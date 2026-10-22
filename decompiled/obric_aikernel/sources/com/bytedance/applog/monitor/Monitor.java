package com.bytedance.applog.monitor;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.apm6.util.constant.CommonConsts;
import f1.g;
import f1.o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class Monitor implements Handler.Callback {
    public static long INTERVAL_REPORT = 86400000;
    private static final long INTERVAL_SAVE = 10000;
    public static final long INVALIDATE_DURATION = -1;
    static final int MSG_LOAD = 1;
    private static final int MSG_RECORD_COUNT = 2;
    private static final int MSG_RECORD_TIME = 3;
    private static final int MSG_SAVE = 4;
    private static final int version_code = 3;
    private volatile boolean loaded;
    private Context mContext;
    private long mInstallTime;
    private long mLastReportTs;
    private g mLogger;
    private Map<String, Map<String, b>> mRecords;
    private volatile boolean mSaving;
    private d mStore;
    private final String mStoreFilePrefix;
    private volatile com.bytedance.applog.monitor.b mUploader;
    private final Handler mWorkHandler;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f1194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f1195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1196c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f1197d;

        public a(String r10, String r11, int r12, long r13) {
            this.f1194a = r10;
            this.f1195b = r11;
            this.f1196c = r12;
            this.f1197d = r13;
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f1199b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f1200c;

        public b() {
            this.f1200c = System.currentTimeMillis();
        }

        public b(long r10) {
            this.f1200c = r10;
        }
    }

    static {
    }

    public Monitor(Looper r10, com.bytedance.applog.monitor.b r11, String r12) {
        this.loaded = false;
        this.mRecords = new ConcurrentHashMap();
        this.mInstallTime = 0;
        this.mStoreFilePrefix = r12;
        this.mUploader = r11;
        if (r10 != null) goto L5;
        HandlerThread r13 = new HandlerThread("bd_monitor_wt");
        r13.start();
        r10 = r13.getLooper();
    L5:
        this.mWorkHandler = new Handler(r10, this);
        this.mLogger = new o("AppLog:Monitor");
    }

    private void doRecord(Message r10) {
        if (this.mContext != null) goto L5;
    L9:
        a r11 = (a) r10.obj;
        String r12 = r11.f1194a;
        String r13 = r11.f1195b;
        int r14 = r11.f1196c;
        long r15 = r11.f1197d;
        Map<String, b> r16 = this.mRecords.get(r12);
        if (r16 != null) goto L12;
        r16 = new HashMap(4);
        this.mRecords.put(r12, r16);
    L12:
        b r17 = r16.get(r13);
        if (r17 != null) goto L15;
        r17 = new b();
    L15:
        int r18 = r10.what;
        if (r18 != 2) goto L19;
        r17.f1198a += r14;
        r17.f1199b = -1;
    L21:
        r16.put(r13, r17);
        return;
    L19:
        if (r18 != 3) goto L21;
        r17.f1199b += r15;
        r17.f1198a++;
        goto L21
    L5:
        if (this.mSaving == true) goto L9;
        if (this.loaded == false) goto L9;
        this.mSaving = true;
        this.mWorkHandler.removeMessages(4);
        this.mWorkHandler.sendEmptyMessageDelayed(4, 10000);
        goto L9
    }

    private void doSave() {
        d r10 = this.mStore;
        if (r10 != null) goto L5;
        this.mStore = new d(this.mContext, this.mStoreFilePrefix, this.mLogger);
    L7:
        if (this.mRecords.isEmpty() == false) goto L9;
        return;
    L9:
        this.mStore.e(this.mLastReportTs, e.c(this.mRecords));
        return;
    L5:
        r10.b();
        goto L7
    }

    private void load() {
        if (this.mContext != null) goto L6;
        return;
    L6:
        if (this.mStore != null) goto L8;
        this.mStore = new d(this.mContext, this.mStoreFilePrefix, this.mLogger);
    L8:
        d.a r10 = this.mStore.c();
        this.mRecords = e.d(new Map[]{e.b(r10.f1212b), this.mRecords});
        this.mLastReportTs = r10.f1211a;
        loadInstallTimeOrSaveNow();
        this.loaded = true;
    }

    private void loadInstallTimeOrSaveNow() {
        Context r10 = this.mContext;
        if (r10 != null) goto L16;
        this.mLogger.s(8, "loadInstallTimeOrSaveNow: context is null", new Object[0]);
        return;
    L16:
        SharedPreferences r11 = r10.getSharedPreferences(this.mStoreFilePrefix + CommonConsts.LOG_REPORT_TYPE_DEFAULT, 0);     // Catch: Throwable -> L12
        long r12 = r11.getLong("monitor_install_time3", 0);     // Catch: Throwable -> L12
        this.mInstallTime = r12;     // Catch: Throwable -> L12
        if (r12 > 0) goto L9;
    L10:
        this.mInstallTime = System.currentTimeMillis();     // Catch: Throwable -> L12
        r11.edit().putLong("monitor_install_time3", this.mInstallTime).apply();     // Catch: Throwable -> L12
    L14:
        this.mLogger.h(8, "loadInstallTimeOrSaveNow: mInstallTime = " + this.mInstallTime, new Object[0]);
        return;
    L9:
        if (r12 <= System.currentTimeMillis()) goto L14;
    L12:
        th = move-exception;
        this.mLogger.v(8, "loadInstallTimeOrSaveNow error", th, new Object[0]);
        goto L14
    }

    private boolean report() {
        List<c> r10 = e.a(this.mRecords);
        if (this.mUploader != null) goto L5;
    L9:
        return false;
    L5:
        if (r10.size() == 0) goto L9;
        this.mLogger.h(8, "[report]: reportDataLists:" + r10.size(), new Object[0]);
        return this.mUploader.a(r10);
    }

    private void save() {
        if (this.mContext != null) goto L6;
        this.mSaving = false;
        return;
    L6:
        long r10 = System.currentTimeMillis();
        if (Math.abs(r10 - this.mLastReportTs) >= INTERVAL_REPORT) goto L9;
    L11:
        this.mSaving = false;
        doSave();
        return;
    L9:
        if (report() == false) goto L11;
        this.mLastReportTs = r10;
        this.mRecords.clear();
        goto L11
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r10) {
        int r11 = r10.what;
        if (r11 != 1) goto L5;
        load();
    L14:
        return true;
    L5:
        if (r11 != 2) goto L7;
    L12:
        doRecord(r10);
        goto L14
    L7:
        if (r11 == 3) goto L12;
        if (r11 != 4) goto L14;
        save();
        goto L14
    }

    public void record(String r10, String r11) {
        recordCount(r10, r11, 1);
    }

    public void recordCount(String r10, String r11, int r12) {
        if (r10 == null) goto L8;
        if (r11 == null) goto L9;
        if (r12 <= 0) goto L10;
        recordCustomCount(r10, r11, r12);
        return;
    L10:
        return;
    L9:
        return;
    }

    public void recordCustom(String r10, String r11) {
        recordCustomCount(r10, r11, 1);
    }

    public void recordCustomCount(String r10, String r11, int r12) {
        if (r10 == null) goto L8;
        if (r11 == null) goto L9;
        if (r12 <= 0) goto L10;
        this.mWorkHandler.obtainMessage(2, new a(r10, r11, r12, -1)).sendToTarget();
        return;
    L10:
        return;
    L9:
        return;
    }

    public void recordCustomState(String r10, String r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        recordCustomCount(r10, r11, 1);
    }

    public void recordCustomTime(String r10, String r11, long r12) {
        if (r10 == null) goto L9;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r12 <= 0) goto L11;
        this.mWorkHandler.obtainMessage(3, new a(r10, r11, 0, r12)).sendToTarget();
        return;
    L11:
        return;
    }

    public void recordTime(String r10, String r11, long r12) {
        if (r10 == null) goto L9;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r12 <= 0) goto L11;
        recordCustomTime(r10, r11, r12);
        return;
    L11:
        return;
    }

    public void setContext(Context r10) {
        this.mContext = r10;
        this.mWorkHandler.sendEmptyMessage(1);
    }

    public void setContext(Context r10, long r11) {
        this.mContext = r10;
        this.mWorkHandler.sendEmptyMessageDelayed(1, r11);
    }

    public void setLogger(g r10) {
        this.mLogger = r10;
    }

    public void setMonitorUploader(com.bytedance.applog.monitor.b r10) {
        this.mUploader = r10;
    }

    public void setReportInterval(long r10) {
        INTERVAL_REPORT = Math.min(r10, 3600000);
    }
}
