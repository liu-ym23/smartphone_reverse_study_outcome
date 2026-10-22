package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes2.dex */
public class AppActivityResumeSuspendRecorder {
    private static volatile long sAppActivityResumeState = 0;
    private static volatile boolean sAppActivityResumed = false;

    static {
    }

    public AppActivityResumeSuspendRecorder() {
    }

    public static long GetAppActivityResumeState() {
        return sAppActivityResumeState;
    }

    public static void OnAppActivitySuspend() {
        if (sAppActivityResumed == false) goto L6;
        sAppActivityResumed = false;
        sAppActivityResumeState++;
        return;
    }

    public static void OnAppActiviyResume() {
        if (sAppActivityResumed == true) goto L6;
        sAppActivityResumed = true;
        sAppActivityResumeState++;
        return;
    }
}
