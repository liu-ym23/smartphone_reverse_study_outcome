package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonSyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l8 {
    public static boolean a;
    public static final Map<String, String> b = null;

    static {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("1455_new_no_rebate_channel", "task_130004");
        r0.put("ad_reward_stream", "inspire_task");
        r0.put("ad_reward_link_single", "live_cell");
        r0.put("ad_reward_link_single", "video_head");
        r0.put("ad_reward_link_stream", "live_cell");
        r0.put("ad_reward_link_stream", "video_head");
        b = r0;
    }

    @JvmStatic
    public static final s5 b() {
        Map r0 = com.bytedance.android.livesdk.utils.s0.a;
        String r1 = "ecom_retain_data";
        Intrinsics.checkNotNullParameter("ecom_retain_data", "key");
        Map r2 = com.bytedance.android.livesdk.utils.s0.a;
        if (((HashMap) r2).containsKey("ecom_retain_data") == false) goto L5;
        String r3 = com.bytedance.android.livesdk.utils.s0.a("ecom_retain_data");
    L9:
        if (r3 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == false) goto L22;
        return null;
    L22:
        s5 r5 = (s5) GsonProtectorUtils.fromJson(GsonHelper.get(), r3, s5.class);     // Catch: JsonSyntaxException -> L19
        r5.a = r1;     // Catch: JsonSyntaxException -> L19
        return r5;
    L19:
        e = move-exception;
        ALogger.e("QuitRoomUtil", e);
        throw e;
    L11:
        if (StringsKt.isBlank(r3) == true) goto L14;
        r4 = false;
        goto L15
    L5:
        r1 = "ad_reward_retain_data";
        Intrinsics.checkNotNullParameter("ad_reward_retain_data", "key");
        if (((HashMap) r2).containsKey("ad_reward_retain_data") == false) goto L8;
        r3 = com.bytedance.android.livesdk.utils.s0.a("ad_reward_retain_data");
        goto L9
    L8:
        r1 = null;
        r3 = null;
        goto L9
    }

    @JvmStatic
    public static final boolean a() {
        com.bytedance.android.livesdk.log.filter.o r0 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r3 = "";
        if (r0.getMap().containsKey("enter_from_merge") == false) goto L5;
        String r1 = (String) r0.getMap().get("enter_from_merge");
    L7:
        if (r0.getMap().containsKey("enter_method") == false) goto L9;
        r3 = (String) r0.getMap().get("enter_method");
    L9:
        Map<String, String> r2 = b;
        if (r2 == null) goto L19;
        if (r2.containsKey(r1) == true) goto L14;
    L17:
        return false;
    L14:
        if (StringsKt.equals$default((String) ((LinkedHashMap) r2).get(r1), r3, false, 2, null) == false) goto L17;
        return true;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    L5:
        r1 = "";
        goto L7
    }

    @JvmStatic
    public static final boolean c() {
        s5 r0 = b();
        if (r0 == null) goto L12;
        a = true;
        i6 r1 = r0.b();
        if (r1 == null) goto L13;
        Long r2 = r1.a();
        if (r2 != null) goto L9;
        return false;
    L9:
        if (((int) (r2.longValue() - new Date().getTime())) < 1000) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    L12:
        return false;
    }
}
