package com.obric.cae.smartNetwork.networkHandoverRL;

import com.obric.cae.smartNetwork.networkHandoverRL.feature.FeatureData;
import com.sdk.bwdl.Utils.BWDLInnerConstant;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiQoeScore {
    private static final String TAG = "WifiQoeScore";
    private static final Object sCacheLock = null;
    private static volatile int sLastValidRttMs;
    private static volatile int sLastValidSendRateBps;
    private static volatile long sLastValidTsMillis;

    static {
        sCacheLock = new Object();
    }

    public WifiQoeScore() {
    }

    private static double clamp01(double r8) {
        if (Double.isNaN(r8) == false) goto L6;
        return 0.0d;
    L6:
        return Math.max(0.0d, Math.min(1.0d, r8));
    }

    private static double computeOooTerm(int r8, double r10, int r11) {
        double r12 = clamp01(1.0d - clamp01(r10 / 102400.0d));
        if (r11 <= 10) goto L5;
        double r13 = clamp01(((double) (r11 - 10)) / 40.0d);
    L7:
        return clamp01(((((double) r8) / 100.0d) * r12) * r13);
    L5:
        r13 = 0.0d;
        goto L7
    }

    private static double computeRateDamp(double r8, double r10) {
        return 1.0d - clamp01(Math.max(r8, r10) / 2097152.0d);
    }

    private static double computeRetranTerm(int r8, int r10) {
        if (r10 > 4) goto L7;
        return 0.0d;
    L7:
        return clamp01(((double) r8) / 100.0d) * clamp01(((double) (r10 - 4)) / 16.0d);
    }

    private static double computeRttTerm(int r8, double r10) {
        return clamp01(((double) r8) / 600.0d) * clamp01(r10 / 56000.0d);
    }

    private static double computeSendOnlyPenalty(int r8, int r10, int r11) {
        return clamp01(((double) ((r8 + r10) - 10)) / 20.0d) * clamp01(((double) (2 - r11)) / 2.0d);
    }

    private static double computeUnackedTerm(int r8, int r10) {
        double r11 = safeDiv(r8, Math.max(1.0d, r10));
        if (r10 > 4) goto L7;
        return 0.0d;
    L7:
        return clamp01(r11) * clamp01(((double) (r10 - 4)) / 16.0d);
    }

    private static int[] findRecentValidRttAndSendRate(int r8) {
        long r10 = System.currentTimeMillis();
        Object r11 = sCacheLock;
        monitor-enter(r11);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (sLastValidTsMillis > 0) goto L7;
    L15:
        monitor-exit(r11);     // Catch: Throwable -> L18
        return null;
    L7:
        if ((r10 - sLastValidTsMillis) > r8) goto L15;
        if (sLastValidRttMs <= 0) goto L15;
        if (sLastValidSendRateBps <= 0) goto L15;
        int[] r12 = {sLastValidRttMs, sLastValidSendRateBps};     // Catch: Throwable -> L18
        monitor-exit(r11);     // Catch: Throwable -> L18
        return r12;
    }

    public static int getWifiQoeScore(FeatureData r20) {
        if (r20 != null) goto L5;
        return 0;
    L5:
        double r8 = Math.max(0, r20.getWifiL4SendSpeed());
        double r10 = Math.max(0, r20.getWifiL4RecvSpeed());
        int r11 = Math.max(0, Math.round(r20.getWifiL4RetryRate()));
        int r12 = Math.max(0, r20.getWifiL4SendPkts());
        int r13 = Math.max(0, r20.getWifiL4UnackPkts());
        int r14 = Math.max(0, r20.getWifiL4RecvPkts());
        int r15 = Math.max(0, Math.round(r20.getWifiL4RecvOooRate()));
        int r16 = Math.max(0, r20.getWifiL4Rtt());
        if (r16 > 0) goto L8;
    L10:
        if (r16 == 0) goto L12;
    L16:
        double r17 = computeRateDamp(r8, r10);
        int r18 = r12 + r13;
        double r19 = computeRttTerm(r16, r8);
        double r110 = computeRetranTerm(r11, r18);
        double r111 = computeUnackedTerm(r13, r18);
        double r21 = computeOooTerm(r15, r10, r14);
        double r22 = computeSendOnlyPenalty(r12, r13, r14) * 0.2d;
        double r23 = r21 * 0.15d;
        double r112 = r19 * 0.15d;
        return Math.max(0, (int) Math.round(clamp01(clamp01(((clamp01((((double) r16) - 700.0d) / 200.0d) * clamp01((r8 - 128000.0d) / 128000.0d)) * 0.1d) + (r112 + (r23 + (r22 + ((r111 * 0.25d) + (r110 * 0.3d)))))) * r17) * 1000.0d));
    L12:
        if (r8 != 0.0d) goto L16;
        int[] r113 = findRecentValidRttAndSendRate(BWDLInnerConstant.EVENT_TIME_TOUT);
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
        Object r11 = sCacheLock;
        monitor-enter(r11);
        sLastValidRttMs = r8;     // Catch: Throwable -> L7
        sLastValidSendRateBps = r10;     // Catch: Throwable -> L7
        sLastValidTsMillis = System.currentTimeMillis();     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
