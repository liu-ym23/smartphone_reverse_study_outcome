package com.bytedance.android.live.broadcastgame.opengame.cloud;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.user.IUserService;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class CloudLoginService {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(final CloudExecutor r11, final Function1 r12, final Function2 r13) {
        Intrinsics.checkNotNullParameter(r11, "cloudExecutor");
        Intrinsics.checkNotNullParameter(r12, "onSuccess");
        Intrinsics.checkNotNullParameter(r13, "onFail");
        ALogger.i("CLoudLoginService_login", "login start");
        if (k.n(IUserService.class).user().isLogin() == false) goto L5;
        f.d(r11.d(), "https://ma.zijieapi.com", CloudConstant$Method.GET, "/api/apps/v3/login/", MapsKt.mapOf(new Pair[]{TuplesKt.to("X-Tma-Host-Sessionid", e.b), TuplesKt.to("X-Tma-Host-Deviceid", e.a)}), MapsKt.mapOf(TuplesKt.to("appid", r11.c)), new CloudLoginService$login$1(r12, r11, r13), new CloudLoginService$login$2(r13));
        return;
    L5:
        ALogger.i("CLoudLoginService_login", "host not login");
        r13.invoke(CloudResultType$ClientResultType.NotLogin, "not login");
    }
}
