package com.lynx.tasm.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Process;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import java.io.OutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m {
    public static Typeface a(String r2) {
        if (TypeFaceOptimizer.getSwitch() == false) goto L14;
        if (r2 == null) goto L14;
        if (TypeFaceLancet.cache.contains(r2) == true) goto L8;
        Typeface r0 = Typeface.createFromFile(r2);
        if (r0 == null) goto L14;
        TypeFaceLancet.cache.put(r2, r0);
        return r0;
    L8:
        return (Typeface) TypeFaceLancet.cache.get(r2);
    L14:
        return Typeface.createFromFile(r2);
    }

    public static boolean b(PolarisFileWrapper r2, byte[] r3) {
        OutputStream r0 = null;
        OutputStream r1 = new PolarisFileOutputStreamWrapper(r2);     // Catch: Throwable -> L11 Exception -> L15
        r1.write(r3);     // Catch: Throwable -> L8 Exception -> L10
        r1.flush();     // Catch: Throwable -> L8 Exception -> L10
        r1.close();     // Catch: Exception -> L20
        return true;
    L33:
        return true;
    L10:
        r0 = r1;
    L8:
        th = th;
        r0 = r1;
    L12:
        if (r0 != null) goto L25;
    L14:
        throw th;
    L25:
        r0.close();     // Catch: Exception -> L21
        goto L14
    L11:
        th = th;
    L16:
        if (r0 == null) goto L34;
        r0.close();     // Catch: Exception -> L22
        return false;
    L35:
        return false;
    L34:
        return false;
    }

    public static Typeface c(Context r6, byte[] r7) {
        String r0 = ".lynx-font" + Process.myPid() + "-" + Process.myTid() + "-";
        int r1 = 0;
    L4:
        if (r1 >= 100) goto L10;
        PolarisFileWrapper r2 = new PolarisFileWrapper(r6.getCacheDir(), r0 + r1);
        if (r2.createNewFile() == false) goto L9;
    L11:
        if (r2 != null) goto L28;
        return null;
    L28:
    L23:
        r2.delete();
        return null;
    L20:
        th = move-exception;
        r2.delete();
        throw th;
    L14:
        if (b(r2, r7) == true) goto L17;
        r2.delete();
        return null;
    L17:
        Typeface r8 = a(r2.getPath());     // Catch: Throwable -> L20 RuntimeException -> L23
        r2.delete();
        return r8;
    L9:
        r1 = r1 + 1;
        goto L4
    L10:
        r2 = null;
        goto L11
    }
}
