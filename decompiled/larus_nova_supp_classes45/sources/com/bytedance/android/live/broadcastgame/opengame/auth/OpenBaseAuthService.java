package com.bytedance.android.live.broadcastgame.opengame.auth;

import com.bytedance.android.live.broadcastgame.opengame.openapi.v;
import com.bytedance.android.live.broadcastgame.opengame.openapi.x;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.bdp.live.livecontainer.sonicgame.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import y10.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/auth/OpenBaseAuthService;", "Ly10/a;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class OpenBaseAuthService implements a {
    @Override // y10.a
    public final void g() {
    }

    public OpenBaseAuthService(PluginContext r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
    }

    public void a(String r2, v.a r3) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter("feature not support", "errMsg");
    }

    public void b(String r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "callback");
        r3.onFail("feature not support");
    }

    public void c(String r2, List r3, JSONObject r4, x r5) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "requestList");
        Intrinsics.checkNotNullParameter(r4, "extra");
        Intrinsics.checkNotNullParameter(r5, "callback");
        r5.a();
    }
}
