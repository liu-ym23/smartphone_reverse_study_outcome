package mb;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.d;
import com.ss.android.socialbase.downloader.model.e;
import com.ss.android.socialbase.downloader.model.f;
import com.ss.android.socialbase.downloader.segment.i;
import com.ss.android.socialbase.downloader.utils.g;
import ib.b0;
import ib.k;
import ib.o;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jb.r;
import nb.h;
import org.json.JSONException;
import org.json.JSONObject;
import qb.l;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: mb.a$a, reason: collision with other inner class name */
    static class RunnableC0241a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f11063c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b0 f11064g;

        RunnableC0241a(c r10, b0 r11) {
            this.f11063c = r10;
            this.f11064g = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = a.a(this.f11063c);     // Catch: Throwable -> L7
            if (r10 != null) goto L5;
            r10 = new JSONObject();     // Catch: Throwable -> L7
        L5:
            this.f11064g.a(r10);     // Catch: Throwable -> L7
            return;
        }
    }

    static class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f11065c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ mb.b f11066g;

        b(c r10, mb.b r11) {
            this.f11065c = r10;
            this.f11066g = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = a.a(this.f11065c);     // Catch: Throwable -> L15
            if (r10 != null) goto L5;
            r10 = new JSONObject();     // Catch: Throwable -> L15
        L5:
            c r11 = this.f11065c;     // Catch: Throwable -> L15
            if (r11.f11068a != (-1)) goto L13;
            r10.put("status", r11.f11069b.getErrorCode());     // Catch: Throwable -> L15
            if (g.Q(com.ss.android.socialbase.downloader.downloader.a.h()) == false) goto L10;
            int r12 = 1;
        L11:
            r10.put("net_connected", r12);     // Catch: Throwable -> L15
            mb.b r13 = this.f11066g;     // Catch: Throwable -> L15
            String r14 = "download_failed";
        L12:
            r13.monitorEvent(r14, r10, null, null);     // Catch: Throwable -> L15
            return;
        L10:
            r12 = 0;
            goto L11
        L13:
            a.b(r11, r10);     // Catch: Throwable -> L15
            r13 = this.f11066g;     // Catch: Throwable -> L15
            r14 = "download_common";
        L15:
            th = move-exception;
            a.h(th);
            th.printStackTrace();
        }
    }

    private static class c {
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
        String f11067J;
        f K;
        e L;
        long M;
        long N;
        long O;
        long P;
        boolean Q;
        long R;
        long S;
        double T;
        long U;
        long V;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f11068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        BaseException f11069b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f11070c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f11071d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f11072e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f11073f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        String f11074g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long f11075h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        long f11076i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        long f11077j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        long f11078k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        String f11079l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f11080m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f11081n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f11082o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        String f11083p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f11084q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        int f11085r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        boolean f11086s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        ByteInvalidRetryStatus f11087t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        AsyncHandleStatus f11088u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        boolean f11089v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        String f11090w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        boolean f11091x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        List<String> f11092y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        int f11093z;

        private c() {
            this.f11087t = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
            this.f11088u = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        }

        /* synthetic */ c(RunnableC0241a r10) {
            this();
        }
    }

    static /* synthetic */ JSONObject a(c r10) {
        return o(r10);
    }

    static /* synthetic */ void b(c r10, JSONObject r11) {
        p(r10, r11);
    }

    private static boolean c(int[] r10, int r11) {
        if (r10 != null) goto L5;
    L14:
        return false;
    L5:
        if (r10.length <= 0) goto L14;
        int r12 = 0;
    L8:
        if (r12 >= r10.length) goto L14;
        if (r11 == r10[r12]) goto L11;
        r12 = r12 + 1;
        goto L8
    L11:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.ss.android.socialbase.downloader.exception.BaseException] */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.ss.android.socialbase.downloader.exception.BaseException] */
    /* JADX WARN: Type inference failed for: r5v4, types: [com.ss.android.socialbase.downloader.exception.DownloadTTNetException] */
    public static void d(String r10, h r11, Throwable r12, k r13) {
        if (r13 == null) goto L40;
        if (r10 == null) goto L42;
        boolean r14 = false;
        com.ss.android.socialbase.downloader.model.b r15 = new com.ss.android.socialbase.downloader.model.b();
        boolean r16 = true;
        if (r11 != null) goto L8;
    L15:
        if (r12 != null) goto L17;
        r16 = r14;
    L29:
        if (r16 == false) goto L41;
        Uri.parse(r10).getHost();     // Catch: Throwable -> L33
    L31:
        r13.a(r15);
        return;
    L41:
        return;
    L17:
        if (r15.f8143a > 0) goto L38;
        r15.f8143a = ((l) qb.k.a(l.class)).a().b(r12);
    L38:
        com.ss.android.socialbase.downloader.utils.c.T(r12, "monitor_cdn");     // Catch: BaseException -> L21 DownloadTTNetException -> L23
    L27:
        r12.toString();
        goto L29
    L23:
        e = e;
        if (r15.f8144b == null) goto L26;
    L22:
        e.getErrorCode();
        goto L27
    L26:
        r15.f8144b = e.getRemoteIp();
    L21:
        e = e;
        goto L22
    L8:
        if ((r11 instanceof nb.a) == false) goto L15;
        nb.a r17 = (nb.a) r11;
        r17.j();     // Catch: Throwable -> L12
        r15.f8143a = r17.c();     // Catch: Throwable -> L12
        r15.f8144b = r17.e();     // Catch: Throwable -> L12
        com.ss.android.socialbase.downloader.utils.c.x(r17.i());     // Catch: Throwable -> L12
    L14:
        r14 = true;
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L14
    L42:
        return;
    }

    public static void e(@Nullable nb.g r13, String r14, String r15, long r16, String r18, int r19, IOException r20, DownloadInfo r21) {
        if (r21 != null) goto L5;
        return;
    L5:
        rb.a r10 = rb.a.g(r21.getId());
        int r11 = r10.o("monitor_download_connect", 0);
        if (r11 > 0) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r14) == false) goto L11;
        return;
    L11:
        int r12 = -1;
        if (r13 != null) goto L74;
    L21:
        String r17 = null;
    L23:
        if (r12 < 200) goto L26;
        if (r12 >= 400) goto L26;
    L41:
        String r22 = null;
    L42:
        Uri r23 = Uri.parse(r14);     // Catch: Throwable -> L66
        String r24 = r23.getHost();     // Catch: Throwable -> L66
        String r110 = r23.getPath();     // Catch: Throwable -> L66
        String r25 = r23.getLastPathSegment();     // Catch: Throwable -> L66
        if (TextUtils.isEmpty(r110) == false) goto L45;
    L47:
        JSONObject r26 = new JSONObject();     // Catch: Throwable -> L66
        r26.put("setting_tag", r10.t("setting_tag"));     // Catch: JSONException -> L53 Throwable -> L66
        r26.put("url_host", r24);     // Catch: JSONException -> L53 Throwable -> L66
        r26.putOpt("host_ip", r15);     // Catch: JSONException -> L53 Throwable -> L66
        r26.putOpt("host_real_ip", r17);     // Catch: JSONException -> L53 Throwable -> L66
        r26.put("url_path", r110);     // Catch: JSONException -> L53 Throwable -> L66
        r26.put("url_last_path_segment", r25);     // Catch: JSONException -> L53 Throwable -> L66
        r26.put("net_lib", r19);     // Catch: JSONException -> L53 Throwable -> L66
        r26.put("connect_type", r18);     // Catch: JSONException -> L53 Throwable -> L66
        r26.put("status_code", r12);     // Catch: JSONException -> L53 Throwable -> L66
        if (r22 == null) goto L51;
        r26.put("error_msg", com.ss.android.socialbase.downloader.utils.c.q(r22, r10.o("exception_msg_length", 500)));     // Catch: JSONException -> L53 Throwable -> L66
    L51:
        r26.put(ICronetClient.KEY_CONNECT_TIME, r16);     // Catch: JSONException -> L53 Throwable -> L66
        r26.put("pkg_name", r21.getPackageName());     // Catch: JSONException -> L53 Throwable -> L66
        r26.put(ActivityLifecycle.NAME, r21.getTitle());     // Catch: JSONException -> L53 Throwable -> L66
    L56:
        if (r11 == 1) goto L58;
        if (r11 == 3) goto L58;
    L62:
        if (r11 == 2) goto L64;
        if (r11 == 3) goto L64;
        return;
    L64:
        com.ss.android.socialbase.downloader.downloader.a.D().a(r21.getId(), "download_connect", r26);     // Catch: Throwable -> L66
        return;
    L58:
        mb.b r27 = com.ss.android.socialbase.downloader.downloader.a.y();     // Catch: Throwable -> L66
        if (r27 == null) goto L62;
        r27.monitorEvent("download_connect", r26, null, null);     // Catch: Throwable -> L66
    L53:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L66
        goto L56
    L45:
        if (TextUtils.isEmpty(r25) == true) goto L47;
        r110 = r110.substring(0, r110.length() - r25.length());     // Catch: Throwable -> L69
    L26:
        if (r21.getCurRetryTime() == 0) goto L31;
        int r111 = r21.getHttpStatusCode();     // Catch: Throwable -> L66
        if (r111 < 200) goto L30;
        if (r111 < 400) goto L31;
        return;
    L30:
        return;
    L31:
        if (r20 == null) goto L41;
        if (g.Q(com.ss.android.socialbase.downloader.downloader.a.h()) == false) goto L35;
    L76:
        com.ss.android.socialbase.downloader.utils.c.T(r20, "");     // Catch: BaseException -> L39 Throwable -> L66
    L39:
        e = move-exception;
        r12 = e.getErrorCode();     // Catch: Throwable -> L66
        r22 = e.getErrorMessage();     // Catch: Throwable -> L66
        goto L42
    L35:
        if (rb.a.d().optBoolean("disable_check_no_network") == true) goto L76;
        r12 = 1049;
        goto L41
    L74:
        r12 = r13.c();     // Catch: Throwable -> L15
    L19:
        if ((r13 instanceof nb.a) == false) goto L21;
        r17 = ((nb.a) r13).e();     // Catch: Throwable -> L66
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        th.printStackTrace();
    }

    public static void f(com.ss.android.socialbase.downloader.model.c r10) {
        mb.b r11 = com.ss.android.socialbase.downloader.downloader.a.y();
        if (r11 != null) goto L10;
        return;
    L10:
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L7
        r12.put("db_init_duration", r10.f8145a);     // Catch: Throwable -> L7
        r12.put("db_init_disk_cache_count", r10.f8146b);     // Catch: Throwable -> L7
        r12.put("db_init_memory_cache_count", r10.f8147c);     // Catch: Throwable -> L7
        r12.put("db_init_disk_cache_size", r10.f8148d);     // Catch: Throwable -> L7
        r11.monitorEvent("download_db", r12, null, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public static void g(rb.a r23, DownloadInfo r24, String r25, h r26, boolean r27, boolean r28, BaseException r29, long r30, long r32, boolean r34, long r35, long r37, long r39, JSONObject r41) {
        i("download_io", r23.n("monitor_download_io"), r23, r24, r25, null, null, r26, r27, r28, r29, r30, r32, r34, r35, r37, r39, null);
    }

    public static void h(Throwable r10) {
        mb.b r11 = com.ss.android.socialbase.downloader.downloader.a.y();
        if (r11 != null) goto L10;
        return;
    L10:
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L7
        r12.put(WsConstants.ERROR_CODE, 1091);     // Catch: Throwable -> L7
        r12.put("error_msg", r10.toString());     // Catch: Throwable -> L7
        r12.put("download_status", -1);     // Catch: Throwable -> L7
        r12.put("error_stack", Log.getStackTraceString(r10));     // Catch: Throwable -> L7
        r11.monitorEvent("download_failed", r12, null, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [mb.c] */
    /* JADX WARN: Type inference failed for: r11v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v10, types: [nb.a] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r2v6, types: [mb.b] */
    private static void i(String r19, int r20, rb.a r21, DownloadInfo r22, String r23, String r24, String r25, h r26, boolean r27, boolean r28, BaseException r29, long r30, long r32, boolean r34, long r35, long r37, long r39, JSONObject r41) {
        if (r20 > 0) goto L5;
        return;
    L5:
        if (r32 <= 0) goto L79;
        Uri r10 = Uri.parse(r23);     // Catch: Throwable -> L69
        String r11 = r10.getHost();     // Catch: Throwable -> L69
        String r12 = r10.getPath();     // Catch: Throwable -> L69
        String r13 = r10.getLastPathSegment();     // Catch: Throwable -> L69
        if (TextUtils.isEmpty(r12) == false) goto L10;
    L12:
        if (r27 == false) goto L15;
        int r14 = 1;
    L14:
        String r15 = null;
    L26:
        ?? r16 = new JSONObject();     // Catch: Throwable -> L69
        String r17 = "";
        ?? r18 = -1;
        if (r26 != null) goto L29;
        String r31 = "";
        int r110 = -1;
        ?? r111 = -1;
    L47:
        double r33 = r30 / 1048576.0d;     // Catch: Throwable -> L69
        double r36 = r32;
        double r38 = r36 / TimeUnit.SECONDS.toNanos(1);     // Catch: Throwable -> L69
        r16.put("setting_tag", r21.t("setting_tag"));     // Catch: Throwable -> L69
        r16.put("url_host", r11);     // Catch: Throwable -> L69
        r16.putOpt("host_ip", r24);     // Catch: Throwable -> L69
        r16.putOpt("host_real_ip", r25);     // Catch: Throwable -> L69
        r16.put("url_path", r12);     // Catch: Throwable -> L69
        r16.put("url_last_path_segment", r13);     // Catch: Throwable -> L69
        r16.put("net_lib", r110);     // Catch: Throwable -> L69
        r16.put("hit_cdn_cache", r111);     // Catch: Throwable -> L69
        r16.put("status_code", r14);     // Catch: Throwable -> L69
        r16.put(ICronetClient.KEY_REQUEST_LOG, r31);     // Catch: Throwable -> L69
        if (r15 == null) goto L50;
        r16.put("error_msg", com.ss.android.socialbase.downloader.utils.c.q(r15, r21.o("exception_msg_length", 500)));     // Catch: Throwable -> L69
    L50:
        r16.put("download_sec", r38);     // Catch: Throwable -> L69
        r16.put("download_mb", r33);     // Catch: Throwable -> L69
        if (r38 <= 0.0d) goto L53;
        r16.put("download_speed", r33 / r38);     // Catch: Throwable -> L69
    L53:
        if (r34 == false) goto L55;
        r16.put("rw_read_time", r35 / r36);     // Catch: Throwable -> L69
        r16.put("rw_write_time", r37 / r36);     // Catch: Throwable -> L69
        r16.put("rw_sync_time", r39 / r36);     // Catch: Throwable -> L69
    L55:
        r16.put("pkg_name", r22.getPackageName());     // Catch: Throwable -> L69
        r16.put(ActivityLifecycle.NAME, r22.getTitle());     // Catch: Throwable -> L69
        if (r20 == 1) goto L60;
        if (r20 == 3) goto L60;
        int r40 = 2;
        String r42 = r19;
    L65:
        if (r20 == r40) goto L67;
        if (r20 == 3) goto L67;
        return;
    L67:
        com.ss.android.socialbase.downloader.downloader.a.D().a(r22.getId(), r42, r16);     // Catch: Throwable -> L69
        return;
    L60:
        ?? r43 = com.ss.android.socialbase.downloader.downloader.a.y();     // Catch: Throwable -> L69
        if (r43 == 0) goto L63;
        r42 = r19;
        r43.monitorEvent(r42, r16, null, null);     // Catch: Throwable -> L69
    L64:
        r40 = 2;
        goto L65
    L63:
        r42 = r19;
        goto L64
    L29:
        if ((r26 instanceof nb.e) == false) goto L31;
        r110 = 0;
    L32:
        String r112 = r26.d("X-Cache");     // Catch: Throwable -> L69
        if (TextUtils.isEmpty(r112) == true) goto L36;
        r18 = r112.toLowerCase().contains("hit");     // Catch: Throwable -> L69
    L36:
        if (r21.o("monitor_sla", 1) != 1) goto L43;
        if (r27 == true) goto L43;
        if (r28 == true) goto L43;
        if ((r26 instanceof nb.a) == false) goto L43;
        ((nb.a) r26).k(r16, true);     // Catch: Throwable -> L69
    L43:
        if ((r26 instanceof nb.a) == false) goto L45;
        r17 = ((nb.a) r26).h();     // Catch: Throwable -> L69
    L45:
        r31 = r17;
        r111 = r18;
        goto L47
    L31:
        r110 = 1;
        goto L32
    L15:
        if (r28 == false) goto L17;
        r14 = 2;
        goto L14
    L17:
        if (r29 != null) goto L19;
        r14 = 0;
        goto L14
    L19:
        if (g.Q(com.ss.android.socialbase.downloader.downloader.a.h()) == false) goto L21;
    L23:
        r14 = r29.getErrorCode();     // Catch: Throwable -> L69
    L24:
        r15 = r29.getErrorMessage();     // Catch: Throwable -> L69
        goto L26
    L21:
        if (rb.a.d().optBoolean("disable_check_no_network") == true) goto L23;
        r14 = 1049;
        goto L24
    L10:
        if (TextUtils.isEmpty(r13) == true) goto L12;
        r12 = r12.substring(0, r12.length() - r13.length());     // Catch: Throwable -> L72
    L69:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public static void j(rb.a r23, DownloadInfo r24, String r25, String r26, String r27, boolean r28, h r29, BaseException r30, long r31, long r33) {
        i("segment_io", r23.n("monitor_segment_io"), r23, r24, r25, r26, r27, r29, r28, false, r30, r31, r33, false, -1, -1, -1, null);
    }

    public static void k(DownloadInfo r10, List<i> r11) {
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L6
        r12.put("segments", i.r(r11));     // Catch: Throwable -> L6
        r12.put("cur_bytes", r10.getCurBytes());     // Catch: Throwable -> L6
        r12.put("total_bytes", r10.getTotalBytes());     // Catch: Throwable -> L6
        mb.c r13 = com.ss.android.socialbase.downloader.downloader.a.D();     // Catch: Throwable -> L6
        if (r13 == null) goto L11;
        r13.a(r10.getId(), "segments_error", r12);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public static void l(d r10, BaseException r11, int r12) {
        if (r10 != null) goto L27;
        return;
    L27:
        DownloadInfo r13 = r10.y();     // Catch: Throwable -> L24
        if (r13 != null) goto L7;
        return;
    L7:
        b0 r14 = r10.G();     // Catch: Throwable -> L24
        boolean r15 = ab.d.d(r12);     // Catch: Throwable -> L24
        if (r15 == true) goto L15;
        r15 = c(r13.getExtraMonitorStatus(), r12);     // Catch: Throwable -> L24
        if (r15 == true) goto L15;
        if (r14 == null) goto L15;
        if ((r14 instanceof ib.d) == false) goto L15;
        r15 = c(((ib.d) r14).b(), r12);     // Catch: Throwable -> L24
    L15:
        if (r15 == false) goto L31;
        o r16 = r10.t();     // Catch: Throwable -> L20
        if (r16 == null) goto L22;
        r16.E0(r13, r11, r12);     // Catch: Throwable -> L20
    L22:
        n(r14, r13, r11, r12);     // Catch: Throwable -> L24
        m(com.ss.android.socialbase.downloader.downloader.a.y(), r10, r13, r11, r12);     // Catch: Throwable -> L24
        return;
    L20:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L24
        goto L22
    L31:
        return;
    L24:
        th = move-exception;
        h(th);
        th.printStackTrace();
    }

    public static void m(mb.b r10, d r11, DownloadInfo r12, BaseException r13, int r14) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r12.isNeedSDKMonitor() == false) goto L9;
        com.ss.android.socialbase.downloader.downloader.a.G0(new b(q(r12.getMonitorScene(), r12, r11, r13, r14), r10));
        return;
    }

    public static void n(b0 r10, DownloadInfo r11, BaseException r12, int r13) {
        if (r10 != null) goto L4;
        return;
    L4:
        String r14 = r10.T();
        if (TextUtils.isEmpty(r14) == false) goto L7;
        r14 = DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE;
    L7:
        com.ss.android.socialbase.downloader.downloader.a.G0(new RunnableC0241a(q(r14, r11, null, r12, r13), r10));
    }

    private static JSONObject o(c r10) {
        JSONObject r11 = null;
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L123
        r r13 = com.ss.android.socialbase.downloader.downloader.a.N();     // Catch: JSONException -> L121
        int r14 = 0;
        String r15 = "";
        if (r13 == null) goto L8;
        String r16 = r13.getDeviceId();     // Catch: JSONException -> L121
        String r17 = g.Y(r16);     // Catch: JSONException -> L121
        String r18 = r13.getAppId();     // Catch: JSONException -> L121
        int r19 = r13.a();     // Catch: JSONException -> L121
    L9:
        r12.put("event_page", r10.f11070c);     // Catch: JSONException -> L121
        r12.put("app_id", r18);     // Catch: JSONException -> L121
        r12.put("device_id", r16);     // Catch: JSONException -> L121
        r12.put("device_id_postfix", r17);     // Catch: JSONException -> L121
        r12.put("update_version", r19);     // Catch: JSONException -> L121
        r12.put("download_status", r10.f11068a);     // Catch: JSONException -> L121
        r12.put("abhit", com.ss.android.socialbase.downloader.downloader.a.U().e());     // Catch: JSONException -> L121
        r12.put("setting_tag", rb.a.g(r10.f11071d).t("setting_tag"));     // Catch: JSONException -> L121
        r12.put("download_id", r10.f11071d);     // Catch: JSONException -> L121
        r12.put(ActivityLifecycle.NAME, r10.f11072e);     // Catch: JSONException -> L121
        r12.put("url", r10.f11073f);     // Catch: JSONException -> L121
        r12.put("save_path", r10.f11074g);     // Catch: JSONException -> L121
        r12.put("download_time", r10.f11075h);     // Catch: JSONException -> L121
        r12.put("cur_bytes", r10.f11076i);     // Catch: JSONException -> L121
        r12.put("background_download_bytes", r10.f11077j);     // Catch: JSONException -> L121
        r12.put("total_bytes", r10.f11078k);     // Catch: JSONException -> L121
        r12.put("network_quality", r10.f11079l);     // Catch: JSONException -> L121
        int r20 = 1;
        if (r10.f11080m == false) goto L12;
        int r21 = 1;
    L13:
        r12.put("only_wifi", r21);     // Catch: JSONException -> L121
        if (r10.f11081n == false) goto L16;
        int r22 = 1;
    L17:
        r12.put("need_https_degrade", r22);     // Catch: JSONException -> L121
        if (r10.f11082o == false) goto L20;
        int r23 = 1;
    L21:
        r12.put("https_degrade_retry_used", r23);     // Catch: JSONException -> L121
        String r24 = r10.f11083p;     // Catch: JSONException -> L121
        if (r24 != null) goto L24;
        r24 = "";
    L24:
        r12.put("md5", r24);     // Catch: JSONException -> L121
        if (r10.f11084q == false) goto L27;
        int r25 = 1;
    L28:
        r12.put("is_force", r25);     // Catch: JSONException -> L121
        r12.put("retry_count", r10.f11085r);     // Catch: JSONException -> L121
        if (r10.f11086s == false) goto L31;
        int r26 = 1;
    L32:
        r12.put("default_http_service_backup", r26);     // Catch: JSONException -> L121
        r12.put("download_byte_error_retry_status", r10.f11087t.ordinal());     // Catch: JSONException -> L121
        r12.put("forbidden_handler_status", r10.f11088u.ordinal());     // Catch: JSONException -> L121
        if (r10.f11089v == false) goto L35;
        int r27 = 1;
    L36:
        r12.put("need_independent_process", r27);     // Catch: JSONException -> L121
        String r28 = r10.f11090w;     // Catch: JSONException -> L121
        if (r28 != null) goto L40;
        r28 = "";
    L40:
        r12.put(WsConstants.KEY_EXTRA, r28);     // Catch: JSONException -> L121
        if (r10.f11091x == false) goto L43;
        int r29 = 1;
    L44:
        r12.put("add_listener_to_same_task", r29);     // Catch: JSONException -> L121
        List<String> r30 = r10.f11092y;     // Catch: JSONException -> L121
        if (r30 == null) goto L47;
        int r31 = r30.size();     // Catch: JSONException -> L121
    L48:
        r12.put("backup_url_count", r31);     // Catch: JSONException -> L121
        List<String> r32 = r10.f11092y;     // Catch: JSONException -> L121
        if (r32 == null) goto L51;
        String r33 = r32.toString();     // Catch: JSONException -> L121
    L52:
        r12.put("backup_url", r33);     // Catch: JSONException -> L121
        if (r10.f11092y == null) goto L55;
        int r34 = r10.f11093z;     // Catch: JSONException -> L121
    L56:
        r12.put("cur_backup_url_index", r34);     // Catch: JSONException -> L121
        List<String> r35 = r10.A;     // Catch: JSONException -> L121
        if (r35 == null) goto L59;
        String r36 = r35.toString();     // Catch: JSONException -> L121
    L60:
        r12.put("forbidden_urls", r36);     // Catch: JSONException -> L121
        r12.put("network_retry_count", r10.B);     // Catch: JSONException -> L121
        r12.put("cache_exists_in_downloading", r10.C);     // Catch: JSONException -> L121
        r12.put("content_type", r10.D);     // Catch: JSONException -> L121
        r12.put("content_encoding", r10.E);     // Catch: JSONException -> L121
        if (r10.F == false) goto L63;
        int r37 = 1;
    L64:
        r12.put("fast_download", r37);     // Catch: JSONException -> L121
        String r38 = r10.f11067J;     // Catch: JSONException -> L121
        if (r38 != null) goto L67;
        r38 = "";
    L67:
        r12.put(ICronetClient.KEY_REQUEST_LOG, r38);     // Catch: JSONException -> L121
        String r39 = r10.H;     // Catch: JSONException -> L121
        if (r39 != null) goto L70;
        r39 = "";
    L70:
        r12.put("request_header", r39);     // Catch: JSONException -> L121
        String r40 = r10.I;     // Catch: JSONException -> L121
        if (r40 != null) goto L73;
        r40 = "";
    L73:
        r12.put("response_header", r40);     // Catch: JSONException -> L121
        JSONObject r41 = r10.G;     // Catch: JSONException -> L121
        if (r41 == null) goto L76;
        r12.put("pcdn_log", r41);     // Catch: JSONException -> L121
    L76:
        f r42 = r10.K;     // Catch: JSONException -> L121
        if (r42 == null) goto L79;
        r12.put("origin_timing_info", r42.c());     // Catch: JSONException -> L121
        r12.put("timing_info", r10.K.b());     // Catch: JSONException -> L121
    L79:
        e r43 = r10.L;     // Catch: JSONException -> L121
        if (r43 == null) goto L82;
        r12.put("thread_info", r43.b());     // Catch: JSONException -> L121
    L82:
        int r44 = r10.f11068a;     // Catch: JSONException -> L121
        if (r44 != (-3)) goto L85;
    L89:
        r12.put("all_connect_time", r10.M);     // Catch: JSONException -> L121
        r12.put("first_speed_time", r10.N);     // Catch: JSONException -> L121
        r12.put("real_download_time", r10.O);     // Catch: JSONException -> L121
        r12.put("background_download_time", r10.P);     // Catch: JSONException -> L121
        if (r10.Q == true) goto L93;
        r20 = 0;
    L93:
        r12.put("backup_url_used", r20);     // Catch: JSONException -> L121
        r12.put("cur_retry_time", r10.R);     // Catch: JSONException -> L121
        r12.put("cur_retry_time_in_total", r10.S);     // Catch: JSONException -> L121
        r12.put("md5_time", r10.V);     // Catch: JSONException -> L121
        r12.put("device_available_space", ((g.n(r10.f11074g) / 1024) / 1024) / 100);     // Catch: Throwable -> L96
    L130:
    L111:
        th = move-exception;
        th.printStackTrace();     // Catch: JSONException -> L121
    L113:
        BaseException r45 = r10.f11069b;     // Catch: JSONException -> L121
        if (r45 == null) goto L116;
        r14 = r45.getErrorCode();     // Catch: JSONException -> L121
    L116:
        r12.put(WsConstants.ERROR_CODE, r14);     // Catch: JSONException -> L121
        BaseException r110 = r10.f11069b;     // Catch: JSONException -> L121
        if (r110 == null) goto L119;
        r15 = r110.getErrorMessage();     // Catch: JSONException -> L121
    L119:
        r12.put("error_msg", r15);     // Catch: JSONException -> L121
        return r12;
    L99:
        if (TextUtils.isEmpty(r10.f11073f) == true) goto L108;
        Uri r46 = Uri.parse(r10.f11073f);     // Catch: Throwable -> L111
        String r47 = r46.getHost();     // Catch: Throwable -> L111
        String r48 = r46.getPath();     // Catch: Throwable -> L111
        String r49 = r46.getLastPathSegment();     // Catch: Throwable -> L111
        if (TextUtils.isEmpty(r48) == false) goto L103;
    L109:
        r12.put("url_host", r47);     // Catch: Throwable -> L111
        r12.put("url_path", r48);     // Catch: Throwable -> L111
        r12.put("url_last_path_segment", r49);     // Catch: Throwable -> L111
    L103:
        if (TextUtils.isEmpty(r49) == true) goto L109;
        r48 = r48.substring(0, r48.length() - r49.length());     // Catch: Throwable -> L106
    L106:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L111
        goto L109
    L108:
        r49 = "";
        r47 = r49;
        r48 = r47;
    L96:
        th = move-exception;
        th.printStackTrace();     // Catch: JSONException -> L121
        goto L130
    L85:
        if (r44 == (-4)) goto L89;
        if (r44 == (-1)) goto L89;
        if (r44 != (-2)) goto L130;
    L63:
        r37 = 0;
        goto L64
    L59:
        r36 = "";
        goto L60
    L55:
        r34 = -1;
        goto L56
    L51:
        r33 = "";
        goto L52
    L47:
        r31 = 0;
        goto L48
    L43:
        r29 = 0;
        goto L44
    L35:
        r27 = 0;
        goto L36
    L31:
        r26 = 0;
        goto L32
    L27:
        r25 = 0;
        goto L28
    L20:
        r23 = 0;
        goto L21
    L16:
        r22 = 0;
        goto L17
    L12:
        r21 = 0;
        goto L13
    L8:
        r19 = 0;
        r16 = "";
        r17 = r16;
        r18 = r17;
    L121:
        e = e;
        r11 = r12;
    L124:
        h(e);
        e.printStackTrace();
        return r11;
    L123:
        e = e;
        goto L124
    }

    private static void p(c r10, JSONObject r11) {
        int r12 = r10.f11068a;
        if (r12 != (-5)) goto L5;
        String r13 = "download_uncomplete";
    L26:
        r11.put("status", r13);
        return;
    L5:
        if (r12 != (-4)) goto L7;
        r13 = "download_cancel";
        goto L26
    L7:
        if (r12 != (-3)) goto L9;
        double r14 = r10.T;
        if (r14 < 0.0d) goto L23;
        r11.put("download_speed", r14);
    L23:
        r11.put("throttle_net_speed", r10.U);
        r13 = "download_success";
        goto L26
    L9:
        if (r12 == (-2)) goto L19;
        if (r12 != 0) goto L12;
        r13 = "download_create";
        goto L26
    L12:
        if (r12 != 2) goto L14;
        r13 = "download_start";
        goto L26
    L14:
        if (r12 == 6) goto L16;
        r13 = "";
        goto L26
    L16:
        r13 = "download_first_start";
        goto L26
    L19:
        r13 = "download_pause";
        goto L26
    }

    private static c q(String r10, DownloadInfo r11, d r12, BaseException r13, int r14) {
        c r15 = new c(null);
        r15.f11068a = r14;
        r15.f11069b = r13;
        r15.f11070c = r10;
        if (r11 == null) goto L15;
        r15.f11071d = r11.getId();
        r15.f11072e = r11.getName();
        r15.f11073f = r11.getUrl();
        r15.f11074g = r11.getSavePath();
        r15.f11075h = r11.getDownloadTime();
        r15.f11076i = r11.getCurBytes();
        r15.f11077j = r11.getBackCurBytes();
        r15.f11078k = r11.getTotalBytes();
        r15.f11079l = r11.getNetworkQuality();
        r15.f11080m = r11.isOnlyWifi();
        r15.f11081n = r11.isNeedHttpsToHttpRetry();
        r15.f11082o = r11.isHttpsToHttpRetryUsed();
        r15.f11083p = r11.getMd5();
        r15.f11084q = r11.isForce();
        r15.f11085r = r11.getRetryCount();
        r15.f11086s = r11.isNeedDefaultHttpServiceBackUp();
        r15.f11087t = r11.getByteInvalidRetryStatus();
        r15.f11088u = r11.getAsyncHandleStatus();
        r15.f11089v = r11.isNeedIndependentProcess();
        r15.f11090w = r11.getExtra();
        r15.f11091x = r11.isAddListenerToSameTask();
        r15.f11092y = r11.getBackUpUrls();
        r15.f11093z = r11.getCurBackUpUrlIndex();
        r15.A = r11.getForbiddenBackupUrls();
        r15.B = r11.getCurNetworkRetryCount();
        r15.C = r11.isCacheExistsInDownloading();
        r15.D = r11.getMimeType();
        r15.E = r11.getContentEncoding();
        r15.F = r11.isFastDownload();
        r15.G = r11.getPcdnStats();
        r15.U = r11.getThrottleNetSpeed();
        r15.H = r11.getHttpRequestHeader();
        r15.I = r11.getHttpResponseHeader();
        r15.f11067J = r11.getRequestLog();
        if (r14 != (-3)) goto L7;
    L12:
        r15.M = r11.getAllConnectTime();
        r15.N = r11.getFirstSpeedTime();
        r15.O = r11.getRealDownloadTime();
        r15.P = r11.getRealBackDownloadTime();
        r15.Q = r11.isBackUpUrlUsed();
        r15.R = r11.getCurRetryTime();
        r15.S = r11.getCurRetryTimeInTotal();
        r15.V = r11.getMd5Time();
    L13:
        if (r14 != (-3)) goto L15;
        r15.T = r11.getDownloadSpeed();
        goto L15
    L7:
        if (r14 == (-4)) goto L12;
        if (r14 == (-1)) goto L12;
        if (r14 != (-2)) goto L13;
    L15:
        if (r12 == null) goto L17;
        r15.K = r12.M().a();
        r15.L = r12.L().a();
    L17:
        return r15;
    }
}
