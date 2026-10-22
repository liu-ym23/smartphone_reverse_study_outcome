package com.bytedance.bdinstall;

import android.aimedia.a;
import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import x4.h;
import x4.x0;

/* JADX INFO: loaded from: classes.dex */
public class BDInstallProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f3788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static UriMatcher f3789b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Uri f3790m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Context f3791n;

    public BDInstallProvider() {
        x0.f13580b = Boolean.TRUE;     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public static synchronized Uri a(Context r8) {
        monitor-enter(BDInstallProvider.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (f3790m == null) goto L19;
    L13:
        Uri r10 = f3790m.buildUpon().appendPath("install_info_change").build();     // Catch: Throwable -> L16
        monitor-exit(BDInstallProvider.class);
        return r10;
    L19:
        b(r8);     // Catch: Exception -> L8 Throwable -> L16
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        return null;
    }

    public static void b(Context r8) {
        if (TextUtils.isEmpty(f3788a) == false) goto L21;
        String r10 = BDInstallProvider.class.getName();
        if (r8 != null) goto L26;
        String r11 = null;
    L19:
        f3788a = r11;
        goto L21
    L26:
    L16:
        e = move-exception;
        e.printStackTrace();
    L18:
        r11 = r8.getPackageName() + ".bdinstall.provider";
        goto L19
    L8:
        if (TextUtils.isEmpty(r10) == true) goto L18;
        ProviderInfo[] r12 = r8.getPackageManager().getPackageInfo(r8.getPackageName(), 8).providers;     // Catch: Exception -> L16
        int r13 = r12.length;     // Catch: Exception -> L16
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L18;
        ProviderInfo r15 = r12[r14];     // Catch: Exception -> L16
        if (r10.equals(r15.name) == true) goto L13;
        r14 = r14 + 1;
        goto L10
    L13:
        r11 = r15.authority;     // Catch: Exception -> L16
    L21:
        if (TextUtils.isEmpty(f3788a) == true) goto L25;
        UriMatcher r16 = new UriMatcher(-1);
        f3789b = r16;
        r16.addURI(f3788a, "*/*", 65536);
        f3790m = Uri.parse("content://" + f3788a);
        return;
    L25:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r8, ProviderInfo r10) {
        f3791n = r8;
        if (r10 == null) goto L5;
        f3788a = r10.authority;
    L5:
        x0.f13580b = Boolean.TRUE;
        super.attachInfo(r8, r10);
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri r8, String r10, String[] r11) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri r8) {
        return a.i(new StringBuilder("vnd.android.cursor.item/vnd."), f3788a, ".item");
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri r8, ContentValues r10) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        if (f3789b != null) goto L21;
        b(getContext());     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    L21:
        Context r8 = getContext();     // Catch: Throwable -> L15
        String r10 = x0.f13579a;     // Catch: Throwable -> L15
        if ((r8 instanceof Application) == true) goto L13;
        if (r8 == null) goto L13;
        r8 = r8.getApplicationContext();     // Catch: Throwable -> L15
    L13:
        ((Application) r8).registerActivityLifecycleCallbacks(h.f13429a);     // Catch: Throwable -> L15
        return true;
    L15:
        th = move-exception;
        th.printStackTrace();
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri r8, String[] r10, String r11, String[] r12, String r13) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri r8, ContentValues r10, String r11, String[] r12) {
        return 0;
    }
}
