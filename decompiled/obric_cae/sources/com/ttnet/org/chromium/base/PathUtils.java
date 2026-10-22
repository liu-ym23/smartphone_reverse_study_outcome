package com.ttnet.org.chromium.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.system.Os;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.task.AsyncTask;
import java.io.File;
import java.util.ArrayList;
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

    public static class Holder {
        private static final String[] DIRECTORY_PATHS = null;

        static {
            DIRECTORY_PATHS = PathUtils.access$000();
        }

        private Holder() {
        }

        public static /* synthetic */ String[] access$100() {
            return DIRECTORY_PATHS;
        }
    }

    private static /* synthetic */ void $closeResource(Throwable r8, AutoCloseable r10) {
        if (r8 != null) goto L9;
        r10.close();
        return;
    L9:
        r10.close();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r8.addSuppressed(th);
    }

    static {
        sInitializationStarted = new AtomicBoolean();
    }

    private PathUtils() {
    }

    public static /* synthetic */ String[] a() {
        return setPrivateDataDirectorySuffixInternal();
    }

    public static /* synthetic */ String[] access$000() {
        return getOrComputeDirectoryPaths();
    }

    @SuppressLint({"NewApi"})
    private static void chmod(String r8, int r10) {
        Os.chmod(r8, r10);     // Catch: Exception -> L4
        return;
    L4:
        Log.e(TAG, defpackage.b.d("Failed to set permissions for path \"", r8, "\""), new Object[0]);
    }

    @CalledByNative
    public static String[] getAllPrivateDownloadsDirectories() {
        StrictModeContext r8 = StrictModeContext.allowDiskWrites();
        File[] r10 = ContextUtils.getApplicationContext().getExternalFilesDirs(Environment.DIRECTORY_DOWNLOADS);     // Catch: Throwable -> L18
        if (r8 == null) goto L6;
        $closeResource(null, r8);
    L6:
        ArrayList r11 = new ArrayList();
        int r12 = 0;
    L8:
        if (r12 >= r10.length) goto L17;
        File r13 = r10[r12];
        if (r13 == null) goto L15;
        if (TextUtils.isEmpty(r13.getAbsolutePath()) == true) goto L15;
        r11.add(r10[r12].getAbsolutePath());
    L15:
        r12 = r12 + 1;
        goto L8
    L17:
        return (String[]) r11.toArray(new String[r11.size()]);
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        if (r8 == null) goto L23;
        $closeResource(th, r8);
    L23:
        throw th;
    }

    @CalledByNative
    public static String getCacheDirectory() {
        return getDirectoryPath(2);
    }

    @CalledByNative
    public static String getDataDirectory() {
        return getDirectoryPath(0);
    }

    private static String getDirectoryPath(int r8) {
        return Holder.access$100()[r8];
    }

    @CalledByNative
    private static String getDownloadsDirectory() {
        StrictModeContext r8 = StrictModeContext.allowDiskReads();
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        if (r8 == null) goto L18;
        $closeResource(th, r8);
    L18:
        throw th;
    L4:
        if (BuildInfo.isAtLeastQ() == false) goto L9;
        String r10 = getAllPrivateDownloadsDirectories()[0];     // Catch: Throwable -> L13
        if (r8 == null) goto L8;
        $closeResource(null, r8);
    L8:
        return r10;
    L9:
        String r11 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();     // Catch: Throwable -> L13
        if (r8 == null) goto L12;
        $closeResource(null, r8);
    L12:
        return r11;
    }

    @CalledByNative
    public static String getExternalStorageDirectory() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    @CalledByNative
    private static String getNativeLibraryDirectory() {
        ApplicationInfo r8 = ContextUtils.getApplicationContext().getApplicationInfo();
        int r10 = r8.flags;
        if ((r10 & 128) != 0) goto L10;
        if ((r10 & 1) == 0) goto L10;
        return "/system/lib/";
    L10:
        return r8.nativeLibraryDir;
    }

    private static String[] getOrComputeDirectoryPaths() {
    L18:
        return null;
    L4:
        if (sDirPathFetchTask.cancel(false) == false) goto L17;
        StrictModeContext r8 = StrictModeContext.allowDiskWrites();     // Catch: Throwable -> L18
        String[] r10 = setPrivateDataDirectorySuffixInternal();     // Catch: Throwable -> L10
        if (r8 == null) goto L9;
        $closeResource(null, r8);     // Catch: Throwable -> L18 Throwable -> L18
    L9:
        return r10;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (r8 == null) goto L15;
        $closeResource(th, r8);     // Catch: Throwable -> L18 Throwable -> L18
    L15:
        throw th;     // Catch: Throwable -> L18 Throwable -> L18
    L17:
        return sDirPathFetchTask.get();
    }

    @CalledByNative
    public static String getThumbnailCacheDirectory() {
        return getDirectoryPath(1);
    }

    public static void setPrivateDataDirectorySuffix(String r8) {
        setPrivateDataDirectorySuffix(r8, null);
    }

    private static String[] setPrivateDataDirectorySuffixInternal() {
        String[] r8 = new String[3];
        Context r10 = ContextUtils.getApplicationContext();
        String r11 = r10.getDir(sDataDirectorySuffix, 0).getPath();
        r8[0] = r11;
        chmod(r11, 448);
        r8[1] = r10.getDir(THUMBNAIL_DIRECTORY_NAME, 0).getPath();
        if (r10.getCacheDir() != null) goto L5;
    L8:
        return r8;
    L5:
        if (sCacheSubDirectory != null) goto L7;
        r8[2] = r10.getCacheDir().getPath();
        goto L8
    L7:
        r8[2] = new File(r10.getCacheDir(), sCacheSubDirectory).getPath();
        goto L8
    }

    public static void setPrivateDataDirectorySuffix(String r8, String r10) {
        if (sInitializationStarted.getAndSet(true) == true) goto L6;
        sDataDirectorySuffix = r8;
        sCacheSubDirectory = r10;
        sDirPathFetchTask = new FutureTask(new a());
        AsyncTask.THREAD_POOL_EXECUTOR.execute(sDirPathFetchTask);
        return;
    }
}
