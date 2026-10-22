package com.obric.cae.location.cell;

import com.bytedance.bdlocation.client.LocationInfoConst;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static int a(String r2) {
        if (r2 != null) goto L5;
        return 0;
    L5:
        String r3 = r2.trim();
        if (r3.equalsIgnoreCase(LocationInfoConst.LTE) == false) goto L10;
        return 3;
    L10:
        if (r3.equalsIgnoreCase(LocationInfoConst.NR) == false) goto L13;
        return 6;
    L13:
        return 0;
    }

    public static long a(long r4, long r6, int r8) {
        long r7 = (r6 & 16777215) << 3;
        long r5 = (r4 & 68719476735L) << 27;
        return (r5 | (r7 | (((long) r8) & 7))) & (-1);
    }

    public static boolean a(File r21, long[] r22, int r23) {
        int r2 = 0;
        int r3 = (int) Math.ceil(((double) Math.max(0, r23)) * 1.2d);
        int r4 = 1;
        if (r3 > 0) goto L5;
        r3 = 1;
    L5:
        double r5 = Math.log(2.0d);
        int r7 = (int) Math.max(8, Math.min(2147483647L, (long) Math.ceil((Math.log(0.001d) * ((double) (-r3))) / (r5 * r5))));
        int r6 = (int) Math.round((((double) r7) / ((double) r3)) * r5);
        if (r6 >= 1) goto L8;
        r6 = 1;
    L10:
        byte[] r8 = new byte[(r7 + 7) / 8];
        int r1 = Math.max(0, Math.min(r23, r22.length));
        int r9 = 0;
    L11:
        if (r9 >= r1) goto L19;
        long r10 = r22[r9];
        int r12 = r4;
    L13:
        if (r12 > r6) goto L18;
        long r13 = ((long) r12) & 4294967295L;
    L15:
        if (r2 >= 8) goto L17;
        r13 = ((r13 ^ ((r10 >>> (r2 * 8)) & 255)) * 16777619) & 4294967295L;
        r2 = r2 + 1;
        goto L15
    L17:
        int r15 = r6;
        int r11 = (int) ((((long) ((int) r13)) & 4294967295L) % ((long) r7));
        int r14 = r11 >>> 3;
        r8[r14] = (byte) ((1 << (r11 & 7)) | r8[r14]);
        r12 = r12 + 1;
        r6 = r15;
        r2 = 0;
        goto L13
    L18:
        r9 = r9 + 1;
        r2 = 0;
        r4 = 1;
        goto L11
    L19:
        ByteBuffer r0 = ByteBuffer.allocate(12).order(ByteOrder.LITTLE_ENDIAN);
        r0.putInt(r7);
        r0.putInt(r6);
        r0.putInt(r3);
        FileOutputStream r16 = new FileOutputStream(r21, false);     // Catch: Throwable -> L35
        r16.write(r0.array());     // Catch: Throwable -> L27
        r16.write(r8);     // Catch: Throwable -> L27
        r16.getFD().sync();     // Catch: Throwable -> L27
        r16.close();     // Catch: Throwable -> L35
        return true;
    L27:
        th = move-exception;
        r16.close();     // Catch: Throwable -> L31
    L51:
        throw th;     // Catch: Throwable -> L35
    L31:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L35
    L35:
        th = th;
    L39:
        com.obric.cae.log.a.a("StarLocation-cellid-bloom", "writeBloomBin failed: out=" + r21.getAbsolutePath(), th);
        return false;
    L37:
        th = th;
        goto L39
    L8:
        if (r6 <= 8) goto L10;
        r6 = 8;
        goto L10
    }
}
