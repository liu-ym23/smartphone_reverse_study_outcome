package com.bytedance.crash.upload;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.monitor.MonitorManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class EventUploadQueue {
    public EventUploadQueue() {
    }

    public static void enqueue(@NonNull EventBody r10) {
        enqueue(null, r10);
    }

    public static void enqueue(@Nullable Object r10, @NonNull EventBody r11) {
        JSONObject r12 = r11.getJson();
        String r13 = r12.optString("log_type");
        if (TextUtils.isEmpty(r13) == false) goto L5;
        r13 = null;
    L5:
        String r14 = r12.optString("stack");
        String r15 = r12.optString(Constants.EVENT_TYPE);
        String r16 = r12.optString("java_data");
        String r17 = r12.optString("stack");
        if (r15.equals(CommonConsts.LOG_REPORT_TYPE_EXCEPTION) == false) goto L9;
        MonitorManager.getAppEnsureManager().reportJavaEnsure(r12, r14, r13);
        return;
    L9:
        if (r15.equals("native_exception") == false) goto L13;
        MonitorManager.getAppEnsureManager().reportNativeEnsure(r12, r17, r16, r13);
        return;
    }
}
