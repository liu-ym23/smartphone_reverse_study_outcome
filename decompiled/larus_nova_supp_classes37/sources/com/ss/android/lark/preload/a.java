package com.ss.android.lark.preload;

import android.os.SystemClock;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.preload.moment.PreloadMoment;
import com.ss.android.lark.statistics.Statistics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final c1c.a a;

    /* JADX INFO: renamed from: com.ss.android.lark.preload.a$a, reason: collision with other inner class name */
    public static class C0105a {
        public static final a a = null;

        static {
            a = new a();
        }
    }

    public a() {
        this.a = new c1c.a();
    }

    public static void a(a r9, d1c.a r10, PreloadMoment r11) {
        r9.getClass();
        StringBuilder r12 = new StringBuilder("finishLoad  TaskName = Docs_preload_task, moment = ");
        r10.getClass();
        r12.append(r11.name());
        Log.i("PreloadEngine", r12.toString());
        PreloadTarget r13 = PreloadTarget.DOC;
        b.a r1 = b.a.get(r13);     // Catch: Exception -> L13
        if (r1 == null) goto L18;
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L13
        r2.put("key_id", null);     // Catch: Exception -> L13
        r2.put("preload_timing", r11);     // Catch: Exception -> L13
        r2.put("business_type", r13);     // Catch: Exception -> L13
        long r3 = SystemClock.uptimeMillis();     // Catch: Exception -> L13
        r1.a = r3;     // Catch: Exception -> L13
        long r5 = r1.b;     // Catch: Exception -> L13
        if (r5 > 0) goto L9;
        r2.put("cost_time_extra", -1);     // Catch: Exception -> L13
    L11:
        Statistics.sendEvent("lark_preload_finish_preload_dev", r2);     // Catch: Exception -> L13
        Log.i("PreloadEngine", "  event: lark_preload_finish_preload_dev, param: " + r2);     // Catch: Exception -> L13
        return;
    L9:
        r2.put("cost_time_extra", r3 - r5);     // Catch: Exception -> L13
        goto L11
    L18:
        return;
    L13:
        e = move-exception;
        Log.e(e.getMessage());
    }
}
