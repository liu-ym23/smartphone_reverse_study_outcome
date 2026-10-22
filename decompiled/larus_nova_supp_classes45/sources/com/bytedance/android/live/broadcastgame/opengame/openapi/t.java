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
public final class t extends f<Object> {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ t a;

        public a(t r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.broadcastgame.opengame.network.c0.a r6 = ((com.bytedance.android.live.broadcastgame.opengame.network.c0) ((BaseResponse) r5).data).a();
            JSONObject r0 = new JSONObject();
            String r1 = null;
            if (r6 == null) goto L5;
            String r2 = r6.a();
        L6:
            r0.put("openUID", r2);
            if (r6 == null) goto L9;
            String r3 = r6.c();
        L10:
            r0.put("secAvatarURL", r3);
            if (r6 == null) goto L13;
            String r4 = r6.d();
        L14:
            r0.put("secNickname", r4);
            if (r6 == null) goto L17;
            r1 = r6.b();
        L17:
            r0.put("role", r1);
            t r7 = this.a;
            JSONObject r8 = new JSONObject();
            r8.put("userInfo", r0);
            Unit r9 = Unit.INSTANCE;
            r7.r(r8);
            return;
        L13:
            r4 = null;
            goto L14
        L9:
            r3 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ t a;

        public b(t r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            t r0 = this.a;
            r0.o((Throwable) r2);
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "getUserInfo";
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public void call(Object r3, CallContext r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        Lazy r5 = LiveOpenGameClient.d;
        j(((OpenGameApi) LiveOpenGameClient.a.a().a(OpenGameApi.class)).getCurrentUserInfo(this.h, this.i).compose(new x10.c(this.d, "/webcast/openapi/user/info/mine/")).subscribe(new a(this), new b(this)));
    }

    public t(PluginContext r2, String r3, long r4, Queue<Long> r6) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "appId");
        super(r2, r3, r4, r6);
    }
}
