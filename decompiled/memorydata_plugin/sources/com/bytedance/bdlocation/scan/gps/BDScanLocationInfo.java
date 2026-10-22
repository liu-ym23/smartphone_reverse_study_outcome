package com.bytedance.bdlocation.scan.gps;

import android.os.SystemClock;
import com.bytedance.bdlocation.BDLocation;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bdlocation$scan$gps$BDScanLocationInfo$TakeStrategy = null;

        static {
            int[] r0 = new int[TakeStrategy.values().length];
            $SwitchMap$com$bytedance$bdlocation$scan$gps$BDScanLocationInfo$TakeStrategy = r0;
            r0[TakeStrategy.firstResult.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
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
            TakeStrategy r0 = new TakeStrategy("firstResult", 0);
            firstResult = r0;
            TakeStrategy r1 = new TakeStrategy("lastResult", 1);
            lastResult = r1;
            $VALUES = new TakeStrategy[]{r0, r1};
        }

        private TakeStrategy(String r1, int r2) {
            super(r1, r2);
        }

        public static TakeStrategy valueOf(String r2) {
            return (TakeStrategy) ZeusTransformUtils.preCheckCast(Enum.valueOf(TakeStrategy.class, r2), TakeStrategy.class, "com.obric.memorydata.plugin");
        }

        public static TakeStrategy[] values() {
            return (TakeStrategy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TakeStrategy[].class, "com.obric.memorydata.plugin");
        }
    }

    public BDScanLocationInfo(String r4, boolean r5) {
        this.mGpsInfoList = new ArrayList(8);
        this.mGpsLocationList = new ArrayList(8);
        this.mGnssInfoList = new ArrayList(16);
        this.mGpsInfoReportClocks = new ArrayList(8);
        this.locateId = r4;
        this.gpsUseContinuous = r5;
    }

    private <T> T takeFromSequence(List<T> r3, TakeStrategy r4) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r2.isEmpty() == true) goto L12;
        int r5 = AnonymousClass1.$SwitchMap$com$bytedance$bdlocation$scan$gps$BDScanLocationInfo$TakeStrategy[r4.ordinal()];
        int r6 = 0;
        if (r5 == 1) goto L11;
        if (r5 != 2) goto L11;
        r6 = r2.size() - 1;
    L11:
        return (T) r2.get(r6);
    L12:
        return null;
    }

    public void addGnssInfo(BDGnssInfo r2) {
        List<BDGnssInfo> r0 = this.mGnssInfoList;
        monitor-enter(r0);
        this.mGnssInfoList.add(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addGpsInfo(BDGpsInfo r3) {
        List<BDGpsInfo> r0 = this.mGpsInfoList;
        monitor-enter(r0);
        this.mGpsInfoList.add(r3);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        List<Long> r4 = this.mGpsInfoReportClocks;
        monitor-enter(r4);
        this.mGpsInfoReportClocks.add(Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L11
        monitor-exit(r4);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        throw th;
    }

    public void addGpsLocation(BDLocation r2) {
        List<BDLocation> r0 = this.mGpsLocationList;
        monitor-enter(r0);
        this.mGpsLocationList.add(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void cleanGnssInfo() {
        List<BDGnssInfo> r0 = this.mGnssInfoList;
        monitor-enter(r0);
        this.mGnssInfoList.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void cleanGpsInfo() {
        List<BDGpsInfo> r0 = this.mGpsInfoList;
        monitor-enter(r0);
        this.mGpsInfoList.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void cleanGpsLocation() {
        List<BDLocation> r0 = this.mGpsLocationList;
        monitor-enter(r0);
        this.mGpsLocationList.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public BDGnssInfo findNearbyGnssInfo(BDGpsInfo r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        List<BDGnssInfo> r1 = this.mGnssInfoList;
        monitor-enter(r1);
        ArrayList r2 = new ArrayList(this.mGnssInfoList);     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        if (r2.isEmpty() == false) goto L12;
        return null;
    L12:
        BDGnssInfo r7 = (BDGnssInfo) ZeusTransformUtils.preCheckCast(r2.get(0), BDGnssInfo.class, "com.obric.memorydata.plugin");
        int r0 = r2.size() - 1;
    L13:
        if (r0 < 0) goto L26;
        BDGnssInfo r3 = (BDGnssInfo) ZeusTransformUtils.preCheckCast(r2.get(r0), BDGnssInfo.class, "com.obric.memorydata.plugin");
        if (r8.callbackClock > r3.callbackClock) goto L18;
        r0 = r0 - 1;
        goto L13
    L18:
        return r3;
    L26:
        return r7;
    L19:
        th = move-exception;
        throw th;
    }

    public BDLocation getAMapLocation() {
        return this.aMapLocation;
    }

    public List<BDGnssInfo> getGnssInfoList() {
        List<BDGnssInfo> r0 = this.mGnssInfoList;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mGnssInfoList);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<BDGpsInfo> getGpsInfo() {
        List<BDGpsInfo> r0 = this.mGpsInfoList;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mGpsInfoList);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<Long> getGpsInfoReportClocks() {
        List<Long> r0 = this.mGpsInfoReportClocks;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mGpsInfoReportClocks);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<BDLocation> getGpsLocation() {
        List<BDLocation> r0 = this.mGpsLocationList;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mGpsLocationList);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
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

    public void setAMapLocation(BDLocation r1) {
        this.aMapLocation = r1;
    }

    public void setSysLocation(BDLocation r1) {
        this.sysLocation = r1;
    }

    public BDGpsInfo takeGpsInfo(TakeStrategy r3) {
        List<BDGpsInfo> r0 = this.mGpsInfoList;
        monitor-enter(r0);
        BDGpsInfo r2 = (BDGpsInfo) ZeusTransformUtils.preCheckCast(takeFromSequence(this.mGpsInfoList, r3), BDGpsInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public BDLocation takeGpsLocation(TakeStrategy r3) {
        List<BDLocation> r0 = this.mGpsLocationList;
        monitor-enter(r0);
        BDLocation r2 = (BDLocation) ZeusTransformUtils.preCheckCast(takeFromSequence(this.mGpsLocationList, r3), BDLocation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }
}
