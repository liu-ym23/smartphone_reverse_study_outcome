package com.ss.android.socialbase.downloader.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadDirUtils {
    private static final String EXTERNAL_DOWNLOAD_DIRECTORY = null;
    public static String EXT_PUBLIC_DIR = "ByteDownload";
    private static String FAST_TEMP_PATH = null;
    private static final String TAG = "DownloadDirUtils";
    private static volatile File dataDir;
    private static volatile File externalCacheDir;
    private static volatile File externalFilesDir;
    private static volatile File externalStorageDirectory;
    private static volatile File externalStoragePublicDirectory;
    private static volatile File filesDir;
    private static volatile Boolean isExternalStorageLegacy;
    private static volatile File obbDir;

    public DownloadDirUtils() {
    }

    public static String getExtPublicDownloadPath() {
        return getExternalStoragePublicDirectory(false).getAbsolutePath();
    L5:
        e = move-exception;
        Logger.globalError(TAG, "getExtPublicDownloadPath", "Error:" + e);
        return null;
    }

    static {
        EXTERNAL_DOWNLOAD_DIRECTORY = Environment.DIRECTORY_DOWNLOADS + File.separator + EXT_PUBLIC_DIR;
        FAST_TEMP_PATH = null;
        externalCacheDir = null;
        obbDir = null;
        filesDir = null;
        externalFilesDir = null;
        externalStorageDirectory = null;
        dataDir = null;
        externalStoragePublicDirectory = null;
        isExternalStorageLegacy = null;
    }

    public static String getDefaultDataPath() {
        Context r0 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (r0 == null) goto L8;
        File r1 = getFilesDir(r0, false);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getAbsolutePath();
    L8:
        return null;
    }

    public static String getDefaultExtPrivatePath() {
        Context r0 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();     // Catch: Exception -> L6
        if (r0 == null) goto L12;
        return getExternalFilesDir(r0, false).getAbsolutePath();
    L12:
        return null;
    L6:
        e = move-exception;
        Logger.globalError(TAG, "getDefaultExtPrivatePath", "Error:" + e);
        return null;
    }

    public static String getDefaultExtPublicPath() {
        return getExternalStorageDirectory(false).getPath() + File.separator + DownloadSetting.obtainGlobal().optString("default_save_dir_name", EXT_PUBLIC_DIR);
    L4:
        e = move-exception;
        Logger.globalError(TAG, "getDefaultExtPublicPath", "Error:" + e);
        return null;
    }

    public static String getDownloadFastTempPath() {
        String r0 = FAST_TEMP_PATH;
        if (r0 == null) goto L10;
        return r0;
    L10:
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L7
        r1.append(getFilesDir(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext(), false));     // Catch: Throwable -> L7
        String r2 = File.separator;     // Catch: Throwable -> L7
        r1.append(r2);     // Catch: Throwable -> L7
        r1.append("download");     // Catch: Throwable -> L7
        r1.append(r2);     // Catch: Throwable -> L7
        r1.append("temp_fast_download");     // Catch: Throwable -> L7
        String r3 = r1.toString();     // Catch: Throwable -> L7
        FAST_TEMP_PATH = r3;     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "getDownloadFastTempPath", "Error:" + th);
        return null;
    }

    public static String getDownloadPath() {
        return getValidDownloadPath(Downloader.getInstance(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()).getGlobalSaveDir());
    }

    public static String getDownloadTempPath() {
        return getValidDownloadPath(Downloader.getInstance(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()).getGlobalSaveTempDir());
    }

    public static String getGlobalSavePath() {
        File r0 = Downloader.getInstance(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()).getGlobalSaveDir();     // Catch: Exception -> L6
        if (r0 == null) goto L12;
        return r0.getAbsolutePath();
    L12:
        return null;
    L6:
        e = move-exception;
        Logger.globalError(TAG, "getGlobalSavePath", "Error:" + e);
        return null;
    }

    public static Uri getRootContentUri() {
        return MediaStore.Files.getContentUri("external");
    }

    public static String getExternalRelativePath() {
        return EXTERNAL_DOWNLOAD_DIRECTORY;
    }

    public static void forceLoadStoragePathCache(Context r1) {
        getExternalCacheDir(r1, true);
        getObbDirStr(r1, true);
        getFilesDir(r1, true);
        getExternalFilesDir(r1, true);
        getExternalStorageDirectory(true);
        getDataDirectory(true);
        getExternalStoragePublicDirectory(true);
        isExternalStorageLegacy(true);
    }

    public static File getDataDirectory(boolean r2) {
        if (dataDir == null) goto L13;
        if (r2 == true) goto L13;
        return dataDir;
    L13:
        dataDir = Environment.getDataDirectory();     // Catch: Throwable -> L9
    L12:
        return dataDir;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getDataDirectory", "Error:" + th);
        goto L12
    }

    public static File getExternalStorageDirectory(boolean r2) {
        if (externalStorageDirectory == null) goto L13;
        if (r2 == true) goto L13;
        return externalStorageDirectory;
    L13:
        externalStorageDirectory = Environment.getExternalStorageDirectory();     // Catch: Throwable -> L9
    L12:
        return externalStorageDirectory;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getExternalStorageDirectory", "Error:" + th);
        goto L12
    }

    public static File getExternalStoragePublicDirectory(boolean r2) {
        if (externalStoragePublicDirectory == null) goto L13;
        if (r2 == true) goto L13;
        return externalStoragePublicDirectory;
    L13:
        externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);     // Catch: Throwable -> L9
    L12:
        return externalStoragePublicDirectory;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getExternalStoragePublicDirectory", "Error:" + th);
        goto L12
    }

    public static String getValidDownloadPath(File r2) {
        Context r0 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (isValidDirectory(r2) == true) goto L5;
        if (r0 != null) goto L10;
        Logger.globalError(TAG, "getValidDownloadPath", "Context is null");
        return null;
    L10:
        if (DownloadSetting.obtainGlobal().optInt("fix_save_external_dir") > 0) goto L12;
        File r3 = getExternalFilesDir(r0, false);
        if (isValidDirectory(r3) == false) goto L18;
        return r3.getAbsolutePath();
    L18:
        return getDefaultDataPath();
    L12:
        return getDefaultDataPath();
    L5:
        return r2.getAbsolutePath();
    }

    public static boolean isExternalStorageLegacy(boolean r2) {
        if (isExternalStorageLegacy == null) goto L16;
        if (r2 == true) goto L16;
        return isExternalStorageLegacy.booleanValue();
    L16:
    L12:
        th = move-exception;
        Logger.globalError(TAG, "isExternalStorageLegacy", "Error:" + th);
    L15:
        return isExternalStorageLegacy.booleanValue();
    L8:
        if (Build.VERSION.SDK_INT < 29) goto L10;
        isExternalStorageLegacy = Boolean.valueOf(Environment.isExternalStorageLegacy());     // Catch: Throwable -> L12
        goto L15
    L10:
        isExternalStorageLegacy = Boolean.FALSE;     // Catch: Throwable -> L12
        goto L15
    }

    public static boolean isSavePathSecurity(String r4) {
        Context r0 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (r0 != null) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L19;
        File r2 = getDataDirectory(false);     // Catch: Exception -> L17
        if (r2 != null) goto L10;
    L12:
        File r1 = getExternalCacheDir(r0, false);     // Catch: Exception -> L17
        if (r1 == null) goto L19;
        if (r4.startsWith(r1.getParent()) == false) goto L19;
        return true;
    L10:
        if (r4.startsWith(r2.getAbsolutePath()) == false) goto L12;
        return true;
    L17:
        e = move-exception;
        e.printStackTrace();
        Logger.globalError(TAG, "isSavePathSecurity", "Error:" + e);
        goto L19
    }

    public static boolean isValidDirectory(File r2) {
        if (r2 != null) goto L16;
        return false;
    L16:
    L15:
        return false;
    L6:
        if (r2.exists() == false) goto L8;
    L10:
        if (r2.isDirectory() == true) goto L13;
        return false;
    L13:
        return true;
    L8:
        if (r2.mkdirs() == true) goto L10;
        return false;
    }

    public static File getExternalCacheDir(Context r1, boolean r2) {
        if (externalCacheDir == null) goto L13;
        if (r2 == true) goto L13;
        return externalCacheDir;
    L13:
        externalCacheDir = r1.getExternalCacheDir();     // Catch: Throwable -> L9
    L12:
        return externalCacheDir;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getExternalCacheDir", "Error:" + th);
        goto L12
    }

    public static File getExternalFilesDir(Context r1, boolean r2) {
        if (externalFilesDir == null) goto L13;
        if (r2 == true) goto L13;
        return externalFilesDir;
    L13:
        externalFilesDir = r1.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);     // Catch: Throwable -> L9
    L12:
        return externalFilesDir;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getExternalFilesDir", "Error:" + th);
        goto L12
    }

    public static File getFilesDir(Context r1, boolean r2) {
        if (filesDir == null) goto L13;
        if (r2 == true) goto L13;
        return filesDir;
    L13:
        filesDir = r1.getFilesDir();     // Catch: Throwable -> L9
    L12:
        return filesDir;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getFilesDir", "Error:" + th);
        goto L12
    }

    public static File getObbDirStr(Context r1, boolean r2) {
        if (obbDir == null) goto L13;
        if (r2 == true) goto L13;
        return obbDir;
    L13:
        obbDir = r1.getObbDir();     // Catch: Throwable -> L9
    L12:
        return obbDir;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getObbDirStr", "Error:" + th);
        goto L12
    }
}
