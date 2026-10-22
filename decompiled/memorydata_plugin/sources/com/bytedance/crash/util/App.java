package com.bytedance.crash.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crash.Global;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileInputStream;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes2.dex */
public final class App {
    private static String sCurProcessName;

    public App() {
    }

    public static String getCurProcessName() {
        String r0 = sCurProcessName;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0;
    }

    public static String getCurProcessName(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L5;
        String r4 = getProcessNameFromCmdline();
        sCurProcessName = r4;
        if (r4 != null) goto L10;
        return "";
    L10:
        return r4;
    L5:
        return sCurProcessName;
    }

    public static String getProcessName() {
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L6;
        sCurProcessName = getProcessNameFromCmdline();
    L6:
        return sCurProcessName;
    }

    private static String getProcessNameFromCmdline() {
        StringBuilder r0 = new StringBuilder();
        FileInputStream r1 = null;
        FileInputStream r2 = new FileInputStream("/proc/self/cmdline");     // Catch: Throwable -> L21 Exception -> L27
        goto L24
    L30:
        byte[] r3 = new byte[64];     // Catch: Throwable -> L18 Exception -> L20
    L6:
        int r4 = 0;
        int r5 = r2.read(r3, 0, 64);     // Catch: Throwable -> L18 Exception -> L20
    L7:
        if (r4 >= r5) goto L16;
        char r6 = (char) r3[r4];     // Catch: Throwable -> L18 Exception -> L20
        if (r6 == 0) goto L15;
        if (r6 == '\n') goto L15;
        r0.append(r6);     // Catch: Throwable -> L18 Exception -> L20
        r4 = r4 + 1;
        goto L7
    L15:
        r5 = -1;
    L16:
        if (r5 > 0) goto L6;
        FileSystemUtils.close(r2);
    L26:
        return r0.toString();
    L20:
        r1 = r2;
    L18:
        th = th;
        r1 = r2;
    L22:
        FileSystemUtils.close(r1);
        throw th;
    L21:
        th = th;
    L24:
        FileSystemUtils.close(r1);
        goto L26
    }

    public static boolean isMainProcess() {
        return isMainProcess((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    public static boolean isMainProcess(Context r2) {
        return isMainProcess((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), getProcessName());
    }

    public static boolean isMainProcess(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR) == false) goto L8;
        return false;
    L8:
        if (r5 != null) goto L10;
        r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L10:
        if (r5 != null) goto L13;
        return false;
    L13:
        if (r4.equals(r5.getPackageName()) == false) goto L17;
        return true;
    L17:
        return r4.equals(r5.getApplicationInfo().processName);
    }

    public static void setCurProcessName(String r0) {
        sCurProcessName = r0;
    }
}
