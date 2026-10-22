package com.bytedance.crash.dumper;

import android.util.Pair;
import com.bytedance.crash.NpthCore;
import com.bytedance.crash.tracker.BatteryTracker;
import com.bytedance.crash.util.SerializeFactory;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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

    public static void dump(File r3) {
        Scraps r0 = new Scraps();
        r0.dumpMiniApp();
        r0.dumpStorage();
        r0.dumpBattery();
        SerializeFactory.store(new File(r3, FILE_NAME), r0);
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
        Pair<Long, Long> r0 = Storage.getSdcardStorage();
        this.mSdcardTotalSize = ((Long) ZeusTransformUtils.preCheckCast(r0.first, Long.class, "com.obric.memorydata.plugin")).longValue();
        this.mSdcardFreeSize = ((Long) ZeusTransformUtils.preCheckCast(r0.second, Long.class, "com.obric.memorydata.plugin")).longValue();
    }

    private void loadBattery(JSONObject r2) {
        r2.put(BATTERY, this.mBatteryLevel);     // Catch: Throwable -> L4
        return;
    }

    private void loadStorage(JSONObject r5) {
        JSONObject r0 = new JSONObject();
        r0.put(SDCARD_TOTAL, Storage.formatSize(this.mSdcardTotalSize));     // Catch: Throwable -> L5
        r0.put(SDCARD_FREE, Storage.formatSize(this.mSdcardFreeSize));     // Catch: Throwable -> L5
        r0.put(INNER_FREE, Storage.getStorageRange(this.mStorageFreeSize));     // Catch: Throwable -> L5
        r0.put(INNER_TOTAL, Storage.getStorageRange(this.mStorageTotalSize));     // Catch: Throwable -> L5
        r0.put(INNER_FREE_REAL, Storage.formatSize(this.mStorageFreeSize));     // Catch: Throwable -> L5
        r0.put(INNER_TOTAL_REAL, Storage.formatSize(this.mStorageTotalSize));     // Catch: Throwable -> L5
        r0.put(INNER_UNIT, Storage.UNIT);     // Catch: Throwable -> L5
        r5.put(STORAGE, r0);     // Catch: Throwable -> L5
        return;
    }

    public static void pushTo(JSONObject r1) {
        pushTo(r1, null);
    }

    public static void pushTo(JSONObject r2, File r3) {
        if (r3 == null) goto L4;
        Scraps r4 = (Scraps) ZeusTransformUtils.preCheckCast(SerializeFactory.load(new File(r3, FILE_NAME)), Scraps.class, "com.obric.memorydata.plugin");
    L5:
        if (r4 != null) goto L7;
        r4 = new Scraps();
        r4.dumpMiniApp();
        r4.dumpStorage();
        r4.dumpBattery();
    L7:
        r4.loadMiniApp(r2);
        r4.loadStorage(r2);
        r4.loadBattery(r2);
        return;
    L4:
        r4 = null;
        goto L5
    }

    public void loadMiniApp(JSONObject r4) {
        if (this.mIsMiniApp == false) goto L6;
        r4.put("is_mp", 1);     // Catch: Throwable -> L8
        r4.put("miniapp_id", this.mMiniAppId);     // Catch: Throwable -> L8
        r4.put("miniapp_version", this.mMiniAppVersion);     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        r4.put("miniapp_id", 0);     // Catch: Throwable -> L8
    }
}
