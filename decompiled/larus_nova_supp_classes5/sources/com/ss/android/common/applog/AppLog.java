package com.ss.android.common.applog;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.tool.BtmDebugTool;
import com.bytedance.applog.IBDAccountCallback;
import com.bytedance.applog.m;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.util.BlockHelper;
import com.bytedance.common.utility.AppLogNetworkStatusMonitor;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.pitaya.api.PitayaProxy;
import com.larus.network.NetQualityManager;
import com.obric.sva.sdk.applog.InteractorAppLogLogger;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.android.ugc.effectmanager.common.EffectRequest;
import eta.b;
import ex3.e;
import gx3.c;
import iqa.a;
import ita.d;
import ita.j;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import jta.f;
import jta.g;
import jta.k;
import kta.u;
import lta.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class AppLog {
    public static f A0 = null;
    public static volatile JSONObject B0 = null;
    public static boolean C0 = false;
    public static b D0 = null;
    public static volatile boolean E0 = false;
    public static volatile long F0 = 0;
    public static final ConcurrentHashMap<String, String> G0 = null;
    public static final Bundle H0 = null;
    public static boolean I0 = false;
    public static final SimpleDateFormat J0 = null;
    public static final SimpleDateFormat K0 = null;
    public static boolean L = false;
    public static final Object L0 = null;
    public static volatile String M = null;
    public static final ThreadLocal<Boolean> M0 = null;
    public static volatile String N = null;
    public static volatile boolean N0 = false;
    public static long O = -1;
    public static volatile boolean O0;
    public static volatile boolean P;
    public static int P0;
    public static boolean Q;
    public static long Q0;
    public static volatile m R;
    public static final long R0 = 0;
    public static volatile a S;
    public static volatile boolean S0;
    public static volatile AtomicInteger T;
    public static volatile IBDAccountCallback T0;
    public static volatile c U;
    public static volatile boolean V;
    public static volatile boolean W;
    public static volatile boolean X;
    public static volatile long Y;
    public static volatile int Z;
    public static volatile long a0;
    public static volatile int b0;
    public static volatile boolean c0;
    public static volatile m d0;
    public static volatile boolean e0;
    public static final AtomicLong f0 = null;
    public static n g0;
    public static final boolean h0 = false;
    public static final boolean i0 = false;
    public static final boolean j0 = false;
    public static final boolean k0 = false;
    public static final boolean l0 = false;
    public static boolean m0;
    public static volatile boolean n0;
    public static final String[] o0 = null;
    public static m0 p0;
    public static volatile int q0;
    public static final Object r0 = null;
    public static volatile AppLog s0;
    public static final AtomicLong t0 = null;
    public static volatile long u0;
    public static volatile int v0;
    public static volatile int w0;
    public static volatile int x0;
    public static String y0;
    public static final List<g> z0 = null;
    public final LinkedList<h> A;
    public long B;
    public volatile long C;
    public volatile long D;
    public volatile boolean E;
    public final ConcurrentHashMap<String, String> F;
    public final ConcurrentHashMap<String, String> G;
    public final ConcurrentHashMap<String, String> H;
    public final AtomicLong I;
    public final AtomicLong J;
    public volatile long K;
    public int a;
    public boolean b;
    public boolean c;
    public int d;
    public final AppLogNetworkStatusMonitor e;
    public volatile boolean f;
    public final LinkedList<c> g;
    public final LinkedList<u> h;
    public volatile x i;
    public e j;
    public long k;
    public final Context l;
    public final JSONObject m;
    public boolean n;
    public final HashSet<Integer> o;
    public volatile boolean p;
    public final AtomicBoolean q;
    public z r;
    public long s;
    public long t;
    public volatile long u;
    public int v;
    public int w;
    public JSONObject x;
    public final AtomicInteger y;
    public final AtomicInteger z;

    public static class i implements n {
        public SharedPreferences a;

        @Override // com.ss.android.common.applog.n
        public final void A() {
            AppLog.W = false;
            g.f = false;
        }

        @Override // com.ss.android.common.applog.n
        public final void B() {
            AppLog.V = true;
        }

        @Override // com.ss.android.common.applog.n
        public final void q() {
            AppLog.S0 = true;
        }

        @Override // com.ss.android.common.applog.n
        public final void r() {
            AppLog.e0 = true;
        }

        @Override // com.ss.android.common.applog.n
        public final JSONObject C() {
            AppLog r0 = AppLog.s0;
            if (r0 != null) goto L5;
            return null;
        L5:
            return r0.x;
        }

        @Override // com.ss.android.common.applog.n
        public final int H() {
            SharedPreferences r0 = this.a;
            if (r0 != null) goto L5;
            return 0;
        L5:
            return r0.getInt("content_encode_method", 0);
        }

        @Override // com.ss.android.common.applog.n
        public final String getCurrentSessionId() {
            AppLog r0 = AppLog.s0;
            if (r0 == null) goto L8;
            z r1 = r0.r;
            if (r1 != null) goto L7;
            return null;
        L7:
            return r1.b;
        L8:
            return null;
        }

        @Override // com.ss.android.common.applog.n
        public final String getInstallId() {
            if (AppLog.s0 != null) goto L5;
            return null;
        L5:
            return g.e();
        }

        @Override // com.ss.android.common.applog.n
        public final String getServerDeviceId() {
            if (AppLog.s0 != null) goto L5;
            return null;
        L5:
            return g.d();
        }

        @Override // com.ss.android.common.applog.n
        public final String getUserId() {
            return String.valueOf(AppLog.t0.get());
        }

        @Override // com.ss.android.common.applog.n
        public final String w() {
            boolean r0 = AppLog.L;
            return AppLog.M;
        }

        public i() {
        }

        @Override // com.ss.android.common.applog.n
        public final void D() {
            boolean r0 = AppLog.L;
        }

        @Override // com.ss.android.common.applog.n
        public final a E() {
            return AppLog.S;
        }

        @Override // com.ss.android.common.applog.n
        public final void G() {
            g r0 = g.a;
        }

        @Override // com.ss.android.common.applog.n
        public final String getSessionKey() {
            return AppLog.y0;
        }

        @Override // com.ss.android.common.applog.n
        public final m h() {
            return AppLog.d0;
        }

        @Override // com.ss.android.common.applog.n
        public final void k() {
            g r0 = g.a;
        }

        @Override // com.ss.android.common.applog.n
        public final JSONObject m() {
            return AppLog.B0;
        }

        @Override // com.ss.android.common.applog.n
        public final void p() {
            g r0 = g.a;
        }

        @Override // com.ss.android.common.applog.n
        public final void a(String r1) {
            AppLog.M = r1;
        }

        @Override // com.ss.android.common.applog.n
        public final void b(b r1) {
            AppLog.D0 = r1;
            g.h(r1);
        }

        @Override // com.ss.android.common.applog.n
        public final void c(boolean r1) {
            AppLog.P = r1;
        }

        @Override // com.ss.android.common.applog.n
        public final void d(Bundle r5) {
            if (r5.size() <= 0) goto L20;
            AppLog r0 = AppLog.s0;     // Catch: Throwable -> L21
            if (r0 != null) goto L22;
            Bundle r1 = AppLog.H0;     // Catch: Throwable -> L21
            monitor-enter(r1);     // Catch: Throwable -> L21
            r1.putAll(r5);     // Catch: Throwable -> L17
            monitor-exit(r1);     // Catch: Throwable -> L17
        L15:
            g.j.s(r5);     // Catch: Throwable -> L21
            return;
        L17:
            th = move-exception;
            throw th;     // Catch: Throwable -> L21
        L22:
            Bundle r2 = new Bundle();     // Catch: Throwable -> L9
            r2.putAll(r5);     // Catch: Throwable -> L9
            c r3 = new c(ActionQueueType.CUSTOMER_HEADER_UPDATE);     // Catch: Throwable -> L9
            r3.b = r2;     // Catch: Throwable -> L9
            r0.i(r3);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L21
            goto L15
        L20:
            return;
        }

        @Override // com.ss.android.common.applog.n
        public final AppLog e(Context r5) {
            AppLog.h(r5, u.a);
            Object r1 = AppLog.r0;
            monitor-enter(r1);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (AppLog.s0 != null) goto L9;
            AppLog.s0 = new AppLog(r5, 0);     // Catch: Throwable -> L12
            if (Logger.debug() == false) goto L9;
            j.b("Process AppLog = " + AppLog.s0.toString() + " pid = " + Process.myPid(), null);     // Catch: Throwable -> L12
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L12
            return AppLog.s0;
        }

        @Override // com.ss.android.common.applog.n
        public final void f(boolean r1) {
            AppLog.n0 = r1;
        }

        @Override // com.ss.android.common.applog.n
        public final void g(Map<String, String> r3) {
            Object r0 = AppLog.r0;
            monitor-enter(r0);
            AppLog r1 = AppLog.s0;     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            if (r1 != null) goto L8;
            return;
        L8:
            g.j.x(r3, g.c);
            String r2 = String.valueOf(AppLog.t0.get());
            if (r2 == null) goto L17;
            ((HashMap) r3).put("user_id", r2);
            return;
        L17:
            return;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // com.ss.android.common.applog.n
        public final void j(boolean r2) {
            if (r2 == false) goto L4;
            AppLog.T.set(AppLog.T.get() | 1);
            return;
        L4:
            AppLog.T.set(AppLog.T.get() & (-2));
        }

        @Override // com.ss.android.common.applog.n
        public final void l(a0.a r1) {
            a0.a = r1;
        }

        @Override // com.ss.android.common.applog.n
        public final void n(InteractorAppLogLogger r1) {
            j.a = r1;
        }

        @Override // com.ss.android.common.applog.n
        public final void o(com.obric.sva.sdk.applog.a r1) {
            AppLog.T0 = r1;
        }

        @Override // com.ss.android.common.applog.n
        public final void onPause(Context r10) {
            if ((r10 instanceof Activity) == false) goto L28;
            String r0 = r10.getClass().getName();
            int r1 = r10.hashCode();
            if (TextUtils.isEmpty(r0) == true) goto L29;
            AppLog r11 = e(r10);
            if (r11 != null) goto L10;
        L26:
            g.j.onPause();
            return;
        L10:
            if (r11.f == false) goto L26;
            long r2 = System.currentTimeMillis();
            e r4 = r11.j;
            if (r4 != null) goto L14;
        L15:
            if (r4 == null) goto L17;
            String r3 = r4.b;
        L18:
            j.g("AppLog unmatched onPause: " + r0 + " " + r3, null);
            r11.k = r2 - 1010;
        L19:
            r11.j = null;
            int r5 = (int) ((r2 - r11.k) / 1000);
            if (r5 > 0) goto L22;
            r5 = 1;
        L22:
            r11.k = r2;
            if (Logger.debug() == false) goto L25;
            j.f("AppLog onPause " + r5 + " " + r0);
        L25:
            s r6 = new s();
            r6.a = r0;
            r6.b = r5;
            c r7 = new c(ActionQueueType.PAGE_END);
            r7.b = r6;
            r7.c = r2;
            r11.i(r7);
            goto L26
        L17:
            r3 = "(null)";
            goto L18
        L14:
            if (r4.a == r1) goto L19;
        L29:
            return;
        }

        @Override // com.ss.android.common.applog.n
        public final void onResume(Context r6) {
            if ((r6 instanceof Activity) == false) goto L20;
            String r0 = r6.getClass().getName();
            int r1 = r6.hashCode();
            if (TextUtils.isEmpty(r0) == true) goto L20;
            boolean r2 = AppLog.L;
            String.valueOf(System.currentTimeMillis());
            e r3 = new e(r0, r1);
            AppLog r4 = e(r6);
            if (r4 != null) goto L10;
        L18:
            g.j.onResume();
            goto L20
        L10:
            if (r4.f == false) goto L18;
            if (r4.j == null) goto L14;
            j.g("AppLog onPause not call on " + r4.j.b, null);
        L14:
            long r5 = System.currentTimeMillis();
            r4.k = r5;
            r4.j = r3;
            if (Logger.debug() == false) goto L17;
            j.f("AppLog onResume ".concat(r0));
        L17:
            c r7 = new c(ActionQueueType.PAGE_START);
            r7.c = r5;
            r4.i(r7);
        L20:
            if (AppLog.m0 == true) goto L23;
            AppLog.c(r6.getApplicationContext());
            return;
        }

        @Override // com.ss.android.common.applog.n
        public final void registerHeaderCustomCallback(a r1) {
            AppLog.S = r1;
        }

        @Override // com.ss.android.common.applog.n
        public final void setAnonymous(boolean r2) {
            if (AppLog.E0 == true) goto L7;
            AppLog.L = r2;
            return;
        L7:
            throw new IllegalStateException("please call before init");
        }

        @Override // com.ss.android.common.applog.n
        public final void setSessionKey(String r1) {
            AppLog.y0 = r1;
        }

        @Override // com.ss.android.common.applog.n
        public final void setUserId(long r2) {
            AppLog.t0.set(r2);
        }

        @Override // com.ss.android.common.applog.n
        public final void t(String r2) {
            if (StringUtils.isEmpty(r2) == true) goto L8;
            String[] r0 = d0.a;
            if (StringUtils.isEmpty(r2) == true) goto L9;
            d0.i = r2;
            return;
        L9:
            return;
        }

        @Override // com.ss.android.common.applog.n
        public final void u(f r1) {
            AppLog.A0 = r1;
        }

        @Override // com.ss.android.common.applog.n
        public final void v(String r2) {
            if (StringUtils.isEmpty(r2) == true) goto L8;
            String r0 = h.e;
            if (StringUtils.isEmpty(r2) == true) goto L9;
            h.e = r2;
            return;
        L9:
            return;
        }

        @Override // com.ss.android.common.applog.n
        public final void x(String r2) {
            if (StringUtils.isEmpty(r2) == false) goto L5;
            return;
        L5:
            if (StringUtils.isEmpty(r2) == true) goto L9;
            kta.b.a = r2;
            return;
        }

        @Override // com.ss.android.common.applog.n
        public final boolean y(String r1) {
            return c0.f(r1);
        }

        @Override // com.ss.android.common.applog.n
        public final void z(m r1) {
            AppLog.R = r1;
        }

        @Override // com.ss.android.common.applog.n
        public final void i(String r7, JSONObject r8) {
            boolean r1 = AppLog.L;
            if (StringUtils.isEmpty(r7) == true) goto L36;
            if (r8 != null) goto L6;
            return;
        L6:
            if (r8.length() <= 0) goto L39;
            AppLog r2 = AppLog.s0;
            if (r2 == null) goto L38;
            e.a().b(StatsCountKeys.COLLECT_EVENT_COUNT, 1);
            if (AppLog.p() <= 0) goto L21;
            c r3 = AppLog.U;     // Catch: Exception -> L25
            if (r3 == null) goto L21;
            if (r3.a(AppLog.e(), "log_data", r8) == false) goto L21;
            e.a().b(StatsCountKeys.FILTER_DROP_EVENT_COUNT, 1);     // Catch: Exception -> L25
            return;
        L21:
            if (EventVerify.inst().isEnable() == false) goto L23;
            r8.put("log_type", r7);     // Catch: Exception -> L25
            JSONArray r4 = new JSONArray();     // Catch: Exception -> L25
            r4.put(r8);     // Catch: Exception -> L25
            EventVerify.inst().putEvent("log_data", r4);     // Catch: Exception -> L25
        L23:
            r8.put("event_id", AppLog.f0.incrementAndGet());     // Catch: Exception -> L25
        L26:
            e.a().b(StatsCountKeys.ACCEPT_EVENT_COUNT, 1);
            if (com.bytedance.applog.log.m.b() == true) goto L33;
            long r5 = r8.optLong("event_id", 0);
            if (r5 <= 0) goto L33;
            com.bytedance.applog.log.m.c("event_receive", new ita.c(r8, r5, r7));
        L33:
            c r0 = new c(ActionQueueType.SAVE_MISC_LOG);
            r0.d = r7;
            r0.b = r8;
            r2.i(r0);
            return;
        L38:
            return;
        L39:
            return;
        }

        @Override // com.ss.android.common.applog.n
        public final void F(Context r3, boolean r4, m0 r5) {
            if (AppLog.e0 == false) goto L24;
            if (r5 == null) goto L22;
            AppLog.p0 = r5;
            g.j.y(r5.e, r5.d);
            if (com.bytedance.applog.log.m.b() == true) goto L8;
            com.bytedance.applog.log.m.c("init_begin", new a(r3));
        L8:
            AppLog.E0 = true;
            if ((r3 instanceof Activity) == false) goto L12;
            AppLog.C0 = true;
        L12:
            if (AppLog.d0 != null) goto L14;
            AppLog.d0 = new com.ss.android.common.applog.i(r3);
        L14:
            e(r3);
            if (AppLog.I0 == true) goto L17;
            AppLog.I0 = true;
            d r0 = d.a();
            r0.getClass();
            new c(r0).start();
        L17:
            AppLog.m0 = !r4;
            AppLog.P0 = 1;
            this.a = r3.getSharedPreferences(kta.b.a, 0);
            AppLog.g0.p();
            ApplogServiceImpl.isServicePrepared = true;
            ApplogServiceImpl.handleCachedData();
            if (com.bytedance.applog.log.m.b() == true) goto L25;
            com.bytedance.applog.log.m.e(String.valueOf(g.c()));
            com.bytedance.applog.log.m.c("start_end", new b());
            return;
        L25:
            return;
        L22:
            throw new IllegalArgumentException("urlConfig must not be null");
        L24:
            throw new IllegalArgumentException("Only support main process init!");
        }

        @Override // com.ss.android.common.applog.n
        public final void s(String r20, String r21, String r22, long r23, long r25, boolean r27, JSONObject r28) {
            JSONObject r0 = r28;
            AppLog r14 = AppLog.s0;
            if (r14 != null) goto L19;
            d r1 = d.a();
            LinkedList r12 = r1.a;
            monitor-enter(r12);
        L15:
            th = move-exception;
            throw th;
        L7:
            if (r1.a.size() <= 200) goto L11;
            d.a r9 = (d.a) r1.a.poll();     // Catch: Throwable -> L15
            a0.a(1, 1, null);     // Catch: Throwable -> L15
            if (r9 == null) goto L11;
            e.a().b(StatsCountKeys.CACHE_DROP_EVENT_COUNT, 1);     // Catch: Throwable -> L15
        L11:
            r1.a.add(new d.a(r20, r21, r22, r23, r25, r27, r28));     // Catch: Throwable -> L15
            monitor-exit(r12);     // Catch: Throwable -> L15
            j.g("AppLog null context when onEvent", null);
            return;
        L19:
            if (StringUtils.isEmpty(r20) == false) goto L21;
            int r2 = 1;
            int r3 = 0;
        L161:
            a0.a(r2, r3, null);
            return;
        L21:
            if (StringUtils.isEmpty(r21) == false) goto L24;
            r3 = 0;
            r2 = 1;
            goto L161
        L24:
            if (r14.f == true) goto L26;
            a0.a(1, 3, null);
            return;
        L26:
            e.a().b(StatsCountKeys.COLLECT_EVENT_COUNT, 1);
            if (AppLog.u() == false) goto L53;
            if (AppLogNewUtils.EVENT_V3_CATEGORY.equalsIgnoreCase(r20) == false) goto L41;
            ConcurrentHashMap<String, String> r13 = r14.G;     // Catch: Throwable -> L62
            if (r13 == null) goto L53;
            if (r13.size() <= 0) goto L53;
            if (StringUtils.isEmpty(r21) == true) goto L53;
            if (r14.G.containsKey(r21) == false) goto L53;
            j.g("AppLog hit block event v3", null);     // Catch: Throwable -> L62
            e.a().b(StatsCountKeys.FILTER_DROP_EVENT_COUNT, 1);     // Catch: Throwable -> L62
            a0.a(1, 2, null);     // Catch: Throwable -> L62
            return;
        L41:
            ConcurrentHashMap<String, String> r15 = r14.F;     // Catch: Throwable -> L62
            if (r15 == null) goto L53;
            if (r15.size() <= 0) goto L53;
            if (StringUtils.isEmpty(r22) == true) goto L48;
            String r16 = r21 + r22;     // Catch: Throwable -> L62
        L50:
            if (r14.F.containsKey(r16) == false) goto L53;
            j.g("AppLog hit block event v1", null);     // Catch: Throwable -> L62
            e.a().b(StatsCountKeys.FILTER_DROP_EVENT_COUNT, 1);     // Catch: Throwable -> L62
            a0.a(1, 2, null);     // Catch: Throwable -> L62
            return;
        L48:
            r16 = r21;
        L53:
            if (AppLog.p() <= 0) goto L63;
            if (AppLogNewUtils.EVENT_V3_CATEGORY.equalsIgnoreCase(r20) == false) goto L63;
            c r10 = AppLog.U;     // Catch: Throwable -> L62
            if (r10 == null) goto L63;
            if (r10.a(AppLog.e(), r21, r0) == false) goto L63;
            e.a().b(StatsCountKeys.FILTER_DROP_EVENT_COUNT, 1);     // Catch: Throwable -> L62
            return;
        L63:
            q r17 = new q();
            r17.a = AppLog.f0.incrementAndGet();
            r17.b = r20;
            r17.c = r21;
            r17.d = r22;
            r17.e = r23;
            r17.f = r25;
            NetworkUtils.NetworkType r11 = r14.e.getNetworkType();
            if (r11 == null) goto L70;
            if (r0 != null) goto L167;
            r0 = new JSONObject();
        L167:
            r0.put("nt", r11.getValue());     // Catch: Exception -> L69
        L70:
            JSONObject r18 = r0;
            long r19 = AppLog.t0.get();
            IBDAccountCallback r4 = AppLog.T0;
            if (AppLog.S0 == false) goto L79;
            if (r4 == null) goto L79;
            Pair r5 = r4.getOdinUserInfo();
            if (((Long) r5.second).longValue() <= 0) goto L77;
            r17.h = ((Long) r5.second).longValue();
            r17.j = 1;
            r17.k = 1;
            r17.g = ((Integer) r5.first).intValue();
            r17.i = ((Long) r5.second).longValue();
        L80:
            if (r18 == null) goto L88;
            JSONObject r110 = r18;
            if (r110.has(AppLogNewUtils.EVENT_RESERVED_FIELD_TIME_STAMP) == true) goto L172;
        L89:
            r17.l = System.currentTimeMillis();
        L90:
            if (r110 == null) goto L113;
            b r6 = AppLog.D0;
            if (r6 != null) goto L94;
        L96:
            boolean r7 = false;
        L176:
            r17.n = r110.toString();     // Catch: StackOverflowError -> L99 ConcurrentModificationException -> L105
        L99:
            e = move-exception;
            if (r7 == true) goto L104;
            j.c("ext json toString stack overflow tag: " + r21 + ", label: " + r22, e);
            goto L113
        L104:
            throw new RuntimeException("ext json toString stack overflow tag: " + r21 + ", label: " + r22, e);
        L105:
            r17.n = r110.toString();     // Catch: Throwable -> L107
        L107:
            th = move-exception;
            if (r7 == true) goto L112;
            j.c("ext json exception tag: " + r21 + ", label: " + r22, th);
            goto L113
        L112:
            throw new RuntimeException("ext json exception tag: " + r21 + ", label: " + r22, th);
        L94:
            if ("local_test".equalsIgnoreCase(r6.getChannel()) == false) goto L96;
            r7 = true;
        L113:
            String r8 = r17.n;
            if (r8 != null) goto L116;
        L118:
            boolean r24 = false;
        L119:
            r17.o = r27;
            r17.p = r24;
            if (Logger.debug() == false) goto L165;
            StringBuilder r26 = new StringBuilder("onEvent ");
            r26.append(r20);
            r26.append(" ");
            r26.append(r21);
            r26.append(" ");
            r26.append(r22);
            if (r23 != 0) goto L127;
            long r29 = r25;
            if (r29 != 0) goto L128;
            if (r110 != null) goto L128;
        L130:
            if (r29 != 0) goto L132;
            if (r110 != null) goto L132;
        L133:
            if (r110 == null) goto L135;
            r26.append(" ");
            r26.append(r110);
        L135:
            j.f("AppLog " + r26);
        L132:
            r26.append(" ");
            r26.append(r29);
        L128:
            r26.append(" ");
            r26.append(r23);
            goto L130
        L127:
            r29 = r25;
        L165:
            if (EventVerify.inst().isEnable() == false) goto L143;
            q r111 = r17;
            EventVerify.inst().putEvent(r20, r21, r22, r23, r25, r17.h, r17.l, r110);     // Catch: Exception -> L163
        L144:
            String r30 = r111.b;
            if (AppLogNewUtils.EVENT_V3_CATEGORY.equalsIgnoreCase(r30) == false) goto L148;
            r30 = "EVENT_V3";
        L148:
            if (com.bytedance.applog.log.m.b() == true) goto L158;
            long r31 = r111.a;
            if (r31 > 0) goto L155;
            r31 = 0;
        L155:
            if (r31 <= 0) goto L158;
            com.bytedance.applog.log.m.c("event_receive", new d(r30, r31, r111));
        L158:
            e.a().b(StatsCountKeys.ACCEPT_EVENT_COUNT, 1);
            c r32 = new c(ActionQueueType.EVENT);
            r32.b = r111;
            r14.i(r32);
            return;
        L143:
            r111 = r17;
            goto L144
        L116:
            if (r8.length() <= 50000) goto L118;
            r24 = false;
            a0.a(5, 0, new Object[]{r20, r21, r22, Integer.valueOf(r17.n.length())});
            goto L119
        L172:
            r17.l = JSONObjectProtectorUtils.getLong(r110, AppLogNewUtils.EVENT_RESERVED_FIELD_TIME_STAMP);     // Catch: Throwable -> L85
        L87:
            r110.remove(AppLogNewUtils.EVENT_RESERVED_FIELD_TIME_STAMP);
        L85:
            th = move-exception;
            th.printStackTrace();
            r17.l = System.currentTimeMillis();
            goto L87
        L88:
            r110 = r18;
            goto L89
        L77:
            if (AppLog.w0 != 0) goto L80;
            r17.j = AppLog.w0;
            r17.k = AppLog.x0;
            r17.g = AppLog.v0;
            r17.i = AppLog.u0;
        L79:
            r17.h = r19;
            goto L80
        }
    }

    public static boolean g(long r3) {
        if (r3 >= 10000) goto L5;
    L7:
        return false;
    L5:
        if (r3 > 300000) goto L7;
        return true;
    }

    public final synchronized void k() {
        monitor-enter(this);
        B0 = new JSONObject(this.m, f.a);     // Catch: Throwable -> L5 JSONException -> L7
    L9:
        monitor-exit(this);
        return;
    L5:
        th = move-exception;
        throw th;
    L7:
        e = move-exception;
        j.c("ensureHeaderCopy error", e);     // Catch: Throwable -> L5
        goto L9
    }

    static {
        T = new AtomicInteger(0);
        V = false;
        W = false;
        X = true;
        Y = 432000000;
        Z = 10;
        b0 = -1;
        e0 = true;
        f0 = new AtomicLong(System.currentTimeMillis());
        g0 = new i();
        h0 = true;
        i0 = true;
        j0 = true;
        k0 = true;
        l0 = true;
        m0 = false;
        n0 = false;
        o0 = new String[]{"klink_egdi", "appkey", "openudid", EffectConfiguration.KEY_SDK_VERSION, "package", EffectConfiguration.KEY_CHANNEL, "display_name", EffectConfiguration.KEY_APP_VERSION, "version_code", "timezone", "access", "os", "os_version", "os_api", "device_model", "device_brand", "device_manufacturer", "language", "resolution", "display_density", "density_dpi", "carrier", "mcc_mnc", "clientudid", "install_id", EffectConfiguration.KEY_DEVICE_ID, "sig_hash", EffectConfiguration.KEY_APP_ID, "push_sdk", "rom", "release_build", "update_version_code", "manifest_version_code", "app_version_minor", "cpu_abi", "app_track", "not_request_sender", "rom_version", EffectConfiguration.KEY_REGION, "tz_name", "tz_offset", "sim_region", "custom", "google_aid", EffectConfiguration.KEY_APP_LANGUAGE, "app_region", "device_category", "ab_sdk_version", "user_unique_id", "platform", "harmony_os_api", "harmony_os_version", "harmony_release_type", "cdid", "sys_region", "carrier_region", "timezone_offset", "timezone_name"};
        q0 = 2000;
        r0 = new Object();
        t0 = new AtomicLong();
        u0 = 0;
        v0 = 0;
        w0 = 0;
        x0 = 0;
        y0 = "";
        z0 = new ArrayList(2);
        B0 = null;
        C0 = false;
        G0 = new ConcurrentHashMap();
        H0 = new Bundle();
        Locale r4 = Locale.US;
        J0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", r4);
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", r4).setTimeZone(TimeZone.getTimeZone("UTC+8"));
        new SimpleDateFormat("yyyy-MM-dd", r4);
        SimpleDateFormat r1 = new SimpleDateFormat("yyyy-MM-dd", r4);
        r1.setTimeZone(TimeZone.getTimeZone("UTC+8"));
        K0 = r1;
        L0 = new Object();
        M0 = new ThreadLocal();
        N0 = false;
        O0 = false;
        Q0 = 0;
        R0 = -1;
        S0 = false;
    }

    public static gx3.j e() {
        String r1 = String.valueOf(g.c());
        String r2 = v();
        w();
        gx3.j r3 = new gx3.j(r1, r2);
        IBDAccountCallback r4 = T0;
        if (r4 == null) goto L10;
        Pair r5 = r4.getOdinUserInfo();
        if (((Long) r5.second).longValue() <= 0) goto L8;
        r3.c = String.valueOf(r5.second);
        r3.d = String.valueOf(r5.first);
    L11:
        return r3;
    L8:
        if (w0 != 0) goto L11;
        r3.c = String.valueOf(u0);
        r3.d = String.valueOf(v0);
        goto L11
    L10:
        r3.c = String.valueOf(t0.get());
        goto L11
    }

    public static String getCurrentSessionId() {
        return g0.getCurrentSessionId();
    }

    public static String n() {
        return g0.w();
    }

    public static int p() {
        return T.get();
    }

    public static boolean q() {
        f r1 = A0;
        if (r1 != null) goto L7;
        return true;
    L7:
        return r1.getEventV3Switch();
    }

    public static String r() {
        return g0.getInstallId();
    }

    public static m s() {
        return g0.h();
    }

    public static boolean t() {
        f r1 = A0;
        if (r1 != null) goto L7;
        return true;
    L7:
        return r1.getEncryptSwitch();
    }

    public static boolean u() {
        f r1 = A0;
        if (r1 != null) goto L7;
        return true;
    L7:
        return r1.getRecoverySwitch();
    }

    public static String v() {
        return g0.getServerDeviceId();
    }

    public static String w() {
        g0.D();
        return null;
    }

    public final void A() {
        if (n0 == false) goto L19;
        ex3.c.a r1 = new ex3.c.a();
        r1.a = String.valueOf(g.c());
        r1.b = g.j.getChannel(this.l);
        r1.j = "2.14.0";
        r1.k = com.bytedance.bdinstall.n.d(this.l);
        r1.l = !com.bytedance.applog.log.m.b();
        r1.i = false;
        b r2 = D0;
        if (r2 == null) goto L7;
        r1.d = r2.getAppName();
        r1.c = D0.getVersion();
        r1.e = D0.getUpdateVersionCode();
    L7:
        f r3 = A0;
        if (r3 == null) goto L10;
        r1.h = r3.getRecoverySwitch();
    L10:
        e r4 = e.a();
        ex3.d.a r5 = new ex3.d.a();
        r5.b = new ex3.c(r1);
        r5.c = this.t;
        r5.d = new g();
        m0 r6 = p0;
        if (r6 == null) goto L17;
        String[] r7 = r6.a;
        if (r7 == null) goto L17;
        if (r7.length <= 0) goto L17;
        String r8 = r7[0];
    L18:
        r5.e = r8;
        r5.a = this.l;
        r5.f = (ExecutorService) qw3.a.g.b(new Object[0]);
        r4.d(new ex3.d(r5));
        return;
    L17:
        r8 = null;
        goto L18
    L19:
        e.a().d(new ex3.d(new ex3.d.a()));
    }

    public final void G() {
        z r1 = this.r;
        if (r1 != null) goto L5;
        return;
    L5:
        h r2 = h.d(this.l);
        int r3 = 0;
        int r4 = this.y.getAndSet(0);
        int r5 = this.z.getAndSet(0);
        if (r1 != null) goto L8;
    L21:
        this.A.clear();
        return;
    L8:
        if (r1.a <= 0) goto L21;
        if (r4 > 0) goto L12;
        if (r5 > 0) goto L12;
    L14:
        if (this.p == true) goto L16;
        this.A.clear();
    L16:
        Iterator<h> r6 = this.A.iterator();
    L18:
        if (r6.hasNext() == false) goto L21;
        h r7 = r6.next();
        q r8 = new q();
        r8.b = "image";
        r8.c = "sample";
        r8.d = r7.a;
        r8.e = r7.b;
        r8.f = r7.c;
        r8.l = r7.d;
        r8.m = r1.a;
        r2.g(r8);
        r3 = r3 + 1;
        if (r3 < 5) goto L18;
    L12:
        q r9 = new q();
        r9.b = "image";
        r9.c = "stats";
        r9.e = r4;
        r9.f = r5;
        r9.l = r1.g;
        r9.m = r1.a;
        r2.g(r9);
        goto L14
    }

    public final void f() {
        z r1 = this.r;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.h == true) goto L16;
        long r2 = System.currentTimeMillis();
        z r3 = this.r;
        if (r3.j == false) goto L10;
        return;
    L10:
        if ((r2 - r3.g) < this.s) goto L17;
        G();
        this.r = null;
        w r4 = new w();
        r4.a = r3;
        j(r4);
        return;
    L17:
        return;
    }

    public final void J() {
        long r1 = System.currentTimeMillis();
        if ((r1 - this.B) <= 60000) goto L12;
        this.B = r1;
        LinkedList<u> r2 = this.h;
        monitor-enter(r2);
        this.h.notify();     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static boolean o() {
        return S0;
    }

    public AppLog(Context r8) {
        this.b = false;
        this.c = false;
        this.d = 1;
        this.f = false;
        this.g = new LinkedList();
        this.h = new LinkedList();
        this.i = null;
        this.k = 0;
        this.n = false;
        this.o = new HashSet();
        this.p = false;
        this.q = new AtomicBoolean();
        this.s = 30000;
        this.t = 60000;
        this.u = 21600000;
        this.v = 1;
        this.w = 0;
        this.x = null;
        this.y = new AtomicInteger();
        this.z = new AtomicInteger();
        this.A = new LinkedList();
        this.B = System.currentTimeMillis();
        this.C = 0;
        this.D = 0;
        this.E = false;
        this.F = new ConcurrentHashMap();
        this.G = new ConcurrentHashMap();
        this.H = new ConcurrentHashMap();
        this.I = new AtomicLong();
        this.J = new AtomicLong();
        Context r9 = r8.getApplicationContext();
        this.l = r9;
        this.e = new AppLogNetworkStatusMonitor(r9);
        this.m = null;
    }

    public static void B(JSONObject r4) {
        boolean r1 = pta.d.h();
        if (r1 == false) goto L6;
        String r3 = "Harmony";
    L18:
        r4.put("platform", r3);     // Catch: JSONException -> L9
    L11:
        if (r1 == true) goto L20;
        return;
    L20:
        r4.put("harmony_os_api", i84.u.a("hw_sc.build.os.apiversion"));     // Catch: Throwable -> L15
        r4.put("harmony_os_version", i84.u.a("hw_sc.build.platform.version"));     // Catch: Throwable -> L15
        r4.put("harmony_release_type", i84.u.a("hw_sc.build.os.releasetype"));     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        j.g("AppLog loadHarmonyInfo ", th);
        return;
    L9:
        e = move-exception;
        j.c("AppLog loadHarmonyInfo ", e);
        goto L11
    L6:
        r3 = "Android";
        goto L18
    }

    public static void D(long r1) {
        List<g> r2 = z0;
        if (r2 != null) goto L5;
        return;
    L5:
        monitor-enter(r2);
        Iterator r3 = ((ArrayList) r2).iterator();     // Catch: Throwable -> L12
    L8:
        if (r3.hasNext() == false) goto L10;
        ((g) r3.next()).a();     // Catch: Throwable -> L12
        goto L8
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void c(Context r7) {
        if (N0 == false) goto L5;
    L16:
        O0 = false;
        long r1 = System.currentTimeMillis();
        if ((r1 - Q0) >= 900000) goto L19;
        return;
    L19:
        if (NetworkUtils.isNetworkAvailable(r7) == false) goto L26;
        Q0 = r1;
        fta.a.b(r7, p0.d, P, Q);
        return;
    L26:
        return;
    L5:
        monitor-enter(AppLog.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (N0 == true) goto L11;
        O0 = true;     // Catch: Throwable -> L13
        monitor-exit(AppLog.class);     // Catch: Throwable -> L13
        return;
    L11:
        monitor-exit(AppLog.class);     // Catch: Throwable -> L13
        goto L16
    }

    public static boolean d(AppLog r13) {
        r13.getClass();
        Context r3 = r13.l;     // Catch: Exception -> L9
        boolean r4 = r13.b;     // Catch: Exception -> L9
        b r5 = new b();     // Catch: Exception -> L9
        boolean r6 = L;     // Catch: Exception -> L9
        boolean r7 = C0;     // Catch: Exception -> L9
        boolean r8 = P;     // Catch: Exception -> L9
        if (m0 == true) goto L6;
        boolean r9 = true;
    L7:
        f.a(r3, r4, r5, r6, r7, r8, r9);     // Catch: Exception -> L9
    L12:
        r13.f = z(r13.m, r13.l);     // Catch: Exception -> L33
        r13.r = h.d(r13.l).f(0);     // Catch: Exception -> L33
        r13.A();     // Catch: Exception -> L33
        r13.C(r13.r);     // Catch: Exception -> L33
        if (r13.r == null) goto L42;
        j.b("AppLog start with last session " + r13.r.b, null);     // Catch: Exception -> L33
        t r1 = new t();     // Catch: Exception -> L33
        r1.a = r13.r.a;     // Catch: Exception -> L33
        r13.j(r1);     // Catch: Exception -> L33
    L42:
        Bundle r2 = new Bundle();     // Catch: Throwable -> L30
        Bundle r10 = H0;     // Catch: Throwable -> L30
        monitor-enter(r10);     // Catch: Throwable -> L30
        r2.putAll(r10);     // Catch: Throwable -> L27
        monitor-exit(r10);     // Catch: Throwable -> L27
    L20:
        if (r2.size() <= 0) goto L31;
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L30
        Iterator<String> r12 = r2.keySet().iterator();     // Catch: Throwable -> L30
    L23:
        if (r12.hasNext() == false) goto L25;
        String r14 = r12.next();     // Catch: Throwable -> L30
        r11.put(r14, r2.get(r14));     // Catch: Throwable -> L30
        goto L23
    L25:
        r13.m.put("custom", r11);     // Catch: Throwable -> L30
    L31:
        r13.i = new x(r13.l, new JSONObject(r13.m, f.a), r13.h, r13.q, z0, r13.r, r13.F, r13.G);     // Catch: Exception -> L33
        x r15 = r13.i;     // Catch: Exception -> L33
        long r16 = r13.t;     // Catch: Exception -> L33
        r15.G = r16;     // Catch: Exception -> L33
        r15.F.set(r16);     // Catch: Exception -> L33
        r13.i.H = r13.v;     // Catch: Exception -> L33
        ThreadMethodProxy.start(r13.i);     // Catch: Exception -> L33
        return true;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        e.a().b(StatsCountKeys.JSON_ERROR_COUNT, 1);     // Catch: Exception -> L33
        goto L31
    L6:
        r9 = false;
    L33:
        e = move-exception;
        if ((e instanceof SQLiteException) == false) goto L37;
        e.a().b(StatsCountKeys.DB_ERROR_COUNT, 1);
    L37:
        j.c("failed to start LogReaper", e);
        return false;
    L9:
        e = move-exception;
        if (Logger.debug() == false) goto L12;
        throw e;     // Catch: Exception -> L33
    }

    public static String m(long r2) {
        return J0.format(new Date(r2));
    }

    public final void C(z r13) {
        this.A.clear();     // Catch: Exception -> L42
        int r3 = 0;
        SharedPreferences r1 = this.l.getSharedPreferences(kta.b.a, 0);     // Catch: Exception -> L42
        long r4 = r1.getLong("session_interval", 30000);     // Catch: Exception -> L42
        if (r4 >= 15000) goto L6;
    L8:
        this.t = r1.getLong("batch_event_interval", 60000);     // Catch: Exception -> L42
        long r5 = R0;     // Catch: Exception -> L42
        if (g(r5) == true) goto L11;
    L13:
        this.v = r1.getInt("send_launch_timely", 1);     // Catch: Exception -> L42
        this.u = r1.getLong("fetch_interval", 21600000);     // Catch: Exception -> L42
        this.w = r1.getInt("http_monitor_port", 0);     // Catch: Exception -> L42
        h.w = r1.getBoolean("device_register_throttle", false);     // Catch: Exception -> L42
        if (r13 != null) goto L16;
        return;
    L16:
        String r2 = r1.getString("stats_value", null);     // Catch: Exception -> L42
        if (StringUtils.isEmpty(r2) == false) goto L19;
        return;
    L19:
        JSONObject r6 = new JSONObject(r2);     // Catch: Exception -> L42
        String r7 = r6.optString("session_id", null);     // Catch: Exception -> L42
        if (r7 != null) goto L22;
        return;
    L22:
        if (r7.equals(r13.b) == false) goto L49;
        int r14 = r6.optInt("cnt_success", 0);     // Catch: Exception -> L42
        int r8 = r6.optInt("cnt_failure", 0);     // Catch: Exception -> L42
        if (r14 <= 0) goto L27;
        this.y.addAndGet(r14);     // Catch: Exception -> L42
    L27:
        if (r8 <= 0) goto L30;
        this.z.addAndGet(r8);     // Catch: Exception -> L42
    L30:
        if (r6.isNull("samples") == false) goto L32;
        return;
    L32:
        JSONArray r15 = JSONObjectProtectorUtils.getJSONArray(r6, "samples");     // Catch: Exception -> L42
        int r9 = r15.length();     // Catch: Exception -> L42
        if (r9 <= 5) goto L35;
        r9 = 5;
    L35:
        if (r3 >= r9) goto L51;
        JSONObject r10 = JSONArrayProtectorUtils.getJSONObject(r15, r3);     // Catch: Exception -> L42
        String r11 = r10.optString("url", null);     // Catch: Exception -> L42
        int r12 = JSONObjectProtectorUtils.getInt(r10, "networktype");     // Catch: Exception -> L42
        long r16 = JSONObjectProtectorUtils.getLong(r10, "time");     // Catch: Exception -> L42
        long r17 = JSONObjectProtectorUtils.getLong(r10, "timestamp");     // Catch: Exception -> L42
        if (StringUtils.isEmpty(r11) == true) goto L40;
        h r18 = new h(r11, r12, r16, r17);     // Catch: Exception -> L42
        this.A.add(r18);     // Catch: Exception -> L42
    L40:
        r3 = r3 + 1;
        goto L35
    L51:
        return;
    L49:
        return;
    L11:
        if (this.t == r5) goto L13;
        this.t = r5;     // Catch: Exception -> L42
        goto L13
    L6:
        if (r4 > 300000) goto L8;
        this.s = r4;     // Catch: Exception -> L42
    }

    public final void I(c r22) {
        if (W == false) goto L16;
        if (X == true) goto L16;
        ActionQueueType r1 = ActionQueueType.PAGE_START;
        ActionQueueType r3 = r22.a;
        if (r1 != r3) goto L9;
        return;
    L9:
        if (ActionQueueType.PAGE_END != r3) goto L11;
        return;
    L11:
        if (ActionQueueType.EVENT != r3) goto L13;
        return;
    L13:
        if (ActionQueueType.SAVE_MISC_LOG != r3) goto L16;
        return;
    L16:
        if (this.f == true) goto L18;
        return;
    L18:
        BlockHelper.tryBlock();
        char r4 = 0;
        boolean r5 = false;
        int r6 = 0;
        char r7 = 0;
        r4 = 0;
        r4 = 0;
        r4 = 0;
        r4 = 0;
        r4 = 0;
        r4 = 0;
        r4 = 0;
        r4 = 0;
        r4 = 0;
        boolean r8 = true;
        jta.n r9 = null;
        switch(b.a[r22.a.ordinal()]) {
            case 1: goto L248;
            case 2: goto L219;
            case 3: goto L213;
            case 4: goto L205;
            case 5: goto L199;
            case 6: goto L405;
            case 7: goto L192;
            case 8: goto L188;
            case 9: goto L405;
            case 10: goto L185;
            case 11: goto L164;
            case 12: goto L140;
            case 13: goto L125;
            case 14: goto L94;
            case 15: goto L57;
            case 16: goto L41;
            case 17: goto L39;
            case 18: goto L29;
            case 19: goto L22;
            default: goto L405;
        };
    L29:
        String r2 = (String) r22.b;
        if (this.i != null) goto L33;
        return;
    L33:
        if (TextUtils.isEmpty(r2) == false) goto L35;
        this.m.remove("user_unique_id");     // Catch: Exception -> L332
    L36:
        this.i.B(new JSONObject(this.m, f.a));     // Catch: Exception -> L332
        return;
    L35:
        this.m.put("user_unique_id", r2);     // Catch: Exception -> L332
        goto L36
    L41:
        Object r10 = r22.b;
        if ((r10 instanceof Pair) == false) goto L44;
        Pair r11 = (Pair) r10;
        r9 = (jta.n) r11.first;
        long r12 = ((Long) r11.second).longValue();
    L46:
        if (r22.c > 0) goto L49;
        r8 = false;
    L49:
        fta.a.b(this.l, p0.d, r8, false);
        g r13 = g.a;
        if (g.b == false) goto L54;
        if (r13 == null) goto L54;
        g.j.m(r8, r12, r9);
    L55:
        N(this.l, r8);
        return;
    L54:
        g.j.c(r8);
        goto L55
    L44:
        r12 = 0;
        goto L46
    L94:
        Object r14 = r22.b;
        if ((r14 instanceof JSONObject) == false) goto L372;
        JSONObject r15 = (JSONObject) r14;
        String r16 = r15.optString(EffectConfiguration.KEY_APP_LANGUAGE, null);
        String r17 = r15.optString("app_region", null);
        if (StringUtils.isEmpty(r16) == false) goto L337;
    L107:
        boolean r18 = false;
    L108:
        if (r18 == false) goto L110;
    L122:
        r7 = 1;
    L123:
        if (r7 == 0) goto L373;
        g.j.g();
        j.b("AppLog updateDeviceInfo call device_register", null);
        return;
    L373:
        return;
    L110:
        if (StringUtils.isEmpty(r17) == false) goto L339;
    L120:
        boolean r19 = false;
    L121:
        if (r19 == false) goto L123;
    L339:
        if (r17.equals(this.m.optString("app_region", null)) == true) goto L120;
        this.m.put("app_region", r17);     // Catch: Throwable -> L119
        if (this.i == null) goto L117;
        this.i.B(new JSONObject(this.m, f.a));     // Catch: Throwable -> L119
    L117:
        this.l.getSharedPreferences(kta.b.a, 0).edit().putString("app_region", r17).commit();     // Catch: Throwable -> L119
        r19 = true;
        goto L121
    L337:
        if (r16.equals(this.m.optString(EffectConfiguration.KEY_APP_LANGUAGE, null)) == true) goto L107;
        this.m.put(EffectConfiguration.KEY_APP_LANGUAGE, r16);     // Catch: Throwable -> L106
        if (this.i == null) goto L104;
        this.i.B(new JSONObject(this.m, f.a));     // Catch: Throwable -> L106
    L104:
        this.l.getSharedPreferences(kta.b.a, 0).edit().putString(EffectConfiguration.KEY_APP_LANGUAGE, r16).commit();     // Catch: Throwable -> L106
        r18 = true;
        goto L108
    L372:
        return;
    L125:
        Object r20 = r22.b;
        if ((r20 instanceof String) == false) goto L375;
        String r21 = (String) r20;
        if (StringUtils.isEmpty(r21) == false) goto L131;
        return;
    L131:
        if (this.i != null) goto L133;
        return;
    L133:
        if (r21.equals(this.m.optString("google_aid", null)) == false) goto L135;
        return;
    L135:
        if (P == true) goto L139;
        this.m.put("google_aid", r21);
        if (this.i == null) goto L139;
        this.i.B(new JSONObject(this.m, f.a));
    L139:
        this.l.getSharedPreferences(kta.b.a, 0).edit().putString("google_aid", r21).commit();
        return;
    L375:
        return;
    L140:
        Object r23 = r22.b;
        if ((r23 instanceof JSONObject) == false) goto L379;
        JSONObject r24 = (JSONObject) r23;
        Objects.toString(r24);
        if (r24 == null) goto L409;
        boolean r25 = g0.y(this.m.optString(EffectConfiguration.KEY_DEVICE_ID, null));
        String r26 = r24.optString(EffectConfiguration.KEY_DEVICE_ID, null);
        String r27 = r24.optString("install_id", null);
        if (StringUtils.isEmpty(r26) == true) goto L152;
        this.m.put(EffectConfiguration.KEY_DEVICE_ID, r26);     // Catch: JSONException -> L149
    L149:
        e = move-exception;
        e.printStackTrace();
    L152:
        if (StringUtils.isEmpty(r27) == true) goto L158;
        this.m.put("install_id", r27);     // Catch: JSONException -> L155
    L155:
        e = move-exception;
        e.printStackTrace();
    L158:
        if (this.i != null) goto L355;
    L163:
        k();
        L(true, true, r25);
        return;
    L355:
        this.i.B(new JSONObject(this.m, f.a));     // Catch: JSONException -> L161
    L161:
        e = move-exception;
        e.printStackTrace();
        goto L163
    L409:
        return;
    L379:
        return;
    L164:
        Object r28 = r22.b;
        if ((r28 instanceof Bundle) == false) goto L381;
        Bundle r29 = (Bundle) r28;
        if (r29 != null) goto L169;
        return;
    L169:
        if (r29.size() > 0) goto L172;
        return;
    L172:
        if (this.i == null) goto L383;
        JSONObject r30 = this.m.optJSONObject("custom");     // Catch: Exception -> L332
        if (r30 != null) goto L176;
        r30 = new JSONObject();     // Catch: Exception -> L332
    L176:
        Iterator<String> r31 = r29.keySet().iterator();     // Catch: Exception -> L332
    L178:
        if (r31.hasNext() == false) goto L180;
        String r32 = r31.next();     // Catch: Exception -> L332
        r30.put(r32, r29.get(r32));     // Catch: Exception -> L332
        goto L178
    L180:
        this.m.put("custom", r30);     // Catch: Exception -> L332
        if (this.i == null) goto L183;
        this.i.B(new JSONObject(this.m, f.a));     // Catch: Exception -> L332
    L183:
        k();     // Catch: Exception -> L332
        return;
    L383:
        return;
    L381:
        return;
    L185:
        long r33 = r22.c;
        if (r33 <= 0) goto L384;
        SharedPreferences.Editor r34 = this.l.getSharedPreferences(kta.b.a, 0).edit();
        r34.putLong("dns_report_time", r33);
        r34.commit();
        return;
    L384:
        return;
    L188:
        Object r35 = r22.b;
        if ((r35 instanceof String) == false) goto L386;
        g.j.j(this.l, (String) r35);
        return;
    L386:
        return;
    L199:
        Object r36 = r22.b;
        if ((r36 instanceof h) == false) goto L390;
        h r37 = (h) r36;
        if (this.A.size() < 5) goto L204;
        this.A.removeFirst();
    L204:
        this.A.add(r37);
        return;
    L390:
        return;
    L205:
        long r38 = r22.c;
        z r39 = this.r;
        if (r39 != null) goto L208;
        String r40 = "";
    L209:
        gta.e r41 = gta.e.c(this.l);
        r41.getClass();
        k0.d().b(new gta.f(r41, r38, r40));
        Object r42 = r22.b;
        if ((r42 instanceof s) == false) goto L212;
        y((s) r42, r22.c);
    L212:
        J();
        return;
    L208:
        r40 = r39.b;
        goto L209
    L213:
        K(r22.c, false);
        long r43 = r22.c;
        z r44 = this.r;
        if (r44 != null) goto L216;
        String r45 = "";
    L217:
        gta.e r46 = gta.e.c(this.l);
        r46.getClass();
        k0.d().b(new gta.d(r46, r43, r45));
        J();
        return;
    L216:
        r45 = r44.b;
        goto L217
    L248:
        Object r47 = r22.b;
        if ((r47 instanceof q) == false) goto L402;
        q r48 = (q) r47;
        if (R == null) goto L253;
        e57.c r49 = R;
        String r110 = r48.b;
        String r111 = r48.c;
        String r112 = r48.d;
        long r113 = r48.e;
        long r50 = r48.f;
        boolean r51 = r48.o;
        String r114 = r48.n;
        r49.getClass();
        PitayaProxy.a(r110, r111, r112, r113, r50, r51, r114);
    L253:
        K(r48.l, true);
        if (this.r != null) goto L257;
        a0.a(1, 4, null);
        return;
    L257:
        if (AppLogNewUtils.EVENT_V3_CATEGORY.equalsIgnoreCase(r48.b) == false) goto L259;
        r48.q = this.I.getAndIncrement();
    L260:
        r48.m = this.r.a;
        long r52 = System.currentTimeMillis();     // Catch: Throwable -> L307
        if (r48.p == true) goto L308;
        if ((r52 - this.K) < 900000) goto L308;
        if (AppLogNewUtils.EVENT_V3_CATEGORY.equalsIgnoreCase(r48.b) == false) goto L308;
        ConcurrentHashMap<String, String> r53 = this.H;     // Catch: Throwable -> L307
        if (r53 == null) goto L308;
        if (r53.size() <= 0) goto L308;
        if (StringUtils.isEmpty(r48.c) == true) goto L308;
        if (this.H.containsKey(r48.c) == false) goto L308;
        if (StringUtils.isEmpty(r48.n) == true) goto L308;
        JSONObject r54 = new JSONObject(r48.n);     // Catch: Throwable -> L307
        if (r54.optInt(AppLogNewUtils.EVENT_SIGN, 0) != 1) goto L308;
        e.a().b(StatsCountKeys.REALTIME_EVENT_COUNT, 1);     // Catch: Throwable -> L307
        if (com.bytedance.applog.log.m.b() == true) goto L291;
        long r55 = r48.a;     // Catch: Throwable -> L307
        if (r55 > 0) goto L288;
        r55 = 0;
    L288:
        if (r55 <= 0) goto L291;
        com.bytedance.applog.log.m.c("event_realtime_eid", new ita.f(r55));     // Catch: Throwable -> L307
    L291:
        JSONObject r56 = new JSONObject();     // Catch: Throwable -> L307
        JSONObject r57 = new JSONObject();     // Catch: Throwable -> L307
        if (r54.has("nt") == false) goto L294;
        r57.put("nt", r54.optInt("nt"));     // Catch: Throwable -> L307
    L294:
        long r115 = r48.h;     // Catch: Throwable -> L307
        if (r115 <= 0) goto L297;
        r57.put("user_id", r115);     // Catch: Throwable -> L307
        r57.put("user_is_login", r48.j);     // Catch: Throwable -> L307
        r57.put("user_type", r48.g);     // Catch: Throwable -> L307
        r57.put("user_is_auth", r48.k);     // Catch: Throwable -> L307
    L297:
        r54.remove("nt");     // Catch: Throwable -> L307
        r54.remove(AppLogNewUtils.EVENT_SIGN);     // Catch: Throwable -> L307
        r57.put("event", r48.c);     // Catch: Throwable -> L307
        r57.put("params", r54);     // Catch: Throwable -> L307
        r57.put("session_id", Long.valueOf(r48.m));     // Catch: Throwable -> L307
        r57.put("datetime", m(r48.l));     // Catch: Throwable -> L307
        r57.put("local_time_ms", r48.l);     // Catch: Throwable -> L307
        JSONArray r58 = new JSONArray();     // Catch: Throwable -> L307
        r58.put(r57);     // Catch: Throwable -> L307
        r56.put(AppLogNewUtils.EVENT_V3_CATEGORY, r58);     // Catch: Throwable -> L307
        Object r59 = this.x;     // Catch: Throwable -> L307
        if (r59 == null) goto L300;
        r56.put("time_sync", r59);     // Catch: Throwable -> L307
    L300:
        r56.put("magic_tag", "ss_app_log");     // Catch: Throwable -> L307
        Context r60 = this.l;     // Catch: Throwable -> L307
        JSONObject r61 = this.m;     // Catch: Throwable -> L307
        String[] r62 = f.a;     // Catch: Throwable -> L307
        String r63 = f.a(kta.n.c(r60));     // Catch: Throwable -> L307
        if (TextUtils.isEmpty(r63) == false) goto L345;
    L305:
        r61.optString(EffectConfiguration.KEY_DEVICE_ID);     // Catch: Throwable -> L307
        r56.put("header", r61);     // Catch: Throwable -> L307
        r56.put("_gen_time", System.currentTimeMillis());     // Catch: Throwable -> L307
        new a(this, r56.toString(), r48).start();     // Catch: Throwable -> L307
        r4 = 1;
        goto L308
    L345:
        JSONObject r64 = new JSONObject(r61, f.a);     // Catch: JSONException -> L331 Throwable -> L307
        r64.put("oaid", r63);     // Catch: JSONException -> L330 Throwable -> L307
    L304:
        r61 = r64;
    L308:
        if (r4 != 0) goto L414;
        long r65 = h.d(this.l).g(r48);
        if (r65 <= 0) goto L327;
        String r66 = r48.b;
        if (AppLogNewUtils.EVENT_V3_CATEGORY.equalsIgnoreCase(r66) == false) goto L316;
        r66 = "EVENT_V3";
    L316:
        if (com.bytedance.applog.log.m.b() == true) goto L326;
        long r67 = r48.a;
        if (r67 > 0) goto L323;
        r67 = 0;
    L323:
        if (r67 <= 0) goto L326;
        com.bytedance.applog.log.m.c("event_save_db", new ita.a(r66, r67, r48));
    L326:
        J();
    L327:
        if (r65 >= 0) goto L404;
        e.a().b(StatsCountKeys.DB_ERROR_COUNT, 1);
        return;
    L404:
        return;
    L414:
        return;
    L259:
        r48.q = this.J.getAndIncrement();
        goto L260
    L402:
        return;
    L405:
        return;
    L22:
        if (this.i != null) goto L24;
        return;
    L24:
        if (ThreadMethodProxy.isAlive(this.i) == true) goto L365;
        ThreadMethodProxy.start(this.i);     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        j.c("AppLog delay start LogReaper", th);
        return;
    L365:
        return;
    L39:
        if (this.r == null) goto L368;
        w r68 = new w();
        r68.a = this.r;
        r68.e = true;
        j(r68);
        return;
    L368:
        return;
    L57:
        if (r22.c <= 0) goto L59;
        boolean r69 = true;
    L60:
        g r70 = g.a;
        if (g.b == false) goto L65;
        if (r70 == null) goto L65;
        g.j.k(r69);
    L66:
        if (r69 == false) goto L68;
        this.m.remove("openudid");
        this.m.remove("google_aid");
        this.m.remove(EffectConfiguration.KEY_DEVICE_ID);
        this.m.remove("install_id");
    L68:
        N(this.l, r69);
        h r71 = h.d(this.l);
        monitor-enter(r71);
        SQLiteDatabase r72 = r71.a;     // Catch: Throwable -> L91
        if (r72 != null) goto L73;
    L85:
        j.g("AppLogdb not establish and open", null);     // Catch: Throwable -> L91
        monitor-exit(r71);
    L87:
        z r73 = this.r;
        if (r73 == null) goto L90;
        r8 = r73.h;
    L90:
        this.r = null;
        K(System.currentTimeMillis(), r8);
        return;
    L73:
        if (r72.isOpen() == false) goto L85;
        String[] r74 = h.f;     // Catch: Throwable -> L91
        int r75 = r74.length;     // Catch: Throwable -> L91
    L76:
        if (r6 >= r75) goto L83;
        String r76 = r74[r6];     // Catch: Throwable -> L91
        r71.a.delete(r76, null, null);     // Catch: Throwable -> L80
    L82:
        r6 = r6 + 1;
    L80:
        th = move-exception;
        e.a().b(StatsCountKeys.DB_ERROR_COUNT, 1);     // Catch: Throwable -> L91
        j.g("AppLogdelete table failed, " + r76, th);     // Catch: Throwable -> L91
        goto L82
    L83:
        monitor-exit(r71);
    L91:
        th = move-exception;
        throw th;
    L65:
        g.j.c(r69);
        goto L66
    L59:
        r69 = false;
        goto L60
    L192:
        if ((r22.b instanceof JSONObject) == true) goto L335;
        return;
    L335:
        r5 = Boolean.valueOf(r22.d).booleanValue();     // Catch: Exception -> L196
    L198:
        x((JSONObject) r22.b, r5);
        return;
    L196:
        e = move-exception;
        e.printStackTrace();
        goto L198
    L219:
        if (StringUtils.isEmpty(r22.d) == true) goto L394;
        Object r77 = r22.b;
        if ((r77 instanceof JSONObject) == false) goto L395;
        JSONObject r78 = (JSONObject) r77;
        String r79 = r22.d;
        z r80 = this.r;
        if (r80 == null) goto L225;
        long r116 = r80.a;
    L227:
        if (this.f == true) goto L229;
        return;
    L229:
        if (r116 > 0) goto L231;
        return;
    L231:
        if (StringUtils.isEmpty(r79) == true) goto L398;
        if (r78 == null) goto L399;
        String r117 = r78.toString();
        long r81 = h.d(this.l).j(r116, r79, r117, r78.optLong("event_id"));
        if (r117 == null) goto L239;
        if (r117.length() <= 50000) goto L239;
        a0.a(5, 0, new Object[]{"misc", r79, "", Integer.valueOf(r117.length())});
    L239:
        if (r81 >= 0) goto L242;
        e.a().b(StatsCountKeys.DB_ERROR_COUNT, 1);
        return;
    L242:
        if (com.bytedance.applog.log.m.b() == true) goto L412;
        long r82 = r78.optLong("event_id", 0);
        if (r82 <= 0) goto L413;
        com.bytedance.applog.log.m.c("event_save_db", new ita.b(r78, r82, r79));
        return;
    L413:
        return;
    L412:
        return;
    L399:
        return;
    L398:
        return;
    L225:
        r116 = 0;
        goto L227
    L395:
        return;
    L394:
        return;
    }

    public final void i(c r5) {
        LinkedList<c> r1 = this.g;
        monitor-enter(r1);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.g.size() < q0) goto L14;
        c r2 = this.g.poll();     // Catch: Throwable -> L17
        if (r2 == null) goto L14;
        int r3 = b.a[r2.a.ordinal()];     // Catch: Throwable -> L17
        if (r3 != 1) goto L11;
    L13:
        e.a().b(StatsCountKeys.CACHE_DROP_EVENT_COUNT, 1);     // Catch: Throwable -> L17
        goto L14
    L11:
        if (r3 == 2) goto L13;
    L14:
        this.g.add(r5);     // Catch: Throwable -> L17
        this.g.notify();     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
    }

    public final void j(u r5) {
        this.B = System.currentTimeMillis();
        LinkedList<u> r1 = this.h;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.h.size() < q0) goto L9;
        u r2 = this.h.poll();     // Catch: Throwable -> L12
        if (r2 == null) goto L9;
        j.c("log queue poll out: " + r2, null);     // Catch: Throwable -> L12
    L9:
        this.h.add(r5);     // Catch: Throwable -> L12
        this.h.notify();     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
    }

    public AppLog(Context r11, int r12) {
        boolean r13 = false;
        this.b = false;
        this.c = false;
        this.d = 1;
        this.f = false;
        this.g = new LinkedList();
        this.h = new LinkedList();
        this.i = null;
        this.k = 0;
        this.n = false;
        HashSet<Integer> r4 = new HashSet();
        this.o = r4;
        this.p = false;
        this.q = new AtomicBoolean();
        this.s = 30000;
        this.t = 60000;
        this.u = 21600000;
        this.v = 1;
        this.w = 0;
        this.x = null;
        this.y = new AtomicInteger();
        this.z = new AtomicInteger();
        this.A = new LinkedList();
        this.B = System.currentTimeMillis();
        this.C = 0;
        this.D = 0;
        this.E = false;
        this.F = new ConcurrentHashMap();
        this.G = new ConcurrentHashMap();
        this.H = new ConcurrentHashMap();
        this.I = new AtomicLong();
        this.J = new AtomicLong();
        g.j.A();
        Context r14 = r11.getApplicationContext();
        this.l = r14;
        g.c = r14.getApplicationContext();
        this.m = new JSONObject();
        b r5 = D0;     // Catch: Exception -> L39
        if (r5 == null) goto L6;
        this.d = r5.getVersionCode();     // Catch: Exception -> L39
    L6:
        long r6 = System.currentTimeMillis();     // Catch: Exception -> L39
        SharedPreferences r15 = r14.getSharedPreferences(kta.b.a, 0);     // Catch: Exception -> L39
        int r7 = r15.getInt("app_log_last_config_version", 0);     // Catch: Exception -> L39
        this.a = r7;     // Catch: Exception -> L39
        if (r7 != this.d) goto L48;
        long r8 = r15.getLong("app_log_last_config_time", 0);     // Catch: Exception -> L39
        if (r8 > r6) goto L12;
        r6 = r8;
    L12:
        this.C = r6;     // Catch: Exception -> L39
    L48:
        String r9 = r15.getString("allow_push_list", null);     // Catch: Exception -> L23
        if (r9 == null) goto L25;
        Object r10 = r0;     // Catch: Exception -> L23
        monitor-enter(r10);     // Catch: Exception -> L23
        H(r4, new JSONArray(r9));     // Catch: Throwable -> L20
        monitor-exit(r10);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;     // Catch: Exception -> L23
    L25:
        this.p = r15.getBoolean("allow_old_image_sample", false);     // Catch: Exception -> L39
        String r16 = r15.getString("real_time_events", null);     // Catch: Throwable -> L36
        if (StringUtils.isEmpty(r16) == true) goto L40;
        JSONArray r17 = new JSONArray(r16);     // Catch: Throwable -> L36
        if (r17.length() <= 0) goto L40;
        int r18 = r17.length();     // Catch: Throwable -> L36
        int r19 = 0;
    L31:
        if (r19 >= r18) goto L40;
        String r20 = JSONArrayProtectorUtils.getString(r17, r19);     // Catch: Throwable -> L36
        if (StringUtils.isEmpty(r20) == true) goto L35;
        this.H.put(r20, "timely");     // Catch: Throwable -> L36
    L35:
        r19 = r19 + 1;
    L36:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L39
    L23:
        e = move-exception;
        j.c("AppLog load allow_push_list exception: ", e);     // Catch: Exception -> L39
    L40:
        this.I.set(0);
        this.J.set(0);
        if (this.l.getSharedPreferences(kta.b.a, 0).getInt("forbid_report_phone_detail_info", 0) <= 0) goto L43;
        r13 = true;
    L43:
        this.b = r13;
        if (p() <= 0) goto L46;
        U = gx3.d.c(this.l, null);
    L46:
        this.f = true;
        ThreadMethodProxy.start(new d(this));
        this.e = new AppLogNetworkStatusMonitor(this.l);
        com.bytedance.applog.log.m.e(String.valueOf(g.c()));
    }

    public static void H(HashSet r3, JSONArray r4) throws JSONException {
        if (r3 == null) goto L9;
        r3.clear();
        int r1 = r4.length();
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L13;
        int r5 = JSONArrayProtectorUtils.getInt(r4, r2);
        if (r5 <= 0) goto L8;
        r3.add(Integer.valueOf(r5));
    L8:
        r2 = r2 + 1;
        goto L4
    L13:
        return;
    }

    public static boolean b(AppLog r24, String r25) {
        r24.getClass();
        j.b("AppLog app_log_config: " + r25, null);     // Catch: Throwable -> L32
        byte[] r1 = r25.getBytes(EffectRequest.DEFAULT_PARAMS_ENCODING);     // Catch: Throwable -> L32
        String[] r2 = p0.c;     // Catch: Throwable -> L32
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.length == 0) goto L49;
        int r13 = r2.length;     // Catch: Throwable -> L32
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L51;
        String r6 = d0.e(c0.b(r2[r14], true), d0.c);     // Catch: Throwable -> L32
        byte[] r17 = (byte[]) r1.clone();     // Catch: Throwable -> L32
        ConcurrentHashMap<String, String> r10 = G0;     // Catch: Throwable -> L32
        e.a().b(StatsCountKeys.REPORT_REQUEST_COUNT, 1);     // Catch: Throwable -> L32
        if (r24.l != null) goto L12;
    L16:
        String r5 = c0.e(s(), r6, r1, true, "application/octet-stream;tt-data=b", r10, false, true);     // Catch: Throwable -> L32
    L17:
        if (r5 != null) goto L19;
    L30:
        e.a().b(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT, 1);     // Catch: Throwable -> L32
        e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);     // Catch: Throwable -> L32
        r14 = r14 + 1;
        goto L8
    L19:
        if (r5.length() == 0) goto L30;
        JSONObject r3 = new JSONObject(r5);     // Catch: Throwable -> L32
        if ("ss_app_log".equals(r3.optString("magic_tag")) == true) goto L24;
    L26:
        boolean r4 = false;
    L27:
        if (r4 == true) goto L50;
        e.a().b(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT, 1);     // Catch: Throwable -> L32
    L50:
        return r4;
    L24:
        if ("success".equals(r3.optString("message")) == false) goto L26;
        r4 = true;
        goto L27
    L12:
        if (t() == false) goto L16;
        r5 = c0.h(s(), r6, r17, r24.l, false, null, r10, false, true);     // Catch: RuntimeException -> L15 Throwable -> L32
    L15:
        e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);     // Catch: Throwable -> L32
        r5 = c0.e(s(), r6, r1, true, "application/octet-stream;tt-data=b", r10, false, true);     // Catch: Throwable -> L32
        goto L17
    L51:
        return false;
    L49:
        return false;
    L32:
        th = move-exception;
        e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);
        if ((th instanceof CommonHttpException) == false) goto L40;
        int r7 = th.getResponseCode();
        if (r7 < 500) goto L40;
        if (r7 >= 600) goto L40;
        r24.K = System.currentTimeMillis();
    L40:
        j.c("AppLog updateConfig exception: ", th);
        return false;
    }

    public static void h(Context r5, String r6) {
        g r1 = g.a;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (TextUtils.equals(r6, "local_test") == true) goto L7;
        return;
    L7:
        monitor-enter(k.class);     // Catch: Exception -> L18
    L15:
        th = move-exception;
        throw th;     // Catch: Exception -> L18
    L9:
        if (ota.b.a(k.class) != null) goto L13;
        k r7 = (k) g.a().getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r5});     // Catch: Throwable -> L15
        ConcurrentHashMap r2 = ota.b.a;     // Catch: Throwable -> L15
        if (r2.containsKey(k.class) == true) goto L13;
        r2.put(k.class, r7);     // Catch: Throwable -> L15
    L13:
        monitor-exit(k.class);     // Catch: Throwable -> L15
    }

    public static String[] l(JSONObject r8, boolean r9) {
        String[] r2 = null;
        if (r9 == true) goto L32;
        boolean r10 = false;
    L23:
        if (r10 == true) goto L25;
    L31:
        return r2;
    L25:
        if (t() == false) goto L31;
        r2 = nta.d.c();     // Catch: JSONException -> L20
        if (nta.d.d(r2) == false) goto L31;
        r8.put("key", r2[0]);     // Catch: JSONException -> L20
        r8.put("iv", r2[1]);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        j.c("AppLog fillKeyIvForEncryptResp", e);
        goto L31
    L32:
        if (S0 == false) goto L7;
        r8.put("uid_enable", 1);     // Catch: JSONException -> L20
        r10 = true;
    L9:
        if (p() <= 0) goto L23;
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L20
        r4.put("capability", p());     // Catch: JSONException -> L20
        c r5 = U;     // Catch: JSONException -> L20
        if (r5 != null) goto L13;
    L16:
        JSONObject r6 = r8.optJSONObject("options");     // Catch: JSONException -> L20
        if (r6 != null) goto L19;
        r6 = new JSONObject();     // Catch: JSONException -> L20
    L19:
        r6.put("event_sampling", r4);     // Catch: JSONException -> L20
        r8.put("options", r6);     // Catch: JSONException -> L20
        goto L23
    L13:
        if (r5.b != p()) goto L15;
        r4.put(EffectConfiguration.KEY_VERSION, r5.a);     // Catch: JSONException -> L20
    L15:
        r4.put("config_ids", r5.d);     // Catch: JSONException -> L20
        goto L16
    L7:
        r10 = false;
        goto L9
    }

    public static boolean z(JSONObject r2, Context r3) {
        JSONArray r1 = new JSONArray();     // Catch: Exception -> L23
        if (h0 == false) goto L6;
        r1.put(1);     // Catch: Exception -> L23
    L6:
        if (i0 == false) goto L9;
        r1.put(2);     // Catch: Exception -> L23
    L9:
        if (j0 == false) goto L12;
        r1.put(7);     // Catch: Exception -> L23
    L12:
        if (k0 == false) goto L15;
        r1.put(8);     // Catch: Exception -> L23
    L15:
        if (l0 == false) goto L17;
        r1.put(9);     // Catch: Exception -> L23
    L17:
        r2.put("push_sdk", r1);     // Catch: Exception -> L23
        w();     // Catch: Exception -> L23
        if (TextUtils.isEmpty(null) == true) goto L20;
        r2.put("user_unique_id", null);     // Catch: Exception -> L23
    L20:
        B(r2);     // Catch: Exception -> L23
    L21:
        boolean r4 = P;
        return g.j.f(r3, r2, r4);
    }

    public final void K(long r13, boolean r15) {
        h r1 = h.d(this.l);
        z r2 = this.r;
        if (r2 != null) goto L5;
    L13:
        boolean r4 = true;
    L14:
        if (r4 == true) goto L18;
        if (r15 == true) goto L63;
        r2.j = true;
        r2.g = r13;
        return;
    L63:
        return;
    L18:
        G();
        z r3 = this.r;
        z r5 = new z();
        r5.b = UUID.randomUUID().toString();
        r5.c = r13;
        AppLog r6 = s0;
        if (r6 == null) goto L21;
        r6.I.set(0);
        r6.J.set(0);
    L21:
        r5.d = this.I.getAndIncrement();
        r5.g = r5.c;
        if (TextUtils.isEmpty(u.c) == false) goto L26;
        b r7 = u.b;
        if (r7 == null) goto L26;
        u.c = r7.getVersion();
    L26:
        r5.e = u.c;
        r5.f = u.e();
        r5.h = r15;
        if (r15 == true) goto L29;
        r5.j = true;
    L29:
        monitor-enter(r1);
        SQLiteDatabase r8 = r1.a;     // Catch: Throwable -> L59
        if (r8 != null) goto L33;
    L38:
        j.g("AppLog db not establish and open", null);     // Catch: Throwable -> L59
        monitor-exit(r1);
        long r9 = -1;
    L42:
        if (r9 <= 0) goto L44;
        r5.a = r9;
        this.r = r5;
        j.e("AppLog start new session " + r5.b);
        D(r9);
    L45:
        if (r3 == null) goto L47;
    L48:
        w r10 = new w();
        r10.a = r3;
        if (P0 > 0) goto L51;
        P0 = 6;
    L51:
        z r11 = this.r;
        if (r11 != null) goto L54;
    L56:
        j(r10);
    L57:
        p.b().a(String.valueOf(r9), r13, r15);
        return;
    L54:
        if (r11.h == true) goto L56;
        r10.b = r11;
        goto L56
    L47:
        if (this.r == null) goto L57;
    L44:
        this.r = null;
        goto L45
    L33:
        if (r8.isOpen() == false) goto L38;
        boolean r12 = r5.h;     // Catch: Throwable -> L59
        ContentValues r14 = new ContentValues();     // Catch: Throwable -> L59
        r14.put("value", r5.b);     // Catch: Throwable -> L59
        r14.put("timestamp", Long.valueOf(r5.c));     // Catch: Throwable -> L59
        r14.put("duration", 0);     // Catch: Throwable -> L59
        r14.put("non_page", Integer.valueOf(r12 ? 1 : 0));     // Catch: Throwable -> L59
        r14.put(EffectConfiguration.KEY_APP_VERSION, r5.e);     // Catch: Throwable -> L59
        r14.put("version_code", Integer.valueOf(r5.f));     // Catch: Throwable -> L59
        r14.put("event_index", Long.valueOf(r5.d));     // Catch: Throwable -> L59
        r9 = r1.a.insert("session", null, r14);     // Catch: Throwable -> L59
        monitor-exit(r1);
    L59:
        th = move-exception;
        throw th;
    L5:
        if (r2.j == true) goto L9;
        if ((r13 - r2.g) >= this.s) goto L13;
    L9:
        if (r2.h == false) goto L12;
        if (r15 == false) goto L13;
    L12:
        r4 = false;
        goto L14
    }

    public final void M(String r20, boolean r21) {
        M0.set(Boolean.TRUE);
        boolean r2 = true;
        JSONObject r4 = new JSONObject(r20);     // Catch: Throwable -> L60
        String[] r14 = l(r4, false);     // Catch: Throwable -> L60
        String r5 = r4.toString();     // Catch: Throwable -> L60
        j.b("AppLog app_log_config: " + r5, null);     // Catch: Throwable -> L60
        byte[] r6 = r5.getBytes(EffectRequest.DEFAULT_PARAMS_ENCODING);     // Catch: Throwable -> L60
        long r7 = System.currentTimeMillis();     // Catch: Throwable -> L60
        if ((r7 - F0) >= 600000) goto L6;
        boolean r16 = true;
    L7:
        F0 = r7;     // Catch: Throwable -> L60
        e.a().b(StatsCountKeys.CONFIG_REQUEST_COUNT, 1);     // Catch: Throwable -> L60
        boolean r1 = false;
        int r13 = 0;
    L9:
        if (r13 >= 2) goto L49;
        byte[] r8 = (byte[]) r6.clone();     // Catch: Throwable -> L60
        m0 r9 = p0;     // Catch: Throwable -> L60
        String r10 = r9.b;     // Catch: Throwable -> L60
        if (r1 == false) goto L13;
        r10 = r9.g;     // Catch: Throwable -> L60
    L13:
        String r3 = d0.e(c0.b(r10, true), d0.b);     // Catch: Throwable -> L60
    L35:
        th = th;
        int r17 = r13;
    L37:
        e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);     // Catch: Throwable -> L60
        if ((th instanceof CommonHttpException) == false) goto L46;
        int r11 = ((CommonHttpException) th).getResponseCode();     // Catch: Throwable -> L60
        if (r11 < 500) goto L46;
        if (r11 >= 600) goto L46;
        this.C = System.currentTimeMillis();     // Catch: Throwable -> L60
        this.a = this.d;     // Catch: Throwable -> L60
        SharedPreferences.Editor r12 = this.l.getSharedPreferences(kta.b.a, 0).edit();     // Catch: Throwable -> L60
        r12.putLong("app_log_last_config_time", this.C);     // Catch: Throwable -> L60
        r12.putInt("app_log_last_config_version", this.a);     // Catch: Throwable -> L60
        r12.commit();     // Catch: Throwable -> L60
        throw th;     // Catch: Throwable -> L60
    L46:
        if (r17 > 0) goto L48;
        r13 = r17 + 1;     // Catch: Throwable -> L60
        r1 = true;
        goto L9
    L48:
        throw th;     // Catch: Throwable -> L60
    L83:
        if (this.l == null) goto L29;
        if (t() == false) goto L29;
        goto L24
    L88:
        String r15 = c0.h(s(), r3, r8, this.l, r16, r14, null, false, false);     // Catch: RuntimeException -> L78 Throwable -> L33
    L50:
        if (r15 != null) goto L52;
    L58:
        e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);     // Catch: Throwable -> L60
        e.a().b(StatsCountKeys.CONFIG_REQUEST_FAILED_COUNT, 1);     // Catch: Throwable -> L60
    L62:
        r2 = false;
    L63:
        if (r2 == true) goto L65;
    L67:
        Object r18 = L0;
        monitor-enter(r18);
        this.E = false;     // Catch: Throwable -> L74
        r18.notifyAll();     // Catch: Exception -> L77 Throwable -> L74
    L71:
        monitor-exit(r18);     // Catch: Throwable -> L74
        M0.remove();
        return;
    L74:
        th = move-exception;
        throw th;
    L65:
        if (a0 <= 0) goto L67;
        a0 = 0;
        goto L67
    L52:
        if (r15.length() == 0) goto L58;
        j.b("AppLog app_log_config response: " + r15, null);     // Catch: Throwable -> L60
        JSONObject r19 = new JSONObject(r15);     // Catch: Throwable -> L60
        if ("ss_app_log".equals(r19.optString("magic_tag")) == true) goto L57;
        e.a().b(StatsCountKeys.CONFIG_REQUEST_FAILED_COUNT, 1);     // Catch: Throwable -> L60
        goto L62
    L57:
        c r22 = new c(ActionQueueType.CONFIG_UPDATE);     // Catch: Throwable -> L60
        r22.b = r19;     // Catch: Throwable -> L60
        r22.d = String.valueOf(r21);     // Catch: Throwable -> L60
        i(r22);     // Catch: Throwable -> L60
    L24:
        e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);     // Catch: Throwable -> L33
        if (r16 == false) goto L27;
        r3 = r3 + "&config_retry=b";     // Catch: Throwable -> L33
    L27:
        r15 = c0.e(null, r3, r6, true, "application/octet-stream;tt-data=b", null, false, false);     // Catch: Throwable -> L33
    L29:
        if (r16 == false) goto L31;
        r3 = r3 + "&config_retry=b";     // Catch: Throwable -> L33
    L31:
        r15 = c0.e(null, r3, r6, true, "application/octet-stream;tt-data=b", null, false, false);     // Catch: Throwable -> L33
    L33:
        th = th;
        goto L37
    L49:
        r15 = null;
        goto L50
    L6:
        r16 = false;
    L60:
        th = move-exception;
        e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);
        j.c("AppLog updateConfig exception: ", th);
        goto L62
    }

    public final void N(Context r2, boolean r3) {
        u.d(r2, this.m, r3);
        if (this.i == null) goto L11;
        JSONObject r4 = new JSONObject(this.m, f.a);     // Catch: JSONException -> L6
        this.i.B(r4);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        j.c("AppLog updateHeader", e);
        return;
    }

    public final void x(JSONObject r16, boolean r17) {
        if (r16 != null) goto L5;
        return;
    L5:
        this.C = System.currentTimeMillis();
        this.a = this.d;
        long r6 = r16.optLong("server_time");     // Catch: Exception -> L14
        if (r6 <= 0) goto L15;
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L14
        r8.put("server_time", r6);     // Catch: Exception -> L14
        r8.put("local_time", System.currentTimeMillis() / 1000);     // Catch: Exception -> L14
        this.x = r8;     // Catch: Exception -> L14
        if (this.i == null) goto L15;
        x r7 = this.i;     // Catch: Exception -> L14
        JSONObject r9 = this.x;     // Catch: Exception -> L14
        r7.I = r9;     // Catch: Exception -> L14
        if (com.bytedance.applog.log.m.b() == true) goto L15;
        com.bytedance.applog.log.m.c("server_time_sync", new y(r9));     // Catch: Exception -> L14
    L15:
        JSONObject r1 = r16.optJSONObject("config");
        if (r1 != null) goto L18;
        r1 = new JSONObject();
    L18:
        JSONObject r10 = r1;
        JSONArray r2 = r10.optJSONArray("allow_push_list");     // Catch: Exception -> L30
        if (r2 == null) goto L31;
        Object r11 = r0;     // Catch: Exception -> L30
        monitor-enter(r11);     // Catch: Exception -> L30
        H(this.o, r2);     // Catch: Throwable -> L27
        monitor-exit(r11);     // Catch: Throwable -> L27
        String r3 = r2.toString();     // Catch: Exception -> L30
    L33:
        if (r10.isNull("allow_old_image_sample") == true) goto L39;
        int r12 = r10.optInt("allow_old_image_sample", -1);
        if (r12 < 1) goto L38;
        boolean r13 = true;
    L42:
        if (r13 == this.p) goto L44;
        this.p = r13;
        boolean r14 = true;
    L45:
        long r4 = r10.optLong("session_interval", 0);
        if (r4 >= 15) goto L48;
    L52:
        boolean r5 = false;
    L53:
        long r15 = r10.optLong("batch_event_interval", 60) * 1000;
        if (g(r15) == true) goto L56;
    L65:
        long r18 = r10.optLong("fetch_interval", 21600) * 1000;
        if (r18 >= 1800000) goto L68;
    L69:
        r18 = 21600000;
    L71:
        if (r18 == this.u) goto L73;
        this.u = r18;
        r5 = true;
    L73:
        int r19 = r10.optInt("send_launch_timely");
        if (r19 == this.v) goto L79;
        this.v = r19;
        if (this.i == null) goto L78;
        this.i.H = this.v;
    L78:
        r5 = true;
    L79:
        int r20 = r10.optInt("http_monitor_port");
        if (r20 > 0) goto L82;
    L84:
        boolean r21 = false;
    L86:
        if (r10.optInt("device_register_throttle", 0) == 0) goto L88;
        boolean r22 = true;
    L89:
        j.b("AppLog get_deviceRegisterThrottle: " + r22, null);
        if (r22 == h.w) goto L92;
        j.b("AppLog change_deviceRegisterThrottle: " + h.w, null);
        h.w = r22;
        boolean r23 = true;
    L93:
        int r24 = r10.optInt("forbid_report_phone_detail_info", -1);
        SharedPreferences.Editor r110 = this.l.getSharedPreferences(kta.b.a, 0).edit();
        if (r24 < 0) goto L102;
        r110.putInt("forbid_report_phone_detail_info", r24);
        if (r24 <= 0) goto L98;
        boolean r25 = true;
    L99:
        this.b = r25;
        g.j.o(r25);
        u.b(this.m);
        k();
        if (this.i == null) goto L102;
        this.i.o();
        goto L102
    L98:
        r25 = false;
    L102:
        if (r5 == false) goto L104;
        r110.putLong("session_interval", this.s);
        r110.putLong("batch_event_interval", this.t);
        r110.putLong("fetch_interval", this.u);
        r110.putInt("send_launch_timely", this.v);
    L104:
        if (r3 == null) goto L106;
        r110.putString("allow_push_list", r3);
    L106:
        if (r14 == false) goto L108;
        r110.putBoolean("allow_old_image_sample", this.p);
    L108:
        if (r21 == false) goto L110;
        r110.putInt("http_monitor_port", this.w);
    L110:
        if (r23 == false) goto L112;
        j.b("AppLog save_deviceRegisterThrottle: " + r22, null);
        r110.putBoolean("device_register_throttle", r22);
    L112:
        r110.putLong("app_log_last_config_time", this.C);
        r110.putInt("app_log_last_config_version", this.a);
        JSONArray r26 = r10.optJSONArray("real_time_events");     // Catch: Throwable -> L126
        this.H.clear();     // Catch: Throwable -> L126
        if (r26 != null) goto L116;
    L124:
        r110.remove("real_time_events");     // Catch: Throwable -> L126
    L128:
        r110.putInt("content_encode_method", r10.optInt("content_encode_method", 0));
        r110.apply();
        if (r17 == true) goto L131;
        return;
    L131:
        if (this.n == true) goto L144;
        this.n = true;
        L(true, true, false);
        return;
    L144:
        return;
    L116:
        if (r26.length() <= 0) goto L124;
        int r27 = r26.length();     // Catch: Throwable -> L126
        int r28 = 0;
    L118:
        if (r28 >= r27) goto L123;
        String r29 = JSONArrayProtectorUtils.getString(r26, r28);     // Catch: Throwable -> L126
        if (StringUtils.isEmpty(r29) == true) goto L122;
        this.H.put(r29, "timely");     // Catch: Throwable -> L126
    L122:
        r28 = r28 + 1;     // Catch: Throwable -> L126
        goto L118
    L123:
        r110.putString("real_time_events", r26.toString());     // Catch: Throwable -> L126
    L126:
        th = move-exception;
        th.printStackTrace();
        goto L128
    L92:
        r23 = false;
        goto L93
    L88:
        r22 = false;
        goto L89
    L82:
        if (r20 == this.w) goto L84;
        this.w = r20;
        r21 = true;
        goto L86
    L68:
        if (r18 <= 172800000) goto L71;
    L56:
        if (r15 == this.t) goto L65;
        this.t = r15;
        if (this.i == null) goto L64;
        x r30 = this.i;
        long r111 = R0;
        if (g(r111) == true) goto L63;
        r111 = this.t;
    L63:
        r30.G = r111;
        r30.F.set(r111);
    L64:
        r5 = true;
        goto L65
    L48:
        if (r4 > 300) goto L52;
        long r31 = r4 * 1000;
        if (r31 == this.s) goto L52;
        this.s = r31;
        r5 = true;
        goto L53
    L44:
        r14 = false;
        goto L45
    L38:
        if (r12 == 0) goto L39;
        r13 = r10.optBoolean("allow_old_image_sample", false);
    L39:
        r13 = false;
        goto L42
    L27:
        th = move-exception;
        throw th;     // Catch: Exception -> L30
    L31:
        r3 = null;
        goto L33
    }

    public final void y(s r7, long r8) {
        z r1 = this.r;
        if (r1 != null) goto L7;
        j.g("AppLog no session when onPause: " + r7.a, null);
        return;
    L7:
        if (r1.h == false) goto L10;
        j.g("AppLog non-page session when onPause: " + r7.a, null);
        return;
    L10:
        r1.j = false;
        r1.g = r8;
        r7.c = r1.a;
        h r2 = h.d(this.l);
        monitor-enter(r2);
        SQLiteDatabase r3 = r2.a;     // Catch: Throwable -> L39
        if (r3 != null) goto L15;
    L28:
        j.g("AppLog db not establish and open", null);     // Catch: Throwable -> L39
        monitor-exit(r2);
    L43:
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L42
        int r10 = this.y.get();     // Catch: Exception -> L42
        int r11 = this.z.get();     // Catch: Exception -> L42
        r9.put("session_id", this.r.b);     // Catch: Exception -> L42
        r9.put("cnt_success", r10);     // Catch: Exception -> L42
        r9.put("cnt_failure", r11);     // Catch: Exception -> L42
        JSONArray r12 = new JSONArray();     // Catch: Exception -> L42
        Iterator<h> r13 = this.A.iterator();     // Catch: Exception -> L42
    L32:
        if (r13.hasNext() == false) goto L35;
        h r4 = r13.next();     // Catch: Exception -> L42
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L42
        r5.put("url", r4.a);     // Catch: Exception -> L42
        r5.put("networktype", r4.b);     // Catch: Exception -> L42
        r5.put("time", r4.c);     // Catch: Exception -> L42
        r5.put("timestamp", r4.d);     // Catch: Exception -> L42
        r12.put(r5);     // Catch: Exception -> L42
        goto L32
    L35:
        if (r12.length() <= 0) goto L37;
        r9.put("samples", r12);     // Catch: Exception -> L42
    L37:
        SharedPreferences.Editor r14 = this.l.getSharedPreferences(kta.b.a, 0).edit();     // Catch: Exception -> L42
        r14.putString("stats_value", r9.toString());     // Catch: Exception -> L42
        r14.commit();     // Catch: Exception -> L42
        return;
    L51:
        return;
    L15:
        if (r3.isOpen() == false) goto L28;
        ContentValues r6 = new ContentValues();     // Catch: Exception -> L19 Throwable -> L39
        r6.put("pausetime", Long.valueOf(r8));     // Catch: Exception -> L19 Throwable -> L39
        r2.a.update("session", r6, "_id = ?", new String[]{String.valueOf(r7.c)});     // Catch: Exception -> L19 Throwable -> L39
    L45:
        ContentValues r15 = new ContentValues();     // Catch: Exception -> L24 Throwable -> L39
        r15.put(DBDefinition.NAME, r7.a);     // Catch: Exception -> L24 Throwable -> L39
        r15.put("duration", Integer.valueOf(r7.b));     // Catch: Exception -> L24 Throwable -> L39
        r15.put("session_id", Long.valueOf(r7.c));     // Catch: Exception -> L24 Throwable -> L39
        r2.a.insert("page", null, r15);     // Catch: Exception -> L24 Throwable -> L39
        monitor-exit(r2);
        goto L43
    L24:
        e = move-exception;
        j.g("AppLog insert page exception: ", e);     // Catch: Throwable -> L39
        goto L43
    L19:
        e = move-exception;
        j.g("AppLog update session pausetime exception: ", e);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;
    }

    public static void recordMiscLog(Context r1, String r2, JSONObject r3) {
        g0.i(r2, r3);
    }

    public final void L(boolean r17, boolean r18, boolean r19) {
        if (this.E == false) goto L5;
        return;
    L5:
        JSONObject r1 = this.m;
        if (r1 != null) goto L9;
        return;
    L9:
        if (g0.y(r1.optString(EffectConfiguration.KEY_DEVICE_ID, null)) == false) goto L12;
        return;
    L12:
        if (StringUtils.isEmpty(this.m.optString("install_id", null)) == false) goto L14;
        return;
    L14:
        long r2 = System.currentTimeMillis();
        long r3 = this.u;
        if (this.a != this.d) goto L17;
        boolean r5 = true;
    L19:
        if (C0 == false) goto L21;
    L24:
        if (r5 == false) goto L26;
        long r12 = 180000;
    L27:
        if (r18 == true) goto L36;
        if ((r2 - this.C) >= r3) goto L32;
        return;
    L32:
        if ((r2 - this.D) >= r12) goto L60;
        j.b("AppLog next query time : " + DateFormat.getDateTimeInstance().format(new Date(this.D + r12)), null);
        return;
    L60:
        long r4 = System.currentTimeMillis();     // Catch: Exception -> L59
        if (a0 > 0) goto L44;
        a0 = r4;     // Catch: Exception -> L59
    L44:
        if (NetworkUtils.isNetworkAvailable(this.l) == true) goto L47;
        e.a().b(StatsCountKeys.NO_NETWORK_COUNT, 1);     // Catch: Exception -> L59
        return;
    L47:
        this.D = r2;     // Catch: Exception -> L59
        this.E = true;     // Catch: Exception -> L59
        JSONObject r6 = new JSONObject(this.m, f.a);     // Catch: Exception -> L59
        Context r7 = this.l;     // Catch: Exception -> L59
        if (StringUtils.isEmpty(u.k) == false) goto L51;
        u.k = r7.getSharedPreferences(kta.b.a, 0).getString("user_agent", null);     // Catch: Exception -> L59
    L51:
        String r8 = u.k;     // Catch: Exception -> L59
        if (StringUtils.isEmpty(r8) == true) goto L54;
        r6.put("user_agent", r8);     // Catch: Exception -> L59
    L54:
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L59
        r9.put("magic_tag", "ss_app_log");     // Catch: Exception -> L59
        r9.put("header", r6);     // Catch: Exception -> L59
        r9.put("_gen_time", System.currentTimeMillis());     // Catch: Exception -> L59
        String r10 = r9.toString();     // Catch: Exception -> L59
        if (r17 == false) goto L57;
        ThreadMethodProxy.start(new a(this, r10, r19, r4));     // Catch: Exception -> L59
        return;
    L57:
        M(r10, r19);     // Catch: Exception -> L59
        return;
    L62:
        return;
    L36:
        if (this.D <= this.C) goto L60;
        if ((r2 - this.D) >= r12) goto L60;
        return;
    L26:
        r12 = 60000;
        goto L27
    L21:
        if (this.k >= 0) goto L24;
        if (r5 == false) goto L24;
        r3 = 2 * this.u;
        goto L24
    L17:
        r5 = false;
        goto L19
    }

    public static void E(Context r1, String r2, String r3, String r4, long r5, long r6, JSONObject r8) {
        a(r1, r2, r3, r4, r5, r6, r8);
    }

    public static void a(Context r21, String r22, String r23, String r24, long r25, long r27, JSONObject r29) {
        com.bytedance.android.btm.api.model.j r1 = new com.bytedance.android.btm.api.model.j(r21, r22, r23, r24, r25, r27, false, r29, true);
        BtmSDK r2 = BtmSDK.INSTANCE;
        com.bytedance.android.btm.api.model.j r3 = r2.addBtmEventParam(r1);
        com.bytedance.android.btm.api.bst.b r4 = (com.bytedance.android.btm.api.bst.b) yc.b.a(com.bytedance.android.btm.api.bst.b.class);
        if (r4 == null) goto L5;
        r4.hookApplog(r3);
    L5:
        r2.getService().checkEventParam(r3);
        BtmDebugTool.b.onEventIntercepted(r3);
        F(r21, r22, r23, r24, r25, r27, false, r3.h);
    }

    public static void F(Context r11, String r12, String r13, String r14, long r15, long r17, boolean r19, JSONObject r20) {
        if (r20 != null) goto L21;
    L7:
        if (r20 != null) goto L10;
    L17:
        g0.s(r12, r13, r14, r15, r17, r19, r20);
        return;
    L10:
        if (r20.has("ab_sdk_version") == true) goto L17;
        String r1 = n();
        if (TextUtils.isEmpty(r1) == true) goto L17;
        r20.put("ab_sdk_version", r1);     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L21:
        r20.put("network_quality", NetQualityManager.a.getValue());     // Catch: JSONException -> L6
        goto L7
    }
}
