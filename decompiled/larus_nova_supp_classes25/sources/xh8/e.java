package xh8;

import com.bytedance.apm.ApmAgent;
import com.facebook.common.statfs.StatFsHelper;
import com.larus.utils.logger.FLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static void a(Throwable r4, String r5) {
        StatFsHelper r0 = StatFsHelper.getInstance();
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L5
        r1.put("exp_type", r4.getClass().getSimpleName());     // Catch: JSONException -> L5
        r1.put("exp_msg", r4.getMessage());     // Catch: JSONException -> L5
        r1.put("exp_method", r5);     // Catch: JSONException -> L5
        JSONObject r6 = new JSONObject();     // Catch: JSONException -> L5
        r6.put("avl_internal_space", r0.getAvailableStorageSpace(StatFsHelper.StorageType.INTERNAL));     // Catch: JSONException -> L5
        r6.put("avl_external_space", r0.getAvailableStorageSpace(StatFsHelper.StorageType.EXTERNAL));     // Catch: JSONException -> L5
        ApmAgent.monitorEvent("flow_sqlite_monitor", r1, r6, null);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        FLogger.a.e("FlowSQLiteMonitor", "monitor err", e);
    }
}
