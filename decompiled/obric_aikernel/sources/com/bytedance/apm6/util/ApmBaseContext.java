package com.bytedance.apm6.util;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class ApmBaseContext {
    private static Application context = null;
    private static boolean debugMode = false;
    private static boolean systraceMode = false;

    static {
    }

    public ApmBaseContext() {
    }

    private static Application getApplication(Context r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof Application) == true) goto L10;
        r10 = r10.getApplicationContext();
    L10:
        return (Application) r10;
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

    public static void setContext(Context r10) {
        if (r10 == null) goto L5;
        context = getApplication(r10);
        return;
    }

    public static void setDebugMode(boolean r10) {
        debugMode = r10;
    }

    public static void setSystraceMode(boolean r10) {
        systraceMode = r10;
    }
}
