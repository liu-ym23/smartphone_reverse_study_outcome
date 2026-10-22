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
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
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
import org.json.JSONArray;
import org.json.JSONObject;
import qb.k;
import qb.l;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8343a = "g";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f8344b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ConnectivityManager f8345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f8346d;

    static {
        f8344b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f8346d = null;
    }

    public static long A(long r10) {
        long r11 = 50;
        return ((r10 / 1048576) / r11) * r11;
    }

    public static String B(nb.g r10, String r11) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r11) == true) goto L16;
        String r12 = r10.d(r11);
        if (TextUtils.isEmpty(r12) == false) goto L10;
        r12 = r10.d(r11.toLowerCase());
    L10:
        if (TextUtils.isEmpty(r12) == true) goto L12;
        return r12;
    L12:
        return r10.d(r11.toUpperCase());
    L16:
        return null;
    }

    public static String C(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L14:
        return null;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L14;
        if (kb.b.p(r10) == false) goto L13;
        if (kb.b.b(r10) == true) goto L13;
        return null;
    L13:
        return new kb.a(r10, r11).getPath();
    }

    public static String D(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return null;
    L7:
        return String.format("%s.tp", new Object[]{r10});
    }

    public static String E(String r10, String r11, String r12) {
        if (TextUtils.isEmpty(r10) == false) goto L7;
        if (TextUtils.isEmpty(r11) == false) goto L7;
    L8:
        return null;
    L7:
        if (TextUtils.isEmpty(r12) == true) goto L8;
        if (TextUtils.isEmpty(r11) == true) goto L12;
        String r13 = C(r11, r12);
    L14:
        if (TextUtils.isEmpty(r13) == false) goto L17;
        return null;
    L17:
        return String.format("%s.tp", new Object[]{r13});
    L12:
        r13 = C(r10, r12);
        goto L14
    }

    public static String F(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L9;
        if (TextUtils.isEmpty(r11) == false) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(r11) == false) goto L11;
        return r10;
    L11:
        return r11;
    }

    public static String G(Throwable r10) {
        if (r10 != null) goto L10;
        return "";
    L10:
        return r10.toString();
    L7:
        th = move-exception;
        th.printStackTrace();
        return "throwable getMsg error";
    }

    public static boolean H(List<HttpHeader> r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.size() == 0) goto L36;
        Iterator<HttpHeader> r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L37;
        HttpHeader r12 = r11.next();
        if (r12 == null) goto L9;
        if (TextUtils.isEmpty(r12.getName()) == true) goto L9;
        if (TextUtils.isEmpty(r12.getValue()) == true) goto L9;
        if ("download-tc21-1-15".equals(r12.getName()) == false) goto L9;
        if ("download-tc21-1-15".equals(r12.getValue()) == false) goto L9;
        return true;
    L37:
        return false;
    L36:
        return false;
    }

    public static boolean I(long r10) {
        if (r10 != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean J(int r10, String r11, String r12) {
        if (r10 == (-3)) goto L5;
        return false;
    L5:
        if (M(r11, r12) == true) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean K(DownloadInfo r10) {
        return L(r10, r10.isForce(), r10.getMd5());
    }

    public static boolean L(DownloadInfo r10, boolean r11, String r12) {
        if (r11 == false) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r10.getSavePath()) == true) goto L19;
        if (TextUtils.isEmpty(r10.getName()) == true) goto L19;
        kb.a r13 = new kb.a(r10.getSavePath(), r10.getName());     // Catch: OutOfMemoryError -> L17
        if (kb.b.f(r13) == false) goto L19;
        if (c(r10, r13) == false) goto L19;
        if (f(r13, r12) == false) goto L19;
        return true;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public static boolean M(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L14;
        if (kb.b.p(r10) == false) goto L13;
        if (kb.b.b(r10) == true) goto L13;
        return false;
    L13:
        return new kb.a(r10, r11).h();
    }

    public static boolean N(Throwable r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if ((r10 instanceof BaseException) == false) goto L31;
        BaseException r11 = (BaseException) r10;
        int r12 = r11.getErrorCode();
        if (r12 != 1006) goto L11;
        return true;
    L11:
        if (r12 != 1023) goto L13;
    L22:
        boolean r13 = true;
    L23:
        if (r13 == false) goto L40;
        String r14 = r11.getMessage();
        if (TextUtils.isEmpty(r14) == false) goto L27;
        return false;
    L27:
        if (r14.contains("ENOSPC") == true) goto L29;
        return false;
    L29:
        return true;
    L40:
        return false;
    L13:
        if (r12 == 1039) goto L22;
        if (r12 == 1040) goto L22;
        if (r12 == 1054) goto L22;
        if (r12 == 1064) goto L22;
        r13 = false;
        goto L23
    L31:
        if ((r10 instanceof IOException) == false) goto L41;
        String r15 = G(r10);
        if (TextUtils.isEmpty(r15) == false) goto L35;
        return false;
    L35:
        if (r15.contains("ENOSPC") == true) goto L37;
        return false;
    L37:
        return true;
    L41:
        return false;
    }

    public static boolean O() {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean P(int r10) {
        if (r10 != 0) goto L4;
    L7:
        return true;
    L4:
        if (r10 == 2) goto L7;
        return false;
    }

    public static boolean Q(Context r10) {
        NetworkInfo r11 = o(r10).getActiveNetworkInfo();     // Catch: Exception -> L8
        if (r11 != null) goto L6;
        return false;
    L6:
        return r11.isConnected();
    L8:
        return false;
    }

    public static boolean R(Throwable r10) {
        if (r10 != null) goto L5;
    L60:
        return false;
    L5:
        if ((r10 instanceof BaseException) == false) goto L60;
        int r11 = ((BaseException) r10).getErrorCode();
        if (r11 < 2000) goto L13;
        if (r11 >= 3000) goto L13;
        return true;
    L13:
        if (r11 != 1075) goto L15;
    L59:
        return true;
    L15:
        if (r11 == 1078) goto L59;
        if (r11 == 1079) goto L59;
        if (r11 == 1055) goto L59;
        if (r11 == 1023) goto L59;
        if (r11 == 1041) goto L59;
        if (r11 == 1022) goto L59;
        if (r11 == 1048) goto L59;
        if (r11 == 1056) goto L59;
        if (r11 == 1057) goto L59;
        if (r11 == 1058) goto L59;
        if (r11 == 1059) goto L59;
        if (r11 == 1060) goto L59;
        if (r11 == 1061) goto L59;
        if (r11 == 1067) goto L59;
        if (r11 == 1049) goto L59;
        if (r11 == 1047) goto L59;
        if (r11 == 1051) goto L59;
        if (r11 == 1004) goto L59;
        if (r11 == 1011) goto L59;
        if (r11 == 1002) goto L59;
        if (r11 == 1013) goto L59;
        return false;
    }

    public static boolean S(Throwable r10) {
        if (((l) k.a(l.class)).a().b(r10) != 304) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean T(Context r10) {
        NetworkInfo r11 = o(r10).getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r11 != null) goto L6;
        return false;
    L6:
        if (r11.isAvailable() == false) goto L17;
        if (1 == r11.getType()) goto L12;
        return false;
    L12:
        return true;
    L17:
        return false;
    L19:
        return false;
    }

    public static List<String> U(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L19;
        return null;
    L19:
        JSONArray r11 = new JSONArray(r10);     // Catch: Exception -> L16
        if (r11.length() > 0) goto L8;
        return null;
    L8:
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L16
        int r13 = 0;
    L10:
        if (r13 >= r11.length()) goto L15;
        String r14 = r11.optString(r13);     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r14) == true) goto L14;
        r12.add(r14);     // Catch: Exception -> L16
    L14:
        r13 = r13 + 1;
        goto L10
    L15:
        return r12;
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String V(List<String> r10) {
        if (r10 != null) goto L5;
    L17:
        return "";
    L5:
        if (r10.isEmpty() == true) goto L17;
        JSONArray r11 = new JSONArray();     // Catch: Exception -> L15
        Iterator<String> r12 = r10.iterator();     // Catch: Exception -> L15
    L9:
        if (r12.hasNext() == false) goto L13;
        String r13 = r12.next();     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r13) == true) goto L9;
        r11.put(r13);     // Catch: Exception -> L15
        goto L9
    L13:
        return r11.toString();
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static String W(String r10) {
        if (r10 != null) goto L11;
    L9:
        return null;
    L11:
        if (r10.length() == 0) goto L9;
        MessageDigest r11 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Exception -> L10
        r11.update(r10.getBytes("UTF-8"));     // Catch: Exception -> L10
        return c0(r11.digest());
    }

    public static long X(nb.g r10) {
        if (r10 != null) goto L5;
        return -1;
    L5:
        String r11 = B(r10, "Content-Range");
        if (TextUtils.isEmpty(r11) == false) goto L16;
        return -1;
    L16:
        Matcher r12 = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(r11);     // Catch: Exception -> L13
        if (r12.find() == false) goto L15;
        return (Long.parseLong(r12.group(2)) - Long.parseLong(r12.group(1))) + 1;
    L15:
        return -1;
    L13:
        e = move-exception;
        lb.a.c(f8343a, "parseContentLengthFromContentRange", "Exception:" + e);
        goto L15
    }

    public static String Y(String r10) {
    L8:
        e = move-exception;
        e.printStackTrace();
        return "";
    L3:
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return "";
    L5:
        if (TextUtils.isDigitsOnly(r10) == false) goto L15;
        return String.valueOf(Long.valueOf(r10).longValue() % 100);
    L15:
        return "";
    }

    public static String Z(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return "";
    L5:
        int r11 = r10.lastIndexOf(":");
        if (r11 > 0) goto L9;
        return "";
    L9:
        return r10.substring(0, r11);
    }

    public static boolean a(DownloadInfo r10) {
        return b(r10, false);
    }

    public static void a0(Cursor... r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L14;
        Cursor r13 = r10[r12];
        if (r13 == null) goto L13;
        r13.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
    L13:
        r12 = r12 + 1;
        goto L5
    }

    public static boolean b(DownloadInfo r10, boolean r11) {
        boolean r12 = true;
        if (r10.isDeleteCacheIfCheckFailed() == true) goto L11;
        if (TextUtils.isEmpty(r10.getLastModified()) == false) goto L11;
        if (lb.a.a() == false) goto L9;
        lb.a.g(f8343a, r10.getId(), "cacheExpiredWithHttp", "Modify is empty, so just return cache");
    L9:
        r12 = false;
    L18:
        if (lb.a.a() == false) goto L20;
        lb.a.g(f8343a, r10.getId(), "cacheExpiredWithHttp", "Name=" + r10.getName() + " expired=" + r12);
    L20:
        return r12;
    L11:
        if (lb.a.a() == false) goto L14;
        lb.a.g(f8343a, r10.getId(), "cacheExpiredWithHttp", "Curt=" + System.currentTimeMillis() + " expired=" + r10.getCacheExpiredTime());
    L14:
        if (System.currentTimeMillis() > r10.getCacheExpiredTime()) goto L18;
        if (r11 == false) goto L9;
        goto L9
    }

    public static void b0(Closeable... r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L14;
        Closeable r13 = r10[r12];
        if (r13 == null) goto L13;
        r13.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
    L13:
        r12 = r12 + 1;
        goto L5
    }

    public static boolean c(DownloadInfo r10, kb.a r11) {
        if (r10.getTotalBytes() > 0) goto L5;
        return true;
    L5:
        if (r11.length() >= r10.getTotalBytes()) goto L10;
        return false;
    L10:
        return true;
    }

    public static String c0(byte[] r10) {
        Objects.requireNonNull(r10, "bytes is null");
        return d0(r10, 0, r10.length);
    }

    public static int d(kb.a r10, String r11) {
        if (r10.o() == true) goto L5;
        return tb.c.d(r11, r10.getFile(), new b(r10.g()));
    L8:
        th = move-exception;
        th.printStackTrace();
        return 5;
    L5:
        return tb.c.c(r11, r10.getFile());
    }

    public static String d0(byte[] r10, int r11, int r12) {
        Objects.requireNonNull(r10, "bytes is null");
        if (r11 < 0) goto L12;
        if ((r11 + r12) > r10.length) goto L12;
        int r13 = r12 * 2;
        char[] r14 = new char[r13];
        int r15 = 0;
        int r16 = 0;
    L7:
        if (r15 >= r12) goto L10;
        int r17 = r10[r15 + r11] & 255;
        int r18 = r16 + 1;
        char[] r19 = f8344b;
        r14[r16] = r19[r17 >> 4];
        r16 = r18 + 1;
        r14[r18] = r19[r17 & 15];
        r15 = r15 + 1;
        goto L7
    L10:
        return new String(r14, 0, r13);
    L12:
        throw new IndexOutOfBoundsException();
    }

    public static boolean e(String r10, String r11, String r12) {
        return P(d(new kb.a(r10, r11), r12));
    }

    public static boolean f(kb.a r10, String r11) {
        return P(d(r10, r11));
    }

    public static void g(DownloadInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        rb.a r11 = rb.a.g(r10.getId());
        JSONObject r12 = r11.q("download_dir");
        if (r12 == null) goto L24;
        String r13 = r12.optString("ins_desc");
        if (TextUtils.isEmpty(r13) == true) goto L9;
        l(r10.getSavePath(), r13);
    L9:
        String r14 = r10.getTitle();
        if (TextUtils.isEmpty(r14) == false) goto L12;
        r14 = r10.getName();
    L12:
        String r15 = z(r14, r11);
        String r16 = r10.getSavePath();
        if (TextUtils.isEmpty(r15) == false) goto L15;
        return;
    L15:
        if (TextUtils.isEmpty(r16) == true) goto L30;
        File r17 = new File(r15);
        File r18 = new File(r16);
    L17:
        if (r17 == null) goto L31;
        if (r18 == null) goto L32;
        if (r18.isDirectory() == false) goto L33;
        if (TextUtils.equals(r17.getName(), r18.getName()) == false) goto L34;
        k(r18.getPath());
        r17 = r17.getParentFile();
        r18 = r18.getParentFile();
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

    public static void h(String r10, String r11, String r12) {
        String r13 = String.format("%s.tp", new Object[]{r12});
        l(r10, r12);
        if (r11 == null) goto L6;
        r10 = r11;
    L6:
        l(r10, r13);
    }

    public static void i(DownloadInfo r10) {
        j(r10, true);
    }

    public static void j(DownloadInfo r10, boolean r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isForce() == true) goto L7;
    L9:
        if (r11 == true) goto L26;
    L11:
        l(r10.getTempPath(), r10.getTempName());     // Catch: Throwable -> L23
        if (r10.isSavePathRedirected() == false) goto L14;
        g(r10);     // Catch: Throwable -> L23
    L14:
        if (r11 == false) goto L28;
        String r12 = W(r10.getUrl());     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r12) == false) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty(r10.getSavePath()) == false) goto L20;
        return;
    L20:
        if (r10.getSavePath().contains(r12) == false) goto L31;
        k(r10.getSavePath());     // Catch: Throwable -> L23
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
        l(r10.getSavePath(), r10.getName());     // Catch: Throwable -> L23
        goto L11
    L7:
        if (a.p(r10.getSavePath()) == true) goto L9;
        r11 = false;
        goto L9
    }

    private static boolean k(String r10) {
        if (lb.a.a() == false) goto L6;
        lb.a.b(f8343a, "deleteDirIfEmpty", "Thread:" + Thread.currentThread());
    L6:
        if (kb.b.l(r10) == 1) goto L8;
    L21:
        return false;
    L8:
        if (a.p(r10) == false) goto L21;
        if (TextUtils.isEmpty(r10) == true) goto L21;
        File r11 = new File(r10);
        if (r11.isDirectory() == false) goto L21;
        if (r11.delete() == false) goto L17;
        return true;
    L17:
        if (lb.a.a() == false) goto L19;
        lb.a.b(f8343a, "deleteDirIfEmpty", "Delete Failed");
    L19:
        return false;
    }

    public static void l(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L14;
        kb.a r12 = new kb.a(r10, r11, false, true);
        if (r12.h() == true) goto L9;
        return;
    L9:
        if (lb.a.a() == false) goto L11;
        lb.a.b(f8343a, "deleteFile", "Path: " + r12.d());
    L11:
        r12.l();
        return;
    }

    public static String m(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == true) goto L10;
        String r12 = W(r11);
        if (TextUtils.isEmpty(r12) == false) goto L7;
        return r10;
    L7:
        if (r10.contains(r12) == false) goto L9;
        return r10;
    L9:
        return new File(r10, r12).getAbsolutePath();
    L10:
        return r10;
    }

    public static long n(String r10) {
        StatFs r11 = new StatFs(r10);     // Catch: Throwable -> L8 IllegalArgumentException -> L11
        if (Build.VERSION.SDK_INT < 18) goto L7;
        return r11.getAvailableBytes();
    L7:
        return r11.getAvailableBlocks() * ((long) r11.getBlockSize());
    L11:
        e = move-exception;
        throw new BaseException(1050, e);
    L8:
        th = move-exception;
        throw new BaseException(1052, th);
    }

    public static ConnectivityManager o(Context r10) {
        ConnectivityManager r11 = f8345c;
        if (r11 != null) goto L6;
        ConnectivityManager r12 = (ConnectivityManager) r10.getSystemService("connectivity");
        f8345c = r12;
        return r12;
    L6:
        return r11;
    }

    public static long p(nb.g r10) {
        if (r10 != null) goto L5;
        return -1;
    L5:
        String r11 = B(r10, "Content-Length");
        if (TextUtils.isEmpty(r11) == true) goto L13;
        return Long.parseLong(r11);
    L14:
        return -1;
    L13:
        return X(r10);
    }

    public static String q(Context r10) {
        String r11 = f8346d;
        if (TextUtils.isEmpty(r11) == true) goto L5;
        return r11;
    L5:
        String r12 = t();
        f8346d = r12;
        if (TextUtils.isEmpty(r12) == false) goto L8;
        String r13 = s();
        f8346d = r13;
        if (TextUtils.isEmpty(r13) == false) goto L12;
        String r14 = u();
        f8346d = r14;
        if (TextUtils.isEmpty(r14) == false) goto L16;
        String r15 = r(r10);
        f8346d = r15;
        return r15;
    L16:
        return f8346d;
    L12:
        return f8346d;
    L8:
        return f8346d;
    }

    private static String r(Context r10) {
        if (r10 != null) goto L20;
        return null;
    L20:
        int r11 = Process.myPid();     // Catch: Exception -> L17
        ActivityManager r12 = (ActivityManager) r10.getSystemService("activity");     // Catch: Exception -> L17
        if (r12 == null) goto L19;
        Iterator<ActivityManager.RunningAppProcessInfo> r13 = r12.getRunningAppProcesses().iterator();     // Catch: Exception -> L17
    L9:
        if (r13.hasNext() == false) goto L19;
        ActivityManager.RunningAppProcessInfo r14 = r13.next();     // Catch: Exception -> L17
        if (r14.pid != r11) goto L9;
        if (lb.a.a() == false) goto L15;
        lb.a.b(f8343a, "getCurProcessNameByActivityManager", "ProcessName: " + r14.processName);     // Catch: Exception -> L17
    L15:
        return r14.processName;
    L19:
        return null;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    private static String s() {
        Method r10 = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L14
        r10.setAccessible(true);     // Catch: Throwable -> L14
        Object r11 = r10.invoke(null, new Object[0]);     // Catch: Throwable -> L14
        if ((r11 instanceof String) == false) goto L23;
        String r12 = (String) r11;     // Catch: Throwable -> L14
    L12:
        Throwable th = th;
    L16:
        th.printStackTrace();
    L18:
        return r12;
    L7:
        if (lb.a.a() == false) goto L18;
        if (TextUtils.isEmpty(r12) == true) goto L18;
        lb.a.b(f8343a, "getCurProcessNameByActivityThread", "ProcessName: " + r12);     // Catch: Throwable -> L12
        goto L18
    L23:
        return null;
    L14:
        th = move-exception;
        r12 = null;
        th = th;
        goto L16
    }

    private static String t() {
        if (Build.VERSION.SDK_INT < 28) goto L16;
        String r10 = Application.getProcessName();     // Catch: Exception -> L10
        if (lb.a.a() == true) goto L7;
    L9:
        return r10;
    L7:
        if (TextUtils.isEmpty(r10) == true) goto L9;
        lb.a.b(f8343a, "getCurProcessNameByApplication", "ProcessName: " + r10);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    L16:
        return null;
    }

    private static String u() {
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L14
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L17
    L5:
        int r12 = r10.read();     // Catch: Throwable -> L17
        if (r12 <= 0) goto L9;
        r11.append((char) r12);     // Catch: Throwable -> L17
        goto L5
    L9:
        if (lb.a.a() == false) goto L11;
        lb.a.b(f8343a, "getCurProcessNameFromProc", "ProcessName: " + r11.toString());     // Catch: Throwable -> L17
    L11:
        String r13 = r11.toString();     // Catch: Throwable -> L17
        b0(new Closeable[]{r10});
        return r13;
    L15:
        b0(new Closeable[]{r10});
        return null;
    L14:
        r10 = null;
        goto L15
    }

    public static String v(String r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L13;
        char r14 = r10.charAt(r13);
        if (r14 > 31) goto L7;
    L10:
        r11.append(String.format("\\u%04x", new Object[]{Integer.valueOf(r14)}));
    L11:
        r13 = r13 + 1;
        goto L3
    L7:
        if (r14 >= 127) goto L10;
        r11.append(r14);
        goto L11
    L13:
        return r11.toString();
    }

    public static String w(Throwable r10, String r11) {
        if (r11 != null) goto L6;
        return G(r10);
    L6:
        return r11 + "-" + G(r10);
    }

    public static String x(int r10) {
        String r11 = "ttmd5 check code = " + r10 + ", ";
        if (r10 == 99) goto L14;
        switch(r10) {
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
        StringBuilder r12 = new StringBuilder();
        r12.append(r11);
        String r13 = "get file md5 error";
    L13:
        r12.append(r13);
        return r12.toString();
    L7:
        r12 = new StringBuilder();
        r12.append(r11);
        r13 = "file not exist";
        goto L13
    L8:
        r12 = new StringBuilder();
        r12.append(r11);
        r13 = "ttmd5 tag parser error";
        goto L13
    L9:
        r12 = new StringBuilder();
        r12.append(r11);
        r13 = "ttmd5 version not support";
        goto L13
    L10:
        r12 = new StringBuilder();
        r12.append(r11);
        r13 = "md5 empty";
        goto L13
    L11:
        r12 = new StringBuilder();
        r12.append(r11);
        r13 = "md5 not match";
        goto L13
    L12:
        r12 = new StringBuilder();
        r12.append(r11);
        r13 = "md5 match";
        goto L13
    L16:
        return r11;
    L14:
        r12 = new StringBuilder();
        r12.append(r11);
        r13 = "unknown error";
        goto L13
    }

    public static int y(Context r10) {
        if (r10 != null) goto L21;
        return 0;
    L21:
        ConnectivityManager r11 = o(r10);     // Catch: Exception -> L20
        if (r11 != null) goto L8;
        return 0;
    L8:
        NetworkInfo r12 = r11.getActiveNetworkInfo();     // Catch: Exception -> L20
        if (r12 == null) goto L19;
        if (r12.isAvailable() == false) goto L19;
        if (1 != r12.getType()) goto L17;
        return 1;
    L17:
        return 2;
    L19:
        return 0;
    }

    public static String z(String r10, rb.a r11) {
        if (r11 == null) goto L21;
        JSONObject r12 = r11.q("download_dir");
        if (r12 == null) goto L21;
        String r13 = r12.optString("dir_name");
        if (TextUtils.isEmpty(r13) == true) goto L11;
        if (r13.startsWith("/") == false) goto L11;
        r13 = r13.substring(1);
    L11:
        if (TextUtils.isEmpty(r13) == false) goto L13;
        return r13;
    L13:
        if (r13.contains("%s") == true) goto L24;
        String r14 = r13 + r10;
    L15:
        r13 = r14;
    L19:
        if (r13.length() > 255) goto L28;
        return r13;
    L28:
        return r13.substring(r13.length() - 255);
    L24:
        r14 = String.format(r13, new Object[]{r10});     // Catch: Throwable -> L23
    L21:
        return "";
    }
}
