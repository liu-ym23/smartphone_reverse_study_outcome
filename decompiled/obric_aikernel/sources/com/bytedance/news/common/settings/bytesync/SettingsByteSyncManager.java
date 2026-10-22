package com.bytedance.news.common.settings.bytesync;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.news.common.settings.api.model.SettingsByteSyncModel;
import e4.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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
        void onSettingsSyncRequest(@NonNull SettingsByteSyncModel r10);

        void onUpdateSettingKey(@NonNull SettingsByteSyncModel r10);
    }

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SettingsByteSyncModel r10 = new SettingsByteSyncModel();
            r10.callerName = SettingsByteSyncManager.access$000();
            r10.taskData = SettingsByteSyncManager.access$100();
            r10.taskId = SettingsByteSyncManager.access$200();
            r10.taskType = SettingsByteSyncManager.access$300();
            r10.timeStamp = SettingsByteSyncManager.access$400() * 1000;
            SettingsByteSyncManager.access$102(SettingsByteSyncManager.access$202(""));
            if (TextUtils.isEmpty(SettingsByteSyncManager.access$000()) == false) goto L8;
            if (e.e(r10) == false) goto L15;
            e.j(r10);
            e.l(true);
        L15:
            SettingsByteSyncManager.access$602(0);
            return;
        L8:
            if (SettingsByteSyncManager.access$500() == null) goto L15;
            Iterator r11 = SettingsByteSyncManager.access$500().iterator();
        L11:
            if (r11.hasNext() == false) goto L15;
            SettingsByteSyncListener r12 = (SettingsByteSyncListener) r11.next();
            if (r12 == null) goto L11;
            r12.onSettingsSyncRequest(r10);
            goto L11
        }
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

    static /* synthetic */ String access$102(String r10) {
        taskDataTmp = r10;
        return r10;
    }

    static /* synthetic */ String access$200() {
        return taskIdTmp;
    }

    static /* synthetic */ String access$202(String r10) {
        taskIdTmp = r10;
        return r10;
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

    static /* synthetic */ int access$602(int r10) {
        receiveCount = r10;
        return r10;
    }

    public static void onReceiveConnectEvent(@NonNull String r10) {
        JSONObject r11 = new JSONObject(r10);     // Catch: JSONException -> L44
        taskType = r11.optInt("task_type");     // Catch: JSONException -> L44
        taskId = r11.optInt("task_id");     // Catch: JSONException -> L44
        callerName = r11.optString("caller_name");     // Catch: JSONException -> L44
        taskData = r11.optString("task_data");     // Catch: JSONException -> L44
        timeStamp = r11.optLong("time_stamp");     // Catch: JSONException -> L44
        int r12 = taskType;     // Catch: JSONException -> L44
        if (r12 != 2) goto L26;
        if (TextUtils.isEmpty(r11.optString("task_data")) == false) goto L47;
        Log.e(TAG, "taskData is empty");     // Catch: JSONException -> L44
        return;
    L47:
        JSONObject r13 = new JSONObject(taskData);     // Catch: JSONException -> L23
        SettingsByteSyncModel r14 = new SettingsByteSyncModel();     // Catch: JSONException -> L23
        r14.callerName = callerName;     // Catch: JSONException -> L23
        r14.taskData = taskData;     // Catch: JSONException -> L23
        r14.taskId = String.valueOf(taskId);     // Catch: JSONException -> L23
        r14.taskType = taskType;     // Catch: JSONException -> L23
        r14.timeStamp = timeStamp * 1000;     // Catch: JSONException -> L23
        if (TextUtils.isEmpty(callerName) == true) goto L12;
        List<SettingsByteSyncListener> r15 = syncListeners;     // Catch: JSONException -> L23
        if (r15 == null) goto L56;
        Iterator<SettingsByteSyncListener> r16 = r15.iterator();     // Catch: JSONException -> L23
    L18:
        if (r16.hasNext() == false) goto L62;
        SettingsByteSyncListener r17 = r16.next();     // Catch: JSONException -> L23
        if (r17 == null) goto L18;
        r17.onUpdateSettingKey(r14);     // Catch: JSONException -> L23
        goto L18
    L62:
        return;
    L56:
        return;
    L12:
        if (e.e(r14) == false) goto L54;
        e.k(r13);     // Catch: JSONException -> L23
        return;
    L54:
        return;
    L23:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L44
        return;
    L26:
        if (r12 == 1) goto L28;
        return;
    L28:
        if (receiveCount != 0) goto L38;
        receiveCount = 1;     // Catch: JSONException -> L44
        if (TextUtils.isEmpty(taskData) == true) goto L32;
        taskDataTmp = taskData;     // Catch: JSONException -> L44
    L32:
        int r18 = taskId;     // Catch: JSONException -> L44
        if (r18 == 0) goto L35;
        taskIdTmp = String.valueOf(r18);     // Catch: JSONException -> L44
    L35:
        e.f8620c.postDelayed(new a(), 5000);     // Catch: JSONException -> L44
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

    public static void registerByteSyncListener(SettingsByteSyncListener r10) {
        syncListeners.add(r10);
    }

    public void unregisterByteSyncListener(SettingsByteSyncListener r10) {
        syncListeners.remove(r10);
    }
}
