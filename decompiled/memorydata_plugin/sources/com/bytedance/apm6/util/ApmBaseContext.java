package com.bytedance.apm6.util;

import android.app.Application;
import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ApmBaseContext {
    private static Application context = null;
    private static boolean debugMode = false;
    private static boolean systraceMode = false;

    static {
    }

    public ApmBaseContext() {
    }

    private static Application getApplication(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, Application.class) == true) goto L11;
        r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L11:
        return (Application) ZeusTransformUtils.preCheckCast(r3, Application.class, "com.obric.memorydata.plugin");
    }

    public static Application getContext() {
        return context;
    }

    public static boolean isDebugMode() {
        if (debugMode == true) goto L5;
    L7:
        return false;
    L5:
        if (systraceMode == true) goto L7;
        return true;
    }

    public static boolean isSystraceMode() {
        return systraceMode;
    }

    public static void setContext(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        context = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplication(r3), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        return;
    }

    public static void setDebugMode(boolean r0) {
        debugMode = r0;
    }

    public static void setSystraceMode(boolean r0) {
        systraceMode = r0;
    }
}
