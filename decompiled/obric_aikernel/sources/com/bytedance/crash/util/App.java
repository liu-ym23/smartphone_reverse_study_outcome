package com.bytedance.crash.util;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.crash.Global;
import java.io.FileInputStream;

/* JADX INFO: loaded from: classes.dex */
public final class App {
    private static String sCurProcessName;

    public App() {
    }

    public static String getCurProcessName() {
        String r10 = sCurProcessName;
        if (r10 != null) goto L7;
        return "";
    L7:
        return r10;
    }

    @NonNull
    public static String getCurProcessName(Context r10) {
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L5;
        String r11 = getProcessNameFromCmdline();
        sCurProcessName = r11;
        if (r11 != null) goto L10;
        return "";
    L10:
        return r11;
    L5:
        return sCurProcessName;
    }

    @NonNull
    public static String getProcessName() {
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L6;
        sCurProcessName = getProcessNameFromCmdline();
    L6:
        return sCurProcessName;
    }

    @NonNull
    private static String getProcessNameFromCmdline() {
        StringBuilder r10 = new StringBuilder();
        FileInputStream r11 = null;
        FileInputStream r12 = new FileInputStream("/proc/self/cmdline");     // Catch: Throwable -> L21 Exception -> L27
        goto L24
    L30:
        byte[] r13 = new byte[64];     // Catch: Throwable -> L18 Exception -> L20
    L6:
        int r14 = 0;
        int r15 = r12.read(r13, 0, 64);     // Catch: Throwable -> L18 Exception -> L20
    L7:
        if (r14 >= r15) goto L16;
        char r16 = (char) r13[r14];     // Catch: Throwable -> L18 Exception -> L20
        if (r16 == 0) goto L15;
        if (r16 == '\n') goto L15;
        r10.append(r16);     // Catch: Throwable -> L18 Exception -> L20
        r14 = r14 + 1;
        goto L7
    L15:
        r15 = -1;
    L16:
        if (r15 > 0) goto L6;
        FileSystemUtils.close(r12);
    L26:
        return r10.toString();
    L20:
        r11 = r12;
    L18:
        th = th;
        r11 = r12;
    L22:
        FileSystemUtils.close(r11);
        throw th;
    L21:
        th = th;
    L24:
        FileSystemUtils.close(r11);
        goto L26
    }

    public static boolean isMainProcess() {
        return isMainProcess(Global.getContext());
    }

    public static boolean isMainProcess(Context r10) {
        return isMainProcess(r10, getProcessName());
    }

    public static boolean isMainProcess(Context r10, String r11) {
        if (r11 != null) goto L6;
        return false;
    L6:
        if (r11.contains(":") == false) goto L8;
        return false;
    L8:
        if (r10 != null) goto L10;
        r10 = Global.getContext();
    L10:
        if (r10 != null) goto L13;
        return false;
    L13:
        if (r11.equals(r10.getPackageName()) == false) goto L17;
        return true;
    L17:
        return r11.equals(r10.getApplicationInfo().processName);
    }

    public static void setCurProcessName(String r10) {
        sCurProcessName = r10;
    }
}
