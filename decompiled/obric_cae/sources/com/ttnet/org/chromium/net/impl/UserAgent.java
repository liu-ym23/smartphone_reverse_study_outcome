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

    private static void appendCronetVersion(StringBuilder r8) {
        r8.append(" Cronet/");
        r8.append(TTNetVersion.VERSION);
    }

    public static String from(Context r8) {
        StringBuilder r10 = new StringBuilder();
        r10.append(r8.getPackageName());
        r10.append('/');
        r10.append(versionFromContext(r8));
        r10.append(" (Linux; U; Android ");
        r10.append(Build.VERSION.RELEASE);
        r10.append("; ");
        r10.append(Locale.getDefault().toString());
        String r11 = Build.MODEL;
        if (r11.length() <= 0) goto L5;
        r10.append("; ");
        r10.append(r11);
    L5:
        String r12 = Build.ID;
        if (r12.length() <= 0) goto L8;
        r10.append("; Build/");
        r10.append(r12);
    L8:
        r10.append(";");
        appendCronetVersion(r10);
        r10.append(')');
        return r10.toString();
    }

    public static String getQuicUserAgentIdFrom(Context r8) {
        StringBuilder r10 = new StringBuilder();
        r10.append(r8.getPackageName());
        appendCronetVersion(r10);
        return r10.toString();
    }

    private static int versionFromContext(Context r8) {
        Object r10 = sLock;
        monitor-enter(r10);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (sVersionCode == 0) goto L18;
    L12:
        int r11 = sVersionCode;     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        return r11;
    L18:
        sVersionCode = r8.getPackageManager().getPackageInfo(r8.getPackageName(), 0).versionCode;     // Catch: PackageManager.NameNotFoundException -> L10 Throwable -> L15
    L11:
        throw new IllegalStateException("Cannot determine package version");     // Catch: Throwable -> L15
    }
}
