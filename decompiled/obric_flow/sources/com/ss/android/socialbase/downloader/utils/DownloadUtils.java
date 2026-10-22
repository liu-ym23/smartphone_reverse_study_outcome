package com.ss.android.socialbase.downloader.utils;

import ai.j0;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.room.writer.DaoWriter;
import com.lynx.tasm.utils.j;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.md5.TTMd5;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import io.reactivex.internal.observers.h;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DownloadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f16142a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ConnectivityManager f16143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f16144c;
    public static volatile AtomicInteger d;

    static {
        f16142a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f16144c = null;
        d = new AtomicInteger(-1);
    }

    public static String a(Throwable r5, String r10) {
        StringBuilder r11 = j.d(r10, DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r11.append(a(r5));
        return r11.toString();
    }

    public static boolean b(Context r5) {
        ConnectivityManager r10 = f16143b;     // Catch: Exception -> L11
        if (r10 != null) goto L6;
        r10 = (ConnectivityManager) r5.getSystemService("connectivity");     // Catch: Exception -> L11
        f16143b = r10;     // Catch: Exception -> L11
    L6:
        NetworkInfo r11 = r10.getActiveNetworkInfo();     // Catch: Exception -> L11
        if (r11 != null) goto L9;
        return false;
    L9:
        return r11.isConnected();
    L11:
        return false;
    }

    public static String c(String r5) {
        if (r5 != null) goto L11;
    L9:
        return null;
    L11:
        if (r5.length() == 0) goto L9;
        MessageDigest r10 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L10
        r10.update(r5.getBytes("UTF-8"));     // Catch: Exception -> L10
        return a(r10.digest());
    }

    public static void a(Closeable... r5) {
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L12;
        Closeable r12 = r5[r11];
        if (r12 == null) goto L11;
        r12.close();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();
    L11:
        r11 = r11 + 1;
        goto L3
    }

    public static void a(Cursor... r5) {
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L12;
        Cursor r12 = r5[r11];
        if (r12 == null) goto L11;
        r12.close();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();
    L11:
        r11 = r11 + 1;
        goto L3
    }

    public static boolean b(Throwable r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if ((r5 instanceof BaseException) == false) goto L27;
        BaseException r10 = (BaseException) r5;
        int r11 = r10.f15601a;
        if (r11 != 1006) goto L11;
        return true;
    L11:
        if (r11 != 1023) goto L13;
    L20:
        String r12 = r10.getMessage();
        if (TextUtils.isEmpty(r12) == false) goto L23;
    L25:
        return false;
    L23:
        if (r12.contains("ENOSPC") == false) goto L25;
        return true;
    L13:
        if (r11 == 1039) goto L20;
        if (r11 == 1040) goto L20;
        if (r11 == 1054) goto L20;
        if (r11 == 1064) goto L20;
    L33:
        return false;
    L27:
        if ((r5 instanceof IOException) == false) goto L33;
        String r13 = a(r5);
        if (TextUtils.isEmpty(r13) == true) goto L33;
        if (r13.contains("ENOSPC") == false) goto L33;
        return true;
    }

    public static boolean c(Context r5) {
        ConnectivityManager r10 = f16143b;     // Catch: Exception -> L16
        if (r10 != null) goto L6;
        r10 = (ConnectivityManager) r5.getSystemService("connectivity");     // Catch: Exception -> L16
        f16143b = r10;     // Catch: Exception -> L16
    L6:
        NetworkInfo r11 = r10.getActiveNetworkInfo();     // Catch: Exception -> L16
        if (r11 == null) goto L15;
        if (r11.isAvailable() == false) goto L15;
        if (1 != r11.getType()) goto L15;
        return true;
    L15:
        return false;
    }

    public static String a(Throwable r5) {
        if (r5 != null) goto L10;
        return "";
    L10:
        return r5.toString();
    L7:
        th = move-exception;
        th.printStackTrace();
        return "throwable getMsg error";
    }

    public static boolean c(Throwable r5) {
        if (r5 != null) goto L5;
    L60:
        return false;
    L5:
        if ((r5 instanceof BaseException) == false) goto L60;
        int r10 = ((BaseException) r5).f15601a;
        if (r10 < 2000) goto L13;
        if (r10 >= 3000) goto L13;
        return true;
    L13:
        if (r10 != 1075) goto L15;
    L59:
        return true;
    L15:
        if (r10 == 1078) goto L59;
        if (r10 == 1079) goto L59;
        if (r10 == 1055) goto L59;
        if (r10 == 1023) goto L59;
        if (r10 == 1041) goto L59;
        if (r10 == 1022) goto L59;
        if (r10 == 1048) goto L59;
        if (r10 == 1056) goto L59;
        if (r10 == 1057) goto L59;
        if (r10 == 1058) goto L59;
        if (r10 == 1059) goto L59;
        if (r10 == 1060) goto L59;
        if (r10 == 1061) goto L59;
        if (r10 == 1067) goto L59;
        if (r10 == 1049) goto L59;
        if (r10 == 1047) goto L59;
        if (r10 == 1051) goto L59;
        if (r10 == 1004) goto L59;
        if (r10 == 1011) goto L59;
        if (r10 == 1002) goto L59;
        if (r10 == 1013) goto L59;
        return false;
    }

    public static String a(byte[] r10) {
        if (r10 == null) goto L13;
        int r5 = r10.length;
        if (r5 > r10.length) goto L11;
        int r11 = r5 * 2;
        char[] r12 = new char[r11];
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r5) goto L9;
        byte r15 = r10[r13];
        int r16 = r15 & UByte.MAX_VALUE;
        int r17 = r14 + 1;
        char[] r18 = f16142a;
        r12[r14] = r18[r16 >> 4];
        r14 = r14 + 2;
        r12[r17] = r18[r15 & 15];
        r13 = r13 + 1;
        goto L6
    L9:
        return new String(r12, 0, r11);
    L11:
        throw new IndexOutOfBoundsException();
    L13:
        throw new NullPointerException("bytes is null");
    }

    public static long b(String r5) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            boolean r0 = com.ss.android.socialbase.downloader.file.DownloadFileUtils.e(r2)     // Catch: java.lang.Throwable -> L18 java.lang.IllegalArgumentException -> L1a
            if (r0 == 0) goto L1c
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L18 java.lang.IllegalArgumentException -> L1a
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch: java.lang.Throwable -> L18 java.lang.IllegalArgumentException -> L1a
            java.lang.String r2 = com.ss.android.socialbase.downloader.file.DownloadFileUtils.a(r2)     // Catch: java.lang.Throwable -> L18 java.lang.IllegalArgumentException -> L1a
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L18 java.lang.IllegalArgumentException -> L1a
            java.lang.String r2 = r0.getParent()     // Catch: java.lang.Throwable -> L18 java.lang.IllegalArgumentException -> L1a
            goto L1c
        L18:
            r2 = move-exception
            goto L26
        L1a:
            r2 = move-exception
            goto L32
        L1c:
            android.os.StatFs r0 = new android.os.StatFs     // Catch: java.lang.Throwable -> L18 java.lang.IllegalArgumentException -> L1a
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L18 java.lang.IllegalArgumentException -> L1a
            long r0 = r0.getAvailableBytes()     // Catch: java.lang.Throwable -> L18 java.lang.IllegalArgumentException -> L1a
            return r0
        L26:
            com.ss.android.socialbase.downloader.exception.BaseException r0 = new com.ss.android.socialbase.downloader.exception.BaseException
            r1 = 1052(0x41c, float:1.474E-42)
            java.lang.String r2 = a(r2)
            r0.<init>(r1, r2)
            throw r0
        L32:
            com.ss.android.socialbase.downloader.exception.BaseException r0 = new com.ss.android.socialbase.downloader.exception.BaseException
            r1 = 1050(0x41a, float:1.471E-42)
            java.lang.String r2 = a(r2)
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.utils.DownloadUtils.b(java.lang.String):long");
    }

    public static int a(DownloadFile r5, String r10) {
        if (r5.o() == true) goto L5;
        return TTMd5.a(r10, r5.l(), new DownloadFileRandomAccess(r5.c()));
    L8:
        th = move-exception;
        th.printStackTrace();
        return 5;
    L5:
        return TTMd5.a(r10, r5.l(), null);
    }

    public static void b(String r5, String r10) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L16;
        DownloadFile r11 = new DownloadFile(r5, r10, true);
        if (r11.f() == true) goto L10;
        return;
    L10:
        if (Logger.b() == false) goto L12;
        Logger.b("DownloadUtils", "deleteFile", "Path: " + r11.e());
    L12:
        r11.m();
        return;
    }

    public static String a(int r5) {
        String r10 = j0.h(r5, "ttmd5 check code = ", ", ");
        if (r5 == 99) goto L21;
        switch(r5) {
            case 0: goto L19;
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            default: goto L5;
        };
    L5:
        return r10;
    L7:
        return h.b(r10, "get file md5 error");
    L9:
        return h.b(r10, "file not exist");
    L11:
        return h.b(r10, "ttmd5 tag parser error");
    L13:
        return h.b(r10, "ttmd5 version not support");
    L15:
        return h.b(r10, "md5 empty");
    L17:
        return h.b(r10, "md5 not match");
    L19:
        return h.b(r10, "md5 match");
    L21:
        return h.b(r10, "unknown error");
    }

    public static boolean b() {
        d.compareAndSet(-1, 0);
        if (d.get() <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static void b(DownloadInfo r5, boolean r10) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.f15828o == true) goto L7;
    L9:
        if (r10 == true) goto L27;
    L13:
        a(r5.q(), r5.p());     // Catch: Throwable -> L11
        r5.d();     // Catch: Throwable -> L11
        if (r5.T0.optBoolean("is_save_path_redirected", false) == false) goto L16;
        a(r5);     // Catch: Throwable -> L11
    L16:
        if (r10 == false) goto L29;
        String r11 = c(r5.d);     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r11) == false) goto L20;
        return;
    L20:
        if (TextUtils.isEmpty(r5.e) == false) goto L22;
        return;
    L22:
        if (r5.e.contains(r11) == false) goto L32;
        a(r5.e);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L32:
        return;
    L29:
        return;
    L27:
        a(r5.e, r5.f15808b);     // Catch: Throwable -> L11
        goto L13
    L7:
        if (DownloadDirUtils.a(r5.e) == true) goto L9;
        r10 = false;
        goto L9
    }

    public static String a(Context r10) {
        String r5 = f16144c;
        if (TextUtils.isEmpty(r5) == true) goto L5;
        return r5;
    L5:
        String r11 = null;
        String r12 = Application.getProcessName();     // Catch: Exception -> L12
        if (Logger.b() == true) goto L9;
    L14:
        f16144c = r12;
        if (TextUtils.isEmpty(r12) == false) goto L17;
        Method r13 = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);     // Catch: Throwable -> L29
        r13.setAccessible(true);     // Catch: Throwable -> L29
        Object r14 = r13.invoke(null, null);     // Catch: Throwable -> L29
        if ((r14 instanceof String) == false) goto L31;
        String r15 = (String) r14;     // Catch: Throwable -> L29
    L27:
        th = th;
    L32:
        th.printStackTrace();
    L33:
        f16144c = r15;
        if (TextUtils.isEmpty(r15) == true) goto L78;
        return f16144c;
    L78:
        BufferedReader r16 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L48
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L73
    L40:
        int r18 = r16.read();     // Catch: Throwable -> L73
        if (r18 <= 0) goto L44;
        r17.append((char) r18);     // Catch: Throwable -> L73
        goto L40
    L44:
        if (Logger.b() == false) goto L46;
        Logger.b("DownloadUtils", "getCurProcessNameFromProc", "ProcessName: " + r17.toString());     // Catch: Throwable -> L73
    L46:
        String r19 = r17.toString();     // Catch: Throwable -> L73
        a(new Closeable[]{r16});
    L50:
        f16144c = r19;
        if (TextUtils.isEmpty(r19) == false) goto L53;
        if (r10 != null) goto L74;
    L71:
        f16144c = r11;
        return r11;
    L74:
        int r20 = Process.myPid();     // Catch: Exception -> L66
        ActivityManager r110 = (ActivityManager) r10.getSystemService("activity");     // Catch: Exception -> L66
        if (r110 == null) goto L71;
        Iterator<ActivityManager.RunningAppProcessInfo> r111 = r110.getRunningAppProcesses().iterator();     // Catch: Exception -> L66
    L60:
        if (r111.hasNext() == false) goto L71;
        ActivityManager.RunningAppProcessInfo r21 = r111.next();     // Catch: Exception -> L66
        if (r21.pid != r20) goto L60;
        if (Logger.b() == false) goto L68;
        Logger.b("DownloadUtils", "getCurProcessNameByActivityManager", "ProcessName: " + r21.processName);     // Catch: Exception -> L66
    L68:
        r11 = r21.processName;     // Catch: Exception -> L66
    L66:
        e = move-exception;
        e.printStackTrace();
        goto L71
    L53:
        return f16144c;
    L49:
        a(new Closeable[]{r16});
        r19 = null;
    L48:
        r16 = null;
        goto L49
    L22:
        if (Logger.b() == false) goto L33;
        if (TextUtils.isEmpty(r15) == true) goto L33;
        Logger.b("DownloadUtils", "getCurProcessNameByActivityThread", "ProcessName: " + r15);     // Catch: Throwable -> L27
        goto L33
    L31:
        r15 = null;
    L29:
        th = th;
        r15 = null;
        goto L32
    L17:
        return f16144c;
    L9:
        if (TextUtils.isEmpty(r12) == true) goto L14;
        Logger.b("DownloadUtils", "getCurProcessNameByApplication", "ProcessName: " + r12);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        r12 = null;
        goto L14
    }

    public static boolean a() {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L6;
        return true;
    L6:
        return false;
    }

    public static long a(IDownloadHeadHttpConnection r5) {
        if (r5 != null) goto L5;
        return -1;
    L5:
        String r10 = a(r5, "Content-Length");
        if (TextUtils.isEmpty(r10) == false) goto L20;
        String r11 = a(r5, "Content-Range");
        if (TextUtils.isEmpty(r11) == true) goto L26;
        Matcher r12 = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(r11);     // Catch: Exception -> L14
        if (r12.find() == false) goto L24;
        return (Long.parseLong(r12.group(2)) - Long.parseLong(r12.group(1))) + 1;
    L24:
        return -1;
    L14:
        e = move-exception;
        Logger.c("DownloadUtils", "parseContentLengthFromContentRange", "Exception:" + e);
        return -1;
    L26:
        return -1;
    L20:
        return Long.parseLong(r10);
    L27:
        return -1;
    }

    public static String a(IDownloadHeadHttpConnection r5, String r10) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L16;
        String r11 = r5.a(r10);
        if (TextUtils.isEmpty(r11) == false) goto L10;
        r11 = r5.a(r10.toLowerCase());
    L10:
        if (TextUtils.isEmpty(r11) == true) goto L12;
        return r11;
    L12:
        return r5.a(r10.toUpperCase());
    L16:
        return null;
    }

    public static boolean a(DownloadInfo r10, boolean r11, String r12) {
        if (r11 == false) goto L5;
    L24:
        return false;
    L5:
        if (TextUtils.isEmpty(r10.e) == true) goto L24;
        if (TextUtils.isEmpty(r10.f15808b) == true) goto L24;
        DownloadFile r13 = new DownloadFile(r10.e, r10.f15808b, true);     // Catch: OutOfMemoryError -> L16
        if (DownloadFileUtils.a(r13) == false) goto L24;
        if (r10.f15817h0 > 0) goto L14;
    L18:
        int r14 = a(r13, r12);     // Catch: OutOfMemoryError -> L16
        if (r14 != 0) goto L21;
    L22:
        return true;
    L21:
        if (r14 != 2) goto L24;
    L14:
        if (r13.length() >= r10.f15817h0) goto L18;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public static void a(String r5) {
        if (Logger.b() == false) goto L6;
        Logger.b("DownloadUtils", "deleteDirIfEmpty", "Thread:" + Thread.currentThread());
    L6:
        if (DownloadFileUtils.b(r5) == 1) goto L8;
        return;
    L8:
        if (DownloadDirUtils.a(r5) == true) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r5) == true) goto L21;
        File r10 = new File(r5);
        if (r10.isDirectory() == true) goto L15;
        return;
    L15:
        if (r10.delete() == false) goto L17;
        return;
    L17:
        if (Logger.b() == false) goto L24;
        Logger.b("DownloadUtils", "deleteDirIfEmpty", "Delete Failed");
        return;
    L24:
        return;
    }

    public static void a(String r5, String r10) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L14;
        DownloadFile r11 = new DownloadFile(r5, r10, false);
        if (r11.f() == true) goto L9;
        return;
    L9:
        if (Logger.b() == false) goto L11;
        Logger.b("DownloadUtils", "deleteFile", "Path: " + r11.e());
    L11:
        r11.m();
        return;
    }

    public static void a(DownloadInfo r5) {
        if (r5 == null) goto L55;
        DownloadSetting r10 = DownloadSetting.a(r5.l(), null);
        JSONObject r11 = r10.d("download_dir");
        if (r11 == null) goto L45;
        String r12 = r11.optString("ins_desc");
        if (TextUtils.isEmpty(r12) == true) goto L10;
        a(r5.e, r12);
    L10:
        if (TextUtils.isEmpty(r5.f15810c) == false) goto L12;
        String r13 = r5.f15808b;
    L14:
        if (TextUtils.isEmpty(r13) == false) goto L16;
        r13 = r5.f15808b;
    L16:
        JSONObject r14 = r10.d("download_dir");
        if (r14 == null) goto L32;
        String r15 = r14.optString("dir_name");
        if (TextUtils.isEmpty(r15) == true) goto L24;
        if (r15.startsWith("/") == false) goto L24;
        r15 = r15.substring(1);
    L24:
        if (TextUtils.isEmpty(r15) == false) goto L26;
    L33:
        String r16 = r5.e;
        if (TextUtils.isEmpty(r15) == false) goto L36;
        return;
    L36:
        if (TextUtils.isEmpty(r16) == true) goto L54;
        File r17 = new File(r15);
        File r18 = new File(r16);
    L38:
        if (r17 == null) goto L56;
        if (r18 == null) goto L57;
        if (r18.isDirectory() == false) goto L58;
        if (TextUtils.equals(r17.getName(), r18.getName()) == false) goto L59;
        a(r18.getPath());
        r17 = r17.getParentFile();
        r18 = r18.getParentFile();
        goto L38
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L56:
        return;
    L54:
        return;
    L26:
        if (r15.contains("%s") == true) goto L47;
        r15 = h.b(r15, r13);
    L30:
        if (r15.length() <= 255) goto L33;
        r15 = r15.substring(r15.length() - 255);
        goto L33
    L47:
        r15 = String.format(r15, new Object[]{r13});     // Catch: Throwable -> L46
        goto L30
    L32:
        r15 = "";
        goto L33
    L12:
        r13 = r5.f15810c;
        goto L14
    L45:
        return;
    }

    public static String a(ArrayList r5) {
        if (r5 != null) goto L5;
    L18:
        return "";
    L5:
        if (r5.isEmpty() == true) goto L18;
        JSONArray r10 = new JSONArray();     // Catch: Exception -> L13
        Iterator r11 = r5.iterator();     // Catch: Exception -> L13
    L9:
        if (r11.hasNext() == false) goto L15;
        String r12 = (String) r11.next();     // Catch: Exception -> L13
        if (TextUtils.isEmpty(r12) == true) goto L9;
        r10.put(r12);     // Catch: Exception -> L13
        goto L9
    L15:
        return r10.toString();
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    public static boolean a(DownloadInfo r11, boolean r12) {
        boolean r5 = false;
        if (r11.T == true) goto L10;
        if (TextUtils.isEmpty(r11.m()) == false) goto L10;
        if (Logger.a(r11) == false) goto L18;
        Logger.a("DownloadUtils", r11.l(), r11.P, "cacheExpiredWithHttp", "Modify is empty, so just return cache", false);
    L18:
        if (Logger.a(r11) == false) goto L20;
        Logger.a("DownloadUtils", r11.l(), r11.P, "cacheExpiredWithHttp", "Name=" + r11.f15808b + " expired=" + r5, false);
    L20:
        return r5;
    L10:
        if (Logger.a(r11) == false) goto L13;
        Logger.a("DownloadUtils", r11.l(), r11.P, "cacheExpiredWithHttp", "Curt=" + System.currentTimeMillis() + " expired=" + r11.g(), false);
    L13:
        if (System.currentTimeMillis() > r11.g()) goto L16;
        if (r12 == false) goto L18;
    L16:
        r5 = true;
        goto L18
    }
}
