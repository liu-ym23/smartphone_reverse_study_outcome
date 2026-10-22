package com.bytedance.crash.runtime.assembly;

import android.app.Activity;
import com.bytedance.crash.outer.CustomActivity;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class ActivityDataManager {
    private static volatile ActivityDataManager sInst;

    private ActivityDataManager() {
    }

    public static ActivityDataManager getInstance() {
        if (sInst != null) goto L15;
        monitor-enter(ActivityDataManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInst != null) goto L9;
        sInst = new ActivityDataManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ActivityDataManager.class);     // Catch: Throwable -> L11
    L15:
        return sInst;
    }

    public static int getLaunchMode() {
        return ActivityLifecycle.getLaunchMode();
    }

    public static long getLaunchTime() {
        return ActivityLifecycle.getLaunchTime();
    }

    public long backgroundTime() {
        return ActivityLifecycle.getBackgroundTimeMs();
    }

    public JSONArray getActivityLife() {
        return ActivityLifecycle.getLifecycleTrack();
    }

    public JSONObject getActivityTrace() {
        JSONObject r2 = new JSONObject();
        ActivityLifecycle.loadActivityTrace(r2);
        if (r2.has(ActivityLifecycle.ACTIVITY_TRACE) == true) goto L5;
        return r2;
    L5:
        return r2.optJSONObject(ActivityLifecycle.ACTIVITY_TRACE);
    }

    public ArrayList<WeakReference<Activity>> getAllActivities() {
        return ActivityLifecycle.getAllActivities();
    }

    public String getLastResumeActivity() {
        return ActivityLifecycle.getLastResumeActivity();
    }

    public boolean isForeground() {
        return !ActivityLifecycle.isBackground();
    }

    public void setCustomActivity(CustomActivity r2) {
        ActivityLifecycle.setCustomActivity((CustomActivity) ZeusTransformUtils.wrapperContextForParams(r2, CustomActivity.class, "com.obric.memorydata.plugin"));
    }
}
