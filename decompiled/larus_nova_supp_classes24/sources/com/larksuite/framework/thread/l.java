package com.larksuite.framework.thread;

import com.ss.android.lark.log.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class l {
    public static JSONObject a(String r2, String r3, long r4, long r6, long r8, long r10) {
        JSONObject r0 = new JSONObject();
        r0.put("taskname", r2);     // Catch: Exception -> L13
        r0.put("poolname", r3);     // Catch: Exception -> L13
        r0.put("run_time", r6);     // Catch: Exception -> L13
        r0.put("maxruntime", r10);     // Catch: Exception -> L13
        if (r6 <= r10) goto L7;
        r0.put("overruntaskname", r2);     // Catch: Exception -> L13
    L7:
        if (r8 <= 0) goto L11;
        r0.put("poolqueuewaittime", r4);     // Catch: Exception -> L13
        r0.put("maxdispatchtime", r8);     // Catch: Exception -> L13
        if (r4 <= r8) goto L11;
        r0.put("overwaittaskname", r2);     // Catch: Exception -> L13
    L11:
        r0.put("appbacktask", CoreThreadPool.sAppFront);     // Catch: Exception -> L13
    L14:
        return r0;
    L13:
        Log.e("CoreTaskMonitor", "genTaskEvent gen json failed");
        goto L14
    }
}
