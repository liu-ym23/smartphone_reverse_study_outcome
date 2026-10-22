package com.bytedance.bdinstall;

import ai.j0;
import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import z7.a;
import z7.c;

/* JADX INFO: loaded from: classes2.dex */
public class BDInstallProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f3947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static UriMatcher f3948b;

    public BDInstallProvider() {
        int r5 = c.f23415a;     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public static void a(Context r10) {
        if (TextUtils.isEmpty(f3947a) == false) goto L22;
        String r5 = BDInstallProvider.class.getName();
        if (r10 != null) goto L27;
        String r11 = null;
    L20:
        f3947a = r11;
        goto L22
    L27:
    L15:
        e = move-exception;
        e.printStackTrace();
    L19:
        r11 = r10.getPackageName() + ".bdinstall.provider";
        goto L20
    L8:
        if (TextUtils.isEmpty(r5) == true) goto L19;
        ProviderInfo[] r12 = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 8).providers;     // Catch: Exception -> L15
        int r13 = r12.length;     // Catch: Exception -> L15
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L19;
        ProviderInfo r15 = r12[r14];     // Catch: Exception -> L15
        if (r5.equals(r15.name) == true) goto L13;
        r14 = r14 + 1;
        goto L10
    L13:
        r11 = r15.authority;     // Catch: Exception -> L15
    L22:
        if (TextUtils.isEmpty(f3947a) == true) goto L26;
        UriMatcher r16 = new UriMatcher(-1);
        f3948b = r16;
        r16.addURI(f3947a, "*/*", 65536);
        Uri.parse("content://" + f3947a);
        return;
    L26:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context r5, ProviderInfo r10) {
        if (r10 == null) goto L4;
        f3947a = r10.authority;
    L4:
        int r11 = c.f23415a;
        super.attachInfo(r5, r10);
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri r5, String r10, String[] r11) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri r5) {
        return j0.q(new StringBuilder("vnd.android.cursor.item/vnd."), f3947a, ".item");
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri r5, ContentValues r10) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        if (f3948b == null) goto L22;
    L20:
        Context r5 = getContext();     // Catch: Throwable -> L13
        int r10 = c.f23415a;     // Catch: Throwable -> L13
        if ((r5 instanceof Application) == true) goto L15;
        if (r5 == null) goto L15;
        r5 = r5.getApplicationContext();     // Catch: Throwable -> L13
    L15:
        ((Application) r5).registerActivityLifecycleCallbacks(a.f23413a);     // Catch: Throwable -> L13
        return true;
    L13:
        th = move-exception;
        th.printStackTrace();
        return true;
    L22:
        a(getContext());     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
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
