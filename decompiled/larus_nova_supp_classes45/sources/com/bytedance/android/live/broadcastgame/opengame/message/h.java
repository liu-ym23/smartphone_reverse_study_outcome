package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.message.model.dh;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements com.bytedance.android.live.broadcastgame.c0<f>, vlc.l {
    public com.bytedance.android.live.broadcastgame.b0 a;
    public final vlc.d b;

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void release() {
        this.b.removeMessageListener(this);
    }

    public h(vlc.d r2) {
        Intrinsics.checkNotNullParameter(r2, "messageManager");
        this.b = r2;
    }

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void a(com.bytedance.android.live.broadcastgame.b0 r2) {
        Intrinsics.checkNotNullParameter(r2, "queue");
        this.a = r2;
        this.b.addMessageListener(MessageType.OPEN_GAME_AUDIENCE_MESSAGE.getIntType(), this);
    }

    public final void onMessage(tlc.d r11) {
        Intrinsics.checkNotNullParameter(r11, "message");
        if ((r11 instanceof dh) == false) goto L13;
        String r0 = ((dh) r11).extra;
        if (r0 == null) goto L14;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L10
        JSONObject r1 = LiveSeiUtil.c(r0);     // Catch: Exception -> L10
        String r5 = JSONObjectProtectorUtils.getString(r1, OpenPlatformBaseDebugger.APP_ID);     // Catch: Exception -> L10
        long r3 = JSONObjectProtectorUtils.getLong(r1, "room_id");     // Catch: Exception -> L10
        long r6 = JSONObjectProtectorUtils.getLong(r1, "conn_id");     // Catch: Exception -> L10
        com.bytedance.android.live.broadcastgame.b0 r2 = this.a;     // Catch: Exception -> L10
        if (r2 == null) goto L15;
        r2.insert(new f(r3, r5, r6, ((dh) r11).data));     // Catch: Exception -> L10
        Unit r12 = Unit.INSTANCE;     // Catch: Exception -> L10
        return;
    L15:
        return;
    L16:
        return;
    L14:
        return;
    }
}
