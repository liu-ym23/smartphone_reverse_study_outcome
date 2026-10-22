package com.bytedance.apm6.perf.base;

import android.text.TextUtils;
import com.bytedance.apm.b;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.a.e;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CommonDataAssembly {
    public CommonDataAssembly() {
    }

    public static void wrapFilters(e r1, boolean r2) {
        r1.d(PerfFilterManager.getInstance().getPerfFiltersJson(r2));
    }

    public static void wrapPerfException(JSONObject r3, String r4) {
        r3.put("timestamp", System.currentTimeMillis());
        r3.put("crash_time", System.currentTimeMillis());
        r3.put(LocationMonitorConst.IS_MAIN_PROCESS, b.f());
        r3.put("process_name", b.e());
        r3.put(com.bytedance.crash.constants.Constants.EVENT_TYPE, r4);
        r3.put(MemoryInfoSectionEditActivity.KIND_SCENE, ActivityLifeObserver.getInstance().getTopActivityClassName());
    }

    public static void wrapPerfStatus(e r5) {
        String r1 = PerfFilterManager.getInstance().getSceneString();
        JSONObject r2 = r5.e;
        if (r2 != null) goto L14;
        r2 = new JSONObject();
    L14:
        if (TextUtils.isEmpty(r1) == false) goto L8;
        r1 = ActivityLifeObserver.getInstance().getTopActivityClassName();     // Catch: JSONException -> L13
    L8:
        r2.put(MemoryInfoSectionEditActivity.KIND_SCENE, r1);     // Catch: JSONException -> L13
        r2.put("process_name", b.e());     // Catch: JSONException -> L13
        r2.put(LocationMonitorConst.IS_MAIN_PROCESS, b.f());     // Catch: JSONException -> L13
        if (r2.isNull("is_front") == false) goto L11;
        r2.put("is_front", ActivityLifeObserver.getInstance().isForeground());     // Catch: JSONException -> L13
    L11:
        r5.e = r2;     // Catch: JSONException -> L13
        return;
    }
}
