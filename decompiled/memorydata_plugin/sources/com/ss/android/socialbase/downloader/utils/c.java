package com.ss.android.socialbase.downloader.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.ss.android.socialbase.downloader.BuildConfig;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.depend.ai;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.bduploader.BDVideoUploaderBase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.StreamResetException;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15652a = "c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile SparseArray<Boolean> f15653b;
    private static volatile SparseArray<List<ai>> c;
    private static Boolean d;
    private static Boolean e;

    static {
        f15653b = new SparseArray();
        c = new SparseArray();
    }

    public c() {
    }

    public static int a(double r2) {
        return (int) ((r2 * 1000.0d) / 8.0d);
    }

    public static long a(DownloadInfo r2) {
        if (r2 != null) goto L6;
        return -1;
    L6:
        return r2.getCurBytes();
    }

    public static long a(String r5) {
        if (r5 != null) goto L5;
        return -1;
    L5:
        String[] r6 = r5.split("/");
        if (r6.length >= 2) goto L13;
    L12:
        return -1;
    L13:
        return Long.parseLong(r6[1]);
    L10:
        e = move-exception;
        com.ss.android.socialbase.downloader.e.a.b(f15652a, "parseContentRangeOfInstanceLength", "Exception:" + e);
        goto L12
    }

    public static DownloadInfo a(Cursor r8) {
        Cursor r9 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r8, Cursor.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L5;
        DownloadInfo.b r0 = new DownloadInfo.b();
        int r1 = r9.getColumnIndex("_id");     // Catch: Exception -> L171
        if (r1 == (-1)) goto L10;
        r0.x = r9.getInt(r1);     // Catch: Exception -> L171
    L10:
        int r2 = r9.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Exception -> L171
        if (r2 == (-1)) goto L13;
        r0.b(r9.getString(r2));     // Catch: Exception -> L171
    L13:
        int r3 = r9.getColumnIndex("title");     // Catch: Exception -> L171
        if (r3 == (-1)) goto L16;
        r0.c(r9.getString(r3));     // Catch: Exception -> L171
    L16:
        int r4 = r9.getColumnIndex("url");     // Catch: Exception -> L171
        if (r4 == (-1)) goto L19;
        r0.d(r9.getString(r4));     // Catch: Exception -> L171
    L19:
        int r5 = r9.getColumnIndex("savePath");     // Catch: Exception -> L171
        if (r5 == (-1)) goto L22;
        r0.e(r9.getString(r5));     // Catch: Exception -> L171
    L22:
        int r6 = r9.getColumnIndex("tempPath");     // Catch: Exception -> L171
        if (r6 == (-1)) goto L25;
        r0.f(r9.getString(r6));     // Catch: Exception -> L171
    L25:
        int r7 = r9.getColumnIndex("chunkCount");     // Catch: Exception -> L171
        if (r7 == (-1)) goto L28;
        r0.y = r9.getInt(r7);     // Catch: Exception -> L171
    L28:
        int r10 = r9.getColumnIndex("status");     // Catch: Exception -> L171
        boolean r11 = false;
        if (r10 == (-1)) goto L31;
        r0.z = r9.getInt(r10);     // Catch: Exception -> L171
    L32:
        int r12 = r9.getColumnIndex("curBytes");     // Catch: Exception -> L171
        long r13 = 0;
        if (r12 == (-1)) goto L35;
        r0.A = r9.getLong(r12);     // Catch: Exception -> L171
    L36:
        int r14 = r9.getColumnIndex("backCurBytes");     // Catch: Exception -> L171
        if (r14 == (-1)) goto L39;
        r13 = r9.getLong(r14);     // Catch: Exception -> L171
    L39:
        r0.B = r13;     // Catch: Exception -> L171
        int r15 = r9.getColumnIndex("totalBytes");     // Catch: Exception -> L171
        if (r15 == (-1)) goto L42;
        r0.C = r9.getLong(r15);     // Catch: Exception -> L171
    L42:
        int r16 = r9.getColumnIndex("eTag");     // Catch: Exception -> L171
        if (r16 == (-1)) goto L45;
        r0.M = r9.getString(r16);     // Catch: Exception -> L171
    L45:
        int r17 = r9.getColumnIndex("onlyWifi");     // Catch: Exception -> L171
        if (r17 != (-1)) goto L48;
    L52:
        int r18 = r9.getColumnIndex("force");     // Catch: Exception -> L171
        if (r18 != (-1)) goto L55;
    L59:
        int r19 = r9.getColumnIndex("retryCount");     // Catch: Exception -> L171
        if (r19 == (-1)) goto L62;
        r0.b(r9.getInt(r19));     // Catch: Exception -> L171
    L62:
        int r20 = r9.getColumnIndex(WsConstants.KEY_EXTRA);     // Catch: Exception -> L171
        if (r20 == (-1)) goto L65;
        r0.g(r9.getString(r20));     // Catch: Exception -> L171
    L65:
        int r21 = r9.getColumnIndex("mimeType");     // Catch: Exception -> L171
        if (r21 == (-1)) goto L68;
        r0.h(r9.getString(r21));     // Catch: Exception -> L171
    L68:
        int r22 = r9.getColumnIndex("notificationEnable");     // Catch: Exception -> L171
        if (r22 != (-1)) goto L71;
    L75:
        int r23 = r9.getColumnIndex("notificationVisibility");     // Catch: Exception -> L171
        if (r23 == (-1)) goto L78;
        r0.D = r9.getInt(r23);     // Catch: Exception -> L171
    L78:
        int r24 = r9.getColumnIndex("isFirstDownload");     // Catch: Exception -> L171
        if (r24 != (-1)) goto L81;
    L85:
        int r25 = r9.getColumnIndex("isFirstSuccess");     // Catch: Exception -> L171
        if (r25 != (-1)) goto L88;
    L92:
        int r26 = r9.getColumnIndex("needHttpsToHttpRetry");     // Catch: Exception -> L171
        if (r26 != (-1)) goto L95;
    L99:
        int r27 = r9.getColumnIndex("downloadTime");     // Catch: Exception -> L171
        if (r27 == (-1)) goto L102;
        r0.G = r9.getLong(r27);     // Catch: Exception -> L171
    L102:
        int r28 = r9.getColumnIndex(ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Exception -> L171
        if (r28 == (-1)) goto L105;
        r0.i(r9.getString(r28));     // Catch: Exception -> L171
    L105:
        int r29 = r9.getColumnIndex("md5");     // Catch: Exception -> L171
        if (r29 == (-1)) goto L108;
        r0.j(r9.getString(r29));     // Catch: Exception -> L171
    L108:
        int r30 = r9.getColumnIndex("curRetryTime");     // Catch: Exception -> L171
        if (r30 == (-1)) goto L111;
        r0.I = r9.getInt(r30);     // Catch: Exception -> L171
    L111:
        int r31 = r9.getColumnIndex("defaultHttpServiceBackUp");     // Catch: Exception -> L171
        if (r31 != (-1)) goto L114;
    L118:
        int r32 = r9.getColumnIndex("backUpUrlsStr");     // Catch: Exception -> L171
        if (r32 == (-1)) goto L121;
        r0.f15558J = r9.getString(r32);     // Catch: Exception -> L171
    L121:
        int r33 = r9.getColumnIndex("backUpUrlRetryCount");     // Catch: Exception -> L171
        if (r33 == (-1)) goto L124;
        r0.c(r9.getInt(r33));     // Catch: Exception -> L171
    L124:
        int r34 = r9.getColumnIndex("realDownloadTime");     // Catch: Exception -> L171
        if (r34 == (-1)) goto L127;
        r0.K = r9.getLong(r34);     // Catch: Exception -> L171
    L127:
        int r35 = r9.getColumnIndex("realBackDownloadTime");     // Catch: Exception -> L171
        if (r35 == (-1)) goto L130;
        r0.H = r9.getLong(r35);     // Catch: Exception -> L171
    L130:
        int r36 = r9.getColumnIndex("independentProcess");     // Catch: Exception -> L171
        if (r36 != (-1)) goto L133;
    L137:
        int r37 = r9.getColumnIndex("auxiliaryJsonobjectString");     // Catch: Exception -> L171
        if (r37 == (-1)) goto L140;
        r0.L = r9.getString(r37);     // Catch: Exception -> L171
    L140:
        int r38 = r9.getColumnIndex("iconUrl");     // Catch: Exception -> L171
        if (r38 == (-1)) goto L143;
        r0.l(r9.getString(r38));     // Catch: Exception -> L171
    L143:
        int r39 = r9.getColumnIndex("appVersionCode");     // Catch: Exception -> L171
        if (r39 == (-1)) goto L146;
        r0.h(r9.getInt(r39));     // Catch: Exception -> L171
    L146:
        int r40 = r9.getColumnIndex("downloadStartTimeStamp");     // Catch: Exception -> L171
        if (r40 == (-1)) goto L149;
        r0.N = r9.getLong(r40);     // Catch: Exception -> L171
    L149:
        int r41 = r9.getColumnIndex("downloadFinishTimeStamp");     // Catch: Exception -> L171
        if (r41 == (-1)) goto L152;
        r0.O = r9.getLong(r41);     // Catch: Exception -> L171
    L152:
        int r42 = r9.getColumnIndex("installedTimeStamp");     // Catch: Exception -> L171
        if (r42 == (-1)) goto L155;
        r0.P = r9.getLong(r42);     // Catch: Exception -> L171
    L155:
        int r43 = r9.getColumnIndex("cacheLifeTimeMax");     // Catch: Exception -> L171
        if (r43 == (-1)) goto L158;
        r0.f(r9.getLong(r43));     // Catch: Exception -> L171
    L158:
        int r44 = r9.getColumnIndex("hasDoInstallation");     // Catch: Exception -> L171
        if (r44 != (-1)) goto L161;
    L164:
        int r45 = r9.getColumnIndex("pcdnUrlsStr");     // Catch: Exception -> L171
        if (r45 == (-1)) goto L167;
        r0.R = r9.getString(r45);     // Catch: Exception -> L171
    L167:
        int r46 = r9.getColumnIndex("cdnUrlsStr");     // Catch: Exception -> L171
        if (r46 == (-1)) goto L174;
        r0.S = r9.getString(r46);     // Catch: Exception -> L171
    L174:
        return r0.c();
    L161:
        if (r9.getInt(r44) != 1) goto L163;
        r11 = true;
    L163:
        r0.Q = r11;     // Catch: Exception -> L171
        goto L164
    L133:
        if (r9.getInt(r36) != 1) goto L135;
        boolean r47 = true;
    L136:
        r0.j(r47);     // Catch: Exception -> L171
        goto L137
    L135:
        r47 = false;
        goto L136
    L114:
        if (r9.getInt(r31) != 1) goto L116;
        boolean r48 = true;
    L117:
        r0.i(r48);     // Catch: Exception -> L171
        goto L118
    L116:
        r48 = false;
        goto L117
    L95:
        if (r9.getInt(r26) != 1) goto L97;
        boolean r49 = true;
    L98:
        r0.e(r49);     // Catch: Exception -> L171
        goto L99
    L97:
        r49 = false;
        goto L98
    L88:
        if (r9.getInt(r25) != 1) goto L90;
        boolean r50 = true;
    L91:
        r0.F = r50;     // Catch: Exception -> L171
        goto L92
    L90:
        r50 = false;
        goto L91
    L81:
        if (r9.getInt(r24) != 1) goto L83;
        boolean r51 = true;
    L84:
        r0.E = r51;     // Catch: Exception -> L171
        goto L85
    L83:
        r51 = false;
        goto L84
    L71:
        if (r9.getInt(r22) == 0) goto L73;
        boolean r52 = true;
    L74:
        r0.f(r52);     // Catch: Exception -> L171
        goto L75
    L73:
        r52 = false;
        goto L74
    L55:
        if (r9.getInt(r18) == 0) goto L57;
        boolean r53 = true;
    L58:
        r0.c(r53);     // Catch: Exception -> L171
        goto L59
    L57:
        r53 = false;
        goto L58
    L48:
        if (r9.getInt(r17) == 0) goto L50;
        boolean r54 = true;
    L51:
        r0.b(r54);     // Catch: Exception -> L171
        goto L52
    L50:
        r54 = false;
        goto L51
    L35:
        r0.A = 0;     // Catch: Exception -> L171
        goto L36
    L31:
        r0.z = 0;     // Catch: Exception -> L171
    L171:
        e = move-exception;
        e.printStackTrace();
        goto L174
    L5:
        return new DownloadInfo();
    }

    public static com.ss.android.socialbase.downloader.model.g a(DownloadInfo r8, String r9, String r10, int r11, boolean r12) {
        if (TextUtils.isEmpty(r9) == true) goto L59;
        if (TextUtils.isEmpty(r10) == true) goto L59;
        File r0 = new File(r9, r10);
        boolean r2 = false;
        if (r0.exists() == false) goto L14;
        if (r0.isDirectory() == false) goto L14;
        throw new BaseException(1035, new IOException(String.format("path is :%s, path is directory:%B:", new Object[]{r9, Boolean.valueOf(r0.isDirectory())})));
    L14:
        if (r0.exists() == true) goto L57;
        File r13 = new File(r9);     // Catch: IOException -> L53
        if (r13.exists() == false) goto L20;
        if (r13.isDirectory() == false) goto L20;
    L44:
        r0.createNewFile();     // Catch: IOException -> L53
    L20:
        if (r13.exists() == false) goto L22;
        r13.delete();     // Catch: IOException -> L53
        if (r13.mkdirs() == true) goto L52;
        if (r13.exists() == true) goto L52;
        throw new BaseException(1031, "download savePath is not directory:path=" + r9);     // Catch: IOException -> L53
    L52:
        throw new BaseException(1031, "download savePath is not directory:" + r9);     // Catch: IOException -> L53
    L22:
        if (r13.mkdirs() == true) goto L44;
        if (r13.exists() == true) goto L44;
        if (com.ss.android.socialbase.downloader.g.a.a(r8).a("opt_mkdir_failed", 0) != 1) goto L43;
        int r1 = 0;
    L29:
        if (r2 == true) goto L35;
        int r3 = r1 + 1;
        if (r1 >= 3) goto L35;
        Thread.sleep(10);     // Catch: InterruptedException -> L60 IOException -> L53
        r2 = r13.mkdirs();     // Catch: IOException -> L53
        r1 = r3;
    L35:
        if (r2 == true) goto L44;
        if (g.c(r8.getSavePath()) >= 16384) goto L41;
        throw new BaseException(1006, "download savePath directory can not created:" + r9);     // Catch: IOException -> L53
    L41:
        throw new BaseException(1030, "download savePath directory can not created:" + r9);     // Catch: IOException -> L53
    L43:
        throw new BaseException(1030, "download savePath directory can not created:" + r9);     // Catch: IOException -> L53
    L53:
        e = move-exception;
        throw new BaseException(1036, e);
    L57:
        return new com.ss.android.socialbase.downloader.model.g(r0, r11, r12);
    L59:
        throw new BaseException(PointerIconCompat.TYPE_GRABBING, new IOException("path must be not empty"));
    }

    public static String a(String r1, int r2) {
        if (r2 != 0) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return r1;
    L8:
        if (r1.length() > r2) goto L11;
        return r1;
    L11:
        return r1.substring(0, r2);
    }

    public static <K> HashMap<Integer, K> a(SparseArray<K> r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        HashMap<Integer, K> r0 = new HashMap();
        int r1 = r5.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        int r3 = r5.keyAt(r2);
        K r4 = r5.valueAt(r2);
        r0.put(Integer.valueOf(r3), r4);
        r2 = r2 + 1;
        goto L6
    L8:
        return r0;
    }

    public static HashMap<String, Integer> a(JSONObject r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        HashMap<String, Integer> r1 = new HashMap();
        Iterator<String> r2 = r6.keys();
    L7:
        if (r2.hasNext() == false) goto L12;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        r1.put(r3, Integer.valueOf(r6.optInt(r3, 0)));
        goto L7
    L12:
        if (r1.isEmpty() == false) goto L15;
        return null;
    L15:
        return r1;
    }

    public static List<HttpHeader> a(List<HttpHeader> r6, String r7, long r8, long r10) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        if (r9 == null) goto L19;
        if (r9.size() <= 0) goto L19;
        Iterator r11 = r9.iterator();
    L8:
        if (r11.hasNext() == false) goto L19;
        HttpHeader r3 = (HttpHeader) ZeusTransformUtils.preCheckCast(r11.next(), HttpHeader.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L8;
        if (NetConst.KEY_ACCEPT_ENCODING.equalsIgnoreCase(r3.getName()) == false) goto L17;
        if (NetConst.GZIP.equalsIgnoreCase(r3.getValue()) == true) goto L8;
    L17:
        r0.add(r3);
    L19:
        if (TextUtils.isEmpty(r7) == true) goto L21;
        r0.add(new HttpHeader("If-Match", r7));
    L21:
        r0.add(new HttpHeader(NetConst.KEY_ACCEPT_ENCODING, "identity"));
        if (r10 > 0) goto L24;
        String r12 = String.format(Locale.US, "bytes=%d-", new Object[]{Long.valueOf(r8)});
    L25:
        r0.add(new HttpHeader("Range", r12));
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L28;
        com.ss.android.socialbase.downloader.e.a.a(f15652a, "addRangeHeader", "CurrentOffset:" + r8 + " EndOffset:" + r10 + ", range = " + r12);
    L28:
        return r0;
    L24:
        r12 = String.format(Locale.US, "bytes=%d-%d", new Object[]{Long.valueOf(r8), Long.valueOf(r10)});
        goto L25
    }

    public static Map<Integer, DownloadInfo> a(List<DownloadInfo> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        return null;
    L6:
        HashMap r0 = new HashMap();
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        DownloadInfo r2 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r6.next(), DownloadInfo.class, "com.obric.memorydata.plugin");
        if (r2.getId() == 0) goto L8;
        r0.put(Integer.valueOf(r2.getId()), r2);
        goto L8
    L12:
        return r0;
    }

    private static Set<String> a(JSONArray r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (r3.length() <= 0) goto L19;
        HashSet r0 = new HashSet();
        int r1 = 0;
    L16:
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        return r0;
    L8:
        if (r1 >= r3.length()) goto L13;
        r0.add(r3.getString(r1));     // Catch: JSONException -> L11
        r1 = r1 + 1;
        goto L16
    L19:
        return null;
    }

    private static void a(int r5, boolean r6, BaseException r7) {
        SparseArray<Boolean> r0 = f15653b;
        monitor-enter(r0);
        List r1 = (List) ZeusTransformUtils.preCheckCast(c.get(r5), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r1 == null) goto L15;
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L20
    L8:
        if (r2.hasNext() == false) goto L15;
        ai r3 = (ai) ZeusTransformUtils.preCheckCast(r2.next(), ai.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r3 == null) goto L8;
        if (r6 == true) goto L12;
        r3.a(r7);     // Catch: Throwable -> L20
        goto L8
    L12:
        r3.a();     // Catch: Throwable -> L20
    L15:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L17;
        com.ss.android.socialbase.downloader.e.a.a(f15652a, r5, "handleTempSaveCallback", "Run");     // Catch: Throwable -> L20
    L17:
        f15653b.remove(r5);     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public static void a(Context r5, String r6, Uri r7) {
        ContentResolver r8 = ((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin")).getContentResolver();
        Closeable r0 = null;
        OutputStream r1 = null;
        r1 = null;
        r1 = null;
        Closeable r2 = null;
        FileInputStream r3 = new FileInputStream(new File(r6));     // Catch: Throwable -> L16 IOException -> L20
        if (r7 != null) goto L25;
    L9:
        if (r1 == null) goto L15;
        byte[] r9 = new byte[4096];     // Catch: Throwable -> L6 IOException -> L8
    L11:
        int r10 = r3.read(r9);     // Catch: Throwable -> L6 IOException -> L8
        if (r10 == (-1)) goto L15;
        r1.write(r9, 0, r10);     // Catch: Throwable -> L6 IOException -> L8
        goto L11
    L8:
        OutputStream r11 = r1;
        r2 = r3;
    L21:
        g.a(new Closeable[]{r2});
        g.a(new Closeable[]{r11});
        return;
    L6:
        th = th;
        OutputStream r12 = r1;
        r0 = r3;
    L18:
        g.a(new Closeable[]{r0});
        g.a(new Closeable[]{r12});
        throw th;
    L15:
        g.a(new Closeable[]{r3});
        g.a(new Closeable[]{r1});
        return;
    L25:
        r1 = r8.openOutputStream(r7);     // Catch: Throwable -> L6 IOException -> L8
        goto L9
    L20:
        r11 = null;
    L16:
        th = th;
        r12 = null;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K> void a(SparseArray<K> r4, Map<Integer, K> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L12;
        if (r4 == 0) goto L18;
        Iterator r7 = r6.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L19;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r0.getKey() == null) goto L8;
        r4.put(((Integer) ZeusTransformUtils.preCheckCast(r0.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue(), r0.getValue());
        goto L8
    L19:
        return;
    L18:
        return;
    }

    public static void a(com.ss.android.socialbase.downloader.g.a r4, List<HttpHeader> r5, DownloadInfo r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        long r0 = r6.getThrottleNetSpeed();
        if (r0 <= 0) goto L5;
        r7.add(new HttpHeader("extra_throttle_net_speed", String.valueOf(r0)));
    L5:
        long r1 = r6.getTtnetProtectTimeout();
        if (r1 <= 300) goto L9;
        r7.add(new HttpHeader("extra_ttnet_protect_timeout", String.valueOf(r1)));
    L9:
        if (r6.isAddTTNetCommonParam() == false) goto L12;
        r7.add(new HttpHeader("extra_ttnet_common_param", "true"));
    L12:
        if (r4.a("enable_download_network_tag", 0) <= 0) goto L14;
        r7.add(new HttpHeader(com.ss.android.socialbase.downloader.constants.c.f15354a, "dl"));
        r7.add(new HttpHeader(com.ss.android.socialbase.downloader.constants.c.f15355b, BuildConfig.DL_VERSION_NAME));
    L14:
        int r8 = r4.a("ttnet_proto_type", 0);
        if (r8 <= 0) goto L18;
        r7.add(new HttpHeader("x-ttnet-http-proto-type", String.valueOf(r8)));
        return;
    }

    public static void a(DownloadInfo r18, IDownloadMonitorDepend r19, ai r20) {
        IDownloadMonitorDepend r0 = (IDownloadMonitorDepend) ZeusTransformUtils.wrapperContextForParams(r19, IDownloadMonitorDepend.class, "com.obric.memorydata.plugin");
        ai r2 = (ai) ZeusTransformUtils.wrapperContextForParams(r20, ai.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.a(r18) == false) goto L109;
        com.ss.android.socialbase.downloader.e.a.a(f15652a, r18, "saveFileAsTargetName", "TargetName: " + r18.getTargetFilePath());
    L109:
        SparseArray<Boolean> r5 = f15653b;     // Catch: Throwable -> L100
        monitor-enter(r5);     // Catch: Throwable -> L100
    L97:
        th = move-exception;
        throw th;     // Catch: Throwable -> L100
    L9:
        if (f15653b.get(r18.getId()) != Boolean.TRUE) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L24;
        if (com.ss.android.socialbase.downloader.e.a.a(r18) == false) goto L16;
        com.ss.android.socialbase.downloader.e.a.a(f15652a, r18, "saveFileAsTargetName", "Has another same task is saving temp file");     // Catch: Throwable -> L97
    L16:
        if (r2 == null) goto L21;
        List<ai> r1 = (List) ZeusTransformUtils.preCheckCast(c.get(r18.getId()), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L97
        if (r1 != null) goto L20;
        r1 = new ArrayList();     // Catch: Throwable -> L97
        c.put(r18.getId(), r1);     // Catch: Throwable -> L97
    L20:
        r1.add(r2);     // Catch: Throwable -> L97
        r2.b();     // Catch: Throwable -> L97
    L21:
        monitor-exit(r5);     // Catch: Throwable -> L97
        return;
    L24:
        if (com.ss.android.socialbase.downloader.e.a.a(r18) == false) goto L26;
        com.ss.android.socialbase.downloader.e.a.a(f15652a, r18, "saveFileAsTargetName", "SaveTempFileStatusMap put id:" + r18.getId());     // Catch: Throwable -> L97
    L26:
        f15653b.put(r18.getId(), Boolean.TRUE);     // Catch: Throwable -> L97
        monitor-exit(r5);     // Catch: Throwable -> L97
        com.ss.android.socialbase.downloader.d.a r7 = new com.ss.android.socialbase.downloader.d.a(r18.getTempPath(), r18.getTempName());     // Catch: Throwable -> L100
        com.ss.android.socialbase.downloader.d.a r8 = new com.ss.android.socialbase.downloader.d.a(r18.getSavePath(), r18.getName());     // Catch: Throwable -> L100
        if (r18.isForce() == true) goto L63;
        if (com.ss.android.socialbase.downloader.d.b.a(r8) == false) goto L63;
        if (g.a(r18, r8) == false) goto L63;
        if (com.ss.android.socialbase.downloader.e.a.a(r18) == false) goto L37;
        com.ss.android.socialbase.downloader.e.a.a(f15652a, r18, "saveFileAsTargetName", "TargetFile exist");     // Catch: Throwable -> L100
    L37:
        long r14 = SystemClock.uptimeMillis();     // Catch: Throwable -> L100
        int r9 = g.a(r8, r18.getMd5());     // Catch: Throwable -> L100
        r18.setMd5Time(SystemClock.uptimeMillis() - r14);     // Catch: Throwable -> L100
        if (g.a(r9) == false) goto L47;
        if (com.ss.android.socialbase.downloader.e.a.a(r18) == false) goto L42;
        com.ss.android.socialbase.downloader.e.a.a(f15652a, r18, "saveFileAsTargetName", "TempFile not exist , targetFile exists and md5 check valid");     // Catch: Throwable -> L100
    L42:
        r18.setTTMd5CheckStatus(r9);     // Catch: Throwable -> L100
        if (r2 == null) goto L45;
        r2.a();     // Catch: Throwable -> L100
    L45:
        a(r18.getId(), true, null);     // Catch: Throwable -> L100
    L69:
        boolean r10 = false;
    L71:
        if (r10 == false) goto L111;
        int r3 = com.ss.android.socialbase.downloader.g.a.a(r18.getId()).a("download_finish_check_ttmd5", 2);     // Catch: BaseException -> L85 Throwable -> L100
        if (r3 <= 0) goto L84;
        long r15 = SystemClock.uptimeMillis();     // Catch: BaseException -> L85 Throwable -> L100
        int r11 = g.a(r7, r18.getMd5());     // Catch: BaseException -> L85 Throwable -> L100
        r18.setMd5Time(SystemClock.uptimeMillis() - r15);     // Catch: BaseException -> L85 Throwable -> L100
        r18.setTTMd5CheckStatus(r11);     // Catch: BaseException -> L85 Throwable -> L100
        if (r3 < 2) goto L84;
        if (g.a(r11) == true) goto L84;
        BaseException r4 = new BaseException(1034, g.b(r11));     // Catch: BaseException -> L85 Throwable -> L100
        if (r2 == null) goto L81;
        r2.a(r4);     // Catch: BaseException -> L85 Throwable -> L100
    L81:
        a(r18.getId(), false, r4);     // Catch: BaseException -> L85 Throwable -> L100
        g.b(r18, a.a(r18.getSavePath()));     // Catch: BaseException -> L85 Throwable -> L100
        return;
    L84:
        boolean r12 = !a(r7, r8);
        BaseException r13 = null;
    L87:
        if (r12 == false) goto L93;
        if (r13 != null) goto L90;
        r13 = new BaseException(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", new Object[]{r18.getTempPath(), r18.getTempName(), r18.getSavePath(), r18.getName()}));     // Catch: Throwable -> L100
    L90:
        if (r2 == null) goto L92;
        r2.a(r13);     // Catch: Throwable -> L100
    L92:
        a(r18.getId(), false, r13);     // Catch: Throwable -> L100
        return;
    L93:
        if (r2 == null) goto L95;
        r2.a();     // Catch: Throwable -> L100
    L95:
        a(r18.getId(), true, null);     // Catch: Throwable -> L100
        return;
    L85:
        e = move-exception;
        r13 = e;
        r12 = true;
        goto L87
    L111:
        return;
    L47:
        if (r7.b() == true) goto L52;
        BaseException r16 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", new Object[]{r18.getTempPath(), r18.getTempName(), r18.getSavePath(), r18.getName(), g.b(r9)}));     // Catch: Throwable -> L100
        if (r2 == null) goto L51;
        r2.a(r16);     // Catch: Throwable -> L100
    L51:
        a(r18.getId(), false, r16);     // Catch: Throwable -> L100
        r10 = false;
    L54:
        if (r8.delete() == true) goto L71;
        if (r10 == true) goto L58;
        if (r0 == null) goto L71;
        com.ss.android.socialbase.downloader.f.a.a(r0, r18, new BaseException(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), r18.getStatus());     // Catch: Throwable -> L100
        goto L71
    L58:
        BaseException r17 = new BaseException(1037, "delete targetPath file existed with md5 check invalid status:" + g.b(r9));     // Catch: Throwable -> L100
        if (r2 == null) goto L61;
        r2.a(r17);     // Catch: Throwable -> L100
    L61:
        int r21 = r18.getId();     // Catch: Throwable -> L100
    L68:
        a(r21, false, r17);     // Catch: Throwable -> L100
        goto L69
    L52:
        r10 = true;
    L63:
        if (r7.b() == true) goto L70;
        r17 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", new Object[]{r18.getTempPath(), r18.getTempName(), r18.getSavePath(), r18.getName()}));     // Catch: Throwable -> L100
        if (r2 == null) goto L67;
        r2.a(r17);     // Catch: Throwable -> L100
    L67:
        r21 = r18.getId();     // Catch: Throwable -> L100
        goto L68
    L70:
        r10 = true;
        goto L71
    L11:
        r6 = false;
    L100:
        th = move-exception;
        BaseException r22 = new BaseException(1038, g.a(th, "saveFileAsTargetName") + " " + Log.getStackTraceString(th));
        if (com.ss.android.socialbase.downloader.e.a.a(r18) == false) goto L104;
        com.ss.android.socialbase.downloader.e.a.a(f15652a, r18, "saveFileAsTargetName", "Error: " + r22);
    L104:
        if (r2 == null) goto L106;
        r2.a(r22);
    L106:
        a(r18.getId(), false, r22);
    }

    public static void a(DownloadInfo r5, String r6, String r7) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r7) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r6) == false) goto L8;
        return;
    L8:
        if (r7.equals(r5.getName()) == true) goto L28;
        com.ss.android.socialbase.downloader.d.a r8 = new com.ss.android.socialbase.downloader.d.a(r5.getSavePath(), r7);
        com.ss.android.socialbase.downloader.d.a r0 = new com.ss.android.socialbase.downloader.d.a(r5.getSavePath(), r5.getName());
        if (com.ss.android.socialbase.downloader.e.a.a(r5) == false) goto L14;
        com.ss.android.socialbase.downloader.e.a.a(f15652a, r5, "copyFileFromExistFileWithSameName", "ExistFile:" + r8.d() + " targetFile:" + r0.d());
    L14:
        if (r0.b() == false) goto L21;
        if (r0.e() == true) goto L21;
        throw new BaseException(1001, "targetPath file exists but read-only");
    L21:
        if ((!a(r8, r0, true)) == true) goto L24;
        return;
    L24:
        throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", new Object[]{r5.getSavePath(), r7, r5.getSavePath(), r5.getName()}));
    }

    public static void a(com.ss.android.socialbase.downloader.network.h r2, BaseException r3) {
        com.ss.android.socialbase.downloader.network.h r4 = (com.ss.android.socialbase.downloader.network.h) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.network.h.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, com.ss.android.socialbase.downloader.network.a.class) == false) goto L16;
        if (r3 != null) goto L8;
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r3, DownloadTTNetException.class) == false) goto L18;
        String r5 = ((com.ss.android.socialbase.downloader.network.a) ZeusTransformUtils.preCheckCast(r4, com.ss.android.socialbase.downloader.network.a.class, "com.obric.memorydata.plugin")).e();
        if (TextUtils.isEmpty(r5) == true) goto L13;
        ((DownloadTTNetException) ZeusTransformUtils.preCheckCast(r3, DownloadTTNetException.class, "com.obric.memorydata.plugin")).setRemoteIp(r5);
    L13:
        ((DownloadTTNetException) ZeusTransformUtils.preCheckCast(r3, DownloadTTNetException.class, "com.obric.memorydata.plugin")).parseRemoteIp();
        return;
    L18:
        return;
    }

    public static void a(IOException r1, String r2) {
        if (r2 != null) goto L4;
        r2 = "";
    L4:
        String r3 = g.a(r1, r2);
        if (ZeusTransformUtils.instanceOf(r1, ConnectException.class) == true) goto L73;
        if (ZeusTransformUtils.instanceOf(r1, UnknownHostException.class) == true) goto L71;
        if (ZeusTransformUtils.instanceOf(r1, NoRouteToHostException.class) == true) goto L69;
        if (ZeusTransformUtils.instanceOf(r1, UnknownServiceException.class) == true) goto L67;
        if (ZeusTransformUtils.instanceOf(r1, PortUnreachableException.class) == true) goto L65;
        if (ZeusTransformUtils.instanceOf(r1, SocketTimeoutException.class) == true) goto L63;
        if (ZeusTransformUtils.instanceOf(r1, SocketException.class) == true) goto L61;
        if (ZeusTransformUtils.instanceOf(r1, HttpRetryException.class) == true) goto L59;
        if (ZeusTransformUtils.instanceOf(r1, ProtocolException.class) == true) goto L57;
        if (ZeusTransformUtils.instanceOf(r1, MalformedURLException.class) == true) goto L55;
        if (ZeusTransformUtils.instanceOf(r1, FileNotFoundException.class) == true) goto L53;
        if (ZeusTransformUtils.instanceOf(r1, InterruptedIOException.class) == true) goto L51;
        if (ZeusTransformUtils.instanceOf(r1, UnsupportedEncodingException.class) == true) goto L49;
        if (ZeusTransformUtils.instanceOf(r1, EOFException.class) == true) goto L47;
        if (ZeusTransformUtils.instanceOf(r1, StreamResetException.class) == true) goto L45;
        if (ZeusTransformUtils.instanceOf(r1, SSLException.class) == true) goto L43;
        if (g.c(r1) == false) goto L41;
        throw new BaseException(1006, r3);
    L41:
        throw new BaseException(1023, r3);
    L43:
        throw new BaseException(1011, r3);
    L45:
        throw new BaseException(1067, r3);
    L47:
        throw new BaseException(1066, r3);
    L49:
        throw new BaseException(1065, r3);
    L51:
        throw new BaseException(1064, r3);
    L53:
        throw new BaseException(1063, r3);
    L55:
        throw new BaseException(1062, r3);
    L57:
        throw new BaseException(1061, r3);
    L59:
        throw new BaseException(1060, r3);
    L61:
        throw new BaseException(1059, r3);
    L63:
        throw new BaseException(1048, r3);
    L65:
        throw new BaseException(1058, r3);
    L67:
        throw new BaseException(1057, r3);
    L69:
        throw new BaseException(1056, r3);
    L71:
        throw new BaseException(1055, r3);
    L73:
        throw new BaseException(1041, r3);
    }

    public static void a(String r5, String r6) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        if (r5.contains(r6) == true) goto L34;
        File r0 = new File(r5);
        if (r0.exists() == true) goto L10;
        return;
    L10:
        if (r0.isDirectory() == false) goto L35;
        File[] r7 = r0.listFiles();
        if (r7 != null) goto L15;
    L26:
        r0.delete();
        return;
    L15:
        if (r7.length == 0) goto L26;
        int r1 = r7.length;
        int r2 = 0;
    L17:
        if (r2 >= r1) goto L26;
        File r3 = r7[r2];
        if (r3.isFile() == false) goto L22;
        r3.delete();
    L25:
        r2 = r2 + 1;
        goto L17
    L22:
        if (r3.isDirectory() == false) goto L25;
        a(r3.getAbsolutePath(), r6);
        return;
    L35:
        return;
    }

    public static void a(Throwable r4, String r5) {
        if (TextUtils.isEmpty(r5) == true) goto L5;
        String r0 = r5;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, BaseException.class) == false) goto L9;
        ((BaseException) ZeusTransformUtils.preCheckCast(r4, BaseException.class, "com.obric.memorydata.plugin")).setErrorMsg(r0 + "-" + ((BaseException) ZeusTransformUtils.preCheckCast(r4, BaseException.class, "com.obric.memorydata.plugin")).getErrorMessage());
        throw ((BaseException) ZeusTransformUtils.preCheckCast(r4, BaseException.class, "com.obric.memorydata.plugin"));
    L9:
        if (ZeusTransformUtils.instanceOf(r4, SSLHandshakeException.class) == true) goto L41;
        if (a(r4) == true) goto L39;
        if (e(r4) == true) goto L37;
        if (f(r4) == true) goto L35;
        if (b(r4) == true) goto L33;
        if (c(r4) == true) goto L31;
        if (d(r4) == true) goto L29;
        if (ZeusTransformUtils.instanceOf(r4, IOException.class) == false) goto L27;
        c(r4, r5);
        a((IOException) ZeusTransformUtils.preCheckCast(r4, IOException.class, "com.obric.memorydata.plugin"), r5);
        return;
    L27:
        throw new BaseException(1000, g.a(r4, r0));
    L29:
        throw new BaseException(1041, g.a(r4, r0));
    L31:
        throw new BaseException(1049, g.a(r4, r0));
    L33:
        throw new BaseException(1047, g.a(r4, r0));
    L35:
        throw new DownloadHttpException(1004, 416, g.a(r4, r0));
    L37:
        throw new DownloadHttpException(1004, BDVideoUploaderBase.KeyIsExternalReaderMode, g.a(r4, r0));
    L39:
        throw new BaseException(1048, g.a(r4, r0));
    L41:
        throw new BaseException(1011, g.a(r4, r0));
    L5:
        r0 = "";
        goto L7
    }

    public static void a(List<HttpHeader> r3, String r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L25;
        if (r4 == null) goto L26;
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L27;
        HttpHeader r0 = (HttpHeader) ZeusTransformUtils.preCheckCast(r6.next(), HttpHeader.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        if (TextUtils.isEmpty(r0.getName()) == true) goto L8;
        if (r0.getName().contains(r4) == false) goto L8;
        r6.remove();
        return;
    L27:
        return;
    L26:
        return;
    }

    public static <K, V> void a(Map<K, V> r3, List<V> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L12;
        if (r6 == null) goto L18;
        Iterator<Map.Entry<K, V>> r7 = r5.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L19;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r0.getKey() == null) goto L8;
        r6.add(r0.getValue());
        goto L8
    L19:
        return;
    L18:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void a(Map<K, V> r3, Map<K, V> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L12;
        if (r6 == 0) goto L18;
        Iterator<Map.Entry<K, V>> r7 = r5.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L19;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r0.getKey() == null) goto L8;
        r6.put(r0.getKey(), r0.getValue());
        goto L8
    L19:
        return;
    L18:
        return;
    }

    public static boolean a() {
        Boolean r0 = d;
        if (r0 != null) goto L5;
        boolean r1 = false;
        if (com.ss.android.socialbase.downloader.g.a.c().b("force_independent_process") <= 0) goto L13;
        Boolean r2 = false;
    L9:
        d = r2;
    L11:
        return r2.booleanValue();
    L13:
        if (com.ss.android.socialbase.downloader.g.a.c().b("force_main_process") <= 0) goto L16;
        r2 = true;
        goto L9
    L16:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) != null) goto L18;
        return true;
    L18:
        String r3 = g.e((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        if (r3 != null) goto L21;
    L23:
        if (r3 != null) goto L25;
    L22:
        d = Boolean.valueOf(r1);
        r2 = d;
        goto L11
    L25:
        if (r3.equals(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName()) == false) goto L22;
        r1 = true;
        goto L22
    L21:
        if (r3.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR) == false) goto L23;
    L5:
        return r0.booleanValue();
    }

    public static boolean a(int r1) {
        if (r1 != 200) goto L5;
    L9:
        return true;
    L5:
        if (r1 == 201) goto L9;
        if (r1 == 0) goto L9;
        return false;
    }

    public static boolean a(int r3, String r4) {
        if (r3 < 400) goto L6;
        return false;
    L6:
        if (r3 == 206) goto L11;
        if (r3 == 1) goto L11;
        if ("bytes".equals(r4) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean a(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (r4.checkCallingOrSelfPermission(r3) != 0) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean a(com.ss.android.socialbase.downloader.d.a r6, com.ss.android.socialbase.downloader.d.a r7) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a(f15652a, "moveFile", "DownloadFile Src:" + r6.d() + " Dest:" + r7.d());
    L6:
        if (com.ss.android.socialbase.downloader.d.b.b() == true) goto L8;
    L12:
        boolean r0 = r6.a(r7);
    L13:
        if (r0 == true) goto L22;
        r0 = a(r6, r7, true);
    L20:
        th = move-exception;
        th.printStackTrace();
        goto L22
    L16:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L18;
        com.ss.android.socialbase.downloader.e.a.a(f15652a, "moveFile", "Copy DownloadFile Src:" + r6.d() + " Dest:" + r7.d());     // Catch: Throwable -> L20
    L18:
        r6.delete();     // Catch: Throwable -> L20
    L22:
        return r0;
    L8:
        if (com.ss.android.socialbase.downloader.d.b.f(r6.k()) == true) goto L12;
        if (com.ss.android.socialbase.downloader.d.b.f(r7.k()) == false) goto L12;
        r0 = false;
        goto L13
    }

    public static boolean a(com.ss.android.socialbase.downloader.d.a r6, com.ss.android.socialbase.downloader.d.a r7, boolean r8) {
        if (r6 == null) goto L42;
        if (r7 == null) goto L42;
    L40:
        e = move-exception;
        throw e;
    L37:
        th = move-exception;
        a(th, "CopyFile");
        return false;
    L6:
        if (r6.b() == false) goto L42;
        if (r6.c() == true) goto L42;
        if (r6.k().equals(r7.k()) == true) goto L42;
        if (r7.m() == false) goto L25;
        File r1 = r7.j();     // Catch: Throwable -> L37 BaseException -> L40
        if (r1 == null) goto L25;
        if (r1.mkdirs() == true) goto L25;
        if (r1.isDirectory() == true) goto L25;
        throw new BaseException(1053, "Destination '" + r1 + "' directory cannot be created");     // Catch: Throwable -> L37 BaseException -> L40
    L25:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L28;
        com.ss.android.socialbase.downloader.e.a.a(f15652a, "copyFile", "SrcFile:" + r6.d() + " DestFile:" + r7.d());     // Catch: Throwable -> L37 BaseException -> L40
    L28:
        if (r7.b() == true) goto L30;
    L34:
        b(r6, r7, r8);     // Catch: Throwable -> L37 BaseException -> L40
        return true;
    L30:
        if (r7.e() == true) goto L34;
        throw new IOException("Destination '" + r7.k() + "' exists but is read-only");     // Catch: Throwable -> L37 BaseException -> L40
    L42:
        return false;
    }

    public static boolean a(BaseException r2) {
        if (r2 != null) goto L4;
    L12:
        return false;
    L4:
        if (r2.getErrorCode() != 1051) goto L6;
    L11:
        return true;
    L6:
        if (r2.getErrorCode() == 1027) goto L11;
        if (r2.getErrorCode() == 1026) goto L11;
        if (r2.getErrorCode() != 1044) goto L12;
        goto L11
    }

    public static boolean a(com.ss.android.socialbase.downloader.network.g r5) {
        com.ss.android.socialbase.downloader.network.g r6 = (com.ss.android.socialbase.downloader.network.g) ZeusTransformUtils.wrapperContextForParams(r5, com.ss.android.socialbase.downloader.network.g.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        return false;
    L6:
        if ("chunked".equals(r6.a("Transfer-Encoding")) == false) goto L8;
    L9:
        return true;
    L8:
        if (g.a(r6) == (-1)) goto L9;
        return false;
    }

    public static boolean a(Throwable r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        String r1 = g.a(r3);
        if (ZeusTransformUtils.instanceOf(r3, SocketTimeoutException.class) == false) goto L8;
    L13:
        return true;
    L8:
        if (TextUtils.isEmpty(r1) == false) goto L10;
        return false;
    L10:
        if (r1.contains("time out") == true) goto L13;
        if (r1.contains("Time-out") == true) goto L13;
        return false;
    }

    public static boolean a(Set<String> r2, Set<String> r3, Set<String> r4, String r5, String r6) {
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
    L9:
        if (r8 != null) goto L11;
    L16:
        return false;
    L11:
        if (r8.contains(r5) == true) goto L16;
        if (r9 != null) goto L14;
        return true;
    L14:
        if (r9.contains(r6) == true) goto L16;
        return true;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L9;
        if (r7.contains(r6) == false) goto L9;
        return true;
    }

    public static long b(DownloadInfo r6) {
        if (r6 != null) goto L5;
        return 0;
    L5:
        boolean r2 = r6.isFileDataValid();
        if (com.ss.android.socialbase.downloader.e.a.a(r6) == false) goto L8;
        com.ss.android.socialbase.downloader.e.a.a(f15652a, r6, "getCurByte", "ResumeAvailable:" + r2);
    L8:
        if (r2 == true) goto L10;
        return 0;
    L10:
        return r6.getCurBytes();
    }

    public static long b(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L13;
        return 0;
    L13:
        Matcher r4 = Pattern.compile("max-age=([0-9]+)").matcher(r3);     // Catch: Throwable -> L10
        if (r4.find() == false) goto L15;
        return Long.parseLong(r4.group(1));
    L15:
        return 0;
    L10:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public static ListenerType b(int r2) {
        ListenerType r0 = ListenerType.MAIN;
        if (r2 != ListenerType.SUB.ordinal()) goto L6;
        return ListenerType.SUB;
    L6:
        if (r2 == ListenerType.NOTIFICATION.ordinal()) goto L8;
        return r0;
    L8:
        return ListenerType.NOTIFICATION;
    }

    public static DownloadTTNetException b(Throwable r2, String r3) {
        DownloadTTNetException r0 = com.ss.android.socialbase.downloader.downloader.b.P().a(r2, null);
        if (r0 != null) goto L5;
        r0 = com.ss.android.socialbase.downloader.downloader.b.P().a(r2.getCause(), null);
    L5:
        if (r0 == null) goto L8;
        String r4 = g.a(r0, r3);
        return new DownloadTTNetException(r0.getErrorCode(), r4).setRequestLog(r0.getRequestLog()).setRemoteIp(r0.getRemoteIp());
    L8:
        return null;
    }

    private static void b(com.ss.android.socialbase.downloader.d.a r17, com.ss.android.socialbase.downloader.d.a r18, boolean r19) {
        if (r18.b() == false) goto L10;
        if (r18.c() == false) goto L10;
        throw new IOException("Destination '" + r18 + "' exists but is a directory");
    L10:
        if (Build.VERSION.SDK_INT >= 29) goto L12;
    L19:
        FileInputStream r1 = r17.h();
        FileChannel r8 = r1.getChannel();     // Catch: Throwable -> L86
        FileOutputStream r9 = r18.i();     // Catch: Throwable -> L74
        FileChannel r10 = r9.getChannel();     // Catch: Throwable -> L62
        long r11 = r8.size();     // Catch: Throwable -> L50
        long r15 = 0;
    L25:
        if (r15 >= r11) goto L35;
        long r2 = r11 - r15;     // Catch: Throwable -> L50
        if (r2 <= 31457280) goto L29;
        long r6 = 31457280;
    L30:
        long r3 = r10.transferFrom(r8, r15, r6);     // Catch: Throwable -> L50
    L32:
        if (r3 == 0) goto L35;
        r15 = r15 + r3;
        goto L25
    L29:
        r6 = r2;
    L35:
        if (r10 == null) goto L37;
        r10.close();     // Catch: Throwable -> L62
    L37:
        if (r9 == null) goto L39;
        r9.close();     // Catch: Throwable -> L74
    L39:
        if (r8 == null) goto L41;
        r8.close();     // Catch: Throwable -> L86
    L41:
        if (r1 == null) goto L43;
        r1.close();
    L43:
        long r4 = r17.a();
        long r5 = r18.a();
        if (r4 != r5) goto L49;
        if (r19 == false) goto L120;
        r18.a(r17.g());
        return;
    L120:
        return;
    L49:
        throw new IOException("Failed to copy full contents from '" + r17 + "' to '" + r18 + "' Expected length: " + r4 + " Actual: " + r5);
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        if (r10 == null) goto L121;
        r10.close();     // Catch: Throwable -> L58
    L122:
        throw th;     // Catch: Throwable -> L62
    L58:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L62
        throw th;     // Catch: Throwable -> L62
    L121:
        throw th;     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        throw th;     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        if (r9 == null) goto L123;
        r9.close();     // Catch: Throwable -> L70
    L124:
        throw th;     // Catch: Throwable -> L74
    L70:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L74
        throw th;     // Catch: Throwable -> L74
    L123:
        throw th;     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        throw th;     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        if (r8 == null) goto L125;
        r8.close();     // Catch: Throwable -> L82
    L126:
        throw th;     // Catch: Throwable -> L86
    L82:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L86
        throw th;     // Catch: Throwable -> L86
    L125:
        throw th;     // Catch: Throwable -> L86
    L86:
        th = move-exception;
        throw th;     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        if (r1 == null) goto L127;
        r1.close();     // Catch: Throwable -> L94
        throw th;
    L94:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L127:
        throw th;
    L12:
        if (com.ss.android.socialbase.downloader.d.b.f(r18.d()) == false) goto L19;
        Uri r7 = com.ss.android.socialbase.downloader.d.b.d(r18.d());
        if (r7 == null) goto L18;
        a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r17.d(), r7);
        return;
    L18:
        throw new IOException("Destination " + r18 + "exists but contentUri is null");
    }

    public static boolean b() {
        if (c() == false) goto L5;
    L9:
        return false;
    L5:
        if (com.ss.android.socialbase.downloader.downloader.b.c() == false) goto L9;
        if (com.ss.android.socialbase.downloader.impls.g.a(true).f() == false) goto L9;
        return true;
    }

    public static boolean b(BaseException r3) {
        if (ZeusTransformUtils.instanceOf(r3, DownloadHttpException.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (((DownloadHttpException) ZeusTransformUtils.preCheckCast(r3, DownloadHttpException.class, "com.obric.memorydata.plugin")).getHttpStatusCode() != 412) goto L7;
    L8:
        return true;
    L7:
        if (((DownloadHttpException) ZeusTransformUtils.preCheckCast(r3, DownloadHttpException.class, "com.obric.memorydata.plugin")).getHttpStatusCode() != 416) goto L9;
        goto L8
    }

    public static boolean b(Throwable r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        String r1 = g.a(r5);
        if (ZeusTransformUtils.instanceOf(r5, DownloadHttpException.class) == false) goto L17;
        DownloadHttpException r6 = (DownloadHttpException) ZeusTransformUtils.preCheckCast(r5, DownloadHttpException.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L12;
        if (r6.getHttpStatusCode() != 403) goto L12;
    L15:
        return true;
    L12:
        if (TextUtils.isEmpty(r1) == true) goto L17;
        if (r1.contains("403") == true) goto L15;
    L17:
        if (TextUtils.isEmpty(r1) == false) goto L19;
        return false;
    L19:
        if (r1.contains("Forbidden") == true) goto L21;
        return false;
    L21:
        return true;
    }

    public static boolean b(List<Pair<String, String>> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return false;
    L5:
        Iterator r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L14;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r7.next(), Pair.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2.second, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L7;
        if (((String) ZeusTransformUtils.preCheckCast(r2.second, String.class, "com.obric.memorydata.plugin")).toLowerCase().contains("hit") == false) goto L7;
        return true;
    L14:
        return false;
    }

    public static ContentValues c(DownloadInfo r4) {
        ContentValues r0 = new ContentValues();
        r0.put("_id", Integer.valueOf(r4.getRawId()));
        r0.put("url", r4.getUrl());
        r0.put("savePath", r4.getSavePath());
        r0.put("tempPath", r4.getRawTempPath());
        r0.put(ActivityLifecycle.NAME, r4.getName());
        r0.put("chunkCount", Integer.valueOf(r4.getChunkCount()));
        r0.put("status", Integer.valueOf(r4.getStatus()));
        r0.put("curBytes", Long.valueOf(r4.getCurBytes()));
        r0.put("backCurBytes", Long.valueOf(r4.getBackCurBytes()));
        r0.put("totalBytes", Long.valueOf(r4.getTotalBytes()));
        r0.put("eTag", r4.geteTag());
        r0.put("onlyWifi", Integer.valueOf(r4.isOnlyWifi() ? 1 : 0));
        r0.put("force", Integer.valueOf(r4.isForce() ? 1 : 0));
        r0.put("retryCount", Integer.valueOf(r4.getRetryCount()));
        r0.put(WsConstants.KEY_EXTRA, r4.getExtra());
        r0.put("mimeType", r4.getMimeType());
        r0.put("title", r4.getRawTitle());
        r0.put("notificationEnable", Integer.valueOf(r4.isShowNotification() ? 1 : 0));
        r0.put("notificationVisibility", Integer.valueOf(r4.getNotificationVisibility()));
        r0.put("isFirstDownload", Integer.valueOf(r4.getIsFirstDownload() ? 1 : 0));
        r0.put("isFirstSuccess", Integer.valueOf(r4.isFirstSuccess() ? 1 : 0));
        r0.put("needHttpsToHttpRetry", Integer.valueOf(r4.isNeedHttpsToHttpRetry() ? 1 : 0));
        r0.put("downloadTime", Long.valueOf(r4.getDownloadTime()));
        r0.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r4.getPackageName());
        r0.put("md5", r4.getMd5());
        r0.put("curRetryTime", Integer.valueOf(r4.getCurRetryTime()));
        r0.put("defaultHttpServiceBackUp", Integer.valueOf(r4.isNeedDefaultHttpServiceBackUp() ? 1 : 0));
        r0.put("chunkRunnableReuse", 0);
        r0.put("chunkDowngradeRetry", 0);
        r0.put("backUpUrlsStr", r4.getBackUpUrlsStr());
        r0.put("backUpUrlRetryCount", Integer.valueOf(r4.getBackUpUrlRetryCount()));
        r0.put("realDownloadTime", Long.valueOf(r4.getRawRealDownloadTime()));
        r0.put("realBackDownloadTime", Long.valueOf(r4.getRawRealBackDownloadTime()));
        r0.put("independentProcess", Integer.valueOf(r4.isNeedIndependentProcess() ? 1 : 0));
        r0.put("auxiliaryJsonobjectString", r4.getDBJsonDataString());
        r0.put("iconUrl", r4.getIconUrl());
        r0.put("appVersionCode", Integer.valueOf(r4.getAppVersionCode()));
        r0.put("taskId", null);
        r0.put("downloadStartTimeStamp", Long.valueOf(r4.getDownloadStartTimeStamp()));
        r0.put("downloadFinishTimeStamp", Long.valueOf(r4.getDownloadFinishTimeStamp()));
        r0.put("installedTimeStamp", Long.valueOf(r4.getInstalledTimeStamp()));
        r0.put("hasDoInstallation", Integer.valueOf(r4.isHasDoInstallation() ? 1 : 0));
        r0.put("cacheLifeTimeMax", Long.valueOf(r4.getCacheLifeTimeMax()));
        r0.put("pcdnUrlsStr", r4.getPcdnUrlsStr());
        r0.put("cdnUrlsStr", r4.getCdnUrlsStr());
        return r0;
    }

    public static void c(String r3) {
        if (com.ss.android.socialbase.downloader.e.a.a() == true) goto L5;
        return;
    L5:
        if (g.a() == false) goto L11;
        com.ss.android.socialbase.downloader.e.a.b(f15652a, "checkWorkerThread", "This method:" + r3 + " cannot be executed on the main thread");
        ae r0 = com.ss.android.socialbase.downloader.downloader.b.R();
        if (r0 == null) goto L12;
        r0.a(r3);
        return;
    L12:
        return;
    }

    private static void c(Throwable r0, String r1) {
        DownloadTTNetException r2 = b(r0, r1);
        if (r2 != null) goto L5;
        return;
    L5:
        throw r2;
    }

    public static boolean c() {
        Boolean r0 = e;
        if (r0 == null) goto L7;
        return r0.booleanValue();
    L7:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) != null) goto L9;
        return false;
    L9:
        String r1 = g.e((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        if (r1 != null) goto L12;
    L14:
        boolean r2 = false;
    L15:
        e = r2;
        return e.booleanValue();
    L12:
        if (r1.equals(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName() + ":downloader") == false) goto L14;
        r2 = true;
        goto L15
    }

    public static boolean c(BaseException r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.getErrorCode() != 1011) goto L8;
    L11:
        return true;
    L8:
        if (r3.getCause() != null) goto L10;
        return false;
    L10:
        if (ZeusTransformUtils.instanceOf(r3.getCause(), SSLHandshakeException.class) == true) goto L11;
        return false;
    }

    public static boolean c(Throwable r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        String r3 = g.a(r2);
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (r3.contains("network not available") == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static Set<String> d() {
        return a(com.ss.android.socialbase.downloader.g.a.c().f("skip_db_init_monitor_scene_list"));
    }

    public static boolean d(Throwable r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        String r3 = g.a(r2);
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (r3.contains("Exception in connect") == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static Set<String> e() {
        return a(com.ss.android.socialbase.downloader.g.a.c().f("skip_db_init_expect_mime_type"));
    }

    public static boolean e(Throwable r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (com.ss.android.socialbase.downloader.downloader.b.P().a(r4) != 412) goto L8;
        return true;
    L8:
        String r5 = g.a(r4);
        if (TextUtils.isEmpty(r5) == false) goto L11;
        return false;
    L11:
        if (r5.contains("Precondition Failed") == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static Set<String> f() {
        return a(com.ss.android.socialbase.downloader.g.a.c().f("db_init_monitor_scene_list"));
    }

    public static boolean f(Throwable r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (com.ss.android.socialbase.downloader.downloader.b.P().a(r4) != 416) goto L8;
        return true;
    L8:
        String r5 = g.a(r4);
        if (TextUtils.isEmpty(r5) == false) goto L11;
        return false;
    L11:
        if (r5.contains("Requested Range Not Satisfiable") == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static boolean g(Throwable r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (ZeusTransformUtils.instanceOf(r2, BaseException.class) == false) goto L8;
        if (((BaseException) ZeusTransformUtils.preCheckCast(r2, BaseException.class, "com.obric.memorydata.plugin")).getErrorCode() != 1083) goto L8;
        return true;
    }
}
