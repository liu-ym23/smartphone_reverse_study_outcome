package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.auth.OpenBaseAuthService;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.OpenGameApi;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w extends BaseOpenMethod<JSONObject> {
    public final String h;
    public final long i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ w a;
        public final /* synthetic */ OpenBaseAuthService b;

        public b(w r1, OpenBaseAuthService r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            ExtraResponse r9 = (ExtraResponse) r8;
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("GetUserInfoV2Method", new Object[]{"on request success, user info: " + ((com.bytedance.android.live.broadcastgame.opengame.network.d0) r9.data).a()});
            String r1 = ((com.bytedance.android.live.broadcastgame.opengame.network.d0) r9.data).a().a();
            String r2 = ((com.bytedance.android.live.broadcastgame.opengame.network.d0) r9.data).a().b();
            ArrayList r3 = new ArrayList();
            r3.add("scope.userInfo");
            JSONObject r4 = new JSONObject().put("nickName", r2).put("avatarUrl", r1);
            OpenBaseAuthService r5 = this.b;
            this.a.getClass();
            r5.c(this.a.h, r3, r4, new x(this, r2, r1, r9));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ w a;

        public c(w r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.e("GetUserInfoV2Method", new Object[]{"on request fail, error: ", r5});
            this.a.o(r5);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "getUserInfoV2";
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r5, CallContext r6) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        int r7 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("GetUserInfoV2Method", new Object[]{"on call, params: " + r5});
        OpenBaseAuthService r8 = (OpenBaseAuthService) this.d.o(OpenBaseAuthService.class);
        Lazy r9 = LiveOpenGameClient.d;
        j(((OpenGameApi) LiveOpenGameClient.a.a().a(OpenGameApi.class)).getUserInfoV2(this.h, this.i).compose(new x10.d(this.d, "/webcast/openapi/user/unencrypted_info/mine", null)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r8), new c(this)));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }

    public w(PluginContext r2, String r3, long r4, Queue<Long> r6) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "appId");
        super(r2, r6);
        this.h = r3;
        this.i = r4;
    }
}
