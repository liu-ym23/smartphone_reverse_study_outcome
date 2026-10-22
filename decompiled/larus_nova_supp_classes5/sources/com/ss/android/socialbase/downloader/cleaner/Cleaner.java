package com.ss.android.socialbase.downloader.cleaner;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class Cleaner {
    private static volatile Cleaner INSTANCE = null;
    private static final String TAG = "Cleaner";
    private static AtomicBoolean mIsRunCleaner;
    private volatile CleanerConfig mCleanerConfig;

    public void start() {
        start(false);
    }

    static {
        mIsRunCleaner = new AtomicBoolean();
        INSTANCE = null;
    }

    public static Cleaner getInstance() {
        if (INSTANCE != null) goto L15;
        monitor-enter(Cleaner.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (INSTANCE != null) goto L9;
        INSTANCE = new Cleaner();     // Catch: Throwable -> L11
    L9:
        monitor-exit(Cleaner.class);     // Catch: Throwable -> L11
    L15:
        return INSTANCE;
    }

    public CacheKeyCleaner getCacheKeyCleaner() {
        return new CacheKeyCleaner(null, this.mCleanerConfig);
    }

    public boolean isNeedClean() {
        return this.mCleanerConfig.isNeedClean();
    }

    public Cleaner() {
        this.mCleanerConfig = new CleanerConfig();
    }

    public void init() {
        if (Logger.debug() == false) goto L5;
        long r0 = System.currentTimeMillis();
    L6:
        this.mCleanerConfig.init();
        if (Logger.debug() == false) goto L10;
        Logger.globalDebug(TAG, "init", "Cleaner init cost time=" + (System.currentTimeMillis() - r0));
        return;
    L10:
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public CleanerConfig getCleanerConfig() {
        return this.mCleanerConfig;
    }

    public static /* synthetic */ CleanerConfig access$000(Cleaner r0) {
        return r0.mCleanerConfig;
    }

    private void startImpl(boolean r5) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "start", "enter Cleaner start");
    L6:
        if (DownloadHelper.isMainProcess() == true) goto L9;
        this.mCleanerConfig.finish();
        return;
    L9:
        FastDownloadCleaner.start();
        CacheStatistics.start(this.mCleanerConfig);
        int r0 = DownloadSetting.obtainGlobal().optInt("start_clean_delay_time_s");
        if (Logger.debug() == false) goto L12;
        Logger.globalDebug(TAG, "run", "Run cleaner startCleanDelayTime: " + r0 + " isCacheCleanEnabled:" + this.mCleanerConfig.isCacheCleanEnabled());
    L12:
        if (r0 > 0) goto L14;
    L21:
        this.mCleanerConfig.finish();
        return;
    L14:
        if (this.mCleanerConfig.isCacheCleanEnabled() == false) goto L21;
        1 r1 = new 1(this);
        if (r5 == false) goto L19;
        r1.run();
        return;
    L19:
        DownloadComponentManager.submitScheduleTask(r1, r0, TimeUnit.SECONDS);
    }

    public boolean isExistInCleanSet(int r2) {
        if (r2 != 0) goto L6;
        return false;
    L6:
        return this.mCleanerConfig.isExistInCleanSet(r2);
    }

    public void removeFromCleanSet(int r2) {
        this.mCleanerConfig.removeFromCleanDownloadIdSet(r2);
    }

    public void start(boolean r4) {
        if (mIsRunCleaner.compareAndSet(false, true) == false) goto L6;
        startImpl(r4);
        return;
    }

    public boolean updateCleanDownloadId(DownloadInfo r2) {
        return updateCleanDownloadId(new CleanDownloadInfo(r2));
    }

    public boolean updateCleanDownloadId(CleanDownloadInfo r2) {
        return this.mCleanerConfig.updateCleanDownloadId(r2);
    }

    public boolean forceUpdateCleanDownloadId(DownloadInfo r2, boolean r3) {
        return forceUpdateCleanDownloadId(new CleanDownloadInfo(r2), r3);
    }

    public boolean forceUpdateCleanDownloadId(CleanDownloadInfo r2, boolean r3) {
        return this.mCleanerConfig.forceUpdateCleanDownloadId(r2, r3);
    }
}
