package com.bytedance.android.live.core.utils;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e0 {
    public static final a a = null;

    public class a implements FileFilter {
        public a() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File r4) {
            String r5 = r4.getName();
            if (r5.startsWith("cpu") == false) goto L13;
            int r0 = 3;
        L6:
            if (r0 >= r5.length()) goto L11;
            if (Character.isDigit(r5.charAt(r0)) == false) goto L9;
            r0 = r0 + 1;
            goto L6
        L9:
            return false;
        L11:
            return true;
        L13:
            return false;
        }
    }

    public static int c() {
        int r1 = b("/sys/devices/system/cpu/possible");     // Catch: Throwable -> L11
        if (r1 != (-1)) goto L6;
        r1 = b("/sys/devices/system/cpu/present");     // Catch: Throwable -> L11
    L6:
        if (r1 != (-1)) goto L10;
        return new PolarisFileWrapper("/sys/devices/system/cpu/").listFiles(a).length;
    L10:
        return r1;
    L15:
        return -1;
    }

    static {
        a = new a();
    }

    public static int b(String r3) {
        int r0 = -1;
        InputStream r1 = null;
        InputStream r2 = new PolarisFileInputStreamWrapper(r3);     // Catch: Throwable -> L19 IOException -> L26
        goto L27
    L41:
        String r4 = new BufferedReader(new InputStreamReader(r2)).readLine();     // Catch: Throwable -> L16 IOException -> L18
        if (r4 != null) goto L7;
    L35:
        r2.close();     // Catch: IOException -> L13
    L15:
        return r0;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L7:
        if (r4.matches("0-[\\d]+$") == false) goto L35;
        r0 = CastIntegerProtector.valueOf(r4.substring(2)).intValue() + 1;
        goto L35
    L18:
        r1 = r2;
    L16:
        th = th;
        r1 = r2;
    L20:
        if (r1 != null) goto L33;
    L25:
        throw th;
    L33:
        r1.close();     // Catch: IOException -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = th;
    L27:
        if (r1 != null) goto L37;
    L32:
        return -1;
    L37:
        r1.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    }

    public static int a(byte[] r3, int r4) {
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
}
