package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.Map;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q extends BaseOpenMethod<Object> {
    public final com.bytedance.android.live.broadcastgame.opengame.message.g h;

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "getSelfCommentCountDuringPluginRunning";
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public void call(Object r3, CallContext r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        String r5 = (String) ((Map) com.bytedance.android.livesdk.sharedpref.b.F2.getValue()).get(String.valueOf(this.h.f));
        if (r5 != null) goto L10;
    L8:
        JSONObject r6 = new JSONObject();
        r6.put("commentCount", 0);
        Unit r7 = Unit.INSTANCE;
        r(r6);
        return;
    L10:
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L6
        int r8 = LiveSeiUtil.c(r5).optInt("count", 0);     // Catch: Exception -> L6
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L6
        r1.put("commentCount", r8);     // Catch: Exception -> L6
        Unit r9 = Unit.INSTANCE;     // Catch: Exception -> L6
        r(r1);     // Catch: Exception -> L6
        Unit r11 = Unit.INSTANCE;     // Catch: Exception -> L6
    L7:
        if (r11 == null) goto L8;
        return;
    L6:
        r11 = null;
        goto L7
    }

    public q(PluginContext r2, com.bytedance.android.live.broadcastgame.opengame.message.g r3, Queue<Long> r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "messageChannel");
        super(r2, r4);
        this.h = r3;
    }
}
