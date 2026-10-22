package com.larksuite.component.card.utils;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e {
    public static String a(byte[] r8) {
        if (r8 != null) goto L4;
        return "";
    L4:
        if (r8.length == 0) goto L14;
        char[] r0 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] r1 = new char[r8.length * 2];
        int r2 = r8.length;
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r3 >= r2) goto L10;
        int r5 = r4 + 1;
        byte r6 = r8[r3];
        r1[r4] = r0[(r6 >>> 4) & 15];
        r4 = r5 + 1;
        r1[r5] = r0[r6 & 15];
        r3 = r3 + 1;
        goto L7
    L10:
        return new String(r1);
    L14:
        return "";
    }

    public static String b(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return "";
    L5:
        String r5 = r4 + "42b91e";
        if (TextUtils.isEmpty(r5) == false) goto L20;
    L7:
        String r6 = "";
    L12:
        String r7 = "08a441".concat(r6);
        if (TextUtils.isEmpty(r7) == true) goto L24;
        MessageDigest r0 = MessageDigest.getInstance("SHA1");     // Catch: Exception -> L17
        r0.update(r7.getBytes(Charset.forName("UTF-8")));     // Catch: Exception -> L17
        return a(r0.digest());
    L17:
        e = move-exception;
        e.printStackTrace();
        return "";
    L24:
        return "";
    L20:
        r6 = a(MessageDigest.getInstance("MD5").digest(r5.getBytes(Charset.forName("UTF-8"))));     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
