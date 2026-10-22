package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends c {
    public long d;
    public long e;
    public int f;

    @Override // com.google.common.hash.c
    public final void C(ByteBuffer r15) {
        long r5 = r15.getLong();
        long r10 = r15.getLong();
        long r11 = (Long.rotateLeft(r5 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.d;
        this.d = r11;
        long r12 = Long.rotateLeft(r11, 27);
        long r13 = this.e;
        this.d = ((r12 + r13) * 5) + 1390208809;
        long r14 = (Long.rotateLeft(r10 * 5545529020109919103L, 33) * (-8663945395140668459L)) ^ r13;
        this.e = r14;
        this.e = ((Long.rotateLeft(r14, 31) + this.d) * 5) + 944331445;
        this.f += 16;
    }

    @Override // com.google.common.hash.c
    public final void D(ByteBuffer r14) {
        this.f = r14.remaining() + this.f;
        long r10 = 0;
        switch(r14.remaining()) {
            case 1: goto L25;
            case 2: goto L23;
            case 3: goto L21;
            case 4: goto L19;
            case 5: goto L17;
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
            default: goto L5;
        };
    L6:
        r10 = ((long) (r14.get(14) & UByte.MAX_VALUE)) << 48;
    L7:
        r10 = r10 ^ (((long) (r14.get(13) & UByte.MAX_VALUE)) << 40);
    L8:
        r10 = r10 ^ (((long) (r14.get(12) & UByte.MAX_VALUE)) << 32);
    L9:
        r10 = r10 ^ (((long) (r14.get(11) & UByte.MAX_VALUE)) << 24);
    L10:
        r10 = r10 ^ (((long) (r14.get(10) & UByte.MAX_VALUE)) << 16);
    L11:
        r10 = r10 ^ (((long) (r14.get(9) & UByte.MAX_VALUE)) << 8);
    L12:
        r10 = r10 ^ ((long) (r14.get(8) & UByte.MAX_VALUE));
    L13:
        long r5 = r14.getLong();
    L27:
        this.d = (Long.rotateLeft(r5 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.d;
        this.e ^= Long.rotateLeft(r10 * 5545529020109919103L, 33) * (-8663945395140668459L);
        return;
    L14:
        long r11 = ((long) (r14.get(6) & UByte.MAX_VALUE)) << 48;
    L16:
        long r12 = (((long) (r14.get(5) & UByte.MAX_VALUE)) << 40) ^ r11;
    L18:
        long r13 = r12 ^ (((long) (r14.get(4) & UByte.MAX_VALUE)) << 32);
    L20:
        long r15 = r13 ^ (((long) (r14.get(3) & UByte.MAX_VALUE)) << 24);
    L22:
        long r16 = (((long) (r14.get(2) & UByte.MAX_VALUE)) << 16) ^ r15;
    L24:
        long r17 = r16 ^ (((long) (r14.get(1) & UByte.MAX_VALUE)) << 8);
    L26:
        r5 = r17 ^ ((long) (r14.get(0) & UByte.MAX_VALUE));
        goto L27
    L15:
        r11 = 0;
        goto L16
    L17:
        r12 = 0;
        goto L18
    L19:
        r13 = 0;
        goto L20
    L21:
        r15 = 0;
        goto L22
    L23:
        r16 = 0;
        goto L24
    L25:
        r17 = 0;
        goto L26
    L5:
        throw new AssertionError("Should never get here.");
    }

    @Override // com.google.common.hash.c
    public final j z() {
        long r5 = this.d;
        long r10 = this.f;
        long r11 = r5 ^ r10;
        long r12 = r10 ^ this.e;
        long r13 = r11 + r12;
        long r14 = r12 + r13;
        long r15 = (r13 ^ (r13 >>> 33)) * (-49064778989728563L);
        long r16 = (r15 ^ (r15 >>> 33)) * (-4265267296055464877L);
        long r17 = (r14 ^ (r14 >>> 33)) * (-49064778989728563L);
        long r18 = (r17 ^ (r17 >>> 33)) * (-4265267296055464877L);
        long r19 = r18 ^ (r18 >>> 33);
        long r20 = (r16 ^ (r16 >>> 33)) + r19;
        this.d = r20;
        this.e = r19 + r20;
        return j.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.d).putLong(this.e).array());
    }
}
