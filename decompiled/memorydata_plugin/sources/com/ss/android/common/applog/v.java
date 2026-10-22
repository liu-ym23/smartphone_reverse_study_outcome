package com.ss.android.common.applog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.crash.constants.Constants;
import com.bytedance.rpc.internal.RpcUtils;
import com.ss.android.common.lib.AppLogNewUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
class v extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SimpleDateFormat f15104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedList<s> f15105b;
    private final Context c;
    private final JSONObject d;
    private final AtomicBoolean e;
    private final List<AppLog.i> f;
    private long g;
    private long h;
    private w i;
    private volatile long j;
    private long k;
    private AtomicLong l;
    private volatile long m;
    private int n;
    private volatile JSONObject o;
    private volatile long p;
    private final ConcurrentHashMap<String, String> q;
    private final ConcurrentHashMap<String, String> r;
    private final e s;

    v(Context r5, JSONObject r6, LinkedList<s> r7, AtomicBoolean r8, List<AppLog.i> r9, w r10, ConcurrentHashMap r11, ConcurrentHashMap r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        List<AppLog.i> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        super("LogReaper");
        this.f15104a = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        this.g = 0;
        this.h = 0;
        this.k = 0;
        this.l = new AtomicLong();
        this.m = 60000;
        this.n = 1;
        this.o = null;
        this.p = 120000;
        Context r15 = ZeusTransformUtils.wrapperContext(r13, "com.obric.memorydata.plugin");
        this.c = r15;
        this.d = r6;
        this.f15105b = r7;
        this.e = r8;
        this.f = r14;
        a(r10);
        this.q = r11;
        this.r = r12;
        this.s = new e(r15);
        String[] r16 = AppLog.d();
        int r17 = r16.length;
        int r18 = 0;
    L3:
        if (r18 >= r17) goto L5;
        String r19 = r16[r18];
        this.s.a(r19);
        r18 = r18 + 1;
        goto L3
    }

    private int a(int r27, String[] r28, String r29, boolean r30) {
        String r0 = r28[r27];
    L135:
        th = move-exception;
        com.ss.android.common.b.b.d("Send log failed", th);
        if (AppLog.m() == false) goto L141;
        e r1 = this.s;
        if (r1 == null) goto L141;
        r1.a(r27, r28, th);
    L141:
        throw th;
    L4:
        if (AppLog.m() == false) goto L14;
        e r6 = this.s;     // Catch: Throwable -> L135
        if (r6 == null) goto L14;
        if (r6.b(r0) == true) goto L14;
        if (AppLog.o == null) goto L12;
        AppLog.o.a("service_monitor", "applog_send_tuibi", 0, null, null);     // Catch: Throwable -> L135
    L12:
        b.a(MonitorKey.pack, MonitorState.f_congestion_control);     // Catch: Throwable -> L135
        return -1;
    L14:
        aa r7 = AppLog.x;     // Catch: Throwable -> L135
        if (r7 == null) goto L21;
        JSONObject r9 = new JSONObject(r29);     // Catch: Throwable -> L135
        boolean r8 = r7.a(r9);     // Catch: Throwable -> L135
        Logger.d("AppLog", "sendLogCallback.onBeforeSendLog allowToSend: " + r8);     // Catch: Throwable -> L135
        if (r8 == true) goto L20;
        return 200;
    L20:
        String r10 = r9.toString();     // Catch: Throwable -> L135
    L23:
        if (Logger.debug() == false) goto L25;
        Logger.d("AppLog", "app_log: " + r10);     // Catch: Throwable -> L135
    L25:
        String r19 = z.a(y.a(r0, true), z.c);     // Catch: Throwable -> L135
        byte[] r20 = r10.getBytes(RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L135
        byte[] r11 = (byte[]) ZeusTransformUtils.preCheckCast(r20.clone(), byte[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L135
        Map<String, String> r21 = AppLog.D();     // Catch: Throwable -> L135
        if (com.bytedance.common.utility.h.a(r19) == true) goto L51;
        if (r30 == false) goto L51;
        if (this.c == null) goto L51;
        if (AppLog.k() == false) goto L51;
        JSONObject r2 = new JSONObject(r10);     // Catch: Throwable -> L38
        String[] r12 = {r2.optString("key"), r2.optString("iv")};     // Catch: Throwable -> L38
        if (com.ss.android.deviceregister.b.a.a.c.a(r12) == true) goto L149;
        r12 = null;
    L149:
        String r13 = null;
        boolean r25 = true;
        String r3 = y.a(AppLog.K(), r19, r11, this.c, false, r12, r21, r10, false, true);     // Catch: RuntimeException -> L46 Throwable -> L135
    L52:
        if (r3 != null) goto L54;
    L133:
        com.ss.android.common.b.b.d("app_log response empty");     // Catch: Throwable -> L135
        return 0;
    L54:
        if (r3.length() == 0) goto L133;
        if (Logger.debug() == false) goto L59;
        com.ss.android.common.b.b.b("app_log response: " + r3);     // Catch: Throwable -> L135
    L59:
        JSONObject r14 = new JSONObject(r3);     // Catch: Throwable -> L135
        if (Api.MSG_MAGIC.equals(r14.optString(Api.KEY_MAGIC)) == true) goto L62;
    L64:
        boolean r15 = false;
    L66:
        if (r15 == true) goto L68;
        com.ss.android.common.b.b.d("app_log response is failed: " + r3);     // Catch: Throwable -> L135
    L76:
        if (AppLog.E() == false) goto L78;
        AppLog.h = r14.optLong("uid");     // Catch: Throwable -> L135
        AppLog.i = r14.optInt("user_type");     // Catch: Throwable -> L135
        AppLog.j = r14.optInt("user_is_login");     // Catch: Throwable -> L135
        AppLog.k = r14.optInt("user_is_auth");     // Catch: Throwable -> L135
    L78:
        long r16 = r14.optLong("batch_event_interval", 0) * 1000;     // Catch: Throwable -> L135
        if (AppLog.c(r16) == false) goto L82;
        this.l.set(r16);     // Catch: Throwable -> L135
    L84:
        e r4 = this.s;     // Catch: Throwable -> L135
        if (r4 == null) goto L151;
        r4.a(r14);     // Catch: Throwable -> L135
    L151:
    L122:
        th = move-exception;
        com.ss.android.common.b.b.d("Parse log res failed", th);     // Catch: Throwable -> L135
    L125:
        if (AppLog.m() == false) goto L129;
        e r5 = this.s;     // Catch: Throwable -> L135
        if (r5 == null) goto L129;
        r5.a(r27, r28);     // Catch: Throwable -> L135
    L129:
        if (r15 == false) goto L132;
        return 200;
    L132:
        return 0;
    L88:
        if (AppLog.m() == false) goto L119;
        if (r14.optJSONObject("blocklist") == null) goto L112;
        Logger.d("AppLog", r14.optJSONObject("blocklist").toString());     // Catch: Throwable -> L122
        JSONArray r17 = r14.optJSONObject("blocklist").optJSONArray(LocationInfoConst.LIBRA_PARAM_V1);     // Catch: Throwable -> L122
        if (r17 != null) goto L95;
    L102:
        JSONArray r18 = r14.optJSONObject("blocklist").optJSONArray("v3");     // Catch: Throwable -> L122
        if (r18 == null) goto L119;
        if (r18.length() <= 0) goto L119;
        int r22 = r18.length();     // Catch: Throwable -> L122
        int r23 = 0;
    L107:
        if (r23 >= r22) goto L119;
        String r24 = r18.getString(r23);     // Catch: Throwable -> L122
        if (com.bytedance.common.utility.h.a(r24) == true) goto L111;
        this.r.put(r24, "block");     // Catch: Throwable -> L122
    L111:
        r23 = r23 + 1;     // Catch: Throwable -> L122
        goto L107
    L95:
        if (r17.length() <= 0) goto L102;
        int r26 = r17.length();     // Catch: Throwable -> L122
        int r31 = 0;
    L97:
        if (r31 >= r26) goto L102;
        String r110 = r17.getString(r31);     // Catch: Throwable -> L122
        if (com.bytedance.common.utility.h.a(r110) == true) goto L101;
        this.q.put(r110, "block");     // Catch: Throwable -> L122
    L101:
        r31 = r31 + 1;     // Catch: Throwable -> L122
        goto L97
    L112:
        Logger.d("AppLog", "block list is empty");     // Catch: Throwable -> L122
        if (this.q.isEmpty() == true) goto L116;
        this.q.clear();     // Catch: Throwable -> L122
    L116:
        if (this.r.isEmpty() == true) goto L119;
        this.r.clear();     // Catch: Throwable -> L122
    L119:
        if (AppLog.C() == false) goto L125;
        AppLog.f15027a = com.bytedance.applog.sampling.d.a(this.c, r13, r14.optJSONObject("sampling_list"), AppLog.f15027a);     // Catch: Throwable -> L122
    L82:
        if (this.m == this.l.get()) goto L84;
        this.l.set(this.m);     // Catch: Throwable -> L135
        goto L84
    L68:
        if (Logger.debug() == false) goto L143;
        com.ss.android.common.b.b.b("app_log upload success");     // Catch: Throwable -> L135
    L143:
        long r111 = r14.optLong("server_time");     // Catch: Exception -> L142 Throwable -> L135
        if (r111 <= 0) goto L76;
        JSONObject r32 = new JSONObject();     // Catch: Exception -> L142 Throwable -> L135
        r32.put("server_time", r111);     // Catch: Exception -> L142 Throwable -> L135
        r32.put("local_time", System.currentTimeMillis() / 1000);     // Catch: Exception -> L142 Throwable -> L135
        this.o = r32;     // Catch: Exception -> L142 Throwable -> L135
        goto L76
    L62:
        if ("success".equals(r14.optString("message")) == false) goto L64;
        r15 = r25;
    L46:
        e = e;
    L50:
        com.ss.android.common.b.b.d("Send encrypt log failed", e);     // Catch: Throwable -> L135
        b.b(r10, MonitorState.f_to_bytes);     // Catch: Throwable -> L135
        r3 = y.a(r19, r20, true, "application/octet-stream;tt-data=b", false, r21, false, true);     // Catch: Throwable -> L135
    L48:
        e = e;
        r13 = null;
        r25 = true;
    L36:
        th = th;
    L40:
        com.ss.android.common.b.b.d("key iv failed", th);     // Catch: Throwable -> L135
    L38:
        th = th;
        r12 = null;
    L51:
        r13 = null;
        r25 = true;
        r3 = y.a(r19, r20, true, "application/octet-stream;tt-data=b", false, r21, false, true);     // Catch: Throwable -> L135
        goto L52
    L21:
        r10 = r29;
        goto L23
    }

    private int a(String[] r6, String r7, boolean r8) {
        int r1 = 0;
        if (AppLog.w == false) goto L5;
        int r0 = -1;
    L9:
        if ((-1) != r0) goto L12;
        b.a(MonitorKey.pack, MonitorState.f_backoff_ratio);
        return -1;
    L12:
        if (r6 != null) goto L14;
    L21:
        return r0;
    L14:
        if (r6.length <= 0) goto L21;
    L16:
        if (r1 >= r6.length) goto L21;
        r0 = a(r1, r6, r7, r8);
        if (r0 == 200) goto L21;
        r1 = r1 + 1;
        goto L16
    L5:
        e r2 = this.s;
        if (r2 == null) goto L8;
        r0 = r2.a(this.l.get());
        goto L9
    L8:
        r0 = 0;
        goto L9
    }

    static List<Long> a(String r8) {
        ArrayList r0 = new ArrayList();
        if (r8 != null) goto L19;
    L18:
        return r0;
    L19:
        JSONObject r1 = new JSONObject(r8);     // Catch: Throwable -> L16
        JSONArray r9 = r1.optJSONArray(AppLogNewUtils.EVENT_V3_CATEGORY);     // Catch: Throwable -> L16
        int r3 = 0;
        if (r9 == null) goto L10;
        int r4 = r9.length();     // Catch: Throwable -> L16
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L10;
        r0.add(Long.valueOf(r9.getJSONObject(r5).getLong("tea_event_index")));     // Catch: Throwable -> L16
        r5 = r5 + 1;     // Catch: Throwable -> L16
    L10:
        JSONArray r10 = r1.optJSONArray("event");     // Catch: Throwable -> L16
        if (r10 == null) goto L18;
        int r2 = r10.length();     // Catch: Throwable -> L16
    L13:
        if (r3 >= r2) goto L18;
        r0.add(Long.valueOf(r10.getJSONObject(r3).getLong("tea_event_index")));     // Catch: Throwable -> L16
        r3 = r3 + 1;
    L16:
        th = move-exception;
        th.printStackTrace();
        goto L18
    }

    private synchronized void a(s r10) {
        monitor-enter(this);
        if (r10 != null) goto L35;
        monitor-exit(this);
        return;
    L35:
    L32:
        th = move-exception;
        throw th;
    L7:
        if (AppLog.G() == false) goto L13;
        if (AppLog.H() == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r10, u.class) == false) goto L19;
        u r11 = (u) ZeusTransformUtils.preCheckCast(r10, u.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        if (r11.e == false) goto L17;
        a(r11.f15102a, null, true, r11.d, false, true);     // Catch: Throwable -> L32
    L30:
        monitor-exit(this);
        return;
    L17:
        a(r11.f15102a, r11.f15103b, r11.c, r11.d);     // Catch: Throwable -> L32
        a(r11.f15103b);     // Catch: Throwable -> L32
        this.k = System.currentTimeMillis();     // Catch: Throwable -> L32
        goto L30
    L19:
        if (ZeusTransformUtils.instanceOf(r10, r.class) == false) goto L22;
        b(((r) ZeusTransformUtils.preCheckCast(r10, r.class, "com.obric.memorydata.plugin")).f15100a);     // Catch: Throwable -> L32
        goto L30
    L22:
        if (ZeusTransformUtils.instanceOf(r10, t.class) == false) goto L30;
        com.ss.android.common.applog.b.d r12 = ((t) ZeusTransformUtils.preCheckCast(r10, t.class, "com.obric.memorydata.plugin")).f15101a;     // Catch: Throwable -> L32
        if (r12 == null) goto L30;
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L32
        com.ss.android.deviceregister.a.u.a(this.d, r0);     // Catch: Throwable -> L32
        Pair<Long, String> r13 = ab.a(this.c).a(r12, r0);     // Catch: Throwable -> L32
        if (r13 == null) goto L30;
        long r1 = ((Long) ZeusTransformUtils.preCheckCast(r13.first, Long.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L32
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.second, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        if (r1 <= 0) goto L30;
        a(r14, r1);     // Catch: Throwable -> L32
        goto L30
    }

    private void a(w r5) {
        this.i = r5;
        SharedPreferences r0 = this.c.getSharedPreferences(com.ss.android.deviceregister.a.b.a(), 0);
        this.j = r0.getLong("latest_forground_session_time", 0);
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.i == true) goto L9;
        this.j = r5.c;
        r0.edit().putLong("latest_forground_session_time", this.j).apply();
        return;
    }

    private void a(w r9, w r10, boolean r11, long r12) {
        a(r9, r10, r11, r12, true, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6 */
    private void a(w r22, w r23, boolean r24, long r25, boolean r27, boolean r28) {
        if (AppLog.G() == true) goto L5;
    L7:
        long r2 = AppLog.b();
        if (r2 == (-1)) goto L22;
        com.ss.android.deviceregister.b.e.a(this.c, r2);
        if (b() == true) goto L22;
        String r3 = com.ss.android.deviceregister.f.h();
        if (y.a(r3) == true) goto L22;
        monitor-enter(this);
        this.d.put("device_id", r3);     // Catch: Throwable -> L16 Exception -> L143
    L16:
        th = move-exception;
        throw th;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L16
    L22:
        d r14 = d.a(this.c);
        if (r22 != null) goto L27;
        if (r23 != null) goto L27;
        return;
    L27:
        if (r22 == null) goto L105;
        long[] r10 = new long[1];
        if (r24 == false) goto L31;
        r10[0] = r25;
    L32:
        List<AppLog.i> r8 = this.f;
        String[] r7 = new String[1];
        JSONObject r5 = new JSONObject();
        monitor-enter(this);
        com.ss.android.deviceregister.a.u.a(this.d, r5);     // Catch: Throwable -> L101
        monitor-exit(this);     // Catch: Throwable -> L101
        com.service.middleware.applog.a r4 = AppLog.z();
        if (r4 == null) goto L39;
        r4.a(r5);
    L39:
        long r6 = r14.a(r22, r23, r5, r24, r10, r7, r8, r27, this.o);
        if (r6 > 0) goto L42;
        return;
    L42:
        if (r14.a(r6) == false) goto L158;
        String r9 = r7[0];
        if (r10[0] <= r25) goto L55;
        if (r27 == true) goto L47;
        if (r28 == false) goto L55;
    L47:
        u r11 = new u();
        r11.f15102a = r22;
        r11.f15103b = r23;
        int r12 = 1;
        r11.c = true;
        r11.d = r10[0];
        r11.e = r28;
        LinkedList<s> r13 = this.f15105b;
        monitor-enter(r13);
        this.f15105b.add(r11);     // Catch: Throwable -> L52
        monitor-exit(r13);     // Catch: Throwable -> L52
    L57:
        if (AppLog.F() == false) goto L63;
        p r15 = new p();
        r15.f15096a = r6;
        r15.f15097b = r9;
        r15.f = 0;
        boolean r16 = a(r15);
        String r17 = r15.f15097b;
        if (r16 == true) goto L61;
        return;
    L61:
        r9 = r17;
    L63:
        if (NetworkUtils.b(this.c) == false) goto L159;
        com.ss.android.common.b.b.b("begin to send batch logs: " + r6);     // Catch: Throwable -> L86
        int r18 = a(AppLog.d(), r9, r12);     // Catch: Throwable -> L86
        if (r18 != (-1)) goto L69;
        return;
    L69:
        if (r18 != 200) goto L71;
        boolean r19 = r12;
    L72:
        if (r19 != 0) goto L151;
    L89:
        List<Long> r0 = a(r9);
        if (r19 == 0) goto L92;
        MonitorState r20 = MonitorState.success;
    L93:
        b.b(r9, r20);
        boolean r21 = r14.a(r6, r19);
        if (r19 != 0) goto L97;
        if (r21 == false) goto L97;
        Object[] r26 = new Object[r12];
        r26[0] = r0;
        x.a(3, 0, r26);
        Object[] r29 = new Object[r12];
        r29[0] = b(r9);
        x.a(4, 0, r29);
        b.b(r9, MonitorState.f_expire);
    L97:
        if (r19 == 0) goto L99;
        return;
    L99:
        if (this.g >= 0) goto L161;
        this.g = r6;
        return;
    L161:
        return;
    L92:
        r20 = MonitorState.f_net;
        goto L93
    L151:
    L84:
        th = th;
        boolean r30 = r19 ? 1 : 0;
    L88:
        com.ss.android.common.b.b.d("send session exception: ", th);
        r19 = r30;
        goto L89
    L74:
        if (b() == false) goto L82;
        if (r23 == null) goto L78;
        r23.j = r12;     // Catch: Throwable -> L84
        r14.d(r23.f15106a);     // Catch: Throwable -> L84
    L78:
        if (r14.h.contains(Long.valueOf(r22.f15106a)) == false) goto L89;
        if (r14.i.contains(Long.valueOf(r22.f15106a)) == true) goto L89;
        r14.i.add(Long.valueOf(r22.f15106a));     // Catch: Throwable -> L84
        goto L89
    L82:
        b.a(MonitorKey.pack, MonitorState.f_device_none);     // Catch: Throwable -> L84
        goto L89
    L71:
        r19 = 0;
    L86:
        th = th;
        r30 = false;
        goto L88
    L159:
        return;
    L52:
        th = move-exception;
        throw th;
    L55:
        r12 = 1;
        goto L57
    L158:
        return;
    L101:
        th = move-exception;
        throw th;
    L31:
        r10[0] = 0;
        goto L32
    L105:
        if (r23 != null) goto L107;
        return;
    L107:
        if (NetworkUtils.b(this.c) == true) goto L109;
        return;
    L109:
        if (this.n > 0) goto L111;
        return;
    L111:
        if (r23.i == true) goto L166;
    L140:
        th = move-exception;
        b.a(MonitorKey.launch, MonitorState.f_exception);
        Logger.d("AppLog", "send launch exception: " + th);
        return;
    L113:
        if (b() == true) goto L115;
        return;
    L115:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L140
        r1.put(Api.KEY_MAGIC, Api.MSG_MAGIC);     // Catch: Throwable -> L140
        JSONObject r31 = new JSONObject();     // Catch: Throwable -> L140
        monitor-enter(this);     // Catch: Throwable -> L140
        com.ss.android.deviceregister.a.u.a(this.d, r31);     // Catch: Throwable -> L137
        monitor-exit(this);     // Catch: Throwable -> L137
        c.a(this.c, r31);     // Catch: Throwable -> L140
        com.service.middleware.applog.a r32 = AppLog.z();     // Catch: Throwable -> L140
        if (r32 == null) goto L122;
        r32.a(r31);     // Catch: Throwable -> L140
    L122:
        r1.put("header", r31);     // Catch: Throwable -> L140
        JSONArray r33 = new JSONArray();     // Catch: Throwable -> L140
        JSONObject r34 = new JSONObject();     // Catch: Throwable -> L140
        r34.put("datetime", AppLog.a(r23.c));     // Catch: Throwable -> L140
        r34.put("session_id", r23.f15107b);     // Catch: Throwable -> L140
        r34.put("local_time_ms", r23.c);     // Catch: Throwable -> L140
        r34.put("tea_event_index", r23.d);     // Catch: Throwable -> L140
        if (r23.i == false) goto L125;
        r34.put("is_background", true);     // Catch: Throwable -> L140
    L125:
        String r35 = AppLog.y();     // Catch: Throwable -> L140
        com.ss.android.common.b.b.c("send first launch, uid: " + AppLog.i() + ", abSdkVersion: " + r35);     // Catch: Throwable -> L140
        if (TextUtils.isEmpty(r35) == true) goto L128;
        r34.put("ab_sdk_version", r35);     // Catch: Throwable -> L140
    L128:
        r33.put(r34);     // Catch: Throwable -> L140
        r1.put(Constants.LAUNCH_TAG, r33);     // Catch: Throwable -> L140
        AppLog.b(r1, true);     // Catch: Throwable -> L140
        b.a(MonitorKey.launch, MonitorState.init);     // Catch: Throwable -> L140
        if (200 != a(AppLog.d(), r1.toString(), true)) goto L132;
        r23.j = true;     // Catch: Throwable -> L140
        r14.d(r23.f15106a);     // Catch: Throwable -> L140
        r14.i.add(Long.valueOf(r23.f15106a));     // Catch: Throwable -> L140
        MonitorKey r36 = MonitorKey.launch;     // Catch: Throwable -> L140
        MonitorState r37 = MonitorState.success;     // Catch: Throwable -> L140
    L131:
        b.a(r36, r37);     // Catch: Throwable -> L140
        r14.h.add(Long.valueOf(r23.f15106a));     // Catch: Throwable -> L140
        b.a(MonitorKey.launch, MonitorState.is_first_launch);     // Catch: Throwable -> L140
        if (f.a().b() == false) goto L167;
        f.a().a(Constants.LAUNCH_TAG, r33);     // Catch: Throwable -> L140
        return;
    L167:
        return;
    L132:
        r36 = MonitorKey.launch;     // Catch: Throwable -> L140
        r37 = MonitorState.f_net;     // Catch: Throwable -> L140
        goto L131
    L137:
        th = move-exception;
        throw th;     // Catch: Throwable -> L140
    L166:
        return;
    L5:
        if (AppLog.H() == true) goto L7;
    }

    private void a(String r6, long r7) {
        d r1 = d.a(this.c);
        if (NetworkUtils.b(this.c) == false) goto L24;
        boolean r2 = false;
        Logger.d("AppLog", "begin to send  logs");     // Catch: Throwable -> L12
        int r5 = a(AppLog.d(), r6, true);     // Catch: Throwable -> L12
        if (r5 != (-1)) goto L10;
        return;
    L10:
        if (r5 != 200) goto L14;
        r2 = true;
    L14:
        if (r2 == false) goto L16;
        MonitorState r8 = MonitorState.success;
    L17:
        b.b(r6, r8);
        p r9 = r1.b(r7 - 1);
        boolean r10 = r1.a(r7, r2);
        if (r2 == true) goto L25;
        if (r10 == false) goto L26;
        b.b(r9.f15097b, MonitorState.f_expire);
        return;
    L26:
        return;
    L25:
        return;
    L16:
        r8 = MonitorState.f_net;
    L12:
        th = move-exception;
        Logger.d("AppLog", "send session exception: " + th);
        goto L14
    }

    private boolean a(p r20) {
        String r8 = this.f15104a.format(new Date(System.currentTimeMillis()));
        if (r8.equals(this.f15104a.format(Long.valueOf(this.j))) == false) goto L63;
        return true;
    L63:
        JSONObject r10 = new JSONObject(r20.f15097b);     // Catch: JSONException -> L8
    L9:
        if (r10 == null) goto L60;
        if (r10.isNull("terminate") == true) goto L60;
        JSONArray r12 = r10.optJSONArray("terminate");
        if (r12 == null) goto L58;
        if (r12.length() <= 0) goto L58;
        JSONObject r0 = r12.optJSONObject(0);
        if (r0 != null) goto L21;
        return true;
    L21:
        String r14 = r0.optString("datetime");
        if (TextUtils.isEmpty(r14) == true) goto L56;
        if (r14.startsWith(r8) == true) goto L56;
        long r9 = (((long) r0.optInt("duration")) * 1000) + AppLog.e.parse(r14).getTime();
    L32:
        if (r8.equals(this.f15104a.format(new Date(r9))) == false) goto L35;
        return true;
    L35:
        JSONObject r11 = r10;
        if (r11.isNull("event") == true) goto L38;
    L61:
        d r1 = d.a(this.c);     // Catch: Throwable -> L51
        r11.remove("terminate");     // Catch: Throwable -> L51
        String r2 = r11.toString();     // Catch: Throwable -> L51
        r20.f15097b = r2;     // Catch: Throwable -> L51
        r1.a(r20.f15096a, r2);     // Catch: Throwable -> L51
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L51
        r3.put("terminate", r12);     // Catch: Throwable -> L51
        r3.put(Api.KEY_MAGIC, Api.MSG_MAGIC);     // Catch: Throwable -> L51
        if (r11.isNull("time_sync") == true) goto L49;
        r3.put("time_sync", r11.optJSONObject("time_sync"));     // Catch: Throwable -> L51
    L49:
        r3.put("header", r11.optJSONObject("header"));     // Catch: Throwable -> L51
        r3.put("_gen_time", r11.optLong("_gen_time"));     // Catch: Throwable -> L51
        r1.a(r3.toString(), 0);     // Catch: Throwable -> L51
        return true;
    L51:
        th = move-exception;
        Logger.e("AppLog", "checkHistoryTerminate", th);
        return true;
    L38:
        if (r11.isNull(AppLogNewUtils.EVENT_V3_CATEGORY) == false) goto L61;
        if (r11.isNull("log_data") == false) goto L61;
        if (r11.isNull("item_impression") == false) goto L61;
        if (r11.isNull(Constants.LAUNCH_TAG) == false) goto L61;
        return false;
    L29:
        e = move-exception;
        Logger.e("AppLog", "checkHistoryTerminate", e);
        r9 = 0;
    L56:
        return true;
    L58:
        return true;
    L60:
        return true;
    L8:
        r10 = null;
        goto L9
    }

    static List<String> b(String r6) {
        ArrayList r0 = new ArrayList();
        if (r6 != null) goto L15;
    L14:
        return r0;
    L15:
        JSONArray r7 = new JSONObject(r6).optJSONArray("terminate");     // Catch: Throwable -> L12
        if (r7 == null) goto L14;
        int r1 = r7.length();     // Catch: Throwable -> L12
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L14;
        String r3 = r7.getJSONObject(r2).optString("session_id", "");     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r3) == true) goto L11;
        r0.add(r3);     // Catch: Throwable -> L12
    L11:
        r2 = r2 + 1;
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L14
    }

    private void b(long r8) {
        if (r8 > 0) goto L5;
        return;
    L5:
        Logger.d("AppLog", "try to batch session  id < " + r8);
        w r9 = d.a(this.c).c(r8);
        if (r9 == null) goto L15;
        a(r9, null, false, 0);
        r r10 = new r();
        r10.f15100a = r9.f15106a;
        LinkedList<s> r11 = this.f15105b;
        monitor-enter(r11);
        this.f15105b.add(r10);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private boolean b() {
        return !com.bytedance.common.utility.h.a(this.d.optString("device_id", ""));
    L5:
        return false;
    }

    private void c() {
        d.a(this.c).a();
    }

    private boolean d() {
        if (AppLog.G() == false) goto L8;
        if (AppLog.H() == true) goto L8;
        return false;
    L8:
        if (NetworkUtils.b(this.c) == true) goto L11;
        return false;
    L11:
        if (this.g >= 0) goto L16;
        if ((System.currentTimeMillis() - this.h) <= this.p) goto L16;
        this.g = 0;
        c();
        this.h = System.currentTimeMillis();
    L16:
        if (this.g >= 0) goto L18;
        return false;
    L18:
        d r0 = d.a(this.c);
        p r2 = r0.b(this.g);
        if (r2 != null) goto L23;
        this.g = -1;
        return false;
    L23:
        if (this.g >= r2.f15096a) goto L25;
        long r5 = r2.f15096a;
    L26:
        this.g = r5;
        if (r2.f15097b != null) goto L29;
    L88:
        return true;
    L29:
        if (r2.f15097b.length() == 0) goto L88;
        if (AppLog.F() == false) goto L37;
        if (a(r2) == true) goto L37;
        return true;
    L37:
        if (AppLog.b() != (-1)) goto L94;
    L90:
    L68:
        th = move-exception;
        Logger.d("AppLog", "send session exception: " + th);
        int r9 = 0;
        boolean r3 = false;
    L71:
        if (r9 != (-1)) goto L73;
        return true;
    L73:
        String r10 = r2.f15097b;
        if (r3 == false) goto L76;
        MonitorState r4 = MonitorState.success;
    L77:
        b.b(r10, r4);
        List<Long> r11 = null;
        if (r2.f != 0) goto L80;
        r11 = a(r2.f15097b);
    L80:
        String r6 = r2.f15097b;
        boolean r1 = r0.a(r2.f15096a, r3);
        if (r3 == true) goto L88;
        if (r1 == false) goto L88;
        if (r2.f != 0) goto L88;
        if (r11 == null) goto L87;
        x.a(3, 0, new Object[]{r11});
    L87:
        x.a(4, 0, new Object[]{b(r6)});
        b.b(r6, MonitorState.f_expire);
        goto L88
    L76:
        r4 = MonitorState.f_net;
        goto L77
    L61:
        if (r2.f != 0) goto L64;
        r9 = a(AppLog.d(), r2.f15097b, true);     // Catch: Throwable -> L68
    L65:
        if (r9 != 200) goto L67;
        r3 = true;
        goto L71
    L67:
        r3 = false;
        goto L71
    L64:
        r9 = 200;
        goto L65
    L94:
        JSONObject r7 = new JSONObject(r2.f15097b);     // Catch: Throwable -> L89
        JSONObject r8 = r7.optJSONObject("header");     // Catch: Throwable -> L89
        String r12 = this.d.optString("device_id");     // Catch: Throwable -> L89
        if (r8 != null) goto L54;
        if (y.a(r12) == true) goto L52;
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L89
        monitor-enter(this);     // Catch: Throwable -> L89
        com.ss.android.deviceregister.a.u.a(this.d, r13);     // Catch: Throwable -> L49
        monitor-exit(this);     // Catch: Throwable -> L49
        r7.put("header", r13);     // Catch: Throwable -> L89
    L47:
        r2.f15097b = r7.toString();     // Catch: Throwable -> L89
        goto L90
    L49:
        th = move-exception;
        throw th;     // Catch: Throwable -> L89
    L52:
        return false;
    L54:
        if (y.a(r8.optString("device_id")) == false) goto L90;
        if (y.a(r12) == true) goto L59;
        r8.put("device_id", r12);     // Catch: Throwable -> L89
        r7.put("header", r8);     // Catch: Throwable -> L89
        goto L47
    L59:
        return false;
    L25:
        r5 = this.g + 1;
        goto L26
    }

    synchronized void a() {
        monitor-enter(this);
        com.ss.android.deviceregister.a.u.a(this.d);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    void a(int r1) {
        this.n = r1;
    }

    void a(long r1) {
        this.m = r1;
        this.l.set(r1);
    }

    void a(JSONObject r1) {
        this.o = r1;
    }

    synchronized void b(JSONObject r7) {
        monitor-enter(this);
        String[] r0 = c.f15072b;     // Catch: Throwable -> L7 Exception -> L9
        int r1 = r0.length;     // Catch: Throwable -> L7 Exception -> L9
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L11;
        String r3 = r0[r2];     // Catch: Throwable -> L7 Exception -> L9
        this.d.put(r3, r7.opt(r3));     // Catch: Throwable -> L7 Exception -> L9
        r2 = r2 + 1;
        goto L4
    L11:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    L9:
        e = move-exception;
        Logger.w("AppLog", "updateHeader exception: " + e);     // Catch: Throwable -> L7
        goto L11
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Logger.d("AppLog", "LogReaper start");
        c();
        this.h = System.currentTimeMillis();
        this.k = System.currentTimeMillis();
        int r11 = 0;
    L3:
        s r1 = null;
    L4:
        if (r1 != null) goto L19;
        LinkedList<s> r2 = this.f15105b;
        monitor-enter(r2);
    L16:
        th = move-exception;
        throw th;
    L8:
        if (this.e.get() == true) goto L9;
        if (this.f15105b.isEmpty() == true) goto L14;
        r1 = (s) ZeusTransformUtils.preCheckCast(this.f15105b.poll(), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
    L14:
        monitor-exit(r2);     // Catch: Throwable -> L16
        goto L19
    L9:
        monitor-exit(r2);     // Catch: Throwable -> L16
    L80:
        Logger.d("AppLog", "LogReaper quit");
        return;
    L19:
        s r12 = r1;
        if (r12 != null) goto L21;
        long r3 = this.l.get();
        if (r3 < 10000) goto L25;
        long r7 = r3;
    L29:
        w r4 = this.i;
        if (r4 != null) goto L32;
    L34:
        long r5 = 0;
    L35:
        long r6 = System.currentTimeMillis();
        if (r7 > 0) goto L38;
    L47:
        long r8 = 0;
    L49:
        if (d() == false) goto L57;
        if (AppLog.m() == false) goto L56;
        r11 = r11 + 1;
        if (r11 <= 4) goto L56;
        this.g = -1;
    L56:
        r1 = r12;
    L57:
        LinkedList<s> r9 = this.f15105b;
        monitor-enter(r9);
    L86:
        th = move-exception;
        throw th;
    L60:
        if (this.f15105b.isEmpty() == true) goto L62;
        s r10 = (s) ZeusTransformUtils.preCheckCast(this.f15105b.poll(), s.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L86
    L84:
        monitor-exit(r9);     // Catch: Throwable -> L86
        r1 = r10;
        r11 = 0;
        goto L4
    L62:
        if (r8 > 0) goto L94;
        this.f15105b.wait();     // Catch: InterruptedException -> L89 Throwable -> L86
    L78:
        if (this.e.get() == true) goto L79;
        r10 = r12;
        goto L84
    L79:
        monitor-exit(r9);     // Catch: Throwable -> L86
        goto L80
    L94:
        long r13 = System.currentTimeMillis();     // Catch: InterruptedException -> L89 Throwable -> L86
        long r14 = this.k;     // Catch: InterruptedException -> L89 Throwable -> L86
        long r15 = r13 - r14;     // Catch: InterruptedException -> L89 Throwable -> L86
        if (r14 != 0) goto L67;
    L73:
        Logger.v("AppLog", "wait for batch event " + r8);     // Catch: InterruptedException -> L89 Throwable -> L86
        if (r8 == 0) goto L78;
        this.f15105b.wait(r8);     // Catch: InterruptedException -> L89 Throwable -> L86
        goto L78
    L67:
        if (r15 < r8) goto L69;
        r8 = 0;
        goto L73
    L69:
        if (r15 < 0) goto L73;
        r8 = r8 - r15;     // Catch: InterruptedException -> L89 Throwable -> L86
        goto L73
    L38:
        if (r5 <= 0) goto L47;
        if ((r6 - this.k) <= r7) goto L46;
        if (NetworkUtils.b(this.c) == false) goto L47;
        this.k = r6;
        Logger.v("AppLog", "batch event " + r7);
        a(r4, null, true, 0, false, false);
    L46:
        r8 = r7;
        goto L49
    L32:
        if (r4.i == true) goto L34;
        r5 = r4.f15106a;
        goto L35
    L25:
        if (r3 > 0) goto L27;
        r7 = 0;
        goto L29
    L27:
        r7 = 10000;
        goto L29
    L21:
        a(r12);
        goto L3
    }
}
