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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z0 extends f<JSONObject> {
    public final g0 j;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ z0 a;

        public a(z0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            BaseResponse r3 = (BaseResponse) r2;
            this.a.r(null);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ z0 a;

        public b(z0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            z0 r0 = this.a;
            r0.o((Throwable) r2);
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "showAllAudienceCornerMark";
    }

    public void call(JSONObject r4, CallContext r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        Lazy r6 = LiveOpenGameClient.d;
        AnchorGameNetApi r7 = (AnchorGameNetApi) LiveOpenGameClient.a.a().a(AnchorGameNetApi.class);
        g0 r8 = this.j;
        j(r7.showAllAudienceCornerMark(r8.a, r8.b).compose(new x10.c(this.d, "/webcast/openapi/corner_mark/reach/all/")).subscribe(new a(this), new b(this)));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(Object r1, CallContext r2) {
        call((JSONObject) r1, r2);
    }

    public z0(PluginContext r8, g0 r9, Queue<Long> r11) {
        Intrinsics.checkNotNullParameter(r8, "pluginContext");
        Intrinsics.checkNotNullParameter(r9, "param");
        super(r8, r9.a, r9.b, r11);
        this.j = r9;
    }
}
