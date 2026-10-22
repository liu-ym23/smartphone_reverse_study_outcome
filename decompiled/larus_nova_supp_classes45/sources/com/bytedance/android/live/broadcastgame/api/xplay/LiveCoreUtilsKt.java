package com.bytedance.android.live.broadcastgame.api.xplay;

import android.util.Log;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveCoreUtilsKt {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, LiveCoreUtilsKt$gson$2.INSTANCE);
    }

    public static final void a(d0 r1, i r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$collectSdkParams");
        Intrinsics.checkNotNullParameter(r2, "out");
        d0.a r3 = r1.getBuilder();
        if (r3 == null) goto L6;
        r2.k(Integer.valueOf(r3.getVideoWidth()));
        r2.h(Integer.valueOf(r3.getVideoHeight()));
        r2.j(Integer.valueOf(r3.n()));
        r2.i(Integer.valueOf(r3.u0()));
        r3.D();
        r2.f(null);
        r2.g(Integer.valueOf(r3.n()));
        r2.e(Integer.valueOf(r3.u0()));
        ALogger.i("XplayLiveCoreUtils", "collectSdkParams: " + r2 + ", stack = " + Log.getStackTraceString(new Exception()));
        return;
    }

    public static final void b(d0 r3, i r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$updateSdkParams");
        Intrinsics.checkNotNullParameter(r4, "params");
        JsonObject r0 = new JsonObject();
        Lazy r1 = a;
        r0.add("PushBase", GsonProtectorUtils.toJsonTree((Gson) r1.getValue(), r4));
        GsonProtectorUtils.toJson((Gson) r1.getValue(), r0);
        r3.A();
    }
}
