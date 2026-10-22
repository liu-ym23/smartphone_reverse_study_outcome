package com.ss.android.socialbase.downloader.utils;

import ai.j0;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import androidx.room.writer.DaoWriter;
import cn.nubia.neopush.commons.Constant;
import com.lynx.tasm.utils.j;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.ITTNetHandler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.RandomAccessOutputStream;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import dn.a;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.StreamResetException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import td.c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DownloadHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile SparseArray f16133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile SparseArray f16134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f16135c;
    public static Boolean d;

    static {
        f16133a = new SparseArray();
        f16134b = new SparseArray();
    }

    public static RandomAccessOutputStream a(DownloadInfo r10, String r11, String r12, int r13, boolean r14) {
        if (TextUtils.isEmpty(r11) == true) goto L64;
        if (TextUtils.isEmpty(r12) == true) goto L64;
        File r5 = new File(r11, r12);
        if (r5.exists() == false) goto L14;
        if (r5.isDirectory() == false) goto L14;
        throw new BaseException(1035, DownloadUtils.a(new IOException(String.format("path is :%s, path is directory:%B:", new Object[]{r11, Boolean.valueOf(r5.isDirectory())}))));
    L14:
        if (r5.exists() == true) goto L62;
        File r15 = new File(r11);     // Catch: IOException -> L20
        if (r15.exists() == false) goto L23;
        if (r15.isDirectory() == false) goto L23;
    L50:
        r5.createNewFile();     // Catch: IOException -> L20
    L23:
        if (r15.exists() == false) goto L25;
        r15.delete();     // Catch: IOException -> L20
        if (r15.mkdirs() == true) goto L58;
        if (r15.exists() == true) goto L58;
        throw new BaseException(1031, "download savePath is not directory:path=" + r11);     // Catch: IOException -> L20
    L58:
        throw new BaseException(1031, "download savePath is not directory:" + r11);     // Catch: IOException -> L20
    L25:
        if (r15.mkdirs() == true) goto L50;
        if (r15.exists() == true) goto L50;
        if (r10 != null) goto L30;
        DownloadSetting r16 = DownloadSetting.f;     // Catch: IOException -> L20
    L31:
        boolean r17 = false;
        if (r16.a("opt_mkdir_failed", 0) != 1) goto L49;
        int r18 = 0;
    L35:
        if (r17 == true) goto L41;
        int r19 = r18 + 1;
        if (r18 >= 3) goto L41;
        Thread.sleep(10);     // Catch: IOException -> L20 InterruptedException -> L65
        r17 = r15.mkdirs();     // Catch: IOException -> L20
        r18 = r19;
    L41:
        if (r17 == true) goto L50;
        if (DownloadUtils.b(r10.e) >= Http2Stream.EMIT_BUFFER_SIZE) goto L47;
        throw new BaseException(PointerIconCompat.TYPE_CELL, "download savePath directory can not created:" + r11);     // Catch: IOException -> L20
    L47:
        throw new BaseException(1030, "download savePath directory can not created:" + r11);     // Catch: IOException -> L20
    L49:
        throw new BaseException(1030, "download savePath directory can not created:" + r11);     // Catch: IOException -> L20
    L30:
        LruCache r20 = DownloadSetting.e;     // Catch: IOException -> L20
        r16 = DownloadSetting.a(r10.l(), r10);     // Catch: IOException -> L20
    L20:
        e = move-exception;
        throw new BaseException(1036, DownloadUtils.a(e));
    L62:
        return new RandomAccessOutputStream(r5, r13, r14);
    L64:
        throw new BaseException(PointerIconCompat.TYPE_GRABBING, DownloadUtils.a(new IOException("path must be not empty")));
    }

    public static void b(DownloadFile r17, DownloadFile r18) {
        if (r18.f() == false) goto L10;
        if (r18.j() == false) goto L10;
        throw new IOException("Destination '" + r18 + "' exists but is a directory");
    L10:
        if (DownloadFileUtils.b() == false) goto L23;
        if (r18.g() <= 1) goto L23;
        monitor-enter(DownloadComponentManager.class);
        Context r5 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L19
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L19
        a(r5, r17.h(), Uri.parse(r18.f15608b));
        return;
    L19:
        th = move-exception;
        throw th;
    L23:
        if (DownloadFileUtils.d(r18.h()) == false) goto L30;
        Uri r10 = DownloadFileUtils.c(r18.h());
        if (r10 == null) goto L29;
        a(DownloadComponentManager.b(), r17.h(), r10);
        return;
    L29:
        throw new IOException("Destination " + r18 + "exists but contentUri is null");
    L30:
        FileInputStream r11 = r17.c();
        FileChannel r12 = r11.getChannel();     // Catch: Throwable -> L61
        FileOutputStream r13 = r18.k();     // Catch: Throwable -> L63
        FileChannel r14 = r13.getChannel();     // Catch: Throwable -> L51
        long r15 = r12.size();     // Catch: Throwable -> L46
        long r16 = 0;
    L36:
        if (r16 >= r15) goto L48;
        long r19 = r15 - r16;     // Catch: Throwable -> L46
        if (r19 <= 31457280) goto L40;
        long r20 = 31457280;
    L41:
        long r21 = r14.transferFrom(r12, r16, r20);     // Catch: Throwable -> L46
    L43:
        if (r21 == 0) goto L48;
        r16 = r16 + r21;
        goto L36
    L40:
        r20 = r19;
    L48:
        if (r14 == null) goto L53;
        r14.close();     // Catch: Throwable -> L51
    L53:
        r13.close();     // Catch: Throwable -> L63
        r12.close();     // Catch: Throwable -> L61
        r11.close();
        long r22 = r17.length();
        long r23 = r18.length();
        if (r22 != r23) goto L60;
        r18.a(r17.i());
        return;
    L60:
        throw new IOException("Failed to copy full contents from '" + r17 + "' to '" + r18 + "' Expected length: " + r22 + " Actual: " + r23);
    L46:
        th = move-exception;
        throw th;     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        if (r14 == null) goto L129;
        r14.close();     // Catch: Throwable -> L71
    L130:
        throw th;     // Catch: Throwable -> L51
    L71:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L51
        throw th;     // Catch: Throwable -> L51
    L129:
        throw th;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;     // Catch: Throwable -> L76
    L76:
        th = move-exception;
        if (r13 == null) goto L131;
        r13.close();     // Catch: Throwable -> L81
    L132:
        throw th;     // Catch: Throwable -> L63
    L81:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L63
        throw th;     // Catch: Throwable -> L63
    L131:
        throw th;     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        throw th;     // Catch: Throwable -> L86
    L86:
        th = move-exception;
        if (r12 == null) goto L133;
        r12.close();     // Catch: Throwable -> L91
    L134:
        throw th;     // Catch: Throwable -> L61
    L91:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L61
        throw th;     // Catch: Throwable -> L61
    L133:
        throw th;     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        throw th;     // Catch: Throwable -> L96
    L96:
        th = move-exception;
        if (r11 == null) goto L135;
        r11.close();     // Catch: Throwable -> L101
        throw th;
    L101:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L135:
        throw th;
    }

    public static long c(String r5) {
        if (r5 != null) goto L5;
        return -1;
    L5:
        String[] r10 = r5.split("/");
        if (r10.length >= 2) goto L13;
    L12:
        return -1;
    L13:
        return Long.parseLong(r10[1]);
    L10:
        e = move-exception;
        Logger.c("DownloadHelper", "parseContentRangeOfInstanceLength", "Exception:" + e);
        goto L12
    }

    public static void d() {
        String[] r5 = {"lru_download_info_cache_enable", "optimize_download_cache"};     // Catch: Throwable -> L13
        monitor-enter(DownloadComponentManager.class);     // Catch: Throwable -> L13
        Context r10 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L32
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L32
        int r11 = 0;
        SharedPreferences r12 = r10.getSharedPreferences("sp_download_setting_cache", 0);     // Catch: Throwable -> L13
        LruCache r13 = DownloadSetting.e;     // Catch: Throwable -> L13
        JSONObject r14 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c();     // Catch: Throwable -> L13
        if (r14.optInt("enable_setting_cache") > 0) goto L20;
    L9:
        if (r11 >= 2) goto L17;
        if (r12.contains(r5[r11]) == true) goto L12;
        r11 = r11 + 1;     // Catch: Throwable -> L13
        goto L9
    L12:
        r12.edit().clear().apply();     // Catch: Throwable -> L13
    L17:
        if (Logger.b() == false) goto L45;
        Logger.b("DownloadHelper", "updateCacheSetting", "Disable cache setting");     // Catch: Throwable -> L13
        return;
    L45:
        return;
    L20:
        SharedPreferences.Editor r15 = r12.edit();     // Catch: Throwable -> L13
        int r16 = 0;
        boolean r17 = false;
    L21:
        if (r16 >= 2) goto L29;
        String r18 = r5[r16];     // Catch: Throwable -> L13
        int r19 = r14.optInt(r18, 0);     // Catch: Throwable -> L13
        if (r12.getInt(r18, 0) == r19) goto L28;
        r15.putInt(r18, r19);     // Catch: Throwable -> L13
        if (Logger.b() == false) goto L27;
        Logger.b("DownloadHelper", "updateCacheSetting", "Key:" + r18 + " Value:" + r19);     // Catch: Throwable -> L13
    L27:
        r17 = true;
    L28:
        r16 = r16 + 1;     // Catch: Throwable -> L13
        goto L21
    L29:
        if (r17 == false) goto L46;
        r15.apply();     // Catch: Throwable -> L13
        return;
    L46:
        return;
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        c.e("Error:", th, "DownloadHelper", "updateCacheSetting");
    }

    public static boolean c(DownloadFile r10, DownloadFile r11) {
        if (Logger.b() == false) goto L6;
        Logger.b("DownloadHelper", "moveFile", "DownloadFile Src:" + r10.h() + " Dest:" + r11.h());
    L6:
        if (DownloadFileUtils.c() == true) goto L8;
    L12:
        boolean r5 = r10.a(r11);
    L13:
        if (r5 == true) goto L23;
        r5 = a(r10, r11);
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L23
    L16:
        if (Logger.b() == false) goto L20;
        Logger.b("DownloadHelper", "moveFile", "Copy DownloadFile Src:" + r10.h() + " Dest:" + r11.h());     // Catch: Throwable -> L18
    L20:
        r10.m();     // Catch: Throwable -> L18
        return r5;
    L23:
        return r5;
    L8:
        if (DownloadFileUtils.d(r10.e()) == true) goto L12;
        if (DownloadFileUtils.d(r11.e()) == false) goto L12;
        r5 = false;
        goto L13
    }

    public static boolean c() {
        if (a() == false) goto L5;
        return false;
    L5:
        monitor-enter(DownloadComponentManager.class);
        boolean r5 = DownloadComponentManager.s;     // Catch: Throwable -> L12
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L12
        if (r5 == true) goto L10;
        return false;
    L10:
        if (DownloadProxy.a(true).d() == false) goto L20;
        return true;
    L20:
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    public static boolean b() {
        Boolean r5 = f16135c;
        if (r5 != null) goto L5;
        DownloadSetting r10 = DownloadSetting.f;
        boolean r11 = false;
        if (r10.a("force_independent_process", 0) <= 0) goto L11;
        f16135c = Boolean.FALSE;
        return false;
    L11:
        if (r10.a("force_main_process", 0) <= 0) goto L15;
        f16135c = Boolean.TRUE;
        return true;
    L15:
        monitor-enter(DownloadComponentManager.class);
        Context r12 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L32
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L32
        if (r12 != null) goto L20;
        return true;
    L20:
        String r13 = DownloadUtils.a(DownloadComponentManager.b());
        if (r13 != null) goto L23;
    L25:
        if (r13 != null) goto L27;
    L29:
        f16135c = Boolean.valueOf(r11);
    L31:
        return f16135c.booleanValue();
    L27:
        if (r13.equals(DownloadComponentManager.b().getPackageName()) == false) goto L29;
        r11 = true;
        goto L29
    L23:
        if (r13.contains(":") == false) goto L25;
        f16135c = Boolean.FALSE;
    L32:
        th = move-exception;
        throw th;
    L5:
        return r5.booleanValue();
    }

    public static void a(int r10, boolean r11, BaseException r12) {
        SparseArray r5 = f16133a;
        monitor-enter(r5);
        List r13 = (List) f16134b.get(r10);     // Catch: Throwable -> L13
        if (r13 == null) goto L17;
        Iterator r14 = r13.iterator();     // Catch: Throwable -> L13
    L8:
        if (r14.hasNext() == false) goto L17;
        ITempFileSaveCompleteCallback r15 = (ITempFileSaveCompleteCallback) r14.next();     // Catch: Throwable -> L13
        if (r15 == null) goto L8;
        if (r11 == true) goto L12;
        r15.a(r12);     // Catch: Throwable -> L13
        goto L8
    L12:
        r15.onSuccess();     // Catch: Throwable -> L13
    L17:
        if (Logger.b() == false) goto L19;
        Logger.a("DownloadHelper", r10, null, "handleTempSaveCallback", "Run", false);     // Catch: Throwable -> L13
    L19:
        f16133a.remove(r10);     // Catch: Throwable -> L13
        monitor-exit(r5);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static boolean a(DownloadFile r5, DownloadFile r10) {
    L24:
        e = move-exception;
        throw e;
    L22:
        th = move-exception;
        a(th, "CopyFile");
        throw null;
    L4:
        if (r5.f() == true) goto L6;
        return false;
    L6:
        if (r5.j() == false) goto L8;
        return false;
    L8:
        if (r5.e().equals(r10.e()) == false) goto L12;
        return false;
    L12:
        if (r10.o() == false) goto L27;
        File r11 = r10.d();     // Catch: Throwable -> L22 BaseException -> L24
        if (r11 == null) goto L27;
        if (r11.mkdirs() == true) goto L27;
        if (r11.isDirectory() == true) goto L27;
        throw new BaseException(1053, "Destination '" + r11 + "' directory cannot be created");     // Catch: Throwable -> L22 BaseException -> L24
    L27:
        if (Logger.b() == false) goto L30;
        Logger.b("DownloadHelper", "copyFile", "SrcFile:" + r5.h() + " DestFile:" + r10.h());     // Catch: Throwable -> L22 BaseException -> L24
    L30:
        if (r10.f() == true) goto L32;
    L36:
        b(r5, r10);     // Catch: Throwable -> L22 BaseException -> L24
        return true;
    L32:
        if (r10.b() == true) goto L36;
        throw new IOException("Destination '" + r10.e() + "' exists but is read-only");     // Catch: Throwable -> L22 BaseException -> L24
    }

    public static int b(String r5) {
        monitor-enter(DownloadComponentManager.class);     // Catch: Throwable -> L11
        Context r10 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L14
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L14
        int r11 = r10.getSharedPreferences("sp_download_setting_cache", 0).getInt(r5, 0);     // Catch: Throwable -> L11
        if (Logger.b() == false) goto L13;
        Logger.b("DownloadHelper", "getCacheSettingInt", "Key:" + r5 + " Value:" + r11);     // Catch: Throwable -> L11
        return r11;
    L13:
        return r11;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        c.e("Error:", th, "DownloadHelper", "getCacheSettingInt");
        return 0;
    }

    public static void a(Context r10, String r11, Uri r12) {
        ContentResolver r13 = r10.getContentResolver();
        FileInputStream r5 = null;
        OutputStream r14 = null;
        r14 = null;
        r14 = null;
        r5 = null;
        FileInputStream r15 = new FileInputStream(new File(r11));     // Catch: Throwable -> L19 IOException -> L21
        if (r12 != null) goto L32;
    L10:
        if (r14 == null) goto L17;
        byte[] r16 = new byte[DownloadComponentManager.C];     // Catch: Throwable -> L6 IOException -> L8
    L12:
        int r17 = r15.read(r16);     // Catch: Throwable -> L6 IOException -> L8
        if (r17 == (-1)) goto L17;
        r14.write(r16, 0, r17);     // Catch: Throwable -> L6 IOException -> L8
        goto L12
    L8:
        e = e;
        OutputStream r18 = r14;
        r5 = r15;
    L30:
        Logger.c("DownloadHelper", "copyFileToExternal", "Error:" + e);     // Catch: Throwable -> L26
        DownloadUtils.a(new Closeable[]{r5});
        DownloadUtils.a(new Closeable[]{r18});
        return;
    L26:
        th = th;
    L27:
        r15 = r5;
        r14 = r18;
    L28:
        DownloadUtils.a(new Closeable[]{r15});
        DownloadUtils.a(new Closeable[]{r14});
        throw th;
    L6:
        th = th;
    L17:
        DownloadUtils.a(new Closeable[]{r15});
        DownloadUtils.a(new Closeable[]{r14});
        return;
    L32:
        r14 = r13.openOutputStream(r12);     // Catch: Throwable -> L6 IOException -> L8
        goto L10
    L21:
        e = e;
        r18 = null;
    L19:
        th = th;
        r18 = null;
        goto L27
    }

    public static ArrayList a(ArrayList r5, String r10, long r11, long r12) {
        ArrayList r13 = new ArrayList();
        if (r5 == null) goto L19;
        if (r5.size() <= 0) goto L19;
        Iterator r14 = r5.iterator();
    L8:
        if (r14.hasNext() == false) goto L19;
        HttpHeader r15 = (HttpHeader) r14.next();
        if (r15 == null) goto L8;
        if ("Accept-Encoding".equalsIgnoreCase(r15.f15909a) == false) goto L17;
        if ("gzip".equalsIgnoreCase(r15.f15910b) == true) goto L8;
    L17:
        r13.add(r15);
    L19:
        if (TextUtils.isEmpty(r10) == true) goto L21;
        r13.add(new HttpHeader("If-Match", r10));
    L21:
        r13.add(new HttpHeader("Accept-Encoding", "identity"));
        if (r12 > 0) goto L24;
        Locale r16 = Locale.US;
        String r17 = "bytes=" + r11 + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD;
    L25:
        r13.add(new HttpHeader("Range", r17));
        if (Logger.b() == false) goto L28;
        StringBuilder r18 = a.K(r11, "CurrentOffset:", " EndOffset:");
        r18.append(r12);
        r18.append(", range = ");
        r18.append(r17);
        Logger.b("DownloadHelper", "addRangeHeader", r18.toString());
    L28:
        return r13;
    L24:
        Locale r19 = Locale.US;
        StringBuilder r20 = j0.t(r11, "bytes=", DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r20.append(r12);
        r17 = r20.toString();
        goto L25
    }

    public static boolean a() {
        Boolean r5 = d;
        if (r5 == null) goto L7;
        return r5.booleanValue();
    L7:
        monitor-enter(DownloadComponentManager.class);
        Context r10 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L21
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L21
        if (r10 != null) goto L13;
        return false;
    L13:
        String r11 = DownloadUtils.a(DownloadComponentManager.b());
        if (r11 != null) goto L16;
    L18:
        d = Boolean.FALSE;
    L20:
        return d.booleanValue();
    L16:
        if (r11.equals(DownloadComponentManager.b().getPackageName() + ":downloader") == false) goto L18;
        d = Boolean.TRUE;
    L21:
        th = move-exception;
        throw th;
    }

    public static void a(Throwable r5, String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L5;
        String r11 = r10;
    L7:
        if ((r5 instanceof BaseException) == false) goto L9;
        BaseException r12 = (BaseException) r5;
        StringBuilder r13 = j.d(r11, DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r13.append(r12.f15602b);
        r12.f15602b = r13.toString();
        throw r12;
    L9:
        if ((r5 instanceof SSLHandshakeException) == true) goto L82;
        if (r5 == null) goto L20;
        String r14 = DownloadUtils.a(r5);
        if ((r5 instanceof SocketTimeoutException) == true) goto L80;
        if (TextUtils.isEmpty(r14) == true) goto L20;
        if (r14.contains("time out") == true) goto L80;
        if (r14.contains("Time-out") == false) goto L20;
    L80:
        throw new BaseException(1048, DownloadUtils.a(r5, r11));
    L20:
        if (r5 == null) goto L29;
        DownloadComponentManager.s().getClass();
        String r15 = DownloadUtils.a(r5);
        if (TextUtils.isEmpty(r15) == true) goto L29;
        if (r15.contains("Precondition Failed") == false) goto L29;
        throw new DownloadHttpException(412, DownloadUtils.a(r5, r11));
    L29:
        if (r5 == null) goto L38;
        DownloadComponentManager.s().getClass();
        String r16 = DownloadUtils.a(r5);
        if (TextUtils.isEmpty(r16) == true) goto L38;
        if (r16.contains("Requested Range Not Satisfiable") == false) goto L38;
        throw new DownloadHttpException(416, DownloadUtils.a(r5, r11));
    L38:
        if (r5 == null) goto L55;
        String r17 = DownloadUtils.a(r5);
        if ((r5 instanceof DownloadHttpException) == false) goto L49;
        if (((DownloadHttpException) r5).d == 403) goto L54;
        if (TextUtils.isEmpty(r17) == true) goto L49;
        if (r17.contains("403") == false) goto L49;
    L54:
        throw new BaseException(1047, DownloadUtils.a(r5, r11));
    L49:
        if (TextUtils.isEmpty(r17) == true) goto L55;
        if (r17.contains("Forbidden") == true) goto L54;
    L55:
        if (r5 == null) goto L64;
        String r18 = DownloadUtils.a(r5);
        if (TextUtils.isEmpty(r18) == true) goto L64;
        if (r18.contains("network not available") == false) goto L64;
        throw new BaseException(1049, DownloadUtils.a(r5, r11));
    L64:
        if (r5 == null) goto L74;
        String r19 = DownloadUtils.a(r5);
        if (TextUtils.isEmpty(r19) == true) goto L74;
        if (r19.contains("Exception in connect") == false) goto L74;
        throw new BaseException(1041, DownloadUtils.a(r5, r11));
    L74:
        if ((r5 instanceof IOException) == false) goto L78;
        DownloadComponentManager.s().getClass();
        ITTNetHandler r20 = DownloadComponentManager.s();
        r5.getCause();
        r20.getClass();
        a((IOException) r5, r10);
        throw null;
    L78:
        throw new BaseException(1000, DownloadUtils.a(r5, r11));
    L82:
        throw new BaseException(PointerIconCompat.TYPE_COPY, DownloadUtils.a(r5, r11));
    L5:
        r11 = "";
        goto L7
    }

    public static void a(IOException r5, String r10) {
        String r11 = DownloadUtils.a(r5, r10);
        if ((r5 instanceof ConnectException) == true) goto L71;
        if ((r5 instanceof UnknownHostException) == true) goto L69;
        if ((r5 instanceof NoRouteToHostException) == true) goto L67;
        if ((r5 instanceof UnknownServiceException) == true) goto L65;
        if ((r5 instanceof PortUnreachableException) == true) goto L63;
        if ((r5 instanceof SocketTimeoutException) == true) goto L61;
        if ((r5 instanceof SocketException) == true) goto L59;
        if ((r5 instanceof HttpRetryException) == true) goto L57;
        if ((r5 instanceof ProtocolException) == true) goto L55;
        if ((r5 instanceof MalformedURLException) == true) goto L53;
        if ((r5 instanceof FileNotFoundException) == true) goto L51;
        if ((r5 instanceof InterruptedIOException) == true) goto L49;
        if ((r5 instanceof UnsupportedEncodingException) == true) goto L47;
        if ((r5 instanceof EOFException) == true) goto L45;
        if ((r5 instanceof StreamResetException) == true) goto L43;
        if ((r5 instanceof SSLException) == true) goto L41;
        if (DownloadUtils.b(r5) == false) goto L39;
        throw new BaseException(PointerIconCompat.TYPE_CELL, r11);
    L39:
        throw new BaseException(1023, r11);
    L41:
        throw new BaseException(PointerIconCompat.TYPE_COPY, r11);
    L43:
        throw new BaseException(1067, r11);
    L45:
        throw new BaseException(1066, r11);
    L47:
        throw new BaseException(1065, r11);
    L49:
        throw new BaseException(1064, r11);
    L51:
        throw new BaseException(1063, r11);
    L53:
        throw new BaseException(1062, r11);
    L55:
        throw new BaseException(1061, r11);
    L57:
        throw new BaseException(1060, r11);
    L59:
        throw new BaseException(1059, r11);
    L61:
        throw new BaseException(1048, r11);
    L63:
        throw new BaseException(1058, r11);
    L65:
        throw new BaseException(1057, r11);
    L67:
        throw new BaseException(1056, r11);
    L69:
        throw new BaseException(1055, r11);
    L71:
        throw new BaseException(1041, r11);
    }

    public static ListenerType a(int r5) {
        ListenerType r10 = ListenerType.f15280a;
        ListenerType r11 = ListenerType.f15281b;
        if (r5 != 1) goto L5;
        return r11;
    L5:
        ListenerType r12 = ListenerType.f15282c;
        if (r5 != 2) goto L8;
        return r12;
    L8:
        return r10;
    }

    public static DownloadInfo a(Cursor r10) {
        DownloadInfo.RawBuilder r5 = new DownloadInfo.RawBuilder();
        int r11 = r10.getColumnIndex("_id");     // Catch: Exception -> L6
        if (r11 == (-1)) goto L8;
        r5.K = r10.getInt(r11);     // Catch: Exception -> L6
    L8:
        int r12 = r10.getColumnIndex("name");     // Catch: Exception -> L6
        if (r12 == (-1)) goto L11;
        r5.f15851a = r10.getString(r12);     // Catch: Exception -> L6
    L11:
        int r13 = r10.getColumnIndex(Constant.TITLE);     // Catch: Exception -> L6
        if (r13 == (-1)) goto L14;
        r5.f15852b = r10.getString(r13);     // Catch: Exception -> L6
    L14:
        int r14 = r10.getColumnIndex("url");     // Catch: Exception -> L6
        if (r14 == (-1)) goto L17;
        r5.f15853c = r10.getString(r14);     // Catch: Exception -> L6
    L17:
        int r15 = r10.getColumnIndex("savePath");     // Catch: Exception -> L6
        if (r15 == (-1)) goto L20;
        r5.d = r10.getString(r15);     // Catch: Exception -> L6
    L20:
        int r16 = r10.getColumnIndex("tempPath");     // Catch: Exception -> L6
        if (r16 == (-1)) goto L23;
        r5.e = r10.getString(r16);     // Catch: Exception -> L6
    L23:
        int r17 = r10.getColumnIndex("chunkCount");     // Catch: Exception -> L6
        if (r17 == (-1)) goto L26;
        r5.L = r10.getInt(r17);     // Catch: Exception -> L6
    L26:
        int r18 = r10.getColumnIndex(NotificationCompat.CATEGORY_STATUS);     // Catch: Exception -> L6
        boolean r19 = false;
        if (r18 == (-1)) goto L29;
        r5.M = r10.getInt(r18);     // Catch: Exception -> L6
    L30:
        int r20 = r10.getColumnIndex("curBytes");     // Catch: Exception -> L6
        if (r20 == (-1)) goto L33;
        r5.N = r10.getLong(r20);     // Catch: Exception -> L6
    L34:
        int r21 = r10.getColumnIndex("backCurBytes");     // Catch: Exception -> L6
        if (r21 == (-1)) goto L37;
        r5.O = r10.getLong(r21);     // Catch: Exception -> L6
    L38:
        int r22 = r10.getColumnIndex("totalBytes");     // Catch: Exception -> L6
        if (r22 == (-1)) goto L41;
        r5.P = r10.getLong(r22);     // Catch: Exception -> L6
    L41:
        int r23 = r10.getColumnIndex("eTag");     // Catch: Exception -> L6
        if (r23 == (-1)) goto L44;
        r5.Z = r10.getString(r23);     // Catch: Exception -> L6
    L44:
        int r24 = r10.getColumnIndex("onlyWifi");     // Catch: Exception -> L6
        if (r24 != (-1)) goto L47;
    L51:
        int r25 = r10.getColumnIndex("force");     // Catch: Exception -> L6
        if (r25 != (-1)) goto L54;
    L58:
        int r26 = r10.getColumnIndex("retryCount");     // Catch: Exception -> L6
        if (r26 == (-1)) goto L61;
        r5.f15856j = r10.getInt(r26);     // Catch: Exception -> L6
    L61:
        int r27 = r10.getColumnIndex("extra");     // Catch: Exception -> L6
        if (r27 == (-1)) goto L64;
        r5.g = r10.getString(r27);     // Catch: Exception -> L6
    L64:
        int r28 = r10.getColumnIndex("mimeType");     // Catch: Exception -> L6
        if (r28 == (-1)) goto L67;
        r5.f15860n = r10.getString(r28);     // Catch: Exception -> L6
    L67:
        int r29 = r10.getColumnIndex("notificationEnable");     // Catch: Exception -> L6
        if (r29 != (-1)) goto L70;
    L74:
        int r30 = r10.getColumnIndex("notificationVisibility");     // Catch: Exception -> L6
        if (r30 == (-1)) goto L77;
        r5.Q = r10.getInt(r30);     // Catch: Exception -> L6
    L77:
        int r31 = r10.getColumnIndex("isFirstDownload");     // Catch: Exception -> L6
        if (r31 != (-1)) goto L80;
    L84:
        int r32 = r10.getColumnIndex("isFirstSuccess");     // Catch: Exception -> L6
        if (r32 != (-1)) goto L87;
    L91:
        int r33 = r10.getColumnIndex("needHttpsToHttpRetry");     // Catch: Exception -> L6
        if (r33 != (-1)) goto L94;
    L98:
        int r34 = r10.getColumnIndex("downloadTime");     // Catch: Exception -> L6
        if (r34 == (-1)) goto L101;
        r5.T = r10.getLong(r34);     // Catch: Exception -> L6
    L101:
        int r35 = r10.getColumnIndex("packageName");     // Catch: Exception -> L6
        if (r35 == (-1)) goto L104;
        r5.s = r10.getString(r35);     // Catch: Exception -> L6
    L104:
        int r36 = r10.getColumnIndex("md5");     // Catch: Exception -> L6
        if (r36 == (-1)) goto L107;
        r5.f15865t = r10.getString(r36);     // Catch: Exception -> L6
    L107:
        int r37 = r10.getColumnIndex("curRetryTime");     // Catch: Exception -> L6
        if (r37 == (-1)) goto L110;
        r5.V = r10.getInt(r37);     // Catch: Exception -> L6
    L110:
        int r38 = r10.getColumnIndex("defaultHttpServiceBackUp");     // Catch: Exception -> L6
        if (r38 != (-1)) goto L113;
    L117:
        int r39 = r10.getColumnIndex("backUpUrlsStr");     // Catch: Exception -> L6
        if (r39 == (-1)) goto L120;
        r5.W = r10.getString(r39);     // Catch: Exception -> L6
    L120:
        int r40 = r10.getColumnIndex("backUpUrlRetryCount");     // Catch: Exception -> L6
        if (r40 == (-1)) goto L123;
        r5.f15857k = r10.getInt(r40);     // Catch: Exception -> L6
    L123:
        int r41 = r10.getColumnIndex("realDownloadTime");     // Catch: Exception -> L6
        if (r41 == (-1)) goto L126;
        r5.X = r10.getLong(r41);     // Catch: Exception -> L6
    L126:
        int r42 = r10.getColumnIndex("realBackDownloadTime");     // Catch: Exception -> L6
        if (r42 == (-1)) goto L129;
        r5.U = r10.getLong(r42);     // Catch: Exception -> L6
    L129:
        int r43 = r10.getColumnIndex("independentProcess");     // Catch: Exception -> L6
        if (r43 != (-1)) goto L132;
    L136:
        int r44 = r10.getColumnIndex("auxiliaryJsonobjectString");     // Catch: Exception -> L6
        if (r44 == (-1)) goto L139;
        r5.Y = r10.getString(r44);     // Catch: Exception -> L6
    L139:
        int r45 = r10.getColumnIndex("iconUrl");     // Catch: Exception -> L6
        if (r45 == (-1)) goto L142;
        r5.f15867v = r10.getString(r45);     // Catch: Exception -> L6
    L142:
        int r46 = r10.getColumnIndex("appVersionCode");     // Catch: Exception -> L6
        if (r46 == (-1)) goto L145;
        r5.f15868w = r10.getInt(r46);     // Catch: Exception -> L6
    L145:
        int r47 = r10.getColumnIndex("downloadStartTimeStamp");     // Catch: Exception -> L6
        if (r47 == (-1)) goto L148;
        r5.f15872a0 = r10.getLong(r47);     // Catch: Exception -> L6
    L148:
        int r48 = r10.getColumnIndex("downloadFinishTimeStamp");     // Catch: Exception -> L6
        if (r48 == (-1)) goto L151;
        r5.f15873b0 = r10.getLong(r48);     // Catch: Exception -> L6
    L151:
        int r49 = r10.getColumnIndex("installedTimeStamp");     // Catch: Exception -> L6
        if (r49 == (-1)) goto L154;
        r5.f15874c0 = r10.getLong(r49);     // Catch: Exception -> L6
    L154:
        int r50 = r10.getColumnIndex("cacheLifeTimeMax");     // Catch: Exception -> L6
        if (r50 == (-1)) goto L157;
        r5.f15862p = r10.getLong(r50);     // Catch: Exception -> L6
    L157:
        int r51 = r10.getColumnIndex("hasDoInstallation");     // Catch: Exception -> L6
        if (r51 != (-1)) goto L160;
    L163:
        int r52 = r10.getColumnIndex("pcdnUrlsStr");     // Catch: Exception -> L6
        if (r52 == (-1)) goto L166;
        r5.f15876e0 = r10.getString(r52);     // Catch: Exception -> L6
    L166:
        int r53 = r10.getColumnIndex("cdnUrlsStr");     // Catch: Exception -> L6
        if (r53 == (-1)) goto L169;
        r5.f15877f0 = r10.getString(r53);     // Catch: Exception -> L6
    L169:
        int r54 = r10.getColumnIndex("monitorScene");     // Catch: Exception -> L6
        if (r54 == (-1)) goto L175;
        r5.f15871z = r10.getString(r54);     // Catch: Exception -> L6
    L175:
        return new DownloadInfo(r5);
    L160:
        if (r10.getInt(r51) != 1) goto L162;
        r19 = true;
    L162:
        r5.f15875d0 = r19;     // Catch: Exception -> L6
        goto L163
    L132:
        if (r10.getInt(r43) != 1) goto L134;
        boolean r55 = true;
    L135:
        r5.f15866u = r55;     // Catch: Exception -> L6
        goto L136
    L134:
        r55 = false;
        goto L135
    L113:
        if (r10.getInt(r38) != 1) goto L115;
        boolean r56 = true;
    L116:
        r5.f15864r = r56;     // Catch: Exception -> L6
        goto L117
    L115:
        r56 = false;
        goto L116
    L94:
        if (r10.getInt(r33) != 1) goto L96;
        boolean r57 = true;
    L97:
        r5.f15861o = r57;     // Catch: Exception -> L6
        goto L98
    L96:
        r57 = false;
        goto L97
    L87:
        if (r10.getInt(r32) != 1) goto L89;
        boolean r58 = true;
    L90:
        r5.S = r58;     // Catch: Exception -> L6
        goto L91
    L89:
        r58 = false;
        goto L90
    L80:
        if (r10.getInt(r31) != 1) goto L82;
        boolean r59 = true;
    L83:
        r5.R = r59;     // Catch: Exception -> L6
        goto L84
    L82:
        r59 = false;
        goto L83
    L70:
        if (r10.getInt(r29) == 0) goto L72;
        boolean r60 = true;
    L73:
        r5.f15859m = r60;     // Catch: Exception -> L6
        goto L74
    L72:
        r60 = false;
        goto L73
    L54:
        if (r10.getInt(r25) == 0) goto L56;
        boolean r61 = true;
    L57:
        r5.f15858l = r61;     // Catch: Exception -> L6
        goto L58
    L56:
        r61 = false;
        goto L57
    L47:
        if (r10.getInt(r24) == 0) goto L49;
        boolean r62 = true;
    L50:
        r5.f = r62;     // Catch: Exception -> L6
        goto L51
    L49:
        r62 = false;
        goto L50
    L37:
        r5.O = 0;     // Catch: Exception -> L6
        goto L38
    L33:
        r5.N = 0;     // Catch: Exception -> L6
        goto L34
    L29:
        r5.M = 0;     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L175
    }

    public static ContentValues a(DownloadInfo r5) {
        ContentValues r10 = new ContentValues();
        r10.put("_id", Integer.valueOf(r5.f15805a));
        r10.put("url", r5.d);
        r10.put("savePath", r5.e);
        r10.put("tempPath", r5.f);
        r10.put("name", r5.f15808b);
        r10.put("chunkCount", Integer.valueOf(r5.f15814e0));
        r10.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(r5.o()));
        r10.put("curBytes", Long.valueOf(r5.i()));
        AtomicLong r11 = r5.g0;
        if (r11 == null) goto L5;
        long r12 = r11.get();
    L6:
        r10.put("backCurBytes", Long.valueOf(r12));
        r10.put("totalBytes", Long.valueOf(r5.f15817h0));
        r10.put("eTag", r5.F);
        r10.put("onlyWifi", Integer.valueOf(r5.g ? 1 : 0));
        r10.put("force", Integer.valueOf(r5.f15828o ? 1 : 0));
        r10.put("retryCount", Integer.valueOf(r5.f15824m));
        r10.put("extra", r5.f15816h);
        r10.put("mimeType", r5.f15839u);
        r10.put(Constant.TITLE, r5.f15810c);
        r10.put("notificationEnable", Integer.valueOf(r5.f15837t ? 1 : 0));
        r10.put("notificationVisibility", Integer.valueOf(r5.f15813d0));
        r10.put("isFirstDownload", Integer.valueOf(r5.f15822k0 ? 1 : 0));
        r10.put("isFirstSuccess", Integer.valueOf(r5.l0 ? 1 : 0));
        r10.put("needHttpsToHttpRetry", Integer.valueOf(r5.f15841v ? 1 : 0));
        r10.put("downloadTime", Long.valueOf(r5.f15825m0));
        r10.put("packageName", r5.B);
        r10.put("md5", r5.C);
        r10.put("curRetryTime", Integer.valueOf(r5.G));
        r10.put("defaultHttpServiceBackUp", Integer.valueOf(r5.E ? 1 : 0));
        r10.put("chunkRunnableReuse", 0);
        r10.put("chunkDowngradeRetry", 0);
        if (r5.P0 != null) goto L9;
        r5.P0 = DownloadUtils.a(r5.s);
    L9:
        r10.put("backUpUrlsStr", r5.P0);
        r10.put("backUpUrlRetryCount", Integer.valueOf(r5.f15826n));
        r10.put("realDownloadTime", Long.valueOf(r5.f15827n0));
        r10.put("realBackDownloadTime", Long.valueOf(r5.f15829o0));
        r10.put("independentProcess", Integer.valueOf(r5.J ? 1 : 0));
        r10.put("auxiliaryJsonobjectString", r5.j());
        r10.put("iconUrl", r5.M);
        r10.put("appVersionCode", Integer.valueOf(r5.H0));
        r10.put("taskId", null);
        r10.put("downloadStartTimeStamp", Long.valueOf(r5.X));
        r10.put("downloadFinishTimeStamp", Long.valueOf(r5.Y));
        r10.put("installedTimeStamp", Long.valueOf(r5.Z));
        r10.put("hasDoInstallation", Integer.valueOf(r5.f15806a0 ? 1 : 0));
        r10.put("cacheLifeTimeMax", Long.valueOf(r5.f15843w));
        if (r5.f15849z != null) goto L12;
        r5.f15849z = DownloadUtils.a(r5.f15845x);
    L12:
        r10.put("pcdnUrlsStr", r5.f15849z);
        if (r5.A != null) goto L15;
        r5.A = DownloadUtils.a(r5.f15847y);
    L15:
        r10.put("cdnUrlsStr", r5.A);
        r10.put("monitorScene", r5.P);
        return r10;
    L5:
        r12 = 0;
        goto L6
    }

    public static void a(IDownloadHttpConnection r5, BaseException r10) {
        if (r5 != null) goto L4;
        return;
    L4:
        if ((r5 instanceof AbsDownloadHttpConnection) == true) goto L6;
        return;
    L6:
        if ((r10 instanceof DownloadTTNetException) == false) goto L38;
        AbsDownloadHttpConnection r11 = (AbsDownloadHttpConnection) r5;
        String r12 = "";
        if (TextUtils.isEmpty("") == true) goto L11;
        ((DownloadTTNetException) r10).d = "";
    L11:
        DownloadTTNetException r13 = (DownloadTTNetException) r10;
        String r14 = r13.d;
        if (r14 == null) goto L16;
        if ("0:".equals(r14) == true) goto L16;
        return;
    L16:
        if (TextUtils.isEmpty(r13.f15603c) == true) goto L36;
        String r15 = new JSONObject(r13.f15603c).getJSONObject("socket").optString("remote");     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r15) == true) goto L37;
        char[] r16 = DownloadUtils.f16142a;     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r15) == true) goto L26;
        int r17 = r15.lastIndexOf(":");     // Catch: Throwable -> L28
        if (r17 <= 0) goto L26;
        r12 = r15.substring(0, r17);     // Catch: Throwable -> L28
    L26:
        r13.d = r12;     // Catch: Throwable -> L28
        return;
    L37:
        return;
    L28:
        th = move-exception;
        th.printStackTrace();
        return;
    L36:
        return;
    }

    public static void a(String r5) {
        if (Logger.b() == true) goto L5;
        return;
    L5:
        if (DownloadUtils.a() == false) goto L9;
        Logger.c("DownloadHelper", "checkWorkerThread", "This method:" + r5 + " cannot be executed on the main thread");
        Context r10 = DownloadComponentManager.f15515a;
        return;
    }

    public static void a(String r5, String r10) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        if (r5.contains(r10) == true) goto L34;
        File r11 = new File(r5);
        if (r11.exists() == true) goto L10;
        return;
    L10:
        if (r11.isDirectory() == false) goto L35;
        File[] r12 = r11.listFiles();
        if (r12 != null) goto L15;
    L26:
        r11.delete();
        return;
    L15:
        if (r12.length == 0) goto L26;
        int r13 = r12.length;
        int r14 = 0;
    L17:
        if (r14 >= r13) goto L26;
        File r15 = r12[r14];
        if (r15.isFile() == false) goto L22;
        r15.delete();
    L25:
        r14 = r14 + 1;
        goto L17
    L22:
        if (r15.isDirectory() == false) goto L25;
        a(r15.getAbsolutePath(), r10);
        return;
    L35:
        return;
    }

    public static HashSet a(JSONArray r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.length() <= 0) goto L19;
        HashSet r10 = new HashSet();
        int r11 = 0;
    L16:
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        return r10;
    L8:
        if (r11 >= r5.length()) goto L13;
        r10.add(r5.getString(r11));     // Catch: JSONException -> L11
        r11 = r11 + 1;
        goto L16
    L19:
        return null;
    }

    public static boolean a(HashSet r5, HashSet r10, HashSet r11, String r12, String r13) {
        if (r5 != null) goto L5;
    L9:
        if (r10 != null) goto L11;
        return false;
    L11:
        if (r10.contains(r12) == true) goto L18;
        if (r11 != null) goto L14;
    L15:
        return true;
    L14:
        if (r11.contains(r13) == false) goto L15;
        return false;
    L18:
        return false;
    L5:
        if (TextUtils.isEmpty(r13) == true) goto L9;
        if (r5.contains(r13) == false) goto L9;
        return true;
    }

    public static void a(DownloadSetting r5, ArrayList r10, DownloadInfo r11) {
        long r12 = r11.I0;
        if (r12 <= 0) goto L5;
        r10.add(new HttpHeader("extra_throttle_net_speed", String.valueOf(r12)));
    L5:
        long r13 = r11.X0;
        if (r13 <= 300) goto L9;
        r10.add(new HttpHeader("extra_ttnet_protect_timeout", String.valueOf(r13)));
    L9:
        if (r11.Y0 == false) goto L12;
        r10.add(new HttpHeader("extra_ttnet_common_param", "true"));
    L12:
        if (r5.a("enable_download_network_tag", 0) <= 0) goto L14;
        r10.add(new HttpHeader("x-ttnet-req-biz-id", "dl"));
        r10.add(new HttpHeader("x-ttnet-req-biz-ver", "1.3.8.96"));
    L14:
        int r14 = r5.a("ttnet_proto_type", 0);
        if (r14 <= 0) goto L18;
        r10.add(new HttpHeader("x-ttnet-http-proto-type", String.valueOf(r14)));
        return;
    }
}
