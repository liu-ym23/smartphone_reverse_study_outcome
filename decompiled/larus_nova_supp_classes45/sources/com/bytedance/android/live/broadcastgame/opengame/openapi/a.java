package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.network.AudienceGameNetApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends BaseOpenMethod<Object> {
    public final String h;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.openapi.a$a, reason: collision with other inner class name */
    public static final class C0068a<T> implements Consumer {
        public final /* synthetic */ a a;

        public C0068a(a r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ExtraResponse r4 = (ExtraResponse) r3;
            a r5 = this.a;
            r5.d.m.c = true;
            r5.r(new JSONObject());
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            a r0 = this.a;
            r0.o((Throwable) r2);
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "addToFavorites";
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public void call(Object r4, CallContext r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        Lazy r6 = LiveOpenGameClient.d;
        j(((AudienceGameNetApi) LiveOpenGameClient.a.a().a(AudienceGameNetApi.class)).addToFavorite(this.h).compose(new x10.d(this.d, "/webcast/openapi/user/collect_app/", null)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0068a(this), new b(this)));
    }

    public a(PluginContext r2, String r3, Queue<Long> r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "appId");
        super(r2, r4);
        this.h = r3;
    }
}
