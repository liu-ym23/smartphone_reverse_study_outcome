package com.ttnet.org.chromium.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.MediaStore;
import android.system.Os;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForQ;
import com.ttnet.org.chromium.base.compat.ApiHelperForR;
import com.ttnet.org.chromium.base.task.AsyncTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
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

    public static /* synthetic */ String[] a() {
        return setPrivateDataDirectorySuffixInternal();
    }

    @SuppressLint({"NewApi"})
    private static void chmod(String r10, int r11) {
        if (Build.VERSION.SDK_INT >= 21) goto L9;
        return;
    L9:
        Os.chmod(r10, r11);     // Catch: Exception -> L7
        return;
    L7:
        Log.e(TAG, "Failed to set permissions for path \"" + r10 + "\"", new Object[0]);
    }

    @NonNull
    @CalledByNative
    public static String[] getAllPrivateDownloadsDirectories() {
        List r10 = new ArrayList();
        StrictModeContext r11 = StrictModeContext.allowDiskWrites();
        File[] r12 = ContextUtils.getApplicationContext().getExternalFilesDirs(Environment.DIRECTORY_DOWNLOADS);     // Catch: Throwable -> L11
        if (r12 == null) goto L7;
        r10 = Arrays.asList(r12);     // Catch: Throwable -> L11
    L7:
        if (r11 == null) goto L10;
        r11.close();
    L10:
        return toAbsolutePathStrings(r10);
    L11:
        th = move-exception;
        if (r11 != null) goto L20;
    L17:
        throw th;
    L20:
        r11.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    }

    @CalledByNative
    public static String getAppExternalCacheDirectory() {
        File r10 = ContextUtils.getApplicationContext().getExternalCacheDir();
        if (r10 != null) goto L6;
        return "";
    L6:
        return r10.getAbsolutePath();
    }

    @CalledByNative
    public static String getCacheDirectory() {
        return getDirectoryPath(2);
    }

    @CalledByNative
    public static String getDataDirectory() {
        return getDirectoryPath(0);
    }

    private static String getDirectoryPath(int r10) {
        return getOrComputeDirectoryPaths()[r10];
    }

    @NonNull
    @CalledByNative
    public static String getDownloadsDirectory() {
        StrictModeContext r10 = StrictModeContext.allowDiskReads();
    L16:
        th = move-exception;
        if (r10 != null) goto L23;
    L22:
        throw th;
    L23:
        r10.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.addSuppressed(th);
        goto L22
    L4:
        if (Build.VERSION.SDK_INT < 29) goto L12;
        String[] r11 = getAllPrivateDownloadsDirectories();     // Catch: Throwable -> L16
        if (r11.length != 0) goto L8;
        String r12 = "";
    L9:
        if (r10 == null) goto L11;
        r10.close();
    L11:
        return r12;
    L8:
        r12 = r11[0];     // Catch: Throwable -> L16
        goto L9
    L12:
        String r13 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();     // Catch: Throwable -> L16
        if (r10 == null) goto L15;
        r10.close();
    L15:
        return r13;
    }

    @NonNull
    @RequiresApi(30)
    @CalledByNative
    public static String[] getExternalDownloadVolumesNames() {
        ArrayList r10 = new ArrayList();
        Iterator<String> r11 = ApiHelperForQ.getExternalVolumeNames(ContextUtils.getApplicationContext()).iterator();
    L4:
        if (r11.hasNext() == false) goto L14;
        String r12 = r11.next();
        if (TextUtils.isEmpty(r12) == true) goto L4;
        if (r12.contains("external_primary") == true) goto L4;
        File r13 = ApiHelperForR.getVolumeDir((StorageManager) ApiHelperForM.getSystemService(ContextUtils.getApplicationContext(), StorageManager.class), MediaStore.Files.getContentUri(r12));
        File r14 = new File(r13, Environment.DIRECTORY_DOWNLOADS);
        if (r14.isDirectory() == true) goto L12;
        Log.w(TAG, "Download dir missing: %s, parent dir:%s, isDirectory:%s", new Object[]{r14.getAbsolutePath(), r13.getAbsolutePath(), Boolean.valueOf(r13.isDirectory())});
    L12:
        r10.add(r14);
        goto L4
    L14:
        return toAbsolutePathStrings(r10);
    }

    @CalledByNative
    public static String getExternalStorageDirectory() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    @CalledByNative
    private static String getNativeLibraryDirectory() {
        ApplicationInfo r10 = ContextUtils.getApplicationContext().getApplicationInfo();
        int r11 = r10.flags;
        if ((r11 & 128) != 0) goto L10;
        if ((r11 & 1) == 0) goto L10;
        return "/system/lib/";
    L10:
        return r10.nativeLibraryDir;
    }

    private static String[] getOrComputeDirectoryPaths() {
        if (sDirPathFetchTask.isDone() == true) goto L20;
        StrictModeContext r10 = StrictModeContext.allowDiskWrites();
        sDirPathFetchTask.run();     // Catch: Throwable -> L8
        if (r10 == null) goto L20;
        r10.close();
    L8:
        th = move-exception;
        if (r10 != null) goto L24;
    L14:
        throw th;
    L24:
        r10.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.addSuppressed(th);
    L20:
        return sDirPathFetchTask.get();
    L17:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @CalledByNative
    public static String getThumbnailCacheDirectory() {
        return getDirectoryPath(1);
    }

    public static void resetForTesting() {
        sInitializationStarted.set(false);
        sDirPathFetchTask = null;
        sDataDirectorySuffix = null;
        sCacheSubDirectory = null;
    }

    public static void setPrivateDataDirectorySuffix(String r10) {
        setPrivateDataDirectorySuffix(r10, null);
    }

    public static void setPrivateDataDirectorySuffix(String r10, String r11) {
        if (sInitializationStarted.getAndSet(true) == true) goto L6;
        sDataDirectorySuffix = r10;
        sCacheSubDirectory = r11;
        sDirPathFetchTask = new FutureTask(d.f8407c);
        AsyncTask.THREAD_POOL_EXECUTOR.execute(sDirPathFetchTask);
        return;
    }

    private static String[] setPrivateDataDirectorySuffixInternal() {
        String[] r10 = new String[3];
        Context r11 = ContextUtils.getApplicationContext();
        r10[0] = r11.getDir(sDataDirectorySuffix, 0).getPath();
        chmod(r10[0], 448);
        r10[1] = r11.getDir(THUMBNAIL_DIRECTORY_NAME, 0).getPath();
        if (r11.getCacheDir() != null) goto L5;
    L8:
        return r10;
    L5:
        if (sCacheSubDirectory != null) goto L7;
        r10[2] = r11.getCacheDir().getPath();
        goto L8
    L7:
        File r12 = new File(r11.getCacheDir(), sCacheSubDirectory);
        r12.mkdir();
        r10[2] = r12.getPath();
        chmod(r10[2], 1472);
        goto L8
    }

    @NonNull
    private static String[] toAbsolutePathStrings(@NonNull List<File> r10) {
        ArrayList r11 = new ArrayList();
        Iterator<File> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L12;
        File r13 = r12.next();
        if (r13 == null) goto L4;
        if (TextUtils.isEmpty(r13.getAbsolutePath()) == true) goto L4;
        r11.add(r13.getAbsolutePath());
        goto L4
    L12:
        return (String[]) r11.toArray(new String[r11.size()]);
    }
}
