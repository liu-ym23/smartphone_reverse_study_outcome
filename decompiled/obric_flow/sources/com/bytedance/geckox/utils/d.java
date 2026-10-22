package com.bytedance.geckox.utils;

import android.content.Context;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.logger.DefaultLogger;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.logger.Logger;
import com.bytedance.geckox.p;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.meta.ChannelMeta;
import com.bytedance.zoin.zstd.ZstdInputStream;
import com.lynx.tasm.utils.j;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final we.a f4794a = null;

    static {
        f4794a = new we.a();
    }

    public static Long a(File r5) {
        String[] r10 = r5.getAbsolutePath().split("/");
        if (r10.length >= 2) goto L5;
        return null;
    L5:
        String r11 = r10[r10.length - 2];
        String r12 = r10[r10.length - 1];
        ChannelMeta r13 = com.bytedance.iesgurd.meta.e.a(r11, r12);
        if (r13 != null) goto L8;
        return null;
    L8:
        return com.bytedance.iesgurd.meta.e.c(r11, r12, r13, "channelDir: " + r5.getAbsolutePath());
    }

    public static String b(String r5) {
        if (r5.indexOf("/") != 0) goto L6;
        r5 = r5.substring(1);
    L6:
        if (r5.lastIndexOf("/") == (r5.length() - 1)) goto L8;
        return r5;
    L8:
        return r5.substring(0, r5.lastIndexOf("/"));
    }

    public static final void c(Closeable r5) {
        if (r5 != null) goto L15;
        return;
    L15:
        r5.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        CopyOnWriteArrayList r10 = GeckoLogger.f4756a;
        CopyOnWriteArrayList r11 = GeckoLogger.f4756a;
        if (r11.size() != 0) goto L10;
        GeckoLogger.f4757b.a("gecko-debug-tag", "close:", e);
        return;
    L10:
        Iterator r12 = r11.iterator();
    L12:
        if (r12.hasNext() == false) goto L18;
        ((DefaultLogger) ((Logger) r12.next())).a("gecko-debug-tag", "close:", e);
        goto L12
    }

    public static void d(File r5) {
        if (r5.exists() == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r5.getName(), "template.js") == true) goto L9;
        return;
    L9:
        if (r5.length() < 4) goto L29;
        RandomAccessFile r10 = null;
        RandomAccessFile r11 = new RandomAccessFile(r5, "r");     // Catch: Throwable -> L25
        int r12 = 0;
    L14:
        if (r12 > 3) goto L23;
    L20:
        th = th;
        r10 = r11;
    L26:
        c(r10);
        throw th;
    L16:
        if (r11.readByte() != 0) goto L17;
        r12 = r12 + 1;
        goto L14
    L17:
        c(r11);
        return;
    L23:
        throw new RuntimeException("file start with 4 zero: " + r5.getName());     // Catch: Throwable -> L20
    L25:
        th = th;
        goto L26
    L29:
        throw new RuntimeException("file size less than 4: " + r5.getName());
    }

    public static void e(File r10, InputStream r11) {
        ZstdInputStream r5 = null;
        FileOutputStream r12 = new FileOutputStream(r10);     // Catch: Throwable -> L18
        ZstdInputStream r13 = new ZstdInputStream(r11);     // Catch: Throwable -> L16
        byte[] r14 = new byte[32768];     // Catch: Throwable -> L11
        Ref.IntRef r15 = new Ref.IntRef();     // Catch: Throwable -> L11
    L7:
        int r16 = r13.read(r14);     // Catch: Throwable -> L11
        r15.element = r16;     // Catch: Throwable -> L11
        if (r16 == (-1)) goto L13;
        r12.write(r14, 0, r16);     // Catch: Throwable -> L11
        goto L7
    L13:
        c(r11);
        c(r12);
        c(r13);
        return;
    L11:
        th = move-exception;
        r5 = r13;
        th = th;
    L20:
        c(r11);
        c(r12);
        c(r5);
        throw th;
    L16:
        th = th;
    L18:
        th = th;
        r12 = null;
        goto L20
    }

    public static void f(File r5, String r10, String r11, String r12) {
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L4
        Object r14 = Result.m124constructorimpl(MD5Utils.INSTANCE.getMD5$geckox_noasanRelease(r5));     // Catch: Throwable -> L4
    L6:
        Long r15 = null;
        if (Result.m130isFailureimpl(r14) == false) goto L9;
        r14 = null;
    L9:
        StringBuilder r16 = com.lynx.tasm.utils.e.b("path: ", r12, ", length: ");
        r16.append(r5.length());
        r16.append(", md5: ");
        r16.append((String) r14);
        String r17 = r16.toString();
        ChannelMeta r18 = com.bytedance.iesgurd.meta.e.a(r10, r11);
        if (r18 == null) goto L12;
        r15 = r18.getUpdateTime();
    L12:
        long r19 = r5.lastModified();
        if (r15 != null) goto L15;
    L17:
        boolean r20 = false;
    L18:
        String r21 = "updateTime: " + r15 + ", lastModified: " + r19 + ", isModified: " + r20;
        EventSubType r22 = EventSubType.f;
        JSONObject r23 = new JSONObject();
        r23.put("sub_type", r22.f6615a);
        if (r10 == null) goto L21;
        r23.put("access_key", r10);
    L21:
        if (r11 == null) goto L23;
        r23.put("channels", r11);
    L23:
        if (r21 == null) goto L25;
        r23.put("err_msg", r21);
    L25:
        if (r17 == null) goto L27;
        r23.put("extra", r17);
    L27:
        j.g("geckosdk_event_message", r23);
        return;
    L15:
        if (r15.longValue() >= r19) goto L17;
        r20 = true;
    L4:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static void g(InputStream r13, String r14, String r15) {
        Closeable r5 = null;
        String r16 = new File(r14).getCanonicalPath();     // Catch: Throwable -> L72
        ZipInputStream r10 = new ZipInputStream(r13);     // Catch: Throwable -> L72
        boolean r11 = false;
    L80:
        ZipEntry r12 = r10.getNextEntry();     // Catch: Throwable -> L63
        if (r12 == null) goto L67;
        String r17 = r12.getName();     // Catch: Throwable -> L63
        if (StringsKt.P(r17, "__MACOSX/") == true) goto L65;
        if (StringsKt.k(r17, ".DS_Store") == true) goto L65;
        if (StringsKt.g(r17, "../") == true) goto L62;
        if (r15 == null) goto L22;
        if (StringsKt.P(r17, r15 + File.separator) == true) goto L22;
        com.lynx.tasm.behavior.utils.d.f(new File(r16));     // Catch: Throwable -> L63
        throw new RuntimeException("the zip package outermost folder is not named by channel:" + r15 + ",name:" + r17);     // Catch: Throwable -> L63
    L22:
        if (r12.isDirectory() == false) goto L28;
        File r18 = new File(r16, r17);     // Catch: Throwable -> L63
        if (StringsKt.P(r18.getCanonicalPath(), r16) == false) goto L27;
        r18.mkdirs();     // Catch: Throwable -> L63
        goto L65
    L27:
        throw new RuntimeException("directory traversal, dir:" + r17);     // Catch: Throwable -> L63
    L28:
        String r19 = new File(r16, r17).getCanonicalPath();     // Catch: Throwable -> L63
        if (StringsKt.P(r19, r16) == false) goto L60;
        File r20 = new File(r19);     // Catch: Throwable -> L63
        r20.getParentFile().mkdirs();     // Catch: Throwable -> L63
        FileOutputStream r21 = new FileOutputStream(r20);     // Catch: Throwable -> L56
        BufferedInputStream r22 = new BufferedInputStream(r10);     // Catch: Throwable -> L49
        BufferedOutputStream r23 = new BufferedOutputStream(r21);     // Catch: Throwable -> L49
        byte[] r110 = new byte[8192];     // Catch: Throwable -> L49
    L33:
        int r111 = r22.read(r110);     // Catch: Throwable -> L49
        if (r111 == (-1)) goto L36;
        r23.write(r110, 0, r111);     // Catch: Throwable -> L49
        goto L33
    L36:
        r23.flush();     // Catch: Throwable -> L49
        if (r20.exists() == false) goto L54;
        BufferedInputStream r24 = new BufferedInputStream(new FileInputStream(r20));     // Catch: Throwable -> L49
        byte[] r25 = new byte[8192];     // Catch: Throwable -> L49
        CRC32 r26 = new CRC32();     // Catch: Throwable -> L49
    L39:
        int r27 = r24.read(r25);     // Catch: Throwable -> L49
        if (r27 == (-1)) goto L42;
        r26.update(r25, 0, r27);     // Catch: Throwable -> L49
        goto L39
    L42:
        r24.close();     // Catch: Throwable -> L49
        long r28 = r26.getValue();     // Catch: Throwable -> L49
        long r29 = r12.getCrc();     // Catch: Throwable -> L49
        if (r29 > 0) goto L45;
    L51:
        c(r21);     // Catch: Throwable -> L63
        goto L65
    L45:
        if (r28 == r29) goto L51;
        throw new RuntimeException("unzip failed, crc check error: " + r17 + ", crc32: " + r28 + ",expected crc32: " + r12.getCrc());     // Catch: Throwable -> L49
    L54:
        throw new RuntimeException("unzip failed, file not exist: " + r17);     // Catch: Throwable -> L49
    L49:
        th = th;
        r5 = r21;
    L57:
        c(r5);     // Catch: Throwable -> L63
        throw th;     // Catch: Throwable -> L63
    L56:
        th = th;
        goto L57
    L60:
        throw new RuntimeException("directory traversal, file name:" + r17);     // Catch: Throwable -> L63
    L62:
        throw new RuntimeException("directory traversal, dir:" + r17);     // Catch: Throwable -> L63
    L65:
        r11 = true;
        goto L80
    L67:
        if (r11 == false) goto L70;
        c(r10);
        return;
    L70:
        r13.reset();     // Catch: Throwable -> L63
        throw new RuntimeException("not zip file");     // Catch: Throwable -> L63
    L63:
        th = th;
        r5 = r10;
    L73:
        c(r5);
        throw th;
    L72:
        th = th;
        goto L73
    }

    public static void h(String r5) {
        df.c.f16652i.a();
        GeckoGlobalConfig r10 = df.c.f;
        if (r10 == null) goto L5;
        Context r11 = r10.getContext();
    L6:
        if (r11 != null) goto L9;
        System.loadLibrary(r5);
        return;
    L9:
        io.reactivex.exceptions.a.p(r11, r5);
        return;
    L5:
        r11 = null;
        goto L6
    }

    public static void i(la.a r5, la.a r10) {
        if (r5 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        na.a r11 = new na.a(r5);
        ZstdInputStream r12 = null;
        ZstdInputStream r13 = new ZstdInputStream(r11);     // Catch: Throwable -> L18
        byte[] r14 = new byte[32768];     // Catch: Throwable -> L13
        Ref.IntRef r15 = new Ref.IntRef();     // Catch: Throwable -> L13
    L9:
        int r16 = r13.read(r14);     // Catch: Throwable -> L13
        r15.element = r16;     // Catch: Throwable -> L13
        if (r16 == (-1)) goto L15;
        r10.write(r14, 0, r16);     // Catch: Throwable -> L13
        goto L9
    L15:
        c(r11);
        c(r13);
        return;
    L13:
        th = move-exception;
        th = th;
        r12 = r13;
    L19:
        c(r11);
        c(r12);
        throw th;
    L18:
        th = th;
        goto L19
    }

    public static final boolean j(File r5) {
        if (r5 != null) goto L4;
        return true;
    L4:
        if (r5.exists() == false) goto L20;
        if (p.d() == false) goto L10;
        boolean r10 = com.bytedance.gkfs.a.d(r5);     // Catch: Throwable -> L17
    L11:
        if (r10 == false) goto L12;
    L13:
        GeckoLogger.a("delete file: " + r10 + ", " + r5.getAbsolutePath());
        return r10;
    L10:
        r10 = false;
    L12:
        r10 = k(r5);
        goto L13
    L20:
        return true;
    }

    public static boolean k(File r10) {
        if (r10 != null) goto L5;
    L26:
        return true;
    L5:
        if (r10.exists() == false) goto L26;
        if (r10.isDirectory() == false) goto L20;
        File[] r5 = r10.listFiles();
        if (r5 == null) goto L20;
        int r11 = r5.length;
        boolean r12 = true;
        int r13 = 0;
    L12:
        if (r13 >= r11) goto L21;
        File r14 = r5[r13];
        if (r12 == true) goto L16;
    L18:
        r12 = false;
    L19:
        r13 = r13 + 1;
        goto L12
    L16:
        if (k(r14) == false) goto L18;
        r12 = true;
    L21:
        if (r12 == true) goto L23;
    L25:
        return false;
    L23:
        if (r10.delete() == false) goto L25;
        return true;
    L20:
        r12 = true;
        goto L21
    }

    public static long l(File r10) {
        if (r10.isFile() == true) goto L5;
        File[] r11 = r10.listFiles();
        long r5 = 0;
        if (r11 == null) goto L11;
        int r12 = r11.length;
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L11;
        r5 = r5 + l(r11[r13]);
        r13 = r13 + 1;
    L11:
        return r5;
    L5:
        return r10.length();
    }
}
