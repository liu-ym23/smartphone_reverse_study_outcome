package com.bytedance.apm.agent.instrumentation;

import androidx.annotation.Keep;
import f.a;
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

    static {
    }

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
    public static void launcherActivityOnCreateStart(String r10) {
        if (launcherActivityCreateStartTime != 0) goto L8;
        long r11 = System.currentTimeMillis();
        launcherActivityCreateStartTime = r11;
        if ((r11 - onCreateEndTime) >= 800) goto L9;
        isValid = true;
        launcherActivityName = r10;
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
    public static void launcherActivityOnResumeStart(String r10) {
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
    public static void launcherActivityOnWindowFocusChangedStart(String r10) {
        if (launcherActivityOnWindowFocusChangedTime == 0) goto L5;
        return;
    L5:
        if (onCreateStartTime > 0) goto L7;
        return;
    L7:
        if (isValid == false) goto L20;
        long r11 = System.currentTimeMillis();
        launcherActivityOnWindowFocusChangedTime = r11;
        long r12 = r11 - constructorStartTime;
        if (r12 > 0) goto L11;
        return;
    L11:
        if (r12 >= 15000) goto L22;
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L15
        r13.put("application_constructor", constructorEndTime - constructorStartTime);     // Catch: Exception -> L15
        r13.put("application_attachBaseContext", attachBaseContextEndTime - attachBaseContextStartTime);     // Catch: Exception -> L15
        r13.put("application_onCreate", onCreateEndTime - onCreateStartTime);     // Catch: Exception -> L15
        r13.put("launcher_activity_onCreate", launcherActivityCreateEndTime - launcherActivityCreateStartTime);     // Catch: Exception -> L15
        r13.put("launcher_activity_onResume", launcherActivityResumeEndTime - launcherActivityResumeStartTime);     // Catch: Exception -> L15
        r13.put("app_to_first_activity_windowfocus", r12);     // Catch: Exception -> L15
        r13.put("app_to_first_activity_windowfocus#" + launcherActivityName, r12);     // Catch: Exception -> L15
        r13.put("launcher_activity_onCreate#" + launcherActivityName, launcherActivityCreateEndTime - launcherActivityCreateStartTime);     // Catch: Exception -> L15
        r13.put("launcher_activity_onResume#" + launcherActivityName, launcherActivityResumeEndTime - launcherActivityResumeStartTime);     // Catch: Exception -> L15
        a.b(r13, constructorStartTime, launcherActivityResumeEndTime);     // Catch: Exception -> L15
    L13:
        onCreateStartTime = 0;
        isValid = false;
        return;
    L22:
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
