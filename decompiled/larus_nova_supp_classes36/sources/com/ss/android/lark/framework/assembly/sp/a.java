package com.ss.android.lark.framework.assembly.sp;

import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.config.d;
import com.ss.android.lark.log.Log;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements com.ss.android.lark.storage.monitor.a {
    public a() {
    }

    public final void sendEvent(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        d.a r0 = d.a();     // Catch: JSONException -> L5
        r0.a = r2;     // Catch: JSONException -> L5
        r0.d = new JSONObject(r3);     // Catch: JSONException -> L5
        ApmAgent.monitorEvent(new d(r0));     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        Log.e("InitUniStoreTask", "file storage event report exception: " + e.getMessage());
    }
}
