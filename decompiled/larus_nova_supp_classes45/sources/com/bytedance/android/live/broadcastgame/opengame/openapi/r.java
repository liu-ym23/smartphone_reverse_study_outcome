package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r extends BaseOpenMethod<JSONObject> {
    public final String h;

    public static final class a implements com.bytedance.android.live.profit.scoreboard.f {
        public final /* synthetic */ r a;

        public a(r r1) {
            this.a = r1;
        }

        public final void a(com.bytedance.android.live.profit.scoreboard.b r12) {
            String r0 = GsonProtectorUtils.toJson(GsonHelper.get(), r12);
            if (r0 != null) goto L6;
            r0 = "";
        L6:
            if (r12 != null) goto L8;
            r12 = new com.bytedance.android.live.profit.scoreboard.b(0);
        L8:
            AudienceGameContext.Companion.getClass();
            AudienceGameContext r2 = AudienceGameContext.a.a();
            if (r2 == null) goto L15;
            com.bytedance.live.datacontext.m<Boolean> r3 = r2.getDisableEntrance();
            if (r3 == null) goto L15;
            Boolean r4 = (Boolean) r3.getValue();
            if (r4 == null) goto L15;
            boolean r5 = r4.booleanValue();
        L16:
            this.a.getClass();
            if ((!Intrinsics.areEqual(r12.b(), "0")) == true) goto L19;
        L23:
            boolean r6 = false;
        L25:
            if (r6 == false) goto L28;
            if (r5 == true) goto L28;
            boolean r7 = com.bytedance.android.live.revenue.core.util.h.a;
            com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.scoreboard.h.class).k2(this.a.d.m.i);
            int r8 = 1;
        L29:
            r r9 = this.a;
            JSONObject r11 = new JSONObject(r0);
            this.a.getClass();     // Catch: JSONException -> L36
            if (r8 == 2) goto L33;
            int r13 = (int) (r12.c() - r12.e());     // Catch: JSONException -> L36
        L34:
            r11.put("left_time", r13);     // Catch: JSONException -> L36
            r11.put("total_time", r12.c() - r12.d());     // Catch: JSONException -> L36
            r11.put("type", r8);     // Catch: JSONException -> L36
        L38:
            Unit r14 = Unit.INSTANCE;
            r9.r(r11);
            return;
        L33:
            r13 = 0;
        L36:
            e = move-exception;
            int r1 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.e(this.a.h, new Object[]{"GetCounterRankMethod e = " + e.getMessage()});
        L28:
            r8 = 2;
            goto L29
        L19:
            if (r12.a() != 0) goto L23;
            if ((r12.c() - r12.e()) <= 0) goto L23;
            r6 = true;
        L15:
            r5 = false;
            goto L16
        }

        public final void onFailed(int r4, String r5) {
            Intrinsics.checkNotNullParameter(r5, "errorMsg");
            BaseOpenMethod.p(this.a, r4, r5, null, 12);
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "getCounterRank";
    }

    public r(PluginContext r2, Queue<Long> r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        super(r2, r3);
        this.h = "GetCounterRankMethod";
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r3, CallContext r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        String r5 = r3.optString("counter_id", "0");
        boolean r6 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.scoreboard.h.class).s1(this.d.m.i, r5, new a(this));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }
}
