package com.ss.android.socialbase.downloader.cleaner;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDirectoryCleanerListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DirectoryCleaner implements CleanerImpl$CleanerHandler {
    private static final String TAG = "DirectoryCleaner";
    private static volatile boolean sEnabled;
    private static volatile long sExpiredTime;
    private long mCleanDuration;
    private CleanerConfig mCleanerConfig;
    private CleanerImpl mCleanerImpl;
    private int mDeleteFileCount;
    private IDirectoryCleanerListener mDirectoryCleanerListener;
    private String mPackageName;
    private int mSearchDBCount;

    @Override // com.ss.android.socialbase.downloader.cleaner.CleanerImpl$CleanerHandler
    public void start() {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "start", "Run");
    L5:
        long r5 = System.nanoTime();
        startImpl();     // Catch: Throwable -> L13
        if (Logger.debug() == false) goto L10;
        Logger.globalDebug(TAG, "start", "Run End");
    L10:
        long r6 = ((System.nanoTime() - r5) / 1000) / 1000;
        this.mCleanDuration = r6;
        IDirectoryCleanerListener r2 = this.mDirectoryCleanerListener;
        if (r2 == null) goto L34;
        r2.onFinish(null, this.mSearchDBCount, this.mDeleteFileCount, r6);
        return;
    L34:
        return;
    L13:
        th = move-exception;
        Logger.globalError(TAG, "start", "Error:" + th);     // Catch: Throwable -> L22
        if (Logger.debug() == false) goto L18;
        Logger.globalDebug(TAG, "start", "Run End");
    L18:
        long r12 = ((System.nanoTime() - r5) / 1000) / 1000;
        this.mCleanDuration = r12;
        IDirectoryCleanerListener r8 = this.mDirectoryCleanerListener;
        if (r8 == null) goto L36;
        r8.onFinish(th, this.mSearchDBCount, this.mDeleteFileCount, r12);
        return;
    L36:
        return;
    L22:
        th = move-exception;
        if (Logger.debug() == false) goto L26;
        Logger.globalDebug(TAG, "start", "Run End");
    L26:
        long r11 = ((System.nanoTime() - r5) / 1000) / 1000;
        this.mCleanDuration = r11;
        IDirectoryCleanerListener r7 = this.mDirectoryCleanerListener;
        if (r7 == null) goto L29;
        r7.onFinish(null, this.mSearchDBCount, this.mDeleteFileCount, r11);
    L29:
        throw th;
    }

    private void startImpl() {
        Context r0 = DownloadComponentManager.getAppContext();
        if (r0 != null) goto L6;
        Logger.globalError(TAG, "init", "Error context is null");
        return;
    L6:
        this.mPackageName = r0.getPackageName();
        if (sExpiredTime >= 0) goto L10;
        sExpiredTime = DownloadSetting.obtainGlobal().optInt("clean_directory_expired_time_d", -1);
    L10:
        if (Logger.debug() == false) goto L13;
        Logger.globalDebug(TAG, "init", "ExpiredTime" + sExpiredTime);
    L13:
        if (sExpiredTime >= 0) goto L15;
        return;
    L15:
        sExpiredTime *= DownloadConstants.DAY;
        CleanerConfig r1 = this.mCleanerConfig;
        if (r1 == null) goto L18;
        r1.updateCleanDirectoryTime();
    L18:
        JSONArray r2 = DownloadSetting.obtainGlobal().optJSONArray("clean_directory_list");
        if (r2 != null) goto L21;
        return;
    L21:
        if (r2.length() <= 0) goto L79;
        int r3 = 0;
    L25:
        if (r3 >= r2.length()) goto L80;
        JSONObject r4 = r2.optJSONObject(r3);
        if (r4 == null) goto L66;
        String r5 = r4.optString("directory_path");
        if (Logger.debug() == false) goto L33;
        Logger.globalDebug(TAG, "startImpl", "Run directoryPath:" + r5);
    L33:
        if (TextUtils.isEmpty(r5) == true) goto L66;
        JSONArray r6 = r4.optJSONArray("path_contains_list");
        ArrayList r7 = new ArrayList();
        if (r6 != null) goto L38;
    L46:
        File r8 = CleanerConfig.getRealExternalFile(r5, this.mPackageName);
        if (r8 != null) goto L49;
    L51:
        CleanerImpl r9 = this.mCleanerImpl;
        if (r9 != null) goto L54;
    L56:
        File r10 = CleanerConfig.getRealInternalFile(r5, this.mPackageName);
        if (r10 != null) goto L59;
    L61:
        CleanerImpl r11 = this.mCleanerImpl;
        if (r11 == null) goto L66;
        if (r11.isStop() == false) goto L66;
        return;
    L59:
        if (r10.isDirectory() == false) goto L61;
        deleteCacheData(r10, r7);
        goto L61
    L54:
        if (r9.isStop() == false) goto L56;
        return;
    L49:
        if (r8.isDirectory() == false) goto L51;
        deleteCacheData(r8, r7);
        goto L66
    L38:
        if (r6.length() <= 0) goto L46;
        int r12 = 0;
    L41:
        if (r12 >= r6.length()) goto L46;
        String r13 = r6.optString(r12);
        if (TextUtils.isEmpty(r13) == true) goto L45;
        r7.add(r13);
    L45:
        r12 = r12 + 1;
    L66:
        r3 = r3 + 1;
        goto L25
    L80:
        return;
    }

    public DirectoryCleaner() {
    }

    public static /* synthetic */ long access$000() {
        return sExpiredTime;
    }

    public static boolean isEnabled() {
        return sEnabled;
    }

    public static void init(CleanerConfig r11) {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "init", "Run");
    L5:
        DownloadSetting r0 = DownloadSetting.obtainGlobal();
        if (r0.optInt("auto_clean_directory") > 0) goto L8;
        return;
    L8:
        JSONArray r3 = r0.optJSONArray("clean_directory_list");
        if (r3 != null) goto L11;
        return;
    L11:
        if (r3.length() <= 0) goto L32;
        int r1 = r0.optInt("clean_directory_check_interval_d");
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "init", "Clean_directory_check_interval_d:" + r1 + " clean_directory_list:" + r3);
    L16:
        if (r1 <= 0) goto L25;
        long r4 = r11.getLastCleanDirectoryTime();
        if (r4 <= 0) goto L25;
        if ((System.currentTimeMillis() - r4) >= (((long) r1) * DownloadConstants.DAY)) goto L25;
        if (Logger.debug() == false) goto L29;
        Logger.globalDebug(TAG, "start", "It has already been clean, lastCleanTime:" + r4);
        return;
    L29:
        return;
    L25:
        sEnabled = true;
        if (Logger.debug() == false) goto L31;
        Logger.globalDebug(TAG, "init", "Run End");
        return;
    L31:
        return;
    }

    public void setDirectoryCleanerListener(IDirectoryCleanerListener r1) {
        this.mDirectoryCleanerListener = r1;
    }

    public DirectoryCleaner(CleanerImpl r1, CleanerConfig r2) {
        this.mCleanerImpl = r1;
        this.mCleanerConfig = r2;
    }

    private void deleteCacheData(File r9, List<String> r10) {
        List<File> r11 = getExpiredFiles(r9, r10);
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isEmpty() == true) goto L35;
        Map r12 = Downloader.getInstance(DownloadComponentManager.getAppContext()).getInstalledTimeStampBySavePath(r9.getAbsolutePath() + "%");
        if (r12 == null) goto L10;
        this.mSearchDBCount += r12.size();
    L10:
        Iterator<File> r13 = r11.iterator();
    L12:
        if (r13.hasNext() == false) goto L36;
        File r0 = r13.next();
        CleanerImpl r1 = this.mCleanerImpl;
        if (r1 != null) goto L16;
    L18:
        String r2 = r0.getAbsolutePath();
        if (r12 == null) goto L25;
        Pair r3 = (Pair) r12.get(r2.toLowerCase(Locale.getDefault()));
        if (r3 == null) goto L25;
        if (((Long) r3.second).longValue() > 0) goto L25;
        DownloadComponentManager.getDownloadCache().removeDownloadTaskData(((Integer) r3.first).intValue());
    L25:
        r0.delete();
        this.mDeleteFileCount++;
        if (Logger.debug() == false) goto L12;
        Logger.globalDebug(TAG, "deleteCacheDataImpl", "Delete DownloadData:" + r2);
        goto L12
    L16:
        if (r1.isStop() == false) goto L18;
        return;
    L36:
        return;
    }

    private List<File> getExpiredFiles(File r10, List<String> r11) {
        long r3 = System.currentTimeMillis();
        ArrayList r7 = new ArrayList();
        LinkedList r8 = new LinkedList();
        r8.add(r10);
        FileFilter r12 = new 1(this, r11, r3, r7, r8);
    L4:
        if (r8.isEmpty() == true) goto L6;
        ((File) r8.poll()).listFiles(r12);
        goto L4
    L6:
        return r7;
    }
}
