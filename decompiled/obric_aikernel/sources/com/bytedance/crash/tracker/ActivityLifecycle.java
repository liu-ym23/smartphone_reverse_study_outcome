package com.bytedance.crash.tracker;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.crash.Flavor;
import com.bytedance.crash.Global;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.dumper.tools.JsonDumper;
import com.bytedance.crash.entity.CustomLong;
import com.bytedance.crash.outer.CustomActivity;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.tracker.fragment.FragmentLifeManager;
import com.bytedance.crash.util.DateUtils;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
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

/* JADX INFO: loaded from: classes.dex */
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

        ActivityLifecycleCallbacks(ActivityLifecycle r10) {
            this.this$0 = r10;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity r10, @Nullable Bundle r11) {
            if (r11 == null) goto L5;
            boolean r12 = true;
        L6:
            ActivityLifecycle.access$002(r12);
            ActivityLifecycle.access$100(this.this$0, 0, r10);
            ActivityLifecycle.access$202(true);
            ActivityLifecycle.access$300(this.this$0).add(new WeakReference(r10));
            FragmentLifeManager.register(r10);
            return;
        L5:
            r12 = false;
            goto L6
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity r10) {
            ActivityLifecycle.access$100(this.this$0, 5, r10);
            FragmentLifeManager.unregister(r10);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity r10) {
            ActivityLifecycle r11 = this.this$0;
            if (ActivityLifecycle.access$400(r11) != null) goto L5;
            String r12 = r10.getClass().getName();
        L6:
            ActivityLifecycle.access$1002(r11, r12);
            ActivityLifecycle.access$510(this.this$0);
            if (ActivityLifecycle.access$500(this.this$0) != 0) goto L10;
        L8:
            ActivityLifecycle.access$602(this.this$0, false);
            ActivityLifecycle.access$202(false);
        L12:
            ActivityLifecycle.access$100(this.this$0, 3, r10);
            return;
        L10:
            if (ActivityLifecycle.access$500(this.this$0) >= 0) goto L12;
            ActivityLifecycle.access$502(this.this$0, 0);
            goto L8
        L5:
            r12 = ActivityLifecycle.access$400(this.this$0).getActivityName(r10);
            goto L6
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity r10) {
            ActivityLifecycle.access$100(this.this$0, 2, r10);
            if (ActivityLifecycle.access$400(this.this$0) != null) goto L5;
            String r11 = r10.getClass().getName();
        L6:
            long r12 = System.currentTimeMillis();
            ActivityLifecycle.access$508(this.this$0);
            if (ActivityLifecycle.access$600(this.this$0) == true) goto L24;
            ActivityLifecycle.access$602(this.this$0, true);
            if (ActivityLifecycle.access$700() == false) goto L12;
            ActivityLifecycle.access$702(false);
            ActivityLifecycle.access$802(1);
            ActivityLifecycle.access$902(r12);
        L12:
            if (r11.equals(ActivityLifecycle.access$1000(this.this$0)) == true) goto L15;
            return;
        L15:
            if (ActivityLifecycle.access$200() == false) goto L20;
            if (ActivityLifecycle.access$000() == true) goto L20;
            int r13 = 4;
        L22:
            ActivityLifecycle.access$802(r13);
            ActivityLifecycle.access$902(r12);
            return;
        L20:
            if (ActivityLifecycle.access$200() == true) goto L25;
            r13 = 3;
            goto L22
        L25:
            return;
        L24:
            return;
        L5:
            r11 = ActivityLifecycle.access$400(this.this$0).getActivityName(r10);
            goto L6
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity r10, @NonNull Bundle r11) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity r10) {
            ActivityLifecycle.access$100(this.this$0, 1, r10);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity r10) {
            ActivityLifecycle.access$100(this.this$0, 4, r10);
        }
    }

    private static class ActivityRecord {
        String mActivityName;
        long mCreatedMillis;
        long mCurrentMillis;
        int mCurrentState;
        int mHashCode;

        public ActivityRecord(String r10, long r11, int r12) {
            this.mActivityName = r10;
            this.mHashCode = r12;
            this.mCreatedMillis = r11;
        }

        public void changeState(int r10, long r11) {
            this.mCurrentState = r10;
            this.mCurrentMillis = r11;
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

        static /* synthetic */ String access$1100(LifecycleTrace r10) {
            return r10.formatWithTime();
        }

        static /* synthetic */ String access$1200(String r10) {
            return formatLine(r10);
        }

        static /* synthetic */ void access$1300(LifecycleTrace r10, StringBuilder r11) {
            r10.appendLine(r11);
        }

        private void appendLine(StringBuilder r10) {
            r10.append(this.mMillis);
            r10.append(' ');
            r10.append(this.mRecord.mActivityName);
            r10.append(' ');
            r10.append(this.mRecord.mHashCode);
            r10.append(' ');
            r10.append(this.mState);
            r10.append('\n');
        }

        private static String format(long r10, String r11, int r12, int r13) {
            return DateUtils.formatDate(r10) + " : " + r11 + '.' + ActivityLifecycle.access$1400()[r13] + '@' + Long.toHexString(r12);
        }

        private static String formatLine(String r10) {
            String[] r11 = r10.split(" ");
            if (r11.length == 4) goto L14;
            return null;
        L14:
            long r12 = Long.parseLong(r11[0]);     // Catch: Exception -> L13
            String r13 = r11[1];     // Catch: Exception -> L13
            int r14 = Integer.parseInt(r11[2]);     // Catch: Exception -> L13
            int r15 = Integer.parseInt(r11[3]);     // Catch: Exception -> L13
            if (r15 < 0) goto L12;
            if (r15 >= ActivityLifecycle.access$1400().length) goto L12;
            return format(r12, r13, r14, r15);
        L12:
            return null;
        }

        private String formatWithTime() {
            long r10 = this.mMillis;
            ActivityRecord r11 = this.mRecord;
            return format(r10, r11.mActivityName, r11.mHashCode, this.mState);
        }

        void copyFrom(ActivityRecord r10) {
            this.mRecord = r10;
            this.mMillis = r10.mCurrentMillis;
            this.mState = r10.mCurrentState;
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
        Application r10 = Global.getApplication();
        if (Build.VERSION.SDK_INT < 24) goto L6;
        if (r10 == null) goto L6;
        r10.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks(this));
    L6:
        Flavor.setActivityImpl();
    }

    static /* synthetic */ boolean access$000() {
        return isRestore;
    }

    static /* synthetic */ boolean access$002(boolean r10) {
        isRestore = r10;
        return r10;
    }

    static /* synthetic */ void access$100(ActivityLifecycle r10, int r11, Activity r12) {
        r10.recordLifecycle(r11, r12);
    }

    static /* synthetic */ String access$1000(ActivityLifecycle r10) {
        return r10.mLastPauseActivity;
    }

    static /* synthetic */ String access$1002(ActivityLifecycle r10, String r11) {
        r10.mLastPauseActivity = r11;
        return r11;
    }

    static /* synthetic */ String[] access$1400() {
        return METHOD_NAMES;
    }

    static /* synthetic */ boolean access$200() {
        return isWalkOnCreate;
    }

    static /* synthetic */ boolean access$202(boolean r10) {
        isWalkOnCreate = r10;
        return r10;
    }

    static /* synthetic */ ArrayList access$300(ActivityLifecycle r10) {
        return r10.mActivitiesCache;
    }

    static /* synthetic */ CustomActivity access$400(ActivityLifecycle r10) {
        return r10.mCustomActivity;
    }

    static /* synthetic */ int access$500(ActivityLifecycle r10) {
        return r10.mActivityNum;
    }

    static /* synthetic */ int access$502(ActivityLifecycle r10, int r11) {
        r10.mActivityNum = r11;
        return r11;
    }

    static /* synthetic */ int access$508(ActivityLifecycle r10) {
        int r11 = r10.mActivityNum;
        r10.mActivityNum = r11 + 1;
        return r11;
    }

    static /* synthetic */ int access$510(ActivityLifecycle r10) {
        int r11 = r10.mActivityNum;
        r10.mActivityNum = r11 - 1;
        return r11;
    }

    static /* synthetic */ boolean access$600(ActivityLifecycle r10) {
        return r10.mIsForeground;
    }

    static /* synthetic */ boolean access$602(ActivityLifecycle r10, boolean r11) {
        r10.mIsForeground = r11;
        return r11;
    }

    static /* synthetic */ boolean access$700() {
        return isClodLaunch;
    }

    static /* synthetic */ boolean access$702(boolean r10) {
        isClodLaunch = r10;
        return r10;
    }

    static /* synthetic */ int access$802(int r10) {
        sLaunchMode = r10;
        return r10;
    }

    static /* synthetic */ long access$902(long r10) {
        sLaunchTime = r10;
        return r10;
    }

    public static void dump(File r10) {
        if (isBackground() == false) goto L6;
        FileSystemUtils.createFile(r10, "background");
    L6:
        if (isBackgroundV2() == false) goto L8;
        FileSystemUtils.createFile(r10, "background_v2");
    L8:
        instance().dumpTrace(r10);
        instance().dumpTrack(r10);
        FragmentLifeManager.dump(r10);
    }

    private void dumpTrace(File r11) {
        JsonDumper r10 = new JsonDumper(r11.getAbsolutePath() + "/" + ACTIVITY_TRACE + ".json");
        r10.objectBegin();
        r10.key(ACTIVITY_TRACE);
        r10.objectBegin();
        int r12 = 0;
    L4:
        if (r12 >= 6) goto L11;
        ActivityStateRecord[] r13 = this.mLastStates;
        if (r13[r12] == null) goto L10;
        if (r13[r12].mActivity == null) goto L10;
        r10.key(JSON_TAGS[r12]);
        r10.objectBegin();
        r10.key(NAME).value(this.mLastStates[r12].mActivity.mActivityName).next();
        r10.key("time").value(this.mLastStates[r12].mTime);
        r10.objectEnd();
        r10.next();
    L10:
        r12 = r12 + 1;
        goto L4
    L11:
        r10.key(ACTIVITY_ALIVE);
        r10.arrayBegin();
        ArrayList r14 = new ArrayList(this.mAliveActivities.entrySet());
        Collections.sort(r14, new AnonymousClass2(this));
        Iterator r15 = r14.iterator();
        boolean r16 = true;
    L13:
        if (r15.hasNext() == false) goto L19;
        Map.Entry r17 = (Map.Entry) r15.next();
        if (r16 == false) goto L17;
        r16 = false;
    L18:
        r10.objectBegin();
        r10.key(NAME).value(((ActivityRecord) r17.getValue()).mActivityName).next();
        r10.key("time").value(((ActivityRecord) r17.getValue()).mCreatedMillis);
        r10.objectEnd();
        goto L13
    L17:
        r10.next();
        goto L18
    L19:
        r10.arrayEnd().next();
        r10.key(ACTIVITY_FINISH);
        r10.arrayBegin();
        int r18 = this.mDestroyedActivities.size() - 1;
    L20:
        if (r18 < 0) goto L25;
        r10.objectBegin();
        r10.key(NAME).value(this.mDestroyedActivities.get(r18).mActivityName).next();
        r10.key("time").value(this.mDestroyedActivities.get(r18).mCurrentMillis);
        r10.objectEnd();
        if (r18 == 0) goto L24;
        r10.next();
    L24:
        r18 = r18 - 1;
        goto L20
    L25:
        r10.arrayEnd();
        r10.objectEnd();
        r10.objectEnd();
        r10.release();
    }

    private void dumpTrack(File r10) {
        StringBuilder r11 = new StringBuilder();
        Iterator<LifecycleTrace> r12 = instance().mLifecycleTracePool.iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        LifecycleTrace.access$1300(r12.next(), r11);
        goto L4
    L7:
        if (r11.length() != 0) goto L9;
        return;
    L9:
        FileSystemUtils.writeFile(new File(r10, "activity_track.inf"), r11.toString());
    }

    private String getActivityName(Activity r10) {
        CustomActivity r11 = this.mCustomActivity;
        if (r11 == null) goto L5;
        String r12 = r11.getActivityName(r10);
    L7:
        if (TextUtils.isEmpty(r12) == true) goto L9;
        return r12;
    L9:
        return r10.getClass().getName();
    L5:
        r12 = null;
        goto L7
    }

    public static ArrayList<WeakReference<Activity>> getAllActivities() {
        return instance().mActivitiesCache;
    }

    public static long getBackgroundTimeMs() {
        return instance().getBackgroundTimeMsInner();
    }

    private long getBackgroundTimeMsInner() {
        ArrayList r10 = new ArrayList(this.mAliveActivities.entrySet());
        int r11 = 0;
        long r12 = 0;
    L4:
        if (r11 >= r10.size()) goto L12;
        ActivityRecord r13 = (ActivityRecord) ((Map.Entry) r10.get(r11)).getValue();
        if (r13.mCurrentState < 3) goto L7;
        long r14 = r13.mCurrentMillis;
        if (r12 >= r14) goto L11;
        r12 = r14;
    L11:
        r11 = r11 + 1;
        goto L4
    L7:
        return 0;
    L12:
        return r12;
    }

    @NonNull
    public static String getLastResumeActivity() {
        ActivityStateRecord r10 = instance().mLastStates[2];
        if (r10 == null) goto L8;
        ActivityRecord r11 = r10.mActivity;
        if (r11 != null) goto L7;
        return "null";
    L7:
        return r11.mActivityName;
    L8:
        return "null";
    }

    @Nullable
    public static String getLastResumedActivityFromBody(JSONObject r10) {
        JSONObject r11 = r10.optJSONObject(ACTIVITY_TRACE);
        if (r11 == null) goto L8;
        JSONObject r12 = r11.optJSONObject(JSON_TAGS[2]);
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.optString(NAME);
    L8:
        return null;
    }

    public static int getLaunchMode() {
        int r10 = sLaunchMode;
        if (r10 == 1) goto L5;
        return r10;
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
        JSONArray r10 = new JSONArray();
        Iterator r11 = new ArrayList(instance().mLifecycleTracePool).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.put(LifecycleTrace.access$1100((LifecycleTrace) r11.next()));
        goto L4
    L6:
        return r10;
    }

    private static String getTrackMethodName(int r10) {
        if (r10 != 0) goto L4;
        return "onCreate";
    L4:
        if (r10 != 1) goto L6;
        return "onStart";
    L6:
        if (r10 != 2) goto L8;
        return "onResume";
    L8:
        if (r10 != 3) goto L10;
        return "onPause";
    L10:
        if (r10 != 4) goto L12;
        return "onStop";
    L12:
        if (r10 == 5) goto L15;
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
        Context r10 = Global.getContext();
        if (r10 != null) goto L5;
        return false;
    L5:
        String r11 = r10.getPackageName();
        ActivityManager r12 = (ActivityManager) r10.getSystemService("activity");     // Catch: Throwable -> L21
        if (r12 != null) goto L10;
        return false;
    L10:
        if (Build.VERSION.SDK_INT >= 21) goto L20;
        List<ActivityManager.RunningTaskInfo> r13 = r12.getRunningTasks(1);     // Catch: Throwable -> L21
        if (r13 == null) goto L20;
        if (r13.isEmpty() == true) goto L20;
        ComponentName r14 = r13.get(0).topActivity;     // Catch: Throwable -> L21
        if (r14 == null) goto L20;
        if (r11.equals(r14.getPackageName()) == false) goto L20;
        return true;
    L20:
        return false;
    }

    private boolean isForegroundInner() {
        ArrayList r10 = new ArrayList(this.mAliveActivities.entrySet());
        int r11 = 0;
    L4:
        if (r11 >= r10.size()) goto L10;
        if (((ActivityRecord) ((Map.Entry) r10.get(r11)).getValue()).mCurrentState < 3) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public static void load(@NonNull JSONObject r10, File r11) {
        r10.put(Constants.IS_BACKGROUND, new File(r11, "background").exists());     // Catch: Throwable -> L15
    L3:
        String r12 = FileSystemUtils.readUtf8File(new File(r11, "activity_trace.json"));
        if (r12 == null) goto L25;
        JSONUtils.combineJson(r10, new JSONObject(r12));     // Catch: Throwable -> L16
    L25:
        JSONArray r13 = new JSONArray();     // Catch: IOException -> L17
        BufferedReader r14 = new BufferedReader(new FileReader(new File(r11, "activity_track.inf")));     // Catch: IOException -> L17
    L7:
        String r15 = r14.readLine();     // Catch: IOException -> L17
        if (r15 == null) goto L12;
        String r16 = LifecycleTrace.access$1200(r15);     // Catch: IOException -> L17
        if (r16 == null) goto L7;
        r13.put(r16);     // Catch: IOException -> L17
        goto L7
    L12:
        CustomLong.add(r10, ACTIVITY_TRACK, r13);     // Catch: IOException -> L17
    L21:
        FragmentLifeManager.load(r10, r11);     // Catch: Throwable -> L18
        return;
    }

    public static void loadActivityTrace(JSONObject r10) {
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L21
        int r12 = 0;
    L5:
        if (r12 >= 6) goto L12;
        if (instance().mLastStates[r12] == null) goto L11;
        if (instance().mLastStates[r12].mActivity == null) goto L11;
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L21
        r13.put(NAME, instance().mLastStates[r12].mActivity.mActivityName);     // Catch: Throwable -> L21
        r13.put("time", instance().mLastStates[r12].mTime);     // Catch: Throwable -> L21
        r11.put(JSON_TAGS[r12], r13);     // Catch: Throwable -> L21
    L11:
        r12 = r12 + 1;     // Catch: Throwable -> L21
        goto L5
    L12:
        ArrayList r14 = new ArrayList(instance().mAliveActivities.entrySet());     // Catch: Throwable -> L21
        Collections.sort(r14, new AnonymousClass1());     // Catch: Throwable -> L21
        JSONArray r15 = new JSONArray();     // Catch: Throwable -> L21
        Iterator r16 = r14.iterator();     // Catch: Throwable -> L21
    L14:
        if (r16.hasNext() == false) goto L16;
        Map.Entry r17 = (Map.Entry) r16.next();     // Catch: Throwable -> L21
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L21
        r18.put(NAME, ((ActivityRecord) r17.getValue()).mActivityName);     // Catch: Throwable -> L21
        r18.put("time", ((ActivityRecord) r17.getValue()).mCreatedMillis);     // Catch: Throwable -> L21
        r15.put(r18);     // Catch: Throwable -> L21
        goto L14
    L16:
        r11.put(ACTIVITY_ALIVE, r15);     // Catch: Throwable -> L21
        Object r19 = new JSONArray();     // Catch: Throwable -> L21
        int r20 = instance().mDestroyedActivities.size() - 1;     // Catch: Throwable -> L21
    L17:
        if (r20 < 0) goto L19;
        JSONObject r21 = new JSONObject();     // Catch: Throwable -> L21
        r21.put(NAME, instance().mDestroyedActivities.get(r20).mActivityName);     // Catch: Throwable -> L21
        r21.put("time", instance().mDestroyedActivities.get(r20).mCurrentMillis);     // Catch: Throwable -> L21
        r20 = r20 - 1;     // Catch: Throwable -> L21
        goto L17
    L19:
        r11.put(ACTIVITY_FINISH, r19);     // Catch: Throwable -> L21
        r10.put(ACTIVITY_TRACE, r11);     // Catch: Throwable -> L21
        return;
    }

    public static void loadActivityTrack(JSONObject r10) {
        JSONArray r11 = new JSONArray();
        Iterator r12 = new ArrayList(instance().mLifecycleTracePool).iterator();     // Catch: Exception -> L9
    L5:
        if (r12.hasNext() == false) goto L7;
        r11.put(LifecycleTrace.access$1100((LifecycleTrace) r12.next()));     // Catch: Exception -> L9
        goto L5
    L7:
        CustomLong.add(r10, ACTIVITY_TRACK, r11);     // Catch: Exception -> L9
        return;
    }

    public static void markFirstLaunch() {
        sFirstLaunch = true;
    }

    private void recordActivityLife(final String r10, final long r11, final String r12, final int r13) {
        DefaultWorkThread.post(new AnonymousClass3(this, r10, r12, r13, r11));
    }

    private void recordLifecycle(int r11, Activity r12) {
        long r10 = System.currentTimeMillis();
        int r13 = r12.hashCode();
        ActivityRecord r14 = this.mAliveActivities.get(Integer.valueOf(r13));
        if (r14 != null) goto L8;
        long r15 = 0;
        if (r11 != 0) goto L7;
        r15 = r10;
    L7:
        ActivityRecord r16 = new ActivityRecord(getActivityName(r12), r15, r13);
        this.mAliveActivities.put(Integer.valueOf(r13), r16);
        r14 = r16;
    L8:
        r14.changeState(r11, r10);
        if (ProcessTracker.getInstance().isEnable() == false) goto L11;
        recordActivityLife(r14.mActivityName, r14.mCreatedMillis, getTrackMethodName(r11), r12.hashCode());
    L11:
        writeLifecycleTrace(r14);
        ActivityStateRecord[] r17 = this.mLastStates;
        if (r17[r11] != null) goto L14;
        r17[r11] = new ActivityStateRecord();
    L14:
        ActivityStateRecord[] r18 = this.mLastStates;
        r18[r11].mActivity = r14;
        ActivityStateRecord r19 = r18[r11];
        r19.mTime = r14.mCurrentMillis;
        if (r11 != 5) goto L21;
        this.mAliveActivities.remove(Integer.valueOf(r14.mHashCode));
        if (this.mDestroyedActivities.size() != 20) goto L19;
        this.mDestroyedActivities.remove(19);
    L19:
        this.mDestroyedActivities.add(r14);
        return;
    }

    public static void setCustomActivity(CustomActivity r10) {
        instance().mCustomActivity = r10;
    }

    public static void start() {
        instance();
    }

    void writeLifecycleTrace(ActivityRecord r10) {
        if (this.mLifecycleTracePool.size() < 50) goto L5;
        LifecycleTrace r11 = this.mLifecycleTracePool.poll();
    L6:
        if (r11 != null) goto L8;
        r11 = new LifecycleTrace();
    L8:
        this.mLifecycleTracePool.add(r11);
        r11.copyFrom(r10);
        return;
    L5:
        r11 = null;
        goto L6
    }
}
