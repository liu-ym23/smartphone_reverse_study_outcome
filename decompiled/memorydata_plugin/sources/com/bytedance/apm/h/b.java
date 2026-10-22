package com.bytedance.apm.h;

import android.text.TextUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.constants.Constants;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(com.bytedance.apm.data.a.e r5) {
        String r1 = e.a().b();
        JSONObject r2 = r5.e;
        if (r2 != null) goto L14;
        r2 = new JSONObject();
    L14:
        if (TextUtils.isEmpty(r1) == false) goto L8;
        r1 = ActivityLifeObserver.getInstance().getTopActivityClassName();     // Catch: JSONException -> L13
    L8:
        r2.put(MemoryInfoSectionEditActivity.KIND_SCENE, r1);     // Catch: JSONException -> L13
        r2.put("process_name", com.bytedance.apm.b.e());     // Catch: JSONException -> L13
        r2.put(LocationMonitorConst.IS_MAIN_PROCESS, com.bytedance.apm.b.f());     // Catch: JSONException -> L13
        if (r2.isNull("is_front") == false) goto L11;
        r2.put("is_front", ActivityLifeObserver.getInstance().isForeground());     // Catch: JSONException -> L13
    L11:
        r5.e = r2;     // Catch: JSONException -> L13
        return;
    }

    public static void a(com.bytedance.apm.data.a.e r1, boolean r2) {
        r1.d(e.a().a(r2));
    }

    public static void a(JSONObject r3, String r4) {
        r3.put("timestamp", System.currentTimeMillis());
        r3.put("crash_time", System.currentTimeMillis());
        r3.put(LocationMonitorConst.IS_MAIN_PROCESS, com.bytedance.apm.b.f());
        r3.put("process_name", com.bytedance.apm.b.e());
        r3.put(Constants.EVENT_TYPE, r4);
        r3.put(MemoryInfoSectionEditActivity.KIND_SCENE, ActivityLifeObserver.getInstance().getTopActivityClassName());
    }
}
