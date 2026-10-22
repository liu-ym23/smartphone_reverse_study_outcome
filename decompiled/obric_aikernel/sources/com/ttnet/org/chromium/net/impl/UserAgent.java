package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.ttnet.org.chromium.net.TTNetVersion;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class UserAgent {
    private static final int VERSION_CODE_UNINITIALIZED = 0;
    private static final Object sLock = null;
    private static int sVersionCode;

    static {
        sLock = new Object();
    }

    private UserAgent() {
    }

    private static void appendCronetVersion(StringBuilder r10) {
        r10.append(" Cronet/");
        r10.append(TTNetVersion.VERSION);
    }

    public static String from(Context r10) {
        StringBuilder r11 = new StringBuilder();
        r11.append(r10.getPackageName());
        r11.append('/');
        r11.append(versionFromContext(r10));
        r11.append(" (Linux; U; Android ");
        r11.append(Build.VERSION.RELEASE);
        r11.append("; ");
        r11.append(Locale.getDefault().toString());
        String r12 = Build.MODEL;
        if (r12.length() <= 0) goto L5;
        r11.append("; ");
        r11.append(r12);
    L5:
        String r13 = Build.ID;
        if (r13.length() <= 0) goto L8;
        r11.append("; Build/");
        r11.append(r13);
    L8:
        r11.append(";");
        appendCronetVersion(r11);
        r11.append(')');
        return r11.toString();
    }

    static String getQuicUserAgentIdFrom(Context r10) {
        StringBuilder r11 = new StringBuilder();
        r11.append(r10.getPackageName());
        appendCronetVersion(r11);
        return r11.toString();
    }

    private static int versionFromContext(Context r10) {
        Object r11 = sLock;
        monitor-enter(r11);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sVersionCode == 0) goto L16;
    L9:
        int r12 = sVersionCode;     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return r12;
    L16:
        sVersionCode = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 0).versionCode;     // Catch: PackageManager.NameNotFoundException -> L15 Throwable -> L12
        goto L9
    }
}
