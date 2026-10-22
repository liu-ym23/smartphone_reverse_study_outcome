package com.bytedance.android.live.broadcastgame.opengame.cloud;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.utility.SharedPrefHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class CloudSPHelper {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, CloudSPHelper$sidHelper$2.INSTANCE);
    }

    public static String a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "appId");
        String r0 = new JSONObject(((SharedPrefHelper) a.getValue()).j(r3, new JSONObject().toString())).optString("sid");
        ALogger.d("CloudSPHelper_getSid", "appId:" + r3 + ", sid:" + r0);
        return r0;
    }

    public static long b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "appId");
        long r0 = new JSONObject(((SharedPrefHelper) a.getValue()).j(r4, new JSONObject().toString())).optLong("expiredTime", -1);
        ALogger.d("CloudSPHelper_getSidExpiredTime", "appId:" + r4 + ", expiredTime:" + r0);
        return r0;
    }

    public static boolean c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "appId");
        boolean r0 = ((SharedPrefHelper) a.getValue()).a.contains(r3);
        ALogger.d("CloudSPHelper_sidExist", "appId:" + r3 + ", exist:" + r0);
        return r0;
    }
}
