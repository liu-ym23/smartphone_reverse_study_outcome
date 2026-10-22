package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.sonicgame.SonicGamePlugin;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class GetScreenTypeMethod extends BaseOpenMethod<JSONObject> {
    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "getScreenType";
    }

    public GetScreenTypeMethod(PluginContext r2, Queue<Long> r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        super(r2, r3);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r3, final CallContext r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        com.bytedance.android.live.broadcastgame.opengame.runtime.k r5 = this.d.k();
        if ((r5 instanceof SonicGamePlugin) == true) goto L5;
        r5 = null;
    L5:
        SonicGamePlugin r6 = (SonicGamePlugin) r5;
        if (r6 == null) goto L8;
        r6.y(new GetScreenTypeMethod$call$$inlined$apply$lambda$1(this, r4));
        return;
    L8:
        n(OpenApiErrorInfo.INTERNAL_ERROR, null);
        Unit r7 = Unit.INSTANCE;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }
}
