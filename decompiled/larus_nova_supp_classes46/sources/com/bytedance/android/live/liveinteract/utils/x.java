package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.core.log.ALogger;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x {
    public static final Map<Integer, String> a = null;

    static {
        a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(9, "bgm"), TuplesKt.to(8, "ksong"), TuplesKt.to(10, "ktv"), TuplesKt.to(Integer.MAX_VALUE, "order_by_user"), TuplesKt.to(11, "rechargeable_normal"), TuplesKt.to(6, "sing_challenge"), TuplesKt.to(5, "boom"), TuplesKt.to(7, "grouppk"), TuplesKt.to(16, "room_grouppk"), TuplesKt.to(21, "music"), TuplesKt.to(17, "self_discipline"), TuplesKt.to(13, "enlarge"), TuplesKt.to(23, "pk_chorus"), TuplesKt.to(19, "request_song"), TuplesKt.to(34, "guest_starwish"), TuplesKt.to(31, "danmu"), TuplesKt.to(39, "chorus_concert"), TuplesKt.to(38, "zhuzhu"), TuplesKt.to(42, "interact_acting")});
    }

    public static final void a(JSONObject r1, String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$set");
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        r1.put(r2, r3);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        ALogger.e("InteractLogUtils", e);
    }
}
