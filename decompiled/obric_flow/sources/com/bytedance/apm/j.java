package com.bytedance.apm;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.net.DefaultHttpServiceImpl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JSONObject f3888b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f3889c = null;
    public static final DefaultHttpServiceImpl d = null;
    public static long e;
    public static volatile int f;
    public static long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f3890h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f3891i;

    static {
        f3888b = new JSONObject();
        f3889c = Collections.emptyMap();
        d = new DefaultHttpServiceImpl();
        e = -1;
        f = -1;
    }

    public static String a() {
        if (TextUtils.isEmpty(f3891i) == false) goto L37;
        int r5 = Process.myPid();
        if (TextUtils.isEmpty(td.d.f22126a) == true) goto L38;
        String r10 = td.d.f22126a;
    L28:
        f3891i = r10;
        goto L37
    L38:
        BufferedReader r11 = new BufferedReader(new FileReader("/proc/" + r5 + "/cmdline"));     // Catch: Throwable -> L19
        r10 = r11.readLine();     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r10) == true) goto L14;
        r10 = r10.trim();     // Catch: Throwable -> L12
    L14:
        td.d.f22126a = r10;     // Catch: Throwable -> L12
        r11.close();     // Catch: IOException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
    L12:
        th = th;
    L40:
        th.printStackTrace();     // Catch: Throwable -> L29
        if (r11 != null) goto L46;
    L27:
        r10 = null;
        goto L28
    L46:
        r11.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L29:
        th = move-exception;
        if (r11 != null) goto L44;
    L35:
        throw th;
    L44:
        r11.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = th;
        r11 = null;
    L37:
        return f3891i;
    }

    public static long b() {
        if (e != (-1)) goto L6;
        e = System.currentTimeMillis();
    L6:
        return e;
    }

    public static String c(long r5) {
        long r10 = r5 - f3890h;
        if (r10 >= 30000) goto L7;
        return "0 - 30s";
    L7:
        if (r10 >= 60000) goto L11;
        return "30s - 1min";
    L11:
        if (r10 >= 120000) goto L15;
        return "1min - 2min";
    L15:
        if (r10 >= 300000) goto L19;
        return "2min - 5min";
    L19:
        if (r10 >= 600000) goto L23;
        return "5min - 10min";
    L23:
        if (r10 >= 1800000) goto L27;
        return "10min - 30min";
    L27:
        if (r10 >= 3600000) goto L30;
        return "30min - 1h";
    L30:
        return "1h - ";
    }

    public static boolean d() {
        String r5 = a();
        if (r5 != null) goto L5;
        return true;
    L5:
        if (r5.contains(":") == false) goto L10;
        return false;
    L10:
        return true;
    }
}
