package i4;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.lifecycle.s;
import c4.m;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.network.BlockedReason;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Handler.Callback {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final List<String> f8209w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f8210x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f8211y = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f8212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j4.a f8213b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final j4.d f8214m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final j4.e f8215n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final j4.b f8216o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final j4.c f8217p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final JSONObject f8218q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Handler f8219r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public e f8220s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final s f8221t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AtomicBoolean f8222u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final JSONObject f8223v;

    public class a implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f8224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f8225b;

        public a(f r8, Thread.UncaughtExceptionHandler r10) {
            this.f8225b = r8;
            this.f8224a = r10;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread r8, Throwable r10) {
            m.u().m(8, f.f8209w, "monitor thread crash!", r10, new Object[0]);
            if (this.f8225b.f8212a.f8170o == false) goto L8;
            Thread.UncaughtExceptionHandler r11 = this.f8224a;
            if (r11 == null) goto L9;
            r11.uncaughtException(r8, r10);
            return;
        L9:
            return;
        }
    }

    static {
        f8209w = Collections.singletonList("MonitorV3Helper");
        f8210x = UUID.randomUUID().toString();
        f8211y = 3590;
    }

    public f() {
        c r8 = new c();
        this.f8212a = r8;
        this.f8213b = new j4.a();
        this.f8214m = new j4.d(r8);
        this.f8215n = new j4.e(r8);
        this.f8216o = new j4.b();
        this.f8217p = new j4.c(r8);
        this.f8218q = new JSONObject();
        this.f8221t = new s(4);
        this.f8222u = new AtomicBoolean(false);
        this.f8223v = new JSONObject();
        j("cold_start_id", f8210x);
    }

    public final void a(int r8, String r10) {
        if (this.f8212a.f8157b == true) goto L5;
        return;
    L5:
        c4.g r11 = m.u();
        Object[] r12 = {r10, Integer.valueOf(r8)};
        r11.l(8, f8209w, "increaseStats {} +{}", r12);
        this.f8215n.b(r8, r10);
    }

    public final void b(k r8, int r10) {
        if (this.f8212a.f8157b == true) goto L5;
        return;
    L5:
        c4.g r11 = m.u();
        Object[] r12 = {r8, Integer.valueOf(r10)};
        r11.l(8, f8209w, "increaseStats {} +{}", r12);
        this.f8215n.b(r10, r8.name());
    }

    public final void c(e r15) {
        m.u().l(8, f8209w, "init monitor v3 helper with config: {}", new Object[]{r15});
        if (this.f8222u.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.f8220s = r15;
        d r8 = r15.f8196b;
        if (this.f8212a.f8157b == true) goto L8;
    L79:
        this.f8213b.f8583b = 0;
        j4.d r16 = this.f8214m;
        r16.getClass();
        m.u().l(8, j4.d.f8620r, "init with disabled", new Object[0]);
        r16.f8622b = false;
        r16.f8621a.clear();
        r16.f8627q.set(true);
        j4.e r17 = this.f8215n;
        r17.f8632a = false;
        r17.f8634m.clear();
        this.f8216o.f8587a = false;
        j4.c r14 = this.f8217p;
        r14.f8605a = false;
        r14.f8607m.clear();
        return;
    L8:
        if (r15.f8195a == null) goto L79;
        if (r8 == null) goto L79;
        j(WsConstants.KEY_APP_ID, String.valueOf(f8211y));
        j("host_aid", r8.f8171a);
        j("channel", r8.f8172b);
        j("cdid", r8.f8181k);
        j("sdk_version_v2", r8.f8180j);
        j("os", LocationInfoConst.SYSTEM);
        j(CloudServiceConstants.OCloud.HEADER_OS_VERSION, Build.VERSION.RELEASE);
        j("app_name", r8.f8174d);
        j("app_version", r8.f8173c);
        j("update_version_code", String.valueOf(r8.f8175e));
        if (r8.f8176f == false) goto L15;
        h(1, "log_enable");
    L15:
        if (r8.f8182l == false) goto L18;
        h(1, "devtools_enable");
    L18:
        if (r8.f8177g == false) goto L21;
        h(1, "tourist_mode");
    L21:
        if (r8.f8178h == false) goto L24;
        h(1, "frequency_control_enable");
    L24:
        if (r8.f8179i == false) goto L27;
        h(1, "log_event_filter_enable");
    L27:
        if (this.f8212a.f8170o == false) goto L29;
        h(1, "debug_mode");
    L29:
        h(r15.f8197c, "report_interval");
        String r10 = r8.f8171a;
        c r11 = this.f8212a;
        Context r12 = r15.f8195a;
        r11.getClass();
        if (r12 == null) goto L45;
        SharedPreferences r13 = r12.getSharedPreferences(r10 + "@applog_monitor_config", 0);
        r11.f8156a = r13;
        JSONObject r18 = r11.f8169n;
        if (r18 == null) goto L37;
        if (r13 == null) goto L37;
        r11.b(r18);
    L37:
        if (r13.contains("enabled") == true) goto L39;
        r11.f8157b = c.f8152p;
        r11.f8158c = BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;
        r11.f8159d = 10;
        r11.f8160e = true;
        r11.f8161f = true;
        r11.f8162g = 300000;
        r11.f8163h = 30000;
        r11.f8164i = 7;
        r11.f8165j = c.f8153q;
        r11.f8166k = c.f8154r;
        r11.f8167l = c.f8155s;
        r11.f8168m = null;
    L43:
        if (r11.f8170o == false) goto L45;
        r11.c();
        goto L45
    L39:
        r11.f8157b = r11.f8156a.getBoolean("enabled", c.f8152p);
        r11.f8158c = r11.f8156a.getInt("max_request_body_size_kb", BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE);
        r11.f8159d = r11.f8156a.getInt("max_request_count", 10);
        r11.f8160e = r11.f8156a.getBoolean("error_report_enable", true);
        r11.f8161f = r11.f8156a.getBoolean("latency_report_enable", true);
        r11.f8162g = r11.f8156a.getLong("report_interval_ms", 300000);
        r11.f8163h = r11.f8156a.getLong("coldstart_report_delay_ms", 30000);
        r11.f8164i = r11.f8156a.getInt("data_keep_alive_days", 7);
        r11.f8165j = r11.f8156a.getBoolean("sentry_enabled", c.f8153q);
        r11.f8166k = r11.f8156a.getInt("sentry_coldstart_sampling_rate", c.f8154r);
        r11.f8167l = r11.f8156a.getInt("network_coldstart_sampling_rate", c.f8155s);
        String r19 = r11.f8156a.getString("sentry_events", null);
        if (TextUtils.isEmpty(r19) == true) goto L43;
        r11.a(new JSONObject(r19));     // Catch: Throwable -> L81
    L45:
        HandlerThread r20 = new HandlerThread(android.aimedia.a.i(new StringBuilder(), r8.f8171a, "@applog_monitor_v3"));
        r20.setUncaughtExceptionHandler(new a(this, r20.getUncaughtExceptionHandler()));
        r20.start();
        Handler r21 = new Handler(r20.getLooper(), this);
        this.f8219r = r21;
        r21.sendEmptyMessageDelayed(1, this.f8212a.f8163h);
        this.f8213b.getClass();
        j4.d r22 = this.f8214m;
        Context r23 = r15.f8195a;
        r22.getClass();
        c4.g r24 = m.u();
        List<String> r25 = j4.d.f8620r;
        r24.l(8, r25, "init with prefix sp: {}.", new Object[]{r10});
        if (r22.f8627q.compareAndSet(false, true) == true) goto L48;
        m.u().a(8, r25, "init failed for already initialized with sp prefix:{}.", new Object[]{r10});
    L77:
        j4.e r26 = this.f8215n;
        Context r27 = r15.f8195a;
        r26.getClass();
        r26.f8635n = r27.getSharedPreferences(r10 + "@applog_monitor_stats", 0);
        Handler r28 = new Handler(r20.getLooper(), r26);
        r26.f8633b = r28;
        r28.removeMessages(8);
        r26.f8633b.sendEmptyMessageDelayed(8, 500);
        r26.f8633b.sendEmptyMessageDelayed(24, Math.max(10000, r26.f8636o.f8163h - 10000) + new SecureRandom().nextInt(9000));
        j4.c r110 = this.f8217p;
        Context r111 = r15.f8195a;
        r110.getClass();
        r110.f8608n = r111.getSharedPreferences(r10 + "@applog_monitor_network", 0);
        c r112 = r110.f8609o;
        r110.f8605a = t2.b.S(r112.f8167l);
        Handler r29 = new Handler(r20.getLooper(), r110);
        r110.f8606b = r29;
        r29.removeMessages(8);
        r110.f8606b.sendEmptyMessageDelayed(8, 500);
        r110.f8606b.sendEmptyMessageDelayed(24, Math.max(10000, r112.f8163h - 10000) + new SecureRandom().nextInt(9000));
        return;
    L48:
        c r30 = r22.f8625o;
        if (r30.f8165j == true) goto L51;
        m.u().l(8, r25, "init but disabled!!!", new Object[0]);
        r22.f8626p = false;
        r22.f8621a.clear();
        r22.f8622b = false;
        goto L77
    L51:
        r22.f8626p = t2.b.S(r30.f8166k);
        m.u().l(8, r25, "sentry acceptAllEvents = {}", new Object[]{Boolean.valueOf(r22.f8626p)});
        r22.f8624n = r23.getSharedPreferences(r10 + "@applog_monitor_sentry", 0);
        if (r22.d() == false) goto L54;
    L76:
        Handler r31 = new Handler(r20.getLooper(), r22);
        r22.f8623m = r31;
        r31.removeMessages(4);
        r22.f8623m.sendEmptyMessageDelayed(4, 500);
        r22.f8623m.sendEmptyMessageDelayed(12, Math.max(10000, r22.f8625o.f8163h - 10000) + new SecureRandom().nextInt(9000));
        goto L77
    L54:
        if (r22.f8621a.isEmpty() == true) goto L76;
        m.u().l(8, r25, "start reset cache map...", new Object[0]);
        if (r22.d() == true) goto L63;
        Map<String, Integer> r32 = r22.f8625o.f8168m;
        if (r32 != null) goto L61;
    L62:
        r22.f8621a.clear();
        goto L76
    L61:
        if (r32.isEmpty() == true) goto L62;
    L63:
        Map<String, j4.d.a> r33 = r22.f8621a;
        monitor-enter(r33);
        Iterator<Map.Entry<String, j4.d.a>> r34 = r22.f8621a.entrySet().iterator();     // Catch: Throwable -> L73
    L67:
        if (r34.hasNext() == false) goto L71;
        Map.Entry<String, j4.d.a> r35 = r34.next();     // Catch: Throwable -> L73
        if (r22.e(r35.getValue().f8628a.f8234a) == true) goto L67;
        r22.f8621a.remove(r35.getKey());     // Catch: Throwable -> L73
        goto L67
    L71:
        monitor-exit(r33);     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        throw th;
    }

    public final boolean d(String r8) {
        if (f() == true) goto L5;
        return false;
    L5:
        j4.d r10 = this.f8214m;
        if (r10.d() == false) goto L8;
    L19:
        return true;
    L8:
        if (r10.f8627q.get() == false) goto L19;
        if (r10.e(r8) == false) goto L23;
        Integer r11 = r10.f8625o.f8168m.get(r8);
        if (r11 != null) goto L16;
        return false;
    L16:
        if (r11.intValue() > 0) goto L22;
        return false;
    L22:
        return t2.b.S(r11.intValue());
    L23:
        return false;
    }

    public final boolean e(String r8) {
        if (f() == true) goto L7;
        return false;
    L7:
        return this.f8214m.e(r8);
    }

    public final boolean f() {
        c r8 = this.f8212a;
        if (r8.f8157b == true) goto L5;
    L7:
        return false;
    L5:
        if (r8.f8165j == false) goto L7;
        return true;
    }

    public final void g(String r10, Throwable r11) {
        c r8 = this.f8212a;
        if (r8.f8157b == true) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == true) goto L10;
        return;
    L10:
        m.u().l(8, f8209w, "sendError {} -> {}", new Object[]{r10, r11});
        j4.a r13 = this.f8213b;
        if (t2.b.S(r13.f8583b) == false) goto L34;
        CopyOnWriteArrayList r14 = r13.f8582a;
        if (r11 == null) goto L26;
        String r15 = r11.getClass().getCanonicalName();
        StringBuilder r16 = new StringBuilder();
    L16:
        if (r11 == null) goto L21;
        r16.append(r11.toString());
        StackTraceElement[] r17 = r11.getStackTrace();
        int r18 = r17.length;
        int r19 = 0;
    L18:
        if (r19 >= r18) goto L20;
        StackTraceElement r20 = r17[r19];
        r16.append("\n\tat ");
        r16.append(r20);
        r19 = r19 + 1;
        goto L18
    L20:
        r11 = r11.getCause();
        goto L16
    L21:
        String r110 = r16.toString().replaceAll("[\\s|\\n]", "");
        if (r110.length() <= 200) goto L25;
        r110 = r110.substring(0, 200);
    L25:
        r14.add(new j4.a.C0097a(r10, r15, r110));
    L28:
        if (r14.size() <= 100) goto L33;
        r14.remove(0);
        return;
    L33:
        return;
    L26:
        r14.add(new j4.a.C0097a(r10));
        goto L28
    L34:
        return;
    L5:
        if (r8.f8160e == false) goto L7;
        r12 = true;
        goto L8
    }

    public final void h(long r8, String r10) {
        if (this.f8212a.f8157b == true) goto L5;
        return;
    L5:
        m.u().l(8, f8209w, "setFeature int {} = {}", new Object[]{r10, Long.valueOf(r8)});
        JSONObject r11 = this.f8223v;
        monitor-enter(r11);
        this.f8223v.put(r10, r8);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L13
        return;
    L9:
        th = move-exception;
        m.u().l(8, f8209w, "setFeature json error", new Object[]{th});     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r12) {
        if (r12.what != 1) goto L17;
        c r13 = this.f8212a;
        if (r13.f8157b == false) goto L17;
        e r8 = this.f8220s;
        if (r8 == null) goto L17;
        if (r8.f8198d == null) goto L17;
        if (r8.f8199e == null) goto L17;
        if (TextUtils.isEmpty(r8.f8200f) == true) goto L17;
        m.u().l(8, f8209w, "start doReport...", new Object[0]);
        long r10 = r13.f8158c;
        int r11 = r13.f8159d;
        e r14 = this.f8220s;
        r14.f8199e.submit(new g(this, r11, r10, r14.f8198d, r14.f8200f));
        this.f8219r.removeMessages(1);
        this.f8219r.sendEmptyMessageDelayed(1, r13.f8162g);
    L17:
        return false;
    }

    public final void i(String r8) {
        if (this.f8212a.f8157b == true) goto L5;
        return;
    L5:
        List<String> r10 = f8209w;
        m.u().l(8, r10, "setHeader {} = {}", new Object[]{"device_id", r8});
        this.f8218q.put("device_id", r8);     // Catch: Throwable -> L8
        return;
    }

    public final void j(String r8, String r10) {
        if (this.f8212a.f8157b == true) goto L5;
        return;
    L5:
        List<String> r11 = f8209w;
        m.u().l(8, r11, "setStringHeader {}: {}", new Object[]{r8, r10});
        this.f8218q.put(r8, r10);     // Catch: Throwable -> L8
        return;
    }

    public final void k(i4.a r10, String r11, String r12, long r13, j r15) {
        l(null, -1, r10, r11, r12, r13, r15);
    }

    public final void l(String r15, int r16, i4.a r17, String r18, String r19, long r20, j r22) {
        if (f() == true) goto L5;
        return;
    L5:
        CopyOnWriteArrayList r8 = (CopyOnWriteArrayList) this.f8221t.f2194b;
        if (r8.isEmpty() == true) goto L12;
        Iterator r10 = r8.iterator();
    L10:
        if (r10.hasNext() == false) goto L12;
        ((h4.b) r10.next()).a();
    L12:
        c4.g r11 = m.u();
        Object[] r12 = {r17, r18, r19, Long.valueOf(r20), r22, r15, Integer.valueOf(r16)};
        r11.l(8, f8209w, "stageEvent {} -> event: {}, monitor_id: {}, ts: {}, type: {}, priority: {}-{}", r12);
        j4.d r13 = this.f8214m;
        if (r13.f8622b == true) goto L15;
    L23:
        List<String> r14 = j4.d.f8620r;
        m.u().l(8, r14, "stage nothing for disabled!!!", new Object[0]);
        return;
    L15:
        if (r13.f8625o.f8165j == false) goto L23;
        j4.d.a r21 = new j4.d.a(r17, new i(r15, r16, r18, r19, r20, r22));
        if (r13.f8623m != null) goto L20;
    L22:
        r13.a(r21);
        return;
    L20:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L22;
        Handler r23 = r13.f8623m;
        r23.sendMessage(r23.obtainMessage(8, r21));
    }
}
