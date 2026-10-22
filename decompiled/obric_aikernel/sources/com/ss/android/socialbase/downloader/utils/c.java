package com.ss.android.socialbase.downloader.utils;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.PointerIconCompat;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import ib.b0;
import ib.h0;
import ib.l0;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8330a = "c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile SparseArray<Boolean> f8331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile SparseArray<List<l0>> f8332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Boolean f8333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Boolean f8334e;

    static {
        f8331b = new SparseArray();
        f8332c = new SparseArray();
    }

    public static boolean A() {
        Boolean r10 = f8334e;
        if (r10 == null) goto L7;
        return r10.booleanValue();
    L7:
        if (com.ss.android.socialbase.downloader.downloader.a.h() != null) goto L10;
        return false;
    L10:
        String r11 = g.q(com.ss.android.socialbase.downloader.downloader.a.h());
        if (r11 != null) goto L13;
    L15:
        Boolean r12 = Boolean.FALSE;
    L16:
        f8334e = r12;
        return f8334e.booleanValue();
    L13:
        if (r11.equals(com.ss.android.socialbase.downloader.downloader.a.h().getPackageName() + ":downloader") == false) goto L15;
        r12 = Boolean.TRUE;
        goto L16
    }

    public static boolean B(Throwable r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        String r11 = g.G(r10);
        if ((r10 instanceof DownloadHttpException) == false) goto L15;
        if (((DownloadHttpException) r10).getHttpStatusCode() != 403) goto L10;
    L13:
        return true;
    L10:
        if (TextUtils.isEmpty(r11) == true) goto L15;
        if (r11.contains("403") == true) goto L13;
    L15:
        if (TextUtils.isEmpty(r11) == false) goto L17;
        return false;
    L17:
        if (r11.contains("Forbidden") == true) goto L19;
        return false;
    L19:
        return true;
    }

    public static boolean C(BaseException r10) {
        if (r10 != null) goto L4;
    L12:
        return false;
    L4:
        if (r10.getErrorCode() != 1051) goto L6;
    L11:
        return true;
    L6:
        if (r10.getErrorCode() == 1027) goto L11;
        if (r10.getErrorCode() == 1026) goto L11;
        if (r10.getErrorCode() != 1044) goto L12;
        goto L11
    }

    public static boolean D(BaseException r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.getErrorCode() != 1011) goto L8;
    L11:
        return true;
    L8:
        if (r10.getCause() != null) goto L10;
        return false;
    L10:
        if ((r10.getCause() instanceof SSLHandshakeException) == true) goto L11;
        return false;
    }

    public static boolean E(Throwable r10) {
        if (r10 != null) goto L4;
    L8:
        return false;
    L4:
        if ((r10 instanceof BaseException) == false) goto L8;
        if (((BaseException) r10).getErrorCode() != 1083) goto L8;
        return true;
    }

    public static boolean F() {
        Boolean r10 = f8333d;
        if (r10 == null) goto L7;
        return r10.booleanValue();
    L7:
        if (rb.a.j().n("force_independent_process") <= 0) goto L13;
        Boolean r11 = Boolean.FALSE;
    L9:
        f8333d = r11;
    L11:
        return r11.booleanValue();
    L13:
        if (rb.a.j().n("force_main_process") <= 0) goto L15;
        r11 = Boolean.TRUE;
        goto L9
    L15:
        boolean r12 = true;
        if (com.ss.android.socialbase.downloader.downloader.a.h() != null) goto L18;
        return true;
    L18:
        String r13 = g.q(com.ss.android.socialbase.downloader.downloader.a.h());
        if (r13 != null) goto L21;
    L24:
        if (r13 != null) goto L26;
    L28:
        r12 = false;
    L29:
        Boolean r14 = Boolean.valueOf(r12);
    L23:
        f8333d = r14;
        r11 = f8333d;
        goto L11
    L26:
        if (r13.equals(com.ss.android.socialbase.downloader.downloader.a.h().getPackageName()) == false) goto L28;
    L21:
        if (r13.contains(":") == false) goto L24;
        r14 = Boolean.FALSE;
        goto L23
    }

    public static boolean G(Throwable r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        String r11 = g.G(r10);
        if (TextUtils.isEmpty(r11) == false) goto L8;
        return false;
    L8:
        if (r11.contains("network not available") == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean H(Throwable r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (com.ss.android.socialbase.downloader.downloader.a.U().b(r10) != 412) goto L8;
        return true;
    L8:
        String r11 = g.G(r10);
        if (TextUtils.isEmpty(r11) == false) goto L11;
        return false;
    L11:
        if (r11.contains("Precondition Failed") == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static boolean I(Throwable r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (com.ss.android.socialbase.downloader.downloader.a.U().b(r10) != 416) goto L8;
        return true;
    L8:
        String r11 = g.G(r10);
        if (TextUtils.isEmpty(r11) == false) goto L11;
        return false;
    L11:
        if (r11.contains("Requested Range Not Satisfiable") == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static boolean J(BaseException r10) {
        if ((r10 instanceof DownloadHttpException) == false) goto L9;
        DownloadHttpException r11 = (DownloadHttpException) r10;
        if (r11.getHttpStatusCode() != 412) goto L7;
    L8:
        return true;
    L7:
        if (r11.getHttpStatusCode() == 416) goto L8;
    L9:
        return false;
    }

    public static boolean K(int r10) {
        if (r10 != 200) goto L5;
    L9:
        return true;
    L5:
        if (r10 == 201) goto L9;
        if (r10 == 0) goto L9;
        return false;
    }

    public static boolean L(Throwable r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        String r11 = g.G(r10);
        if ((r10 instanceof SocketTimeoutException) == false) goto L8;
    L13:
        return true;
    L8:
        if (TextUtils.isEmpty(r11) == false) goto L10;
        return false;
    L10:
        if (r11.contains("time out") == true) goto L13;
        if (r11.contains("Time-out") == true) goto L13;
        return false;
    }

    public static HashMap<String, Integer> M(JSONObject r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        HashMap<String, Integer> r11 = new HashMap();
        Iterator<String> r12 = r10.keys();
    L7:
        if (r12.hasNext() == false) goto L12;
        String r13 = r12.next();
        if (r13 == null) goto L7;
        r11.put(r13, Integer.valueOf(r10.optInt(r13, 0)));
        goto L7
    L12:
        if (r11.isEmpty() == false) goto L15;
        return null;
    L15:
        return r11;
    }

    public static Map<Integer, DownloadInfo> N(List<DownloadInfo> r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        HashMap r11 = new HashMap();
        Iterator<DownloadInfo> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        DownloadInfo r13 = r12.next();
        if (r13.getId() == 0) goto L7;
        r11.put(Integer.valueOf(r13.getId()), r13);
        goto L7
    L11:
        return r11;
    }

    public static <K, V> void O(Map<K, V> r10, List<V> r11) {
        if (r10 == null) goto L11;
        if (r11 == null) goto L17;
        Iterator<Map.Entry<K, V>> r12 = r10.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L18;
        Map.Entry<K, V> r13 = r12.next();
        if (r13.getKey() == null) goto L7;
        r11.add(r13.getValue());
        goto L7
    L18:
        return;
    L17:
        return;
    }

    public static boolean P(kb.a r10, kb.a r11) {
        if (lb.a.a() == false) goto L6;
        lb.a.b(f8330a, "moveFile", "DownloadFile Src:" + r10.getPath() + " Dest:" + r11.getPath());
    L6:
        if (kb.b.q() == true) goto L8;
    L12:
        boolean r12 = r10.f(r11);
    L13:
        if (r12 == true) goto L22;
        r12 = g(r10, r11, true);
    L20:
        th = move-exception;
        th.printStackTrace();
        goto L22
    L16:
        if (lb.a.a() == false) goto L18;
        lb.a.b(f8330a, "moveFile", "Copy DownloadFile Src:" + r10.getPath() + " Dest:" + r11.getPath());     // Catch: Throwable -> L20
    L18:
        r10.l();     // Catch: Throwable -> L20
    L22:
        return r12;
    L8:
        if (kb.b.o(r10.d()) == true) goto L12;
        if (kb.b.o(r11.d()) == false) goto L12;
        r12 = false;
        goto L13
    }

    public static boolean Q() {
        if (A() == false) goto L5;
    L9:
        return false;
    L5:
        if (com.ss.android.socialbase.downloader.downloader.a.X() == false) goto L9;
        if (com.ss.android.socialbase.downloader.impls.g.a(true).A() == false) goto L9;
        return true;
    }

    public static long R(String r10) {
        if (r10 != null) goto L5;
        return -1;
    L5:
        String[] r11 = r10.split("/");
        if (r11.length >= 2) goto L13;
    L12:
        return -1;
    L13:
        return Long.parseLong(r11[1]);
    L10:
        e = move-exception;
        lb.a.c(f8330a, "parseContentRangeOfInstanceLength", "Exception:" + e);
        goto L12
    }

    public static DownloadInfo S(Cursor r10) {
        if (r10 == null) goto L4;
        DownloadInfo.c r11 = new DownloadInfo.c();
        int r12 = r10.getColumnIndex("_id");     // Catch: Exception -> L170
        if (r12 == (-1)) goto L9;
        r11.f8123i0 = r10.getInt(r12);     // Catch: Exception -> L170
    L9:
        int r13 = r10.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Exception -> L170
        if (r13 == (-1)) goto L12;
        r11.V(r10.getString(r13));     // Catch: Exception -> L170
    L12:
        int r14 = r10.getColumnIndex("title");     // Catch: Exception -> L170
        if (r14 == (-1)) goto L15;
        r11.g0(r10.getString(r14));     // Catch: Exception -> L170
    L15:
        int r15 = r10.getColumnIndex("url");     // Catch: Exception -> L170
        if (r15 == (-1)) goto L18;
        r11.h0(r10.getString(r15));     // Catch: Exception -> L170
    L18:
        int r16 = r10.getColumnIndex("savePath");     // Catch: Exception -> L170
        if (r16 == (-1)) goto L21;
        r11.d0(r10.getString(r16));     // Catch: Exception -> L170
    L21:
        int r17 = r10.getColumnIndex("tempPath");     // Catch: Exception -> L170
        if (r17 == (-1)) goto L24;
        r11.f0(r10.getString(r17));     // Catch: Exception -> L170
    L24:
        int r18 = r10.getColumnIndex("chunkCount");     // Catch: Exception -> L170
        if (r18 == (-1)) goto L27;
        r11.f8124j0 = r10.getInt(r18);     // Catch: Exception -> L170
    L27:
        int r19 = r10.getColumnIndex("status");     // Catch: Exception -> L170
        boolean r20 = false;
        if (r19 == (-1)) goto L30;
        r11.f8125k0 = r10.getInt(r19);     // Catch: Exception -> L170
    L31:
        int r21 = r10.getColumnIndex("curBytes");     // Catch: Exception -> L170
        long r22 = 0;
        if (r21 == (-1)) goto L34;
        r11.f8126l0 = r10.getLong(r21);     // Catch: Exception -> L170
    L35:
        int r23 = r10.getColumnIndex("backCurBytes");     // Catch: Exception -> L170
        if (r23 == (-1)) goto L38;
        r22 = r10.getLong(r23);     // Catch: Exception -> L170
    L38:
        r11.f8127m0 = r22;     // Catch: Exception -> L170
        int r24 = r10.getColumnIndex("totalBytes");     // Catch: Exception -> L170
        if (r24 == (-1)) goto L41;
        r11.f8128n0 = r10.getLong(r24);     // Catch: Exception -> L170
    L41:
        int r25 = r10.getColumnIndex("eTag");     // Catch: Exception -> L170
        if (r25 == (-1)) goto L44;
        r11.f8138x0 = r10.getString(r25);     // Catch: Exception -> L170
    L44:
        int r26 = r10.getColumnIndex("onlyWifi");     // Catch: Exception -> L170
        if (r26 != (-1)) goto L47;
    L51:
        int r27 = r10.getColumnIndex("force");     // Catch: Exception -> L170
        if (r27 != (-1)) goto L54;
    L58:
        int r28 = r10.getColumnIndex("retryCount");     // Catch: Exception -> L170
        if (r28 == (-1)) goto L61;
        r11.c0(r10.getInt(r28));     // Catch: Exception -> L170
    L61:
        int r29 = r10.getColumnIndex(WsConstants.KEY_EXTRA);     // Catch: Exception -> L170
        if (r29 == (-1)) goto L64;
        r11.Q(r10.getString(r29));     // Catch: Exception -> L170
    L64:
        int r30 = r10.getColumnIndex("mimeType");     // Catch: Exception -> L170
        if (r30 == (-1)) goto L67;
        r11.U(r10.getString(r30));     // Catch: Exception -> L170
    L67:
        int r31 = r10.getColumnIndex("notificationEnable");     // Catch: Exception -> L170
        if (r31 != (-1)) goto L70;
    L74:
        int r32 = r10.getColumnIndex("notificationVisibility");     // Catch: Exception -> L170
        if (r32 == (-1)) goto L77;
        r11.f8129o0 = r10.getInt(r32);     // Catch: Exception -> L170
    L77:
        int r33 = r10.getColumnIndex("isFirstDownload");     // Catch: Exception -> L170
        if (r33 != (-1)) goto L80;
    L84:
        int r34 = r10.getColumnIndex("isFirstSuccess");     // Catch: Exception -> L170
        if (r34 != (-1)) goto L87;
    L91:
        int r35 = r10.getColumnIndex("needHttpsToHttpRetry");     // Catch: Exception -> L170
        if (r35 != (-1)) goto L94;
    L98:
        int r36 = r10.getColumnIndex("downloadTime");     // Catch: Exception -> L170
        if (r36 == (-1)) goto L101;
        r11.f8132r0 = r10.getLong(r36);     // Catch: Exception -> L170
    L101:
        int r37 = r10.getColumnIndex("packageName");     // Catch: Exception -> L170
        if (r37 == (-1)) goto L104;
        r11.b0(r10.getString(r37));     // Catch: Exception -> L170
    L104:
        int r38 = r10.getColumnIndex("md5");     // Catch: Exception -> L170
        if (r38 == (-1)) goto L107;
        r11.T(r10.getString(r38));     // Catch: Exception -> L170
    L107:
        int r39 = r10.getColumnIndex("curRetryTime");     // Catch: Exception -> L170
        if (r39 == (-1)) goto L110;
        r11.f8134t0 = r10.getInt(r39);     // Catch: Exception -> L170
    L110:
        int r40 = r10.getColumnIndex("defaultHttpServiceBackUp");     // Catch: Exception -> L170
        if (r40 != (-1)) goto L113;
    L117:
        int r41 = r10.getColumnIndex("backUpUrlsStr");     // Catch: Exception -> L170
        if (r41 == (-1)) goto L120;
        r11.f8135u0 = r10.getString(r41);     // Catch: Exception -> L170
    L120:
        int r42 = r10.getColumnIndex("backUpUrlRetryCount");     // Catch: Exception -> L170
        if (r42 == (-1)) goto L123;
        r11.M(r10.getInt(r42));     // Catch: Exception -> L170
    L123:
        int r43 = r10.getColumnIndex("realDownloadTime");     // Catch: Exception -> L170
        if (r43 == (-1)) goto L126;
        r11.f8136v0 = r10.getLong(r43);     // Catch: Exception -> L170
    L126:
        int r44 = r10.getColumnIndex("realBackDownloadTime");     // Catch: Exception -> L170
        if (r44 == (-1)) goto L129;
        r11.f8133s0 = r10.getLong(r44);     // Catch: Exception -> L170
    L129:
        int r45 = r10.getColumnIndex("independentProcess");     // Catch: Exception -> L170
        if (r45 != (-1)) goto L132;
    L136:
        int r46 = r10.getColumnIndex("auxiliaryJsonobjectString");     // Catch: Exception -> L170
        if (r46 == (-1)) goto L139;
        r11.f8137w0 = r10.getString(r46);     // Catch: Exception -> L170
    L139:
        int r47 = r10.getColumnIndex("iconUrl");     // Catch: Exception -> L170
        if (r47 == (-1)) goto L142;
        r11.S(r10.getString(r47));     // Catch: Exception -> L170
    L142:
        int r48 = r10.getColumnIndex("appVersionCode");     // Catch: Exception -> L170
        if (r48 == (-1)) goto L145;
        r11.K(r10.getInt(r48));     // Catch: Exception -> L170
    L145:
        int r49 = r10.getColumnIndex("downloadStartTimeStamp");     // Catch: Exception -> L170
        if (r49 == (-1)) goto L148;
        r11.f8139y0 = r10.getLong(r49);     // Catch: Exception -> L170
    L148:
        int r50 = r10.getColumnIndex("downloadFinishTimeStamp");     // Catch: Exception -> L170
        if (r50 == (-1)) goto L151;
        r11.f8140z0 = r10.getLong(r50);     // Catch: Exception -> L170
    L151:
        int r51 = r10.getColumnIndex("installedTimeStamp");     // Catch: Exception -> L170
        if (r51 == (-1)) goto L154;
        r11.A0 = r10.getLong(r51);     // Catch: Exception -> L170
    L154:
        int r52 = r10.getColumnIndex("cacheLifeTimeMax");     // Catch: Exception -> L170
        if (r52 == (-1)) goto L157;
        r11.O(r10.getLong(r52));     // Catch: Exception -> L170
    L157:
        int r53 = r10.getColumnIndex("hasDoInstallation");     // Catch: Exception -> L170
        if (r53 != (-1)) goto L160;
    L163:
        int r54 = r10.getColumnIndex("pcdnUrlsStr");     // Catch: Exception -> L170
        if (r54 == (-1)) goto L166;
        r11.C0 = r10.getString(r54);     // Catch: Exception -> L170
    L166:
        int r55 = r10.getColumnIndex("cdnUrlsStr");     // Catch: Exception -> L170
        if (r55 == (-1)) goto L173;
        r11.D0 = r10.getString(r55);     // Catch: Exception -> L170
    L173:
        return r11.N();
    L160:
        if (r10.getInt(r53) != 1) goto L162;
        r20 = true;
    L162:
        r11.B0 = r20;     // Catch: Exception -> L170
        goto L163
    L132:
        if (r10.getInt(r45) != 1) goto L134;
        boolean r56 = true;
    L135:
        r11.Z(r56);     // Catch: Exception -> L170
        goto L136
    L134:
        r56 = false;
        goto L135
    L113:
        if (r10.getInt(r40) != 1) goto L115;
        boolean r57 = true;
    L116:
        r11.X(r57);     // Catch: Exception -> L170
        goto L117
    L115:
        r57 = false;
        goto L116
    L94:
        if (r10.getInt(r35) != 1) goto L96;
        boolean r58 = true;
    L97:
        r11.Y(r58);     // Catch: Exception -> L170
        goto L98
    L96:
        r58 = false;
        goto L97
    L87:
        if (r10.getInt(r34) != 1) goto L89;
        boolean r59 = true;
    L90:
        r11.f8131q0 = r59;     // Catch: Exception -> L170
        goto L91
    L89:
        r59 = false;
        goto L90
    L80:
        if (r10.getInt(r33) != 1) goto L82;
        boolean r60 = true;
    L83:
        r11.f8130p0 = r60;     // Catch: Exception -> L170
        goto L84
    L82:
        r60 = false;
        goto L83
    L70:
        if (r10.getInt(r31) == 0) goto L72;
        boolean r61 = true;
    L73:
        r11.e0(r61);     // Catch: Exception -> L170
        goto L74
    L72:
        r61 = false;
        goto L73
    L54:
        if (r10.getInt(r27) == 0) goto L56;
        boolean r62 = true;
    L57:
        r11.R(r62);     // Catch: Exception -> L170
        goto L58
    L56:
        r62 = false;
        goto L57
    L47:
        if (r10.getInt(r26) == 0) goto L49;
        boolean r63 = true;
    L50:
        r11.a0(r63);     // Catch: Exception -> L170
        goto L51
    L49:
        r63 = false;
        goto L50
    L34:
        r11.f8126l0 = 0;     // Catch: Exception -> L170
        goto L35
    L30:
        r11.f8125k0 = 0;     // Catch: Exception -> L170
    L170:
        e = move-exception;
        e.printStackTrace();
        goto L173
    L4:
        return new DownloadInfo();
    }

    public static void T(Throwable r10, String r11) {
        if (TextUtils.isEmpty(r11) == true) goto L5;
        String r12 = r11;
    L7:
        if ((r10 instanceof BaseException) == false) goto L9;
        BaseException r13 = (BaseException) r10;
        r13.setErrorMsg(r12 + "-" + r13.getErrorMessage());
        throw r13;
    L9:
        if ((r10 instanceof SSLHandshakeException) == true) goto L41;
        if (L(r10) == true) goto L39;
        if (H(r10) == true) goto L37;
        if (I(r10) == true) goto L35;
        if (B(r10) == true) goto L33;
        if (G(r10) == true) goto L31;
        if (z(r10) == true) goto L29;
        if ((r10 instanceof IOException) == false) goto L27;
        W(r10, r11);
        U((IOException) r10, r11);
        return;
    L27:
        throw new BaseException(1000, g.w(r10, r12));
    L29:
        throw new BaseException(1041, g.w(r10, r12));
    L31:
        throw new BaseException(1049, g.w(r10, r12));
    L33:
        throw new BaseException(1047, g.w(r10, r12));
    L35:
        throw new DownloadHttpException(PointerIconCompat.TYPE_WAIT, TypedValues.CycleType.TYPE_PATH_ROTATE, g.w(r10, r12));
    L37:
        throw new DownloadHttpException(PointerIconCompat.TYPE_WAIT, 412, g.w(r10, r12));
    L39:
        throw new BaseException(1048, g.w(r10, r12));
    L41:
        throw new BaseException(PointerIconCompat.TYPE_COPY, g.w(r10, r12));
    L5:
        r12 = "";
        goto L7
    }

    public static void U(IOException r10, String r11) {
        if (r11 != null) goto L4;
        r11 = "";
    L4:
        String r12 = g.w(r10, r11);
        if ((r10 instanceof ConnectException) == true) goto L73;
        if ((r10 instanceof UnknownHostException) == true) goto L71;
        if ((r10 instanceof NoRouteToHostException) == true) goto L69;
        if ((r10 instanceof UnknownServiceException) == true) goto L67;
        if ((r10 instanceof PortUnreachableException) == true) goto L65;
        if ((r10 instanceof SocketTimeoutException) == true) goto L63;
        if ((r10 instanceof SocketException) == true) goto L61;
        if ((r10 instanceof HttpRetryException) == true) goto L59;
        if ((r10 instanceof ProtocolException) == true) goto L57;
        if ((r10 instanceof MalformedURLException) == true) goto L55;
        if ((r10 instanceof FileNotFoundException) == true) goto L53;
        if ((r10 instanceof InterruptedIOException) == true) goto L51;
        if ((r10 instanceof UnsupportedEncodingException) == true) goto L49;
        if ((r10 instanceof EOFException) == true) goto L47;
        if ((r10 instanceof StreamResetException) == true) goto L45;
        if ((r10 instanceof SSLException) == true) goto L43;
        if (g.N(r10) == false) goto L41;
        throw new BaseException(PointerIconCompat.TYPE_CELL, r12);
    L41:
        throw new BaseException(1023, r12);
    L43:
        throw new BaseException(PointerIconCompat.TYPE_COPY, r12);
    L45:
        throw new BaseException(1067, r12);
    L47:
        throw new BaseException(1066, r12);
    L49:
        throw new BaseException(1065, r12);
    L51:
        throw new BaseException(1064, r12);
    L53:
        throw new BaseException(1063, r12);
    L55:
        throw new BaseException(1062, r12);
    L57:
        throw new BaseException(1061, r12);
    L59:
        throw new BaseException(1060, r12);
    L61:
        throw new BaseException(1059, r12);
    L63:
        throw new BaseException(1048, r12);
    L65:
        throw new BaseException(1058, r12);
    L67:
        throw new BaseException(1057, r12);
    L69:
        throw new BaseException(1056, r12);
    L71:
        throw new BaseException(1055, r12);
    L73:
        throw new BaseException(1041, r12);
    }

    private static Set<String> V(JSONArray r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.length() <= 0) goto L19;
        HashSet r11 = new HashSet();
        int r12 = 0;
    L16:
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        return r11;
    L8:
        if (r12 >= r10.length()) goto L13;
        r11.add(r10.getString(r12));     // Catch: JSONException -> L11
        r12 = r12 + 1;
        goto L16
    L19:
        return null;
    }

    private static void W(Throwable r10, String r11) {
        DownloadTTNetException r12 = t(r10, r11);
        if (r12 != null) goto L5;
        return;
    L5:
        throw r12;
    }

    public static long X(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return 0;
    L5:
        Matcher r11 = Pattern.compile("max-age=([0-9]+)").matcher(r10);
        if (r11.find() == true) goto L13;
        return 0;
    L13:
        return Long.parseLong(r11.group(1));
    L10:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public static void Y(List<HttpHeader> r10, String r11) {
        if (r10 == null) goto L24;
        if (r11 == null) goto L25;
        Iterator<HttpHeader> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L26;
        HttpHeader r13 = r12.next();
        if (r13 == null) goto L7;
        if (TextUtils.isEmpty(r13.getName()) == true) goto L7;
        if (r13.getName().contains(r11) == false) goto L7;
        r12.remove();
        return;
    L26:
        return;
    L25:
        return;
    }

    public static void Z(DownloadInfo r18, b0 r19, l0 r20) {
        if (lb.a.a() == false) goto L108;
        lb.a.g(f8330a, r18.getId(), "saveFileAsTargetName", "TargetName: " + r18.getTargetFilePath());
    L108:
        SparseArray<Boolean> r10 = f8331b;     // Catch: Throwable -> L100
        monitor-enter(r10);     // Catch: Throwable -> L100
        Boolean r11 = f8331b.get(r18.getId());     // Catch: Throwable -> L97
        Boolean r12 = Boolean.TRUE;     // Catch: Throwable -> L97
        if (r11 != r12) goto L11;
        boolean r13 = true;
    L12:
        if (r13 == false) goto L24;
        if (lb.a.a() == false) goto L16;
        lb.a.g(f8330a, r18.getId(), "saveFileAsTargetName", "Has another same task is saving temp file");     // Catch: Throwable -> L97
    L16:
        if (r20 == null) goto L21;
        List<l0> r14 = f8332c.get(r18.getId());     // Catch: Throwable -> L97
        if (r14 != null) goto L20;
        r14 = new ArrayList();     // Catch: Throwable -> L97
        f8332c.put(r18.getId(), r14);     // Catch: Throwable -> L97
    L20:
        r14.add(r20);     // Catch: Throwable -> L97
    L21:
        monitor-exit(r10);     // Catch: Throwable -> L97
        return;
    L24:
        if (lb.a.a() == false) goto L26;
        lb.a.g(f8330a, r18.getId(), "saveFileAsTargetName", "SaveTempFileStatusMap put id:" + r18.getId());     // Catch: Throwable -> L97
    L26:
        f8331b.put(r18.getId(), r12);     // Catch: Throwable -> L97
        monitor-exit(r10);     // Catch: Throwable -> L97
        kb.a r15 = new kb.a(r18.getTempPath(), r18.getTempName());     // Catch: Throwable -> L100
        kb.a r16 = new kb.a(r18.getSavePath(), r18.getName());     // Catch: Throwable -> L100
        if (r18.isForce() == true) goto L63;
        if (kb.b.f(r16) == false) goto L63;
        if (g.c(r18, r16) == false) goto L63;
        if (lb.a.a() == false) goto L37;
        lb.a.g(f8330a, r18.getId(), "saveFileAsTargetName", "TargetFile exist");     // Catch: Throwable -> L100
    L37:
        long r17 = SystemClock.uptimeMillis();     // Catch: Throwable -> L100
        int r21 = g.d(r16, r18.getMd5());     // Catch: Throwable -> L100
        r18.setMd5Time(SystemClock.uptimeMillis() - r17);     // Catch: Throwable -> L100
        if (g.P(r21) == false) goto L47;
        if (lb.a.a() == false) goto L42;
        lb.a.g(f8330a, r18.getId(), "saveFileAsTargetName", "TempFile not exist , targetFile exists and md5 check valid");     // Catch: Throwable -> L100
    L42:
        r18.setTTMd5CheckStatus(r21);     // Catch: Throwable -> L100
        if (r20 == null) goto L45;
        r20.a();     // Catch: Throwable -> L100
    L45:
        u(r18.getId(), true, null);     // Catch: Throwable -> L100
    L69:
        boolean r22 = false;
    L71:
        if (r22 == false) goto L111;
        int r23 = rb.a.g(r18.getId()).o("download_finish_check_ttmd5", 2);     // Catch: BaseException -> L85 Throwable -> L100
        if (r23 <= 0) goto L84;
        long r110 = SystemClock.uptimeMillis();     // Catch: BaseException -> L85 Throwable -> L100
        int r24 = g.d(r15, r18.getMd5());     // Catch: BaseException -> L85 Throwable -> L100
        r18.setMd5Time(SystemClock.uptimeMillis() - r110);     // Catch: BaseException -> L85 Throwable -> L100
        r18.setTTMd5CheckStatus(r24);     // Catch: BaseException -> L85 Throwable -> L100
        if (r23 < 2) goto L84;
        if (g.P(r24) == true) goto L84;
        BaseException r25 = new BaseException(1034, g.x(r24));     // Catch: BaseException -> L85 Throwable -> L100
        if (r20 == null) goto L81;
        r20.b(r25);     // Catch: BaseException -> L85 Throwable -> L100
    L81:
        u(r18.getId(), false, r25);     // Catch: BaseException -> L85 Throwable -> L100
        g.j(r18, a.p(r18.getSavePath()));     // Catch: BaseException -> L85 Throwable -> L100
        return;
    L84:
        boolean r26 = !P(r15, r16);
        BaseException r27 = null;
    L87:
        if (r26 == false) goto L93;
        if (r27 != null) goto L90;
        r27 = new BaseException(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", new Object[]{r18.getTempPath(), r18.getTempName(), r18.getSavePath(), r18.getName()}));     // Catch: Throwable -> L100
    L90:
        if (r20 == null) goto L92;
        r20.b(r27);     // Catch: Throwable -> L100
    L92:
        u(r18.getId(), false, r27);     // Catch: Throwable -> L100
        return;
    L93:
        if (r20 == null) goto L95;
        r20.a();     // Catch: Throwable -> L100
    L95:
        u(r18.getId(), true, null);     // Catch: Throwable -> L100
        return;
    L85:
        e = move-exception;
        r27 = e;
        r26 = true;
        goto L87
    L111:
        return;
    L47:
        if (r15.h() == true) goto L52;
        BaseException r28 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", new Object[]{r18.getTempPath(), r18.getTempName(), r18.getSavePath(), r18.getName(), g.x(r21)}));     // Catch: Throwable -> L100
        if (r20 == null) goto L51;
        r20.b(r28);     // Catch: Throwable -> L100
    L51:
        u(r18.getId(), false, r28);     // Catch: Throwable -> L100
        r22 = false;
    L54:
        if (r16.l() == true) goto L71;
        if (r22 == true) goto L58;
        if (r19 == null) goto L71;
        mb.a.n(r19, r18, new BaseException(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), r18.getStatus());     // Catch: Throwable -> L100
        goto L71
    L58:
        BaseException r29 = new BaseException(1037, "delete targetPath file existed with md5 check invalid status:" + g.x(r21));     // Catch: Throwable -> L100
        if (r20 == null) goto L61;
        r20.b(r29);     // Catch: Throwable -> L100
    L61:
        int r30 = r18.getId();     // Catch: Throwable -> L100
    L68:
        u(r30, false, r29);     // Catch: Throwable -> L100
        goto L69
    L52:
        r22 = true;
    L63:
        if (r15.h() == true) goto L70;
        r29 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", new Object[]{r18.getTempPath(), r18.getTempName(), r18.getSavePath(), r18.getName()}));     // Catch: Throwable -> L100
        if (r20 == null) goto L67;
        r20.b(r29);     // Catch: Throwable -> L100
    L67:
        r30 = r18.getId();     // Catch: Throwable -> L100
        goto L68
    L70:
        r22 = true;
        goto L71
    L11:
        r13 = false;
    L97:
        th = move-exception;
        throw th;     // Catch: Throwable -> L100
    L100:
        th = move-exception;
        BaseException r31 = new BaseException(1038, g.w(th, "saveFileAsTargetName") + " " + Log.getStackTraceString(th));
        if (lb.a.a() == false) goto L104;
        lb.a.g(f8330a, r18.getId(), "saveFileAsTargetName", "Error: " + r31);
    L104:
        if (r20 == null) goto L106;
        r20.b(r31);
    L106:
        u(r18.getId(), false, r31);
    }

    public static List<HttpHeader> a(List<HttpHeader> r10, String r11, long r12, long r13) {
        ArrayList r14 = new ArrayList();
        if (r10 == null) goto L19;
        if (r10.size() <= 0) goto L19;
        Iterator<HttpHeader> r15 = r10.iterator();
    L8:
        if (r15.hasNext() == false) goto L19;
        HttpHeader r16 = r15.next();
        if (r16 == null) goto L8;
        if (NetConst.KEY_ACCEPT_ENCODING.equalsIgnoreCase(r16.getName()) == false) goto L17;
        if (NetConst.GZIP.equalsIgnoreCase(r16.getValue()) == true) goto L8;
    L17:
        r14.add(r16);
    L19:
        if (TextUtils.isEmpty(r11) == true) goto L21;
        r14.add(new HttpHeader("If-Match", r11));
    L21:
        r14.add(new HttpHeader(NetConst.KEY_ACCEPT_ENCODING, "identity"));
        if (r13 > 0) goto L24;
        String r17 = String.format(Locale.US, "bytes=%d-", new Object[]{Long.valueOf(r12)});
    L25:
        r14.add(new HttpHeader("Range", r17));
        if (lb.a.a() == false) goto L28;
        lb.a.b(f8330a, "addRangeHeader", "CurrentOffset:" + r12 + " EndOffset:" + r13 + ", range = " + r17);
    L28:
        return r14;
    L24:
        r17 = String.format(Locale.US, "bytes=%d-%d", new Object[]{Long.valueOf(r12), Long.valueOf(r13)});
        goto L25
    }

    public static <K> void a0(SparseArray<K> r10, Map<Integer, K> r11) {
        if (r11 == null) goto L11;
        if (r10 == null) goto L17;
        Iterator<Map.Entry<Integer, K>> r12 = r11.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L18;
        Map.Entry<Integer, K> r13 = r12.next();
        if (r13.getKey() == null) goto L7;
        r10.put(r13.getKey().intValue(), r13.getValue());
        goto L7
    L18:
        return;
    L17:
        return;
    }

    public static void b(rb.a r10, List<HttpHeader> r11, DownloadInfo r12) {
        long r13 = r12.getThrottleNetSpeed();
        if (r13 <= 0) goto L5;
        r11.add(new HttpHeader("extra_throttle_net_speed", String.valueOf(r13)));
    L5:
        long r14 = r12.getTtnetProtectTimeout();
        if (r14 <= 300) goto L9;
        r11.add(new HttpHeader("extra_ttnet_protect_timeout", String.valueOf(r14)));
    L9:
        if (r12.isAddTTNetCommonParam() == false) goto L12;
        r11.add(new HttpHeader("extra_ttnet_common_param", "true"));
    L12:
        if (r10.o("enable_download_network_tag", 0) <= 0) goto L14;
        r11.add(new HttpHeader(ab.c.f135a, "dl"));
        r11.add(new HttpHeader(ab.c.f136b, "1.3.8.65"));
    L14:
        int r15 = r10.o("ttnet_proto_type", 0);
        if (r15 <= 0) goto L18;
        r11.add(new HttpHeader("x-ttnet-http-proto-type", String.valueOf(r15)));
        return;
    }

    public static <K> HashMap<Integer, K> b0(SparseArray<K> r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        HashMap<Integer, K> r11 = new HashMap();
        int r12 = r10.size();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L8;
        int r14 = r10.keyAt(r13);
        K r15 = r10.valueAt(r13);
        r11.put(Integer.valueOf(r14), r15);
        r13 = r13 + 1;
        goto L6
    L8:
        return r11;
    }

    public static boolean c(int r10, String r11) {
        if (r10 < 400) goto L6;
        return false;
    L6:
        if (r10 == 206) goto L11;
        if (r10 == 1) goto L11;
        if ("bytes".equals(r11) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static ContentValues c0(DownloadInfo r10) {
        ContentValues r11 = new ContentValues();
        r11.put("_id", Integer.valueOf(r10.getRawId()));
        r11.put("url", r10.getUrl());
        r11.put("savePath", r10.getSavePath());
        r11.put("tempPath", r10.getRawTempPath());
        r11.put(ActivityLifecycle.NAME, r10.getName());
        r11.put("chunkCount", Integer.valueOf(r10.getChunkCount()));
        r11.put("status", Integer.valueOf(r10.getStatus()));
        r11.put("curBytes", Long.valueOf(r10.getCurBytes()));
        r11.put("backCurBytes", Long.valueOf(r10.getBackCurBytes()));
        r11.put("totalBytes", Long.valueOf(r10.getTotalBytes()));
        r11.put("eTag", r10.geteTag());
        r11.put("onlyWifi", Integer.valueOf(r10.isOnlyWifi() ? 1 : 0));
        r11.put("force", Integer.valueOf(r10.isForce() ? 1 : 0));
        r11.put("retryCount", Integer.valueOf(r10.getRetryCount()));
        r11.put(WsConstants.KEY_EXTRA, r10.getExtra());
        r11.put("mimeType", r10.getMimeType());
        r11.put("title", r10.getRawTitle());
        r11.put("notificationEnable", Integer.valueOf(r10.isShowNotification() ? 1 : 0));
        r11.put("notificationVisibility", Integer.valueOf(r10.getNotificationVisibility()));
        r11.put("isFirstDownload", Integer.valueOf(r10.getIsFirstDownload() ? 1 : 0));
        r11.put("isFirstSuccess", Integer.valueOf(r10.isFirstSuccess() ? 1 : 0));
        r11.put("needHttpsToHttpRetry", Integer.valueOf(r10.isNeedHttpsToHttpRetry() ? 1 : 0));
        r11.put("downloadTime", Long.valueOf(r10.getDownloadTime()));
        r11.put("packageName", r10.getPackageName());
        r11.put("md5", r10.getMd5());
        r11.put("curRetryTime", Integer.valueOf(r10.getCurRetryTime()));
        r11.put("defaultHttpServiceBackUp", Integer.valueOf(r10.isNeedDefaultHttpServiceBackUp() ? 1 : 0));
        r11.put("chunkRunnableReuse", 0);
        r11.put("chunkDowngradeRetry", 0);
        r11.put("backUpUrlsStr", r10.getBackUpUrlsStr());
        r11.put("backUpUrlRetryCount", Integer.valueOf(r10.getBackUpUrlRetryCount()));
        r11.put("realDownloadTime", Long.valueOf(r10.getRawRealDownloadTime()));
        r11.put("realBackDownloadTime", Long.valueOf(r10.getRawRealBackDownloadTime()));
        r11.put("independentProcess", Integer.valueOf(r10.isNeedIndependentProcess() ? 1 : 0));
        r11.put("auxiliaryJsonobjectString", r10.getDBJsonDataString());
        r11.put("iconUrl", r10.getIconUrl());
        r11.put("appVersionCode", Integer.valueOf(r10.getAppVersionCode()));
        r11.put("taskId", null);
        r11.put("downloadStartTimeStamp", Long.valueOf(r10.getDownloadStartTimeStamp()));
        r11.put("downloadFinishTimeStamp", Long.valueOf(r10.getDownloadFinishTimeStamp()));
        r11.put("installedTimeStamp", Long.valueOf(r10.getInstalledTimeStamp()));
        r11.put("hasDoInstallation", Integer.valueOf(r10.isHasDoInstallation() ? 1 : 0));
        r11.put("cacheLifeTimeMax", Long.valueOf(r10.getCacheLifeTimeMax()));
        r11.put("pcdnUrlsStr", r10.getPcdnUrlsStr());
        r11.put("cdnUrlsStr", r10.getCdnUrlsStr());
        return r11;
    }

    public static boolean d(Context r10, String r11) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r11) == false) goto L8;
        return false;
    L8:
        if (r10.checkCallingOrSelfPermission(r11) != 0) goto L12;
        return true;
    L12:
        return false;
    }

    public static void e(String r10) {
        if (lb.a.a() == true) goto L5;
        return;
    L5:
        if (g.O() == false) goto L11;
        lb.a.c(f8330a, "checkWorkerThread", "This method:" + r10 + " cannot be executed on the main thread");
        h0 r11 = com.ss.android.socialbase.downloader.downloader.a.C();
        if (r11 == null) goto L12;
        r11.a(r10);
        return;
    L12:
        return;
    }

    public static ListenerType f(int r10) {
        ListenerType r11 = ListenerType.MAIN;
        ListenerType r12 = ListenerType.SUB;
        if (r10 == r12.ordinal()) goto L8;
        r12 = ListenerType.NOTIFICATION;
        if (r10 == r12.ordinal()) goto L8;
        return r11;
    L8:
        return r12;
    }

    public static boolean g(kb.a r10, kb.a r11, boolean r12) {
        if (r10 == null) goto L42;
        if (r11 == null) goto L42;
    L40:
        e = move-exception;
        throw e;
    L37:
        th = move-exception;
        T(th, "CopyFile");
        return false;
    L6:
        if (r10.h() == false) goto L42;
        if (r10.e() == true) goto L42;
        if (r10.d().equals(r11.d()) == true) goto L42;
        if (r11.o() == false) goto L25;
        File r13 = r11.c();     // Catch: Throwable -> L37 BaseException -> L40
        if (r13 == null) goto L25;
        if (r13.mkdirs() == true) goto L25;
        if (r13.isDirectory() == true) goto L25;
        throw new BaseException(1053, "Destination '" + r13 + "' directory cannot be created");     // Catch: Throwable -> L37 BaseException -> L40
    L25:
        if (lb.a.a() == false) goto L28;
        lb.a.b(f8330a, "copyFile", "SrcFile:" + r10.getPath() + " DestFile:" + r11.getPath());     // Catch: Throwable -> L37 BaseException -> L40
    L28:
        if (r11.h() == true) goto L30;
    L34:
        m(r10, r11, r12);     // Catch: Throwable -> L37 BaseException -> L40
        return true;
    L30:
        if (r11.b() == true) goto L34;
        throw new IOException("Destination '" + r11.d() + "' exists but is read-only");     // Catch: Throwable -> L37 BaseException -> L40
    L42:
        return false;
    }

    public static void h(DownloadInfo r10, String r11, String r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r12) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r11) == false) goto L8;
        return;
    L8:
        if (r12.equals(r10.getName()) == true) goto L28;
        kb.a r13 = new kb.a(r10.getSavePath(), r12);
        kb.a r14 = new kb.a(r10.getSavePath(), r10.getName());
        if (lb.a.a() == false) goto L14;
        lb.a.g(f8330a, r10.getId(), "copyFileFromExistFileWithSameName", "ExistFile:" + r13.getPath() + " targetFile:" + r14.getPath());
    L14:
        if (r14.h() == false) goto L21;
        if (r14.b() == true) goto L21;
        throw new BaseException(1001, "targetPath file exists but read-only");
    L21:
        if ((!g(r13, r14, true)) == true) goto L24;
        return;
    L24:
        throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", new Object[]{r10.getSavePath(), r12, r10.getSavePath(), r10.getName()}));
    }

    public static void i(Context r10, String r11, Uri r12) {
        ContentResolver r13 = r10.getContentResolver();
        Closeable r14 = null;
        OutputStream r15 = null;
        r15 = null;
        r15 = null;
        Closeable r16 = null;
        FileInputStream r17 = new FileInputStream(new File(r11));     // Catch: Throwable -> L16 IOException -> L20
        if (r12 != null) goto L23;
    L9:
        if (r15 == null) goto L15;
        byte[] r18 = new byte[4096];     // Catch: Throwable -> L6 IOException -> L8
    L11:
        int r19 = r17.read(r18);     // Catch: Throwable -> L6 IOException -> L8
        if (r19 == (-1)) goto L15;
        r15.write(r18, 0, r19);     // Catch: Throwable -> L6 IOException -> L8
        goto L11
    L8:
        OutputStream r20 = r15;
        r16 = r17;
    L21:
        g.b0(new Closeable[]{r16});
        g.b0(new Closeable[]{r20});
        return;
    L6:
        th = th;
        OutputStream r21 = r15;
        r14 = r17;
    L18:
        g.b0(new Closeable[]{r14});
        g.b0(new Closeable[]{r21});
        throw th;
    L15:
        g.b0(new Closeable[]{r17});
        g.b0(new Closeable[]{r15});
        return;
    L23:
        r15 = r13.openOutputStream(r12);     // Catch: Throwable -> L6 IOException -> L8
        goto L9
    L20:
        r20 = null;
    L16:
        th = th;
        r21 = null;
        goto L18
    }

    public static <K, V> void j(Map<K, V> r10, Map<K, V> r11) {
        if (r10 == null) goto L11;
        if (r11 == null) goto L17;
        Iterator<Map.Entry<K, V>> r12 = r10.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L18;
        Map.Entry<K, V> r13 = r12.next();
        if (r13.getKey() == null) goto L7;
        r11.put(r13.getKey(), r13.getValue());
        goto L7
    L18:
        return;
    L17:
        return;
    }

    public static com.ss.android.socialbase.downloader.model.h k(DownloadInfo r10, String r11, String r12, int r13, boolean r14) {
        if (TextUtils.isEmpty(r11) == true) goto L59;
        if (TextUtils.isEmpty(r12) == true) goto L59;
        File r15 = new File(r11, r12);
        boolean r16 = false;
        if (r15.exists() == false) goto L14;
        if (r15.isDirectory() == false) goto L14;
        throw new BaseException(1035, new IOException(String.format("path is :%s, path is directory:%B:", new Object[]{r11, Boolean.valueOf(r15.isDirectory())})));
    L14:
        if (r15.exists() == true) goto L57;
        File r17 = new File(r11);     // Catch: IOException -> L53
        if (r17.exists() == false) goto L20;
        if (r17.isDirectory() == false) goto L20;
    L44:
        r15.createNewFile();     // Catch: IOException -> L53
    L20:
        if (r17.exists() == false) goto L22;
        r17.delete();     // Catch: IOException -> L53
        if (r17.mkdirs() == true) goto L52;
        if (r17.exists() == true) goto L52;
        throw new BaseException(1031, "download savePath is not directory:path=" + r11);     // Catch: IOException -> L53
    L52:
        throw new BaseException(1031, "download savePath is not directory:" + r11);     // Catch: IOException -> L53
    L22:
        if (r17.mkdirs() == true) goto L44;
        if (r17.exists() == true) goto L44;
        if (rb.a.i(r10).o("opt_mkdir_failed", 0) != 1) goto L43;
        int r18 = 0;
    L29:
        if (r16 == true) goto L35;
        int r19 = r18 + 1;
        if (r18 >= 3) goto L35;
        Thread.sleep(10);     // Catch: InterruptedException -> L60 IOException -> L53
        r16 = r17.mkdirs();     // Catch: IOException -> L53
        r18 = r19;
    L35:
        if (r16 == true) goto L44;
        if (g.n(r10.getSavePath()) >= PlaybackStateCompat.ACTION_PREPARE) goto L41;
        throw new BaseException(PointerIconCompat.TYPE_CELL, "download savePath directory can not created:" + r11);     // Catch: IOException -> L53
    L41:
        throw new BaseException(1030, "download savePath directory can not created:" + r11);     // Catch: IOException -> L53
    L43:
        throw new BaseException(1030, "download savePath directory can not created:" + r11);     // Catch: IOException -> L53
    L53:
        e = move-exception;
        throw new BaseException(1036, e);
    L57:
        return new com.ss.android.socialbase.downloader.model.h(r15, r13, r14);
    L59:
        throw new BaseException(PointerIconCompat.TYPE_GRABBING, new IOException("path must be not empty"));
    }

    public static void l(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        if (r10.contains(r11) == true) goto L34;
        File r12 = new File(r10);
        if (r12.exists() == true) goto L10;
        return;
    L10:
        if (r12.isDirectory() == false) goto L35;
        File[] r13 = r12.listFiles();
        if (r13 != null) goto L15;
    L26:
        r12.delete();
        return;
    L15:
        if (r13.length == 0) goto L26;
        int r14 = r13.length;
        int r15 = 0;
    L17:
        if (r15 >= r14) goto L26;
        File r16 = r13[r15];
        if (r16.isFile() == false) goto L22;
        r16.delete();
    L25:
        r15 = r15 + 1;
        goto L17
    L22:
        if (r16.isDirectory() == false) goto L25;
        l(r16.getAbsolutePath(), r11);
        return;
    L35:
        return;
    }

    @TargetApi(19)
    private static void m(kb.a r17, kb.a r18, boolean r19) {
        if (r18.h() == false) goto L10;
        if (r18.e() == false) goto L10;
        throw new IOException("Destination '" + r18 + "' exists but is a directory");
    L10:
        if (Build.VERSION.SDK_INT >= 29) goto L12;
    L19:
        FileInputStream r10 = r17.g();
        FileChannel r11 = r10.getChannel();     // Catch: Throwable -> L82
        FileOutputStream r12 = r18.k();     // Catch: Throwable -> L70
        FileChannel r13 = r12.getChannel();     // Catch: Throwable -> L58
        long r14 = r11.size();     // Catch: Throwable -> L46
        long r15 = 0;
    L25:
        if (r15 >= r14) goto L35;
        long r16 = r14 - r15;     // Catch: Throwable -> L46
        if (r16 <= 31457280) goto L29;
        long r20 = 31457280;
    L30:
        long r21 = r13.transferFrom(r11, r15, r20);     // Catch: Throwable -> L46
    L32:
        if (r21 == 0) goto L35;
        r15 = r15 + r21;
        goto L25
    L29:
        r20 = r16;
    L35:
        if (r13 == null) goto L37;
        r13.close();     // Catch: Throwable -> L58
    L37:
        r12.close();     // Catch: Throwable -> L70
        r11.close();     // Catch: Throwable -> L82
        r10.close();
        long r22 = r17.length();
        long r23 = r18.length();
        if (r22 != r23) goto L45;
        if (r19 == false) goto L116;
        r18.m(r17.j());
        return;
    L116:
        return;
    L45:
        throw new IOException("Failed to copy full contents from '" + r17 + "' to '" + r18 + "' Expected length: " + r22 + " Actual: " + r23);
    L46:
        th = move-exception;
        throw th;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        if (r13 == null) goto L117;
        r13.close();     // Catch: Throwable -> L54
    L118:
        throw th;     // Catch: Throwable -> L58
    L54:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L58
        throw th;     // Catch: Throwable -> L58
    L117:
        throw th;     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        throw th;     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        if (r12 == null) goto L119;
        r12.close();     // Catch: Throwable -> L66
    L120:
        throw th;     // Catch: Throwable -> L70
    L66:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L70
        throw th;     // Catch: Throwable -> L70
    L119:
        throw th;     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        throw th;     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        if (r11 == null) goto L121;
        r11.close();     // Catch: Throwable -> L78
    L122:
        throw th;     // Catch: Throwable -> L82
    L78:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L82
        throw th;     // Catch: Throwable -> L82
    L121:
        throw th;     // Catch: Throwable -> L82
    L82:
        th = move-exception;
        throw th;     // Catch: Throwable -> L85
    L85:
        th = move-exception;
        if (r10 == null) goto L123;
        r10.close();     // Catch: Throwable -> L90
        throw th;
    L90:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L123:
        throw th;
    L12:
        if (kb.b.o(r18.getPath()) == false) goto L19;
        Uri r24 = kb.b.m(r18.getPath());
        if (r24 == null) goto L18;
        i(com.ss.android.socialbase.downloader.downloader.a.h(), r17.getPath(), r24);
        return;
    L18:
        throw new IOException("Destination " + r18 + "exists but contentUri is null");
    }

    public static long n(DownloadInfo r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        boolean r11 = r10.isFileDataValid();
        if (lb.a.a() == false) goto L8;
        lb.a.g(f8330a, r10.getId(), "getCurByte", "ResumeAvailable:" + r11);
    L8:
        if (r11 == true) goto L10;
        return 0;
    L10:
        return r10.getCurBytes();
    }

    public static Set<String> o() {
        return V(rb.a.j().p("db_init_monitor_scene_list"));
    }

    public static long p(DownloadInfo r10) {
        if (r10 != null) goto L6;
        return -1;
    L6:
        return r10.getCurBytes();
    }

    public static String q(String r10, int r11) {
        if (r11 != 0) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return r10;
    L8:
        if (r10.length() > r11) goto L11;
        return r10;
    L11:
        return r10.substring(0, r11);
    }

    public static Set<String> r() {
        return V(rb.a.j().p("skip_db_init_expect_mime_type"));
    }

    public static Set<String> s() {
        return V(rb.a.j().p("skip_db_init_monitor_scene_list"));
    }

    public static DownloadTTNetException t(Throwable r10, String r11) {
        DownloadTTNetException r12 = com.ss.android.socialbase.downloader.downloader.a.U().f(r10, null);
        if (r12 != null) goto L5;
        r12 = com.ss.android.socialbase.downloader.downloader.a.U().f(r10.getCause(), null);
    L5:
        if (r12 == null) goto L8;
        String r13 = g.w(r12, r11);
        return new DownloadTTNetException(r12.getErrorCode(), r13).setRequestLog(r12.getRequestLog()).setRemoteIp(r12.getRemoteIp());
    L8:
        return null;
    }

    private static void u(int r10, boolean r11, BaseException r12) {
        SparseArray<Boolean> r13 = f8331b;
        monitor-enter(r13);
        List<l0> r14 = f8332c.get(r10);     // Catch: Throwable -> L20
        if (r14 == null) goto L15;
        Iterator<l0> r15 = r14.iterator();     // Catch: Throwable -> L20
    L8:
        if (r15.hasNext() == false) goto L15;
        l0 r16 = r15.next();     // Catch: Throwable -> L20
        if (r16 == null) goto L8;
        if (r11 == true) goto L12;
        r16.b(r12);     // Catch: Throwable -> L20
        goto L8
    L12:
        r16.a();     // Catch: Throwable -> L20
    L15:
        if (lb.a.a() == false) goto L17;
        lb.a.g(f8330a, r10, "handleTempSaveCallback", "Run");     // Catch: Throwable -> L20
    L17:
        f8331b.remove(r10);     // Catch: Throwable -> L20
        monitor-exit(r13);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public static boolean v(Set<String> r10, Set<String> r11, Set<String> r12, String r13, String r14) {
        if (r10 != null) goto L5;
    L9:
        if (r11 != null) goto L11;
    L16:
        return false;
    L11:
        if (r11.contains(r13) == true) goto L16;
        if (r12 != null) goto L14;
        return true;
    L14:
        if (r12.contains(r14) == true) goto L16;
        return true;
    L5:
        if (TextUtils.isEmpty(r14) == true) goto L9;
        if (r10.contains(r14) == false) goto L9;
        return true;
    }

    public static void w(nb.h r10, BaseException r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if ((r10 instanceof nb.a) == false) goto L15;
        if (r11 != null) goto L7;
        return;
    L7:
        if ((r11 instanceof DownloadTTNetException) == false) goto L17;
        String r12 = ((nb.a) r10).e();
        if (TextUtils.isEmpty(r12) == true) goto L12;
        ((DownloadTTNetException) r11).setRemoteIp(r12);
    L12:
        ((DownloadTTNetException) r11).parseRemoteIp();
        return;
    L17:
        return;
    }

    public static boolean x(List<Pair<String, String>> r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        Iterator<Pair<String, String>> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L14;
        Pair<String, String> r12 = r11.next();
        if (TextUtils.isEmpty((CharSequence) r12.second) == true) goto L7;
        if (((String) r12.second).toLowerCase().contains("hit") == false) goto L7;
        return true;
    L14:
        return false;
    }

    public static boolean y(nb.g r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if ("chunked".equals(r10.d("Transfer-Encoding")) == false) goto L8;
    L9:
        return true;
    L8:
        if (g.p(r10) == (-1)) goto L9;
        return false;
    }

    public static boolean z(Throwable r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        String r11 = g.G(r10);
        if (TextUtils.isEmpty(r11) == false) goto L8;
        return false;
    L8:
        if (r11.contains("Exception in connect") == false) goto L12;
        return true;
    L12:
        return false;
    }
}
