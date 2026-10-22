package com.ss.android.socialbase.downloader.f;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.downloader.p;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.d;
import com.ss.android.socialbase.downloader.model.e;
import com.ss.android.socialbase.downloader.network.g;
import com.ss.android.socialbase.downloader.network.h;
import com.ss.android.socialbase.downloader.segment.i;
import com.ss.android.socialbase.downloader.service.k;
import com.ss.android.socialbase.downloader.service.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.f.a$a, reason: collision with other inner class name */
    private static class C0829a {
        List<String> A;
        int B;
        boolean C;
        String D;
        String E;
        boolean F;
        JSONObject G;
        String H;
        String I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        String f15442J;
        int K;
        e L;
        d M;
        long N;
        long O;
        long P;
        long Q;
        boolean R;
        long S;
        long T;
        double U;
        long V;
        long W;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        BaseException f15444b;
        String c;
        int d;
        String e;
        String f;
        String g;
        long h;
        long i;
        long j;
        long k;
        String l;
        boolean m;
        boolean n;
        boolean o;
        String p;
        boolean q;
        int r;
        boolean s;
        ByteInvalidRetryStatus t;
        AsyncHandleStatus u;
        boolean v;
        String w;
        boolean x;
        List<String> y;
        int z;

        private C0829a() {
            this.t = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
            this.u = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        }

        /* synthetic */ C0829a(AnonymousClass1 r1) {
            this();
        }
    }

    private static C0829a a(String r3, DownloadInfo r4, DownloadTask r5, BaseException r6, int r7) {
        C0829a r0 = new C0829a(null);
        r0.f15443a = r7;
        r0.f15444b = r6;
        r0.c = r3;
        if (r4 == null) goto L15;
        r0.d = r4.getId();
        r0.e = r4.getName();
        r0.f = r4.getUrl();
        r0.g = r4.getSavePath();
        r0.h = r4.getDownloadTime();
        r0.i = r4.getCurBytes();
        r0.j = r4.getBackCurBytes();
        r0.k = r4.getTotalBytes();
        r0.l = r4.getNetworkQuality();
        r0.m = r4.isOnlyWifi();
        r0.n = r4.isNeedHttpsToHttpRetry();
        r0.o = r4.isHttpsToHttpRetryUsed();
        r0.p = r4.getMd5();
        r0.q = r4.isForce();
        r0.r = r4.getRetryCount();
        r0.s = r4.isNeedDefaultHttpServiceBackUp();
        r0.t = r4.getByteInvalidRetryStatus();
        r0.u = r4.getAsyncHandleStatus();
        r0.v = r4.isNeedIndependentProcess();
        r0.w = r4.getExtra();
        r0.x = r4.isAddListenerToSameTask();
        r0.y = r4.getBackUpUrls();
        r0.z = r4.getCurBackUpUrlIndex();
        r0.A = r4.getForbiddenBackupUrls();
        r0.B = r4.getCurNetworkRetryCount();
        r0.C = r4.isCacheExistsInDownloading();
        r0.D = r4.getMimeType();
        r0.E = r4.getContentEncoding();
        r0.F = r4.isFastDownload();
        r0.G = r4.getPcdnStats();
        r0.V = r4.getThrottleNetSpeed();
        r0.H = r4.getHttpRequestHeader();
        r0.I = r4.getHttpResponseHeader();
        r0.f15442J = r4.getRequestLog();
        r0.K = r4.getEnqueueType().ordinal();
        if (r7 != (-3)) goto L7;
    L12:
        r0.N = r4.getAllConnectTime();
        r0.O = r4.getFirstSpeedTime();
        r0.P = r4.getRealDownloadTime();
        r0.Q = r4.getRealBackDownloadTime();
        r0.R = r4.isBackUpUrlUsed();
        r0.S = r4.getCurRetryTime();
        r0.T = r4.getCurRetryTimeInTotal();
        r0.W = r4.getMd5Time();
    L13:
        if (r7 != (-3)) goto L15;
        r0.U = r4.getDownloadSpeed();
        goto L15
    L7:
        if (r7 == (-4)) goto L12;
        if (r7 == (-1)) goto L12;
        if (r7 != (-2)) goto L13;
    L15:
        if (r5 == null) goto L17;
        r0.L = r5.getTimingInfo().c();
        r0.M = r5.getThreadInfo().b();
    L17:
        return r0;
    }

    static /* synthetic */ JSONObject a(C0829a r0) {
        return b(r0);
    }

    public static void a(IDownloadMonitorDepend r2, DownloadInfo r3, BaseException r4, int r5) {
        final IDownloadMonitorDepend r6 = (IDownloadMonitorDepend) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadMonitorDepend.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        String r0 = r6.getEventPage();
        if (TextUtils.isEmpty(r0) == false) goto L8;
        r0 = "default";
    L8:
        final C0829a r7 = a(r0, r3, null, r4, r5);
        com.ss.android.socialbase.downloader.downloader.b.a(new AnonymousClass1(r7, r6));
    }

    static /* synthetic */ void a(C0829a r0, JSONObject r1) {
        b(r0, r1);
    }

    public static void a(b r2, DownloadTask r3, DownloadInfo r4, BaseException r5, int r6) {
        final b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        if (r4.isNeedSDKMonitor() == false) goto L10;
        final C0829a r8 = a(r4.getMonitorScene(), r4, r3, r5, r6);
        com.ss.android.socialbase.downloader.downloader.b.a(new AnonymousClass2(r8, r7));
        return;
    }

    public static void a(com.ss.android.socialbase.downloader.g.a r23, DownloadInfo r24, String r25, h r26, boolean r27, boolean r28, BaseException r29, long r30, long r32, boolean r34, long r35, long r37, long r39, JSONObject r41) {
        h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r26, h.class, "com.obric.memorydata.plugin");
        a("download_io", r23.b("monitor_download_io"), r23, r24, r25, null, null, r7, r27, r28, r29, r30, r32, r34, r35, r37, r39, null);
    }

    public static void a(com.ss.android.socialbase.downloader.g.a r23, DownloadInfo r24, String r25, String r26, String r27, boolean r28, h r29, BaseException r30, long r31, long r33) {
        h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r29, h.class, "com.obric.memorydata.plugin");
        a("segment_io", r23.b("monitor_segment_io"), r23, r24, r25, r26, r27, r7, r28, false, r30, r31, r33, false, -1, -1, -1, null);
    }

    public static void a(DownloadInfo r4, List<i> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L7
        r1.put("segments", i.a(r6));     // Catch: Throwable -> L7
        r1.put("cur_bytes", r4.getCurBytes());     // Catch: Throwable -> L7
        r1.put("total_bytes", r4.getTotalBytes());     // Catch: Throwable -> L7
        c r7 = com.ss.android.socialbase.downloader.downloader.b.U();     // Catch: Throwable -> L7
        if (r7 == null) goto L12;
        r7.a(r4.getId(), "segments_error", r1);     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public static void a(DownloadTask r4, BaseException r5, int r6) {
        if (r4 != null) goto L27;
        return;
    L27:
        DownloadInfo r0 = r4.getDownloadInfo();     // Catch: Throwable -> L24
        if (r0 != null) goto L7;
        return;
    L7:
        IDownloadMonitorDepend r1 = r4.getMonitorDepend();     // Catch: Throwable -> L24
        boolean r2 = DownloadStatus.isMonitorStatus(r6);     // Catch: Throwable -> L24
        if (r2 == true) goto L15;
        r2 = a(r0.getExtraMonitorStatus(), r6);     // Catch: Throwable -> L24
        if (r2 == true) goto L15;
        if (r1 == null) goto L15;
        if (ZeusTransformUtils.instanceOf(r1, com.ss.android.socialbase.downloader.depend.c.class) == false) goto L15;
        r2 = a(((com.ss.android.socialbase.downloader.depend.c) ZeusTransformUtils.preCheckCast(r1, com.ss.android.socialbase.downloader.depend.c.class, "com.obric.memorydata.plugin")).a(), r6);     // Catch: Throwable -> L24
    L15:
        if (r2 == false) goto L31;
        n r3 = r4.getDepend();     // Catch: Throwable -> L20
        if (r3 == null) goto L22;
        r3.a(r0, r5, r6);     // Catch: Throwable -> L20
    L22:
        a(r1, r0, r5, r6);     // Catch: Throwable -> L24
        a(com.ss.android.socialbase.downloader.downloader.b.f(), r4, r0, r5, r6);     // Catch: Throwable -> L24
        return;
    L20:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L24
        goto L22
    L31:
        return;
    L24:
        th = move-exception;
        a(th);
        th.printStackTrace();
    }

    public static void a(com.ss.android.socialbase.downloader.model.c r5) {
        b r0 = com.ss.android.socialbase.downloader.downloader.b.f();
        if (r0 != null) goto L10;
        return;
    L10:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L7
        r1.put("db_init_duration", r5.f15565a);     // Catch: Throwable -> L7
        r1.put("db_init_disk_cache_count", r5.f15566b);     // Catch: Throwable -> L7
        r1.put("db_init_memory_cache_count", r5.c);     // Catch: Throwable -> L7
        r1.put("db_init_disk_cache_size", r5.d);     // Catch: Throwable -> L7
        r0.a("download_db", r1, null, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public static void a(g r13, String r14, String r15, long r16, String r18, int r19, IOException r20, DownloadInfo r21) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r13, g.class, "com.obric.memorydata.plugin");
        if (r21 != null) goto L5;
        return;
    L5:
        com.ss.android.socialbase.downloader.g.a r5 = com.ss.android.socialbase.downloader.g.a.a(r21.getId());
        int r7 = r5.a("monitor_download_connect", 0);
        if (r7 > 0) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r14) == false) goto L11;
        return;
    L11:
        int r8 = -1;
        if (r4 != null) goto L72;
    L21:
        String r6 = null;
    L23:
        if (r8 < 200) goto L26;
        if (r8 >= 400) goto L26;
    L41:
        String r0 = null;
    L42:
        Uri r1 = Uri.parse(r14);     // Catch: Throwable -> L66
        String r3 = r1.getHost();     // Catch: Throwable -> L66
        String r10 = r1.getPath();     // Catch: Throwable -> L66
        String r2 = r1.getLastPathSegment();     // Catch: Throwable -> L66
        if (TextUtils.isEmpty(r10) == false) goto L45;
    L47:
        JSONObject r9 = new JSONObject();     // Catch: Throwable -> L66
        r9.put("setting_tag", r5.d("setting_tag"));     // Catch: JSONException -> L53 Throwable -> L66
        r9.put("url_host", r3);     // Catch: JSONException -> L53 Throwable -> L66
        r9.putOpt("host_ip", r15);     // Catch: JSONException -> L53 Throwable -> L66
        r9.putOpt("host_real_ip", r6);     // Catch: JSONException -> L53 Throwable -> L66
        r9.put("url_path", r10);     // Catch: JSONException -> L53 Throwable -> L66
        r9.put("url_last_path_segment", r2);     // Catch: JSONException -> L53 Throwable -> L66
        r9.put("net_lib", r19);     // Catch: JSONException -> L53 Throwable -> L66
        r9.put("connect_type", r18);     // Catch: JSONException -> L53 Throwable -> L66
        r9.put("status_code", r8);     // Catch: JSONException -> L53 Throwable -> L66
        if (r0 == null) goto L51;
        r9.put("error_msg", com.ss.android.socialbase.downloader.utils.c.a(r0, r5.a("exception_msg_length", 500)));     // Catch: JSONException -> L53 Throwable -> L66
    L51:
        r9.put("connect_time", r16);     // Catch: JSONException -> L53 Throwable -> L66
        r9.put("pkg_name", r21.getPackageName());     // Catch: JSONException -> L53 Throwable -> L66
        r9.put(ActivityLifecycle.NAME, r21.getTitle());     // Catch: JSONException -> L53 Throwable -> L66
    L56:
        if (r7 == 1) goto L58;
        if (r7 == 3) goto L58;
    L62:
        if (r7 == 2) goto L64;
        if (r7 == 3) goto L64;
        return;
    L64:
        com.ss.android.socialbase.downloader.downloader.b.U().a(r21.getId(), "download_connect", r9);     // Catch: Throwable -> L66
        return;
    L58:
        b r11 = com.ss.android.socialbase.downloader.downloader.b.f();     // Catch: Throwable -> L66
        if (r11 == null) goto L62;
        r11.a("download_connect", r9, null, null);     // Catch: Throwable -> L66
    L53:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L66
        goto L56
    L45:
        if (TextUtils.isEmpty(r2) == true) goto L47;
        r10 = r10.substring(0, r10.length() - r2.length());     // Catch: Throwable -> L69
    L26:
        if (r21.getCurRetryTime() == 0) goto L31;
        int r12 = r21.getHttpStatusCode();     // Catch: Throwable -> L66
        if (r12 < 200) goto L30;
        if (r12 < 400) goto L31;
        return;
    L30:
        return;
    L31:
        if (r20 == null) goto L41;
        if (com.ss.android.socialbase.downloader.utils.g.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L35;
    L76:
        com.ss.android.socialbase.downloader.utils.c.a(r20, "");     // Catch: BaseException -> L39 Throwable -> L66
    L39:
        e = move-exception;
        r8 = e.getErrorCode();     // Catch: Throwable -> L66
        r0 = e.getErrorMessage();     // Catch: Throwable -> L66
        goto L42
    L35:
        if (com.ss.android.socialbase.downloader.g.a.b().optBoolean("disable_check_no_network") == true) goto L76;
        r8 = 1049;
        goto L41
    L72:
        r8 = r4.b();     // Catch: Throwable -> L15
    L19:
        if (ZeusTransformUtils.instanceOf(r4, com.ss.android.socialbase.downloader.network.a.class) == false) goto L21;
        r6 = ((com.ss.android.socialbase.downloader.network.a) ZeusTransformUtils.preCheckCast(r4, com.ss.android.socialbase.downloader.network.a.class, "com.obric.memorydata.plugin")).e();     // Catch: Throwable -> L66
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        th.printStackTrace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.ss.android.socialbase.downloader.f.c] */
    /* JADX WARN: Type inference failed for: r11v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v16, types: [com.ss.android.socialbase.downloader.network.a] */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.ss.android.socialbase.downloader.f.b] */
    private static void a(String r19, int r20, com.ss.android.socialbase.downloader.g.a r21, DownloadInfo r22, String r23, String r24, String r25, h r26, boolean r27, boolean r28, BaseException r29, long r30, long r32, boolean r34, long r35, long r37, long r39, JSONObject r41) {
        h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r26, h.class, "com.obric.memorydata.plugin");
        if (r20 > 0) goto L5;
        return;
    L5:
        if (r32 <= 0) goto L80;
        Uri r8 = Uri.parse(r23);     // Catch: Throwable -> L70
        String r9 = r8.getHost();     // Catch: Throwable -> L70
        String r10 = r8.getPath();     // Catch: Throwable -> L70
        String r11 = r8.getLastPathSegment();     // Catch: Throwable -> L70
        if (TextUtils.isEmpty(r10) == false) goto L10;
    L12:
        if (r27 == false) goto L15;
        int r12 = 1;
    L14:
        String r15 = null;
    L26:
        ?? r13 = new JSONObject();     // Catch: Throwable -> L70
        String r16 = "";
        ?? r17 = -1;
        if (r6 != null) goto L29;
        String r7 = "";
        int r14 = -1;
        ?? r18 = -1;
    L48:
        double r0 = r30 / 1048576.0d;     // Catch: Throwable -> L70
        double r3 = r32;
        double r1 = r3 / TimeUnit.SECONDS.toNanos(1);     // Catch: Throwable -> L70
        r13.put("setting_tag", r21.d("setting_tag"));     // Catch: Throwable -> L70
        r13.put("url_host", r9);     // Catch: Throwable -> L70
        r13.putOpt("host_ip", r24);     // Catch: Throwable -> L70
        r13.putOpt("host_real_ip", r25);     // Catch: Throwable -> L70
        r13.put("url_path", r10);     // Catch: Throwable -> L70
        r13.put("url_last_path_segment", r11);     // Catch: Throwable -> L70
        r13.put("net_lib", r14);     // Catch: Throwable -> L70
        r13.put("hit_cdn_cache", r18);     // Catch: Throwable -> L70
        r13.put("status_code", r12);     // Catch: Throwable -> L70
        r13.put("request_log", r7);     // Catch: Throwable -> L70
        if (r15 == null) goto L51;
        r13.put("error_msg", com.ss.android.socialbase.downloader.utils.c.a(r15, r21.a("exception_msg_length", 500)));     // Catch: Throwable -> L70
    L51:
        r13.put("download_sec", r1);     // Catch: Throwable -> L70
        r13.put("download_mb", r0);     // Catch: Throwable -> L70
        if (r1 <= 0.0d) goto L54;
        r13.put("download_speed", r0 / r1);     // Catch: Throwable -> L70
    L54:
        if (r34 == false) goto L56;
        r13.put("rw_read_time", r35 / r3);     // Catch: Throwable -> L70
        r13.put("rw_write_time", r37 / r3);     // Catch: Throwable -> L70
        r13.put("rw_sync_time", r39 / r3);     // Catch: Throwable -> L70
    L56:
        r13.put("pkg_name", r22.getPackageName());     // Catch: Throwable -> L70
        r13.put(ActivityLifecycle.NAME, r22.getTitle());     // Catch: Throwable -> L70
        if (r20 == 1) goto L61;
        if (r20 == 3) goto L61;
        int r2 = 2;
        String r4 = r19;
    L66:
        if (r20 == r2) goto L68;
        if (r20 == 3) goto L68;
        return;
    L68:
        com.ss.android.socialbase.downloader.downloader.b.U().a(r22.getId(), r4, r13);     // Catch: Throwable -> L70
        return;
    L61:
        ?? r5 = com.ss.android.socialbase.downloader.downloader.b.f();     // Catch: Throwable -> L70
        if (r5 == 0) goto L64;
        r4 = r19;
        r5.a(r4, r13, null, null);     // Catch: Throwable -> L70
    L65:
        r2 = 2;
        goto L66
    L64:
        r4 = r19;
        goto L65
    L29:
        if (ZeusTransformUtils.instanceOf(r6, com.ss.android.socialbase.downloader.network.e.class) == false) goto L31;
        int r110 = 0;
    L32:
        String r111 = r6.a("X-Cache");     // Catch: Throwable -> L70
        if (TextUtils.isEmpty(r111) == true) goto L37;
        r17 = r111.toLowerCase().contains("hit");     // Catch: Throwable -> L70
    L37:
        if (r21.a("monitor_sla", 1) != 1) goto L44;
        if (r27 == true) goto L44;
        if (r28 == true) goto L44;
        if (ZeusTransformUtils.instanceOf(r6, com.ss.android.socialbase.downloader.network.a.class) == false) goto L44;
        ((com.ss.android.socialbase.downloader.network.a) ZeusTransformUtils.preCheckCast(r6, com.ss.android.socialbase.downloader.network.a.class, "com.obric.memorydata.plugin")).a(r13, true);     // Catch: Throwable -> L70
    L44:
        if (ZeusTransformUtils.instanceOf(r6, com.ss.android.socialbase.downloader.network.a.class) == false) goto L46;
        r16 = ((com.ss.android.socialbase.downloader.network.a) ZeusTransformUtils.preCheckCast(r6, com.ss.android.socialbase.downloader.network.a.class, "com.obric.memorydata.plugin")).h();     // Catch: Throwable -> L70
    L46:
        r14 = r110;
        r7 = r16;
        r18 = r17;
        goto L48
    L31:
        r110 = 1;
        goto L32
    L15:
        if (r28 == false) goto L17;
        r12 = 2;
        goto L14
    L17:
        if (r29 != null) goto L19;
        r12 = 0;
        goto L14
    L19:
        if (com.ss.android.socialbase.downloader.utils.g.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L21;
    L23:
        r12 = r29.getErrorCode();     // Catch: Throwable -> L70
    L24:
        r15 = r29.getErrorMessage();     // Catch: Throwable -> L70
        goto L26
    L21:
        if (com.ss.android.socialbase.downloader.g.a.b().optBoolean("disable_check_no_network") == true) goto L23;
        r12 = 1049;
        goto L24
    L10:
        if (TextUtils.isEmpty(r11) == true) goto L12;
        r10 = r10.substring(0, r10.length() - r11.length());     // Catch: Throwable -> L73
    L70:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public static void a(String r5, h r6, Throwable r7, j r8) {
        h r9 = (h) ZeusTransformUtils.wrapperContextForParams(r6, h.class, "com.obric.memorydata.plugin");
        j r10 = (j) ZeusTransformUtils.wrapperContextForParams(r8, j.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L46;
        if (r5 == null) goto L48;
        com.ss.android.socialbase.downloader.model.b r0 = new com.ss.android.socialbase.downloader.model.b();
        boolean r2 = false;
        boolean r3 = true;
        if (r9 != null) goto L9;
    L19:
        if (r7 != null) goto L21;
        r3 = r2;
    L35:
        if (r3 == false) goto L47;
        r0.f = Uri.parse(r5).getHost();     // Catch: Throwable -> L39
    L37:
        r10.a(r0);
        return;
    L47:
        return;
    L21:
        if (r0.d > 0) goto L44;
        r0.d = ((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).h().a(r7);
    L44:
        com.ss.android.socialbase.downloader.utils.c.a(r7, "monitor_cdn");     // Catch: BaseException -> L25 DownloadTTNetException -> L28
    L33:
        r0.c = r7.toString();
        goto L35
    L28:
        e = move-exception;
        if (r0.g != null) goto L32;
        r0.g = e.getRemoteIp();
    L32:
        int r11 = e.getErrorCode();
    L27:
        r0.f15564b = r11;
    L25:
        e = move-exception;
        r11 = e.getErrorCode();
        goto L27
    L9:
        if (ZeusTransformUtils.instanceOf(r9, com.ss.android.socialbase.downloader.network.a.class) == false) goto L19;
        com.ss.android.socialbase.downloader.network.a r12 = (com.ss.android.socialbase.downloader.network.a) ZeusTransformUtils.preCheckCast(r9, com.ss.android.socialbase.downloader.network.a.class, "com.obric.memorydata.plugin");
    L16:
        th = move-exception;
        th.printStackTrace();
    L18:
        r2 = true;
        goto L19
    L12:
        if (r12.f() == true) goto L14;
        r2 = true;
    L14:
        r0.f15563a = r2;     // Catch: Throwable -> L16
        r0.d = r12.b();     // Catch: Throwable -> L16
        r0.g = r12.e();     // Catch: Throwable -> L16
        r0.e = com.ss.android.socialbase.downloader.utils.c.b(r12.g());     // Catch: Throwable -> L16
        goto L18
    L48:
        return;
    }

    public static void a(Throwable r4) {
        b r0 = com.ss.android.socialbase.downloader.downloader.b.f();
        if (r0 != null) goto L10;
        return;
    L10:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L7
        r1.put("error_code", 1091);     // Catch: Throwable -> L7
        r1.put("error_msg", r4.toString());     // Catch: Throwable -> L7
        r1.put("download_status", -1);     // Catch: Throwable -> L7
        r1.put("error_stack", Log.getStackTraceString(r4));     // Catch: Throwable -> L7
        r0.a("download_failed", r1, null, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    private static boolean a(int[] r3, int r4) {
        if (r3 != null) goto L5;
    L14:
        return false;
    L5:
        if (r3.length <= 0) goto L14;
        int r1 = 0;
    L8:
        if (r1 >= r3.length) goto L14;
        if (r4 == r3[r1]) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        return true;
    }

    private static JSONObject b(C0829a r10) {
        JSONObject r1 = null;
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L128
        p r3 = com.ss.android.socialbase.downloader.downloader.b.h();     // Catch: JSONException -> L126
        int r4 = 0;
        String r5 = "";
        if (r3 == null) goto L8;
        String r6 = r3.b();     // Catch: JSONException -> L126
        String r7 = com.ss.android.socialbase.downloader.utils.g.e(r6);     // Catch: JSONException -> L126
        String r8 = r3.a();     // Catch: JSONException -> L126
        int r9 = r3.c();     // Catch: JSONException -> L126
    L9:
        r2.put("event_page", r10.c);     // Catch: JSONException -> L126
        r2.put("app_id", r8);     // Catch: JSONException -> L126
        r2.put("device_id", r6);     // Catch: JSONException -> L126
        r2.put("device_id_postfix", r7);     // Catch: JSONException -> L126
        r2.put("update_version", r9);     // Catch: JSONException -> L126
        r2.put("download_status", r10.f15443a);     // Catch: JSONException -> L126
        r2.put("abhit", com.ss.android.socialbase.downloader.downloader.b.P().d());     // Catch: JSONException -> L126
        r2.put("setting_tag", com.ss.android.socialbase.downloader.g.a.a(r10.d).d("setting_tag"));     // Catch: JSONException -> L126
        r2.put("download_id", r10.d);     // Catch: JSONException -> L126
        r2.put(ActivityLifecycle.NAME, r10.e);     // Catch: JSONException -> L126
        r2.put("url", r10.f);     // Catch: JSONException -> L126
        r2.put("save_path", r10.g);     // Catch: JSONException -> L126
        r2.put("download_time", r10.h);     // Catch: JSONException -> L126
        r2.put("cur_bytes", r10.i);     // Catch: JSONException -> L126
        r2.put("background_download_bytes", r10.j);     // Catch: JSONException -> L126
        r2.put("total_bytes", r10.k);     // Catch: JSONException -> L126
        r2.put("network_quality", r10.l);     // Catch: JSONException -> L126
        int r11 = 1;
        if (r10.m == false) goto L12;
        int r12 = 1;
    L13:
        r2.put("only_wifi", r12);     // Catch: JSONException -> L126
        if (r10.n == false) goto L16;
        int r13 = 1;
    L17:
        r2.put("need_https_degrade", r13);     // Catch: JSONException -> L126
        if (r10.o == false) goto L20;
        int r14 = 1;
    L21:
        r2.put("https_degrade_retry_used", r14);     // Catch: JSONException -> L126
        if (r10.p != null) goto L24;
        String r15 = "";
    L25:
        r2.put("md5", r15);     // Catch: JSONException -> L126
        if (r10.q == false) goto L28;
        int r16 = 1;
    L29:
        r2.put("is_force", r16);     // Catch: JSONException -> L126
        r2.put("retry_count", r10.r);     // Catch: JSONException -> L126
        if (r10.s == false) goto L32;
        int r17 = 1;
    L33:
        r2.put("default_http_service_backup", r17);     // Catch: JSONException -> L126
        r2.put("download_byte_error_retry_status", r10.t.ordinal());     // Catch: JSONException -> L126
        r2.put("forbidden_handler_status", r10.u.ordinal());     // Catch: JSONException -> L126
        if (r10.v == false) goto L36;
        int r18 = 1;
    L37:
        r2.put("need_independent_process", r18);     // Catch: JSONException -> L126
        if (r10.w == null) goto L40;
        String r19 = r10.w;     // Catch: JSONException -> L126
    L41:
        r2.put(WsConstants.KEY_EXTRA, r19);     // Catch: JSONException -> L126
        if (r10.x == false) goto L44;
        int r20 = 1;
    L45:
        r2.put("add_listener_to_same_task", r20);     // Catch: JSONException -> L126
        if (r10.y == null) goto L48;
        int r21 = r10.y.size();     // Catch: JSONException -> L126
    L49:
        r2.put("backup_url_count", r21);     // Catch: JSONException -> L126
        if (r10.y == null) goto L52;
        String r22 = r10.y.toString();     // Catch: JSONException -> L126
    L53:
        r2.put("backup_url", r22);     // Catch: JSONException -> L126
        if (r10.y == null) goto L56;
        int r23 = r10.z;     // Catch: JSONException -> L126
    L57:
        r2.put("cur_backup_url_index", r23);     // Catch: JSONException -> L126
        if (r10.A == null) goto L60;
        String r24 = r10.A.toString();     // Catch: JSONException -> L126
    L61:
        r2.put("forbidden_urls", r24);     // Catch: JSONException -> L126
        r2.put("network_retry_count", r10.B);     // Catch: JSONException -> L126
        r2.put("cache_exists_in_downloading", r10.C);     // Catch: JSONException -> L126
        r2.put("content_type", r10.D);     // Catch: JSONException -> L126
        r2.put("content_encoding", r10.E);     // Catch: JSONException -> L126
        if (r10.F == false) goto L64;
        int r25 = 1;
    L65:
        r2.put("fast_download", r25);     // Catch: JSONException -> L126
        if (r10.f15442J != null) goto L68;
        String r26 = "";
    L69:
        r2.put("request_log", r26);     // Catch: JSONException -> L126
        if (r10.H != null) goto L72;
        String r27 = "";
    L73:
        r2.put("request_header", r27);     // Catch: JSONException -> L126
        if (r10.I != null) goto L76;
        String r28 = "";
    L77:
        r2.put("response_header", r28);     // Catch: JSONException -> L126
        r2.put("enqueue_type", r10.K);     // Catch: JSONException -> L126
        if (r10.G == null) goto L81;
        r2.put("pcdn_log", r10.G);     // Catch: JSONException -> L126
    L81:
        if (r10.L == null) goto L84;
        r2.put("origin_timing_info", r10.L.b());     // Catch: JSONException -> L126
        r2.put("timing_info", r10.L.a());     // Catch: JSONException -> L126
    L84:
        if (r10.M == null) goto L87;
        r2.put("thread_info", r10.M.a());     // Catch: JSONException -> L126
    L87:
        if (r10.f15443a != (-3)) goto L89;
    L94:
        r2.put("all_connect_time", r10.N);     // Catch: JSONException -> L126
        r2.put("first_speed_time", r10.O);     // Catch: JSONException -> L126
        r2.put("real_download_time", r10.P);     // Catch: JSONException -> L126
        r2.put("background_download_time", r10.Q);     // Catch: JSONException -> L126
        if (r10.R == true) goto L98;
        r11 = 0;
    L98:
        r2.put("backup_url_used", r11);     // Catch: JSONException -> L126
        r2.put("cur_retry_time", r10.S);     // Catch: JSONException -> L126
        r2.put("cur_retry_time_in_total", r10.T);     // Catch: JSONException -> L126
        r2.put("md5_time", r10.W);     // Catch: JSONException -> L126
        r2.put("device_available_space", ((com.ss.android.socialbase.downloader.utils.g.c(r10.g) / 1024) / 1024) / 100);     // Catch: Throwable -> L101
    L135:
    L116:
        th = move-exception;
        th.printStackTrace();     // Catch: JSONException -> L126
    L119:
        if (r10.f15444b == null) goto L121;
        r4 = r10.f15444b.getErrorCode();     // Catch: JSONException -> L126
    L121:
        r2.put("error_code", r4);     // Catch: JSONException -> L126
        if (r10.f15444b == null) goto L124;
        r5 = r10.f15444b.getErrorMessage();     // Catch: JSONException -> L126
    L124:
        r2.put("error_msg", r5);     // Catch: JSONException -> L126
        return r2;
    L104:
        if (TextUtils.isEmpty(r10.f) == true) goto L113;
        Uri r0 = Uri.parse(r10.f);     // Catch: Throwable -> L116
        String r29 = r0.getHost();     // Catch: Throwable -> L116
        String r30 = r0.getPath();     // Catch: Throwable -> L116
        String r31 = r0.getLastPathSegment();     // Catch: Throwable -> L116
        if (TextUtils.isEmpty(r30) == false) goto L108;
    L114:
        r2.put("url_host", r29);     // Catch: Throwable -> L116
        r2.put("url_path", r30);     // Catch: Throwable -> L116
        r2.put("url_last_path_segment", r31);     // Catch: Throwable -> L116
    L108:
        if (TextUtils.isEmpty(r31) == true) goto L114;
        r30 = r30.substring(0, r30.length() - r31.length());     // Catch: Throwable -> L111
    L111:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L116
        goto L114
    L113:
        r31 = "";
        r29 = r31;
        r30 = r29;
    L101:
        th = move-exception;
        th.printStackTrace();     // Catch: JSONException -> L126
        goto L135
    L89:
        if (r10.f15443a == (-4)) goto L94;
        if (r10.f15443a == (-1)) goto L94;
        if (r10.f15443a != (-2)) goto L135;
    L76:
        r28 = r10.I;     // Catch: JSONException -> L126
        goto L77
    L72:
        r27 = r10.H;     // Catch: JSONException -> L126
        goto L73
    L68:
        r26 = r10.f15442J;     // Catch: JSONException -> L126
        goto L69
    L64:
        r25 = 0;
        goto L65
    L60:
        r24 = "";
        goto L61
    L56:
        r23 = -1;
        goto L57
    L52:
        r22 = "";
        goto L53
    L48:
        r21 = 0;
        goto L49
    L44:
        r20 = 0;
        goto L45
    L40:
        r19 = "";
        goto L41
    L36:
        r18 = 0;
        goto L37
    L32:
        r17 = 0;
        goto L33
    L28:
        r16 = 0;
        goto L29
    L24:
        r15 = r10.p;     // Catch: JSONException -> L126
        goto L25
    L20:
        r14 = 0;
        goto L21
    L16:
        r13 = 0;
        goto L17
    L12:
        r12 = 0;
        goto L13
    L8:
        r9 = 0;
        r6 = "";
        r7 = r6;
        r8 = r7;
    L126:
        e = e;
        r1 = r2;
    L129:
        a(e);
        e.printStackTrace();
        return r1;
    L128:
        e = e;
        goto L129
    }

    private static void b(C0829a r4, JSONObject r5) {
        int r0 = r4.f15443a;
        if (r0 != (-5)) goto L5;
        String r6 = "download_uncomplete";
    L26:
        r5.put("status", r6);
        return;
    L5:
        if (r0 != (-4)) goto L7;
        r6 = "download_cancel";
        goto L26
    L7:
        if (r0 == (-3)) goto L21;
        if (r0 == (-2)) goto L19;
        if (r0 != 0) goto L12;
        r6 = "download_create";
        goto L26
    L12:
        if (r0 != 2) goto L14;
        r6 = "download_start";
        goto L26
    L14:
        if (r0 == 6) goto L16;
        r6 = "";
        goto L26
    L16:
        r6 = "download_first_start";
        goto L26
    L19:
        r6 = "download_pause";
        goto L26
    L21:
        if (r4.U < 0.0d) goto L23;
        r5.put("download_speed", r4.U);
    L23:
        r5.put("throttle_net_speed", r4.V);
        r6 = "download_success";
        goto L26
    }
}
