package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.OpenGameApi;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u extends BaseOpenMethod<Object> {
    public final String h;
    public final long i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ u a;

        public a(u r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            BaseResponse r5 = (BaseResponse) r4;
            JSONObject r0 = new JSONObject();
            com.bytedance.android.live.broadcastgame.opengame.network.b0.a r1 = ((com.bytedance.android.live.broadcastgame.opengame.network.b0) r5.data).a();
            if (r1 == null) goto L5;
            String r2 = r1.b();
        L6:
            r0.put("roomID", r2);
            com.bytedance.android.live.broadcastgame.opengame.network.b0.a r6 = ((com.bytedance.android.live.broadcastgame.opengame.network.b0) r5.data).a();
            if (r6 == null) goto L9;
            int r7 = (int) r6.a();
        L10:
            r0.put("liveDuration", r7);
            u r8 = this.a;
            JSONObject r3 = new JSONObject();
            r3.put("roomInfo", r0);
            Unit r9 = Unit.INSTANCE;
            r8.r(r3);
            return;
        L9:
            r7 = 0;
            goto L10
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ u a;

        public b(u r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            u r0 = this.a;
            r0.o((Throwable) r2);
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "getRoomInfo";
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public void call(Object r3, CallContext r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        Lazy r5 = LiveOpenGameClient.d;
        j(((OpenGameApi) LiveOpenGameClient.a.a().a(OpenGameApi.class)).getRoomInfo(this.h, this.i).compose(new x10.c(this.d, "/webcast/openapi/room/info/")).subscribe(new a(this), new b(this)));
    }

    public u(PluginContext r2, String r3, long r4, Queue<Long> r6) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "appId");
        super(r2, r6);
        this.h = r3;
        this.i = r4;
    }
}
