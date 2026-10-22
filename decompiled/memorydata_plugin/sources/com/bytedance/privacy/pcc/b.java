package com.bytedance.privacy.pcc;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EncryptedPayloadTlv f3047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f3048b;

    public b(EncryptedPayloadTlv r1, byte[] r2) {
        this.f3047a = r1;
        if (r2 != null) goto L6;
        r2 = new byte[0];
    L6:
        this.f3048b = r2;
    }

    public static b a(byte[] r5) {
        int r0 = 0;
        if (r5 != null) goto L5;
    L24:
        StringBuilder r2 = new StringBuilder().append("EncryptedProtocol: data too short (");
        if (r5 == null) goto L29;
        r0 = r5.length;
    L29:
        throw new Exception(r2.append(r0).append(" bytes)").toString());
    L5:
        if (r5.length < 6) goto L24;
        int r1 = ((r5[0] & 255) << 8) | (r5[1] & 255);
        if (r1 != 8193) goto L23;
        int r3 = ((((r5[2] & 255) << 24) | ((r5[3] & 255) << 16)) | ((r5[4] & 255) << 8)) | (r5[5] & 255);
        if (r3 < 0) goto L21;
        int r4 = r3 + 6;
        if (r4 > r5.length) goto L19;
        byte[] r6 = new byte[r3];
        System.arraycopy(r5, 6, r6, 0, r3);
        int r7 = r5.length - r4;
        byte[] r8 = new byte[r7];
        if (r7 <= 0) goto L17;
        System.arraycopy(r5, r4, r8, 0, r7);
    L17:
        return new b(EncryptedPayloadTlv.a(r6), r8);
    L19:
        throw new Exception("EncryptedProtocol: TLV length " + r3 + " exceeds remaining buffer " + (r5.length - 6));
    L21:
        throw new Exception("EncryptedProtocol: TLV length overflow");
    L23:
        throw new Exception("EncryptedProtocol: invalid magic 0x" + Integer.toHexString(r1) + " (expected 0x2001)");
    }

    public byte[] a() {
        byte[] r0 = this.f3047a.a();
        int r1 = r0.length;
        ByteArrayOutputStream r2 = new ByteArrayOutputStream((r1 + 6) + this.f3048b.length);
        r2.write(32);
        r2.write(1);
        r2.write((r1 >> 24) & 255);
        r2.write((r1 >> 16) & 255);
        r2.write((r1 >> 8) & 255);
        r2.write(r1 & 255);
        r2.write(r0, 0, r1);
        byte[] r5 = this.f3048b;
        if (r5.length <= 0) goto L6;
        r2.write(r5, 0, r5.length);
    L6:
        return r2.toByteArray();
    }
}
