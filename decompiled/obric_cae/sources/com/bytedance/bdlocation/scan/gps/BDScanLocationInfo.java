package com.bytedance.bdlocation.scan.gps;

import android.os.SystemClock;
import com.bytedance.bdlocation.BDLocation;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BDScanLocationInfo {
    private volatile BDLocation aMapLocation;
    private final boolean gpsUseContinuous;
    private final String locateId;
    private final List<BDGnssInfo> mGnssInfoList;
    private final List<BDGpsInfo> mGpsInfoList;
    private final List<Long> mGpsInfoReportClocks;
    private final List<BDLocation> mGpsLocationList;
    private volatile BDLocation sysLocation;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.gps.BDScanLocationInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bdlocation$scan$gps$BDScanLocationInfo$TakeStrategy = null;

        static {
            int[] r8 = new int[TakeStrategy.values().length];
            $SwitchMap$com$bytedance$bdlocation$scan$gps$BDScanLocationInfo$TakeStrategy = r8;
            r8[TakeStrategy.firstResult.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$bytedance$bdlocation$scan$gps$BDScanLocationInfo$TakeStrategy[TakeStrategy.lastResult.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final enum TakeStrategy extends Enum<TakeStrategy> {
        private static final /* synthetic */ TakeStrategy[] $VALUES = null;
        public static final TakeStrategy firstResult = null;
        public static final TakeStrategy lastResult = null;

        static {
            TakeStrategy r8 = new TakeStrategy("firstResult", 0);
            firstResult = r8;
            TakeStrategy r10 = new TakeStrategy("lastResult", 1);
            lastResult = r10;
            $VALUES = new TakeStrategy[]{r8, r10};
        }

        private TakeStrategy(String r8, int r10) {
            super(r8, r10);
        }

        public static TakeStrategy valueOf(String r8) {
            return (TakeStrategy) Enum.valueOf(TakeStrategy.class, r8);
        }

        public static TakeStrategy[] values() {
            return (TakeStrategy[]) $VALUES.clone();
        }
    }

    public BDScanLocationInfo(String r8, boolean r10) {
        this.mGpsInfoList = new ArrayList(8);
        this.mGpsLocationList = new ArrayList(8);
        this.mGnssInfoList = new ArrayList(16);
        this.mGpsInfoReportClocks = new ArrayList(8);
        this.locateId = r8;
        this.gpsUseContinuous = r10;
    }

    private <T> T takeFromSequence(List<T> r8, TakeStrategy r10) {
        if (r8.isEmpty() == true) goto L12;
        int r11 = AnonymousClass1.$SwitchMap$com$bytedance$bdlocation$scan$gps$BDScanLocationInfo$TakeStrategy[r10.ordinal()];
        int r12 = 0;
        if (r11 == 1) goto L11;
        if (r11 != 2) goto L11;
        r12 = r8.size() - 1;
    L11:
        return r8.get(r12);
    L12:
        return null;
    }

    public void addGnssInfo(BDGnssInfo r8) {
        List<BDGnssInfo> r10 = this.mGnssInfoList;
        monitor-enter(r10);
        this.mGnssInfoList.add(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addGpsInfo(BDGpsInfo r8) {
        List<BDGpsInfo> r10 = this.mGpsInfoList;
        monitor-enter(r10);
        this.mGpsInfoList.add(r8);     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
        List<Long> r11 = this.mGpsInfoReportClocks;
        monitor-enter(r11);
        this.mGpsInfoReportClocks.add(Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        throw th;
    }

    public void addGpsLocation(BDLocation r8) {
        List<BDLocation> r10 = this.mGpsLocationList;
        monitor-enter(r10);
        this.mGpsLocationList.add(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void cleanGnssInfo() {
        List<BDGnssInfo> r8 = this.mGnssInfoList;
        monitor-enter(r8);
        this.mGnssInfoList.clear();     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void cleanGpsInfo() {
        List<BDGpsInfo> r8 = this.mGpsInfoList;
        monitor-enter(r8);
        this.mGpsInfoList.clear();     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void cleanGpsLocation() {
        List<BDLocation> r8 = this.mGpsLocationList;
        monitor-enter(r8);
        this.mGpsLocationList.clear();     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public BDGnssInfo findNearbyGnssInfo(BDGpsInfo r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        List<BDGnssInfo> r10 = this.mGnssInfoList;
        monitor-enter(r10);
        ArrayList r11 = new ArrayList(this.mGnssInfoList);     // Catch: Throwable -> L19
        monitor-exit(r10);     // Catch: Throwable -> L19
        if (r11.isEmpty() == false) goto L12;
        return null;
    L12:
        BDGnssInfo r12 = (BDGnssInfo) r11.get(0);
        int r13 = r11.size() - 1;
    L13:
        if (r13 < 0) goto L26;
        BDGnssInfo r14 = (BDGnssInfo) r11.get(r13);
        if (r8.callbackClock > r14.callbackClock) goto L18;
        r13 = r13 - 1;
        goto L13
    L18:
        return r14;
    L26:
        return r12;
    L19:
        th = move-exception;
        throw th;
    }

    public BDLocation getAMapLocation() {
        return this.aMapLocation;
    }

    public List<BDGnssInfo> getGnssInfoList() {
        List<BDGnssInfo> r8 = this.mGnssInfoList;
        monitor-enter(r8);
        ArrayList r10 = new ArrayList(this.mGnssInfoList);     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public List<BDGpsInfo> getGpsInfo() {
        List<BDGpsInfo> r8 = this.mGpsInfoList;
        monitor-enter(r8);
        ArrayList r10 = new ArrayList(this.mGpsInfoList);     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public List<Long> getGpsInfoReportClocks() {
        List<Long> r8 = this.mGpsInfoReportClocks;
        monitor-enter(r8);
        ArrayList r10 = new ArrayList(this.mGpsInfoReportClocks);     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public List<BDLocation> getGpsLocation() {
        List<BDLocation> r8 = this.mGpsLocationList;
        monitor-enter(r8);
        ArrayList r10 = new ArrayList(this.mGpsLocationList);     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public String getLocateId() {
        return this.locateId;
    }

    public BDLocation getSysLocation() {
        return this.sysLocation;
    }

    public boolean isContinuousGps() {
        return this.gpsUseContinuous;
    }

    public void setAMapLocation(BDLocation r8) {
        this.aMapLocation = r8;
    }

    public void setSysLocation(BDLocation r8) {
        this.sysLocation = r8;
    }

    public BDGpsInfo takeGpsInfo(TakeStrategy r8) {
        List<BDGpsInfo> r10 = this.mGpsInfoList;
        monitor-enter(r10);
        BDGpsInfo r11 = (BDGpsInfo) takeFromSequence(this.mGpsInfoList, r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public BDLocation takeGpsLocation(TakeStrategy r8) {
        List<BDLocation> r10 = this.mGpsLocationList;
        monitor-enter(r10);
        BDLocation r11 = (BDLocation) takeFromSequence(this.mGpsLocationList, r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }
}
