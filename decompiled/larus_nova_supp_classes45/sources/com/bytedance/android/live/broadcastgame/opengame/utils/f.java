package com.bytedance.android.live.broadcastgame.opengame.utils;

import android.util.Base64;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.common.utility.DigestUtils;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r11) {
        Intrinsics.checkNotNullParameter(r11, "roomId");
        StringBuilder r0 = new StringBuilder();
        int r1 = RangesKt.coerceAtLeast(32, r11.length());
        int r4 = 1;
        int r5 = 1;
    L3:
        if (r4 > r1) goto L38;
        String r6 = "";
        if (r4 > 32) goto L7;
        String r7 = "7f5fb48cb16bac939c1ac077077d8ad8".substring(r4 - 1, RangesKt.coerceAtMost(32, (r4 * 2) - 1));
    L9:
        if (r4 > r11.length()) goto L11;
        r6 = r11.substring(r4 - 1, RangesKt.coerceAtMost(r11.length(), (r4 * 2) - 1));
    L11:
        boolean r9 = false;
        if ((r5 % 2) != 1) goto L26;
        if (r6.length() <= 0) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L20;
        r0.insert(0, r6);
    L20:
        if (r7.length() <= 0) goto L22;
        boolean r12 = true;
    L23:
        if (r12 == false) goto L36;
        r0.insert(0, r7);
    L36:
        r5 = r5 + 1;
        r4 = r4 * 2;
        goto L3
    L22:
        r12 = false;
        goto L23
    L16:
        r8 = false;
        goto L17
    L26:
        if (r7.length() <= 0) goto L28;
        boolean r13 = true;
    L29:
        if (r13 == false) goto L32;
        r0.append(r7);
    L32:
        if (r6.length() <= 0) goto L34;
        r9 = true;
    L34:
        if (r9 == false) goto L36;
        r0.append(r6);
        goto L36
    L28:
        r13 = false;
        goto L29
    L7:
        r7 = "";
        goto L9
    L38:
        return DigestUtils.md5Hex(r0.toString());
    }

    public static String b(String r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "cipherText");
        Intrinsics.checkNotNullParameter(r5, "crypt");
        byte[] r4 = Base64.decode(r2, 0);     // Catch: Exception -> L9
        IvParameterSpec r1 = new IvParameterSpec(DigestUtils.hexStringToBytes(a(String.valueOf(r3))));     // Catch: Exception -> L9
        byte[] r6 = Base64.decode(r5, 0);     // Catch: Exception -> L9
        Charset r7 = Charsets.UTF_8;     // Catch: Exception -> L9
        String r8 = new String(r6, r7).concat(new String(Base64.decode("OGJjNmMyYWFhOWE5ZjE3ZDlkZTllY2E1OTZkOTA3ZjI=", 0), r7));     // Catch: Exception -> L9
        MessageDigest r9 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L9
        if (r8 == null) goto L8;
        SecretKeySpec r11 = new SecretKeySpec(r9.digest(r8.getBytes(r7)), "AES");     // Catch: Exception -> L9
        Cipher r12 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Exception -> L9
        r12.init(2, r11, r1);     // Catch: Exception -> L9
        return new String(r12.doFinal(r4), r7);
    L8:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        ALogger.e("OPEN_LIVE_GAME", "DecryptUtil.decrypt() :\n " + e);
        return null;
    }
}
