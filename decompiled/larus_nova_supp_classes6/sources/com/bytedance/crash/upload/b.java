package com.bytedance.crash.upload;

import android.text.TextUtils;
import com.bytedance.crash.util.p;
import eh4.a;
import eh4.d;
import fh4.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class b {
    public static void a(d r10) {
        JSONObject r4 = ((a) r10).a;
        String r11 = r4.optString("log_type");
        if (TextUtils.isEmpty(r11) == false) goto L5;
        r11 = null;
    L5:
        String r2 = r4.optString("stack");
        String r1 = r4.optString("event_type");
        String r3 = r4.optString("java_data");
        String r5 = r4.optString("stack");
        if (r1.equals("exception") == false) goto L16;
        fh4.f r9 = com.bytedance.crash.monitor.j.c();
        r9.getClass();
        String r0 = r4.optString("message");
        if (TextUtils.isEmpty(r11) == false) goto L10;
        String r6 = "core_exception_monitor";
    L12:
        if (r9.d(r6, r0) == false) goto L14;
        p.e("reportJavaEnsure：isDrop:" + r6 + " " + r0);
        return;
    L14:
        r9.f(new g(r6, r2, null, r4, "exception"));
        return;
    L10:
        r6 = r11;
        goto L12
    L16:
        if (r1.equals("native_exception") == false) goto L28;
        fh4.f r12 = com.bytedance.crash.monitor.j.c();
        r12.getClass();
        if (TextUtils.isEmpty(r11) == false) goto L20;
        String r7 = "core_exception_monitor";
    L21:
        String r13 = r4.optString("message");
        if (r12.d(r7, r13) == false) goto L24;
        p.e("reportNativeEnsure：isDrop:" + r7 + " " + r13);
        return;
    L24:
        r12.f(new g(r7, r3, r5, r4, "native_exception"));
        return;
    L20:
        r7 = r11;
        goto L21
    }
}
