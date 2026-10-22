package com.bytedance.applog;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.bdinstall.Level;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g f1159a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f1160b;

    static {
        f1159a = j();
        f1160b = false;
    }

    public a() {
    }

    public static void a(h r10) {
        f1159a.g(r10);
    }

    public static String b(Context r10, String r11, boolean r12, Level r13) {
        return f1159a.addNetCommonParams(r10, r11, r12, r13);
    }

    public static void c() {
        f1159a.flush();
    }

    public static String d() {
        return f1159a.getDid();
    }

    public static String e() {
        return f1159a.getIid();
    }

    public static g f() {
        return f1159a;
    }

    public static String g() {
        return f1159a.getSessionId();
    }

    public static String h() {
        return f1159a.e();
    }

    public static void i(@NonNull Context r10, @NonNull n r11) {
        monitor-enter(a.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (f1160b == true) goto L13;
        f1160b = true;     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r11.A()) == false) goto L9;
        r11.g0("applog_stats");     // Catch: Throwable -> L14
    L9:
        f1159a.d(r10, r11);     // Catch: Throwable -> L14
        monitor-exit(a.class);     // Catch: Throwable -> L14
        return;
    L13:
        throw new RuntimeException("Default AppLog is initialized, please new a instance by `AppLog.newInstance()`.");     // Catch: Throwable -> L14
    }

    public static g j() {
        return new c();
    }

    public static void k(String r10, int r11) {
        f1159a.b(r10, r11);
    }

    public static void l(@NonNull String r10, @Nullable JSONObject r11) {
        f1159a.a(r10, r11);
    }

    public static void m(Context r10) {
        f1159a.f(r10);
    }

    public static void n(Context r10, Map<String, String> r11, boolean r12, Level r13) {
        f1159a.putCommonParams(r10, r11, r12, r13);
    }

    public static void o(boolean r10) {
        f1159a.c(r10);
    }
}
