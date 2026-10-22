package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.message.model.ch;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends BaseAnchorMessageReceiver<a> {
    @Override // com.bytedance.android.live.broadcastgame.opengame.message.BaseAnchorMessageReceiver
    public final int b() {
        return MessageType.OPEN_GAME_ANCHOR_MESSAGE.getIntType();
    }

    public b(vlc.d r2) {
        Intrinsics.checkNotNullParameter(r2, "messageManager");
        super(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.message.BaseAnchorMessageReceiver
    public final Long c(tlc.d r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        if ((r3 instanceof ch) == false) goto L9;
        String r4 = ((ch) r3).extra;
        if (r4 == null) goto L9;
        Intrinsics.checkNotNullParameter(r4, "$this$getTimeStamp");
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L11
        return Long.valueOf(LiveSeiUtil.c(r4).optLong("time_stamp"));
    L9:
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.message.BaseAnchorMessageReceiver
    public final boolean d(tlc.d r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        if ((r5 instanceof ch) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ch) r5).sendType != 2) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.message.BaseAnchorMessageReceiver
    public final a e(tlc.d r17) {
        Intrinsics.checkNotNullParameter(r17, "message");
        if ((r17 instanceof ch) == false) goto L8;
        String r1 = ((ch) r17).extra;
        if (r1 == null) goto L8;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L10
        JSONObject r2 = LiveSeiUtil.c(r1);     // Catch: Exception -> L10
        return new a(r2.optString(OpenPlatformBaseDebugger.APP_ID, ""), r2.optLong("room_id", 0), r2.optLong("seq", 0), r2.optLong("conn_id", 0), ((ch) r17).data, ((ch) r17).sendType, "");
    L8:
        return null;
    }
}
