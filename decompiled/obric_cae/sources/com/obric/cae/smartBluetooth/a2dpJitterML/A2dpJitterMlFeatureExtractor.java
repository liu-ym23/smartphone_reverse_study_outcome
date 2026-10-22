package com.obric.cae.smartBluetooth.a2dpJitterML;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothQualityReport;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class A2dpJitterMlFeatureExtractor {
    private static final double[] MEAN = null;
    private static final Pattern P_ACLQ = null;
    private static final Pattern P_ARRIVAL_TIME = null;
    private static final Pattern P_GLITCH = null;
    private static final Pattern P_LAST_TX_ACK = null;
    private static final Pattern P_NAK = null;
    private static final Pattern P_NORX = null;
    private static final Pattern P_OVERFLOW = null;
    private static final Pattern P_PICONET_CLOCK = null;
    private static final Pattern P_PKTTYPE = null;
    private static final Pattern P_RETRANS = null;
    private static final Pattern P_SCHEDULE_TIME = null;
    private static final Pattern P_TXPWR = null;
    private static final double[] STD = null;
    private final Object mLock;
    private final Map<String, PrevState> mPrevStateByAddr;

    /* JADX INFO: renamed from: com.obric.cae.smartBluetooth.a2dpJitterML.A2dpJitterMlFeatureExtractor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class ExtractResult {
        public final int mAclTxQueueLength;
        public final float mDeltaRetransSum;
        public final int mGlitchCount;
        public final float mHostBufferMargin;
        public final int mNakCount;
        public final int mNoRxCount;
        public final float mNoRxRatio;
        public final int mOverflowCount;
        public final String mPacketType;
        public final float mSilenceDuration;
        public final float[] mStandardized;
        public final int mTxPowerLevel;

        public ExtractResult(float[] r8, float r10, float r11, float r12, float r13, int r14, int r15, int r16, int r17, int r18, String r19, int r110) {
            this.mStandardized = r8;
            this.mDeltaRetransSum = r10;
            this.mNoRxRatio = r11;
            this.mSilenceDuration = r12;
            this.mHostBufferMargin = r13;
            this.mAclTxQueueLength = r14;
            this.mGlitchCount = r15;
            this.mNakCount = r16;
            this.mNoRxCount = r17;
            this.mOverflowCount = r18;
            this.mPacketType = r19;
            this.mTxPowerLevel = r110;
        }
    }

    public static final class PrevState {
        long mNakCount;
        long mNoRxCount;
        long mRetransmissionCount;

        private PrevState() {
        }

        public /* synthetic */ PrevState(AnonymousClass1 r8) {
            this();
        }
    }

    static {
        P_RETRANS = Pattern.compile("mRetransmissionCount:\\s*(\\d+)");
        P_NORX = Pattern.compile("mNoRxCount:\\s*(\\d+)");
        P_NAK = Pattern.compile("mNakCount:\\s*(\\d+)");
        P_OVERFLOW = Pattern.compile("mOverflowCount:\\s*(\\d+)");
        P_TXPWR = Pattern.compile("mTxPowerLevel:\\s*(-?\\d+)");
        P_PKTTYPE = Pattern.compile("mPacketType:\\s*([^\\(\\r\\n]+?)\\s*\\(0x([0-9a-fA-F]+)\\)");
        P_GLITCH = Pattern.compile("mGlitchCount:\\s*(\\d+)");
        P_ACLQ = Pattern.compile("mAclTxQueueLength:\\s*(\\d+)");
        P_ARRIVAL_TIME = Pattern.compile("mArrivalTime:\\s*0x([0-9a-fA-F]+)");
        P_SCHEDULE_TIME = Pattern.compile("mScheduleTime:\\s*0x([0-9a-fA-F]+)");
        P_PICONET_CLOCK = Pattern.compile("mPiconetClock:\\s*0x([0-9a-fA-F]+)");
        P_LAST_TX_ACK = Pattern.compile("mLastTxAckTimestamp:\\s*0x([0-9a-fA-F]+)");
        MEAN = new double[]{124.49621725078093d, 0.2447855890360265d, 283.5209360273008d, 90.25997372840041d, 1.7565678998970804d, 4.984020367260712d, 1.9140711048516692d, 147.01636964411463d, 266.27271906541716d, 22.971832511781592d, 14.711662423487352d};
        STD = new double[]{238.0471632208169d, 0.2617075568585259d, 1827.053057276023d, 419.9856724968285d, 3.5244100137269823d, 9.919050924418583d, 2.510893387188187d, 143.17226258127747d, 1506.9335635415866d, 2.343396183646834d, 3.715275309966361d};
    }

    public A2dpJitterMlFeatureExtractor() {
        this.mLock = new Object();
        this.mPrevStateByAddr = new HashMap();
    }

    private static long matchHexLong(Pattern r8, String r10, long r11) {
        Matcher r12 = r8.matcher(r10);
        if (r12.find() == true) goto L9;
        return r11;
    L9:
        return Long.parseLong(r12.group(1), 16);
    L8:
        return r11;
    }

    private static long matchLong(Pattern r8, String r10, long r11) {
        Matcher r12 = r8.matcher(r10);
        if (r12.find() == true) goto L9;
        return r11;
    L9:
        return Long.parseLong(r12.group(1));
    L8:
        return r11;
    }

    private static String matchPacketTypeLabel(String r8, long r10) {
        Matcher r11 = P_PKTTYPE.matcher(r8);
        if (r11.find() == false) goto L18;
        String r12 = "";
        if (r11.group(1) == null) goto L7;
        String r13 = r11.group(1).trim();
    L9:
        if (r11.group(2) == null) goto L12;
        r12 = r11.group(2).toUpperCase(Locale.US);
    L12:
        if (r13.isEmpty() == true) goto L18;
        if (r12.isEmpty() == true) goto L18;
        StringBuilder r14 = new StringBuilder();
        r14.append(r13);
        r14.append("(0x");
        r14.append(r12);
    L16:
        r14.append(")");
        return r14.toString();
    L7:
        r13 = "";
    L18:
        r14 = new StringBuilder("UNKNOWN(0x");
        r14.append(Long.toHexString(r10).toUpperCase(Locale.US));
        goto L16
    }

    private static long matchPacketTypeValue(String r8, long r10) {
        Matcher r11 = P_PKTTYPE.matcher(r8);
        if (r11.find() == true) goto L9;
        return r10;
    L9:
        return Long.parseLong(r11.group(2), 16);
    L8:
        return r10;
    }

    private static int safeInt(long r8) {
        if (r8 <= 2147483647L) goto L7;
        return Integer.MAX_VALUE;
    L7:
        if (r8 >= (-2147483648L)) goto L11;
        return Integer.MIN_VALUE;
    L11:
        return (int) r8;
    }

    public ExtractResult extract(BluetoothDevice r38, BluetoothQualityReport r39) {
        if (r39 == null) goto L5;
        String r8 = r39.toString();
    L6:
        if (r8 != null) goto L8;
        return null;
    L8:
        if (r8.isEmpty() == true) goto L76;
        long r10 = matchLong(P_RETRANS, r8, 0);
        long r11 = matchLong(P_NORX, r8, 0);
        long r12 = matchLong(P_NAK, r8, 0);
        long r13 = matchLong(P_OVERFLOW, r8, 0);
        long r14 = matchLong(P_TXPWR, r8, 0);
        long r15 = matchPacketTypeValue(r8, 0);
        String r29 = matchPacketTypeLabel(r8, r15);
        boolean r16 = r8.contains("BqrVsA2dpChoppy");
        if (r16 == false) goto L13;
        long r31 = matchLong(P_GLITCH, r8, 0);
    L14:
        if (r16 == false) goto L16;
        long r33 = matchLong(P_ACLQ, r8, 0);
    L18:
        if (r16 == false) goto L20;
        long r21 = matchHexLong(P_ARRIVAL_TIME, r8, -1);
    L21:
        if (r16 == false) goto L23;
        long r23 = matchHexLong(P_SCHEDULE_TIME, r8, -1);
    L24:
        long r25 = matchHexLong(P_PICONET_CLOCK, r8, -1);
        long r17 = matchHexLong(P_LAST_TX_ACK, r8, -1);
        float r30 = 0.0f;
        if (r25 >= 0) goto L27;
    L29:
        float r18 = 0.0f;
    L31:
        if (r23 >= 0) goto L33;
    L35:
        float r24 = 0.0f;
    L36:
        if (r38 == null) goto L38;
        String r19 = r38.getAddress();
    L39:
        Object r20 = this.mLock;
        monitor-enter(r20);
        if (r19 != null) goto L73;
        long r26 = r13;
        long r22 = r15;
        float r27 = 0.0f;
        float r110 = 0.0f;
        float r111 = 0.0f;
    L59:
        monitor-exit(r20);     // Catch: Throwable -> L68
        float r28 = r111 + r110;
        float r32 = r28 + r27;
        if (r32 <= 0.0f) goto L63;
        r30 = r110 / r32;
    L63:
        long r34 = r33;
        long r112 = r31;
        long r113 = r26;
        float r310 = r18;
        long r35 = r14;
        float[] r36 = {r28, r30, r18, r24, r34, r112, r12, r11, r113, r22, r35};
        int r37 = 11;
        float[] r40 = new float[11];
        int r41 = 0;
    L64:
        if (r41 >= r37) goto L67;
        r40[r41] = (float) ((((double) r36[r41]) - MEAN[r41]) / STD[r41]);
        r41 = r41 + 1;
        r36 = r36;
        r35 = r35;
        r37 = 11;
        goto L64
    L67:
        return new ExtractResult(r40, r28, r30, r310, r24, safeInt(r34), safeInt(r112), safeInt(r12), safeInt(r11), safeInt(r113), r29, safeInt(r35));
    L68:
        th = move-exception;
        throw th;
    L73:
        PrevState r42 = this.mPrevStateByAddr.get(r19);     // Catch: Throwable -> L68
        if (r42 != null) goto L46;
        r26 = r13;
        r22 = r15;
        r27 = 0.0f;
        r110 = 0.0f;
        r111 = 0.0f;
    L58:
        PrevState r43 = new PrevState(null);     // Catch: Throwable -> L68
        r43.mRetransmissionCount = r10;     // Catch: Throwable -> L68
        r43.mNoRxCount = r11;     // Catch: Throwable -> L68
        r43.mNakCount = r12;     // Catch: Throwable -> L68
        this.mPrevStateByAddr.put(r19, r43);     // Catch: Throwable -> L68
        goto L59
    L46:
        r22 = r15;
        long r114 = r10 - r42.mRetransmissionCount;     // Catch: Throwable -> L68
        r26 = r13;
        long r115 = r11 - r42.mNoRxCount;     // Catch: Throwable -> L68
        long r44 = r12 - r42.mNakCount;     // Catch: Throwable -> L68
        if (r114 <= 0) goto L49;
        r111 = r114;
    L51:
        if (r115 <= 0) goto L53;
        r110 = r115;
    L55:
        if (r44 <= 0) goto L57;
        r27 = r44;
        goto L58
    L57:
        r27 = 0.0f;
        goto L58
    L53:
        r110 = 0.0f;
        goto L55
    L49:
        r111 = 0.0f;
        goto L51
    L38:
        r19 = null;
        goto L39
    L33:
        if (r21 < 0) goto L35;
        r24 = (float) (((r23 - r21) & QesdkUtils.LIMITS.UINT_32_UPPER) * 0.625d);
        goto L36
    L27:
        if (r17 < 0) goto L29;
        r18 = (float) (((r25 - r17) & QesdkUtils.LIMITS.UINT_32_UPPER) * 0.625d);
        goto L31
    L23:
        r23 = -1;
        goto L24
    L20:
        r21 = -1;
        goto L21
    L16:
        r33 = 0;
        goto L18
    L13:
        r31 = 0;
        goto L14
    L76:
        return null;
    L5:
        r8 = null;
        goto L6
    }

    public float[] extractStandardized(BluetoothDevice r8, BluetoothQualityReport r10) {
        ExtractResult r11 = extract(r8, r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.mStandardized;
    }
}
