package com.obric.cae.userAware.poi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class PoiAwareCodec {
    static final int COMMAND_COMPLETE_REQUEST = 4;
    static final int COMMAND_DEBUG_SNAPSHOT = 5;
    static final int COMMAND_PING = 1;
    static final int COMMAND_QUERY_CONFIG = 6;
    static final int COMMAND_RESET_CONFIG = 7;
    static final int COMMAND_SYNC_STATE = 2;
    static final int COMMAND_UPDATE_CONFIG = 3;
    static final int COMPLETION_ACCEPTED = 1;
    static final int COMPLETION_REJECTED = 2;
    static final int PROTOCOL_VERSION = 3;
    static final int STATUS_ACK = 2;
    static final int STATUS_ERROR = 3;
    static final int STATUS_READY = 1;

    public static final class Event {
        private final Map<Integer, byte[]> bytes;
        int requestId;
        int typeOrReason;
        long value10;
        long value11;
        long value12;
        long value13;
        long value14;
        long value15;
        long value16;
        long value17;
        long value2;
        long value3;
        long value4;
        long value5;
        long value6;
        long value7;
        long value8;
        long value9;
        private final Map<Integer, Long> values;

        public Event() {
            this.values = new HashMap();
            this.bytes = new HashMap();
        }

        public static /* synthetic */ void access$000(Event r0, byte[] r1, int[] r2, int r3, int r4) {
            r0.readField(r1, r2, r3, r4);
        }

        private void readField(byte[] r3, int[] r4, int r5, int r6) {
            if (r5 == 0) goto L23;
            if (r6 != 0) goto L6;
            long r7 = PoiAwareCodec.access$100(r3, r4);
            this.values.put(Integer.valueOf(r5), Long.valueOf(r7));
            setLegacyValue(r5, r7);
            return;
        L6:
            if (r6 != 1) goto L10;
            int r2 = 8;
        L8:
            skip(r3, r4, r2);
            return;
        L10:
            if (r6 != 2) goto L17;
            long r8 = PoiAwareCodec.access$100(r3, r4);
            if (r8 > 2147483647L) goto L15;
            r2 = (int) r8;
            goto L8
        L15:
            throw new IllegalArgumentException("invalid protobuf bytes");
        L17:
            if (r6 != 5) goto L21;
            r2 = 4;
            goto L8
        L21:
            throw new IllegalArgumentException("unsupported protobuf wire type=" + r6);
        L23:
            throw new IllegalArgumentException("invalid protobuf field");
        }

        private void setLegacyValue(int r1, long r2) {
            switch(r1) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                case 14: goto L7;
                case 15: goto L6;
                case 16: goto L5;
                case 17: goto L4;
                default: goto L38;
            };
        L4:
            this.value17 = r2;
            return;
        L5:
            this.value16 = r2;
            return;
        L6:
            this.value15 = r2;
            return;
        L7:
            this.value14 = r2;
            return;
        L8:
            this.value13 = r2;
            return;
        L9:
            this.value12 = r2;
            return;
        L10:
            this.value11 = r2;
            return;
        L11:
            this.value10 = r2;
            return;
        L12:
            this.value9 = r2;
            return;
        L13:
            this.value8 = r2;
            return;
        L14:
            this.value7 = r2;
            return;
        L15:
            this.value6 = r2;
            return;
        L16:
            this.value5 = r2;
            return;
        L17:
            this.value4 = r2;
            return;
        L18:
            this.value3 = r2;
            return;
        L19:
            this.typeOrReason = (int) r2;
            this.value2 = r2;
            return;
        L20:
            this.requestId = (int) r2;
            return;
        }

        private static void skip(byte[] r2, int[] r3, int r4) {
            if (r4 < 0) goto L8;
            int r1 = r3[0];
            if (r1 > (r2.length - r4)) goto L8;
            r3[0] = r1 + r4;
            return;
        L8:
            throw new IllegalArgumentException("truncated protobuf");
        }

        public boolean hasV2WakeupIdentity() {
            if (hasVarintField(1) == true) goto L5;
        L11:
            return false;
        L5:
            if (hasVarintField(4) == false) goto L11;
            if (hasVarintField(5) == false) goto L11;
            if (hasVarintField(11) == false) goto L11;
            return true;
        }

        public boolean hasValidWakeupFields() {
            if (hasV2WakeupIdentity() == true) goto L5;
        L9:
            return false;
        L5:
            if (hasVarintField(2) == false) goto L9;
            if (hasVarintField(6) == false) goto L9;
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
    }

    private PoiAwareCodec() {
    }

    public static /* synthetic */ long access$100(byte[] r0, int[] r1) {
        return readVarint(r0, r1);
    }

    public static Event decodeEvent(byte[] r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        Event r0 = new Event();
        int[] r1 = {0};
    L7:
        if (r1[0] >= r8.length) goto L9;
        long r3 = readVarint(r8, r1);
        Event.access$000(r0, r8, r1, (int) (r3 >>> 3), (int) (r3 & 7));
        goto L7
    L9:
        return r0;
    }

    public static byte[] encodeCommand(int r3, int r4, int r5, int r6, int r7, int r8, int r9, PoiAwareBridge.Config r10) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(96);
        writeField(r0, 1, r3);
        writeField(r0, 2, r4);
        writeField(r0, 3, 3);
        writeField(r0, 4, r5);
        writeField(r0, 5, r6);
        writeField(r0, 6, r7);
        if (r8 == 0) goto L5;
        writeField(r0, 7, r8);
    L5:
        if (r10 == null) goto L9;
        writeField(r0, 8, r10.stationaryDelaySeconds);
        writeField(r0, 9, r10.walkStepThreshold);
        writeField(r0, 10, r10.stationaryStepDeltaThreshold);
        writeField(r0, 11, r10.stationaryCheckIntervalMs);
        writeField(r0, 12, r10.upDownSuppressSeconds);
        writeField(r0, 13, r10.configVersion);
        writeField(r0, 14, r10.algorithmVersion);
        writeField(r0, 15, r10.stepWindowBucketCount);
        writeField(r0, 16, r10.entryStepThreshold);
        writeField(r0, 17, r10.requiredLowChecks);
        writeField(r0, 18, r10.harHoldSeconds);
        writeField(r0, 19, r10.harGuardStepThreshold);
        writeField(r0, 20, r10.eventAckTimeoutSeconds);
        writeField(r0, 21, r10.retryBackoffInitialSeconds);
        writeField(r0, 22, r10.retryBackoffMaxSeconds);
        writeField(r0, 24, r10.stepWindowSeconds);
        int r11 = r10.expectedConfigVersion;
        if (r11 < 0) goto L9;
        writeField(r0, 25, r11);
    L9:
        if (r9 == 0) goto L12;
        writeField(r0, 23, r9);
    L12:
        return r0.toByteArray();
    }

    public static byte[] encodeResetCommand(int r3, int r4, int r5, int r6, int r7, int r8) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(48);
        writeField(r0, 1, r3);
        writeField(r0, 2, 7);
        writeField(r0, 3, 3);
        writeField(r0, 4, r4);
        writeField(r0, 5, r5);
        writeField(r0, 6, r6);
        writeField(r0, 13, r7);
        writeField(r0, 25, r8);
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
