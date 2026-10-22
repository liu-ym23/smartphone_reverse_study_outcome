package com.bytedance.android.live.impl.logfilter;

import am2.x;
import android.text.TextUtils;
import com.bytedance.android.live.feature.config.LivePostClientSequenceConfig;
import com.bytedance.android.live.impl.utils.LimitSizeQueue;
import com.bytedance.android.livesdk.log.j0;
import j40.w2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class SkipSequenceHelper {
    public static final aa0.b a = null;
    public static final LimitSizeQueue<JSONObject> b = null;
    public static final Map<String, Long> c = null;
    public static final long d = 0;
    public static final Set<Pair<Long, Long>> e = null;
    public static int f;
    public static final Map<String, String> g = null;

    static {
        aa0.b r0 = w2.a.getValue();
        a = r0;
        b = new LimitSizeQueue(r0.c());
        c = new LinkedHashMap();
        d = r0.d();
        e = new LinkedHashSet();
        g = MapsKt.mapOf(new Pair[]{TuplesKt.to("gid", "room_id"), TuplesKt.to("aid", "anchor_id"), TuplesKt.to("live_time_gap", "live_time_gap"), TuplesKt.to("live_duration", "watch_dur"), TuplesKt.to("live_window_stay_duration", "preview_watch_dur"), TuplesKt.to("live_show_time", "show_ts")});
    }

    public static String b() {
        final JSONArray r0 = new JSONArray();
        Iterator<JSONObject> r1 = b.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        r0.put(r1.next());
        goto L4
    L7:
        if (a.b() == false) goto L21;
        int r2 = r0.length();
        f++;
        j0.l().sendLog("livesdk_skip_sequence_report", MapsKt.mapOf(new Pair[]{TuplesKt.to("sequence_count", String.valueOf(r2)), TuplesKt.to("request_count", String.valueOf(f))}), new Object[]{x.class});
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L21;
        JSONObject r4 = r0.optJSONObject(r3);
        Pair<Long, Long> r5 = TuplesKt.to(Long.valueOf(r4.optLong("gid", 0)), Long.valueOf(r4.optLong("show_ts", 0)));
        if (e.contains(r5) == true) goto L20;
        HashMap r11 = new HashMap();
        Iterator<String> r12 = g.keySet().iterator();
    L15:
        if (r12.hasNext() == false) goto L19;
        String r13 = r12.next();
        Object r14 = r4.opt(r13);
        if (r14 == null) goto L15;
        String r15 = (String) r11.put("skip_" + r13, r14.toString());
        goto L15
    L19:
        Set<Pair<Long, Long>> r6 = e;
        r11.put("room_order", String.valueOf(r6.size()));
        r11.put("sequence_count", String.valueOf(r2));
        r11.put("request_count", String.valueOf(f));
        r6.add(r5);
        j0.l().sendLog("livesdk_skip_sequence_report", r11, new Object[]{x.class});
    L20:
        r3 = r3 + 1;
    L21:
        final String r7 = r0.toString();
        boolean r8 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.d("LFM-SkipSequence", new SkipSequenceHelper$getSequenceJsonString$1(r7));
        com.bytedance.android.live.impl.utils.a.d("LFM-SkipSequence", new SkipSequenceHelper$getSequenceJsonString$2(r0));
        com.bytedance.android.live.impl.utils.a.b("LFM-SkipSequence", new SkipSequenceHelper$getSequenceJsonString$3(r7), null);
        return r7;
    }

    public static String a(String r1) {
        LivePostClientSequenceConfig r0 = RealtimeSequenceFilter.a;
        String r2 = g.get(r1);
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        return RealtimeSequenceFilter.b(r2);
    }

    public static boolean c(JSONObject r2) {
        String r0 = r2.optString("entrance_room_id");
        LivePostClientSequenceConfig r1 = RealtimeSequenceFilter.a;
        final boolean r3 = TextUtils.equals(r0, r2.optString(RealtimeSequenceFilter.b("room_id")));
        boolean r4 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.a("LFM-SkipSequence", new SkipSequenceHelper$isEntranceRoom$1(r3));
        return r3;
    }
}
