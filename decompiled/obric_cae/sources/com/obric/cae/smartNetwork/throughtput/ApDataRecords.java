package com.obric.cae.smartNetwork.throughtput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ApDataRecords {
    public static final String KEY_CCA_BUSY_RATE = "ccaBusyRate";
    public static final String KEY_PER = "per";
    public static final String KEY_RX_LINK_SPEED = "rxLinkSpeed";
    private static final int MAX_AP_COUNT = 5;
    private static final int MAX_QUEUE_SIZE = 100;
    private final Map<String, APData> mLatestUsedAPMap;
    private final Map<String, APData> mLongestUsedAPMap;

    public static class APData {
        long lastUsedTime;
        String mac;
        Map<Integer, RssiData> rssiMap;
        long usageDuration;

        public APData(String r8) {
            this.rssiMap = new HashMap();
            this.mac = r8;
            this.lastUsedTime = System.currentTimeMillis();
            this.usageDuration = 0;
        }
    }

    public static class DataPoint {
        int ccaBusyRate;
        int per;
        int rxLinkSpeed;
        int rxMpdu;
        long timestamp;

        public DataPoint(long r8, int r10, int r11, int r12, int r13) {
            this.timestamp = r8;
            this.rxMpdu = r10;
            this.rxLinkSpeed = r11;
            this.per = r12;
            this.ccaBusyRate = r13;
        }
    }

    public static class RssiData {
        LinkedList<DataPoint> queue;
        int rssi;

        public RssiData() {
            this.queue = new LinkedList();
        }
    }

    public ApDataRecords() {
        this.mLatestUsedAPMap = new ConcurrentHashMap();
        this.mLongestUsedAPMap = new ConcurrentHashMap();
    }

    public static /* synthetic */ RssiData a(Integer r8) {
        return lambda$updateAPData$0(r8);
    }

    private RssiData findAlternativeRssiData(APData r8, int r10) {
        int[] r11 = {1, -1, 2, -2};
        int r12 = 0;
    L4:
        if (r12 >= 4) goto L11;
        int r13 = r11[r12];
        RssiData r14 = r8.rssiMap.get(Integer.valueOf(r13 + r10));
        if (r14 == null) goto L10;
        if (r14.queue.isEmpty() == true) goto L10;
        return r14;
    L10:
        r12 = r12 + 1;
        goto L4
    L11:
        return null;
    }

    private List<DataPoint> getLatestN(List<DataPoint> r8, int r10) {
        r8.sort(new AnonymousClass2(this));
        return r8.subList(0, Math.min(r8.size(), r10));
    }

    private List<DataPoint> getTopNByRxMpdu(List<DataPoint> r8, int r10) {
        r8.sort(new AnonymousClass1(this));
        return r8.subList(0, Math.min(r8.size(), r10));
    }

    private static /* synthetic */ RssiData lambda$updateAPData$0(Integer r8) {
        return new RssiData();
    }

    private void removeLeastRecentlyUsed(Map<String, APData> r8) {
        Iterator<APData> r10 = r8.values().iterator();
        String r11 = null;
        long r12 = Long.MAX_VALUE;
    L4:
        if (r10.hasNext() == false) goto L8;
        APData r13 = r10.next();
        long r14 = r13.lastUsedTime;
        if (r14 >= r12) goto L4;
        r11 = r13.mac;
        r12 = r14;
        goto L4
    L8:
        if (r11 == null) goto L16;
        r8.remove(r11);
        return;
    }

    private void removeShortestUsed(Map<String, APData> r8) {
        Iterator<APData> r10 = r8.values().iterator();
        String r11 = null;
        long r12 = Long.MAX_VALUE;
    L4:
        if (r10.hasNext() == false) goto L8;
        APData r13 = r10.next();
        long r14 = r13.usageDuration;
        if (r14 >= r12) goto L4;
        r11 = r13.mac;
        r12 = r14;
        goto L4
    L8:
        if (r11 == null) goto L16;
        r8.remove(r11);
        return;
    }

    public synchronized Map<String, Double> getWeightedMetrics(String r17, int r18) {
        monitor-enter(this);
        APData r8 = this.mLatestUsedAPMap.get(r17);     // Catch: Throwable -> L35
        if (r8 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        RssiData r10 = r8.rssiMap.get(Integer.valueOf(r18));     // Catch: Throwable -> L35
        if (r10 != null) goto L12;
    L13:
        r10 = findAlternativeRssiData(r8, r18);     // Catch: Throwable -> L35
        if (r10 != null) goto L16;
    L33:
        monitor-exit(this);
        return null;
    L16:
        if (r10.queue.isEmpty() == true) goto L33;
    L18:
        ArrayList r11 = new ArrayList(r10.queue);     // Catch: Throwable -> L35
        if (r11.isEmpty() == false) goto L22;
        monitor-exit(this);
        return null;
    L22:
        ArrayList r12 = new ArrayList(getTopNByRxMpdu(r11, 5));     // Catch: Throwable -> L35
        ArrayList r13 = new ArrayList(getLatestN(r11, 2));     // Catch: Throwable -> L35
        Iterator r14 = r12.iterator();     // Catch: Throwable -> L35
        double r15 = 0.0d;
        double r16 = 0.0d;
        double r19 = 0.0d;
    L24:
        if (r14.hasNext() == false) goto L26;
        DataPoint r110 = (DataPoint) r14.next();     // Catch: Throwable -> L35
        r15 = r15 + ((((double) r110.rxLinkSpeed) * 0.7d) / ((double) r12.size()));     // Catch: Throwable -> L35
        r16 = r16 + ((((double) r110.per) * 0.7d) / ((double) r12.size()));     // Catch: Throwable -> L35
        r19 = r19 + ((((double) r110.ccaBusyRate) * 0.7d) / ((double) r12.size()));     // Catch: Throwable -> L35
        goto L24
    L26:
        Iterator r20 = r13.iterator();     // Catch: Throwable -> L35
    L28:
        if (r20.hasNext() == false) goto L30;
        DataPoint r21 = (DataPoint) r20.next();     // Catch: Throwable -> L35
        r15 = r15 + ((((double) r21.rxLinkSpeed) * 0.3d) / ((double) r13.size()));     // Catch: Throwable -> L35
        r16 = r16 + ((((double) r21.per) * 0.3d) / ((double) r13.size()));     // Catch: Throwable -> L35
        r19 = r19 + ((((double) r21.ccaBusyRate) * 0.3d) / ((double) r13.size()));     // Catch: Throwable -> L35
        goto L28
    L30:
        HashMap r22 = new HashMap();     // Catch: Throwable -> L35
        r22.put(KEY_RX_LINK_SPEED, Double.valueOf(r15));     // Catch: Throwable -> L35
        r22.put(KEY_PER, Double.valueOf(r16));     // Catch: Throwable -> L35
        r22.put(KEY_CCA_BUSY_RATE, Double.valueOf(r19));     // Catch: Throwable -> L35
        monitor-exit(this);
        return r22;
    L12:
        if (r10.queue.isEmpty() == false) goto L18;
    L35:
        th = move-exception;
        throw th;
    }

    public synchronized void updateAPData(String r10, int r11, int r12, int r13, int r14, int r15) {
        monitor-enter(this);
        if (r12 >= 50) goto L25;
        monitor-exit(this);
        return;
    L25:
        long r8 = System.currentTimeMillis();     // Catch: Throwable -> L22
        APData r16 = this.mLatestUsedAPMap.get(r10);     // Catch: Throwable -> L22
        if (r16 != null) goto L10;
        r16 = new APData(r10);     // Catch: Throwable -> L22
        this.mLatestUsedAPMap.put(r10, r16);     // Catch: Throwable -> L22
        this.mLongestUsedAPMap.put(r10, r16);     // Catch: Throwable -> L22
    L10:
        r16.usageDuration += 1000;     // Catch: Throwable -> L22
        r16.lastUsedTime = r8;     // Catch: Throwable -> L22
        if (this.mLatestUsedAPMap.size() <= 5) goto L14;
        removeLeastRecentlyUsed(this.mLatestUsedAPMap);     // Catch: Throwable -> L22
    L14:
        if (this.mLongestUsedAPMap.size() <= 5) goto L16;
        removeShortestUsed(this.mLongestUsedAPMap);     // Catch: Throwable -> L22
    L16:
        RssiData r17 = r16.rssiMap.computeIfAbsent(Integer.valueOf(r11), new com.obric.cae.BWDL.BwdlDrop.a(8));     // Catch: Throwable -> L22
        if (r17.queue.size() < 100) goto L19;
        r17.queue.poll();     // Catch: Throwable -> L22
    L19:
        r17.queue.add(new DataPoint(r8, r12, r13, r14, r15));     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        throw th;
    }
}
