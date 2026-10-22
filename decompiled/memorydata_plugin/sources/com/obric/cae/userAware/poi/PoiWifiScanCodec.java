package com.obric.cae.userAware.poi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class PoiWifiScanCodec {
    static final int ACK_ACCEPTED = 1;
    static final int ACK_REJECTED = 2;
    static final int COMMAND_EVENT_ACK = 6;
    static final int COMMAND_QUERY = 5;
    static final int COMMAND_QUERY_CONFIG = 7;
    static final int COMMAND_RESET_CONFIG = 8;
    static final int COMMAND_START = 1;
    static final int COMMAND_STOP = 2;
    static final int COMMAND_TRIGGER_ONCE = 4;
    static final int COMMAND_UPDATE = 3;
    static final int EVENT_LEAVE = 1;
    static final int EVENT_VERIFY = 2;
    static final int PROTOCOL_VERSION = 3;

    public static final class Event {
        private final Map<Integer, byte[]> bytes;
        private final Map<Integer, Long> values;

        public Event() {
            this.values = new HashMap();
            this.bytes = new HashMap();
        }

        public static /* synthetic */ Map access$000(Event r0) {
            return r0.values;
        }

        public static /* synthetic */ Map access$100(Event r0) {
            return r0.bytes;
        }

        public boolean boolValue(int r3, boolean r4) {
            Long r2 = (Long) ZeusTransformUtils.preCheckCast(this.values.get(Integer.valueOf(r3)), Long.class, "com.obric.memorydata.plugin");
            if (r2 != null) goto L6;
            return r4;
        L6:
            if (r2.longValue() == 0) goto L8;
            return true;
        L8:
            return false;
        }

        public byte[] bytesValue(int r2) {
            return (byte[]) ZeusTransformUtils.preCheckCast(this.bytes.get(Integer.valueOf(r2)), byte[].class, "com.obric.memorydata.plugin");
        }

        public boolean hasV2EventIdentity(int r3, int r4) {
            if (hasVarintField(1) == true) goto L5;
        L9:
            return false;
        L5:
            if (hasVarintField(r3) == false) goto L9;
            if (hasVarintField(r4) == false) goto L9;
            return true;
        }

        public boolean hasValidLeaveFields() {
            if (hasV2EventIdentity(11, 12) == true) goto L5;
        L9:
            return false;
        L5:
            if (hasVarintField(2) == false) goto L9;
            if (hasVarintField(10) == false) goto L9;
            return true;
        }

        public boolean hasVarintField(int r1) {
            return this.values.containsKey(Integer.valueOf(r1));
        }

        public int intValue(int r2, int r3) {
            Long r1 = (Long) ZeusTransformUtils.preCheckCast(this.values.get(Integer.valueOf(r2)), Long.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L6;
            return r3;
        L6:
            return (int) r1.longValue();
        }

        public long longValue(int r2, long r3) {
            Long r1 = (Long) ZeusTransformUtils.preCheckCast(this.values.get(Integer.valueOf(r2)), Long.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L6;
            return r3;
        L6:
            return r1.longValue();
        }
    }

    private PoiWifiScanCodec() {
    }

    public static Event decodeEvent(byte[] r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        Event r0 = new Event();
        int[] r2 = {0};
    L7:
        if (r2[0] >= r9.length) goto L28;
        long r4 = readVarint(r9, r2);
        int r6 = (int) (r4 >>> 3);
        int r5 = (int) (r4 & 7);
        if (r6 == 0) goto L27;
        if (r5 == 0) goto L11;
        if (r5 == 2) goto L14;
        if (r5 == 1) goto L20;
        if (r5 != 5) goto L25;
        requireAvailable(r9, r2, 4);
        r2[0] = r2[0] + 4;
        goto L7
    L25:
        throw new IllegalArgumentException("unsupported protobuf wire type=" + r5);
    L20:
        requireAvailable(r9, r2, 8);
        r2[0] = r2[0] + 8;
        goto L7
    L14:
        long r7 = readVarint(r9, r2);
        if (r7 > 2147483647L) goto L18;
        int r8 = (int) r7;
        requireAvailable(r9, r2, r8);
        byte[] r10 = new byte[r8];
        System.arraycopy(r9, r2[0], r10, 0, r8);
        r2[0] = r2[0] + r8;
        Event.access$100(r0).put(Integer.valueOf(r6), r10);
        goto L7
    L18:
        throw new IllegalArgumentException("invalid protobuf bytes");
    L11:
        Event.access$000(r0).put(Integer.valueOf(r6), Long.valueOf(readVarint(r9, r2)));
        goto L7
    L27:
        throw new IllegalArgumentException("invalid protobuf field");
    L28:
        return r0;
    }

    public static byte[] encodeCommand(int r4, int r5, int r6, PoiWifiScanBridge.Config r7) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(128);
        writeField(r0, 1, r4);
        writeField(r0, 2, r5);
        writeField(r0, 3, 3);
        writeField(r0, 4, r6);
        writeField(r0, 5, r7.configVersion);
        writeField(r0, 6, r7.taskType);
        writeField(r0, 7, r7.scheduleMode);
        writeField(r0, 8, r7.intervalSeconds);
        writeField(r0, 9, r7.reportMode);
        writeField(r0, 10, r7.scanType);
        writeField(r0, 11, r7.bandMask);
        writeField(r0, 12, r7.maxScanAgeMs);
        writeField(r0, 13, r7.radioChainPref);
        int r8 = 0;
    L3:
        int[] r9 = r7.frequenciesMhz;
        if (r8 >= r9.length) goto L10;
        if (r8 >= 8) goto L10;
        int r10 = r9[r8];
        if (r10 <= 0) goto L9;
        writeField(r0, r8 + 14, r10);
    L9:
        r8 = r8 + 1;
    L10:
        writeField(r0, 22, r7.storeType);
        writeField(r0, 23, r7.algorithmVersion);
        writeField(r0, 24, r7.storeConfirmedElapsedMs);
        writeField(r0, 25, r7.scanWatchdogSeconds);
        writeField(r0, 26, r7.eventAckTimeoutSeconds);
        writeField(r0, 27, r7.retryBackoffInitialSeconds);
        writeField(r0, 28, r7.retryBackoffMaxSeconds);
        writeField(r0, 32, r7.minimumAnchorCountForStrongExit);
        writeField(r0, 33, r7.minimumStrongExitDensityPercent);
        writeField(r0, 34, r7.anchorFrameCount);
        writeField(r0, 35, r7.anchorMinHits);
        writeField(r0, 36, r7.anchorMaxMadDb);
        writeField(r0, 37, r7.anchorMinStableCount);
        writeField(r0, 38, r7.coreWeightQuarters);
        writeField(r0, 39, r7.backgroundWeightQuarters);
        writeField(r0, 40, r7.anchorIntervalSeconds);
        writeField(r0, 41, r7.monitorIntervalSeconds);
        writeField(r0, 42, r7.followUpIntervalSeconds);
        writeField(r0, 43, r7.gateCheckSeconds);
        writeField(r0, 44, r7.scanWake60sMinSteps);
        writeField(r0, 45, r7.sittableStart60sSteps);
        writeField(r0, 46, r7.sittableKeep60sSteps);
        writeField(r0, 47, r7.walkableFirst40sSteps);
        writeField(r0, 48, r7.walkableFirst60sSteps);
        writeField(r0, 49, r7.migrationConfirmFrames);
        writeField(r0, 50, r7.sharedStableMinCount);
        writeField(r0, 51, r7.rssiMedianDeltaMinDb);
        writeField(r0, 52, r7.delta8MinPercent);
        writeField(r0, 53, r7.rssiShiftDensityMinPercent);
        writeField(r0, 54, r7.lowRetainAnchorMinCount);
        writeField(r0, 55, r7.lowRetainMaxPercent);
        writeField(r0, 56, r7.lowRetainDensityMinPercent);
        writeField(r0, 57, r7.strongExitMaxSharedBssid);
        int r11 = r7.expectedConfigVersion;
        if (r11 < 0) goto L13;
        writeField(r0, 58, r11);
    L13:
        writeField(r0, 59, r7.coreRssiThresholdAbsDbm);
        writeField(r0, 60, r7.identityHandoffStepThreshold);
        writeField(r0, 61, r7.identityHandoffStationary60sSteps);
        return r0.toByteArray();
    }

    public static byte[] encodeEventAck(int r3, int r4, int r5, int r6, int r7, int r8) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(48);
        writeField(r0, 1, r3);
        writeField(r0, 2, 6);
        writeField(r0, 3, 3);
        writeField(r0, 4, r4);
        writeField(r0, 5, r5);
        writeField(r0, 29, r6);
        writeField(r0, 30, r7);
        writeField(r0, 31, r8);
        return r0.toByteArray();
    }

    public static byte[] encodeResetCommand(int r3, int r4, int r5, int r6) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(40);
        writeField(r0, 1, r3);
        writeField(r0, 2, 8);
        writeField(r0, 3, 3);
        writeField(r0, 4, r4);
        writeField(r0, 5, r5);
        writeField(r0, 58, r6);
        return r0.toByteArray();
    }

    private static long readVarint(byte[] r7, int[] r8) {
        long r1 = 0;
        int r3 = 0;
    L4:
        if (r3 >= 64) goto L12;
        int r4 = r8[0];
        if (r4 >= r7.length) goto L12;
        r8[0] = r4 + 1;
        int r5 = r7[r4] & 255;
        r1 = r1 | (((long) (r5 & 127)) << r3);
        if ((r5 & 128) == 0) goto L9;
        r3 = r3 + 7;
        goto L4
    L9:
        return r1;
    L12:
        throw new IllegalArgumentException("invalid protobuf varint");
    }

    private static void requireAvailable(byte[] r1, int[] r2, int r3) {
        if (r3 < 0) goto L7;
        if (r2[0] > (r1.length - r3)) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("truncated protobuf");
    }

    private static void writeField(ByteArrayOutputStream r2, int r3, long r4) {
        writeVarint(r2, ((long) r3) << 3);
        writeVarint(r2, r4 & 4294967295L);
    }

    private static void writeVarint(ByteArrayOutputStream r4, long r5) {
    L3:
        if (((-128) & r5) == 0) goto L5;
        r4.write((int) ((127 & r5) | 128));
        r5 = r5 >>> 7;
        goto L3
    L5:
        r4.write((int) r5);
    }
}
