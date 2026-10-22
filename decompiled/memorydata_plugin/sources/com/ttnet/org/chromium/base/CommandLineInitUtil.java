package com.ttnet.org.chromium.base;

import android.content.Context;
import android.provider.Settings;
import com.ttnet.org.chromium.base.supplier.Supplier;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public final class CommandLineInitUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String COMMAND_LINE_FILE_PATH = "/data/local";
    private static final String COMMAND_LINE_FILE_PATH_DEBUG_APP = "/data/local/tmp";

    static {
    }

    private CommandLineInitUtil() {
    }

    private static String getDebugApp(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (Settings.Global.getInt(r4.getContentResolver(), "adb_enabled", 0) != 1) goto L5;
        r2 = true;
    L5:
        if (r2 == true) goto L7;
        return null;
    L7:
        return Settings.Global.getString(r4.getContentResolver(), "debug_app");
    }

    public static void initCommandLine(String r1) {
        initCommandLine(r1, null);
    }

    public static void initCommandLine(String r2, Supplier<Boolean> r3) {
        Supplier r4 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r3, Supplier.class, "com.obric.memorydata.plugin");
        File r0 = new File(COMMAND_LINE_FILE_PATH_DEBUG_APP, r2);
        if (r0.exists() == true) goto L5;
    L6:
        r0 = new File(COMMAND_LINE_FILE_PATH, r2);
    L7:
        CommandLine.initFromFile(r0.getPath());
        return;
    L5:
        if (shouldUseDebugCommandLine(r4) == true) goto L7;
        goto L6
    }

    private static boolean shouldUseDebugCommandLine(Supplier<Boolean> r3) {
        Supplier r4 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r3, Supplier.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
    L7:
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r5.getPackageName().equals(getDebugApp(r5)) == false) goto L10;
        return true;
    L10:
        if (BuildInfo.isDebugAndroid() == true) goto L15;
        return false;
    L15:
        return true;
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4.get(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        return true;
    }
}
