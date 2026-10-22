package com.ss.android.socialbase.downloader.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.rpc.internal.RpcUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.service.k;
import com.ss.android.socialbase.downloader.service.l;
import com.ss.android.ttmd5.TTMd5;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15658a = "g";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f15659b = null;
    private static ConnectivityManager c;
    private static String d;

    static {
        f15659b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        d = null;
    }

    public g() {
    }

    public static int a(com.ss.android.socialbase.downloader.d.a r2, String r3) {
        if (r2.m() == true) goto L5;
        return TTMd5.checkMd5(r3, r2.f(), new b(r2.h()));
    L8:
        th = move-exception;
        th.printStackTrace();
        return 5;
    L5:
        return TTMd5.checkMd5(r3, r2.f());
    }

    public static long a(com.ss.android.socialbase.downloader.network.g r4) {
        com.ss.android.socialbase.downloader.network.g r5 = (com.ss.android.socialbase.downloader.network.g) ZeusTransformUtils.wrapperContextForParams(r4, com.ss.android.socialbase.downloader.network.g.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return -1;
    L5:
        String r2 = a(r5, "Content-Length");
        if (TextUtils.isEmpty(r2) == true) goto L13;
        return Long.parseLong(r2);
    L14:
        return -1;
    L13:
        return b(r5);
    }

    public static ConnectivityManager a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        ConnectivityManager r0 = c;
        if (r0 != null) goto L6;
        ConnectivityManager r1 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r3.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");
        c = r1;
        return r1;
    L6:
        return r0;
    }

    public static String a(com.ss.android.socialbase.downloader.network.g r2, String r3) {
        com.ss.android.socialbase.downloader.network.g r4 = (com.ss.android.socialbase.downloader.network.g) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.network.g.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L17;
        String r0 = r4.a(r3);
        if (TextUtils.isEmpty(r0) == false) goto L11;
        r0 = r4.a(r3.toLowerCase());
    L11:
        if (TextUtils.isEmpty(r0) == true) goto L13;
        return r0;
    L13:
        return r4.a(r3.toUpperCase());
    L17:
        return null;
    }

    public static String a(String r3) {
        if (r3 != null) goto L11;
    L9:
        return null;
    L11:
        if (r3.length() == 0) goto L9;
        MessageDigest r1 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Exception -> L10
        r1.update(r3.getBytes(RpcUtils.CHARSET_UTF8));     // Catch: Exception -> L10
        return a(r1.digest());
    }

    public static String a(String r2, com.ss.android.socialbase.downloader.g.a r3) {
        if (r3 == null) goto L21;
        JSONObject r4 = r3.e("download_dir");
        if (r4 == null) goto L21;
        String r5 = r4.optString("dir_name");
        if (TextUtils.isEmpty(r5) == true) goto L11;
        if (r5.startsWith("/") == false) goto L11;
        r5 = r5.substring(1);
    L11:
        if (TextUtils.isEmpty(r5) == false) goto L13;
        return r5;
    L13:
        if (r5.contains("%s") == true) goto L24;
        String r6 = r5 + r2;
    L15:
        r5 = r6;
    L19:
        if (r5.length() > 255) goto L28;
        return r5;
    L28:
        return r5.substring(r5.length() - 255);
    L24:
        r6 = String.format(r5, new Object[]{r2});     // Catch: Throwable -> L23
    L21:
        return "";
    }

    public static String a(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == true) goto L10;
        String r3 = a(r2);
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return r1;
    L7:
        if (r1.contains(r3) == false) goto L9;
        return r1;
    L9:
        return new File(r1, r3).getAbsolutePath();
    L10:
        return r1;
    }

    public static String a(String r2, String r3, String r4) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        if (TextUtils.isEmpty(r3) == false) goto L7;
    L8:
        return null;
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L8;
        if (TextUtils.isEmpty(r3) == true) goto L12;
        String r5 = b(r3, r4);
    L14:
        if (TextUtils.isEmpty(r5) == false) goto L17;
        return null;
    L17:
        return String.format("%s.tp", new Object[]{r5});
    L12:
        r5 = b(r2, r4);
        goto L14
    }

    public static String a(Throwable r0) {
        if (r0 != null) goto L10;
        return "";
    L10:
        return r0.toString();
    L7:
        th = move-exception;
        th.printStackTrace();
        return "throwable getMsg error";
    }

    public static String a(Throwable r1, String r2) {
        if (r2 != null) goto L6;
        return a(r1);
    L6:
        return r2 + "-" + a(r1);
    }

    public static String a(byte[] r2) {
        Objects.requireNonNull(r2, "bytes is null");
        return a(r2, 0, r2.length);
    }

    public static String a(byte[] r9, int r10, int r11) {
        Objects.requireNonNull(r9, "bytes is null");
        if (r10 < 0) goto L12;
        if ((r10 + r11) > r9.length) goto L12;
        int r0 = r11 * 2;
        char[] r1 = new char[r0];
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r3 >= r11) goto L10;
        int r5 = r9[r3 + r10] & 255;
        int r6 = r4 + 1;
        char[] r7 = f15659b;
        r1[r4] = r7[r5 >> 4];
        r4 = r6 + 1;
        r1[r6] = r7[r5 & 15];
        r3 = r3 + 1;
        goto L7
    L10:
        return new String(r1, 0, r0);
    L12:
        throw new IndexOutOfBoundsException();
    }

    public static void a(Cursor... r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L14;
        Cursor r2 = r3[r1];
        if (r2 == null) goto L13;
        r2.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
    L13:
        r1 = r1 + 1;
        goto L5
    }

    public static void a(Closeable... r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L14;
        Closeable r2 = r3[r1];
        if (r2 == null) goto L13;
        r2.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
    L13:
        r1 = r1 + 1;
        goto L5
    }

    public static boolean a() {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(int r1) {
        if (r1 != 0) goto L4;
    L7:
        return true;
    L4:
        if (r1 == 2) goto L7;
        return false;
    }

    public static boolean a(int r1, String r2, String r3) {
        if (r1 == (-3)) goto L5;
        return false;
    L5:
        if (d(r2, r3) == true) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean a(long r2) {
        if (r2 != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(DownloadInfo r2) {
        return a(r2, r2.isForce(), r2.getMd5());
    }

    public static boolean a(DownloadInfo r4, com.ss.android.socialbase.downloader.d.a r5) {
        if (r4.getTotalBytes() > 0) goto L5;
        return true;
    L5:
        if (r5.a() >= r4.getTotalBytes()) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean a(DownloadInfo r9, boolean r10) {
        boolean r1 = true;
        if (r9.isDeleteCacheIfCheckFailed() == true) goto L11;
        if (TextUtils.isEmpty(r9.getLastModified()) == false) goto L11;
        if (com.ss.android.socialbase.downloader.e.a.a(r9) == false) goto L9;
        com.ss.android.socialbase.downloader.e.a.a(f15658a, r9, "cacheExpiredWithHttp", "Modify is empty, so just return cache");
    L9:
        r1 = false;
    L18:
        if (com.ss.android.socialbase.downloader.e.a.a(r9) == false) goto L20;
        com.ss.android.socialbase.downloader.e.a.a(f15658a, r9, "cacheExpiredWithHttp", "Name=" + r9.getName() + " expired=" + r1);
    L20:
        return r1;
    L11:
        if (com.ss.android.socialbase.downloader.e.a.a(r9) == false) goto L14;
        com.ss.android.socialbase.downloader.e.a.a(f15658a, r9, "cacheExpiredWithHttp", "Curt=" + System.currentTimeMillis() + " expired=" + r9.getCacheExpiredTime());
    L14:
        if (System.currentTimeMillis() > r9.getCacheExpiredTime()) goto L18;
        if (r10 == false) goto L9;
        goto L9
    }

    public static boolean a(DownloadInfo r3, boolean r4, String r5) {
        if (r4 == false) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r3.getSavePath()) == true) goto L19;
        if (TextUtils.isEmpty(r3.getName()) == true) goto L19;
        com.ss.android.socialbase.downloader.d.a r6 = new com.ss.android.socialbase.downloader.d.a(r3.getSavePath(), r3.getName());     // Catch: OutOfMemoryError -> L17
        if (com.ss.android.socialbase.downloader.d.b.a(r6) == false) goto L19;
        if (a(r3, r6) == false) goto L19;
        if (b(r6, r5) == false) goto L19;
        return true;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public static boolean a(List<HttpHeader> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return false;
    L5:
        if (r6.size() == 0) goto L36;
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L37;
        HttpHeader r2 = (HttpHeader) ZeusTransformUtils.preCheckCast(r7.next(), HttpHeader.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        if (TextUtils.isEmpty(r2.getName()) == true) goto L9;
        if (TextUtils.isEmpty(r2.getValue()) == true) goto L9;
        if ("download-tc21-1-15".equals(r2.getName()) == false) goto L9;
        if ("download-tc21-1-15".equals(r2.getValue()) == false) goto L9;
        return true;
    L37:
        return false;
    L36:
        return false;
    }

    public static long b(long r2) {
        long r0 = 50;
        return ((r2 / 1048576) / r0) * r0;
    }

    public static long b(com.ss.android.socialbase.downloader.network.g r5) {
        com.ss.android.socialbase.downloader.network.g r6 = (com.ss.android.socialbase.downloader.network.g) ZeusTransformUtils.wrapperContextForParams(r5, com.ss.android.socialbase.downloader.network.g.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return -1;
    L5:
        String r7 = a(r6, "Content-Range");
        if (TextUtils.isEmpty(r7) == false) goto L16;
        return -1;
    L16:
        Matcher r8 = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(r7);     // Catch: Exception -> L13
        if (r8.find() == false) goto L15;
        return (Long.parseLong(r8.group(2)) - Long.parseLong(r8.group(1))) + 1;
    L15:
        return -1;
    L13:
        e = move-exception;
        com.ss.android.socialbase.downloader.e.a.b(f15658a, "parseContentLengthFromContentRange", "Exception:" + e);
        goto L15
    }

    private static String b() {
        BufferedReader r3 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L14
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L17
    L5:
        int r5 = r3.read();     // Catch: Throwable -> L17
        if (r5 <= 0) goto L9;
        r4.append((char) r5);     // Catch: Throwable -> L17
        goto L5
    L9:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L11;
        com.ss.android.socialbase.downloader.e.a.a(f15658a, "getCurProcessNameFromProc", "ProcessName: " + r4.toString());     // Catch: Throwable -> L17
    L11:
        String r2 = r4.toString();     // Catch: Throwable -> L17
        a(new Closeable[]{r3});
        return r2;
    L15:
        a(new Closeable[]{r3});
        return null;
    L14:
        r3 = null;
        goto L15
    }

    public static String b(int r2) {
        String r0 = "ttmd5 check code = " + r2 + ", ";
        if (r2 == 99) goto L14;
        switch(r2) {
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L16;
        };
    L6:
        StringBuilder r3 = new StringBuilder().append(r0);
        String r1 = "get file md5 error";
    L15:
        return r3.append(r1).toString();
    L7:
        r3 = new StringBuilder().append(r0);
        r1 = "file not exist";
        goto L15
    L8:
        r3 = new StringBuilder().append(r0);
        r1 = "ttmd5 tag parser error";
        goto L15
    L9:
        r3 = new StringBuilder().append(r0);
        r1 = "ttmd5 version not support";
        goto L15
    L10:
        r3 = new StringBuilder().append(r0);
        r1 = "md5 empty";
        goto L15
    L11:
        r3 = new StringBuilder().append(r0);
        r1 = "md5 not match";
        goto L15
    L12:
        r3 = new StringBuilder().append(r0);
        r1 = "md5 match";
        goto L15
    L16:
        return r0;
    L14:
        r3 = new StringBuilder().append(r0);
        r1 = "unknown error";
        goto L15
    }

    public static String b(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        return String.format("%s.tp", new Object[]{r2});
    }

    public static String b(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L14:
        return null;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L14;
        if (com.ss.android.socialbase.downloader.d.b.a(r2) == false) goto L13;
        if (com.ss.android.socialbase.downloader.d.b.e(r2) == true) goto L13;
        return null;
    L13:
        return new com.ss.android.socialbase.downloader.d.a(r2, r3).d();
    }

    public static String b(List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L17:
        return "";
    L5:
        if (r6.isEmpty() == true) goto L17;
        JSONArray r2 = new JSONArray();     // Catch: Exception -> L15
        Iterator r7 = r6.iterator();     // Catch: Exception -> L15
    L9:
        if (r7.hasNext() == false) goto L13;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r3) == true) goto L9;
        r2.put(r3);     // Catch: Exception -> L15
        goto L9
    L13:
        return r2.toString();
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static void b(DownloadInfo r2, boolean r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.isForce() == true) goto L7;
    L9:
        if (r3 == true) goto L26;
    L11:
        e(r2.getTempPath(), r2.getTempName());     // Catch: Throwable -> L23
        if (r2.isSavePathRedirected() == false) goto L14;
        d(r2);     // Catch: Throwable -> L23
    L14:
        if (r3 == false) goto L28;
        String r4 = a(r2.getUrl());     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r4) == false) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty(r2.getSavePath()) == false) goto L20;
        return;
    L20:
        if (r2.getSavePath().contains(r4) == false) goto L31;
        h(r2.getSavePath());     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        th.printStackTrace();
        return;
    L31:
        return;
    L28:
        return;
    L26:
        e(r2.getSavePath(), r2.getName());     // Catch: Throwable -> L23
        goto L11
    L7:
        if (a.a(r2.getSavePath()) == true) goto L9;
        r3 = false;
        goto L9
    }

    public static boolean b(Context r2) {
        NetworkInfo r3 = a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.isAvailable() == false) goto L17;
        if (1 == r3.getType()) goto L12;
        return false;
    L12:
        return true;
    L17:
        return false;
    L19:
        return false;
    }

    public static boolean b(com.ss.android.socialbase.downloader.d.a r0, String r1) {
        return a(a(r0, r1));
    }

    public static boolean b(DownloadInfo r1) {
        return a(r1, false);
    }

    public static boolean b(String r1, String r2, String r3) {
        return a(a(new com.ss.android.socialbase.downloader.d.a(r1, r2), r3));
    }

    public static boolean b(Throwable r3) {
        if (r3 != null) goto L5;
    L60:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, BaseException.class) == false) goto L60;
        int r4 = ((BaseException) ZeusTransformUtils.preCheckCast(r3, BaseException.class, "com.obric.memorydata.plugin")).getErrorCode();
        if (r4 < 2000) goto L13;
        if (r4 >= 3000) goto L13;
        return true;
    L13:
        if (r4 != 1075) goto L15;
    L59:
        return true;
    L15:
        if (r4 == 1078) goto L59;
        if (r4 == 1079) goto L59;
        if (r4 == 1055) goto L59;
        if (r4 == 1023) goto L59;
        if (r4 == 1041) goto L59;
        if (r4 == 1022) goto L59;
        if (r4 == 1048) goto L59;
        if (r4 == 1056) goto L59;
        if (r4 == 1057) goto L59;
        if (r4 == 1058) goto L59;
        if (r4 == 1059) goto L59;
        if (r4 == 1060) goto L59;
        if (r4 == 1061) goto L59;
        if (r4 == 1067) goto L59;
        if (r4 == 1049) goto L59;
        if (r4 == 1047) goto L59;
        if (r4 == 1051) goto L59;
        if (r4 == 1004) goto L59;
        if (r4 == 1011) goto L59;
        if (r4 == 1002) goto L59;
        if (r4 == 1013) goto L59;
        return false;
    }

    public static long c(String r5) {
        StatFs r0 = new StatFs(r5);     // Catch: Throwable -> L8 IllegalArgumentException -> L11
        if (Build.VERSION.SDK_INT < 18) goto L7;
        return r0.getAvailableBytes();
    L7:
        return r0.getAvailableBlocks() * ((long) r0.getBlockSize());
    L11:
        e = move-exception;
        throw new BaseException(1050, e);
    L8:
        th = move-exception;
        throw new BaseException(1052, th);
    }

    private static String c() {
        if (Build.VERSION.SDK_INT < 28) goto L16;
        String r0 = Application.getProcessName();     // Catch: Exception -> L10
        if (com.ss.android.socialbase.downloader.e.a.a() == true) goto L7;
    L9:
        return r0;
    L7:
        if (TextUtils.isEmpty(r0) == true) goto L9;
        com.ss.android.socialbase.downloader.e.a.a(f15658a, "getCurProcessNameByApplication", "ProcessName: " + r0);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    L16:
        return null;
    }

    public static String c(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == false) goto L9;
        if (TextUtils.isEmpty(r2) == false) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(r2) == false) goto L11;
        return r1;
    L11:
        return r2;
    }

    public static void c(DownloadInfo r1) {
        b(r1, true);
    }

    public static void c(String r2, String r3, String r4) {
        String r0 = String.format("%s.tp", new Object[]{r4});
        f(r2, r4);
        if (r3 == null) goto L6;
        r2 = r3;
    L6:
        f(r2, r0);
    }

    public static boolean c(Context r2) {
        NetworkInfo r3 = a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L8
        if (r3 != null) goto L6;
        return false;
    L6:
        return r3.isConnected();
    L8:
        return false;
    }

    public static boolean c(Throwable r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BaseException.class) == false) goto L31;
        BaseException r6 = (BaseException) ZeusTransformUtils.preCheckCast(r5, BaseException.class, "com.obric.memorydata.plugin");
        int r1 = r6.getErrorCode();
        if (r1 != 1006) goto L11;
        return true;
    L11:
        if (r1 != 1023) goto L13;
    L22:
        boolean r2 = true;
    L23:
        if (r2 == false) goto L40;
        String r7 = r6.getMessage();
        if (TextUtils.isEmpty(r7) == false) goto L27;
        return false;
    L27:
        if (r7.contains("ENOSPC") == true) goto L29;
        return false;
    L29:
        return true;
    L40:
        return false;
    L13:
        if (r1 == 1039) goto L22;
        if (r1 == 1040) goto L22;
        if (r1 == 1054) goto L22;
        if (r1 == 1064) goto L22;
        r2 = false;
        goto L23
    L31:
        if (ZeusTransformUtils.instanceOf(r5, IOException.class) == false) goto L41;
        String r8 = a(r5);
        if (TextUtils.isEmpty(r8) == false) goto L35;
        return false;
    L35:
        if (r8.contains("ENOSPC") == true) goto L37;
        return false;
    L37:
        return true;
    L41:
        return false;
    }

    public static int d(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L21;
        return 0;
    L21:
        ConnectivityManager r4 = a(r3);     // Catch: Exception -> L20
        if (r4 != null) goto L8;
        return 0;
    L8:
        NetworkInfo r5 = r4.getActiveNetworkInfo();     // Catch: Exception -> L20
        if (r5 == null) goto L19;
        if (r5.isAvailable() == false) goto L19;
        if (1 != r5.getType()) goto L17;
        return 1;
    L17:
        return 2;
    L19:
        return 0;
    }

    private static String d() {
        Method r2 = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", (Class[]) ZeusTransformUtils.preCheckCast(new Class[0], Class[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        r2.setAccessible(true);     // Catch: Throwable -> L14
        Object r3 = r2.invoke(null, new Object[0]);     // Catch: Throwable -> L14
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L23;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
    L12:
        Throwable th = th;
    L16:
        th.printStackTrace();
    L18:
        return r0;
    L7:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L18;
        if (TextUtils.isEmpty(r0) == true) goto L18;
        com.ss.android.socialbase.downloader.e.a.a(f15658a, "getCurProcessNameByActivityThread", "ProcessName: " + r0);     // Catch: Throwable -> L12
        goto L18
    L23:
        return null;
    L14:
        th = move-exception;
        th = th;
        r0 = null;
        goto L16
    }

    public static String d(String r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L13;
        char r4 = r6.charAt(r3);
        if (r4 > 31) goto L7;
    L10:
        r0.append(String.format("\\u%04x", new Object[]{Integer.valueOf(r4)}));
    L11:
        r3 = r3 + 1;
        goto L3
    L7:
        if (r4 >= 127) goto L10;
        r0.append(r4);
        goto L11
    L13:
        return r0.toString();
    }

    public static void d(DownloadInfo r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        com.ss.android.socialbase.downloader.g.a r0 = com.ss.android.socialbase.downloader.g.a.a(r3.getId());
        JSONObject r1 = r0.e("download_dir");
        if (r1 == null) goto L24;
        String r2 = r1.optString("ins_desc");
        if (TextUtils.isEmpty(r2) == true) goto L9;
        e(r3.getSavePath(), r2);
    L9:
        String r4 = r3.getTitle();
        if (TextUtils.isEmpty(r4) == false) goto L12;
        r4 = r3.getName();
    L12:
        String r5 = a(r4, r0);
        String r6 = r3.getSavePath();
        if (TextUtils.isEmpty(r5) == false) goto L15;
        return;
    L15:
        if (TextUtils.isEmpty(r6) == true) goto L30;
        File r7 = new File(r5);
        File r8 = new File(r6);
    L17:
        if (r7 == null) goto L31;
        if (r8 == null) goto L32;
        if (r8.isDirectory() == false) goto L33;
        if (TextUtils.equals(r7.getName(), r8.getName()) == false) goto L34;
        h(r8.getPath());
        r7 = r7.getParentFile();
        r8 = r8.getParentFile();
        goto L17
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    }

    public static boolean d(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L14;
        if (com.ss.android.socialbase.downloader.d.b.a(r2) == false) goto L13;
        if (com.ss.android.socialbase.downloader.d.b.e(r2) == true) goto L13;
        return false;
    L13:
        return new com.ss.android.socialbase.downloader.d.a(r2, r3).b();
    }

    public static boolean d(Throwable r3) {
        if (((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).h().a(r3) != 304) goto L5;
        return true;
    L5:
        return false;
    }

    public static String e(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        String r0 = d;
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        String r1 = c();
        d = r1;
        if (TextUtils.isEmpty(r1) == false) goto L8;
        String r4 = d();
        d = r4;
        if (TextUtils.isEmpty(r4) == false) goto L12;
        String r5 = b();
        d = r5;
        if (TextUtils.isEmpty(r5) == false) goto L16;
        String r6 = f(r3);
        d = r6;
        return r6;
    L16:
        return d;
    L12:
        return d;
    L8:
        return d;
    }

    public static String e(String r4) {
    L8:
        e = move-exception;
        e.printStackTrace();
        return "";
    L3:
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return "";
    L5:
        if (TextUtils.isDigitsOnly(r4) == false) goto L15;
        return String.valueOf(Long.valueOf(r4).longValue() % 100);
    L15:
        return "";
    }

    public static void e(String r3, String r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L14;
        com.ss.android.socialbase.downloader.d.a r0 = new com.ss.android.socialbase.downloader.d.a(r3, r4, false, true);
        if (r0.b() == true) goto L9;
        return;
    L9:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L11;
        com.ss.android.socialbase.downloader.e.a.a(f15658a, "deleteFile", "Path: " + r0.k());
    L11:
        r0.delete();
        return;
    }

    private static String f(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L20;
        return null;
    L20:
        int r2 = Process.myPid();     // Catch: Exception -> L17
        ActivityManager r7 = (ActivityManager) ZeusTransformUtils.preCheckCast(r6.getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L17
        if (r7 == null) goto L19;
        Iterator<ActivityManager.RunningAppProcessInfo> r8 = r7.getRunningAppProcesses().iterator();     // Catch: Exception -> L17
    L9:
        if (r8.hasNext() == false) goto L19;
        ActivityManager.RunningAppProcessInfo r3 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r8.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L17
        if (r3.pid != r2) goto L9;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L15;
        com.ss.android.socialbase.downloader.e.a.a(f15658a, "getCurProcessNameByActivityManager", "ProcessName: " + r3.processName);     // Catch: Exception -> L17
    L15:
        return r3.processName;
    L19:
        return null;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public static List<String> f(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L19;
        return null;
    L19:
        JSONArray r0 = new JSONArray(r5);     // Catch: Exception -> L16
        if (r0.length() > 0) goto L8;
        return null;
    L8:
        ArrayList r6 = new ArrayList();     // Catch: Exception -> L16
        int r2 = 0;
    L10:
        if (r2 >= r0.length()) goto L15;
        String r3 = r0.optString(r2);     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r3) == true) goto L14;
        r6.add(r3);     // Catch: Exception -> L16
    L14:
        r2 = r2 + 1;
        goto L10
    L15:
        return r6;
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static void f(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L16;
        com.ss.android.socialbase.downloader.d.a r0 = new com.ss.android.socialbase.downloader.d.a(r2, r3, true, true);
        if (r0.b() == true) goto L10;
        return;
    L10:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L12;
        com.ss.android.socialbase.downloader.e.a.a(f15658a, "deleteFile", "Path: " + r0.k());
    L12:
        r0.delete();
        return;
    }

    public static String g(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return "";
    L5:
        int r0 = r2.lastIndexOf(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        if (r0 > 0) goto L9;
        return "";
    L9:
        return r2.substring(0, r0);
    }

    private static boolean h(String r4) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a(f15658a, "deleteDirIfEmpty", "Thread:" + Thread.currentThread());
    L6:
        if (com.ss.android.socialbase.downloader.d.b.c(r4) == 1) goto L8;
    L21:
        return false;
    L8:
        if (a.a(r4) == false) goto L21;
        if (TextUtils.isEmpty(r4) == true) goto L21;
        File r0 = new File(r4);
        if (r0.isDirectory() == false) goto L21;
        if (r0.delete() == false) goto L17;
        return true;
    L17:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L19;
        com.ss.android.socialbase.downloader.e.a.a(f15658a, "deleteDirIfEmpty", "Delete Failed");
    L19:
        return false;
    }
}
