package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.OpenGameApi;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i extends BaseOpenMethod<JSONObject> {
    public volatile boolean h;
    public final g0 i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            i r0 = this.a;
            JSONObject r1 = new JSONObject();
            r1.put("IsIntermediateIndividualPlayer", ((com.bytedance.android.live.broadcastgame.opengame.network.c) ((ExtraResponse) r4).data).status);
            Unit r5 = Unit.INSTANCE;
            r0.r(r1);
            this.a.h = false;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ i a;

        public b(i r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            i r6 = this.a;
            JSONObject r0 = new JSONObject();
            r0.put("IsIntermediateIndividualPlayer", false);
            Unit r1 = Unit.INSTANCE;
            r6.r(r0);
            this.a.h = false;
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "checkIntermediateIndividualPlayer";
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r5, CallContext r6) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        if (this.h == false) goto L6;
        n(OpenApiErrorInfo.EXCEED_FREQ_LIMIT, null);
        return;
    L6:
        this.h = true;
        Lazy r7 = LiveOpenGameClient.d;
        OpenGameApi r8 = (OpenGameApi) LiveOpenGameClient.a.a().a(OpenGameApi.class);
        g0 r0 = this.i;
        j(r8.checkIntermediateIndividualPlayer(r0.a, r0.b).compose(new x10.d(this.d, "/webcast/openapi/business/individual/intermediate_player/", null)).subscribe(new a(this), new b(this)));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }

    public i(PluginContext r2, g0 r3, Queue<Long> r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "openApi");
        super(r2, r4);
        this.i = r3;
    }
}
