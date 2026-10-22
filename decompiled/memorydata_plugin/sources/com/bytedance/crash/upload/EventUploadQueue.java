package com.bytedance.crash.upload;

import android.text.TextUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.monitor.MonitorManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class EventUploadQueue {
    public EventUploadQueue() {
    }

    public static void enqueue(EventBody r1) {
        enqueue(null, r1);
    }

    public static void enqueue(Object r5, EventBody r6) {
        JSONObject r7 = r6.getJson();
        String r8 = r7.optString("log_type");
        if (TextUtils.isEmpty(r8) == false) goto L5;
        r8 = null;
    L5:
        String r1 = r7.optString("stack");
        String r2 = r7.optString(Constants.EVENT_TYPE);
        String r3 = r7.optString("java_data");
        String r0 = r7.optString("stack");
        if (r2.equals(CommonConsts.LOG_REPORT_TYPE_EXCEPTION) == false) goto L9;
        MonitorManager.getAppEnsureManager().reportJavaEnsure(r7, r1, r8);
        return;
    L9:
        if (r2.equals("native_exception") == false) goto L13;
        MonitorManager.getAppEnsureManager().reportNativeEnsure(r7, r0, r3, r8);
        return;
    }
}
