package com.bytedance.crash.config;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class NpthBuildConfig {
    public static String VERSION_NAME;

    static {
        String r0 = reviseVersionName("4.2.2-rc.4-pico", "cnNoasanInnerFull".toLowerCase());
        if (TextUtils.isEmpty(r0) == true) goto L5;
        VERSION_NAME = r0;
        return;
    L5:
        VERSION_NAME = "4.2.2-rc.4-pico";
    }

    public NpthBuildConfig() {
    }

    public static String extractVersionNumber(String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r1 = 1;
        if (Character.isDigit(r5.charAt(r5.length() - 1)) == false) goto L8;
        return r5;
    L8:
        StringBuilder r0 = new StringBuilder();
        char r2 = r5.charAt(0);
    L10:
        if (r1 >= r5.length()) goto L17;
        char r3 = r5.charAt(r1);
        if (Character.isDigit(r5.charAt(r1)) == true) goto L15;
        if (r3 != '.') goto L17;
    L15:
        r0.append(r2);
        r1 = r1 + 1;
        r2 = r3;
    L17:
        return r0.toString();
    }

    public static String reviseVersionName(String r5, String r6) {
        String[] r1 = r5.split("-");     // Catch: Throwable -> L17
        String r2 = "";
        if (r1.length != 2) goto L6;
        r2 = r5.split("-")[1];     // Catch: Throwable -> L17
    L6:
        String r7 = extractVersionNumber(r1[0]);     // Catch: Throwable -> L17
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L17
        r3.append(r7);     // Catch: Throwable -> L17
        if (r6.contains("oversea") == false) goto L10;
        r3.append(".oversea");     // Catch: Throwable -> L17
    L10:
        if (r6.contains("lite") == false) goto L13;
        r3.append(".lite");     // Catch: Throwable -> L17
    L13:
        if (TextUtils.isEmpty(r2) == true) goto L15;
        r3.append("-");     // Catch: Throwable -> L17
        r3.append(r2);     // Catch: Throwable -> L17
    L15:
        return r3.toString();
    L17:
        th = move-exception;
        Log.e("NpthBuildConfig", th.toString(), th);
        return null;
    }
}
