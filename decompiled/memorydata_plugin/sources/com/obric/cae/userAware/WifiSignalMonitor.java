package com.obric.cae.userAware;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public class WifiSignalMonitor {
    private static final int RSSI_CHANGE_THRESHOLD_DB = 10;
    public static final int RSSI_DECREASED = 2;
    public static final int RSSI_INCREASED = 1;
    public static final int RSSI_STABLE = 3;
    private static final long TIME_WINDOW_MS = 5200;
    private final Deque<RssiRecord> mRssiHistory;

    public static class RssiRecord {
        int rssi;
        long timestamp;

        public RssiRecord(int r1, long r2) {
            this.rssi = r1;
            this.timestamp = r2;
        }
    }

    public WifiSignalMonitor() {
        this.mRssiHistory = new LinkedList();
    }

    public int detectRssiChange(int r9) {
        long r0 = System.currentTimeMillis();
    L4:
        if (this.mRssiHistory.isEmpty() == true) goto L8;
        if ((r0 - ((RssiRecord) ZeusTransformUtils.preCheckCast(this.mRssiHistory.peekFirst(), RssiRecord.class, "com.obric.memorydata.plugin")).timestamp) <= TIME_WINDOW_MS) goto L8;
        this.mRssiHistory.pollFirst();
    L8:
        this.mRssiHistory.addLast(new RssiRecord(r9, r0));
        int r1 = Integer.MIN_VALUE;
        int r2 = Integer.MAX_VALUE;
        Iterator<RssiRecord> r8 = this.mRssiHistory.iterator();
    L10:
        if (r8.hasNext() == false) goto L13;
        RssiRecord r3 = (RssiRecord) ZeusTransformUtils.preCheckCast(r8.next(), RssiRecord.class, "com.obric.memorydata.plugin");
        r1 = Math.max(r1, r3.rssi);
        r2 = Math.min(r2, r3.rssi);
        goto L10
    L13:
        if ((r1 - r2) < 10) goto L20;
        if (r9 != r1) goto L17;
        return 1;
    L17:
        if (r9 != r2) goto L25;
        return 2;
    L25:
        return 3;
    L20:
        return 3;
    }
}
