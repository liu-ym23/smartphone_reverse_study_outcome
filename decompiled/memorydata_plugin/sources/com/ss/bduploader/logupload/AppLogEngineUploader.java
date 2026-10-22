package com.ss.bduploader.logupload;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.crash.entity.EventBody;
import com.ss.bduploader.BDUploadUtil;
import com.ss.bduploader.UploadEventManager;
import com.ss.bduploader.net.BDUploadThreadPool;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class AppLogEngineUploader implements VideoEventEngineUploader {
    private static final String APPLOG_CLASS_NAME = "com.ss.android.common.applog.AppLog";
    private static final String APPLOG_NEW_UTILS_CLASS_NAME = "com.ss.android.common.lib.AppLogNewUtils";
    private static final String APPLOG_WRAPPER = "com.pandora.common.applog.AppLogWrapper";
    private static final String TAG = "ttmn";

    private static class Holder {
        private static final AppLogEngineUploader instance = null;

        static {
            instance = new AppLogEngineUploader(null);
        }

        private Holder() {
        }

        static /* synthetic */ AppLogEngineUploader access$100() {
            return instance;
        }
    }

    private AppLogEngineUploader() {
    }

    /* synthetic */ AppLogEngineUploader(AnonymousClass1 r1) {
        this();
    }

    public static AppLogEngineUploader getInstance() {
        return Holder.access$100();
    }

    static void logPrint(final JSONObject r1) {
        BDUploadThreadPool.addExecuteTask(new AnonymousClass1(r1));
    }

    private JSONObject setJsonValue(JSONObject r3, String r4, String r5) {
        r3.put(r4, r5);     // Catch: JSONException -> L4
        Log.d(TAG, "key" + r4 + EventBody.KEY_VALUE + r5);     // Catch: JSONException -> L4
    L6:
        return r3;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    @Override // com.ss.bduploader.logupload.VideoEventEngineUploader
    public void onEventV3(String r11, JSONObject r12) {
        Log.i(TAG, "onEventV3 monitorName " + r11);
        if (r12 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L18;
        logPrint(r12);
        if (BDUploadUtil.eventEngineUploader == null) goto L15;
        BDUploadUtil.eventEngineUploader.onEventV3(r11, setJsonValue(r12, "upload_log_type", "2"));
        return;
    L15:
        ZeusTransformUtils.forName(APPLOG_NEW_UTILS_CLASS_NAME, "com.obric.memorydata.plugin").getMethod("onEventV3", new Class[]{String.class, JSONObject.class}).invoke(null, new Object[]{r11, setJsonValue(r12, "upload_log_type", "1")});     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        UploadEventManager.instance.putEvent(setJsonValue(r12, "upload_log_type", "0"));
        e.printStackTrace();
        Log.e(TAG, "upload error " + e);
        return;
    }
}
