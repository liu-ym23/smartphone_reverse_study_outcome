package com.ss.android.lark.image.utils;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(d r3) {
        Intrinsics.checkNotNullParameter(r3, "inlineInfo");
        Log.i("ImageMonitor", "reportInlineEvent, inlineInfo=" + r3);
        r3.getClass();
        JSONObject r0 = new JSONObject();
        r0.put("resultCode", r3.a);
        r0.put("errorMsg", r3.b);
        r0.put("latency", r3.c);
        r0.put("size", r3.d);
        r0.put("width", r3.e);
        r0.put("height", r3.f);
        Statistics.sendEvent("inline_preview_decode_dev", r0);
    }
}
