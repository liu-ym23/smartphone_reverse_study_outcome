package ita;

import com.bytedance.applog.log.m;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.common.applog.q;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class e {
    public static void b(JSONObject r5) {
        if (m.b() == true) goto L9;
        long r3 = r5.optLong("event_id", 0);
        if (r3 > 0) goto L7;
        return;
    L7:
        m.c("event_receive", new b(r5, r3));
        return;
    }

    public static void c(JSONObject r5) {
        if (m.b() == true) goto L9;
        long r3 = r5.optLong("event_id", 0);
        if (r3 > 0) goto L7;
        return;
    L7:
        m.c("event_receive", new a(r5, r3));
        return;
    }

    public static void d(q r4, boolean r5) {
        if (m.b() == false) goto L6;
        return;
    L6:
        if (r4 == null) goto L10;
        long r2 = r4.a;
        if (r2 <= 0) goto L10;
    L12:
        if (r2 > 0) goto L14;
        return;
    L14:
        m.c("event_upload_eid", new c(r2, r5));
        return;
    L10:
        r2 = 0;
        goto L12
    }

    public static void e(JSONObject r2, boolean r3) {
        if (m.b() == false) goto L5;
        return;
    L5:
        JSONArray r0 = new JSONArray();
        a(r2, EventVerify.TYPE_LAUNCH, r0);
        a(r2, EventVerify.TYPE_TERMINATE, r0);
        a(r2, EventVerify.TYPE_LOG_DATA, r0);
        a(r2, EventVerify.TYPE_EVENT_V1, r0);
        a(r2, EventVerify.TYPE_EVENT_V3, r0);
        if (r0.length() != 0) goto L8;
        return;
    L8:
        m.c("event_upload_eid", new d(r0, r3));
    }

    public static void a(JSONObject r5, String r6, JSONArray r7) {
        JSONArray r8 = r5.optJSONArray(r6);
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.length() <= 0) goto L20;
        int r9 = 0;
    L8:
        if (r9 >= r8.length()) goto L21;
        JSONObject r0 = r8.optJSONObject(r9);
        if (r0 == null) goto L14;
        long r1 = r0.optLong("event_id", 0);
        if (r1 <= 0) goto L14;
        r7.put(r1);
    L14:
        r9 = r9 + 1;
        goto L8
    L21:
        return;
    }
}
