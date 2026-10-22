package com.bytedance.crash.dumper;

import android.util.Pair;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.bytedance.crash.NpthCore;
import com.bytedance.crash.tracker.BatteryTracker;
import com.bytedance.crash.util.SerializeFactory;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class Scraps implements Serializable {
    public static final String BATTERY = "battery";
    private static final String FILE_NAME = "scraps.inf";
    public static final String INNER_FREE = "inner_free";
    private static final String INNER_FREE_REAL = "inner_free_realUnit";
    public static final String INNER_TOTAL = "inner_total";
    private static final String INNER_TOTAL_REAL = "inner_total_realUnit";
    public static final String INNER_UNIT = "unit";
    public static final String SDCARD_FREE = "sdcard_free";
    private static final String SDCARD_TOTAL = "sdcard_total";
    public static final String STORAGE = "storage";
    private static final long serialVersionUID = 1;
    private int mBatteryLevel;
    private boolean mIsMiniApp;
    private int mMiniAppId;
    private String mMiniAppVersion;
    private long mSdcardFreeSize;
    private long mSdcardTotalSize;
    private long mStorageFreeSize;
    private long mStorageTotalSize;

    public Scraps() {
    }

    public static void dump(File r10) {
        Scraps r11 = new Scraps();
        r11.dumpMiniApp();
        r11.dumpStorage();
        r11.dumpBattery();
        SerializeFactory.store(new File(r10, FILE_NAME), r11);
    }

    private void dumpBattery() {
        this.mBatteryLevel = BatteryTracker.getBatteryLevel();
    }

    private void dumpMiniApp() {
        if (NpthCore.isCurrentMiniAppProcess() == false) goto L5;
        this.mIsMiniApp = true;
        this.mMiniAppId = NpthCore.getMiniAppId();
        this.mMiniAppVersion = NpthCore.getMiniAppVersion();
        return;
    L5:
        this.mIsMiniApp = false;
    }

    private void dumpStorage() {
        this.mStorageTotalSize = Storage.storageTotalSize();
        this.mStorageFreeSize = Storage.storageFreeSize();
        Pair<Long, Long> r10 = Storage.getSdcardStorage();
        this.mSdcardTotalSize = ((Long) r10.first).longValue();
        this.mSdcardFreeSize = ((Long) r10.second).longValue();
    }

    private void loadBattery(@NonNull JSONObject r10) {
        r10.put(BATTERY, this.mBatteryLevel);     // Catch: Throwable -> L4
        return;
    }

    private void loadStorage(@NonNull JSONObject r10) {
        JSONObject r11 = new JSONObject();
        r11.put(SDCARD_TOTAL, Storage.formatSize(this.mSdcardTotalSize));     // Catch: Throwable -> L5
        r11.put(SDCARD_FREE, Storage.formatSize(this.mSdcardFreeSize));     // Catch: Throwable -> L5
        r11.put(INNER_FREE, Storage.getStorageRange(this.mStorageFreeSize));     // Catch: Throwable -> L5
        r11.put(INNER_TOTAL, Storage.getStorageRange(this.mStorageTotalSize));     // Catch: Throwable -> L5
        r11.put(INNER_FREE_REAL, Storage.formatSize(this.mStorageFreeSize));     // Catch: Throwable -> L5
        r11.put(INNER_TOTAL_REAL, Storage.formatSize(this.mStorageTotalSize));     // Catch: Throwable -> L5
        r11.put(INNER_UNIT, Storage.UNIT);     // Catch: Throwable -> L5
        r10.put(STORAGE, r11);     // Catch: Throwable -> L5
        return;
    }

    public static void pushTo(@NonNull JSONObject r10) {
        pushTo(r10, null);
    }

    public static void pushTo(@NonNull JSONObject r10, File r11) {
        if (r11 == null) goto L4;
        Scraps r12 = (Scraps) SerializeFactory.load(new File(r11, FILE_NAME));
    L5:
        if (r12 != null) goto L7;
        r12 = new Scraps();
        r12.dumpMiniApp();
        r12.dumpStorage();
        r12.dumpBattery();
    L7:
        r12.loadMiniApp(r10);
        r12.loadStorage(r10);
        r12.loadBattery(r10);
        return;
    L4:
        r12 = null;
        goto L5
    }

    public void loadMiniApp(@NonNull JSONObject r10) {
        if (this.mIsMiniApp == false) goto L6;
        r10.put("is_mp", 1);     // Catch: Throwable -> L8
        r10.put("miniapp_id", this.mMiniAppId);     // Catch: Throwable -> L8
        r10.put("miniapp_version", this.mMiniAppVersion);     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        r10.put("miniapp_id", 0);     // Catch: Throwable -> L8
    }
}
