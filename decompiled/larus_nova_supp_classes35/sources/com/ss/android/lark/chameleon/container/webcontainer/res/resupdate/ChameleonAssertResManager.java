package com.ss.android.lark.chameleon.container.webcontainer.res.resupdate;

import android.app.Application;
import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.api.ResConfig;
import com.ss.android.lark.chameleon.container.webcontainer.util.Storage;
import com.ss.android.lark.chameleon.container.webcontainer.util.StorageUtils;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.FileUtils;
import com.ss.android.lark.chameleon.util.LzmaUtils;
import com.ss.android.lark.chameleon.util.PackageUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonAssertResManager;", BuildConfig.FLAVOR, "()V", "ASSET_FOLDER", BuildConfig.FLAVOR, "TAG", "localChameleonResInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonResInfo;", "extractSimAssetToLocal", BuildConfig.FLAVOR, "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "context", "Landroid/content/Context;", "destFile", "Ljava/io/File;", "getAssetFilePath", "getLocalAssetFileName", "getLocalAssetPath", "getResInfo", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonAssertResManager {
    public static final String ASSET_FOLDER = "assets";
    public static final ChameleonAssertResManager INSTANCE = null;
    public static final String TAG = "CML_TAG_AssertResManager";
    private static ConcurrentHashMap<String, ChameleonResInfo> localChameleonResInfoMap;

    private ChameleonAssertResManager() {
    }

    static {
        INSTANCE = new ChameleonAssertResManager();
        localChameleonResInfoMap = new ConcurrentHashMap();
    }

    private final String getLocalAssetPath(ChameleonConfig r5) {
        Application r0 = Env.getApplication();
        if (r5 == null) goto L6;
        String r6 = r5.getBizName();
        if (r6 == null) goto L6;
    L8:
        return StorageUtils.composeStoragePath(r0, ChameleonResConstants.WEBCONAINER_ROOT_DIR, r6, Storage.Type.INNER_FILES, new String[]{ASSET_FOLDER});
    L6:
        r6 = BuildConfig.FLAVOR;
        goto L8
    }

    private final File getAssetFilePath(ChameleonConfig r3, Context r4) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(getLocalAssetPath(r3), getLocalAssetFileName(r3, r4));
        File r5 = r0.getParentFile();
        boolean r6 = false;
        if (r5 != null) goto L5;
    L7:
        if (r6 == true) goto L11;
        File r7 = r0.getParentFile();
        if (r7 == null) goto L11;
        r7.mkdirs();
    L11:
        return r0;
    L5:
        if (r5.exists() != true) goto L7;
        r6 = true;
        goto L7
    }

    private final String getLocalAssetFileName(ChameleonConfig r2, Context r3) {
        StringBuilder r0 = new StringBuilder(PackageUtils.getAppVersionName(r3));
        r0.append("-");
        if (r2 == null) goto L8;
        ResConfig r4 = r2.getResConfig();
        if (r4 == null) goto L8;
        String r5 = r4.getOfflineZipName();
        if (r5 == null) goto L8;
    L9:
        r0.append(r5);
        return r0.toString();
    L8:
        r5 = BuildConfig.FLAVOR;
        goto L9
    }

    public final ChameleonResInfo getResInfo(ChameleonConfig r17, Context r18) {
        Intrinsics.checkNotNullParameter(r18, "context");
        String r6 = null;
        if (r17 == null) goto L59;
        String r7 = r17.getBizName();
        if (r7 == null) goto L59;
        String r8 = ThreadMethodProxy.currentThread().getName();
        if (r17.getResConfig() != null) goto L10;
        Log.i(TAG, "getResInfo, chameleonConfig resConfig is null, return");
        return new ChameleonResInfo(null, null, 3, null);
    L10:
        ChameleonAssertResManager r9 = INSTANCE;
        File r10 = r9.getAssetFilePath(r17, r18);
        if (r10.exists() == false) goto L18;
        ChameleonResInfo r0 = localChameleonResInfoMap.get(r17.getBizName());
        if (r0 == null) goto L15;
        r6 = r0.getVersion();
    L15:
        if (r6 != null) goto L63;
        ChameleonResInfo r1 = ChameleonResUtils.INSTANCE.getResInfoOf7z(r17, r10.getAbsolutePath());
        localChameleonResInfoMap.put(r7, r1);
        return r1;
    L63:
        return r0;
    L18:
        Log.i(TAG, "getResInfo: appId is " + r7 + " local asset not exist,begin copy thread:" + r8);
        monitor-enter(ChameleonAssertResManager.class);
    L55:
        th = move-exception;
        throw th;
    L21:
        if (r10.exists() == false) goto L31;
        ChameleonResInfo r2 = localChameleonResInfoMap.get(r17.getBizName());     // Catch: Throwable -> L55
        if (r2 == null) goto L25;
        r6 = r2.getVersion();     // Catch: Throwable -> L55
    L25:
        if (r6 != null) goto L29;
        r2 = ChameleonResUtils.INSTANCE.getResInfoOf7z(r17, r10.getAbsolutePath());     // Catch: Throwable -> L55
        if (r2 == null) goto L29;
        localChameleonResInfoMap.put(r7, r2);     // Catch: Throwable -> L55
    L29:
        monitor-exit(ChameleonAssertResManager.class);
        return r2;
    L31:
        String r11 = r9.getLocalAssetPath(r17);     // Catch: Throwable -> L55
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L55
        r13.append(System.currentTimeMillis());     // Catch: Throwable -> L55
        ResConfig r14 = r17.getResConfig();     // Catch: Throwable -> L55
        if (r14 == null) goto L34;
        String r15 = r14.getOfflineZipName();     // Catch: Throwable -> L55
    L35:
        r13.append(r15);     // Catch: Throwable -> L55
        PolarisFileWrapper r12 = new PolarisFileWrapper(r11, r13.toString());     // Catch: Throwable -> L55
        Log.i(TAG, "getResInfo: clean directory thread:" + r8);     // Catch: IOException -> L38 Throwable -> L55
        FileUtils.cleanDirectory(r12.getParentFile());     // Catch: IOException -> L38 Throwable -> L55
    L40:
        ResConfig r3 = r17.getResConfig();     // Catch: Throwable -> L55
        if (r3 == null) goto L44;
        String r4 = r3.getOfflineZipName();     // Catch: Throwable -> L55
        if (r4 == null) goto L44;
    L46:
        if (FileUtils.copyAssets(r18, r4, r12.getAbsolutePath()) == true) goto L48;
    L52:
        r12.deleteOnExit();     // Catch: Throwable -> L55
        Log.i(TAG, "getResInfo: asset copy to local fails thread:" + r8);     // Catch: Throwable -> L55
        ChameleonResInfo r5 = new ChameleonResInfo(null, null, 3, null);     // Catch: Throwable -> L55
        monitor-exit(ChameleonAssertResManager.class);
        return r5;
    L48:
        if (r12.exists() == false) goto L52;
        r12.renameTo(r10);     // Catch: Throwable -> L55
        Log.i(TAG, "getResInfo: rename to :" + r10.getAbsolutePath() + " thread:" + r8);     // Catch: Throwable -> L55
        ChameleonResInfo r16 = ChameleonResUtils.INSTANCE.getResInfoOf7z(r17, r10.getAbsolutePath());     // Catch: Throwable -> L55
        localChameleonResInfoMap.put(r7, r16);     // Catch: Throwable -> L55
        monitor-exit(ChameleonAssertResManager.class);
        return r16;
    L44:
        r4 = BuildConfig.FLAVOR;
        goto L46
    L38:
        e = move-exception;
        Log.e(TAG, r8 + " => getResInfo: clean directory fails : " + e);     // Catch: Throwable -> L55
        goto L40
    L34:
        r15 = null;
    L59:
        return new ChameleonResInfo(null, null, 3, null);
    }

    public final boolean extractSimAssetToLocal(ChameleonConfig r3, Context r4, File r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "destFile");
        Log.i(TAG, "extractSimAssetToLocal: begin extract local assets");
        if (LzmaUtils.extract7z(getAssetFilePath(r3, r4).getAbsolutePath(), r5.getAbsolutePath()) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
