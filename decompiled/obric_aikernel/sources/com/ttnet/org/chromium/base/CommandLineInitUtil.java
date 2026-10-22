package com.ttnet.org.chromium.base;

import android.content.Context;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.ttnet.org.chromium.base.supplier.Supplier;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class CommandLineInitUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String COMMAND_LINE_FILE_PATH = "/data/local";
    private static final String COMMAND_LINE_FILE_PATH_DEBUG_APP = "/data/local/tmp";

    static {
    }

    private CommandLineInitUtil() {
    }

    private static String getDebugApp(Context r10) {
        boolean r11 = false;
        if (Settings.Global.getInt(r10.getContentResolver(), "adb_enabled", 0) != 1) goto L5;
        r11 = true;
    L5:
        if (r11 == true) goto L7;
        return null;
    L7:
        return Settings.Global.getString(r10.getContentResolver(), "debug_app");
    }

    public static void initCommandLine(String r10) {
        initCommandLine(r10, null);
    }

    public static void initCommandLine(String r10, @Nullable Supplier<Boolean> r11) {
        File r12 = new File(COMMAND_LINE_FILE_PATH_DEBUG_APP, r10);
        if (r12.exists() == true) goto L5;
    L6:
        r12 = new File(COMMAND_LINE_FILE_PATH, r10);
    L7:
        CommandLine.initFromFile(r12.getPath());
        return;
    L5:
        if (shouldUseDebugCommandLine(r11) == true) goto L7;
        goto L6
    }

    private static boolean shouldUseDebugCommandLine(@Nullable Supplier<Boolean> r10) {
        if (r10 != null) goto L5;
    L7:
        Context r11 = ContextUtils.getApplicationContext();
        if (r11.getPackageName().equals(getDebugApp(r11)) == false) goto L10;
        return true;
    L10:
        if (BuildInfo.isDebugAndroid() == true) goto L15;
        return false;
    L15:
        return true;
    L5:
        if (r10.get().booleanValue() == false) goto L7;
        return true;
    }
}
