package com.obric.olog;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.UserManager;
import android.util.Log;
import com.obric.android.agilelogger.ALog;
import qq.a;
import so.h;

/* JADX INFO: loaded from: classes3.dex */
public class OLog extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f11908a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f11909b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile int f11910c = 3;
    public static volatile boolean d = false;
    public static Context e;

    public OLog() {
    }

    public static void a(int r5, String r10, String r11) {
        if (r5 > 2) goto L6;
        ALog.v(r10, r11);
        return;
    L6:
        if (r5 != 3) goto L9;
        ALog.d(r10, r11);
        return;
    L9:
        if (r5 != 4) goto L12;
        ALog.i(r10, r11);
        return;
    L12:
        if (r5 != 5) goto L14;
        ALog.w(r10, r11);
        return;
    L14:
        ALog.e(r10, r11);
    }

    public static boolean b(int r5) {
        if (r5 < f11910c) goto L5;
        return true;
    L5:
        return false;
    }

    public static void c(a r5) {
        f11908a = r5.f21562c;
        f11910c = r5.f21561b;
        Context r10 = r5.f21560a;
        e = r10;
        UserManager r11 = (UserManager) r10.getSystemService("user");
        if (r11 != null) goto L43;
    L9:
        SharedPreferences r12 = r5.f21560a.createDeviceProtectedStorageContext().getSharedPreferences("olog_config", 0);     // Catch: IllegalStateException -> L7
    L42:
    L13:
        if (r12 != null) goto L20;
        if (f11908a == false) goto L17;
        d(r5);
    L17:
        d = true;
        return;
    L20:
        if (r12.contains("report") == false) goto L23;
        r12.getBoolean("report", false);
    L23:
        if (r12.contains("save_to_disk") == false) goto L26;
        f11908a = r12.getBoolean("save_to_disk", true);
    L26:
        if (r12.contains("output_to_logd") == false) goto L29;
        f11909b = r12.getBoolean("output_to_logd", false);
    L29:
        if (r12.contains("log_level") == false) goto L32;
        f11910c = r12.getInt("log_level", 3);
        r5.f21561b = f11910c;
    L32:
        if (r12.contains("max_dir_size") == false) goto L35;
        r5.d = r12.getInt("max_dir_size", r5.d);
    L35:
        if (r12.contains("log_expired_days") == false) goto L38;
        r5.e = r12.getInt("log_expired_days", r5.e);
    L38:
        if (f11908a == false) goto L40;
        d(r5);
    L40:
        d = true;
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        r12 = null;
        goto L13
    L43:
        if (r11.isUserUnlocked() == false) goto L9;
        r12 = r5.f21560a.getSharedPreferences("olog_config", 0);     // Catch: IllegalStateException -> L7
        goto L42
    }

    public static void d(a r5) {
        h r10 = new h(r5.f21560a);
        r10.g = true;
        r10.e = false;
        r10.d = false;
        r10.f = r5.f21561b;
        r10.f21980c = r5.d;
        r10.f21979b = r5.e;
        ALog.init(r10.a());
    }

    public static void e() {
        Context r5 = e;
        if (r5 == null) goto L14;
        Context r10 = r5.getApplicationContext();
        if (r10 == null) goto L8;
        r5 = r10;
    L8:
        if (Build.TYPE.equals("userdebug") == false) goto L10;
        int r11 = 31457280;
    L11:
        a r12 = new a();
        r12.f21560a = r5;
        r12.f21561b = 3;
        r12.f21562c = true;
        r12.d = r11;
        r12.e = 14;
        c(r12);
        return;
    L10:
        r11 = 20971520;
        goto L11
    L14:
        throw new RuntimeException("context must not be null");
    }

    public static void f(int r5, String r10, String r11) {
        if (r5 > 2) goto L6;
        Log.v(r10, r11);
        return;
    L6:
        if (r5 != 3) goto L9;
        Log.d(r10, r11);
        return;
    L9:
        if (r5 != 4) goto L12;
        Log.i(r10, r11);
        return;
    L12:
        if (r5 != 5) goto L14;
        Log.w(r10, r11);
        return;
    L14:
        Log.e(r10, r11);
    }

    public static void g(boolean r5) {
        f11909b = r5;     // Catch: Exception -> L9
        UserManager r10 = (UserManager) e.getSystemService("user");     // Catch: Exception -> L9
        if (r10 != null) goto L7;
    L11:
        SharedPreferences r11 = e.createDeviceProtectedStorageContext().getSharedPreferences("olog_config", 0);     // Catch: Exception -> L9
    L13:
        if (r11.contains("output_to_logd") == false) goto L20;
        f11909b = r11.getBoolean("output_to_logd", false);     // Catch: Exception -> L9
        return;
    L20:
        return;
    L7:
        if (r10.isUserUnlocked() == false) goto L11;
        r11 = e.getSharedPreferences("olog_config", 0);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    public static void h(String r5, String r10) {
        if (d == true) goto L6;
        e();
    L6:
        if (f11909b == false) goto L11;
        if (b(5) == false) goto L11;
        f(5, r5, r10);
    L11:
        if (f11908a == false) goto L14;
        a(5, r5, r10);
        return;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri r5, String r10, String[] r11) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri r5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri r5, ContentValues r10) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        e = getContext();
        System.currentTimeMillis();
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri r5, String[] r10, String r11, String[] r12, String r13) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri r5, ContentValues r10, String r11, String[] r12) {
        return 0;
    }
}
