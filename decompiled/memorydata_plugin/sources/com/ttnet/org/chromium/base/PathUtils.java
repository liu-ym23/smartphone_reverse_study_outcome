package com.ttnet.org.chromium.base;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.MediaStore;
import android.system.Os;
import android.text.TextUtils;
import com.ss.bduploader.BDVideoUploaderBase;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForQ;
import com.ttnet.org.chromium.base.compat.ApiHelperForR;
import com.ttnet.org.chromium.base.task.AsyncTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
@MainDex
public abstract class PathUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CACHE_DIRECTORY = 2;
    private static final int DATA_DIRECTORY = 0;
    private static final int NUM_DIRECTORIES = 3;
    private static final String TAG = "PathUtils";
    private static final int THUMBNAIL_DIRECTORY = 1;
    private static final String THUMBNAIL_DIRECTORY_NAME = "textures";
    private static String sCacheSubDirectory;
    private static String sDataDirectorySuffix;
    private static FutureTask<String[]> sDirPathFetchTask;
    private static final AtomicBoolean sInitializationStarted = null;

    static {
        sInitializationStarted = new AtomicBoolean();
    }

    private PathUtils() {
    }

    private static void chmod(String r2, int r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L9;
        return;
    L9:
        Os.chmod(r2, r3);     // Catch: Exception -> L7
        return;
    L7:
        Log.e(TAG, "Failed to set permissions for path \"" + r2 + "\"", new Object[0]);
    }

    public static String[] getAllPrivateDownloadsDirectories() {
        List r1 = new ArrayList();
        StrictModeContext r2 = StrictModeContext.allowDiskWrites();
        File[] r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getExternalFilesDirs(Environment.DIRECTORY_DOWNLOADS);     // Catch: Throwable -> L11
        if (r0 == null) goto L7;
        r1 = Arrays.asList(r0);     // Catch: Throwable -> L11
    L7:
        if (r2 == null) goto L10;
        r2.close();
    L10:
        return toAbsolutePathStrings(r1);
    L11:
        th = move-exception;
        if (r2 != null) goto L20;
    L17:
        throw th;
    L20:
        r2.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    }

    public static String getAppExternalCacheDirectory() {
        File r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getExternalCacheDir();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0.getAbsolutePath();
    }

    public static String getCacheDirectory() {
        return getDirectoryPath(2);
    }

    public static String getDataDirectory() {
        return getDirectoryPath(0);
    }

    private static String getDirectoryPath(int r1) {
        return getOrComputeDirectoryPaths()[r1];
    }

    public static String getDownloadsDirectory() {
        StrictModeContext r0 = StrictModeContext.allowDiskReads();
    L16:
        th = move-exception;
        if (r0 != null) goto L23;
    L22:
        throw th;
    L23:
        r0.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.addSuppressed(th);
        goto L22
    L4:
        if (Build.VERSION.SDK_INT < 29) goto L12;
        String[] r1 = getAllPrivateDownloadsDirectories();     // Catch: Throwable -> L16
        if (r1.length != 0) goto L8;
        String r2 = "";
    L9:
        if (r0 == null) goto L11;
        r0.close();
    L11:
        return r2;
    L8:
        r2 = r1[0];     // Catch: Throwable -> L16
        goto L9
    L12:
        String r3 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();     // Catch: Throwable -> L16
        if (r0 == null) goto L15;
        r0.close();
    L15:
        return r3;
    }

    public static String[] getExternalDownloadVolumesNames() {
        ArrayList r0 = new ArrayList();
        Iterator<String> r1 = ApiHelperForQ.getExternalVolumeNames((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r3) == true) goto L4;
        if (r3.contains("external_primary") == true) goto L4;
        File r4 = ApiHelperForR.getVolumeDir((StorageManager) ZeusTransformUtils.preCheckCast(ApiHelperForM.getSystemService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), StorageManager.class), StorageManager.class, "com.obric.memorydata.plugin"), MediaStore.Files.getContentUri(r3));
        File r5 = new File(r4, Environment.DIRECTORY_DOWNLOADS);
        if (r5.isDirectory() == true) goto L12;
        Log.w(TAG, "Download dir missing: %s, parent dir:%s, isDirectory:%s", new Object[]{r5.getAbsolutePath(), r4.getAbsolutePath(), Boolean.valueOf(r4.isDirectory())});
    L12:
        r0.add(r5);
        goto L4
    L14:
        return toAbsolutePathStrings(r0);
    }

    public static String getExternalStorageDirectory() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    private static String getNativeLibraryDirectory() {
        ApplicationInfo r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationInfo();
        if ((r0.flags & 128) != 0) goto L10;
        if ((r0.flags & 1) == 0) goto L10;
        return "/system/lib/";
    L10:
        return r0.nativeLibraryDir;
    }

    private static String[] getOrComputeDirectoryPaths() {
        if (sDirPathFetchTask.isDone() == true) goto L22;
        StrictModeContext r0 = StrictModeContext.allowDiskWrites();
        sDirPathFetchTask.run();     // Catch: Throwable -> L8
        if (r0 == null) goto L22;
        r0.close();
    L8:
        th = move-exception;
        if (r0 != null) goto L24;
    L14:
        throw th;
    L24:
        r0.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.addSuppressed(th);
    L22:
        return (String[]) ZeusTransformUtils.preCheckCast(sDirPathFetchTask.get(), String[].class, "com.obric.memorydata.plugin");
    L17:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static String getThumbnailCacheDirectory() {
        return getDirectoryPath(1);
    }

    /* JADX INFO: renamed from: lambda$X-RW9o94x1PPFTEKigy_G0WBu-g, reason: not valid java name */
    public static /* synthetic */ String[] m1400lambda$XRW9o94x1PPFTEKigy_G0WBug() {
        return setPrivateDataDirectorySuffixInternal();
    }

    public static void resetForTesting() {
        sInitializationStarted.set(false);
        sDirPathFetchTask = null;
        sDataDirectorySuffix = null;
        sCacheSubDirectory = null;
    }

    public static void setPrivateDataDirectorySuffix(String r1) {
        setPrivateDataDirectorySuffix(r1, null);
    }

    public static void setPrivateDataDirectorySuffix(String r2, String r3) {
        if (sInitializationStarted.getAndSet(true) == true) goto L6;
        sDataDirectorySuffix = r2;
        sCacheSubDirectory = r3;
        sDirPathFetchTask = new FutureTask($$Lambda$PathUtils$XRW9o94x1PPFTEKigy_G0WBug.INSTANCE);
        AsyncTask.THREAD_POOL_EXECUTOR.execute(sDirPathFetchTask);
        return;
    }

    private static String[] setPrivateDataDirectorySuffixInternal() {
        String[] r0 = new String[3];
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        r0[0] = r1.getDir(sDataDirectorySuffix, 0).getPath();
        chmod(r0[0], BDVideoUploaderBase.KeyIsDynamicSliceLowSize);
        r0[1] = r1.getDir(THUMBNAIL_DIRECTORY_NAME, 0).getPath();
        if (r1.getCacheDir() != null) goto L5;
    L8:
        return r0;
    L5:
        if (sCacheSubDirectory != null) goto L7;
        r0[2] = r1.getCacheDir().getPath();
        goto L8
    L7:
        File r2 = new File(r1.getCacheDir(), sCacheSubDirectory);
        r2.mkdir();
        r0[2] = r2.getPath();
        chmod(r0[2], 1472);
        goto L8
    }

    private static String[] toAbsolutePathStrings(List<File> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        File r2 = (File) ZeusTransformUtils.preCheckCast(r6.next(), File.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        if (TextUtils.isEmpty(r2.getAbsolutePath()) == true) goto L4;
        r0.add(r2.getAbsolutePath());
        goto L4
    L12:
        return (String[]) ZeusTransformUtils.preCheckCast(r0.toArray(new String[r0.size()]), String[].class, "com.obric.memorydata.plugin");
    }
}
