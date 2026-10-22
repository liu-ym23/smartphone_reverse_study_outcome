package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.auth.OpenBaseAuthService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h0 extends BaseOpenMethod<JSONObject> {
    public final String h;

    public static final class a implements com.bytedance.bdp.live.livecontainer.sonicgame.c {
        public final /* synthetic */ h0 a;

        public final void a(JSONObject r3) {
            Intrinsics.checkNotNullParameter("onSettingClick", "status");
            Intrinsics.checkNotNullParameter(r3, "data");
        }

        public a(h0 r1) {
            this.a = r1;
        }

        public final void onFail(String r3) {
            Intrinsics.checkNotNullParameter(r3, "errMsg");
            this.a.o(new Throwable(r3));
        }

        public final void onSuccess(JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "result");
            h0 r0 = this.a;     // Catch: JSONException -> L5
            JSONObject r1 = new JSONObject();     // Catch: JSONException -> L5
            r1.put("authSetting", r4);     // Catch: JSONException -> L5
            Unit r5 = Unit.INSTANCE;     // Catch: JSONException -> L5
            r0.r(r1);     // Catch: JSONException -> L5
            return;
        L5:
            e = move-exception;
            this.a.o(e);
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "openSetting";
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r2, CallContext r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        ((OpenBaseAuthService) this.d.o(OpenBaseAuthService.class)).b(this.h, new a(this));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }

    public h0(PluginContext r2, String r3, Queue<Long> r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "appId");
        super(r2, r4);
        this.h = r3;
    }
}
