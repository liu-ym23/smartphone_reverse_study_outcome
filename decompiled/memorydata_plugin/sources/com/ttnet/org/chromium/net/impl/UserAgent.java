package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.ttnet.org.chromium.net.TTNetVersion;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public final class UserAgent {
    private static final int VERSION_CODE_UNINITIALIZED = 0;
    private static final Object sLock = null;
    private static int sVersionCode;

    static {
        sLock = new Object();
    }

    private UserAgent() {
    }

    private static void appendCronetVersion(StringBuilder r1) {
        r1.append(" Cronet/");
        r1.append(TTNetVersion.VERSION);
    }

    public static String from(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        r0.append(r4.getPackageName());
        r0.append('/');
        r0.append(versionFromContext(r4));
        r0.append(" (Linux; U; Android ");
        r0.append(Build.VERSION.RELEASE);
        r0.append("; ");
        r0.append(Locale.getDefault().toString());
        String r1 = Build.MODEL;
        if (r1.length() <= 0) goto L5;
        r0.append("; ");
        r0.append(r1);
    L5:
        String r5 = Build.ID;
        if (r5.length() <= 0) goto L8;
        r0.append("; Build/");
        r0.append(r5);
    L8:
        r0.append(";");
        appendCronetVersion(r0);
        r0.append(')');
        return r0.toString();
    }

    static String getQuicUserAgentIdFrom(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        r0.append(r3.getPackageName());
        appendCronetVersion(r0);
        return r0.toString();
    }

    private static int versionFromContext(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Object r0 = sLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sVersionCode == 0) goto L18;
    L9:
        int r5 = sVersionCode;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r5;
    L18:
        sVersionCode = r4.getPackageManager().getPackageInfo(r4.getPackageName(), 0).versionCode;     // Catch: PackageManager.NameNotFoundException -> L15 Throwable -> L12
        goto L9
    }
}
