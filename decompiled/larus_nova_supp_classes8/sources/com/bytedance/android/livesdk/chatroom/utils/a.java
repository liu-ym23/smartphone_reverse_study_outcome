package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.core.activity.ActivityHybridMonitor;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public a() {
    }

    static {
    }

    public static void a(int r8, Integer r9, String r10, String r11) {
        if (ActivityMonitor.a() == false) goto L17;
        JSONObject r3 = new JSONObject();
        r3.put("url", r11);
        r3.put("room_id", r10);
        r3.put("biz_id", r9);
        r3.put("msg", "onFallback");
        com.bytedance.android.livesdk.log.filter.o r12 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if (r12 == null) goto L10;
        Map r13 = r12.getMap();
        if (r13 == null) goto L10;
        String r14 = (String) r13.get("enter_from_merge");
        if (r14 == null) goto L10;
    L12:
        if (x40.e.a(r14) == false) goto L14;
        String r5 = r14;
    L15:
        ActivityMonitor.d("ttlive_activity_downgrade_webView", r8, r3, "", r5, null, 64);
        return;
    L14:
        r5 = "";
    L10:
        r14 = "";
        goto L12
    }

    public static /* synthetic */ void c(int r10, String r11, ActivityHybridMonitor.ContainerType r12, int r13, String r14, String r15) {
        b(r10, r11, r12, "-1", r13, r14, r15, null, 0);
    }

    public static void b(int r15, String r16, ActivityHybridMonitor.ContainerType r17, String r18, int r19, String r20, String r21, String r22, long r23) {
        String r1 = r21;
        String r5 = "";
        if (ActivityMonitor.a() == false) goto L25;
        JSONObject r2 = new JSONObject();
        r2.put("url", r1);
        r2.put("room_id", r20);
        r2.put("biz_id", r19);
        r2.put("msg", r16);
        r2.put("live_activity", r22);
        com.bytedance.android.livesdk.log.filter.o r6 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if (r6 == null) goto L10;
        Map r8 = r6.getMap();
        if (r8 == null) goto L10;
        String r9 = (String) r8.get("enter_method");
        if (r9 == null) goto L10;
    L12:
        if (r6 == null) goto L17;
        Map r7 = r6.getMap();
        if (r7 == null) goto L17;
        String r10 = (String) r7.get("enter_from_merge");
        if (r10 == null) goto L17;
    L18:
        JSONObject r11 = new JSONObject();
        r11.put("status_code", r15);
        if (r17 == null) goto L21;
        String r13 = r17.getType();
    L22:
        r11.put("category_1", r13);
        r11.put("category_2", r18);
        r11.put("enter_method", r9);
        r11.put("enter_from_merge", r10);
        r11.put("short_touch_type", r19);
        ActivityMonitor.c("ttlive_activity_short_touch_container_show", r11, null, r2);
        goto L25
    L21:
        r13 = null;
    L17:
        r10 = "";
    L10:
        r9 = "";
    L25:
        if (ActivityMonitor.a.booleanValue() == false) goto L37;
        HashMap r3 = new HashMap();
        if (r1 != null) goto L29;
        r1 = "";
    L29:
        r3.put("url", r1);
        r3.put("icon_name", String.valueOf(r19));
        r3.put("status_code", String.valueOf(r15));
        r3.put("tti", String.valueOf(r23));
        if (r17 == null) goto L35;
        String r0 = r17.getType();
        if (r0 == null) goto L35;
        r5 = r0;
    L35:
        r3.put("container_type", r5);
        com.bytedance.android.livesdk.log.j0.l().sendLog("short_touch_icon_show", r3, new Object[]{IRoom.class, am2.x.class});
        return;
    }
}
