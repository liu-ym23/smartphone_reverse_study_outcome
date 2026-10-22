package com.ss.ugc.effectplatform.util;

import bytekn.foundation.encryption.MD5;
import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.io.file.FileType;
import bytekn.foundation.logger.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i {
    public static final i a = null;

    public i() {
    }

    static {
        a = new i();
    }

    public static String a(String r4) {
        if (r4 == null) goto L9;
        String r1 = FileManager.a;
        if (StringsKt.endsWith$default(r4, r1, false, 2, null) == false) goto L8;
        return StringsKt.dropLast(r4, 1) + "_tmp" + r1;
    L8:
        return r4.concat("_tmp");
    L9:
        return null;
    }

    public static String d(String r5) {
        String r0 = FileManager.a;
        bytekn.foundation.io.file.b r6 = FileManager.j(r5);
        MD5 r1 = new MD5();
        byte[] r2 = new byte[1024];
        int r3 = r6.a(r2, 1024);
    L3:
        if (r3 <= 0) goto L5;
        r1.update(r2, 0, r3);
        r3 = r6.a(r2, 1024);
        goto L3
    L5:
        byte[] r4 = r1.e();
        r6.close();
        return bytekn.foundation.encryption.b.a(r4);
    }

    public static String e(String r7) {
        if (r7 == null) goto L9;
        int r1 = StringsKt.lastIndexOf$default(r7, FileManager.a, 0, false, 6, null);
        if (r1 >= 0) goto L8;
        return null;
    L8:
        return r7.substring(r1 + 1, r7.length());
    L9:
        return null;
    }

    public static long f(String r7) {
        if (r7 == null) goto L29;
        String r2 = FileManager.a;
        bytekn.foundation.io.file.d r3 = FileManager.a(new PolarisFileWrapper(r7));
        if (r3.getType() != FileType.Directory) goto L21;
        List r8 = FileManager.m(r7);
        if (r8 == null) goto L20;
        Iterator r9 = r8.iterator();
        long r4 = 0;
    L10:
        if (r9.hasNext() == false) goto L19;
        bytekn.foundation.io.file.d r5 = (bytekn.foundation.io.file.d) r9.next();
        if (r5.getType() != FileType.Directory) goto L14;
        long r6 = f(r5.b.b);
    L18:
        r4 = r4 + r6;
        goto L10
    L14:
        Long r10 = r5.f;
        if (r10 == null) goto L17;
        r6 = r10.longValue();
        goto L18
    L17:
        r6 = 0;
        goto L18
    L19:
        return r4;
    L20:
        return 0;
    L21:
        Long r11 = r3.f;
        if (r11 != null) goto L24;
        return 0;
    L24:
        return r11.longValue();
    L29:
        return 0;
    }

    public static String g(String r7) {
        if (r7 == null) goto L9;
        int r1 = StringsKt.lastIndexOf$default(r7, FileManager.a, 0, false, 6, null);
        if (r1 >= 0) goto L8;
        return null;
    L8:
        return r7.substring(0, r1);
    L9:
        return null;
    }

    public final boolean delete(bytekn.foundation.io.file.f r9) {
        if (r9 == null) goto L9;
        String r0 = FileManager.a;
        boolean r1 = FileManager.n(r9);
        if (r1 == false) goto L6;
    L8:
        return r1;
    L6:
        if (FileManager.c(r9) == false) goto L8;
        Logger.e$default(Logger.INSTANCE, "FileUtils", "remove file: " + r9.b + " failed!", null, 4, null);
        h(r9.b, r9.b + "_dirty", true);
        goto L8
    L9:
        return false;
    }

    public final boolean delete(String r9) {
        if (r9 == null) goto L9;
        String r0 = FileManager.a;
        boolean r1 = FileManager.o(r9);
        if (r1 == false) goto L6;
    L8:
        return r1;
    L6:
        if (FileManager.d(r9) == false) goto L8;
        Logger.e$default(Logger.INSTANCE, "FileUtils", "remove file: " + r9 + " failed!", null, 4, null);
        h(r9, r9.concat("_dirty"), true);
        goto L8
    L9:
        return false;
    }

    public static void i(String r3, com.ss.ugc.effectplatform.download.d r4) {
        String r0 = FileManager.a;
        b(r4, FileManager.l(r3, false), 0, null);
    }

    public static boolean h(String r3, String r4, boolean r5) {
        if (r3 == null) goto L23;
        String r1 = FileManager.a;
        if (new PolarisFileWrapper(r3).getAbsoluteFile().renameTo(new PolarisFileWrapper(r4).getAbsoluteFile()) == true) goto L21;
        if (r5 == false) goto L24;
        new PolarisFileWrapper(r3).getAbsoluteFile();
        if (r4 == null) goto L10;
        new PolarisFileWrapper(r4).getAbsoluteFile();
    L10:
        if (r4 == null) goto L12;
        boolean r6 = FileManager.d(r4);
    L13:
        if (r6 == false) goto L16;
        if (r4 == null) goto L16;
        FileManager.o(r4);
    L16:
        PolarisFileWrapper r7 = new PolarisFileWrapper(r3);
        PolarisFileWrapper r8 = new PolarisFileWrapper(r4);
        if (r7.exists() == true) goto L20;
        return false;
    L20:
        return r7.renameTo(r8);
    L12:
        r6 = false;
        goto L13
    L24:
        return false;
    L21:
        return true;
    L23:
        return false;
    }

    public static long b(bytekn.foundation.io.file.b r10, bytekn.foundation.io.file.e r11, long r12, Function2 r14) {
        byte[] r1 = new byte[8192];
        int r2 = r10.a(r1, 8192);
        long r5 = 0;
    L4:
        if (r2 <= 0) goto L12;
        r11.b(r1, r2);
        r5 = r5 + ((long) r2);
        if (r5 >= r12) goto L11;
        if (r12 <= 0) goto L11;
        if (r14 == null) goto L11;
        Unit r3 = (Unit) r14.invoke(Integer.valueOf((int) ((r5 / r12) * 100)), Long.valueOf(r12));
    L11:
        r2 = r10.a(r1, 8192);
        goto L4
    L12:
        if (r14 == null) goto L14;
        Unit r13 = (Unit) r14.invoke(100, Long.valueOf(r12));
    L14:
        r11.a();
        r11.close();
        return r5;
    }

    public static String c(bytekn.foundation.io.file.b r11, bytekn.foundation.io.file.j r12, long r13, Function2 r15) {
        MD5 r0 = new MD5();
        byte[] r2 = new byte[8192];
        int r3 = r11.a(r2, 8192);
        long r6 = 0;
    L4:
        if (r3 <= 0) goto L12;
        r12.b(r2, r3);
        r6 = r6 + ((long) r3);
        r0.update(r2, 0, r3);
        if (r6 >= r13) goto L11;
        if (r13 <= 0) goto L11;
        if (r15 == null) goto L11;
        Unit r4 = (Unit) r15.invoke(Integer.valueOf((int) ((r6 / r13) * 100)), Long.valueOf(r13));
    L11:
        r3 = r11.a(r2, 8192);
        goto L4
    L12:
        if (r15 == null) goto L14;
        Unit r14 = (Unit) r15.invoke(100, Long.valueOf(r13));
    L14:
        byte[] r16 = r0.e();
        r12.a();
        r12.close();
        return bytekn.foundation.encryption.b.a(r16);
    }
}
