package com.bytedance.crash.tracker;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.crash.Flavor;
import com.bytedance.crash.Global;
import com.bytedance.crash.dumper.tools.JsonDumper;
import com.bytedance.crash.entity.CustomLong;
import com.bytedance.crash.outer.CustomActivity;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.tracker.fragment.FragmentLifeManager;
import com.bytedance.crash.util.DateUtils;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityLifecycle {
    private static final String ACTIVITY_ALIVE = "alive_activities";
    private static final String ACTIVITY_FINISH = "finish_activities";
    public static final String ACTIVITY_TRACE = "activity_trace";
    public static final String ACTIVITY_TRACK = "activity_track";
    private static final int DESTROYED_ACTIVITY_LIMIT = 20;
    private static final String[] JSON_TAGS = null;
    public static final String LAST_RESUME_ACTIVITY = "last_resume_activity";
    public static final int LAUNCH_COLD = 1;
    public static final int LAUNCH_COLD_FIRST = 1;
    public static final int LAUNCH_COLD_SECOND = 2;
    public static final int LAUNCH_HOT = 3;
    public static final int LAUNCH_WARM = 4;
    private static final String[] METHOD_NAMES = null;
    public static final String NAME = "name";
    private static final int STATE_CREATED = 0;
    private static final int STATE_DESTROYED = 5;
    private static final int STATE_MAX = 6;
    private static final int STATE_PAUSED = 3;
    private static final int STATE_RESUMED = 2;
    private static final int STATE_STARTED = 1;
    private static final int STATE_STOPPED = 4;
    private static final String TIME = "time";
    private static final int TRACE_POOL_CAPACITY = 50;
    private static boolean isClodLaunch = true;
    private static boolean isRestore = false;
    private static boolean isWalkOnCreate = false;
    private static boolean sFirstLaunch = false;
    private static volatile ActivityLifecycle sInstance = null;
    private static int sLaunchMode = 1;
    private static long sLaunchTime = -1;
    private final ArrayList<WeakReference<Activity>> mActivitiesCache;
    private int mActivityNum;
    private final Map<Integer, ActivityRecord> mAliveActivities;
    private CustomActivity mCustomActivity;
    private final List<ActivityRecord> mDestroyedActivities;
    private boolean mIsForeground;
    private String mLastPauseActivity;
    private final ActivityStateRecord[] mLastStates;
    private final LinkedList<LifecycleTrace> mLifecycleTracePool;

    class ActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        final /* synthetic */ ActivityLifecycle this$0;

        ActivityLifecycleCallbacks(ActivityLifecycle r1) {
            this.this$0 = r1;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r3, Bundle r4) {
            Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L5;
            boolean r6 = true;
        L6:
            ActivityLifecycle.access$002(r6);
            ActivityLifecycle.access$100(this.this$0, 0, r5);
            ActivityLifecycle.access$202(true);
            ActivityLifecycle.access$300(this.this$0).add(new WeakReference(r5));
            FragmentLifeManager.register(r5);
            return;
        L5:
            r6 = false;
            goto L6
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
            ActivityLifecycle.access$100(this.this$0, 5, r4);
            FragmentLifeManager.unregister(r4);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
            ActivityLifecycle r0 = this.this$0;
            if (ActivityLifecycle.access$400(r0) != null) goto L5;
            String r1 = r4.getClass().getName();
        L6:
            ActivityLifecycle.access$1002(r0, r1);
            ActivityLifecycle.access$510(this.this$0);
            if (ActivityLifecycle.access$500(this.this$0) != 0) goto L10;
        L8:
            ActivityLifecycle.access$602(this.this$0, false);
            ActivityLifecycle.access$202(false);
        L12:
            ActivityLifecycle.access$100(this.this$0, 3, r4);
            return;
        L10:
            if (ActivityLifecycle.access$500(this.this$0) >= 0) goto L12;
            ActivityLifecycle.access$502(this.this$0, 0);
            goto L8
        L5:
            r1 = ActivityLifecycle.access$400(this.this$0).getActivityName(r4);
            goto L6
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r5) {
            Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.memorydata.plugin");
            ActivityLifecycle.access$100(this.this$0, 2, r6);
            if (ActivityLifecycle.access$400(this.this$0) != null) goto L5;
            String r7 = r6.getClass().getName();
        L6:
            long r0 = System.currentTimeMillis();
            ActivityLifecycle.access$508(this.this$0);
            if (ActivityLifecycle.access$600(this.this$0) == true) goto L24;
            ActivityLifecycle.access$602(this.this$0, true);
            if (ActivityLifecycle.access$700() == false) goto L12;
            ActivityLifecycle.access$702(false);
            ActivityLifecycle.access$802(1);
            ActivityLifecycle.access$902(r0);
        L12:
            if (r7.equals(ActivityLifecycle.access$1000(this.this$0)) == true) goto L15;
            return;
        L15:
            if (ActivityLifecycle.access$200() == false) goto L20;
            if (ActivityLifecycle.access$000() == true) goto L20;
            int r4 = 4;
        L22:
            ActivityLifecycle.access$802(r4);
            ActivityLifecycle.access$902(r0);
            return;
        L20:
            if (ActivityLifecycle.access$200() == true) goto L25;
            r4 = 3;
            goto L22
        L25:
            return;
        L24:
            return;
        L5:
            r7 = ActivityLifecycle.access$400(this.this$0).getActivityName(r6);
            goto L6
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
            Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.memorydata.plugin");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
            ActivityLifecycle.access$100(this.this$0, 1, r4);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
            ActivityLifecycle.access$100(this.this$0, 4, r4);
        }
    }

    private static class ActivityRecord {
        String mActivityName;
        long mCreatedMillis;
        long mCurrentMillis;
        int mCurrentState;
        int mHashCode;

        public ActivityRecord(String r1, long r2, int r4) {
            this.mActivityName = r1;
            this.mHashCode = r4;
            this.mCreatedMillis = r2;
        }

        public void changeState(int r1, long r2) {
            this.mCurrentState = r1;
            this.mCurrentMillis = r2;
        }
    }

    static class ActivityStateRecord {
        ActivityRecord mActivity;
        long mTime;

        ActivityStateRecord() {
        }
    }

    public static class LifecycleTrace {
        long mMillis;
        ActivityRecord mRecord;
        int mState;

        public LifecycleTrace() {
        }

        static /* synthetic */ String access$1100(LifecycleTrace r0) {
            return r0.formatWithTime();
        }

        static /* synthetic */ String access$1200(String r0) {
            return formatLine(r0);
        }

        static /* synthetic */ void access$1300(LifecycleTrace r0, StringBuilder r1) {
            r0.appendLine(r1);
        }

        private void appendLine(StringBuilder r3) {
            r3.append(this.mMillis).append(' ').append(this.mRecord.mActivityName).append(' ').append(this.mRecord.mHashCode).append(' ').append(this.mState).append('\n');
        }

        private static String format(long r1, String r3, int r4, int r5) {
            return DateUtils.formatDate(r1) + " : " + r3 + '.' + ActivityLifecycle.access$1400()[r5] + '@' + Long.toHexString(r4);
        }

        private static String formatLine(String r6) {
            String[] r7 = r6.split(" ");
            if (r7.length == 4) goto L14;
            return null;
        L14:
            long r2 = Long.parseLong(r7[0]);     // Catch: Exception -> L13
            String r0 = r7[1];     // Catch: Exception -> L13
            int r4 = Integer.parseInt(r7[2]);     // Catch: Exception -> L13
            int r8 = Integer.parseInt(r7[3]);     // Catch: Exception -> L13
            if (r8 < 0) goto L12;
            if (r8 >= ActivityLifecycle.access$1400().length) goto L12;
            return format(r2, r0, r4, r8);
        L12:
            return null;
        }

        private String formatWithTime() {
            return format(this.mMillis, this.mRecord.mActivityName, this.mRecord.mHashCode, this.mState);
        }

        void copyFrom(ActivityRecord r3) {
            this.mRecord = r3;
            this.mMillis = r3.mCurrentMillis;
            this.mState = r3.mCurrentState;
        }
    }

    static {
        JSON_TAGS = new String[]{"last_create_activity", "last_start_activity", LAST_RESUME_ACTIVITY, "last_pause_activity", "last_stop_activity", "last_destroy_activity"};
        METHOD_NAMES = new String[]{"onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy"};
    }

    private ActivityLifecycle() {
        this.mAliveActivities = new HashMap();
        this.mDestroyedActivities = new ArrayList();
        this.mLastStates = new ActivityStateRecord[6];
        this.mLifecycleTracePool = new LinkedList();
        this.mActivitiesCache = new ArrayList();
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 24) goto L6;
        if (r0 == null) goto L6;
        r0.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks(this));
    L6:
        Flavor.setActivityImpl();
    }

    static /* synthetic */ boolean access$000() {
        return isRestore;
    }

    static /* synthetic */ boolean access$002(boolean r0) {
        isRestore = r0;
        return r0;
    }

    static /* synthetic */ void access$100(ActivityLifecycle r2, int r3, Activity r4) {
        r2.recordLifecycle(r3, (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ String access$1000(ActivityLifecycle r0) {
        return r0.mLastPauseActivity;
    }

    static /* synthetic */ String access$1002(ActivityLifecycle r0, String r1) {
        r0.mLastPauseActivity = r1;
        return r1;
    }

    static /* synthetic */ String[] access$1400() {
        return METHOD_NAMES;
    }

    static /* synthetic */ boolean access$200() {
        return isWalkOnCreate;
    }

    static /* synthetic */ boolean access$202(boolean r0) {
        isWalkOnCreate = r0;
        return r0;
    }

    static /* synthetic */ ArrayList access$300(ActivityLifecycle r0) {
        return r0.mActivitiesCache;
    }

    static /* synthetic */ CustomActivity access$400(ActivityLifecycle r0) {
        return r0.mCustomActivity;
    }

    static /* synthetic */ int access$500(ActivityLifecycle r0) {
        return r0.mActivityNum;
    }

    static /* synthetic */ int access$502(ActivityLifecycle r0, int r1) {
        r0.mActivityNum = r1;
        return r1;
    }

    static /* synthetic */ int access$508(ActivityLifecycle r2) {
        int r0 = r2.mActivityNum;
        r2.mActivityNum = r0 + 1;
        return r0;
    }

    static /* synthetic */ int access$510(ActivityLifecycle r2) {
        int r0 = r2.mActivityNum;
        r2.mActivityNum = r0 - 1;
        return r0;
    }

    static /* synthetic */ boolean access$600(ActivityLifecycle r0) {
        return r0.mIsForeground;
    }

    static /* synthetic */ boolean access$602(ActivityLifecycle r0, boolean r1) {
        r0.mIsForeground = r1;
        return r1;
    }

    static /* synthetic */ boolean access$700() {
        return isClodLaunch;
    }

    static /* synthetic */ boolean access$702(boolean r0) {
        isClodLaunch = r0;
        return r0;
    }

    static /* synthetic */ int access$802(int r0) {
        sLaunchMode = r0;
        return r0;
    }

    static /* synthetic */ long access$902(long r0) {
        sLaunchTime = r0;
        return r0;
    }

    public static void dump(File r1) {
        if (isBackground() == false) goto L6;
        FileSystemUtils.createFile(r1, TraceCons.METRIC_BACKGROUND);
    L6:
        if (isBackgroundV2() == false) goto L8;
        FileSystemUtils.createFile(r1, "background_v2");
    L8:
        instance().dumpTrace(r1);
        instance().dumpTrack(r1);
        FragmentLifeManager.dump(r1);
    }

    private void dumpTrace(File r12) {
        JsonDumper r0 = new JsonDumper(r12.getAbsolutePath() + "/" + ACTIVITY_TRACE + ".json");
        r0.objectBegin();
        r0.key(ACTIVITY_TRACE);
        r0.objectBegin();
        int r1 = 0;
    L4:
        if (r1 >= 6) goto L11;
        ActivityStateRecord[] r2 = this.mLastStates;
        if (r2[r1] == null) goto L10;
        if (r2[r1].mActivity == null) goto L10;
        r0.key(JSON_TAGS[r1]);
        r0.objectBegin();
        r0.key(NAME).value(this.mLastStates[r1].mActivity.mActivityName).next();
        r0.key("time").value(this.mLastStates[r1].mTime);
        r0.objectEnd();
        r0.next();
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        r0.key(ACTIVITY_ALIVE);
        r0.arrayBegin();
        ArrayList r3 = new ArrayList(this.mAliveActivities.entrySet());
        Collections.sort(r3, new AnonymousClass2(this));
        Iterator r4 = r3.iterator();
        boolean r5 = true;
    L13:
        if (r4.hasNext() == false) goto L19;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r5 == false) goto L17;
        r5 = false;
    L18:
        r0.objectBegin();
        r0.key(NAME).value(((ActivityRecord) ZeusTransformUtils.preCheckCast(r6.getValue(), ActivityRecord.class, "com.obric.memorydata.plugin")).mActivityName).next();
        r0.key("time").value(((ActivityRecord) ZeusTransformUtils.preCheckCast(r6.getValue(), ActivityRecord.class, "com.obric.memorydata.plugin")).mCreatedMillis);
        r0.objectEnd();
        goto L13
    L17:
        r0.next();
        goto L18
    L19:
        r0.arrayEnd().next();
        r0.key(ACTIVITY_FINISH);
        r0.arrayBegin();
        int r13 = this.mDestroyedActivities.size() - 1;
    L20:
        if (r13 < 0) goto L25;
        r0.objectBegin();
        r0.key(NAME).value(((ActivityRecord) ZeusTransformUtils.preCheckCast(this.mDestroyedActivities.get(r13), ActivityRecord.class, "com.obric.memorydata.plugin")).mActivityName).next();
        r0.key("time").value(((ActivityRecord) ZeusTransformUtils.preCheckCast(this.mDestroyedActivities.get(r13), ActivityRecord.class, "com.obric.memorydata.plugin")).mCurrentMillis);
        r0.objectEnd();
        if (r13 == 0) goto L24;
        r0.next();
    L24:
        r13 = r13 - 1;
        goto L20
    L25:
        r0.arrayEnd();
        r0.objectEnd();
        r0.objectEnd();
        r0.release();
    }

    private void dumpTrack(File r5) {
        StringBuilder r4 = new StringBuilder();
        Iterator<LifecycleTrace> r0 = instance().mLifecycleTracePool.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        LifecycleTrace.access$1300((LifecycleTrace) ZeusTransformUtils.preCheckCast(r0.next(), LifecycleTrace.class, "com.obric.memorydata.plugin"), r4);
        goto L4
    L7:
        if (r4.length() != 0) goto L9;
        return;
    L9:
        FileSystemUtils.writeFile(new File(r5, "activity_track.inf"), r4.toString());
    }

    private String getActivityName(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        CustomActivity r2 = this.mCustomActivity;
        if (r2 == null) goto L5;
        String r5 = r2.getActivityName(r4);
    L7:
        if (TextUtils.isEmpty(r5) == true) goto L9;
        return r5;
    L9:
        return r4.getClass().getName();
    L5:
        r5 = null;
        goto L7
    }

    public static ArrayList<WeakReference<Activity>> getAllActivities() {
        return instance().mActivitiesCache;
    }

    public static long getBackgroundTimeMs() {
        return instance().getBackgroundTimeMsInner();
    }

    private long getBackgroundTimeMsInner() {
        ArrayList r0 = new ArrayList(this.mAliveActivities.entrySet());
        int r8 = 0;
        long r3 = 0;
    L4:
        if (r8 >= r0.size()) goto L12;
        ActivityRecord r5 = (ActivityRecord) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.get(r8), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), ActivityRecord.class, "com.obric.memorydata.plugin");
        if (r5.mCurrentState < 3) goto L7;
        if (r3 >= r5.mCurrentMillis) goto L11;
        r3 = r5.mCurrentMillis;
    L11:
        r8 = r8 + 1;
        goto L4
    L7:
        return 0;
    L12:
        return r3;
    }

    public static String getLastResumeActivity() {
        ActivityStateRecord r0 = instance().mLastStates[2];
        if (r0 != null) goto L5;
        return "null";
    L5:
        if (r0.mActivity != null) goto L7;
        return "null";
    L7:
        return r0.mActivity.mActivityName;
    }

    public static String getLastResumedActivityFromBody(JSONObject r2) {
        JSONObject r3 = r2.optJSONObject(ACTIVITY_TRACE);
        if (r3 == null) goto L8;
        JSONObject r4 = r3.optJSONObject(JSON_TAGS[2]);
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.optString(NAME);
    L8:
        return null;
    }

    public static int getLaunchMode() {
        int r0 = sLaunchMode;
        if (r0 == 1) goto L5;
        return r0;
    L5:
        if (sFirstLaunch == false) goto L9;
        return 2;
    L9:
        return 1;
    }

    public static long getLaunchTime() {
        return sLaunchTime;
    }

    public static JSONArray getLifecycleTrack() {
        JSONArray r0 = new JSONArray();
        Iterator r1 = new ArrayList(instance().mLifecycleTracePool).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.put(LifecycleTrace.access$1100((LifecycleTrace) ZeusTransformUtils.preCheckCast(r1.next(), LifecycleTrace.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        return r0;
    }

    private static String getTrackMethodName(int r1) {
        if (r1 != 0) goto L4;
        return "onCreate";
    L4:
        if (r1 != 1) goto L6;
        return "onStart";
    L6:
        if (r1 != 2) goto L8;
        return "onResume";
    L8:
        if (r1 != 3) goto L10;
        return "onPause";
    L10:
        if (r1 != 4) goto L12;
        return "onStop";
    L12:
        if (r1 == 5) goto L15;
        return "";
    L15:
        return "onDestroy";
    }

    private static ActivityLifecycle instance() {
        if (sInstance != null) goto L15;
        monitor-enter(ActivityLifecycle.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ActivityLifecycle();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ActivityLifecycle.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public static boolean isBackground() {
        if (instance().mAliveActivities.isEmpty() == true) goto L13;
        if (instance().isForegroundInner() == false) goto L7;
        return false;
    L7:
        if ((System.currentTimeMillis() - getBackgroundTimeMs()) <= 2000) goto L10;
        return true;
    L10:
        return false;
    L13:
        return !isForegroundByAms();
    }

    public static boolean isBackgroundV2() {
        if (instance().mAliveActivities.isEmpty() == true) goto L10;
        if (instance().isForegroundInner() == true) goto L7;
        return true;
    L7:
        return false;
    L10:
        return !isForegroundByAms();
    }

    private static boolean isForegroundByAms() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return false;
    L5:
        String r3 = r0.getPackageName();
        ActivityManager r1 = (ActivityManager) ZeusTransformUtils.preCheckCast(r0.getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r1 != null) goto L10;
        return false;
    L10:
        if (Build.VERSION.SDK_INT >= 21) goto L20;
        List<ActivityManager.RunningTaskInfo> r2 = r1.getRunningTasks(1);     // Catch: Throwable -> L21
        if (r2 == null) goto L20;
        if (r2.isEmpty() == true) goto L20;
        ComponentName r4 = ((ActivityManager.RunningTaskInfo) ZeusTransformUtils.preCheckCast(r2.get(0), ActivityManager.RunningTaskInfo.class, "com.obric.memorydata.plugin")).topActivity;     // Catch: Throwable -> L21
        if (r4 == null) goto L20;
        if (r3.equals(r4.getPackageName()) == false) goto L20;
        return true;
    L20:
        return false;
    }

    private boolean isForegroundInner() {
        ArrayList r0 = new ArrayList(this.mAliveActivities.entrySet());
        int r1 = 0;
    L4:
        if (r1 >= r0.size()) goto L10;
        if (((ActivityRecord) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.get(r1), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), ActivityRecord.class, "com.obric.memorydata.plugin")).mCurrentState < 3) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public static void load(JSONObject r4, File r5) {
        r4.put("is_background", new File(r5, TraceCons.METRIC_BACKGROUND).exists());     // Catch: Throwable -> L15
    L3:
        String r0 = FileSystemUtils.readUtf8File(new File(r5, "activity_trace.json"));
        if (r0 == null) goto L25;
        JSONUtils.combineJson(r4, new JSONObject(r0));     // Catch: Throwable -> L16
    L25:
        JSONArray r1 = new JSONArray();     // Catch: IOException -> L17
        BufferedReader r2 = new BufferedReader(new FileReader(new File(r5, "activity_track.inf")));     // Catch: IOException -> L17
    L7:
        String r3 = r2.readLine();     // Catch: IOException -> L17
        if (r3 == null) goto L12;
        String r6 = LifecycleTrace.access$1200(r3);     // Catch: IOException -> L17
        if (r6 == null) goto L7;
        r1.put(r6);     // Catch: IOException -> L17
        goto L7
    L12:
        CustomLong.add(r4, ACTIVITY_TRACK, r1);     // Catch: IOException -> L17
    L21:
        FragmentLifeManager.load(r4, r5);     // Catch: Throwable -> L18
        return;
    }

    public static void loadActivityTrace(JSONObject r10) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L22
        int r1 = 0;
    L5:
        if (r1 >= 6) goto L12;
        if (instance().mLastStates[r1] == null) goto L11;
        if (instance().mLastStates[r1].mActivity == null) goto L11;
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L22
        r2.put(NAME, instance().mLastStates[r1].mActivity.mActivityName);     // Catch: Throwable -> L22
        r2.put("time", instance().mLastStates[r1].mTime);     // Catch: Throwable -> L22
        r0.put(JSON_TAGS[r1], r2);     // Catch: Throwable -> L22
    L11:
        r1 = r1 + 1;     // Catch: Throwable -> L22
        goto L5
    L12:
        ArrayList r3 = new ArrayList(instance().mAliveActivities.entrySet());     // Catch: Throwable -> L22
        Collections.sort(r3, new AnonymousClass1());     // Catch: Throwable -> L22
        JSONArray r4 = new JSONArray();     // Catch: Throwable -> L22
        Iterator r5 = r3.iterator();     // Catch: Throwable -> L22
    L15:
        if (r5.hasNext() == false) goto L17;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L22
        r7.put(NAME, ((ActivityRecord) ZeusTransformUtils.preCheckCast(r6.getValue(), ActivityRecord.class, "com.obric.memorydata.plugin")).mActivityName);     // Catch: Throwable -> L22
        r7.put("time", ((ActivityRecord) ZeusTransformUtils.preCheckCast(r6.getValue(), ActivityRecord.class, "com.obric.memorydata.plugin")).mCreatedMillis);     // Catch: Throwable -> L22
        r4.put(r7);     // Catch: Throwable -> L22
        goto L15
    L17:
        r0.put(ACTIVITY_ALIVE, r4);     // Catch: Throwable -> L22
        Object r8 = new JSONArray();     // Catch: Throwable -> L22
        int r9 = instance().mDestroyedActivities.size() - 1;     // Catch: Throwable -> L22
    L18:
        if (r9 < 0) goto L20;
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L22
        r11.put(NAME, ((ActivityRecord) ZeusTransformUtils.preCheckCast(instance().mDestroyedActivities.get(r9), ActivityRecord.class, "com.obric.memorydata.plugin")).mActivityName);     // Catch: Throwable -> L22
        r11.put("time", ((ActivityRecord) ZeusTransformUtils.preCheckCast(instance().mDestroyedActivities.get(r9), ActivityRecord.class, "com.obric.memorydata.plugin")).mCurrentMillis);     // Catch: Throwable -> L22
        r9 = r9 - 1;     // Catch: Throwable -> L22
        goto L18
    L20:
        r0.put(ACTIVITY_FINISH, r8);     // Catch: Throwable -> L22
        r10.put(ACTIVITY_TRACE, r0);     // Catch: Throwable -> L22
        return;
    }

    public static void loadActivityTrack(JSONObject r5) {
        JSONArray r0 = new JSONArray();
        Iterator r1 = new ArrayList(instance().mLifecycleTracePool).iterator();     // Catch: Exception -> L9
    L5:
        if (r1.hasNext() == false) goto L7;
        r0.put(LifecycleTrace.access$1100((LifecycleTrace) ZeusTransformUtils.preCheckCast(r1.next(), LifecycleTrace.class, "com.obric.memorydata.plugin")));     // Catch: Exception -> L9
        goto L5
    L7:
        CustomLong.add(r5, ACTIVITY_TRACK, r0);     // Catch: Exception -> L9
        return;
    }

    public static void markFirstLaunch() {
        sFirstLaunch = true;
    }

    private void recordActivityLife(final String r9, final long r10, final String r12, final int r13) {
        DefaultWorkThread.post(new AnonymousClass3(this, r9, r12, r13, r10));
    }

    private void recordLifecycle(int r9, Activity r10) {
        Activity r11 = (Activity) ZeusTransformUtils.wrapperContextForParams(r10, Activity.class, "com.obric.memorydata.plugin");
        long r2 = System.currentTimeMillis();
        int r0 = r11.hashCode();
        ActivityRecord r1 = (ActivityRecord) ZeusTransformUtils.preCheckCast(this.mAliveActivities.get(Integer.valueOf(r0)), ActivityRecord.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L8;
        long r4 = 0;
        if (r9 != 0) goto L7;
        r4 = r2;
    L7:
        r1 = new ActivityRecord(getActivityName(r11), r4, r0);
        this.mAliveActivities.put(Integer.valueOf(r0), r1);
    L8:
        r1.changeState(r9, r2);
        if (ProcessTracker.getInstance().isEnable() == false) goto L11;
        recordActivityLife(r1.mActivityName, r1.mCreatedMillis, getTrackMethodName(r9), r11.hashCode());
    L11:
        writeLifecycleTrace(r1);
        ActivityStateRecord[] r12 = this.mLastStates;
        if (r12[r9] != null) goto L14;
        r12[r9] = new ActivityStateRecord();
    L14:
        this.mLastStates[r9].mActivity = r1;
        ActivityStateRecord r13 = this.mLastStates[r9];
        r13.mTime = r1.mCurrentMillis;
        if (r9 != 5) goto L21;
        this.mAliveActivities.remove(Integer.valueOf(r1.mHashCode));
        if (this.mDestroyedActivities.size() != 20) goto L19;
        this.mDestroyedActivities.remove(19);
    L19:
        this.mDestroyedActivities.add(r1);
        return;
    }

    public static void setCustomActivity(CustomActivity r2) {
        instance().mCustomActivity = (CustomActivity) ZeusTransformUtils.wrapperContextForParams(r2, CustomActivity.class, "com.obric.memorydata.plugin");
    }

    public static void start() {
        instance();
    }

    void writeLifecycleTrace(ActivityRecord r4) {
        if (this.mLifecycleTracePool.size() < 50) goto L5;
        LifecycleTrace r0 = (LifecycleTrace) ZeusTransformUtils.preCheckCast(this.mLifecycleTracePool.poll(), LifecycleTrace.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 != null) goto L8;
        r0 = new LifecycleTrace();
    L8:
        this.mLifecycleTracePool.add(r0);
        r0.copyFrom(r4);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
