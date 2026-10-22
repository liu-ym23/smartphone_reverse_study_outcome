package com.obric.cae.userAware.Garage;

import android.os.SystemClock;
import com.obric.cae.userAware.Garage.proto.GarageTelemetryChunk;
import com.obric.cae.userAware.Garage.proto.GarageTelemetryType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes3.dex */
final class GarageTelemetryReassembler {
    static final int CHUNK_BYTES = 768;
    static final int MAX_CHUNKS = 64;
    private static final int MAX_IN_FLIGHT = 2;
    static final int MAX_TOTAL_BYTES = 40000;
    static final int RAW_COMPACT_PRESSURE_VERSION = 2;
    static final int SCAN_VERSION = 1;
    static final long TIMEOUT_MS = 30000;
    private final Map<Long, Assembly> mAssemblies;

    public static final class Assembly {
        final GarageTelemetryChunk header;
        long lastUpdateElapsedMs;
        final byte[] payload;
        final boolean[] received;
        int receivedCount;

        public Assembly(GarageTelemetryChunk r2, long r3) {
            this.header = normalizedHeader(r2);
            this.payload = new byte[r2.getTotalSize()];
            this.received = new boolean[r2.getChunkCount()];
            this.lastUpdateElapsedMs = r3;
        }

        private static GarageTelemetryChunk normalizedHeader(GarageTelemetryChunk r1) {
            return r1.toBuilder().setChunkIndex(0).clearPayload().buildPartial();
        }

        public boolean add(GarageTelemetryChunk r5, long r6) {
            int r0 = r5.getChunkIndex();
            int r1 = r0 * GarageTelemetryReassembler.CHUNK_BYTES;
            byte[] r7 = r5.getPayload().toByteArray();
            this.lastUpdateElapsedMs = r6;
            if (this.received[r0] == false) goto L12;
            int r8 = 0;
        L6:
            if (r8 >= r7.length) goto L11;
            if (this.payload[r1 + r8] != r7[r8]) goto L9;
            r8 = r8 + 1;
            goto L6
        L9:
            return false;
        L11:
            return true;
        L12:
            System.arraycopy(r7, 0, this.payload, r1, r7.length);
            this.received[r0] = true;
            this.receivedCount++;
            return true;
        }

        public boolean isComplete() {
            if (this.receivedCount != this.received.length) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean matches(GarageTelemetryChunk r1) {
            return this.header.equals(normalizedHeader(r1));
        }
    }

    public static final class Result {
        final GarageTelemetryChunk header;
        final byte[] payload;

        public Result(GarageTelemetryChunk r1, byte[] r2) {
            this.header = r1;
            this.payload = r2;
        }
    }

    public GarageTelemetryReassembler() {
        this.mAssemblies = new HashMap();
    }

    private void clearExpired(long r5) {
        Iterator<Assembly> r4 = this.mAssemblies.values().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        if ((r5 - ((Assembly) ZeusTransformUtils.preCheckCast(r4.next(), Assembly.class, "com.obric.memorydata.plugin")).lastUpdateElapsedMs) < TIMEOUT_MS) goto L4;
        r4.remove();
        goto L4
    }

    private static boolean hasValidChunkLayout(GarageTelemetryChunk r5) {
        int r0 = r5.getChunkIndex() * CHUNK_BYTES;
        if (r0 >= 0) goto L5;
        return false;
    L5:
        if (r0 >= r5.getTotalSize()) goto L16;
        int r1 = Math.min(CHUNK_BYTES, r5.getTotalSize() - r0);
        if (r5.getPayload().size() == r1) goto L10;
        return false;
    L10:
        if (r5.getChunkCount() == (((r5.getTotalSize() + CHUNK_BYTES) - 1) / CHUNK_BYTES)) goto L12;
        return false;
    L12:
        return true;
    L16:
        return false;
    }

    private static boolean hasValidRawMetadata(GarageTelemetryChunk r2) {
        if (r2.hasEventDirection() == true) goto L5;
    L15:
        return false;
    L5:
        if (r2.hasEventConfidence() == false) goto L15;
        if (isBoundedCount(r2.getPressureSampleCount(), 320) == false) goto L15;
        if (isBoundedCount(r2.getAccelSampleCount(), 640) == false) goto L15;
        if (isBoundedCount(r2.getLinaccSampleCount(), 640) == false) goto L15;
        if (isBoundedCount(r2.getGyroSampleCount(), 640) == false) goto L15;
        return true;
    }

    private static boolean hasValidScanMetadata(GarageTelemetryChunk r1) {
        if (r1.hasScanId() == true) goto L5;
    L27:
        return false;
    L5:
        if (r1.hasScanPurpose() == false) goto L27;
        if (r1.hasScanResult() == false) goto L27;
        if (r1.hasRequestedScanMask() == false) goto L27;
        if (r1.hasCompletedScanMask() == false) goto L27;
        if (r1.hasSceneValid() == false) goto L27;
        if (r1.hasSceneIsUg() == false) goto L27;
        if (r1.hasSceneConfidence() == false) goto L27;
        if (r1.getPressureSampleCount() != 0) goto L27;
        if (r1.getAccelSampleCount() != 0) goto L27;
        if (r1.getLinaccSampleCount() != 0) goto L27;
        if (r1.getGyroSampleCount() != 0) goto L27;
        return true;
    }

    private static boolean isBoundedCount(int r0, int r1) {
        if (r0 < 0) goto L5;
        if (r0 > r1) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isValidHeader(GarageTelemetryChunk r3) {
        if (r3 != null) goto L5;
    L35:
        return false;
    L5:
        if (r3.getSnapshotId() == 0) goto L35;
        if (r3.getChunkCount() <= 0) goto L35;
        if (r3.getChunkCount() > 64) goto L35;
        if (r3.getChunkIndex() < 0) goto L35;
        if (r3.getChunkIndex() >= r3.getChunkCount()) goto L35;
        if (r3.getTotalSize() <= 0) goto L35;
        if (r3.getTotalSize() > MAX_TOTAL_BYTES) goto L35;
        GarageTelemetryType r1 = r3.getType();
        if (r1 != GarageTelemetryType.GARAGE_TELEMETRY_TYPE_RAW_WINDOW) goto L27;
        if (r3.getVersion() == 2) goto L24;
    L25:
        return false;
    L24:
        if (hasValidRawMetadata(r3) == false) goto L25;
    L34:
        return hasValidChunkLayout(r3);
    L27:
        if (r1 != GarageTelemetryType.GARAGE_TELEMETRY_TYPE_SCAN_FEATURE) goto L35;
        if (r3.getVersion() != 1) goto L35;
        if (hasValidScanMetadata(r3) == true) goto L34;
        goto L35
    }

    private static long key(GarageTelemetryType r2, int r3) {
        long r0 = ((long) r2.getNumber()) << 32;
        return Integer.toUnsignedLong(r3) | r0;
    }

    private void removeOldest() {
        Iterator<Map.Entry<Long, Assembly>> r0 = this.mAssemblies.entrySet().iterator();
        Long r1 = null;
        long r2 = Long.MAX_VALUE;
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((Assembly) ZeusTransformUtils.preCheckCast(r4.getValue(), Assembly.class, "com.obric.memorydata.plugin")).lastUpdateElapsedMs >= r2) goto L4;
        r1 = (Long) ZeusTransformUtils.preCheckCast(r4.getKey(), Long.class, "com.obric.memorydata.plugin");
        r2 = ((Assembly) ZeusTransformUtils.preCheckCast(r4.getValue(), Assembly.class, "com.obric.memorydata.plugin")).lastUpdateElapsedMs;
        goto L4
    L8:
        if (r1 == null) goto L16;
        this.mAssemblies.remove(r1);
        return;
    }

    public Result accept(GarageTelemetryChunk r9) {
        long r0 = SystemClock.elapsedRealtime();
        clearExpired(r0);
        if (isValidHeader(r9) == true) goto L5;
        return null;
    L5:
        long r4 = key(r9.getType(), r9.getSnapshotId());
        Assembly r2 = (Assembly) ZeusTransformUtils.preCheckCast(this.mAssemblies.get(Long.valueOf(r4)), Assembly.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L12;
        if (this.mAssemblies.size() < 2) goto L10;
        removeOldest();
    L10:
        r2 = new Assembly(r9, r0);
        this.mAssemblies.put(Long.valueOf(r4), r2);
    L16:
        if (r2.add(r9, r0) == true) goto L19;
    L13:
        this.mAssemblies.remove(Long.valueOf(r4));
        return null;
    L19:
        if (r2.isComplete() == true) goto L21;
        return null;
    L21:
        this.mAssemblies.remove(Long.valueOf(r4));
        CRC32 r8 = new CRC32();
        r8.update(r2.payload);
        if (r8.getValue() == Integer.toUnsignedLong(r9.getCrc32())) goto L25;
        return null;
    L25:
        return new Result(r2.header, r2.payload);
    L12:
        if (r2.matches(r9) == true) goto L16;
        goto L13
    }

    public void clear() {
        this.mAssemblies.clear();
    }

    public void clearExpired() {
        clearExpired(SystemClock.elapsedRealtime());
    }
}
