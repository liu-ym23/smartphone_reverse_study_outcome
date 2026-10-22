package com.bytedance.android.live.revenue.common.player.utils;

import d51.c;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LiveSeiUtil {
    public static final Lazy a = null;
    public static final LinkedHashMap<Integer, JSONObject> b = null;
    public static final Lazy c = null;

    static {
        a = LazyKt.lazy(LiveSeiUtil$seiOptimizeEnable$2.INSTANCE);
        c r1 = c.A0;
        r1.getClass();
        b = new LinkedHashMap(((Number) c.i0.getValue(r1, c.a[59])).intValue());
        c = LazyKt.lazy(LiveSeiUtil$harmonySeiFixEnable$2.INSTANCE);
    }

    public static JSONObject a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "rawJson");
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        if (((Boolean) a.getValue()).booleanValue() == false) goto L14;
        JSONObject r1 = b.get(Integer.valueOf(r2.hashCode()));     // Catch: Exception -> L16
        if (r1 != null) goto L18;
        r1 = new JSONObject(r2);     // Catch: Exception -> L16
    L18:
        return r1;
    L14:
        r1 = new JSONObject(r2);     // Catch: Exception -> L16
    L21:
        return new JSONObject();
    L8:
        return new JSONObject();
    L5:
        r0 = false;
        goto L6
    }

    public static boolean b(String r4) {
        if (((Boolean) c.getValue()).booleanValue() == false) goto L10;
        if (r4 == null) goto L6;
        boolean r5 = StringsKt.contains$default(r4, "TTLiveSDK_Harmony", false, 2, null);
    L7:
        if (r5 == false) goto L11;
        return true;
    L11:
        return false;
    L6:
        r5 = false;
        goto L7
    L10:
        return false;
    }
}
