package com.ss.android.common.applog;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.log.m;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.news.common.settings.SettingsManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import gta.g;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kta.n;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class x extends PthreadThreadV2 {
    public long A;
    public long B;
    public z C;
    public volatile long D;
    public long E;
    public final AtomicLong F;
    public volatile long G;
    public int H;
    public volatile JSONObject I;
    public volatile long J;
    public final ConcurrentHashMap<String, String> K;
    public final ConcurrentHashMap<String, String> L;
    public final j M;
    public final LinkedList<u> v;
    public final Context w;
    public final JSONObject x;
    public final AtomicBoolean y;
    public final List<AppLog.g> z;

    public final synchronized void o() {
        monitor-enter(this);
        kta.u.b(this.x);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void l() {
        h r0 = h.d(this.w);
        monitor-enter(r0);
        SQLiteDatabase r2 = r0.a;     // Catch: Throwable -> L34
        Cursor r3 = null;
        if (r2 != null) goto L7;
    L31:
        ita.j.g("AppLog db not establish and open", null);     // Catch: Throwable -> L34
        monitor-exit(r0);
        return;
    L7:
        if (r2.isOpen() == false) goto L31;
        String r1 = "timestamp <= ? OR retry_count > " + AppLog.Z;     // Catch: Throwable -> L34
        String[] r12 = {String.valueOf(System.currentTimeMillis() - AppLog.Y)};     // Catch: Throwable -> L34
        r3 = r0.a.query("queue", new String[]{"value"}, r1, r12, null, null, null);     // Catch: Throwable -> L19
    L11:
        if (r3 == null) goto L21;
        if (r3.moveToNext() == false) goto L21;
        h.k(new JSONObject(r3.getString(0)));     // Catch: Throwable -> L17
    L17:
        e.a().b(StatsCountKeys.JSON_ERROR_COUNT, 1);     // Catch: Throwable -> L19
        goto L11
    L21:
        h.p(r3);     // Catch: Throwable -> L34
        r0.a.delete("queue", r1, r12);     // Catch: Exception -> L24 Throwable -> L34
    L26:
        monitor-exit(r0);
        return;
    L24:
        e = move-exception;
        e.a().b(StatsCountKeys.DB_ERROR_COUNT, 1);     // Catch: Throwable -> L34
        ita.j.g("AppLog delete expire log error:", e);     // Catch: Throwable -> L34
    L19:
        th = move-exception;
        ita.j.g("AppLog count expire log error:", th);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        h.p(r3);     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    public final void m() {
        ita.j.b("AppLog LogReaper start", null);
        l();
        this.B = System.currentTimeMillis();
        this.E = System.currentTimeMillis();
        u r1 = null;
    L3:
        int r11 = 0;
    L4:
        if (r1 != null) goto L19;
        LinkedList<u> r2 = this.v;
        monitor-enter(r2);
    L16:
        th = move-exception;
        throw th;
    L8:
        if (this.y.get() == true) goto L9;
        if (this.v.isEmpty() == true) goto L14;
        r1 = this.v.poll();     // Catch: Throwable -> L16
    L14:
        monitor-exit(r2);     // Catch: Throwable -> L16
        goto L19
    L9:
        monitor-exit(r2);     // Catch: Throwable -> L16
    L81:
        ita.j.b("AppLog LogReaper quit", null);
        return;
    L19:
        u r12 = r1;
        if (r12 != null) goto L21;
        long r3 = this.F.get();
        if (r3 < 10000) goto L25;
        long r7 = r3;
    L29:
        z r4 = this.C;
        if (r4 != null) goto L32;
    L34:
        long r5 = 0;
    L35:
        long r6 = System.currentTimeMillis();
        if (r7 > 0) goto L38;
    L48:
        long r8 = 0;
    L50:
        if (x() == false) goto L58;
        if (AppLog.u() == false) goto L57;
        r11 = r11 + 1;
        if (r11 <= 4) goto L57;
        this.A = -1;
    L57:
        r1 = r12;
    L58:
        LinkedList<u> r9 = this.v;
        monitor-enter(r9);
    L87:
        th = move-exception;
        throw th;
    L61:
        if (this.v.isEmpty() == true) goto L63;
        u r10 = this.v.poll();     // Catch: Throwable -> L87
    L85:
        monitor-exit(r9);     // Catch: Throwable -> L87
        r1 = r10;
        goto L3
    L63:
        if (r8 > 0) goto L91;
        this.v.wait();     // Catch: InterruptedException -> L90 Throwable -> L87
    L79:
        if (this.y.get() == true) goto L80;
        r10 = r12;
        goto L85
    L80:
        monitor-exit(r9);     // Catch: Throwable -> L87
        goto L81
    L91:
        long r13 = System.currentTimeMillis();     // Catch: InterruptedException -> L90 Throwable -> L87
        long r14 = this.E;     // Catch: InterruptedException -> L90 Throwable -> L87
        long r15 = r13 - r14;     // Catch: InterruptedException -> L90 Throwable -> L87
        if (r14 != 0) goto L68;
    L74:
        ita.j.b("AppLog wait for batch event " + r8, null);     // Catch: InterruptedException -> L90 Throwable -> L87
        if (r8 == 0) goto L79;
        this.v.wait(r8);     // Catch: InterruptedException -> L90 Throwable -> L87
        goto L79
    L68:
        if (r15 < r8) goto L70;
        r8 = 0;
        goto L74
    L70:
        if (r15 < 0) goto L74;
        r8 = r8 - r15;     // Catch: InterruptedException -> L90 Throwable -> L87
        goto L74
    L38:
        if (r5 <= 0) goto L48;
        if ((r6 - this.E) <= r7) goto L47;
        if (NetworkUtils.isNetworkAvailable(this.w) == false) goto L45;
        this.E = r6;
        ita.j.b("AppLog batch event " + r7, null);
        z(r4, null, true, 0, false, false);
        goto L47
    L45:
        e.a().b(StatsCountKeys.NO_NETWORK_COUNT, 1);
    L47:
        r8 = r7;
        goto L50
    L32:
        if (r4.h == true) goto L34;
        r5 = r4.a;
        goto L35
    L25:
        if (r3 > 0) goto L27;
        r7 = 0;
        goto L29
    L27:
        r7 = 10000;
        goto L29
    L21:
        w(r12);
        r1 = null;
        goto L4
    }

    public final boolean n() {
        return !StringUtils.isEmpty(this.x.optString("device_id", ""));
    L5:
        return false;
    }

    public final boolean x() {
        if (AppLog.W == false) goto L8;
        if (AppLog.X == true) goto L8;
        return false;
    L8:
        if (NetworkUtils.isNetworkAvailable(this.w) == true) goto L11;
        return false;
    L11:
        if (this.A >= 0) goto L16;
        if ((System.currentTimeMillis() - this.B) <= this.J) goto L16;
        this.A = 0;
        l();
        this.B = System.currentTimeMillis();
    L16:
        if (this.A >= 0) goto L18;
        return false;
    L18:
        h r0 = h.d(this.w);
        r r2 = r0.e(this.A);
        if (r2 != null) goto L22;
        this.A = -1;
        return false;
    L22:
        long r5 = this.A;
        long r7 = r2.a;
        if (r5 >= r7) goto L25;
        this.A = r7;
    L26:
        String r6 = r2.b;
        if (r6 != null) goto L29;
    L83:
        return true;
    L29:
        if (r6.length() == 0) goto L83;
        if (AppLog.V == false) goto L38;
        if (f(r2) == true) goto L38;
        e.a().b(StatsCountKeys.ADJUST_TERMINATE_BLOCK_REQUEST_COUNT, 1);
        return true;
    L38:
        if (AppLog.O == (-1)) goto L86;
        JSONObject r3 = new JSONObject(r2.b);     // Catch: Throwable -> L84
        JSONObject r4 = r3.optJSONObject("header");     // Catch: Throwable -> L84
        String r8 = this.x.optString("device_id");     // Catch: Throwable -> L84
        if (r4 != null) goto L54;
        if (c0.f(r8) == true) goto L52;
        JSONObject r9 = new JSONObject();     // Catch: Throwable -> L84
        monitor-enter(this);     // Catch: Throwable -> L84
        kta.u.a(this.x, r9);     // Catch: Throwable -> L49
        monitor-exit(this);     // Catch: Throwable -> L49
        r3.put("header", r9);     // Catch: Throwable -> L84
        r2.b = r3.toString();     // Catch: Throwable -> L84
        goto L86
    L49:
        th = move-exception;
        throw th;     // Catch: Throwable -> L84
    L52:
        return false;
    L54:
        if (c0.f(r4.optString("device_id")) == false) goto L86;
        if (c0.f(r8) == true) goto L59;
        r4.put("device_id", r8);     // Catch: Throwable -> L84
        r3.put("header", r4);     // Catch: Throwable -> L84
        r2.b = r3.toString();     // Catch: Throwable -> L84
        goto L86
    L59:
        return false;
    L86:
    L67:
        th = move-exception;
        ita.j.c("AppLog send session exception: ", th);
        int r10 = 0;
    L69:
        boolean r11 = false;
    L71:
        if (r10 != (-1)) goto L90;
        return true;
    L90:
        JSONObject r12 = new JSONObject(r2.b);     // Catch: Throwable -> L76
    L77:
        u(r12, r11);
        ita.e.e(r12, r11);
        boolean r1 = r0.n(r2.a, r11);
        if (r11 == true) goto L83;
        if (r1 == false) goto L83;
        if (r2.c != 0) goto L83;
        a0.a(3, 0, new Object[]{q(r12)});
        a0.a(4, 0, new Object[]{s(r12)});
        h.k(r12);
    L76:
        e.a().b(StatsCountKeys.JSON_ERROR_COUNT, 1);
        r12 = null;
        goto L77
    L61:
        if (r2.c != 0) goto L64;
        r10 = y(AppLog.p0.a, r2.b);     // Catch: Throwable -> L67
    L65:
        if (r10 != 200) goto L69;
        r11 = true;
        goto L71
    L64:
        r10 = 200;
        goto L65
    L25:
        this.A = r5 + 1;
        goto L26
    }

    public final void run() {
        m();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public static List<Long> q(JSONObject r10) {
        ArrayList r0 = new ArrayList();
        if (r10 != null) goto L18;
    L16:
        return r0;
    L18:
        JSONArray r1 = r10.optJSONArray(EventVerify.TYPE_EVENT_V3);     // Catch: Throwable -> L17
        int r5 = 0;
        if (r1 == null) goto L10;
        int r6 = r1.length();     // Catch: Throwable -> L17
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L10;
        r0.add(Long.valueOf(JSONArrayProtectorUtils.getJSONObject(r1, r7).optLong("tea_event_index", 0)));     // Catch: Throwable -> L17
        r7 = r7 + 1;     // Catch: Throwable -> L17
    L10:
        JSONArray r11 = r10.optJSONArray(EventVerify.TYPE_EVENT_V1);     // Catch: Throwable -> L17
        if (r11 == null) goto L16;
        int r2 = r11.length();     // Catch: Throwable -> L17
    L13:
        if (r5 >= r2) goto L16;
        r0.add(Long.valueOf(JSONArrayProtectorUtils.getJSONObject(r11, r5).optLong("tea_event_index", 0)));     // Catch: Throwable -> L17
        r5 = r5 + 1;
        goto L13
    }

    public static List<String> s(JSONObject r6) {
        ArrayList r0 = new ArrayList();
        if (r6 != null) goto L15;
    L14:
        return r0;
    L15:
        JSONArray r7 = r6.optJSONArray(EventVerify.TYPE_TERMINATE);     // Catch: Throwable -> L12
        if (r7 == null) goto L14;
        int r1 = r7.length();     // Catch: Throwable -> L12
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L14;
        String r3 = JSONArrayProtectorUtils.getJSONObject(r7, r2).optString("session_id", "");     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r3) == true) goto L11;
        r0.add(r3);     // Catch: Throwable -> L12
    L11:
        r2 = r2 + 1;
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L14
    }

    public final synchronized void B(JSONObject r7) {
        monitor-enter(this);
        String[] r0 = f.a;     // Catch: Throwable -> L10 Exception -> L12
        int r1 = r0.length;     // Catch: Throwable -> L10 Exception -> L12
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L7;
        String r3 = r0[r2];     // Catch: Throwable -> L10 Exception -> L12
        this.x.put(r3, r7.opt(r3));     // Catch: Throwable -> L10 Exception -> L12
        r2 = r2 + 1;     // Catch: Throwable -> L10 Exception -> L12
        goto L4
    L7:
        if (m.b() == true) goto L14;
        m.c("set_header", new b(this));     // Catch: Throwable -> L10 Exception -> L12
    L14:
        monitor-exit(this);
        return;
    L12:
        e = move-exception;
        ita.j.c("AppLog updateHeader exception: ", e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final void C(z r5) {
        boolean r0 = AppLog.L;
        this.C = r5;
        SharedPreferences r1 = this.w.getSharedPreferences(kta.b.a, 0);
        this.D = r1.getLong("latest_forground_session_time", 0);
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.h == true) goto L9;
        this.D = r5.c;
        r1.edit().putLong("latest_forground_session_time", this.D).apply();
        return;
    }

    public final void e(long r10) {
        if (r10 > 0) goto L5;
        return;
    L5:
        ita.j.b("AppLog try to batch session  id < " + r10, null);
        z r11 = h.d(this.w).f(r10);
        if (r11 == null) goto L15;
        z(r11, null, false, 0, true, false);
        t r12 = new t();
        r12.a = r11.a;
        LinkedList<u> r13 = this.v;
        monitor-enter(r13);
        this.v.add(r12);     // Catch: Throwable -> L12
        monitor-exit(r13);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final boolean f(r r19) {
        SimpleDateFormat r5 = AppLog.K0;
        String r6 = r5.format(new Date(System.currentTimeMillis()));
        if (r6.equals(r5.format(Long.valueOf(this.D))) == false) goto L57;
        return true;
    L57:
        JSONObject r7 = new JSONObject(r19.b);     // Catch: JSONException -> L7
    L8:
        if (r7 != null) goto L10;
    L54:
        return true;
    L10:
        if (r7.isNull(EventVerify.TYPE_TERMINATE) == true) goto L54;
        JSONArray r9 = r7.optJSONArray(EventVerify.TYPE_TERMINATE);
        if (r9 == null) goto L54;
        if (r9.length() <= 0) goto L54;
        JSONObject r11 = r9.optJSONObject(0);
        if (r11 != null) goto L20;
        return true;
    L20:
        String r12 = r11.optString("datetime");
        if (TextUtils.isEmpty(r12) == false) goto L23;
        return true;
    L23:
        int r13 = r11.optInt("duration");
        Date r14 = AppLog.J0.parse(r12);     // Catch: Throwable -> L52
        if (r14 != null) goto L27;
        return true;
    L27:
        SimpleDateFormat r15 = AppLog.K0;     // Catch: Throwable -> L52
        if (r6.equals(r15.format(r14)) == false) goto L30;
        return true;
    L30:
        if (r6.equals(r15.format(new Date(r14.getTime() + (((long) r13) * 1000)))) == false) goto L34;
        return true;
    L34:
        if (r7.isNull(EventVerify.TYPE_EVENT_V1) == true) goto L36;
    L59:
        h r8 = h.d(this.w);     // Catch: Throwable -> L49
        r7.remove(EventVerify.TYPE_TERMINATE);     // Catch: Throwable -> L49
        String r10 = r7.toString();     // Catch: Throwable -> L49
        r19.b = r10;     // Catch: Throwable -> L49
        r8.s(r19.a, r10);     // Catch: Throwable -> L49
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L49
        r0.put(EventVerify.TYPE_TERMINATE, r9);     // Catch: Throwable -> L49
        r0.put("magic_tag", "ss_app_log");     // Catch: Throwable -> L49
        if (r7.isNull("time_sync") == true) goto L47;
        r0.put("time_sync", r7.optJSONObject("time_sync"));     // Catch: Throwable -> L49
    L47:
        r0.put("header", r7.optJSONObject("header"));     // Catch: Throwable -> L49
        r0.put("_gen_time", r7.optLong("_gen_time"));     // Catch: Throwable -> L49
        r8.i(r0.toString());     // Catch: Throwable -> L49
    L51:
        return true;
    L49:
        th = move-exception;
        ita.j.c("AppLog checkHistoryTerminate", th);
        goto L51
    L36:
        if (r7.isNull(EventVerify.TYPE_EVENT_V3) == false) goto L59;
        if (r7.isNull(EventVerify.TYPE_LOG_DATA) == false) goto L59;
        if (r7.isNull(EventVerify.TYPE_ITEM_IMPRESSION) == false) goto L59;
        if (r7.isNull(EventVerify.TYPE_LAUNCH) == false) goto L59;
        return false;
    L52:
        th = move-exception;
        ita.j.c("AppLog checkHistoryTerminate error", th);
    L7:
        r7 = null;
        goto L8
    }

    public final synchronized void w(u r10) {
        monitor-enter(this);
    L29:
        th = move-exception;
        throw th;
    L4:
        if (AppLog.W == false) goto L10;
        if (AppLog.X == true) goto L10;
        monitor-exit(this);
        return;
    L10:
        if ((r10 instanceof w) == false) goto L16;
        w r11 = (w) r10;     // Catch: Throwable -> L29
        if (r11.e == false) goto L14;
        z(r11.a, null, true, r11.d, false, true);     // Catch: Throwable -> L29
    L27:
        monitor-exit(this);
        return;
    L14:
        z(r11.a, r11.b, r11.c, r11.d, true, false);     // Catch: Throwable -> L29
        C(r11.b);     // Catch: Throwable -> L29
        this.E = System.currentTimeMillis();     // Catch: Throwable -> L29
        goto L27
    L16:
        if ((r10 instanceof t) == false) goto L19;
        e(((t) r10).a);     // Catch: Throwable -> L29
        goto L27
    L19:
        if ((r10 instanceof v) == false) goto L27;
        g r12 = ((v) r10).a;     // Catch: Throwable -> L29
        if (r12 == null) goto L27;
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L29
        kta.u.a(this.x, r0);     // Catch: Throwable -> L29
        Pair<Long, String> r13 = f0.a(this.w).b(r12, r0);     // Catch: Throwable -> L29
        if (r13 == null) goto L27;
        long r1 = ((Long) r13.first).longValue();     // Catch: Throwable -> L29
        String r14 = (String) r13.second;     // Catch: Throwable -> L29
        if (r1 <= 0) goto L27;
        A(r14, r1);     // Catch: Throwable -> L29
        goto L27
    }

    public static void u(JSONObject r6, boolean r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (e.a().a.b == false) goto L39;
        JSONArray r0 = r6.optJSONArray(EventVerify.TYPE_EVENT_V3);
        JSONArray r1 = r6.optJSONArray(EventVerify.TYPE_EVENT_V1);
        JSONArray r2 = r6.optJSONArray(EventVerify.TYPE_LOG_DATA);
        JSONArray r3 = r6.optJSONArray(EventVerify.TYPE_LAUNCH);
        JSONArray r8 = r6.optJSONArray(EventVerify.TYPE_TERMINATE);
        if (r3 != null) goto L9;
    L15:
        if (r8 != null) goto L17;
    L23:
        int r9 = 0;
        if (r0 == null) goto L26;
        r9 = 0 + r0.length();
    L26:
        if (r1 == null) goto L28;
        r9 = r9 + r1.length();
    L28:
        if (r2 == null) goto L30;
        r9 = r9 + r2.length();
    L30:
        if (r9 <= 0) goto L38;
        ex3.e r4 = e.a();
        if (r7 == false) goto L34;
        StatsCountKeys r10 = StatsCountKeys.REPORT_SUCCESS_EVENT_COUNT;
    L35:
        r4.b(r10, r9);
        return;
    L34:
        r10 = StatsCountKeys.REPORT_FAILED_EVENT_COUNT;
        goto L35
    L38:
        return;
    L17:
        if (r8.length() <= 0) goto L23;
        ex3.e r5 = e.a();
        if (r7 == false) goto L21;
        StatsCountKeys r11 = StatsCountKeys.REPORT_SUCCESS_TERMINATE_COUNT;
    L22:
        r5.b(r11, r8.length());
        goto L23
    L21:
        r11 = StatsCountKeys.REPORT_FAILED_TERMINATE_COUNT;
        goto L22
    L9:
        if (r3.length() <= 0) goto L15;
        ex3.e r12 = e.a();
        if (r7 == false) goto L13;
        StatsCountKeys r13 = StatsCountKeys.REPORT_SUCCESS_LAUNCH_COUNT;
    L14:
        r12.b(r13, r3.length());
        goto L15
    L13:
        r13 = StatsCountKeys.REPORT_FAILED_LAUNCH_COUNT;
        goto L14
    }

    public final void A(String r6, long r7) {
        h r0 = h.d(this.w);
        if (NetworkUtils.isNetworkAvailable(this.w) == false) goto L22;
        JSONObject r1 = null;
        ita.j.b("AppLog begin to send  logs", null);     // Catch: Throwable -> L12
        int r3 = y(AppLog.p0.a, r6);     // Catch: Throwable -> L12
        if (r3 != (-1)) goto L10;
        return;
    L10:
        if (r3 != 200) goto L14;
        boolean r4 = true;
    L24:
        r1 = new JSONObject(r6);     // Catch: Throwable -> L17
    L18:
        u(r1, r4);
        ita.e.e(r1, r4);
        boolean r8 = r0.n(r7, r4);
        if (r4 == true) goto L28;
        if (r8 == false) goto L29;
        h.k(r1);
        return;
    L29:
        return;
    L28:
        return;
    L17:
        e.a().b(StatsCountKeys.JSON_ERROR_COUNT, 1);
    L14:
        r4 = false;
    L12:
        th = move-exception;
        ita.j.c("AppLog send session exception: ", th);
        goto L14
    L22:
        e.a().b(StatsCountKeys.NO_NETWORK_COUNT, 1);
    }

    public final int y(String[] r25, String r26) throws Throwable {
        boolean r0 = AppLog.L;
        j r1 = this.M;
        char r6 = 0;
        if (r1 == null) goto L26;
        long r7 = this.F.get();
        j.b r2 = r1.c;
        if (r2 == null) goto L26;
        if (r2.a > 0) goto L9;
    L18:
        int r8 = r2.a;
        if (r8 >= 10000) goto L25;
        if (r8 <= 0) goto L26;
        if (r8 >= 10000) goto L26;
        if (new Random().nextInt(10000) >= r2.a) goto L26;
    L25:
        int r3 = -1;
    L27:
        if ((-1) != r3) goto L30;
        e.a().b(StatsCountKeys.BACKOFF_BLOCK_REQUEST_COUNT, 1);
        return -1;
    L30:
        if (r25 != null) goto L32;
    L172:
        return r3;
    L32:
        if (r25.length <= 0) goto L172;
        int r9 = 0;
    L35:
        if (r9 >= r25.length) goto L172;
        String r4 = r25[r9];
        if (AppLog.u() == false) goto L45;
        j r10 = this.M;     // Catch: Throwable -> L164
        if (r10 == null) goto L45;
        if (r10.c(r4) == true) goto L45;
        e.a().b(StatsCountKeys.CONGESTION_BLOCK_REQUEST_COUNT, 1);     // Catch: Throwable -> L164
        int r11 = r9;
        r3 = -1;
    L159:
        if (r3 == 200) goto L172;
        r9 = r11 + 1;
        r6 = 0;
    L45:
        e.a().b(StatsCountKeys.REPORT_REQUEST_COUNT, 1);     // Catch: Throwable -> L164
        new HashMap();     // Catch: Throwable -> L164
        if (Logger.debug() == false) goto L48;
        ita.j.b("AppLog app_log: " + r26, null);     // Catch: Throwable -> L164
    L48:
        String r12 = d0.e(c0.b(r4, true), d0.c);     // Catch: Throwable -> L164
        byte[] r22 = r26.getBytes("UTF-8");     // Catch: Throwable -> L164
        byte[] r15 = (byte[]) r22.clone();     // Catch: Throwable -> L164
        ConcurrentHashMap r23 = AppLog.G0;     // Catch: Throwable -> L164
        if (StringUtils.isEmpty(r12) == false) goto L51;
    L68:
        String r5 = c0.e(AppLog.s(), r12, r22, true, "application/octet-stream;tt-data=b", r23, false, true);     // Catch: Throwable -> L164
    L69:
        if (r5 != null) goto L71;
    L157:
        r11 = r9;
        e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);     // Catch: Throwable -> L162
        e.a().b(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT, 1);     // Catch: Throwable -> L162
        ita.j.c("app_log response empty", null);     // Catch: Throwable -> L162
    L158:
        r3 = 0;
        goto L159
    L71:
        if (r5.length() == 0) goto L157;
        if (Logger.debug() == false) goto L76;
        ita.j.b("app_log response: " + r5, null);     // Catch: Throwable -> L164
    L76:
        JSONObject r13 = new JSONObject(r5);     // Catch: Throwable -> L164
        if ("ss_app_log".equals(r13.optString("magic_tag")) == true) goto L79;
    L81:
        boolean r14 = false;
    L82:
        int r17 = r9;
        if (r14 == true) goto L177;
        e.a().b(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT, 1);     // Catch: Throwable -> L155
        ita.j.c("app_log response is failed: " + r5, null);     // Catch: Throwable -> L155
    L96:
        if (AppLog.S0 == false) goto L98;
        AppLog.u0 = r13.optLong("uid");     // Catch: Throwable -> L155
        AppLog.v0 = r13.optInt("user_type");     // Catch: Throwable -> L155
        AppLog.w0 = r13.optInt("user_is_login");     // Catch: Throwable -> L155
        AppLog.x0 = r13.optInt("user_is_auth");     // Catch: Throwable -> L155
    L98:
        long r16 = r13.optLong("batch_event_interval", 0) * 1000;     // Catch: Throwable -> L155
        if (AppLog.g(r16) == false) goto L102;
        this.F.set(r16);     // Catch: Throwable -> L155
    L104:
        j r18 = this.M;     // Catch: Throwable -> L155
        if (r18 == null) goto L179;
        r18.d(r13);     // Catch: Throwable -> L155
    L179:
        if (AppLog.u() == false) goto L139;
        if (r13.optJSONObject("blocklist") == null) goto L132;
        ita.j.b("AppLog block list keys: " + r13.optJSONObject("blocklist"), null);     // Catch: Throwable -> L144
        JSONArray r19 = r13.optJSONObject("blocklist").optJSONArray("v1");     // Catch: Throwable -> L144
        if (r19 != null) goto L115;
    L122:
        JSONArray r20 = r13.optJSONObject("blocklist").optJSONArray("v3");     // Catch: Throwable -> L144
        if (r20 == null) goto L139;
        if (r20.length() <= 0) goto L139;
        int r21 = r20.length();     // Catch: Throwable -> L144
        int r24 = 0;
    L127:
        if (r24 >= r21) goto L139;
        String r27 = JSONArrayProtectorUtils.getString(r20, r24);     // Catch: Throwable -> L144
        if (StringUtils.isEmpty(r27) == true) goto L131;
        this.L.put(r27, "block");     // Catch: Throwable -> L144
    L131:
        r24 = r24 + 1;     // Catch: Throwable -> L144
        goto L127
    L115:
        if (r19.length() <= 0) goto L122;
        int r28 = r19.length();     // Catch: Throwable -> L144
        int r29 = 0;
    L117:
        if (r29 >= r28) goto L122;
        String r110 = JSONArrayProtectorUtils.getString(r19, r29);     // Catch: Throwable -> L144
        if (StringUtils.isEmpty(r110) == true) goto L121;
        this.K.put(r110, "block");     // Catch: Throwable -> L144
    L121:
        r29 = r29 + 1;     // Catch: Throwable -> L144
        goto L117
    L132:
        ita.j.b("AppLog block list is empty", null);     // Catch: Throwable -> L144
        if (this.K.isEmpty() == true) goto L136;
        this.K.clear();     // Catch: Throwable -> L144
    L136:
        if (this.L.isEmpty() == true) goto L139;
        this.L.clear();     // Catch: Throwable -> L144
    L139:
        if (AppLog.p() <= 0) goto L147;
        JSONObject r30 = r13.optJSONObject("sampling_list");     // Catch: Throwable -> L144
        if (r30 == null) goto L147;
        AppLog.U = gx3.d.b(this.w, null, r30, AppLog.U);     // Catch: Throwable -> L144
    L147:
        if (AppLog.u() == false) goto L152;
        j r31 = this.M;     // Catch: Throwable -> L155
        if (r31 == null) goto L152;
        r11 = r17;
        r31.b(r11, r25);     // Catch: Throwable -> L162
    L153:
        if (r14 == false) goto L158;
        r3 = 200;
    L162:
        th = th;
    L166:
        ita.j.c("Send log failed", th);
        e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);
        e.a().b(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT, 1);
        if (AppLog.u() == false) goto L171;
        j r32 = this.M;
        if (r32 == null) goto L171;
        r32.a(r11, r25, th);
    L171:
        throw th;
    L152:
        r11 = r17;
        goto L153
    L144:
        th = move-exception;
        ita.j.c("Parse log res failed", th);     // Catch: Throwable -> L155
    L155:
        th = th;
        r11 = r17;
        goto L166
    L102:
        if (this.G == this.F.get()) goto L104;
        this.F.set(this.G);     // Catch: Throwable -> L155
        goto L104
    L177:
        if (Logger.debug() == false) goto L175;
        ita.j.b("app_log upload success", null);     // Catch: Throwable -> L155
    L175:
        long r111 = r13.optLong("server_time");     // Catch: Exception -> L93 Throwable -> L155
        if (r111 <= 0) goto L96;
        JSONObject r33 = new JSONObject();     // Catch: Exception -> L93 Throwable -> L155
        r33.put("server_time", r111);     // Catch: Exception -> L93 Throwable -> L155
        r33.put("local_time", System.currentTimeMillis() / 1000);     // Catch: Exception -> L93 Throwable -> L155
        this.I = r33;     // Catch: Exception -> L93 Throwable -> L155
        if (m.b() == true) goto L96;
        m.c("server_time_sync", new y(r33));     // Catch: Exception -> L93 Throwable -> L155
    L93:
        e.a().b(StatsCountKeys.JSON_ERROR_COUNT, 1);     // Catch: Throwable -> L155
        goto L96
    L79:
        if ("success".equals(r13.optString("message")) == false) goto L81;
        r14 = true;
        goto L82
    L51:
        if (this.w == null) goto L68;
        if (AppLog.t() == false) goto L68;
        JSONObject r34 = new JSONObject(r26);     // Catch: Throwable -> L60
        String r112 = r34.optString("key");     // Catch: Throwable -> L60
        String r35 = r34.optString("iv");     // Catch: Throwable -> L60
        String[] r113 = new String[2];     // Catch: Throwable -> L60
        r113[r6] = r112;     // Catch: Throwable -> L60
        r113[1] = r35;     // Catch: Throwable -> L60
        if (nta.d.d(r113) == true) goto L63;
        String[] r114 = null;
    L183:
        r5 = c0.h(AppLog.s(), r12, r15, this.w, false, r114, r23, false, true);     // Catch: RuntimeException -> L66 Throwable -> L164
    L66:
        e = move-exception;
        e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);     // Catch: Throwable -> L164
        ita.j.c("Send encrypt log failed", e);     // Catch: Throwable -> L164
        r5 = c0.e(AppLog.s(), r12, r22, true, "application/octet-stream;tt-data=b", r23, false, true);     // Catch: Throwable -> L164
    L63:
        r114 = r113;
    L58:
        th = th;
    L62:
        ita.j.c("key iv failed", th);     // Catch: Throwable -> L164
        e.a().b(StatsCountKeys.JSON_ERROR_COUNT, 1);     // Catch: Throwable -> L164
    L60:
        th = th;
        r113 = null;
    L164:
        th = th;
        r11 = r9;
        goto L166
    L9:
        if (AppLog.g(r7) == true) goto L11;
        r7 = 60000;
    L11:
        long r36 = System.currentTimeMillis();
        long r115 = r2.c;
        if (r36 >= (r115 + r7)) goto L17;
        int r37 = r2.d;
        if (r37 >= r2.b) goto L25;
        r2.d = r37 + 1;
        goto L18
    L17:
        r2.c = r115 + (((r36 - r115) / r7) * r7);
        r2.d = 1;
    L26:
        r3 = 0;
        goto L27
    }

    public final void z(z r24, z r25, boolean r26, long r27, boolean r29, boolean r30) {
        if (AppLog.W == true) goto L5;
    L7:
        long r3 = AppLog.O;
        if (r3 == (-1)) goto L22;
        lta.h.g(this.w, r3);
        if (n() == true) goto L22;
        String r4 = jta.g.d();
        if (c0.f(r4) == true) goto L22;
        monitor-enter(this);
        this.x.put("device_id", r4);     // Catch: Throwable -> L16 Exception -> L149
    L16:
        th = move-exception;
        throw th;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L16
    L22:
        h r12 = h.d(this.w);
        if (r24 != null) goto L27;
        if (r25 != null) goto L27;
        return;
    L27:
        if (r24 == null) goto L105;
        long[] r8 = new long[1];
        if (r26 == false) goto L31;
        r8[0] = r27;
    L32:
        List<AppLog.g> r7 = this.z;
        String[] r6 = new String[1];
        JSONObject r5 = new JSONObject();
        monitor-enter(this);
        kta.u.a(this.x, r5);     // Catch: Throwable -> L101
        monitor-exit(this);     // Catch: Throwable -> L101
        SettingsManager.c r2 = AppLog.g0.E();
        if (r2 == null) goto L39;
        r2.a(r5);
    L39:
        long r9 = r12.a(r24, r25, r5, r26, r8, r6, r7, r29, this.I, r30);
        if (r9 > 0) goto L42;
        return;
    L42:
        if (r12.c(r9) == false) goto L167;
        String r10 = r6[0];
        if (r8[0] <= r27) goto L56;
        if (r29 == true) goto L47;
        if (r30 == false) goto L56;
    L47:
        w r11 = new w();
        r11.a = r24;
        r11.b = r25;
        r11.c = true;
        r11.d = r8[0];
        r11.e = r30;
        LinkedList<u> r13 = this.v;
        monitor-enter(r13);
        this.v.add(r11);     // Catch: Throwable -> L52
        monitor-exit(r13);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        throw th;
    L56:
        if (AppLog.V == false) goto L63;
        r r14 = new r();
        r14.a = r9;
        r14.b = r10;
        r14.c = 0;
        boolean r15 = f(r14);
        String r16 = r14.b;
        if (r15 == true) goto L61;
        e.a().b(StatsCountKeys.ADJUST_TERMINATE_BLOCK_REQUEST_COUNT, 1);
        return;
    L61:
        r10 = r16;
    L63:
        if (NetworkUtils.isNetworkAvailable(this.w) == false) goto L100;
        JSONObject r17 = null;
        ita.j.b("begin to send batch logs: " + r9, null);     // Catch: Throwable -> L86
        int r18 = y(AppLog.p0.a, r10);     // Catch: Throwable -> L86
        if (r18 != (-1)) goto L70;
        return;
    L70:
        if (r18 != 200) goto L72;
        boolean r19 = true;
    L73:
        if (r19 == false) goto L161;
    L84:
        th = th;
    L88:
        ita.j.c("send session exception: ", th);
        goto L161
    L75:
        if (n() == false) goto L161;
        if (r25 == null) goto L79;
        r25.i = true;     // Catch: Throwable -> L84
        r12.r(r25.a);     // Catch: Throwable -> L84
    L79:
        if (((HashSet) r12.c).contains(Long.valueOf(r24.a)) == false) goto L161;
        if (((HashSet) r12.d).contains(Long.valueOf(r24.a)) == true) goto L161;
        ((HashSet) r12.d).add(Long.valueOf(r24.a));     // Catch: Throwable -> L84
    L161:
        r17 = new JSONObject(r10);     // Catch: Throwable -> L91
        int r20 = 1;
    L92:
        u(r17, r19);
        ita.e.e(r17, r19);
        boolean r0 = r12.n(r9, r19);
        if (r19 == true) goto L96;
        if (r0 == false) goto L96;
        Object[] r21 = new Object[r20];
        r21[0] = q(r17);
        a0.a(3, 0, r21);
        Object[] r22 = new Object[r20];
        r22[0] = s(r17);
        a0.a(4, 0, r22);
        h.k(r17);
    L96:
        if (r19 == false) goto L98;
        return;
    L98:
        if (this.A >= 0) goto L169;
        this.A = r9;
        return;
    L169:
        return;
    L91:
        r20 = 1;
        e.a().b(StatsCountKeys.JSON_ERROR_COUNT, 1);
        goto L92
    L72:
        r19 = false;
    L86:
        th = th;
        r19 = false;
        goto L88
    L100:
        e.a().b(StatsCountKeys.NO_NETWORK_COUNT, 1);
        return;
    L167:
        return;
    L101:
        th = move-exception;
        throw th;
    L31:
        r8[0] = 0;
        goto L32
    L105:
        if (r25 == null) goto L146;
        if (NetworkUtils.isNetworkAvailable(this.w) == false) goto L146;
        if (this.H <= 0) goto L146;
        if (r25.h == true) goto L146;
    L143:
        th = move-exception;
        e.a().b(StatsCountKeys.PACK_ERROR_COUNT, 1);
        ita.j.c("AppLog send launch exception: ", th);
        return;
    L113:
        if (n() == true) goto L115;
        return;
    L115:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L143
        r1.put("magic_tag", "ss_app_log");     // Catch: Throwable -> L143
        JSONObject r23 = new JSONObject();     // Catch: Throwable -> L143
        monitor-enter(this);     // Catch: Throwable -> L143
        kta.u.a(this.x, r23);     // Catch: Throwable -> L140
        monitor-exit(this);     // Catch: Throwable -> L140
        Context r28 = this.w;     // Catch: Throwable -> L143
        String[] r31 = f.a;     // Catch: Throwable -> L143
        String r32 = f.a(n.c(r28));     // Catch: Throwable -> L143
        if (TextUtils.isEmpty(r32) == true) goto L122;
        r23.put("oaid", r32);     // Catch: Throwable -> L143
    L122:
        SettingsManager.c r33 = AppLog.g0.E();     // Catch: Throwable -> L143
        if (r33 == null) goto L125;
        r33.a(r23);     // Catch: Throwable -> L143
    L125:
        r1.put("header", r23);     // Catch: Throwable -> L143
        JSONArray r34 = new JSONArray();     // Catch: Throwable -> L143
        JSONObject r35 = new JSONObject();     // Catch: Throwable -> L143
        r35.put("datetime", AppLog.m(r25.c));     // Catch: Throwable -> L143
        r35.put("session_id", r25.b);     // Catch: Throwable -> L143
        r35.put("local_time_ms", r25.c);     // Catch: Throwable -> L143
        r35.put("tea_event_index", r25.d);     // Catch: Throwable -> L143
        r35.put("event_id", AppLog.f0.incrementAndGet());     // Catch: Throwable -> L143
        if (r25.h == false) goto L128;
        r35.put("is_background", true);     // Catch: Throwable -> L143
    L129:
        String r36 = AppLog.n();     // Catch: Throwable -> L143
        ita.j.e("send first launch, uid: " + AppLog.g0.getUserId() + ", abSdkVersion: " + r36);     // Catch: Throwable -> L143
        if (TextUtils.isEmpty(r36) == true) goto L132;
        r35.put("ab_sdk_version", r36);     // Catch: Throwable -> L143
    L132:
        r34.put(r35);     // Catch: Throwable -> L143
        ita.e.b(r35);     // Catch: Throwable -> L143
        e.a().b(StatsCountKeys.COLLECT_LAUNCH_COUNT, 1);     // Catch: Throwable -> L143
        r1.put(EventVerify.TYPE_LAUNCH, r34);     // Catch: Throwable -> L143
        AppLog.l(r1, true);     // Catch: Throwable -> L143
        if (200 != y(AppLog.p0.a, r1.toString())) goto L135;
        r25.i = true;     // Catch: Throwable -> L143
        r12.r(r25.a);     // Catch: Throwable -> L143
        ((HashSet) r12.d).add(Long.valueOf(r25.a));     // Catch: Throwable -> L143
        e.a().b(StatsCountKeys.REPORT_SUCCESS_LAUNCH_COUNT, 1);     // Catch: Throwable -> L143
        ita.e.e(r1, true);     // Catch: Throwable -> L143
    L136:
        ((HashSet) r12.c).add(Long.valueOf(r25.a));     // Catch: Throwable -> L143
        if (EventVerify.inst().isEnable() == false) goto L172;
        EventVerify.inst().putEvent(EventVerify.TYPE_LAUNCH, r34);     // Catch: Throwable -> L143
        return;
    L172:
        return;
    L135:
        e.a().b(StatsCountKeys.REPORT_FAILED_LAUNCH_COUNT, 1);     // Catch: Throwable -> L143
        ita.e.e(r1, false);     // Catch: Throwable -> L143
        goto L136
    L128:
        e.a().b(StatsCountKeys.COLLECT_FRONT_LAUNCH_COUNT, 1);     // Catch: Throwable -> L143
        goto L129
    L140:
        th = move-exception;
        throw th;     // Catch: Throwable -> L143
    L146:
        if (NetworkUtils.isNetworkAvailable(this.w) == true) goto L174;
        e.a().b(StatsCountKeys.NO_NETWORK_COUNT, 1);
        return;
    L174:
        return;
    L5:
        if (AppLog.X == true) goto L7;
    }

    public x(Context r8, JSONObject r9, LinkedList<u> r10, AtomicBoolean r11, List<AppLog.g> r12, z r13, ConcurrentHashMap r14, ConcurrentHashMap r15) {
        super("LogReaper");
        new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        this.A = 0;
        this.B = 0;
        this.E = 0;
        this.F = new AtomicLong();
        this.G = 60000;
        this.H = 1;
        this.I = null;
        this.J = 120000;
        this.w = r8;
        this.x = r9;
        this.v = r10;
        this.y = r11;
        this.z = r12;
        C(r13);
        this.K = r14;
        this.L = r15;
        this.M = new j(r8);
        String[] r16 = AppLog.p0.a;
        int r17 = r16.length;
        int r18 = 0;
    L3:
        if (r18 >= r17) goto L21;
        String r19 = r16[r18];
        j.a r110 = this.M.b;
        monitor-enter(r110);
        if (StringUtils.isEmpty(r19) == false) goto L9;
    L15:
        monitor-exit(r110);
        r18 = r18 + 1;
        goto L3
    L9:
        if (((HashMap) r110.b).containsKey(r19) == true) goto L15;
        j.a.C0004a r111 = new j.a.C0004a();     // Catch: Throwable -> L17
        SharedPreferences r112 = r110.c.a.getSharedPreferences(kta.b.a, 0);     // Catch: Throwable -> L17
        if ((System.currentTimeMillis() - r112.getLong(r19 + "_downgrade_time", 0)) >= 10800000) goto L13;
        r111.a = r112.getInt(r19 + "_downgrade_index", 0);     // Catch: Throwable -> L17
    L14:
        ((HashMap) r110.b).put(r19, r111);     // Catch: Throwable -> L17
        goto L15
    L13:
        r112.edit().remove(r19 + "_downgrade_time").remove(r19 + "_downgrade_index").commit();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L21:
        if (m.b() == true) goto L27;
        m.c("set_header", new a(this));
        return;
    }
}
