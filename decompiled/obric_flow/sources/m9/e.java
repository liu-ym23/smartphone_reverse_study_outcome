package m9;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.crash.AppDataCenter;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.n;
import com.bytedance.crash.upload.k;
import com.bytedance.crash.util.NativeTools;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CrashType f20050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f20051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ICommonParams f20052c;
    public final c d;
    public final k e;

    public e(CrashType r5, Context r10, c r11, k r12) {
        this.f20050a = r5;
        this.f20051b = r10;
        this.d = r11;
        this.e = r12;
        this.f20052c = (ICommonParams) n.d().f17503c;
    }

    public z8.c a(int r11, z8.c r12) {
        if (r12 != null) goto L4;
        r12 = new z8.c();
    L4:
        boolean r5 = true;
        if (r11 != 0) goto L7;
        int r13 = n.f4069q;
        String r10 = n.f4070r;
        mh.e.g(Integer.valueOf(r13), "miniapp_id", r12.f23416a);
        mh.e.g(r10, "miniapp_version", r12.f23416a);
        if (n.f == false) goto L128;
        mh.e.g(1, "is_mp", r12.f23416a);
    L128:
        r12.g(this.f20052c);
        ConcurrentHashMap r14 = n.f4064l;
        if (r14 != null) goto L131;
    L137:
        mh.e.g(n.f4065m, "inner_sdk", r12.f23416a);
        mh.e.g(m.o(n.f4057a), "process_name", r12.f23416a);
        return r12;
    L131:
        if (r14.size() <= 0) goto L137;
        JSONObject r15 = new JSONObject();
        Iterator r16 = r14.keySet().iterator();
    L134:
        if (r16.hasNext() == false) goto L136;
        Integer r17 = (Integer) r16.next();
        mh.e.g(r14.get(r17), String.valueOf(r17), r15);
        goto L134
    L136:
        mh.e.g(r15, "sdk_info", r12.f23416a);
        goto L137
    L7:
        if (r11 == 1) goto L35;
        if (r11 == 2) goto L19;
        if (r11 == 5) goto L13;
    L121:
        return r12;
    L13:
        if ((this instanceof h) == true) goto L18;
        HashMap r18 = new HashMap();
        JSONObject r19 = com.lynx.tasm.base.h.d(r18);
        JSONObject r20 = r12.f23416a;
        mh.e.g(r19, "storage", r20);
        long r21 = r19.optLong("inner_free");
        long r22 = r19.optLong("sdcard_free");
        long r23 = r19.optLong("inner_free_real");
        String r110 = z8.c.a(r21);
        String r24 = z8.c.a(r22);
        String r25 = z8.c.a(r23);
        z8.c.l(r20, "filters", "inner_free", r110);
        z8.c.l(r20, "filters", "inner_free_real", r25);
        z8.c.l(r20, "filters", "sdcard_free", r24);
        Iterator r111 = r18.keySet().iterator();
    L16:
        if (r111.hasNext() == false) goto L121;
        String r26 = (String) r111.next();
        z8.c.l(r12.b(), "filters", r26, (String) r18.get(r26));
        goto L16
    L18:
        return r12;
    L19:
        i4.a r112 = n.d();
        r112.getClass();
        String r113 = ((ICommonParams) r112.f17503c).getSessionId();     // Catch: Throwable -> L22
    L24:
        if (TextUtils.isEmpty(r113) == true) goto L26;
        mh.e.g(r113, "session_id", r12.f23416a);
    L26:
        k r114 = this.e;
        if (r114 != null) goto L29;
        int r115 = 0;
    L30:
        mh.e.g(Integer.valueOf(r115), "battery", r12.f23416a);
        r12.k(n.f4063k.f4023a);
        if (v8.a.d().f22550a != null) goto L33;
        r5 = false;
    L33:
        z8.c.l(r12.b(), "filters", "alog_inited", String.valueOf(r5));
        goto L121
    L29:
        r115 = r114.f4136a;
    L22:
        r113 = "";
        goto L24
    L35:
        if (m.q(n.f4057a) == true) goto L37;
        mh.e.g(1, "remote_process", r12.f23416a);
    L37:
        mh.e.g(Integer.valueOf(Process.myPid()), LynxMonitorService.KEY_PID, r12.f23416a);
        r12.f(n.f4059c, n.d);
        c r116 = this.d;
        if (r116 == null) goto L154;
        JSONObject r27 = new JSONObject();
        mh.e.g(c.c(r116.f20037h, r116.g), "last_create_activity", r27);
        mh.e.g(c.c(r116.f20039j, r116.f20038i), "last_start_activity", r27);
        mh.e.g(c.c(r116.f20041l, r116.f20040k), "last_resume_activity", r27);
        mh.e.g(c.c(r116.f20044o, r116.f20043n), "last_pause_activity", r27);
        mh.e.g(c.c(r116.f20046q, r116.f20045p), "last_stop_activity", r27);
        WeakReference r28 = r116.f20042m;
        String r29 = null;
        if (r28 == null) goto L53;
        if (r28.get() == null) goto L53;
        Activity r30 = (Activity) r116.f20042m.get();
        Object r31 = r30.getClass().getMethod("getSupportFragmentManager", null).invoke(r30, null);     // Catch: Exception -> L139
        String r32 = "";
        Iterator r33 = ((List) r31.getClass().getMethod("getFragments", null).invoke(r31, null)).iterator();     // Catch: Exception -> L139
    L46:
        if (r33.hasNext() == false) goto L51;
        Object r34 = r33.next();     // Catch: Exception -> L139
        if (((Boolean) r34.getClass().getMethod("isResumed", null).invoke(r34, null)).booleanValue() == false) goto L46;
        r32 = r34.getClass().getName();     // Catch: Exception -> L139
    L51:
        r29 = r32;
    L53:
        if (TextUtils.isEmpty(r29) == true) goto L55;
        mh.e.g(r29, "last_resume_fragment", r27);
    L55:
        mh.e.g(r116.b(r116.f20034a, r116.f20035b), "alive_activities", r27);
        mh.e.g(r116.b(r116.f20036c, r116.d), "finish_activities", r27);
        if (r27.has("last_resume_fragment") == false) goto L59;
        z8.c.l(r12.b(), "filters", "last_resume_fragment", r27.getString("last_resume_fragment"));     // Catch: Exception -> L140
    L59:
        mh.e.g(r27, "activity_trace", r12.f23416a);
        JSONArray r117 = r116.a();
        JSONObject r35 = r12.f23416a.optJSONObject("custom_long");
        if (r35 != null) goto L62;
        r35 = new JSONObject();
        mh.e.g(r35, "custom_long", r12.f23416a);
    L62:
        mh.e.g(r117, "activity_track", r35);
    L154:
        List<String> r118 = this.f20052c.getPatchInfo();     // Catch: Throwable -> L72
        JSONArray r36 = new JSONArray();     // Catch: Throwable -> L72
        if (r118 != null) goto L66;
    L75:
        mh.e.g(r36, "patch_info", r12.f23416a);     // Catch: Throwable -> L72
    L88:
        mh.e.g(n.e, "business", r12.f23416a);
        if (this.f20051b != null) goto L91;
        boolean r37 = c.e().f20047r;
    L92:
        mh.e.g(Boolean.valueOf(true ^ r37), "is_background", r12.f23416a);
        AppDataCenter r119 = n.f4063k;
        CrashType r38 = this.f20050a;
        monitor-enter(r119);
        List r39 = r119.a(r38);     // Catch: Throwable -> L122
        monitor-exit(r119);     // Catch: Throwable -> L122
        HashMap r120 = new HashMap();
        JSONObject r40 = r12.f23416a.optJSONObject("custom");
        if (r40 != null) goto L99;
        r40 = new JSONObject();
        mh.e.g(r40, "custom", r12.f23416a);
    L99:
        int r41 = 0;
    L101:
        if (r41 >= r39.size()) goto L117;
        AttachUserData r42 = (AttachUserData) r39.get(r41);     // Catch: Throwable -> L104
        long r43 = SystemClock.uptimeMillis();     // Catch: Throwable -> L104
        z8.c.m(r40, r42.getUserData(this.f20050a));     // Catch: Throwable -> L104
        r120.put("custom_cost_" + r42.getClass().getName() + "_" + r120.size(), Long.valueOf(SystemClock.uptimeMillis() - r43));     // Catch: Throwable -> L104
    L116:
        r41 = r41 + 1;
    L104:
        th = move-exception;
        if (r40.opt("npth_err_info") == null) goto L147;
        int r44 = 0;
    L110:
        if (r44 >= 5) goto L116;
        if (r40.opt("npth_err_info" + r44) == null) goto L113;
        r44 = r44 + 1;
        goto L110
    L113:
        r40.put("npth_err_info" + r44, com.bytedance.crash.util.h.a(th));     // Catch: Throwable -> L142
        goto L116
    L147:
        r40.put("npth_err_info", com.bytedance.crash.util.h.a(th));     // Catch: Throwable -> L142
        goto L116
    L117:
        mh.e.g(Integer.valueOf(NativeTools.k().r()), "fd_count", r40);
        Iterator r121 = r120.entrySet().iterator();
    L119:
        if (r121.hasNext() == false) goto L121;
        Map.Entry r122 = (Map.Entry) r121.next();
        mh.e.g(r122.getValue(), (String) r122.getKey(), r40);
    L122:
        th = move-exception;
        throw th;
    L91:
        r37 = c.e().f20047r;
        goto L92
    L66:
        if (r118.isEmpty() == true) goto L75;
        Iterator<String> r123 = r118.iterator();     // Catch: Throwable -> L72
    L70:
        if (r123.hasNext() == false) goto L74;
        r36.put(r123.next());     // Catch: Throwable -> L72
        goto L70
    L74:
        mh.e.g(r36, "patch_info", r12.f23416a);     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        List r124 = Collections.singletonList("Code err:\n" + com.bytedance.crash.util.h.a(th));     // Catch: Throwable -> L141
        JSONArray r45 = new JSONArray();     // Catch: Throwable -> L141
        if (r124 != null) goto L80;
    L87:
        mh.e.g(r45, "patch_info", r12.f23416a);     // Catch: Throwable -> L141
        goto L88
    L80:
        if (r124.isEmpty() == true) goto L87;
        Iterator r125 = r124.iterator();     // Catch: Throwable -> L141
    L84:
        if (r125.hasNext() == false) goto L86;
        r45.put((String) r125.next());     // Catch: Throwable -> L141
        goto L84
    L86:
        mh.e.g(r45, "patch_info", r12.f23416a);     // Catch: Throwable -> L141
        goto L88
    }

    public z8.c b(z8.c r5) {
        return r5;
    }
}
