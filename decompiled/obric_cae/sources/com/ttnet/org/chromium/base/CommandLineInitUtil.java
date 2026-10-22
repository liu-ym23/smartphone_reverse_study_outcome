package com.ttnet.org.chromium.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class CommandLineInitUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String COMMAND_LINE_FILE_PATH = "/data/local";
    private static final String COMMAND_LINE_FILE_PATH_DEBUG_APP = "/data/local/tmp";

    private CommandLineInitUtil() {
    }

    @SuppressLint({"NewApi"})
    private static String getDebugAppJBMR1(Context r8) {
        boolean r10 = false;
        if (Settings.Global.getInt(r8.getContentResolver(), "adb_enabled", 0) != 1) goto L5;
        r10 = true;
    L5:
        if (r10 == true) goto L7;
        return null;
    L7:
        return Settings.Global.getString(r8.getContentResolver(), "debug_app");
    }

    private static String getDebugAppPreJBMR1(Context r8) {
        boolean r10 = false;
        if (Settings.System.getInt(r8.getContentResolver(), "adb_enabled", 0) != 1) goto L5;
        r10 = true;
    L5:
        if (r10 == true) goto L7;
        return null;
    L7:
        return Settings.System.getString(r8.getContentResolver(), "debug_app");
    }

    public static void initCommandLine(String r8) {
        initCommandLine(r8, null);
    }

    private static boolean shouldUseDebugCommandLine(Supplier<Boolean> r8) {
        if (r8 != null) goto L5;
    L7:
        Context r10 = ContextUtils.getApplicationContext();
        String r11 = getDebugAppJBMR1(r10);
        if (r10.getPackageName().equals(r11) == false) goto L10;
        return true;
    L10:
        if (BuildInfo.isDebugAndroid() == true) goto L15;
        return false;
    L15:
        return true;
    L5:
        if (r8.get().booleanValue() == false) goto L7;
        return true;
    }

    public static void initCommandLine(String r8, Supplier<Boolean> r10) {
        File r11 = new File(COMMAND_LINE_FILE_PATH_DEBUG_APP, r8);
        if (r11.exists() == true) goto L5;
    L6:
        r11 = new File(COMMAND_LINE_FILE_PATH, r8);
    L7:
        CommandLine.initFromFile(r11.getPath());
        return;
    L5:
        if (shouldUseDebugCommandLine(r10) == true) goto L7;
        goto L6
    }
}
