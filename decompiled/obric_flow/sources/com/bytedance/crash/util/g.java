package com.bytedance.crash.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.n;
import com.bytedance.crash.runtime.ConfigManager;
import java.io.File;
import java.net.URL;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4181a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f4182b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f4183c;
    public static File d;
    public static File e;
    public static File f;
    public static File g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static File f4184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static File f4185i;

    static {
        String r5 = x8.a.f22982a;
        f4181a = "npth/configCrash/";
        f4182b = "npth/GwpReport";
    }

    public static File a() {
        if (f4185i != null) goto L6;
        File r5 = new File(h(n.f4057a), x8.a.f);
        StringBuilder r10 = new StringBuilder("anr_");
        r10.append(n.f() + '_' + Long.toHexString(new Random().nextLong()) + "G");
        File r11 = new File(new File(r5, r10.toString()), "trace");
        f4185i = r11;
        r11.getParentFile().mkdirs();
    L6:
        return f4185i;
    }

    public static File b(Context r5) {
        if (f4184h != null) goto L6;
        f4184h = new File(new File(h(r5), x8.a.f), "asdawd");
    L6:
        return f4184h;
    }

    public static File c(Context r5, String r10) {
        return new File(h(r5) + '/' + x8.a.f + '/' + r10);
    }

    public static void d(CrashType r5) {
        if (r5 != CrashType.JAVA) goto L5;
    L16:
        File[] r10 = new File(h(n.f4057a), x8.a.f22983b).listFiles();
    L17:
        if (r10 != null) goto L19;
        return;
    L19:
        if (r10.length <= 0) goto L38;
        int r11 = 0;
    L23:
        if (r11 >= r10.length) goto L39;
        File r12 = r10[r11];
        if (r12.isFile() == true) goto L29;
        cl.a.s(r12.getAbsolutePath());     // Catch: Throwable -> L31
    L29:
        r11 = r11 + 1;
        goto L23
    L39:
        return;
    L38:
        return;
    L5:
        if (r5 == CrashType.LAUNCH) goto L16;
        if (r5 != CrashType.NATIVE) goto L11;
        r10 = g(n.f4057a).listFiles();
        goto L17
    L11:
        if (r5 != CrashType.ANR) goto L30;
        Context r13 = n.f4057a;
        if (f != null) goto L15;
        f = new File(h(r13), x8.a.e);
    L15:
        r10 = f.listFiles();
        goto L17
    }

    public static void e(String r5) {
    L10:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);
        return;
    L4:
        if (TextUtils.isEmpty(r5) == true) goto L59;
        io.reactivex.exceptions.a.l("deleteCrashLog:" + r5);     // Catch: Throwable -> L10
        ConfigManager r10 = n.f4062j;     // Catch: Throwable -> L10
        if (new URL(r10.getJavaCrashUploadUrl()).getPath().equals(r5) == false) goto L12;
        d(CrashType.JAVA);     // Catch: Throwable -> L10
        d(CrashType.ANR);     // Catch: Throwable -> L10
        return;
    L12:
        int r11 = 0;
        if (new URL(r10.getLaunchCrashUploadUrl()).getPath().equals(r5) == false) goto L30;
        File r12 = new File(h(n.f4057a), f4182b);     // Catch: Throwable -> L10
        if (r12.exists() == false) goto L27;
        File[] r13 = r12.listFiles();     // Catch: Throwable -> L10
        if (r13 == null) goto L27;
        if (r13.length == 0) goto L27;
    L23:
        if (r11 >= r13.length) goto L27;
        cl.a.C(r13[r11]);     // Catch: Throwable -> L48
    L26:
        r11 = r11 + 1;
    L27:
        d(CrashType.LAUNCH);     // Catch: Throwable -> L10
        return;
    L30:
        if (new URL(r10.getNativeCrashUploadUrl()).getPath().equals(r5) == false) goto L60;
        File r14 = b(n.f4057a);     // Catch: Throwable -> L10
        if (r14.exists() == false) goto L44;
        File[] r15 = r14.listFiles();     // Catch: Throwable -> L10
        if (r15 == null) goto L44;
        if (r15.length == 0) goto L44;
    L40:
        if (r11 >= r15.length) goto L44;
        cl.a.C(r15[r11]);     // Catch: Throwable -> L49
    L43:
        r11 = r11 + 1;
    L44:
        d(CrashType.NATIVE);     // Catch: Throwable -> L10
        return;
    L60:
        return;
    }

    public static File f(Context r5) {
        if (g != null) goto L6;
        g = new File(h(r5) + '/' + x8.a.f + '/' + n.f());
    L6:
        return g;
    }

    public static File g(Context r5) {
        if (e != null) goto L8;
        if (r5 != null) goto L6;
        r5 = n.f4057a;
    L6:
        e = new File(h(r5), x8.a.d);
    L8:
        return e;
    }

    public static String h(Context r5) {
        if (r5 != null) goto L7;
        io.reactivex.exceptions.a.e("LogPath", "getDirBeforeInit!");
        return "";
    L7:
        if (TextUtils.isEmpty(f4183c) == false) goto L13;
        f4183c = r5.getFilesDir().getAbsolutePath();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        f4183c = "";
        e.printStackTrace();
    L13:
        return f4183c;
    }
}
