package com.bytedance.android.annie.monitor.common.timing;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final List<String> d = null;
    public final Map<String, Long> a;
    public final Map<String, Object> b;
    public String c;

    /* JADX INFO: renamed from: com.bytedance.android.annie.monitor.common.timing.a$a, reason: collision with other inner class name */
    public static final class C0071a {
        public static a a(JSONObject r12, a r13) {
            Intrinsics.checkNotNullParameter(r12, "data");
            LinkedHashMap r0 = new LinkedHashMap();
            LinkedHashMap r1 = new LinkedHashMap();
            Iterator<String> r10 = r12.keys();
            String r11 = null;
            if (r10 != null) goto L5;
        L18:
            String r14 = r12.optString("ttwebview_new_metrics");
            if (r14 == null) goto L22;
            r11 = r14;
        L22:
            if ((!r0.isEmpty()) == false) goto L24;
        L25:
            if (r13 != null) goto L27;
            r13 = new a();
        L27:
            r13.a.putAll(r0);
            r13.b.putAll(r1);
        L28:
            if (r11 == null) goto L32;
            if (r13 == null) goto L32;
            r13.c = r11;
        L32:
            return r13;
        L24:
            if ((!r1.isEmpty()) == false) goto L28;
        L5:
            if (r10.hasNext() == false) goto L18;
            String r15 = r10.next();
            if (StringsKt.startsWith$default(r15, "tick_", false, 2, null) == false) goto L12;
            long r16 = r12.optLong(r15);
            if (r16 <= 0) goto L12;
            r0.put(r15, Long.valueOf(r16));
        L12:
            if (a.d.contains(r15) == true) goto L15;
            if (StringsKt.startsWith$default(r15, "flag_", false, 2, null) == false) goto L5;
        L15:
            Object r17 = r12.opt(r15);
            if (r17 == null) goto L5;
            r1.put(r15, r17);
            goto L5
        }
    }

    static {
        d = CollectionsKt.listOf(new String[]{"loadso", "webview_count_on_load", "webview_count_on_get", "net_error_code", "render_process_status_on_load_url", "render_process_status_on_get", "dur_render_block", "render_block_reason"});
    }

    public a() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
    }
}
