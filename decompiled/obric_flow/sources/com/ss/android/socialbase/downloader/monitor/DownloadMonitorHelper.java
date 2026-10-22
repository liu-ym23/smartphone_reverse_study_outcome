package com.ss.android.socialbase.downloader.monitor;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.depend.AbsDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDefaultDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DownloadMonitorHelper {

    public static class DownloadMonitorInfo {
        public ArrayList A;
        public int B;
        public boolean C;
        public String D;
        public String E;
        public boolean F;
        public JSONObject G;
        public String H;
        public String I;
        public String J;
        public int K;
        public long L;
        public long M;
        public long N;
        public long O;
        public boolean P;
        public long Q;
        public long R;
        public long S;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BaseException f15924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f15925c;
        public int d;
        public String e;
        public String f;
        public String g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f15926h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f15927i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f15928j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f15929k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f15930l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f15931m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f15932n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f15933o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f15934p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f15935q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f15936r;
        public boolean s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public ByteInvalidRetryStatus f15937t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public AsyncHandleStatus f15938u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f15939v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public String f15940w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f15941x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public ArrayList f15942y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f15943z;

        public DownloadMonitorInfo() {
            this.f15937t = ByteInvalidRetryStatus.f15266a;
            this.f15938u = AsyncHandleStatus.f15263a;
        }
    }

    public static void a(DownloadTask r10, BaseException r11, int r12) {
        boolean r5 = true;
        if (r10 == null) goto L75;
        DownloadInfo r13 = r10.f15878a;     // Catch: Throwable -> L36
        if (r13 == null) goto L73;
        IDownloadMonitorDepend r14 = r10.f15883j;     // Catch: Throwable -> L36
        if (r12 != 2) goto L11;
    L23:
        boolean r15 = true;
    L24:
        if (r15 == true) goto L53;
        int[] r16 = r13.Q;     // Catch: Throwable -> L36
        if (r16 != null) goto L28;
    L38:
        r15 = false;
    L39:
        if (r15 == true) goto L53;
        if (r14 == null) goto L53;
        int[] r17 = ((AbsDownloadMonitorDepend) r14).a();     // Catch: Throwable -> L36
        if (r17 != null) goto L44;
    L52:
        r5 = false;
    L54:
        if (r5 == false) goto L74;
        IDownloadDepend r18 = r10.f15882i;     // Catch: Throwable -> L59
        if (r18 == null) goto L61;
        r18.a(r13, r11, r12);     // Catch: Throwable -> L59
    L61:
        a(r14, r13, r11, r12);     // Catch: Throwable -> L36
        Context r19 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L36
        return;
    L59:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L36
        goto L61
    L74:
        return;
    L44:
        if (r17.length <= 0) goto L52;
        int r20 = 0;
    L47:
        if (r20 >= r17.length) goto L52;
        if (r12 == r17[r20]) goto L54;
        r20 = r20 + 1;
        goto L47
    L28:
        if (r16.length <= 0) goto L38;
        int r21 = 0;
    L31:
        if (r21 >= r16.length) goto L38;
        if (r12 == r16[r21]) goto L34;
        r21 = r21 + 1;     // Catch: Throwable -> L36
        goto L31
    L34:
        r15 = true;
    L53:
        r5 = r15;
        goto L54
    L11:
        if (r12 == (-3)) goto L23;
        if (r12 == (-1)) goto L23;
        if (r12 == (-4)) goto L23;
        if (r12 == (-2)) goto L23;
        if (r12 == 6) goto L23;
        if (r12 == 0) goto L23;
        r15 = false;
        goto L24
    L73:
        return;
    L36:
        th = move-exception;
        Context r22 = DownloadComponentManager.f15515a;
        th.printStackTrace();
        return;
    }

    public static void a(final IDownloadMonitorDepend r5, DownloadInfo r10, BaseException r11, int r12) {
        if (r5 != null) goto L4;
        return;
    L4:
        String r13 = r5.g();
        if (TextUtils.isEmpty(r13) == false) goto L7;
        r13 = "default";
    L7:
        final DownloadMonitorInfo r14 = new DownloadMonitorInfo();
        r14.f15923a = r12;
        r14.f15924b = r11;
        r14.f15925c = r13;
        if (r10 == null) goto L32;
        r14.d = r10.l();
        r14.e = r10.f15808b;
        r14.f = r10.d;
        r14.g = r10.e;
        r14.f15926h = r10.f15825m0;
        r14.f15927i = r10.i();
        AtomicLong r15 = r10.g0;
        if (r15 == null) goto L12;
        long r16 = r15.get();
    L13:
        r14.f15928j = r16;
        r14.f15929k = r10.f15817h0;
        r14.f15930l = r10.f15809b0;
        r14.f15931m = r10.g;
        r14.f15932n = r10.f15841v;
        r14.f15933o = r10.f15833q0;
        r14.f15934p = r10.C;
        r14.f15935q = r10.f15828o;
        r14.f15936r = r10.f15824m;
        r14.s = r10.E;
        r14.f15937t = r10.f15848y0;
        r14.f15938u = r10.H;
        r14.f15939v = r10.J;
        r14.f15940w = r10.f15816h;
        r14.f15941x = r10.O0;
        r14.f15942y = r10.s;
        r14.f15943z = r10.f15811c0;
        r14.A = r10.f15846x0;
        r14.B = r10.N;
        r14.C = r10.M0;
        r14.D = r10.f15839u;
        r14.E = r10.N0;
        r14.F = r10.b1;
        r14.G = r10.R0;
        r14.H = r10.C0;
        r14.I = r10.D0;
        r14.J = r10.E0;
        r14.K = r10.f15850z0.ordinal();
        if (r12 != (-3)) goto L16;
    L21:
        r10.d();
        if (r10.D != null) goto L24;
        r10.D = new AtomicLong(r10.T0.optLong("dbjson_key_all_connect_time"));
    L24:
        r14.L = r10.D.get();
        r10.d();
        r14.M = r10.T0.optLong("dbjson_key_first_speed_time");
        TimeUnit r17 = TimeUnit.NANOSECONDS;
        r14.N = r17.toMillis(r10.f15827n0);
        r14.O = r17.toMillis(r10.f15829o0);
        boolean r18 = r10.f15831p0;
        r14.P = r18;
        int r19 = r10.G;
        r14.Q = r19;
        if (r18 == false) goto L29;
        r19 = r19 + r10.f15824m;
        int r20 = r10.f15811c0;
        if (r20 <= 0) goto L29;
        r19 = r19 + (r20 * r10.f15826n);
    L29:
        r14.R = r19;
        r14.S = r10.K0;
    L30:
        if (r12 != (-3)) goto L32;
        r10.i();
        TimeUnit.NANOSECONDS.toMillis(r10.f15827n0);
        goto L32
    L16:
        if (r12 == (-4)) goto L21;
        if (r12 == (-1)) goto L21;
        if (r12 != (-2)) goto L30;
    L12:
        r16 = 0;
    L32:
        ((ThreadPoolExecutor) DownloadComponentManager.c()).execute(new AnonymousClass1(r14, r5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v2, types: [org.json.JSONObject] */
    public static JSONObject a(DownloadMonitorInfo r10) {
        ?? r5 = 0;
        ?? r11 = new JSONObject();     // Catch: JSONException -> L87
        monitor-enter(DownloadComponentManager.class);     // Catch: JSONException -> L11
        Context r12 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L83
        monitor-exit(DownloadComponentManager.class);     // Catch: JSONException -> L11
        r11.put("event_page", r10.f15925c);     // Catch: JSONException -> L11
        r11.put("app_id", "");     // Catch: JSONException -> L11
        r11.put(WsConstants.KEY_DEVICE_ID, "");     // Catch: JSONException -> L11
        r11.put("device_id_postfix", "");     // Catch: JSONException -> L11
        int r13 = 0;
        r11.put("update_version", 0);     // Catch: JSONException -> L11
        r11.put("download_status", r10.f15923a);     // Catch: JSONException -> L11
        r11.put("setting_tag", DownloadSetting.a(r10.d, null).a());     // Catch: JSONException -> L11
        r11.put(Constant.DOWNLOAD_ID, r10.d);     // Catch: JSONException -> L11
        r11.put("name", r10.e);     // Catch: JSONException -> L11
        r11.put("url", r10.f);     // Catch: JSONException -> L11
        r11.put("save_path", r10.g);     // Catch: JSONException -> L11
        r11.put("download_time", r10.f15926h);     // Catch: JSONException -> L11
        r11.put("cur_bytes", r10.f15927i);     // Catch: JSONException -> L11
        r11.put("background_download_bytes", r10.f15928j);     // Catch: JSONException -> L11
        r11.put("total_bytes", r10.f15929k);     // Catch: JSONException -> L11
        r11.put("network_quality", r10.f15930l);     // Catch: JSONException -> L11
        r11.put("only_wifi", r10.f15931m ? 1 : 0);     // Catch: JSONException -> L11
        r11.put("need_https_degrade", r10.f15932n ? 1 : 0);     // Catch: JSONException -> L11
        r11.put("https_degrade_retry_used", r10.f15933o ? 1 : 0);     // Catch: JSONException -> L11
        String r14 = r10.f15934p;     // Catch: JSONException -> L11
        if (r14 != null) goto L13;
        r14 = "";
    L13:
        r11.put("md5", r14);     // Catch: JSONException -> L11
        r11.put("is_force", r10.f15935q ? 1 : 0);     // Catch: JSONException -> L11
        r11.put("retry_count", r10.f15936r);     // Catch: JSONException -> L11
        r11.put("default_http_service_backup", r10.s ? 1 : 0);     // Catch: JSONException -> L11
        r11.put("download_byte_error_retry_status", r10.f15937t.ordinal());     // Catch: JSONException -> L11
        r11.put("forbidden_handler_status", r10.f15938u.ordinal());     // Catch: JSONException -> L11
        r11.put("need_independent_process", r10.f15939v ? 1 : 0);     // Catch: JSONException -> L11
        String r15 = r10.f15940w;     // Catch: JSONException -> L11
        if (r15 != null) goto L17;
        r15 = "";
    L17:
        r11.put("extra", r15);     // Catch: JSONException -> L11
        r11.put("add_listener_to_same_task", r10.f15941x ? 1 : 0);     // Catch: JSONException -> L11
        ArrayList r16 = r10.f15942y;     // Catch: JSONException -> L11
        if (r16 == null) goto L20;
        int r17 = r16.size();     // Catch: JSONException -> L11
    L21:
        r11.put("backup_url_count", r17);     // Catch: JSONException -> L11
        ArrayList r18 = r10.f15942y;     // Catch: JSONException -> L11
        if (r18 == null) goto L24;
        String r19 = r18.toString();     // Catch: JSONException -> L11
    L25:
        r11.put("backup_url", r19);     // Catch: JSONException -> L11
        if (r10.f15942y == null) goto L28;
        int r20 = r10.f15943z;     // Catch: JSONException -> L11
    L29:
        r11.put("cur_backup_url_index", r20);     // Catch: JSONException -> L11
        ArrayList r21 = r10.A;     // Catch: JSONException -> L11
        if (r21 == null) goto L32;
        String r22 = r21.toString();     // Catch: JSONException -> L11
    L33:
        r11.put("forbidden_urls", r22);     // Catch: JSONException -> L11
        r11.put("network_retry_count", r10.B);     // Catch: JSONException -> L11
        r11.put("cache_exists_in_downloading", r10.C);     // Catch: JSONException -> L11
        r11.put("content_type", r10.D);     // Catch: JSONException -> L11
        r11.put("content_encoding", r10.E);     // Catch: JSONException -> L11
        r11.put("fast_download", r10.F ? 1 : 0);     // Catch: JSONException -> L11
        String r23 = r10.J;     // Catch: JSONException -> L11
        if (r23 != null) goto L36;
        r23 = "";
    L36:
        r11.put("request_log", r23);     // Catch: JSONException -> L11
        String r24 = r10.H;     // Catch: JSONException -> L11
        if (r24 != null) goto L39;
        r24 = "";
    L39:
        r11.put("request_header", r24);     // Catch: JSONException -> L11
        String r25 = r10.I;     // Catch: JSONException -> L11
        if (r25 != null) goto L42;
        r25 = "";
    L42:
        r11.put("response_header", r25);     // Catch: JSONException -> L11
        r11.put("enqueue_type", r10.K);     // Catch: JSONException -> L11
        r11.put("sleep_time", 0);     // Catch: JSONException -> L11
        String r26 = DownloadUtils.a(DownloadComponentManager.b());     // Catch: JSONException -> L11
        if (r26 != null) goto L45;
        r26 = "";
    L45:
        r11.put("process_name", r26);     // Catch: JSONException -> L11
        JSONObject r27 = r10.G;     // Catch: JSONException -> L11
        if (r27 == null) goto L48;
        r11.put("pcdn_log", r27);     // Catch: JSONException -> L11
    L48:
        int r28 = r10.f15923a;     // Catch: JSONException -> L11
        if (r28 != (-3)) goto L51;
    L55:
        r11.put("all_connect_time", r10.L);     // Catch: JSONException -> L11
        r11.put("first_speed_time", r10.M);     // Catch: JSONException -> L11
        r11.put("real_download_time", r10.N);     // Catch: JSONException -> L11
        r11.put("background_download_time", r10.O);     // Catch: JSONException -> L11
        r11.put("backup_url_used", r10.P ? 1 : 0);     // Catch: JSONException -> L11
        r11.put("cur_retry_time", r10.Q);     // Catch: JSONException -> L11
        r11.put("cur_retry_time_in_total", r10.R);     // Catch: JSONException -> L11
        r11.put("md5_time", r10.S);     // Catch: JSONException -> L11
        r11.put("device_available_space", ((DownloadUtils.b(r10.g) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) / 100);     // Catch: Throwable -> L58
    L95:
        String r29 = "";
        String r30 = "";
        String r31 = "";
        if (TextUtils.isEmpty(r10.f) == true) goto L72;
        Uri r32 = Uri.parse(r10.f);     // Catch: Throwable -> L70
        String r33 = r32.getHost();     // Catch: Throwable -> L70
        String r34 = r32.getPath();     // Catch: Throwable -> L70
        String r35 = r32.getLastPathSegment();     // Catch: Throwable -> L70
        if (TextUtils.isEmpty(r34) == false) goto L65;
    L67:
        String r36 = r34;
        r31 = r35;
        r29 = r33;
        r30 = r36;
        goto L72
    L65:
        if (TextUtils.isEmpty(r35) == true) goto L67;
        r34 = r34.substring(0, r34.length() - r35.length());     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L70
    L72:
        r11.put("url_host", r29);     // Catch: Throwable -> L70
        r11.put("url_path", r30);     // Catch: Throwable -> L70
        r11.put("url_last_path_segment", r31);     // Catch: Throwable -> L70
    L75:
        BaseException r37 = r10.f15924b;     // Catch: JSONException -> L11
        if (r37 == null) goto L78;
        r13 = r37.f15601a;     // Catch: JSONException -> L11
    L78:
        r11.put(WsConstants.ERROR_CODE, r13);     // Catch: JSONException -> L11
        BaseException r38 = r10.f15924b;     // Catch: JSONException -> L11
        if (r38 == null) goto L81;
        String r39 = r38.f15602b;     // Catch: JSONException -> L11
    L82:
        r11.put("error_msg", r39);     // Catch: JSONException -> L11
        return r11;
    L81:
        r39 = "";
        goto L82
    L70:
        th = move-exception;
        th.printStackTrace();     // Catch: JSONException -> L11
    L58:
        th = move-exception;
        th.printStackTrace();     // Catch: JSONException -> L11
        goto L95
    L51:
        if (r28 == (-4)) goto L55;
        if (r28 == (-1)) goto L55;
        if (r28 != (-2)) goto L95;
    L32:
        r22 = "";
        goto L33
    L28:
        r20 = -1;
        goto L29
    L24:
        r19 = "";
        goto L25
    L20:
        r17 = 0;
        goto L21
    L83:
        th = move-exception;
        throw th;     // Catch: JSONException -> L11
    L11:
        e = e;
        r5 = r11;
    L88:
        Context r40 = DownloadComponentManager.f15515a;
        e.printStackTrace();
        return r5;
    L87:
        e = e;
        goto L88
    }

    public static void a(IDownloadHeadHttpConnection r14, String r15, String r16, long r17, int r19, IOException r20, DownloadInfo r21) {
        if (r21 == null) goto L104;
        String r5 = null;
        DownloadSetting r10 = DownloadSetting.a(r21.l(), null);
        int r11 = r10.a("monitor_download_connect", 0);
        if (r11 > 0) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r15) == true) goto L106;
        int r12 = -1;
        if (r14 != null) goto L99;
    L23:
        Object r13 = null;
    L25:
        if (r12 < 200) goto L28;
        if (r12 >= 400) goto L28;
    L50:
        Uri r18 = Uri.parse(r15);     // Catch: Throwable -> L21
        String r22 = r18.getHost();     // Catch: Throwable -> L21
        String r110 = r18.getPath();     // Catch: Throwable -> L21
        String r23 = r18.getLastPathSegment();     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r110) == false) goto L53;
    L55:
        JSONObject r111 = new JSONObject();     // Catch: Throwable -> L21
        r111.put("setting_tag", r10.a());     // Catch: Throwable -> L21 JSONException -> L62
        r111.put("url_host", r22);     // Catch: Throwable -> L21 JSONException -> L62
        r111.putOpt("host_ip", r16);     // Catch: Throwable -> L21 JSONException -> L62
        r111.putOpt("host_real_ip", r13);     // Catch: Throwable -> L21 JSONException -> L62
        r111.put("url_path", r110);     // Catch: Throwable -> L21 JSONException -> L62
        r111.put("url_last_path_segment", r23);     // Catch: Throwable -> L21 JSONException -> L62
        r111.put("net_lib", r19);     // Catch: Throwable -> L21 JSONException -> L62
        r111.put("connect_type", "get");     // Catch: Throwable -> L21 JSONException -> L62
        r111.put("status_code", r12);     // Catch: Throwable -> L21 JSONException -> L62
        if (r5 == null) goto L71;
        int r24 = r10.a("exception_msg_length", 500);     // Catch: Throwable -> L21 JSONException -> L62
        SparseArray r25 = DownloadHelper.f16133a;     // Catch: Throwable -> L21 JSONException -> L62
        if (r24 != 0) goto L65;
        String r26 = "";
    L61:
        r5 = r26;
    L70:
        r111.put("error_msg", r5);     // Catch: Throwable -> L21 JSONException -> L62
        goto L71
    L65:
        if (TextUtils.isEmpty(r5) == true) goto L70;
        if (r5.length() <= r24) goto L70;
        r26 = r5.substring(0, r24);     // Catch: Throwable -> L21 JSONException -> L62
    L71:
        r111.put(ICronetClient.KEY_CONNECT_TIME, r17);     // Catch: Throwable -> L21 JSONException -> L62
        r111.put("pkg_name", r21.B);     // Catch: Throwable -> L21 JSONException -> L62
        if (TextUtils.isEmpty(r21.f15810c) == false) goto L74;
        String r27 = r21.f15808b;     // Catch: Throwable -> L21 JSONException -> L62
    L75:
        r111.put("name", r27);     // Catch: Throwable -> L21 JSONException -> L62
    L79:
        if (r11 == 1) goto L81;
        if (r11 == 3) goto L81;
    L83:
        if (r11 == 2) goto L85;
        if (r11 == 3) goto L85;
        return;
    L85:
        InnerEventListener r28 = DownloadComponentManager.m();     // Catch: Throwable -> L21
        r21.l();     // Catch: Throwable -> L21
        r28.getClass();     // Catch: Throwable -> L21
        return;
    L81:
        Context r29 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L21
        goto L83
    L74:
        r27 = r21.f15810c;     // Catch: Throwable -> L21 JSONException -> L62
    L62:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
        goto L79
    L53:
        if (TextUtils.isEmpty(r23) == true) goto L55;
        r110 = r110.substring(0, r110.length() - r23.length());     // Catch: Throwable -> L89
    L28:
        if (r21.G == 0) goto L33;
        int r112 = r21.A0;     // Catch: Throwable -> L21
        if (r112 < 200) goto L101;
        if (r112 < 400) goto L33;
        return;
    L101:
        return;
    L33:
        if (r20 == null) goto L50;
        monitor-enter(DownloadComponentManager.class);     // Catch: Throwable -> L21
        Context r30 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L47
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L47
    L39:
        if (DownloadUtils.b(r30) == false) goto L41;
    L96:
        DownloadHelper.a(r20, "");     // Catch: Throwable -> L21 BaseException -> L45
        throw null;     // Catch: Throwable -> L21 BaseException -> L45
    L45:
        e = move-exception;
        r12 = e.f15601a;     // Catch: Throwable -> L21
        r5 = e.f15602b;     // Catch: Throwable -> L21
        goto L50
    L41:
        if (((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optBoolean("disable_check_no_network") == true) goto L96;
        r12 = 1049;
    L47:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L99:
        r12 = r14.b();     // Catch: Throwable -> L15
    L19:
        if ((r14 instanceof AbsDownloadHttpConnection) == false) goto L23;
        r13 = "";
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.printStackTrace();
        return;
    L106:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v2, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v7 */
    public static void a(int r21, DownloadSetting r22, DownloadInfo r23, String r24, String r25, String r26, IDownloadHttpConnection r27, boolean r28, boolean r29, BaseException r30, long r31, long r33, boolean r35, long r36, long r38, long r40) {
        if (r21 > 0) goto L5;
        return;
    L5:
        if (r33 <= 0) goto L95;
        Uri r10 = Uri.parse(r24);     // Catch: Throwable -> L13
        String r11 = r10.getHost();     // Catch: Throwable -> L13
        String r12 = r10.getPath();     // Catch: Throwable -> L13
        String r13 = r10.getLastPathSegment();     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r12) == false) goto L10;
    L15:
        String r14 = null;
        if (r28 == false) goto L18;
        int r5 = 1;
    L36:
        ?? r15 = new JSONObject();     // Catch: Throwable -> L13
        ?? r16 = -1;
        if (r27 == null) goto L52;
        int r17 = !(r27 instanceof IDefaultDownloadHttpConnection) ? 1 : 0;     // Catch: Throwable -> L13
        String r18 = r27.a("X-Cache");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r18) == true) goto L42;
        r16 = r18.toLowerCase().contains("hit");     // Catch: Throwable -> L13
    L42:
        if (r22.a("monitor_sla", 1) != 1) goto L49;
        if (r28 == true) goto L49;
        if (r29 == true) goto L49;
        if ((r27 instanceof AbsDownloadHttpConnection) == false) goto L49;
        AbsDownloadHttpConnection r19 = (AbsDownloadHttpConnection) r27;     // Catch: Throwable -> L13
    L49:
        if ((r27 instanceof AbsDownloadHttpConnection) == false) goto L51;
        AbsDownloadHttpConnection r20 = (AbsDownloadHttpConnection) r27;     // Catch: Throwable -> L13
    L51:
        ?? r32 = r16;
    L53:
        double r110 = r31 / 1048576.0d;     // Catch: Throwable -> L13
        double r34 = r33;
        double r111 = r34 / TimeUnit.SECONDS.toNanos(1);     // Catch: Throwable -> L13
        r15.put("setting_tag", r22.a());     // Catch: Throwable -> L13
        r15.put("url_host", r11);     // Catch: Throwable -> L13
        r15.putOpt("host_ip", r25);     // Catch: Throwable -> L13
        r15.putOpt("host_real_ip", r26);     // Catch: Throwable -> L13
        r15.put("url_path", r12);     // Catch: Throwable -> L13
        r15.put("url_last_path_segment", r13);     // Catch: Throwable -> L13
        r15.put("net_lib", r17);     // Catch: Throwable -> L13
        r15.put("hit_cdn_cache", r32);     // Catch: Throwable -> L13
        r15.put("status_code", r5);     // Catch: Throwable -> L13
        r15.put("request_log", "");     // Catch: Throwable -> L13
        if (r14 == null) goto L66;
        int r37 = r22.a("exception_msg_length", 500);     // Catch: Throwable -> L13
        SparseArray r39 = DownloadHelper.f16133a;     // Catch: Throwable -> L13
        if (r37 != 0) goto L60;
        String r41 = "";
    L58:
        r14 = r41;
    L65:
        r15.put("error_msg", r14);     // Catch: Throwable -> L13
        goto L66
    L60:
        if (TextUtils.isEmpty(r14) == true) goto L65;
        if (r14.length() <= r37) goto L65;
        r41 = r14.substring(0, r37);     // Catch: Throwable -> L13
    L66:
        r15.put("download_sec", r111);     // Catch: Throwable -> L13
        r15.put("download_mb", r110);     // Catch: Throwable -> L13
        if (r111 <= 0.0d) goto L69;
        r15.put("download_speed", r110 / r111);     // Catch: Throwable -> L13
    L69:
        if (r35 == false) goto L71;
        r15.put("rw_read_time", r36 / r34);     // Catch: Throwable -> L13
        r15.put("rw_write_time", r38 / r34);     // Catch: Throwable -> L13
        r15.put("rw_sync_time", r40 / r34);     // Catch: Throwable -> L13
    L71:
        r15.put("pkg_name", r23.B);     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r23.f15810c) == false) goto L74;
        String r42 = r23.f15808b;     // Catch: Throwable -> L13
    L75:
        r15.put("name", r42);     // Catch: Throwable -> L13
        if (r21 == 1) goto L80;
        if (r21 == 3) goto L80;
    L81:
        if (r21 == 2) goto L83;
        if (r21 == 3) goto L83;
        return;
    L83:
        InnerEventListener r43 = DownloadComponentManager.m();     // Catch: Throwable -> L13
        r23.l();     // Catch: Throwable -> L13
        r43.getClass();     // Catch: Throwable -> L13
        return;
    L80:
        Context r44 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L13
        goto L81
    L74:
        r42 = r23.f15810c;     // Catch: Throwable -> L13
        goto L75
    L52:
        r32 = -1;
        r17 = -1;
        goto L53
    L18:
        if (r29 == false) goto L20;
        r5 = 2;
        goto L36
    L20:
        if (r30 != null) goto L22;
        r5 = 0;
        goto L36
    L22:
        monitor-enter(DownloadComponentManager.class);     // Catch: Throwable -> L13
        Context r112 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L32
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L32
    L26:
        if (DownloadUtils.b(r112) == true) goto L30;
        LruCache r113 = DownloadSetting.e;     // Catch: Throwable -> L13
        if (((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optBoolean("disable_check_no_network") == true) goto L30;
        int r114 = 1049;
    L31:
        int r210 = r114;
        r14 = r30.f15602b;     // Catch: Throwable -> L13
        r5 = r210;
    L30:
        r114 = r30.f15601a;     // Catch: Throwable -> L13
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L10:
        if (TextUtils.isEmpty(r13) == true) goto L15;
        r12 = r12.substring(0, r12.length() - r13.length());     // Catch: Throwable -> L87
    L13:
        th = move-exception;
        th.printStackTrace();
        return;
    }
}
