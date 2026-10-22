package com.obric.cae.userAware;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
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

        public RssiRecord(int r8, long r10) {
            this.rssi = r8;
            this.timestamp = r10;
        }
    }

    public WifiSignalMonitor() {
        this.mRssiHistory = new LinkedList();
    }

    public int detectRssiChange(int r8) {
        long r10 = System.currentTimeMillis();
    L4:
        if (this.mRssiHistory.isEmpty() == true) goto L8;
        if ((r10 - this.mRssiHistory.peekFirst().timestamp) <= TIME_WINDOW_MS) goto L8;
        this.mRssiHistory.pollFirst();
    L8:
        this.mRssiHistory.addLast(new RssiRecord(r8, r10));
        Iterator<RssiRecord> r11 = this.mRssiHistory.iterator();
        int r12 = Integer.MIN_VALUE;
        int r13 = Integer.MAX_VALUE;
    L10:
        if (r11.hasNext() == false) goto L13;
        RssiRecord r14 = r11.next();
        r12 = Math.max(r12, r14.rssi);
        r13 = Math.min(r13, r14.rssi);
        goto L10
    L13:
        if ((r12 - r13) < 10) goto L20;
        if (r8 != r12) goto L17;
        return 1;
    L17:
        if (r8 != r13) goto L25;
        return 2;
    L25:
        return 3;
    L20:
        return 3;
    }
}
