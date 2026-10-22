package com.obric.cae.smartNetwork.networkHandover;

import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;

/* JADX INFO: loaded from: classes2.dex */
public final class NetworkQoeScore {
    private static final Object CACHE_LOCK = null;
    private static final double HIGH_RATE_BPS = 2097152.0d;
    private static final double LOW_RECV_THRESHOLD_BPS = 102400.0d;
    private static final int MIN_PACKETS_THRESHOLD = 4;
    private static final int MIN_RECV_FOR_SEND_ONLY = 2;
    private static final int RECENT_VALID_WINDOW_MS = 3000;
    private static final int RECV_PKTS_BASE = 10;
    private static final int RECV_PKTS_SPAN = 40;
    private static final double RTT_HIGH_BUMP_RTT_SPAN = 200.0d;
    private static final double RTT_HIGH_BUMP_RTT_START = 700.0d;
    private static final double RTT_SCALE = 600.0d;
    private static final double SEND_RATE_HIGH_BUMP_SPAN = 128000.0d;
    private static final double SEND_RATE_HIGH_BUMP_START = 128000.0d;
    private static final double SEND_RATE_SCALE = 56000.0d;
    private static final int SEND_TOTAL_BASE = 10;
    private static final int SEND_TOTAL_SPAN = 20;
    private static final double WEIGHT_OOO = 0.15d;
    private static final double WEIGHT_RETRAN = 0.3d;
    private static final double WEIGHT_RTT = 0.15d;
    private static final double WEIGHT_RTT_HIGH_BUMP = 0.1d;
    private static final double WEIGHT_SEND_ONLY = 0.2d;
    private static final double WEIGHT_UNACKED = 0.25d;
    private static volatile int lastValidRttMs;
    private static volatile int lastValidSendRateBps;
    private static volatile long lastValidTsMillis;

    static {
        CACHE_LOCK = new Object();
    }

    public NetworkQoeScore() {
    }

    private static double clamp01(double r8) {
        if (Double.isNaN(r8) == false) goto L6;
        return 0.0d;
    L6:
        return Math.max(0.0d, Math.min(1.0d, r8));
    }

    private static double computeOutOfOrderComponent(int r8, double r10, int r11) {
        double r12 = clamp01(1.0d - clamp01(r10 / LOW_RECV_THRESHOLD_BPS));
        if (r11 <= 10) goto L5;
        double r13 = clamp01(((double) (r11 - 10)) / 40.0d);
    L7:
        return clamp01(((((double) r8) / 100.0d) * r12) * r13);
    L5:
        r13 = 0.0d;
        goto L7
    }

    private static double computeRateDamping(double r8, double r10) {
        return 1.0d - clamp01(Math.max(r8, r10) / HIGH_RATE_BPS);
    }

    private static double computeRetransmitComponent(int r8, int r10) {
        if (r10 > 4) goto L7;
        return 0.0d;
    L7:
        return clamp01(((double) r8) / 100.0d) * clamp01(((double) (r10 - 4)) / 16.0d);
    }

    private static double computeRttComponent(int r8, double r10) {
        return clamp01(((double) r8) / RTT_SCALE) * clamp01(r10 / SEND_RATE_SCALE);
    }

    private static double computeSendOnlyPenalty(int r8, int r10, int r11) {
        return clamp01(((double) ((r8 + r10) - 10)) / 20.0d) * clamp01(((double) (2 - r11)) / 2.0d);
    }

    private static double computeUnackedComponent(int r8, int r10) {
        double r11 = safeDiv(r8, Math.max(1.0d, r10));
        if (r10 > 4) goto L7;
        return 0.0d;
    L7:
        return clamp01(r11) * clamp01(((double) (r10 - 4)) / 16.0d);
    }

    private static int[] findRecentValidRttAndSendRate(int r8) {
        long r10 = System.currentTimeMillis();
        Object r11 = CACHE_LOCK;
        monitor-enter(r11);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (lastValidTsMillis > 0) goto L7;
    L15:
        monitor-exit(r11);     // Catch: Throwable -> L18
        return null;
    L7:
        if ((r10 - lastValidTsMillis) > r8) goto L15;
        if (lastValidRttMs <= 0) goto L15;
        if (lastValidSendRateBps <= 0) goto L15;
        int[] r12 = {lastValidRttMs, lastValidSendRateBps};     // Catch: Throwable -> L18
        monitor-exit(r11);     // Catch: Throwable -> L18
        return r12;
    }

    public static int getNetworkScore(L4NetEvaluate.L4NetStats r20) {
        if (r20 != null) goto L5;
        return 0;
    L5:
        double r8 = Math.max(0, r20.sendRate);
        double r10 = Math.max(0, r20.recvRate);
        int r11 = Math.max(0, Math.round(r20.sendRetrans));
        int r12 = Math.max(0, r20.sendPackets);
        int r13 = Math.max(0, r20.unacked);
        int r14 = Math.max(0, r20.recvPackets);
        int r15 = Math.max(0, Math.round(r20.recvOooPercent));
        int r16 = Math.max(0, r20.rttAve);
        if (r16 > 0) goto L8;
    L10:
        if (r16 == 0) goto L12;
    L16:
        double r17 = computeRateDamping(r8, r10);
        int r18 = r12 + r13;
        double r19 = computeRttComponent(r16, r8);
        double r110 = computeRetransmitComponent(r11, r18);
        double r111 = computeUnackedComponent(r13, r18);
        double r21 = computeOutOfOrderComponent(r15, r10, r14);
        double r22 = computeSendOnlyPenalty(r12, r13, r14);
        double r23 = r21 * 0.15d;
        double r112 = r19 * 0.15d;
        return Math.max(0, (int) Math.round(clamp01(clamp01(((clamp01((((double) r16) - RTT_HIGH_BUMP_RTT_START) / RTT_HIGH_BUMP_RTT_SPAN) * clamp01((r8 - 128000.0d) / 128000.0d)) * WEIGHT_RTT_HIGH_BUMP) + (r112 + (r23 + ((r22 * WEIGHT_SEND_ONLY) + ((r111 * WEIGHT_UNACKED) + (r110 * WEIGHT_RETRAN)))))) * r17) * 1000.0d));
    L12:
        if (r8 != 0.0d) goto L16;
        int[] r113 = findRecentValidRttAndSendRate(3000);
        if (r113 == null) goto L16;
        r16 = r113[0];
        r8 = r113[1];
        goto L16
    L8:
        if (r8 <= 0.0d) goto L10;
        updateLastValid(r16, (int) Math.round(r8));
        goto L16
    }

    public static int getScore(L4NetEvaluate.UidQosStats r20) {
        if (r20 != null) goto L5;
        return 0;
    L5:
        double r8 = Math.max(0, r20.sendRate);
        double r10 = Math.max(0, r20.recvRate);
        int r11 = Math.max(0, Math.round(r20.sendRetrans));
        int r12 = Math.max(0, r20.sendPackets);
        int r13 = Math.max(0, r20.unacked);
        int r14 = Math.max(0, r20.recvPackets);
        int r15 = Math.max(0, Math.round(r20.recvOooPercent));
        int r16 = Math.max(0, r20.rttAve);
        if (r16 > 0) goto L8;
    L10:
        if (r16 == 0) goto L12;
    L16:
        double r17 = computeRateDamping(r8, r10);
        int r18 = r12 + r13;
        double r19 = computeRttComponent(r16, r8);
        double r110 = computeRetransmitComponent(r11, r18);
        double r111 = computeUnackedComponent(r13, r18);
        double r21 = computeOutOfOrderComponent(r15, r10, r14);
        double r22 = computeSendOnlyPenalty(r12, r13, r14);
        double r23 = r21 * 0.15d;
        double r112 = r19 * 0.15d;
        return Math.max(0, (int) Math.round(clamp01(clamp01(((clamp01((((double) r16) - RTT_HIGH_BUMP_RTT_START) / RTT_HIGH_BUMP_RTT_SPAN) * clamp01((r8 - 128000.0d) / 128000.0d)) * WEIGHT_RTT_HIGH_BUMP) + (r112 + (r23 + ((r22 * WEIGHT_SEND_ONLY) + ((r111 * WEIGHT_UNACKED) + (r110 * WEIGHT_RETRAN)))))) * r17) * 1000.0d));
    L12:
        if (r8 != 0.0d) goto L16;
        int[] r113 = findRecentValidRttAndSendRate(3000);
        if (r113 == null) goto L16;
        r16 = r113[0];
        r8 = r113[1];
        goto L16
    L8:
        if (r8 <= 0.0d) goto L10;
        updateLastValid(r16, (int) Math.round(r8));
        goto L16
    }

    private static double safeDiv(double r8, double r10) {
        if (r10 != 0.0d) goto L6;
        return 0.0d;
    L6:
        return r8 / r10;
    }

    private static void updateLastValid(int r8, int r10) {
        Object r11 = CACHE_LOCK;
        monitor-enter(r11);
        lastValidRttMs = r8;     // Catch: Throwable -> L7
        lastValidSendRateBps = r10;     // Catch: Throwable -> L7
        lastValidTsMillis = System.currentTimeMillis();     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
