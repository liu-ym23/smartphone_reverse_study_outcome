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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h1 extends BaseOpenMethod<Object> {
    public final g0 h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ h1 a;

        public a(h1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            BaseResponse r3 = (BaseResponse) r2;
            this.a.r(null);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ h1 a;

        public b(h1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            h1 r0 = this.a;
            r0.o((Throwable) r2);
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "unsubscribeAllSpecifiedUserComment";
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public void call(Object r4, CallContext r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        Lazy r6 = LiveOpenGameClient.d;
        AnchorGameNetApi r7 = (AnchorGameNetApi) LiveOpenGameClient.a.a().a(AnchorGameNetApi.class);
        g0 r8 = this.h;
        j(r7.unSubscribeAllSpecifiedUserComment(r8.a, r8.b).compose(new x10.c(this.d, "/webcast/openapi/comment/unsubscribe/spec_user/")).subscribe(new a(this), new b(this)));
    }

    public h1(PluginContext r2, g0 r3, Queue<Long> r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "param");
        super(r2, r4);
        this.h = r3;
    }
}
