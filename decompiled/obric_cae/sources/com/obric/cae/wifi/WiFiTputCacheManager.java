package com.obric.cae.wifi;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings;
import android.util.Log;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.smartNetwork.CloudConfigParseAndSave;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class WiFiTputCacheManager {
    private static final int CACHE_MAX_SIZE = 20;
    private static final long CLEANUP_INTERVAL_MS = 86400000;
    private static final long EXPIRE_SECONDS_30_DAYS = 2592000;
    private static final long FLUSH_INTERVAL = 10000;
    private static final int MAX_SAMPLES_PER_COMBO = 100;
    private static final String TAG = "WiFiTputCache";
    private static volatile WiFiTputCacheManager instance;
    private final ConcurrentHashMap<String, CacheItem> cacheMap;
    private final Object cleanupLock;
    private final WiFiTputManager dbManager;
    private float emaAlpha;
    private final Object evictionLock;
    private final Handler flushHandler;
    private final Object flushStateLock;
    private HandlerThread flushThread;
    private long lastCleanupMs;
    private volatile boolean periodicFlushEnabled;
    private final Runnable periodicFlushRunnable;
    private volatile boolean wifiConnected;

    public static class CacheItem {
        int emaTput;
        long lastFlushTime;
        long lastUpdateTime;
        int sampleCount;
        int tempSampleCount;

        private CacheItem() {
        }

        public /* synthetic */ CacheItem(AnonymousClass1 r8) {
            this();
        }
    }

    private WiFiTputCacheManager(Context r8) {
        this.cacheMap = new ConcurrentHashMap();
        this.emaAlpha = 0.1f;
        this.flushStateLock = new Object();
        this.wifiConnected = true;
        this.periodicFlushEnabled = true;
        this.periodicFlushRunnable = new AnonymousClass1(this);
        this.cleanupLock = new Object();
        this.lastCleanupMs = 0;
        this.evictionLock = new Object();
        this.dbManager = WiFiTputManager.getInstance(r8);
        float r10 = Settings.Global.getFloat(r8.getContentResolver(), CloudConfigParseAndSave.SETTINGS_GLOBAL_WIFI_TPUT_EMA_WEIGHT, 0.1f);     // Catch: Throwable -> L10
        this.emaAlpha = r10;     // Catch: Throwable -> L10
        if (r10 >= 0.0f) goto L7;
        this.emaAlpha = 0.0f;     // Catch: Throwable -> L10
    L7:
        if (this.emaAlpha <= 1.0f) goto L12;
        this.emaAlpha = 1.0f;     // Catch: Throwable -> L10
    L12:
        HandlerThread r11 = new HandlerThread("WiFiTputFlushThread");
        this.flushThread = r11;
        r11.start();
        this.flushHandler = new Handler(this.flushThread.getLooper());
        startPeriodicFlush();
        return;
    L10:
        e = move-exception;
        Log.e(TAG, "read ema weight failed, use default 0.1", e);
        this.emaAlpha = 0.1f;
        goto L12
    }

    public static /* synthetic */ CacheItem a(WiFiTputCacheManager r8, boolean[] r10, String r11, int r12, long r13, int r14, String r15, CacheItem r16) {
        return r8.lambda$updateTput$0(r10, r11, r12, r13, r14, r15, r16);
    }

    public static /* synthetic */ boolean access$000(WiFiTputCacheManager r8) {
        return r8.periodicFlushEnabled;
    }

    public static /* synthetic */ boolean access$100(WiFiTputCacheManager r8) {
        return r8.wifiConnected;
    }

    public static /* synthetic */ void access$200(WiFiTputCacheManager r8) {
        r8.maybeCleanExpiredRows();
    }

    public static /* synthetic */ Handler access$300(WiFiTputCacheManager r8) {
        return r8.flushHandler;
    }

    private void evictOldestIfNeeded() {
        if (this.cacheMap.size() > 20) goto L5;
        return;
    L5:
        Object r8 = this.evictionLock;
        monitor-enter(r8);
    L30:
    L27:
        th = move-exception;
        throw th;
    L8:
        if (this.cacheMap.size() <= 20) goto L25;
        Iterator<Map.Entry<String, CacheItem>> r10 = this.cacheMap.entrySet().iterator();     // Catch: Throwable -> L27
        String r11 = null;
        long r12 = Long.MAX_VALUE;
    L11:
        if (r10.hasNext() == false) goto L22;
        Map.Entry<String, CacheItem> r13 = r10.next();     // Catch: Throwable -> L27
        CacheItem r14 = r13.getValue();     // Catch: Throwable -> L27
        long r15 = 0;
        if (r14 == null) goto L17;
        long r16 = r14.lastUpdateTime;     // Catch: Throwable -> L27
        if (r16 <= 0) goto L17;
        r15 = r16;
    L20:
        if (r15 >= r12) goto L11;
        r11 = r13.getKey();     // Catch: Throwable -> L27
        r12 = r15;
    L17:
        if (r14 == null) goto L20;
        r15 = r14.lastFlushTime;     // Catch: Throwable -> L27
        goto L20
    L22:
        if (r11 == null) goto L25;
        this.cacheMap.remove(r11);     // Catch: Throwable -> L27
        Log.d(TAG, "evictOldestIfNeeded: evict key=" + r11 + ", ts=" + r12 + ", cacheSize=" + this.cacheMap.size());     // Catch: Throwable -> L27
    L25:
        monitor-exit(r8);     // Catch: Throwable -> L27
    }

    public static WiFiTputCacheManager getInstance() {
        if (instance == null) goto L7;
        return instance;
    L7:
        throw new IllegalStateException("please call getInstance(Context) first");
    }

    private /* synthetic */ CacheItem lambda$updateTput$0(boolean[] r8, String r10, int r11, long r12, int r13, String r14, CacheItem r15) {
        if (r15 != null) goto L11;
        r8[0] = true;
        r15 = new CacheItem(null);
        r15.emaTput = this.dbManager.getEmaTput(r10, r11);     // Catch: Exception -> L7
        r15.sampleCount = this.dbManager.getSampleCount(r10, r11);     // Catch: Exception -> L7
    L9:
        r15.tempSampleCount = 0;
        r15.lastFlushTime = r12;
        r15.lastUpdateTime = r12;
    L7:
        e = move-exception;
        Log.e(TAG, "seed from db failed", e);
        r15.emaTput = 0;
        r15.sampleCount = 0;
    L11:
        if (r15.sampleCount != 0) goto L13;
        r15.emaTput = r13;
    L14:
        r15.sampleCount++;
        int r16 = r15.tempSampleCount + 1;
        r15.tempSampleCount = r16;
        r15.lastUpdateTime = r12;
        if (r16 < 100) goto L17;
        r15.tempSampleCount = 0;
    L17:
        return r15;
    L13:
        r15.emaTput = EmaCalculator.calculateEmaIntWithAlpha(r13, r15.emaTput, this.emaAlpha);
        goto L14
    }

    private void maybeCleanExpiredRows() {
        long r8 = System.currentTimeMillis();
        Object r10 = this.cleanupLock;
        monitor-enter(r10);
        long r11 = this.lastCleanupMs;     // Catch: Throwable -> L17
        if (r11 != 0) goto L7;
    L10:
        this.lastCleanupMs = r8;     // Catch: Throwable -> L17
        monitor-exit(r10);     // Catch: Throwable -> L17
        this.dbManager.cleanExpiredData(EXPIRE_SECONDS_30_DAYS);     // Catch: Throwable -> L14
        Log.d(TAG, "cleanExpiredData success");     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Log.e(TAG, "cleanExpiredData failed", th);
        return;
    L7:
        if ((r8 - r11) >= 86400000) goto L10;
        monitor-exit(r10);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private static String normalizeBssid(String r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        return r8.trim().toLowerCase();
    }

    private void startPeriodicFlush() {
        this.flushHandler.postDelayed(this.periodicFlushRunnable, 10000);
    }

    public boolean addOrUpdateData(String r8, int r10, int r11) {
        updateTput(r8, r10, r11);     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        Log.e(TAG, "addOrUpdateData failed", e);
        return false;
    }

    public void flushCacheToDb() {
        if (this.cacheMap.isEmpty() == false) goto L6;
        Log.d(TAG, "flushCacheToDb: cache is empty");
        return;
    L6:
        Iterator<Map.Entry<String, CacheItem>> r8 = this.cacheMap.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L20;
        Map.Entry<String, CacheItem> r10 = r8.next();
        String r11 = r10.getKey();     // Catch: Throwable -> L18
        int r12 = r11.lastIndexOf(58);     // Catch: Throwable -> L18
        if (r12 <= 0) goto L16;
        if (r12 >= (r11.length() - 1)) goto L16;
        String r13 = r11.substring(0, r12);     // Catch: Throwable -> L18
        int r14 = Integer.parseInt(r11.substring(r12 + 1));     // Catch: Throwable -> L18
        CacheItem r15 = r10.getValue();     // Catch: Throwable -> L18
        this.dbManager.upsertEmaTput(r13, r14, Math.round(r15.emaTput), r15.sampleCount);     // Catch: Throwable -> L18
        r15.lastFlushTime = System.currentTimeMillis();     // Catch: Throwable -> L18
    L16:
        Log.w(TAG, "flushCacheToDb: invalid key=" + r11);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Log.e(TAG, "flushCacheToDb failed for key=" + r10.getKey(), th);
        goto L8
    }

    public int getCountByBssidAndRssi(String r8, int r10) {
        String r11 = normalizeBssid(r8);     // Catch: Exception -> L16
        if (r11 != null) goto L6;
    L14:
        Log.d(TAG, "getCountByBssidAndRssi: empty bssid, return 0");     // Catch: Exception -> L16
        return 0;
    L6:
        if (r11.isEmpty() == true) goto L14;
        int r12 = EmaCalculator.groupRssiBy3dB(r10);     // Catch: Exception -> L16
        CacheItem r13 = this.cacheMap.get(r11 + BdimCategoryConstants.SEPARATOR_COLON + r12);     // Catch: Exception -> L16
        if (r13 == null) goto L13;
        return r13.sampleCount;
    L13:
        return this.dbManager.getSampleCount(r11, r12);
    L16:
        e = move-exception;
        Log.e(TAG, "getCountByBssidAndRssi failed", e);
        return 0;
    }

    public int getCurrentEmaTput(String r8, int r10) {
        CacheItem r11 = this.cacheMap.get(normalizeBssid(r8) + BdimCategoryConstants.SEPARATOR_COLON + EmaCalculator.groupRssiBy3dB(r10));
        if (r11 != null) goto L6;
        return 0;
    L6:
        return r11.emaTput;
    }

    public List<Integer> getScannedFreqsMhz(String r8, String r10) {
        WiFiTputManager r11 = this.dbManager;
        if (r11 == null) goto L7;
        return r11.getScannedFreqsMhz(r8, r10);
    L7:
        return new ArrayList();
    }

    public void insertBandRecords(List<ScannedBandRecord> r8) {
        WiFiTputManager r10 = this.dbManager;
        if (r10 == null) goto L6;
        r10.insertBandRecords(r8);
        return;
    }

    public void onWifiConnectionStateChanged(boolean r8) {
        this.wifiConnected = r8;
        if (r8 == true) goto L17;
        Object r10 = this.flushStateLock;
        monitor-enter(r10);
        this.periodicFlushEnabled = false;     // Catch: Throwable -> L14
        this.flushHandler.removeCallbacks(this.periodicFlushRunnable);     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
        flushCacheToDb();     // Catch: Throwable -> L11
    L13:
        int r11 = this.cacheMap.size();
        this.cacheMap.clear();
        String r12 = TAG;
        String r13 = "wifi disconnected: cleared cache size=" + r11;
    L24:
        Log.d(r12, r13);
        return;
    L11:
        th = move-exception;
        Log.e(TAG, "flush on wifi disconnect failed", th);
    L14:
        th = move-exception;
        throw th;
    L17:
        Object r14 = this.flushStateLock;
        monitor-enter(r14);
    L26:
        th = move-exception;
        throw th;
    L20:
        if (this.periodicFlushEnabled == true) goto L22;
        this.periodicFlushEnabled = true;     // Catch: Throwable -> L26
        this.flushHandler.removeCallbacks(this.periodicFlushRunnable);     // Catch: Throwable -> L26
        this.flushHandler.postDelayed(this.periodicFlushRunnable, 10000);     // Catch: Throwable -> L26
    L22:
        monitor-exit(r14);     // Catch: Throwable -> L26
        r12 = TAG;
        r13 = "wifi connected: resume periodic flush";
        goto L24
    }

    public int queryThroughput(String r8, int r10) {
        String r11 = normalizeBssid(r8);     // Catch: Exception -> L16
        if (r11 != null) goto L6;
    L14:
        Log.d(TAG, "queryThroughput: empty bssid, return -1");     // Catch: Exception -> L16
        return -1;
    L6:
        if (r11.isEmpty() == true) goto L14;
        int r12 = getCurrentEmaTput(r11, r10);     // Catch: Exception -> L16
        if (r12 > 0) goto L11;
        int r13 = EmaCalculator.groupRssiBy3dB(r10);     // Catch: Exception -> L16
        r12 = this.dbManager.getEmaTput(r11, r13);     // Catch: Exception -> L16
    L11:
        if (r12 > 0) goto L13;
        return -1;
    L13:
        return r12;
    L16:
        e = move-exception;
        Log.e(TAG, "queryThroughput failed", e);
        return -1;
    }

    public void release() {
        flushCacheToDb();
        this.flushHandler.removeCallbacksAndMessages(null);
        HandlerThread r8 = this.flushThread;
        if (r8 == null) goto L5;
        r8.quitSafely();
        this.flushThread = null;
    L5:
        this.cacheMap.clear();
        this.dbManager.close();
        instance = null;
    }

    public void updateTput(String r11, int r12, final int r13) {
        if (this.wifiConnected == true) goto L7;
        String r10 = "ignore updateTput: wifi not connected";
    L5:
        Log.d(TAG, r10);
        return;
    L7:
        if (r13 > 0) goto L9;
        r10 = "ignore updateTput: non-positive tput, rssi=" + r12 + ", tput=" + r13;
        goto L5
    L9:
        final String r8 = normalizeBssid(r11);
        if (r8 != null) goto L12;
    L18:
        r10 = "ignore updateTput: empty bssid";
        goto L5
    L12:
        if (r8.isEmpty() == true) goto L18;
        final int r14 = EmaCalculator.groupRssiBy3dB(r12);
        String r15 = r8 + BdimCategoryConstants.SEPARATOR_COLON + r14;
        final long r16 = System.currentTimeMillis();
        final boolean[] r17 = new boolean[1];
        this.cacheMap.compute(r15, new h(this, r17, r8, r14, r16, r13));
        if (r17[0] == false) goto L19;
        evictOldestIfNeeded();
        return;
    }

    public static WiFiTputCacheManager getInstance(Context r8) {
        if (instance != null) goto L15;
        monitor-enter(WiFiTputCacheManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new WiFiTputCacheManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(WiFiTputCacheManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }
}
