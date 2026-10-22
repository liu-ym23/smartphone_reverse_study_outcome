package com.bytedance.bdinstall;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class BDInstallProvider extends PluginContentProvider {
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

    static synchronized Uri getContentUri(Context r3, String r4) {
        monitor-enter(BDInstallProvider.class);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (sBaseUri == null) goto L19;
    L13:
        Uri r6 = sBaseUri.buildUpon().appendPath(r4).build();     // Catch: Throwable -> L16
        monitor-exit(BDInstallProvider.class);
        return r6;
    L19:
        init(r5);     // Catch: Exception -> L8 Throwable -> L16
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        return null;
    L16:
        th = move-exception;
        throw th;
    }

    static Context getFallbackContext() {
        return sContext;
    }

    private static String getProviderAuthority(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L19;
        return null;
    L19:
    L15:
        e = move-exception;
        e.printStackTrace();
    L18:
        return r7.getPackageName() + ".bdinstall.provider";
    L7:
        if (TextUtils.isEmpty(r6) == true) goto L18;
        ProviderInfo[] r0 = r7.getPackageManager().getPackageInfo(r7.getPackageName(), 8).providers;     // Catch: Exception -> L15
        int r1 = r0.length;     // Catch: Exception -> L15
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L18;
        ProviderInfo r3 = r0[r2];     // Catch: Exception -> L15
        if (r6.equals(r3.name) == true) goto L12;
        r2 = r2 + 1;
        goto L9
    L12:
        return r3.authority;
    }

    private static void init(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(sShareAuthority) == false) goto L6;
        sShareAuthority = getProviderAuthority(r4, BDInstallProvider.class.getName());
    L6:
        if (TextUtils.isEmpty(sShareAuthority) == true) goto L10;
        UriMatcher r5 = new UriMatcher(-1);
        sMatcher = r5;
        r5.addURI(sShareAuthority, "*/*", 65536);
        sBaseUri = Uri.parse("content://" + sShareAuthority);
        return;
    L10:
        throw new IllegalStateException("Must Set MultiProcessSharedProvider Authority");
    }

    public void attachInfo(Context r3, ProviderInfo r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        sContext = r5;
        if (r4 == null) goto L5;
        sShareAuthority = r4.authority;
    L5:
        Utils.setIsMainProcess(true);
        super.attachInfo(r5, r4);
    }

    public int delete(Uri r1, String r2, String[] r3) {
        return 0;
    }

    public String getType(Uri r1) {
        return "vnd.android.cursor.item/vnd." + sShareAuthority + ".item";
    }

    public Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    public boolean onCreate() {
        if (sMatcher != null) goto L17;
        init((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    L17:
        BDInstall.registerLifeCycleListener((Application) ZeusTransformUtils.preCheckCast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Utils.getApp((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
        return true;
    L11:
        th = move-exception;
        th.printStackTrace();
        return true;
    }

    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return 0;
    }
}
