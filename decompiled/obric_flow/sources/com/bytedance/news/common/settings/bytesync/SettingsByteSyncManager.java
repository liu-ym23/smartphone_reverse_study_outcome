package com.bytedance.news.common.settings.bytesync;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.news.common.settings.api.model.SettingsByteSyncModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pg.e;
import ug.d;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsByteSyncManager {
    private static final String TAG = "SettingsByteSyncManager";
    private static String callerName;
    private static volatile int receiveCount;
    private static List<SettingsByteSyncListener> syncListeners;
    private static String taskData;
    private static String taskDataTmp;
    private static int taskId;
    private static String taskIdTmp;
    private static int taskType;
    private static long timeStamp;

    public interface SettingsByteSyncListener {
        void onSettingsSyncRequest(@NonNull SettingsByteSyncModel r5);

        void onUpdateSettingKey(@NonNull SettingsByteSyncModel r5);
    }

    static {
        syncListeners = new ArrayList();
    }

    public SettingsByteSyncManager() {
    }

    public static /* synthetic */ String access$000() {
        return callerName;
    }

    public static /* synthetic */ String access$100() {
        return taskDataTmp;
    }

    public static /* synthetic */ String access$102(String r5) {
        taskDataTmp = r5;
        return r5;
    }

    public static /* synthetic */ String access$200() {
        return taskIdTmp;
    }

    public static /* synthetic */ String access$202(String r5) {
        taskIdTmp = r5;
        return r5;
    }

    public static /* synthetic */ int access$300() {
        return taskType;
    }

    public static /* synthetic */ long access$400() {
        return timeStamp;
    }

    public static /* synthetic */ List access$500() {
        return syncListeners;
    }

    public static /* synthetic */ int access$602(int r5) {
        receiveCount = r5;
        return r5;
    }

    public static void onReceiveConnectEvent(@NonNull String r10) {
        JSONObject r5 = new JSONObject(r10);     // Catch: JSONException -> L9
        taskType = r5.optInt("task_type");     // Catch: JSONException -> L9
        taskId = r5.optInt("task_id");     // Catch: JSONException -> L9
        callerName = r5.optString("caller_name");     // Catch: JSONException -> L9
        taskData = r5.optString("task_data");     // Catch: JSONException -> L9
        timeStamp = r5.optLong("time_stamp");     // Catch: JSONException -> L9
        int r11 = taskType;     // Catch: JSONException -> L9
        if (r11 != 2) goto L31;
        if (TextUtils.isEmpty(r5.optString("task_data")) == false) goto L51;
        Log.e(TAG, "taskData is empty");     // Catch: JSONException -> L9
        return;
    L51:
        new JSONObject(taskData);     // Catch: JSONException -> L16
        SettingsByteSyncModel r12 = new SettingsByteSyncModel();     // Catch: JSONException -> L16
        r12.callerName = callerName;     // Catch: JSONException -> L16
        r12.taskData = taskData;     // Catch: JSONException -> L16
        r12.taskId = String.valueOf(taskId);     // Catch: JSONException -> L16
        r12.taskType = taskType;     // Catch: JSONException -> L16
        r12.timeStamp = timeStamp * 1000;     // Catch: JSONException -> L16
        if (TextUtils.isEmpty(callerName) == false) goto L20;
        Handler r13 = e.f21353a;     // Catch: JSONException -> L16
        if (r12.timeStamp >= Math.max(0, 0)) goto L18;
        Log.e("SettingsManager", "settingsByteSyncModel.timeStamp = " + r12.timeStamp + " initTime = 0 requestTime = 0");     // Catch: JSONException -> L16
        return;
    L18:
        d.f(ug.a.b());     // Catch: JSONException -> L16
        throw null;     // Catch: JSONException -> L16
    L20:
        List<SettingsByteSyncListener> r14 = syncListeners;     // Catch: JSONException -> L16
        if (r14 == null) goto L59;
        Iterator<SettingsByteSyncListener> r15 = r14.iterator();     // Catch: JSONException -> L16
    L24:
        if (r15.hasNext() == false) goto L65;
        SettingsByteSyncListener r16 = r15.next();     // Catch: JSONException -> L16
        if (r16 == null) goto L24;
        r16.onUpdateSettingKey(r12);     // Catch: JSONException -> L16
        goto L24
    L65:
        return;
    L59:
        return;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L9
        return;
    L31:
        if (r11 == 1) goto L33;
        return;
    L33:
        if (receiveCount != 0) goto L43;
        receiveCount = 1;     // Catch: JSONException -> L9
        if (TextUtils.isEmpty(taskData) == true) goto L37;
        taskDataTmp = taskData;     // Catch: JSONException -> L9
    L37:
        int r17 = taskId;     // Catch: JSONException -> L9
        if (r17 == 0) goto L40;
        taskIdTmp = String.valueOf(r17);     // Catch: JSONException -> L9
    L40:
        e.f21353a.postDelayed(new a(), 5000);     // Catch: JSONException -> L9
        return;
    L43:
        if (TextUtils.isEmpty(taskData) == true) goto L46;
        taskDataTmp += "," + taskData;     // Catch: JSONException -> L9
    L46:
        if (taskId == 0) goto L63;
        taskIdTmp += "," + taskId;     // Catch: JSONException -> L9
        return;
    L63:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    public static void registerByteSyncListener(SettingsByteSyncListener r5) {
        syncListeners.add(r5);
    }

    public void unregisterByteSyncListener(SettingsByteSyncListener r5) {
        syncListeners.remove(r5);
    }
}
