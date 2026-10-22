package com.bytedance.apm.agent.instrumentation;

import androidx.annotation.Keep;
import b3.b;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import e2.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class AppInstrumentation {
    private static final String TAG = "AppInstrumentation";
    private static long attachBaseContextEndTime = 0;
    private static long attachBaseContextStartTime = 0;
    private static long constructorEndTime = 0;
    private static long constructorStartTime = 0;
    private static boolean isValid = false;
    private static long launcherActivityCreateEndTime;
    private static long launcherActivityCreateStartTime;
    private static String launcherActivityName;
    private static long launcherActivityOnWindowFocusChangedTime;
    private static long launcherActivityResumeEndTime;
    private static long launcherActivityResumeStartTime;
    private static long onCreateEndTime;
    private static long onCreateStartTime;

    public AppInstrumentation() {
    }

    @Keep
    public static void attachBaseContextEnd() {
        if (attachBaseContextEndTime != 0) goto L6;
        attachBaseContextEndTime = System.currentTimeMillis();
        return;
    }

    @Keep
    public static void attachBaseContextStart() {
        if (attachBaseContextStartTime != 0) goto L6;
        attachBaseContextStartTime = System.currentTimeMillis();
        return;
    }

    @Keep
    public static void initEnd() {
        if (constructorEndTime != 0) goto L6;
        constructorEndTime = System.currentTimeMillis();
        return;
    }

    @Keep
    public static void initStart() {
        if (constructorStartTime != 0) goto L6;
        constructorStartTime = System.currentTimeMillis();
        return;
    }

    @Keep
    public static void launcherActivityOnCreateEnd() {
        if (launcherActivityCreateEndTime == 0) goto L5;
        return;
    L5:
        if (isValid == false) goto L9;
        launcherActivityCreateEndTime = System.currentTimeMillis();
        return;
    }

    @Keep
    public static void launcherActivityOnCreateStart(String r8) {
        if (launcherActivityCreateStartTime != 0) goto L8;
        long r10 = System.currentTimeMillis();
        launcherActivityCreateStartTime = r10;
        if ((r10 - onCreateEndTime) >= 800) goto L9;
        isValid = true;
        launcherActivityName = r8;
        return;
    L9:
        return;
    }

    @Keep
    public static void launcherActivityOnResumeEnd() {
        if (launcherActivityResumeEndTime == 0) goto L5;
        return;
    L5:
        if (isValid == false) goto L9;
        launcherActivityResumeEndTime = System.currentTimeMillis();
        return;
    }

    @Keep
    public static void launcherActivityOnResumeStart(String r8) {
        if (launcherActivityResumeStartTime == 0) goto L5;
        return;
    L5:
        if (isValid == false) goto L9;
        launcherActivityResumeStartTime = System.currentTimeMillis();
        return;
    }

    @Keep
    public static void launcherActivityOnWindowFocusChangedEnd() {
    }

    @Keep
    public static void launcherActivityOnWindowFocusChangedStart(String r12) {
        if (launcherActivityOnWindowFocusChangedTime == 0) goto L5;
        return;
    L5:
        if (onCreateStartTime > 0) goto L7;
        return;
    L7:
        if (isValid == false) goto L27;
        long r8 = System.currentTimeMillis();
        launcherActivityOnWindowFocusChangedTime = r8;
        long r10 = r8 - constructorStartTime;
        if (r10 > 0) goto L11;
        return;
    L11:
        if (r10 >= SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME) goto L29;
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L19
        r11.put("application_constructor", constructorEndTime - constructorStartTime);     // Catch: Exception -> L19
        r11.put("application_attachBaseContext", attachBaseContextEndTime - attachBaseContextStartTime);     // Catch: Exception -> L19
        r11.put("application_onCreate", onCreateEndTime - onCreateStartTime);     // Catch: Exception -> L19
        r11.put("launcher_activity_onCreate", launcherActivityCreateEndTime - launcherActivityCreateStartTime);     // Catch: Exception -> L19
        r11.put("launcher_activity_onResume", launcherActivityResumeEndTime - launcherActivityResumeStartTime);     // Catch: Exception -> L19
        r11.put("app_to_first_activity_windowfocus", r10);     // Catch: Exception -> L19
        r11.put("app_to_first_activity_windowfocus#" + launcherActivityName, r10);     // Catch: Exception -> L19
        r11.put("launcher_activity_onCreate#" + launcherActivityName, launcherActivityCreateEndTime - launcherActivityCreateStartTime);     // Catch: Exception -> L19
        r11.put("launcher_activity_onResume#" + launcherActivityName, launcherActivityResumeEndTime - launcherActivityResumeStartTime);     // Catch: Exception -> L19
        long r13 = constructorStartTime;     // Catch: Exception -> L19
        long r14 = launcherActivityResumeEndTime;     // Catch: Exception -> L19
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L15
        r15.put("begin_time", r13);     // Catch: Exception -> L15
        r15.put("end_time", r14);     // Catch: Exception -> L15
        r15.put("from", "monitor-plugin");     // Catch: Exception -> L15
        b.C0032b.f3038a.c(new c(r11, r15));     // Catch: Exception -> L15
    L20:
        goto L17
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L19
    L17:
        onCreateStartTime = 0;
        isValid = false;
        return;
    L29:
        return;
    }

    @Keep
    public static void onCreateEnd() {
        if (onCreateEndTime != 0) goto L6;
        onCreateEndTime = System.currentTimeMillis();
        return;
    }

    @Keep
    public static void onCreateStart() {
        if (onCreateStartTime != 0) goto L6;
        onCreateStartTime = System.currentTimeMillis();
        return;
    }
}
