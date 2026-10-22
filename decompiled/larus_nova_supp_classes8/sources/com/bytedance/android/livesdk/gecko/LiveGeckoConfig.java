package com.bytedance.android.livesdk.gecko;

import android.app.Application;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.z5;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveGeckoConfig {
    public static final Lazy a = null;
    public static String b;

    static {
        a = LazyKt.lazy(LiveGeckoConfig$geckoConfigGetOpt$2.INSTANCE);
        b = "";
    }

    @JvmStatic
    public static final String b() {
        if (((Boolean) z5.a.getValue()).booleanValue() == false) goto L6;
        return "5fb33cde3ebff01c8433ddc22aac0816";
    L6:
        if (jc1.k.n(IMiddleWareHostContext.class).isBoe() == false) goto L9;
        return "68f927652a5370ec9f4ae1dbaf56fd85";
    L9:
        if (v.a() == false) goto L13;
        return "36723dc3e85a23e701d1697d57de07ed";
    L13:
        return "5fb33cde3ebff01c8433ddc22aac0816";
    }

    @JvmStatic
    public static final String c() {
        if (((Boolean) a.getValue()).booleanValue() == false) goto L18;
        String r0 = b;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L12:
        if (r1 == true) goto L15;
        r0 = null;
    L15:
        if (r0 != null) goto L20;
        String r2 = a();
        b = r2;
        return r2;
    L20:
        return r0;
    L7:
        if (r0.length() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 != true) goto L12;
        r1 = true;
        goto L12
    L9:
        r3 = false;
        goto L10
    L18:
        String r4 = a();
        ALogger.d("LiveGeckoConfig", "geckox save path: " + r4);
        return r4;
    }

    public static String a() {
        Application r0 = jc1.a.b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getFilesDir().getAbsolutePath() + "/offlineX";
    }
}
