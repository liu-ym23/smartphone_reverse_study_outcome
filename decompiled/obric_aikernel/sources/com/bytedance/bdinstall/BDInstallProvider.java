package com.bytedance.bdinstall;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class BDInstallProvider extends ContentProvider {
    private static final int MATCH_DATA = 65536;
    private static Uri sBaseUri;
    private static Context sContext;
    private static UriMatcher sMatcher;
    private static String sShareAuthority;

    public BDInstallProvider() {
        Utils.setIsMainProcess(true);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    static synchronized Uri getContentUri(Context r10, String r11) {
        monitor-enter(BDInstallProvider.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (sBaseUri == null) goto L20;
    L13:
        Uri r12 = sBaseUri.buildUpon().appendPath(r11).build();     // Catch: Throwable -> L16
        monitor-exit(BDInstallProvider.class);
        return r12;
    L20:
        init(r10);     // Catch: Exception -> L8 Throwable -> L16
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        return null;
    }

    static Context getFallbackContext() {
        return sContext;
    }

    private static String getProviderAuthority(Context r10, String r11) {
        if (r10 != null) goto L18;
        return null;
    L18:
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        return r10.getPackageName() + ".bdinstall.provider";
    L6:
        if (TextUtils.isEmpty(r11) == true) goto L17;
        ProviderInfo[] r12 = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 8).providers;     // Catch: Exception -> L14
        int r13 = r12.length;     // Catch: Exception -> L14
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L17;
        ProviderInfo r15 = r12[r14];     // Catch: Exception -> L14
        if (r11.equals(r15.name) == true) goto L11;
        r14 = r14 + 1;
        goto L8
    L11:
        return r15.authority;
    }

    private static void init(Context r10) {
        if (TextUtils.isEmpty(sShareAuthority) == false) goto L6;
        sShareAuthority = getProviderAuthority(r10, BDInstallProvider.class.getName());
    L6:
        if (TextUtils.isEmpty(sShareAuthority) == true) goto L10;
        UriMatcher r11 = new UriMatcher(-1);
        sMatcher = r11;
        r11.addURI(sShareAuthority, "*/*", 65536);
        sBaseUri = Uri.parse("content://" + sShareAuthority);
        return;
    L10:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r10, ProviderInfo r11) {
        sContext = r10;
        if (r11 == null) goto L5;
        sShareAuthority = r11.authority;
    L5:
        Utils.setIsMainProcess(true);
        super.attachInfo(r10, r11);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri r10, @Nullable String r11, @Nullable String[] r12) {
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri r10) {
        return "vnd.android.cursor.item/vnd." + sShareAuthority + ".item";
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri r10, @Nullable ContentValues r11) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (sMatcher == null) goto L17;
    L15:
        BDInstall.registerLifeCycleListener((Application) Utils.getApp(getContext()));     // Catch: Throwable -> L11
        return true;
    L11:
        th = move-exception;
        th.printStackTrace();
        return true;
    L17:
        init(getContext());     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri r10, @Nullable String[] r11, @Nullable String r12, @Nullable String[] r13, @Nullable String r14) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri r10, @Nullable ContentValues r11, @Nullable String r12, @Nullable String[] r13) {
        return 0;
    }
}
