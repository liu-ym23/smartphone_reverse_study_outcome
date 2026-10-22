package com.bytedance.crash;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import androidx.room.writer.DaoWriter;
import com.bytedance.crash.runtime.ConfigManager;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f4057a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Application f4058b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f4059c = 0;
    public static long d = 0;
    public static String e = "default";
    public static boolean f = false;
    public static boolean g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f4060h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static i4.a f4061i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ConfigManager f4062j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AppDataCenter f4063k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile ConcurrentHashMap f4064l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final JSONObject f4065m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static r6.a f4066n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile String f4067o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Object f4068p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile int f4069q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile String f4070r;
    public static final long s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static long f4071t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f4072u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static String f4073v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f4074w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f4075x;

    static {
        f4062j = new ConfigManager();
        f4063k = new AppDataCenter();
        f4065m = new JSONObject();
        f4068p = new Object();
        s = -1;
        f4071t = 0;
        f4072u = false;
    }

    public static Context a() {
        return f4057a;
    }

    public static String b(long r5, CrashType r10, boolean r11, boolean r12) {
        StringBuilder r13 = new StringBuilder();
        r13.append(r5);
        r13.append("_");
        r13.append(r10.getName());
        r13.append('_');
        r13.append(f());
        r13.append('_');
        String r14 = "normal_";
        if (r11 == false) goto L5;
        String r15 = "oom_";
    L6:
        r13.append(r15);
        r13.append(f4059c);
        r13.append('_');
        if (r12 == false) goto L9;
        String r16 = "ignore_";
    L10:
        r13.append(r16);
        if (com.bytedance.android.anniex.base.service.f.n() == false) goto L13;
        r14 = "nospace_";
    L13:
        r13.append(r14);
        r13.append(Long.toHexString(new Random().nextLong()));
        r13.append("G");
        return r13.toString();
    L9:
        r16 = "normal_";
        goto L10
    L5:
        r15 = "normal_";
        goto L6
    }

    public static String c() {
        if (f4073v != null) goto L16;
        monitor-enter(n.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f4073v != null) goto L11;
        f4073v = i.a.j().optString("bytrace_id_prefix", String.valueOf(UUID.randomUUID())) + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + Process.myPid();     // Catch: Throwable -> L9
    L11:
        monitor-exit(n.class);     // Catch: Throwable -> L9
    L16:
        return f4073v;
    }

    public static i4.a d() {
        if (f4061i != null) goto L6;
        f4061i = new i4.a(f4057a, new com.lynx.tasm.utils.c(12), null);
    L6:
        return f4061i;
    }

    public static ConfigManager e() {
        return f4062j;
    }

    public static String f() {
        if (f4067o != null) goto L16;
        Object r5 = f4068p;
        monitor-enter(r5);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f4067o != null) goto L11;
        f4067o = Long.toHexString(new Random().nextLong()) + '-' + f4059c + '-' + Process.myPid() + "G";     // Catch: Throwable -> L9
    L11:
        monitor-exit(r5);     // Catch: Throwable -> L9
    L16:
        return f4067o;
    }

    public static r6.a g() {
        if (f4066n != null) goto L13;
        monitor-enter(n.class);
        f4066n = new r6.a();     // Catch: Throwable -> L9
        monitor-exit(n.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return f4066n;
    }

    public static boolean h() {
        Object r5 = d().u().get(LynxMonitorService.KEY_CHANNEL);
        if (r5 != null) goto L5;
        String r10 = "unknown";
    L7:
        return r10.contains("test_crash");
    L5:
        r10 = String.valueOf(r5);
        goto L7
    }
}
