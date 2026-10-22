package com.bytedance.news.common.settings.bytesync;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.news.common.settings.api.model.SettingsByteSyncModel;
import com.bytedance.news.common.settings.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

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
        void onSettingsSyncRequest(SettingsByteSyncModel r1);

        void onUpdateSettingKey(SettingsByteSyncModel r1);
    }

    static {
        syncListeners = new ArrayList();
    }

    public SettingsByteSyncManager() {
    }

    static /* synthetic */ String access$000() {
        return callerName;
    }

    static /* synthetic */ String access$100() {
        return taskDataTmp;
    }

    static /* synthetic */ String access$102(String r0) {
        taskDataTmp = r0;
        return r0;
    }

    static /* synthetic */ String access$200() {
        return taskIdTmp;
    }

    static /* synthetic */ String access$202(String r0) {
        taskIdTmp = r0;
        return r0;
    }

    static /* synthetic */ int access$300() {
        return taskType;
    }

    static /* synthetic */ long access$400() {
        return timeStamp;
    }

    static /* synthetic */ List access$500() {
        return syncListeners;
    }

    static /* synthetic */ int access$602(int r0) {
        receiveCount = r0;
        return r0;
    }

    public static void onReceiveConnectEvent(String r5) {
        JSONObject r1 = new JSONObject(r5);     // Catch: JSONException -> L44
        taskType = r1.optInt("task_type");     // Catch: JSONException -> L44
        taskId = r1.optInt("task_id");     // Catch: JSONException -> L44
        callerName = r1.optString("caller_name");     // Catch: JSONException -> L44
        taskData = r1.optString("task_data");     // Catch: JSONException -> L44
        timeStamp = r1.optLong("time_stamp");     // Catch: JSONException -> L44
        int r6 = taskType;     // Catch: JSONException -> L44
        if (r6 != 2) goto L26;
        if (TextUtils.isEmpty(r1.optString("task_data")) == false) goto L47;
        Log.e(TAG, "taskData is empty");     // Catch: JSONException -> L44
        return;
    L47:
        JSONObject r7 = new JSONObject(taskData);     // Catch: JSONException -> L23
        SettingsByteSyncModel r0 = new SettingsByteSyncModel();     // Catch: JSONException -> L23
        r0.callerName = callerName;     // Catch: JSONException -> L23
        r0.taskData = taskData;     // Catch: JSONException -> L23
        r0.taskId = String.valueOf(taskId);     // Catch: JSONException -> L23
        r0.taskType = taskType;     // Catch: JSONException -> L23
        r0.timeStamp = timeStamp * 1000;     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(callerName) == true) goto L12;
        List<SettingsByteSyncListener> r8 = syncListeners;     // Catch: JSONException -> L23
        if (r8 == null) goto L56;
        Iterator<SettingsByteSyncListener> r9 = r8.iterator();     // Catch: JSONException -> L23
    L18:
        if (r9.hasNext() == false) goto L62;
        SettingsByteSyncListener r2 = (SettingsByteSyncListener) ZeusTransformUtils.preCheckCast(r9.next(), SettingsByteSyncListener.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L23
        if (r2 == null) goto L18;
        r2.onUpdateSettingKey(r0);     // Catch: JSONException -> L23
        goto L18
    L62:
        return;
    L56:
        return;
    L12:
        if (e.a(r0) == false) goto L54;
        e.a(r7);     // Catch: JSONException -> L23
        return;
    L54:
        return;
    L23:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L44
        return;
    L26:
        if (r6 == 1) goto L28;
        return;
    L28:
        if (receiveCount != 0) goto L38;
        receiveCount = 1;     // Catch: JSONException -> L44
        if (TextUtils.isEmpty(taskData) == true) goto L32;
        taskDataTmp = taskData;     // Catch: JSONException -> L44
    L32:
        int r10 = taskId;     // Catch: JSONException -> L44
        if (r10 == 0) goto L35;
        taskIdTmp = String.valueOf(r10);     // Catch: JSONException -> L44
    L35:
        e.f2935a.postDelayed(new AnonymousClass1(), 5000);     // Catch: JSONException -> L44
        return;
    L38:
        if (TextUtils.isEmpty(taskData) == true) goto L41;
        taskDataTmp += "," + taskData;     // Catch: JSONException -> L44
    L41:
        if (taskId == 0) goto L60;
        taskIdTmp += "," + taskId;     // Catch: JSONException -> L44
        return;
    L60:
        return;
    L44:
        e = move-exception;
        e.printStackTrace();
    }

    public static void registerByteSyncListener(SettingsByteSyncListener r2) {
        SettingsByteSyncListener r3 = (SettingsByteSyncListener) ZeusTransformUtils.wrapperContextForParams(r2, SettingsByteSyncListener.class, "com.obric.memorydata.plugin");
        syncListeners.add(r3);
    }

    public void unregisterByteSyncListener(SettingsByteSyncListener r2) {
        SettingsByteSyncListener r1 = (SettingsByteSyncListener) ZeusTransformUtils.wrapperContextForParams(r2, SettingsByteSyncListener.class, "com.obric.memorydata.plugin");
        syncListeners.remove(r1);
    }
}
