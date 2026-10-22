package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonParseException;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s extends BaseOpenMethod<JSONObject> {

    public static final class a implements com.bytedance.android.live.profit.scoreboard.e {
        public final /* synthetic */ s a;

        public a(s r1) {
            this.a = r1;
        }

        public final void a(com.bytedance.android.live.profit.scoreboard.a r5) {
            Intrinsics.checkNotNullParameter(r5, "config");
            this.a.r(tv5.a.a(GsonHelper.get(), r5));     // Catch: JsonParseException -> L5
            return;
        L5:
            e = move-exception;
            s r0 = this.a;
            String r6 = e.getMessage();
            if (r6 != null) goto L9;
            r6 = "";
        L9:
            BaseOpenMethod.p(r0, -1, r6, null, 8);
        }

        public final void onFailed(int r4, String r5) {
            Intrinsics.checkNotNullParameter(r5, "errorMsg");
            BaseOpenMethod.p(this.a, r4, r5, null, 8);
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "getCounterRuleInfo";
    }

    public s(PluginContext r2, Queue<Long> r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        super(r2, r3);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r4, CallContext r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        boolean r6 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.profit.scoreboard.h r7 = com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.scoreboard.h.class);
        com.bytedance.android.live.broadcastgame.opengame.t r8 = this.d.m;
        r7.H5(r8.i, r8.a, new a(this));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }
}
