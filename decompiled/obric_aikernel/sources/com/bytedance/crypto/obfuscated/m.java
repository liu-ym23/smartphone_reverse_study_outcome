package com.bytedance.crypto.obfuscated;

import android.content.Context;
import android.util.Log;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    public static byte[] a(Context r12, SecretKey r13, int r14, byte[] r15) {
        byte r10 = -2;
        if (r12 != null) goto L6;
        String r11 = "Context is null!!";
    L5:
        Log.e("a", r11);
    L15:
        if (r10 == 0) goto L19;
        Log.e("a", "Input param is invalid!!");
        return new byte[0];
    L19:
        if (r14 != 1) goto L28;
        byte[] r16 = new byte[12];
        new SecureRandom().nextBytes(r16);
        byte[] r17 = o.a(r14, r13, r12.getPackageName().getBytes(StandardCharsets.UTF_8), r16, r15);
        if (r17 != null) goto L23;
    L26:
        Log.e("a", "AES GCM encrypt failed!!");
        return new byte[0];
    L23:
        if (r17.length == 0) goto L26;
        byte[] r18 = new byte[r17.length + 17];
        byte r19 = (byte) 18;
        byte r20 = (byte) 205;
        System.arraycopy(new byte[]{r19, r20, r19, r20}, 0, r18, 0, 4);
        r18[4] = 1;
        System.arraycopy(r16, 0, r18, 5, 12);
        System.arraycopy(r17, 0, r18, 17, r17.length);
        return r18;
    L28:
        byte[] r21 = new byte[4];
        if (r15.length >= 4) goto L33;
        StringBuilder r110 = new StringBuilder("Input data len is too short! len:");
    L31:
        r110.append(r15.length);
    L32:
        String r111 = r110.toString();
    L54:
        Log.e("a", r111);
        return new byte[0];
    L33:
        System.arraycopy(r15, 0, r21, 0, 4);
        int r22 = (((r21[2] & 255) << 8) | (((r21[0] & 255) << 24) | ((r21[1] & 255) << 16))) | (r21[3] & 255);
        if (r22 == 315429581) goto L38;
        r110 = new StringBuilder("Cannot parse input cipher data! magic:");
    L36:
        r110.append(r22);
        goto L32
    L38:
        if (r15.length >= 5) goto L40;
        r110 = new StringBuilder("Input data len is too short!! len:");
        goto L31
    L40:
        r22 = Byte.toUnsignedInt(r15[4]);
        if (r22 == 1) goto L44;
        r110 = new StringBuilder("Input cipher data version is wrong! version:");
        goto L36
    L44:
        if (r15.length >= 17) goto L46;
        r110 = new StringBuilder("Input data len is too short for iv! len:");
        goto L31
    L46:
        byte[] r23 = new byte[12];
        System.arraycopy(r15, 5, r23, 0, 12);
        if (r15.length >= 33) goto L49;
        r110 = new StringBuilder("Input data len is too short for data cipher! len:");
        goto L31
    L49:
        int r24 = r15.length - 17;
        byte[] r25 = new byte[r24];
        System.arraycopy(r15, 17, r25, 0, r24);
        byte[] r112 = o.a(r14, r13, r12.getPackageName().getBytes(StandardCharsets.UTF_8), r23, r25);
        if (r112 != null) goto L52;
    L53:
        r111 = "AES GCM decrypt failed!!";
        goto L54
    L52:
        if (r112.length == 0) goto L53;
        return r112;
    L6:
        if (r15 != null) goto L8;
    L14:
        r11 = "Input data is empty!!";
        goto L5
    L8:
        if (r15.length == 0) goto L14;
        if (r14 == 1) goto L13;
        if (r14 == 2) goto L13;
        r11 = "Input mode is invalid!! mode:" + r14;
    L13:
        Log.i("a", "Byte xcrypt params check ok, mode:" + r14 + ", data len:" + r15.length);
        r10 = 0;
        goto L15
    }
}
