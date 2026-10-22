package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/AnchorGameStateWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lvlc/l;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorGameStateWidget extends LiveRecyclableWidget implements vlc.l {
    public vlc.d a;

    public final String getSpm() {
        return "a100.a100.a164";
    }

    public final void onClear() {
        super.onClear();
        this.a = null;
    }

    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        vlc.d r0 = this.a;
        if (r0 == null) goto L6;
        r0.removeMessageListener(MessageType.ANCHOR_GAME_STATE_MESSAGE.getIntType(), this);
        return;
    }

    public AnchorGameStateWidget() {
    }

    public final void onInit(Object[] r3) {
        this.a = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
    }

    public final void onLoad(Object[] r2) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        vlc.d r3 = this.a;
        if (r3 == null) goto L6;
        r3.addMessageListener(MessageType.ANCHOR_GAME_STATE_MESSAGE.getIntType(), this);
        return;
    }

    public final void onMessage(tlc.d r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        if (r6.getIntType() != MessageType.ANCHOR_GAME_STATE_MESSAGE.getIntType()) goto L30;
        com.bytedance.android.livesdk.message.model.p r7 = (com.bytedance.android.livesdk.message.model.p) r6;
        boolean r2 = true;
        if (r7.getGameStatus() != 1) goto L7;
        boolean r1 = true;
    L28:
    L17:
        e = move-exception;
        ALogger.d("AnchorGameStateWidget", e.getMessage());
    L19:
        ALogger.d("AnchorGameStateWidget", "设置游戏状态为" + r1);
        InteractGameContext r8 = InteractGameContext.Companion.getContext();
        if (r8 == null) goto L24;
        com.bytedance.live.datacontext.m r9 = r8.isPlayingGame();
        if (r9 == null) goto L24;
        r9.setValue(Boolean.valueOf(r1));
    L24:
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 == null) goto L31;
        r10.put("cmd_update_mini_game_conflict", Boolean.valueOf(r1));
        return;
    L31:
        return;
    L9:
        if (r7.getExtra() == null) goto L19;
        int r11 = new JSONObject(r7.getExtra()).optInt("game_kind", 0);     // Catch: Exception -> L17
        int r4 = com.bytedance.android.live.broadcastgame.api.interactgame.j.a;     // Catch: Exception -> L17
        int r5 = com.bytedance.android.live.broadcastgame.api.interactgame.k.a;     // Catch: Exception -> L17
        if (r11 != 6) goto L14;
        r2 = false;
    L14:
        if (r2 == true) goto L19;
        ALogger.d("AnchorGameStateWidget", "不设置游戏状态");     // Catch: Exception -> L17
        return;
    L7:
        r1 = false;
        goto L28
    }
}
