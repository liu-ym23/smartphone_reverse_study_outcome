package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.panel.PanelType;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.sonicgame.SonicGamePlugin;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class SwitchScreenMethod extends BaseOpenMethod<JSONObject> {
    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "switchScreen";
    }

    public SwitchScreenMethod(PluginContext r2, Queue<Long> r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        super(r2, r3);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r4, final CallContext r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        final PanelType r6 = PanelType.Companion.getType(r4.optString("screenType"));
        if (r6 != null) goto L6;
        n(OpenApiErrorInfo.INCORRECT_PARAMS, null);
        return;
    L6:
        com.bytedance.android.live.broadcastgame.opengame.runtime.k r1 = this.d.k();
        if ((r1 instanceof SonicGamePlugin) == true) goto L9;
        r1 = null;
    L9:
        SonicGamePlugin r2 = (SonicGamePlugin) r1;
        if (r2 == null) goto L12;
        r2.G(r6, new SwitchScreenMethod$call$$inlined$apply$lambda$1(this, r6, r5), new SwitchScreenMethod$call$$inlined$apply$lambda$2(this, r6, r5));
        return;
    L12:
        n(OpenApiErrorInfo.INTERNAL_ERROR, null);
        Unit r7 = Unit.INSTANCE;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }
}
