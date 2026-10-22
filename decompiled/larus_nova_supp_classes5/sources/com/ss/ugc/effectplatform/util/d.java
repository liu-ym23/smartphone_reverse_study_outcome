package com.ss.ugc.effectplatform.util;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.Closeable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d {
    public static final Map<String, Object> a = null;

    public static class a {
        public long a;

        public a() {
        }
    }

    static {
        a = new ConcurrentHashMap();
    }

    public static void a(Closeable r0) {
        if (r0 == null) goto L10;
        r0.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static int b(byte[] r3, int r4) {
    L3:
        if (r4 >= r3.length) goto L17;
        byte r0 = r3[r4];
        if (r0 == 10) goto L24;
        if (Character.isDigit(r0) == true) goto L8;
        r4 = r4 + 1;
        goto L3
    L8:
        int r1 = r4 + 1;
    L10:
        if (r1 >= r3.length) goto L15;
        if (Character.isDigit(r3[r1]) == false) goto L15;
        r1 = r1 + 1;
    L15:
        return CastIntegerProtector.parseInt(new String(r3, 0, r4, r1 - r4));
    L24:
        return -1;
    L17:
        return -1;
    }

    public static int c(String r7, PolarisFileInputStreamWrapper r8) {
        byte[] r0 = new byte[1024];
        int r9 = r8.read(r0);     // Catch: Throwable -> L22
        int r2 = 0;
    L4:
        if (r2 >= r9) goto L21;
        byte r3 = r0[r2];     // Catch: Throwable -> L22
        if (r3 == 10) goto L8;
        if (r2 == 0) goto L8;
    L20:
        r2 = r2 + 1;
    L8:
        if (r3 != 10) goto L10;
        r2 = r2 + 1;     // Catch: Throwable -> L22
    L10:
        int r4 = r2;
    L11:
        if (r4 >= r9) goto L20;
        int r5 = r4 - r2;     // Catch: Throwable -> L22
        if (r0[r4] != r7.charAt(r5)) goto L20;
        if (r5 == (r7.length() - 1)) goto L17;
        r4 = r4 + 1;
        goto L11
    L17:
        return b(r0, r4);
    L21:
        return -1;
    }
}
