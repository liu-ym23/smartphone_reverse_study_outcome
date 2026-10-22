package com.bytedance.crash.config;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class NpthBuildConfig {
    public static String VERSION_NAME;

    static {
        String r10 = reviseVersionName("4.2.2-rc.4-pico", "cnNoasanInnerFull".toLowerCase());
        if (TextUtils.isEmpty(r10) == true) goto L5;
        VERSION_NAME = r10;
        return;
    L5:
        VERSION_NAME = "4.2.2-rc.4-pico";
    }

    public NpthBuildConfig() {
    }

    public static String extractVersionNumber(String r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r11 = 1;
        if (Character.isDigit(r10.charAt(r10.length() - 1)) == false) goto L8;
        return r10;
    L8:
        StringBuilder r12 = new StringBuilder();
        char r13 = r10.charAt(0);
    L10:
        if (r11 >= r10.length()) goto L17;
        char r14 = r10.charAt(r11);
        if (Character.isDigit(r10.charAt(r11)) == true) goto L15;
        if (r14 != '.') goto L17;
    L15:
        r12.append(r13);
        r11 = r11 + 1;
        r13 = r14;
    L17:
        return r12.toString();
    }

    public static String reviseVersionName(String r10, String r11) {
        String[] r12 = r10.split("-");     // Catch: Throwable -> L17
        String r13 = "";
        if (r12.length != 2) goto L6;
        r13 = r10.split("-")[1];     // Catch: Throwable -> L17
    L6:
        String r14 = extractVersionNumber(r12[0]);     // Catch: Throwable -> L17
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L17
        r15.append(r14);     // Catch: Throwable -> L17
        if (r11.contains("oversea") == false) goto L10;
        r15.append(".oversea");     // Catch: Throwable -> L17
    L10:
        if (r11.contains("lite") == false) goto L13;
        r15.append(".lite");     // Catch: Throwable -> L17
    L13:
        if (TextUtils.isEmpty(r13) == true) goto L15;
        r15.append("-");     // Catch: Throwable -> L17
        r15.append(r13);     // Catch: Throwable -> L17
    L15:
        return r15.toString();
    L17:
        th = move-exception;
        Log.e("NpthBuildConfig", th.toString(), th);
        return null;
    }
}
