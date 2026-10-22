package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.network.AnchorGameNetApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d1 extends f<JSONObject> {
    public final g0 j;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ d1 a;

        public a(d1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            BaseResponse r3 = (BaseResponse) r2;
            this.a.r(null);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ d1 a;

        public b(d1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            d1 r0 = this.a;
            r0.o((Throwable) r2);
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "subscribeSpecifiedContentComment";
    }

    public void call(JSONObject r5, CallContext r6) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        JSONArray r7 = r5.optJSONArray("keyWordList");
        if (r7 != null) goto L5;
    L9:
        n(OpenApiErrorInfo.INCORRECT_PARAMS, null);
        return;
    L5:
        if (r7.length() == 0) goto L9;
        Lazy r8 = LiveOpenGameClient.d;
        AnchorGameNetApi r9 = (AnchorGameNetApi) LiveOpenGameClient.a.a().a(AnchorGameNetApi.class);
        g0 r0 = this.j;
        j(r9.subscribeSpecifiedContentComment(r0.a, r0.b, r7.toString()).compose(new x10.c(this.d, "/webcast/openapi/comment/subscribe/keyword/")).subscribe(new a(this), new b(this)));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(Object r1, CallContext r2) {
        call((JSONObject) r1, r2);
    }

    public d1(PluginContext r8, g0 r9, Queue<Long> r11) {
        Intrinsics.checkNotNullParameter(r8, "pluginContext");
        Intrinsics.checkNotNullParameter(r9, "param");
        super(r8, r9.a, r9.b, r11);
        this.j = r9;
    }
}
