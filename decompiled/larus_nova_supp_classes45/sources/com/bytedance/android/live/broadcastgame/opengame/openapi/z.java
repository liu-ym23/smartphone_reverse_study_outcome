package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.network.AudienceGameNetApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
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
public final class z extends BaseOpenMethod<Object> {
    public final g0 h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ z a;

        public a(z r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            BaseResponse r6 = (BaseResponse) r5;
            z r0 = this.a;
            JSONObject r1 = new JSONObject();
            r1.put("isFavorited", ((com.bytedance.android.live.broadcastgame.opengame.network.r) r6.data).a().b());
            r1.put("lastFavoriteTime", ((com.bytedance.android.live.broadcastgame.opengame.network.r) r6.data).a().a());
            Unit r7 = Unit.INSTANCE;
            r0.r(r1);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ z a;

        public b(z r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            z r0 = this.a;
            r0.o((Throwable) r2);
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "isFavoriteGame";
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public void call(Object r4, CallContext r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        Lazy r6 = LiveOpenGameClient.d;
        AudienceGameNetApi r7 = (AudienceGameNetApi) LiveOpenGameClient.a.a().a(AudienceGameNetApi.class);
        g0 r8 = this.h;
        j(r7.getCollectionStatus(r8.a, r8.b).compose(new x10.c(this.d, "/webcast/openapi/user/collection_status/")).subscribe(new a(this), new b(this)));
    }

    public z(PluginContext r2, g0 r3, Queue<Long> r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "param");
        super(r2, r4);
        this.h = r3;
    }
}
