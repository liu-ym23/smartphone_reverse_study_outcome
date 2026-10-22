package com.ss.android.lark.contact.customized.common;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r2, long r3, boolean r5, ErrorResult r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        JSONObject r1 = new JSONObject();
        r1.put("scene", r2);
        r1.put("duration", r3);
        r1.put("is_succeed", r5);
        r1.put("is_cache", r7);
        r1.put("is_first_screen", r8);
        if (r5 == true) goto L11;
        if (r6 == null) goto L11;
        r1.put("err_code", r6.getCode());
        String r4 = r6.getMessage();
        if (r4 != null) goto L10;
        r4 = r6.getDebugMsg();
        if (r4 != null) goto L10;
        r4 = r6.getDisplayMsg();
    L10:
        r1.put("err_msg", r4);
    L11:
        Statistics.sendEvent("flow_doc_dev_biz_comp_perf_event", r1);
    }
}
