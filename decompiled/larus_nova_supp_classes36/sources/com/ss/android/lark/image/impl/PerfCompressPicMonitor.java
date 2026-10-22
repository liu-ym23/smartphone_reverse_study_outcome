package com.ss.android.lark.image.impl;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.statistics.Statistics;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class PerfCompressPicMonitor {
    public static void sendCompressPicFailedToTea() {
        Statistics.sendEvent("lark_android_compress_pic", new JSONObject().put("compress_succ", "n"));     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static /* synthetic */ void access$000(Map r0) {
        sendCompressPicSuccToTea(r0);
    }

    private static void sendCompressPicSuccToTea(Map<String, Float> r3) {
        JSONObject r0 = new JSONObject();
        r0.put("compress_succ", "y");     // Catch: JSONException -> L8
        Iterator<Map.Entry<String, Float>> r4 = r3.entrySet().iterator();     // Catch: JSONException -> L8
    L5:
        if (r4.hasNext() == false) goto L10;
        Map.Entry<String, Float> r1 = r4.next();     // Catch: JSONException -> L8
        r0.put(r1.getKey(), r1.getValue());     // Catch: JSONException -> L8
    L10:
        Statistics.sendEvent("lark_android_compress_pic", r0);
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static void reportCompressEvent(final long r2, final String r4, final String r5) {
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new AnonymousClass1(r4, r5, r2));
    }
}
