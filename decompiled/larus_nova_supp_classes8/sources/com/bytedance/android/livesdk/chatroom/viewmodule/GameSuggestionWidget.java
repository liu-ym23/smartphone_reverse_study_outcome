package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.message.model.g5;
import com.bytedance.android.livesdk.message.model.h5;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/GameSuggestionWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lvlc/l;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameSuggestionWidget extends LiveRecyclableWidget implements vlc.l {

    public static final class a {
    }

    static {
    }

    public final String getSpm() {
        return "a100.a100.a209";
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        vlc.d r0 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r0 == null) goto L6;
        r0.removeMessageListener(this);
        return;
    }

    public GameSuggestionWidget() {
    }

    public final void onLoad(Object[] r3) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 != null) goto L5;
        return;
    L5:
        RoomContext r1 = null;
        vlc.d r5 = (vlc.d) r4.get("data_message_manager", null);
        if (r5 == null) goto L8;
        r5.addMessageListener(MessageType.GAME_ROOM_SUGGESTION_MESSAGE.getIntType(), this);
    L8:
        RoomContext r6 = com.bytedance.live.datacontext.d.d(RoomContext.class);
        if ((r6 instanceof RoomContext) == false) goto L13;
        r1 = r6;
    }

    public final void onMessage(tlc.d r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getIntType() == MessageType.GAME_ROOM_SUGGESTION_MESSAGE.getIntType()) goto L6;
        return;
    L6:
        if ((r5 instanceof h5) == false) goto L46;
        h5 r6 = (h5) r5;
        StringBuilder r0 = new StringBuilder("showGameSuggestionMessage, id=");
        h5.a r1 = r6.floatWindow;
        String r2 = null;
        if (r1 == null) goto L10;
        Long r3 = r1.b();
    L11:
        r0.append(r3);
        r0.append(", text=");
        h5.a r4 = r6.floatWindow;
        if (r4 == null) goto L14;
        String r7 = r4.c();
    L15:
        r0.append(r7);
        r0.append(", createTime=");
        h5.a r8 = r6.floatWindow;
        if (r8 == null) goto L18;
        Long r9 = r8.a();
    L19:
        r0.append(r9);
        Logger.d("GameSuggestionWidget", r0.toString());
        Room r10 = (Room) ((Widget) this).dataCenter.get("data_room", null);
        if (r10 == null) goto L22;
        r10.getOwnerUserIdString();
    L22:
        if (r10 == null) goto L24;
        LiveMode r11 = r10.getStreamType();
    L26:
        if (r11 != LiveMode.SCREEN_RECORD) goto L47;
        h5.a r12 = r6.floatWindow;
        if (r12 == null) goto L30;
        String r13 = r12.d();
    L31:
        h5.a r14 = r6.floatWindow;
        if (r14 == null) goto L34;
        String r15 = r14.c();
    L35:
        h5.a r16 = r6.floatWindow;
        if (r16 == null) goto L41;
        Long r17 = r16.b();
        if (r17 == null) goto L41;
        r2 = String.valueOf(r17.longValue());
    L41:
        if (rx1.m.e(((Widget) this).context) == false) goto L48;
        xs2.b.a().post(new g5(r2, r13, r15));
        return;
    L48:
        return;
    L34:
        r15 = null;
        goto L35
    L30:
        r13 = null;
        goto L31
    L47:
        return;
    L24:
        r11 = null;
        goto L26
    L18:
        r9 = null;
        goto L19
    L14:
        r7 = null;
        goto L15
    L10:
        r3 = null;
        goto L11
    }
}
