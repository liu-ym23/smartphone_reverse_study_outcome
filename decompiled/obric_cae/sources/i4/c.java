package i4;

import android.content.SharedPreferences;
import com.bytedance.keva.KevaImpl;
import com.obric.cae.network.BlockedReason;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile boolean f8152p = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile boolean f8153q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile int f8154r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile int f8155s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f8156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8160e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f8162g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f8163h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8164i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8165j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8166k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8167l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map<String, Integer> f8168m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public JSONObject f8169n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f8170o;

    public c() {
        this.f8157b = f8152p;
        this.f8158c = BlockedReason.BLOCKED_REASON_BG_DISABLED_VALUE;
        this.f8159d = 10;
        this.f8160e = true;
        this.f8161f = true;
        this.f8162g = 300000;
        this.f8163h = 30000;
        this.f8164i = 7;
        this.f8165j = f8153q;
        this.f8166k = f8154r;
        this.f8167l = f8155s;
        this.f8168m = null;
        this.f8169n = null;
        this.f8170o = false;
    }

    public final void a(JSONObject r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        this.f8168m.clear();
        Iterator<String> r10 = r8.keys();
    L6:
        if (r10.hasNext() == false) goto L12;
        String r11 = r10.next();
        int r12 = r8.optInt(r11, 0);
        if (r12 <= 0) goto L6;
        if (r12 > 10000) goto L6;
        this.f8168m.put(r11, Integer.valueOf(r12));
        goto L6
    }

    public final void b(JSONObject r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        SharedPreferences r10 = this.f8156a;
        if (r10 == null) goto L7;
        SharedPreferences.Editor r11 = r10.edit();
    L8:
        boolean r12 = false;
        if (r8.optInt("enabled", f8152p ? 1 : 0) != 1) goto L11;
        boolean r13 = true;
    L12:
        this.f8157b = r13;
        if (r11 == null) goto L16;
        r11.putBoolean("enabled", r13);
    L16:
        if (r8.has("max_request_body_size_kb") == false) goto L21;
        int r14 = r8.optInt("max_request_body_size_kb", 1024) * 1024;
        this.f8158c = r14;
        if (r11 == null) goto L21;
        r11.putInt("max_request_body_size_kb", r14);
    L21:
        if (r8.has("max_request_count") == false) goto L26;
        int r15 = r8.optInt("max_request_count", 10);
        this.f8159d = r15;
        if (r11 == null) goto L26;
        r11.putInt("max_request_count", r15);
    L26:
        if (r8.has("error_report_enable") == false) goto L35;
        if (r8.optInt("error_report_enable", 1) != 1) goto L30;
        boolean r16 = true;
    L31:
        this.f8160e = r16;
        if (r11 == null) goto L35;
        r11.putBoolean("error_report_enable", r16);
        goto L35
    L30:
        r16 = false;
    L35:
        if (r8.has("latency_report_enable") == false) goto L44;
        if (r8.optInt("latency_report_enable", 1) != 1) goto L39;
        boolean r17 = true;
    L40:
        this.f8161f = r17;
        if (r11 == null) goto L44;
        r11.putBoolean("latency_report_enable", r17);
        goto L44
    L39:
        r17 = false;
    L44:
        if (r8.has("report_interval_ms") == false) goto L49;
        long r18 = r8.optLong("report_interval_ms", 300000);
        this.f8162g = r18;
        if (r11 == null) goto L49;
        r11.putLong("report_interval_ms", r18);
    L49:
        if (r8.has("coldstart_report_delay_ms") == false) goto L54;
        long r19 = r8.optLong("coldstart_report_delay_ms", 30000);
        this.f8163h = r19;
        if (r11 == null) goto L54;
        r11.putLong("coldstart_report_delay_ms", r19);
    L54:
        if (r8.has("data_keep_alive_days") == false) goto L59;
        int r20 = r8.optInt("data_keep_alive_days", 7);
        this.f8164i = r20;
        if (r11 == null) goto L59;
        r11.putLong("data_keep_alive_days", r20);
    L59:
        if (r8.has("sentry_enabled") == false) goto L67;
        if (r8.optInt("sentry_enabled", f8153q ? 1 : 0) != 1) goto L63;
        r12 = true;
    L63:
        this.f8165j = r12;
        if (r11 == null) goto L67;
        r11.putBoolean("sentry_enabled", r12);
    L67:
        if (r8.has("sentry_coldstart_sampling_rate") == false) goto L72;
        int r21 = r8.optInt("sentry_coldstart_sampling_rate", f8154r);
        this.f8166k = r21;
        if (r11 == null) goto L72;
        r11.putInt("sentry_coldstart_sampling_rate", r21);
    L72:
        if (r8.has("network_coldstart_sampling_rate") == false) goto L77;
        int r22 = r8.optInt("network_coldstart_sampling_rate", f8155s);
        this.f8167l = r22;
        if (r11 == null) goto L77;
        r11.putInt("network_coldstart_sampling_rate", r22);
    L77:
        if (r8.has("sentry_events") == false) goto L81;
        JSONObject r23 = r8.optJSONObject("sentry_events");
        a(r23);
        if (r11 == null) goto L81;
        r11.putString("sentry_events", r23.toString());
    L81:
        if (r11 == null) goto L84;
        r11.apply();
    L84:
        if (this.f8170o == false) goto L87;
        c();
        return;
    L87:
        return;
    L11:
        r13 = false;
        goto L12
    L7:
        this.f8169n = r8;
        r11 = null;
        goto L8
    }

    public final void c() {
        this.f8170o = true;
        f8152p = true;
        f8153q = true;
        f8154r = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        f8155s = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        this.f8157b = f8152p;
        this.f8165j = f8153q;
        this.f8166k = f8154r;
        this.f8167l = f8155s;
        this.f8168m = null;
    }
}
