package d4;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import c4.l;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import r3.m;
import v4.e;
import v4.i;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final List<String> f6756q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f6758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedPreferences f6759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedPreferences f6760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedPreferences f6761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile JSONObject f6762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashSet<String> f6763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashSet<String> f6764h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile HashSet<String> f6765i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f6766j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final u4.a f6767k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final r3.c f6768l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public y3.c f6769m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile String f6770n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile String f6771o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f6772p;

    static {
        f6756q = Collections.singletonList("ConfigManager");
    }

    public c(r3.c r8, Application r10, m r11) {
        this.f6766j = 0;
        this.f6772p = true;
        new ConcurrentHashMap();
        this.f6768l = r8;
        this.f6757a = r10;
        this.f6758b = r11;
        this.f6761e = r10.getSharedPreferences(r11.f11437m, 0);
        this.f6759c = r10.getSharedPreferences(r3.b.b(r8, "header_custom"), 0);
        this.f6760d = r10.getSharedPreferences(r3.b.b(r8, "last_sp_session"), 0);
        this.f6763g = new HashSet();
        this.f6764h = new HashSet();
        this.f6767k = new u4.a(r8, this, b());
        r8.getClass();
    }

    public final String a() {
        Context r8 = this.f6757a;
        String r10 = this.f6758b.f11427c;
        if (TextUtils.isEmpty(r10) == false) goto L6;
        r10 = null;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L16;
        Bundle r11 = r8.getPackageManager().getApplicationInfo(r8.getPackageName(), 128).metaData;     // Catch: Throwable -> L11
        if (TextUtils.isEmpty("UMENG_CHANNEL") == true) goto L17;
        return r11.getString("UMENG_CHANNEL");
    L17:
        return r10;
    L11:
        th = move-exception;
        List<String> r12 = f6756q;
        this.f6768l.H.i(r12, "getChannel failed", th, new Object[0]);
        return r10;
    L16:
        return r10;
    }

    public final long b() {
        long r8 = this.f6766j;
        if (r8 >= 10000) goto L5;
    L7:
        boolean r10 = false;
    L8:
        if (r10 == false) goto L11;
        return r8;
    L11:
        return this.f6761e.getLong("batch_event_interval", 60000);
    L5:
        if (r8 > 300000) goto L7;
        r10 = true;
        goto L8
    }

    public final JSONObject c() {
        String r8 = this.f6761e.getString("log_back", "");
        if (TextUtils.isEmpty(r8) == false) goto L10;
        return null;
    L10:
        return new JSONObject(r8);
    L7:
        th = move-exception;
        this.f6768l.H.i(null, "json parse to logback failed", th, new Object[0]);
        return null;
    }

    public final boolean d() {
        m r8 = this.f6758b;
        if (r8.f11428d != 0) goto L34;
        Context r10 = this.f6757a;
        String r11 = i.f12730a;
        if (TextUtils.isEmpty(r11) == true) goto L42;
    L28:
        boolean r12 = !r11.contains(BdimCategoryConstants.SEPARATOR_COLON);
        r8.getClass();
        if (r12 == false) goto L31;
        int r13 = 1;
    L32:
        r8.f11428d = r13;
        goto L34
    L31:
        r13 = 2;
        goto L32
    L42:
        int r14 = Process.myPid();     // Catch: Exception -> L14
        Iterator<ActivityManager.RunningAppProcessInfo> r15 = ((ActivityManager) r10.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L14
    L9:
        if (r15.hasNext() == false) goto L16;
        ActivityManager.RunningAppProcessInfo r16 = r15.next();     // Catch: Exception -> L14
        if (r16.pid != r14) goto L9;
        i.f12730a = r16.processName;     // Catch: Exception -> L14
    L16:
        String r17 = null;
        BufferedReader r18 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L24
        StringBuilder r19 = new StringBuilder();     // Catch: Throwable -> L39
    L19:
        int r20 = r18.read();     // Catch: Throwable -> L39
        if (r20 <= 0) goto L22;
        r19.append((char) r20);     // Catch: Throwable -> L39
        goto L19
    L22:
        r17 = r19.toString();     // Catch: Throwable -> L39
    L44:
        r18.close();     // Catch: Exception -> L38
    L27:
        i.f12730a = r17;
        c4.m.u().e("getProcessName: {}", new Object[]{i.f12730a});
        r11 = i.f12730a;
    L25:
        if (r18 == null) goto L27;
    L24:
        r18 = null;
    L14:
        e = move-exception;
        e.printStackTrace();
    L34:
        if (r8.f11428d == 1) goto L52;
        return false;
    L52:
        return true;
    }

    public final HashSet<String> e(JSONArray r8) {
        HashSet<String> r10 = new HashSet();
        if (r8 == null) goto L13;
    L5:
        int r11 = r8.length();     // Catch: Throwable -> L12
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L11;
        String r13 = r8.getString(r12);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r13) == true) goto L10;
        r10.add(r13);     // Catch: Throwable -> L12
    L10:
        r12 = r12 + 1;
    L11:
        return r10;
    L13:
        r8 = new JSONArray(this.f6761e.getString("real_time_events", "[]"));     // Catch: Throwable -> L12
        goto L5
    }

    public final void f(JSONObject r19) {
        boolean r8 = false;
        this.f6768l.H.l(0, f6756q, "setConfig: {}", new Object[]{r19});
        this.f6762f = r19;
        long r10 = System.currentTimeMillis();
        SharedPreferences.Editor r11 = this.f6761e.edit();
        long r12 = r19.optInt("session_interval", 0);
        if (r12 > 0) goto L5;
    L7:
        r11.remove("session_interval");
    L8:
        long r13 = ((long) r19.optInt("batch_event_interval", 60)) * 1000;
        if (r13 >= 10000) goto L11;
    L13:
        boolean r14 = false;
    L14:
        if (r14 == false) goto L16;
        r11.putLong("batch_event_interval", r13);
    L17:
        int r15 = r19.optInt("send_launch_timely", 0);
        if (r15 > 0) goto L20;
    L22:
        r11.remove("send_launch_timely");
    L23:
        long r16 = r19.optInt("abtest_fetch_interval", 0);
        if (r16 > 20) goto L26;
    L28:
        r11.remove("abtest_fetch_interval");
    L30:
        if (r19.optBoolean("bav_ab_config", false) == false) goto L32;
        r11.putBoolean("bav_ab_config", true);
    L33:
        JSONArray r17 = r19.optJSONArray("real_time_events");
        if (r17 != null) goto L36;
    L38:
        this.f6765i = new HashSet();
        r11.remove("real_time_events");
    L39:
        int r18 = r19.optInt("http_monitor_port", 0);
        if (r18 <= 0) goto L42;
        r11.putInt("http_monitor_port", r18);
    L42:
        r11.putLong("app_log_last_config_time", r10);
        int r20 = r19.optInt("forbid_report_phone_detail_info", -1);
        if (r20 < 0) goto L48;
        if (r20 <= 0) goto L46;
        boolean r21 = true;
    L47:
        r11.putBoolean("forbid_report_phone_detail_info", r21);
        goto L48
    L46:
        r21 = false;
    L48:
        long r22 = r19.optLong("fetch_interval", 21600) * 1000;
        if (r22 >= 1800000) goto L51;
    L52:
        r22 = 21600000;
    L53:
        r11.putLong("fetch_interval", r22);
        r11.putInt("content_encode_method", r19.optInt("content_encode_method", 0));
        r11.putLong("max_pack_size", r19.optLong("max_pack_size", 0));
        JSONObject r23 = r19.optJSONObject("log_back");
        if (r23 == null) goto L57;
        g(r11, r23);
    L57:
        if (r19.optInt("ignore_event_priority", 0) != 1) goto L59;
        r8 = true;
    L59:
        r11.putBoolean("ignore_event_priority", r8);
        this.f6768l.getClass();
        this.f6768l.getClass();
        r11.apply();
        if (r19.has("monitor_config") == false) goto L63;
        this.f6768l.f11417y.f8212a.b(r19.optJSONObject("monitor_config"));
    L63:
        if (l.b() == true) goto L67;
        l.c("remote_settings", new b(this));
        return;
    L67:
        return;
    L51:
        if (r22 <= 172800000) goto L53;
    L36:
        if (r17.length() <= 0) goto L38;
        this.f6765i = e(r17);
        r11.putString("real_time_events", r17.toString());
        goto L39
    L32:
        r11.remove("bav_ab_config");
        goto L33
    L26:
        if (r16 > 604800) goto L28;
        r11.putLong("abtest_fetch_interval", r16 * 1000);
        goto L30
    L20:
        if (r15 > 604800) goto L22;
        r11.putInt("send_launch_timely", r15);
        goto L23
    L16:
        r11.remove("batch_event_interval");
        goto L17
    L11:
        if (r13 > 300000) goto L13;
        r14 = true;
        goto L14
    L5:
        if (r12 > 604800) goto L7;
        r11.putLong("session_interval", r12 * 1000);
        goto L8
    }

    public final void g(SharedPreferences.Editor r8, JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        JSONObject r11 = c();
        if (r11 == null) goto L9;
        e.b(r10, r11);
        r10 = r11;
    L9:
        if (r8 == null) goto L11;
        r8.putString("log_back", r10.toString());
        return;
    L11:
        this.f6761e.edit().putString("log_back", r10.toString()).apply();
    }
}
