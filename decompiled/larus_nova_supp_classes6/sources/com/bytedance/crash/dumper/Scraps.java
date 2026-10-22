package com.bytedance.crash.dumper;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.crash.d0;
import com.bytedance.crash.util.s;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
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

    private void dumpBattery() {
        if (bi4.d.b == null) goto L5;
    L14:
        this.mBatteryLevel = bi4.d.b.a;
        return;
    L5:
        monitor-enter(bi4.d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (bi4.d.b != null) goto L9;
        bi4.d.b = new bi4.d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(bi4.d.class);     // Catch: Throwable -> L11
        goto L14
    }

    private void dumpMiniApp() {
        if (d0.a == false) goto L5;
        this.mIsMiniApp = true;
        this.mMiniAppId = d0.b;
        this.mMiniAppVersion = d0.c;
        return;
    L5:
        this.mIsMiniApp = false;
    }

    private void dumpStorage() {
        Context r0 = com.bytedance.crash.i.getContext();
        long r1 = 0;
        if (r0 != null) goto L39;
    L8:
        long r3 = 0;
    L9:
        this.mStorageTotalSize = r3;
        Context r2 = com.bytedance.crash.i.getContext();
        if (r2 != null) goto L35;
    L15:
        long r4 = 0;
    L16:
        this.mStorageFreeSize = r4;
        String r5 = Environment.getExternalStorageState();     // Catch: Throwable -> L19
    L21:
        if (TextUtils.equals(r5, "mounted") == true) goto L33;
        long r6 = 0;
    L27:
        long r7 = r1;
        r1 = r6;
    L28:
        Pair r8 = new Pair(Long.valueOf(r1), Long.valueOf(r7));
        this.mSdcardTotalSize = ((Long) r8.first).longValue();
        this.mSdcardFreeSize = ((Long) r8.second).longValue();
        return;
    L33:
        StatFs r9 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());     // Catch: Throwable -> L25
        r7 = r9.getAvailableBytes();     // Catch: Throwable -> L25
        r6 = r9.getBlockSizeLong() * r9.getBlockCountLong();
        r1 = r7;
    L25:
        r7 = 0;
    L19:
        r5 = null;
        goto L21
    L35:
        r4 = new StatFs(r2.getFilesDir().getPath()).getFreeBytes();     // Catch: Throwable -> L31
    L39:
        r3 = new StatFs(r0.getFilesDir().getPath()).getTotalBytes();     // Catch: Throwable -> L32
        goto L9
    }

    public static void dump(File r3) {
        Scraps r0 = new Scraps();
        r0.dumpMiniApp();
        r0.dumpStorage();
        r0.dumpBattery();
        s.b(new PolarisFileWrapper(r3, FILE_NAME), r0);
    }

    private void loadBattery(JSONObject r3) {
        r3.put(BATTERY, this.mBatteryLevel);     // Catch: Throwable -> L4
        return;
    }

    private void loadStorage(JSONObject r7) {
        JSONObject r0 = new JSONObject();
        r0.put(SDCARD_TOTAL, this.mSdcardTotalSize / 52428800);     // Catch: Throwable -> L5
        r0.put(SDCARD_FREE, this.mSdcardFreeSize / 52428800);     // Catch: Throwable -> L5
        r0.put(INNER_FREE, p.a(this.mStorageFreeSize));     // Catch: Throwable -> L5
        r0.put(INNER_TOTAL, p.a(this.mStorageTotalSize));     // Catch: Throwable -> L5
        r0.put(INNER_FREE_REAL, this.mStorageFreeSize / 52428800);     // Catch: Throwable -> L5
        r0.put(INNER_TOTAL_REAL, this.mStorageTotalSize / 52428800);     // Catch: Throwable -> L5
        r0.put(INNER_UNIT, 52428800);     // Catch: Throwable -> L5
        r7.put(STORAGE, r0);     // Catch: Throwable -> L5
        return;
    }

    public static void pushTo(JSONObject r1) {
        pushTo(r1, null);
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

    public static void pushTo(JSONObject r2, File r3) {
        if (r3 == null) goto L4;
        Scraps r4 = (Scraps) s.a(new PolarisFileWrapper(r3, FILE_NAME));
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
}
