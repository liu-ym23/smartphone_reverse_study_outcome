package com.obric.cae.location.cell;

import com.obric.cae.log.CommSenseLog;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class StoreCellIdBloomFilterWriter {
    private static final double ERROR_RATE = 0.001d;
    private static final double EXPECTED_FACTOR = 1.2d;
    private static final long FNV_PRIME_32 = 16777619;
    private static final int HASH_MAX = 8;
    private static final String TAG = "StarLocation-cellid-bloom";
    private static final long UINT32_MASK = 4294967295L;

    private StoreCellIdBloomFilterWriter() {
    }

    private static byte[] buildBits(long[] r10, int r11, int r12, int r13) {
        byte[] r8 = new byte[(r12 + 7) / 8];
        int r14 = 0;
        int r15 = Math.max(0, Math.min(r11, r10.length));
    L3:
        if (r14 >= r15) goto L8;
        long r16 = r10[r14];
        int r17 = 1;
    L5:
        if (r17 > r13) goto L7;
        int r18 = (int) ((((long) fnv1aHashUint64(r16, r17)) & 4294967295L) % ((long) r12));
        int r19 = r18 >>> 3;
        r8[r19] = (byte) ((1 << (r18 & 7)) | r8[r19]);
        r17 = r17 + 1;
        goto L5
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r8;
    }

    private static int fnv1aHashUint64(long r8, int r10) {
        long r11 = ((long) r10) & 4294967295L;
        int r12 = 0;
    L4:
        if (r12 >= 8) goto L7;
        r11 = ((r11 ^ ((r8 >>> (r12 * 8)) & 255)) * FNV_PRIME_32) & 4294967295L;
        r12 = r12 + 1;
        goto L4
    L7:
        return (int) r11;
    }

    public static long makeKeyU64(long r8, long r10, int r11) {
        long r12 = (r10 & 16777215) << 3;
        long r13 = (r8 & 68719476735L) << 27;
        return (r13 | (r12 | (((long) r11) & 7))) & (-1);
    }

    public static int typeToRat(String r8) {
        if (r8 != null) goto L5;
        return 0;
    L5:
        String r10 = r8.trim();
        if (r10.equalsIgnoreCase("lte") == false) goto L10;
        return 3;
    L10:
        if (r10.equalsIgnoreCase("nr") == false) goto L13;
        return 6;
    L13:
        return 0;
    }

    public static boolean writeBloomBin(File r10, long[] r11, int r12) {
        int r8 = (int) Math.ceil(((double) Math.max(0, r12)) * EXPECTED_FACTOR);
        if (r8 > 0) goto L5;
        r8 = 1;
    L5:
        double r13 = Math.log(2.0d);
        int r14 = (int) Math.max(8, Math.min(2147483647L, (long) Math.ceil((Math.log(ERROR_RATE) * ((double) (-r8))) / (r13 * r13))));
        int r15 = (int) Math.round((((double) r14) / ((double) r8)) * r13);
        if (r15 >= 1) goto L9;
        r15 = 1;
    L11:
        byte[] r16 = buildBits(r11, r12, r14, r15);
        ByteBuffer r17 = ByteBuffer.allocate(12).order(ByteOrder.LITTLE_ENDIAN);
        r17.putInt(r14);
        r17.putInt(r15);
        r17.putInt(r8);
        FileOutputStream r18 = new FileOutputStream(r10, false);     // Catch: Throwable -> L22
        r18.write(r17.array());     // Catch: Throwable -> L16
        r18.write(r16);     // Catch: Throwable -> L16
        r18.getFD().sync();     // Catch: Throwable -> L16
        r18.close();     // Catch: Throwable -> L22
        return true;
    L16:
        th = move-exception;
        r18.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: Throwable -> L22
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CommSenseLog.e(TAG, "writeBloomBin failed: out=" + r10.getAbsolutePath(), th);
        return false;
    L9:
        if (r15 <= 8) goto L11;
        r15 = 8;
        goto L11
    }
}
