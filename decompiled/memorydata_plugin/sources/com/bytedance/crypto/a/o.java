package com.bytedance.crypto.a;

import android.content.Context;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o {
    public static byte[] a(Context r12, SecretKey r13, int r14, byte[] r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        SecretKey r17 = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r13, SecretKey.class, "com.obric.memorydata.plugin");
        byte r1 = -2;
        if (r16 != null) goto L6;
        String r5 = "Context is null!!";
    L5:
        Log.e("a", r5);
    L15:
        if (r1 == 0) goto L19;
        Log.e("a", "Input param is invalid!!");
        return new byte[0];
    L19:
        if (r14 != 1) goto L28;
        byte[] r9 = new byte[12];
        new SecureRandom().nextBytes(r9);
        byte[] r18 = q.a(r14, r17, r16.getPackageName().getBytes(StandardCharsets.UTF_8), r9, r15);
        if (r18 != null) goto L23;
    L26:
        Log.e("a", "AES GCM encrypt failed!!");
        return new byte[0];
    L23:
        if (r18.length == 0) goto L26;
        byte[] r19 = new byte[r18.length + 17];
        byte r110 = (byte) 18;
        byte r3 = (byte) 205;
        System.arraycopy(new byte[]{r110, r3, r110, r3}, 0, r19, 0, 4);
        r19[4] = 1;
        System.arraycopy(r9, 0, r19, 5, 12);
        System.arraycopy(r18, 0, r19, 17, r18.length);
        return r19;
    L28:
        byte[] r10 = new byte[4];
        if (r15.length >= 4) goto L33;
        StringBuilder r111 = new StringBuilder("Input data len is too short! len:");
    L31:
        StringBuilder r112 = r111.append(r15.length);
    L32:
        String r113 = r112.toString();
    L54:
        Log.e("a", r113);
        return new byte[0];
    L33:
        System.arraycopy(r15, 0, r10, 0, 4);
        int r0 = (((r10[2] & 255) << 8) | (((r10[0] & 255) << 24) | ((r10[1] & 255) << 16))) | (r10[3] & 255);
        if (r0 == 315429581) goto L38;
        StringBuilder r114 = new StringBuilder("Cannot parse input cipher data! magic:");
    L36:
        r112 = r114.append(r0);
        goto L32
    L38:
        if (r15.length >= 5) goto L40;
        r111 = new StringBuilder("Input data len is too short!! len:");
        goto L31
    L40:
        r0 = Byte.toUnsignedInt(r15[4]);
        if (r0 == 1) goto L44;
        r114 = new StringBuilder("Input cipher data version is wrong! version:");
        goto L36
    L44:
        if (r15.length >= 17) goto L46;
        r111 = new StringBuilder("Input data len is too short for iv! len:");
        goto L31
    L46:
        byte[] r2 = new byte[12];
        System.arraycopy(r15, 5, r2, 0, 12);
        if (r15.length >= 33) goto L49;
        r111 = new StringBuilder("Input data len is too short for data cipher! len:");
        goto L31
    L49:
        int r4 = r15.length - 17;
        byte[] r6 = new byte[r4];
        System.arraycopy(r15, 17, r6, 0, r4);
        byte[] r115 = q.a(r14, r17, r16.getPackageName().getBytes(StandardCharsets.UTF_8), r2, r6);
        if (r115 != null) goto L52;
    L53:
        r113 = "AES GCM decrypt failed!!";
        goto L54
    L52:
        if (r115.length == 0) goto L53;
        return r115;
    L6:
        if (r15 != null) goto L8;
    L14:
        r5 = "Input data is empty!!";
        goto L5
    L8:
        if (r15.length == 0) goto L14;
        if (r14 == 1) goto L13;
        if (r14 == 2) goto L13;
        r5 = "Input mode is invalid!! mode:" + r14;
    L13:
        Log.i("a", "Byte xcrypt params check ok, mode:" + r14 + ", data len:" + r15.length);
        r1 = 0;
        goto L15
    }
}
