package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.service.CloudGameService;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.IGameCPCloudGameService;
import com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.LiveCloudGameCloseStatus;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j extends BaseOpenMethod<JSONObject> {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "closeCloudGame";
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r5, CallContext r6) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        m10.a.a("CloseCloudGameMethod", "Cloud game closed.");
        CloudGameService r0 = (CloudGameService) this.d.o(CloudGameService.class);
        if (com.bytedance.android.livesdk.utils.s.a(r0.d.getContext()) == true) goto L5;
        m10.a.a("CloudGameService", "closeCloudGame isAppBackground");
        r0.c.postValue(com.bytedance.android.live.broadcastgame.opengame.service.c.a);
    L8:
        m10.a.a("CloseCloudGameMethod", "Cloud game closed.");
        return;
    L5:
        IGameCPCloudGameService r1 = jc1.k.n(IHostGameCP.class).getCloudGameService();
        if (r1 == null) goto L8;
        r1.closeGame(r0.a, "developer_close", LiveCloudGameCloseStatus.FORCE_STOP.getStatus());
        goto L8
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }

    public j(PluginContext r2, g0 r3, Queue<Long> r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "openApi");
        super(r2, r4);
    }
}
