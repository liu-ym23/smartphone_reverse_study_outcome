package com.ss.android.deviceregister.b;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.compat.intf.IAppTraitCallback;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.rpc.internal.RpcUtils;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.ss.android.common.applog.MonitorKey;
import com.ss.android.common.applog.MonitorState;
import com.ss.android.common.applog.y;
import com.ss.android.deviceregister.a.h;
import com.ss.android.deviceregister.a.i;
import com.ss.android.deviceregister.a.u;
import com.ss.android.deviceregister.f;
import com.ss.android.deviceregister.g;
import com.ss.android.deviceregister.q;
import com.ss.android.deviceregister.r;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes6.dex */
public abstract class e {
    private static List<WeakReference<f.a>> C;
    private static final ThreadLocal<Boolean> D = null;
    private static boolean F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f15186a;
    private static h c;
    private static final Object d = null;
    private static i e;
    private static volatile r f;
    private static final Bundle h = null;
    private static volatile boolean i;
    private static volatile boolean j;
    private static long q;
    private static volatile boolean v;
    private static volatile long x;
    private b A;
    private boolean B;
    private b.a E;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.ss.android.deviceregister.b.a.a f15187b;
    private final Object g;
    private volatile boolean k;
    private int l;
    private volatile int m;
    private final Context n;
    private final SharedPreferences o;
    private JSONObject p;
    private long r;
    private long s;
    private long t;
    private String u;
    private String w;
    private a y;
    private volatile q z;

    private class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f15191b;

        a(e r1) {
            this.f15191b = r1;
            super("DeviceRegisterThread");
            this.f15190a = 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v1 */
        /* JADX WARN: Type inference failed for: r14v4 */
        /* JADX WARN: Type inference failed for: r14v5 */
        /* JADX WARN: Type inference failed for: r18v1, types: [byte[]] */
        /* JADX WARN: Type inference failed for: r18v10 */
        /* JADX WARN: Type inference failed for: r18v2 */
        /* JADX WARN: Type inference failed for: r18v3 */
        /* JADX WARN: Type inference failed for: r18v5 */
        /* JADX WARN: Type inference failed for: r18v9 */
        private boolean a(String r28, JSONObject r29) {
            Logger.d("RegisterServiceController", "app_log_config: " + r28);     // Catch: Throwable -> L54
            byte[] r6 = r28.getBytes(RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L54
            e.b(this.f15191b, System.currentTimeMillis());     // Catch: Throwable -> L54
            String[] r15 = com.ss.android.deviceregister.b.a.a();     // Catch: Throwable -> L54
            if (r15 == null) goto L53;
            int r13 = 0;
            ?? r14 = r15.length;     // Catch: Throwable -> L54
        L6:
            if (r13 >= r14) goto L51;
            String r7 = r15[r13];     // Catch: Throwable -> L54
            r14 = (byte[]) ZeusTransformUtils.preCheckCast(r6.clone(), byte[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
            if (com.bytedance.common.utility.h.a(r7) == false) goto L11;
            r13 = r13;
            r14 = r14;
        L49:
            r13 = r13 + 1;     // Catch: Throwable -> L54
            r14 = r14;
            goto L6
        L11:
            if (Logger.debug() == false) goto L14;
            Logger.d("RegisterServiceController", "request url : " + r7);     // Catch: Throwable -> L54
        L14:
            if (TextUtils.isEmpty(r29.optString("device_id")) == false) goto L16;
        L19:
            boolean r0 = true;
        L62:
            if (d() == true) goto L58;
            String r1 = y.a(r7, r6, true, "application/json; charset=utf-8", false, null, r0, false);     // Catch: Throwable -> L43
        L60:
            com.ss.android.common.b.b.a("device_register response: " + r1);     // Catch: Throwable -> L43
            if (r1 != null) goto L36;
        L41:
            com.ss.android.common.applog.b.a(MonitorKey.register, MonitorState.f_resp_error);     // Catch: Throwable -> L43
            goto L49
        L36:
            if (r1.length() == 0) goto L41;
            if (a(new JSONObject(r1)) == false) goto L49;
            return true;
        L43:
            th = th;
        L47:
            com.ss.android.common.applog.b.a(MonitorKey.register, MonitorState.f_net);     // Catch: Throwable -> L54
            if (e.a(this.f15191b, th) == true) goto L49;
            throw th;     // Catch: Throwable -> L54
        L58:
            if (r7.indexOf(63) >= 0) goto L26;
            StringBuilder r8 = new StringBuilder().append(r7).append("?");     // Catch: RuntimeException -> L29 Throwable -> L45
        L27:
            r1 = y.a(null, r8.toString(), r14, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.k(this.f15191b), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), false, null, null, null, r0, false);     // Catch: RuntimeException -> L29 Throwable -> L45
            goto L60
        L26:
            r8 = new StringBuilder().append(r7).append("&");     // Catch: RuntimeException -> L29 Throwable -> L45
            goto L27
        L29:
            com.ss.android.common.applog.b.a(MonitorKey.register, MonitorState.f_to_bytes);     // Catch: Throwable -> L45
            r1 = y.a(r7, r6, true, "application/json; charset=utf-8", false, null, r0, false);     // Catch: Throwable -> L43
        L45:
            th = th;
            r13 = r13;
            r14 = r14;
            goto L47
        L16:
            if (TextUtils.isEmpty(r29.optString("install_id")) == true) goto L19;
            r0 = false;
            goto L62
        L51:
            return false;
        L53:
            throw new IllegalArgumentException("url is null");     // Catch: Throwable -> L54
        L54:
            th = move-exception;
            com.ss.android.common.applog.b.a(MonitorKey.register, MonitorState.f_exception);
            th.printStackTrace();
            return false;
        }

        private boolean a(JSONObject r23) {
            boolean r2 = false;
            if (r23 != null) goto L5;
            return false;
        L5:
            e.b(this.f15191b, u.c());
            if (r23.optInt(Api.KEY_NEW_USER, 0) <= 0) goto L8;
            boolean r3 = true;
        L9:
            e.d(r3);
            SharedPreferences.Editor r4 = e.o(this.f15191b).edit();
            r4.putInt("last_config_version", e.f(this.f15191b));
            r4.putString("dr_channel", u.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.k(this.f15191b), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));
            String r5 = e.p(this.f15191b);
            String r6 = this.f15191b.f15187b.b();
            boolean r7 = com.bytedance.common.utility.h.a(r6);
            final String r10 = r23.optString("install_id", null);
            final String r9 = r23.optString("device_id", null);
            String r1 = r23.optString("device_token", "");
            boolean r13 = y.a(r9);
            boolean r14 = y.a(r10);
            if (r13 == true) goto L14;
            if (r14 == true) goto L14;
            e.c(this.f15191b, System.currentTimeMillis());
            r4.putLong("last_config_time", e.g(this.f15191b));
        L14:
            if (r14 == false) goto L16;
        L21:
            if (r13 == false) goto L23;
        L25:
            if (r13 == true) goto L27;
        L29:
            if (r2 == true) goto L43;
        L31:
            r4.putString("device_token", r1);
            r4.commit();
            if (r2 == false) goto L34;
            this.f15191b.f15187b.a(r9);
            e.q(this.f15191b);
        L34:
            e.a(this.f15191b, true, r7);
            if (e.a(this.f15191b) == null) goto L38;
            new Handler(Looper.getMainLooper()).post(new AnonymousClass1(this, r9, r10));
        L38:
            return true ^ r13;
        L43:
            e.b(this.f15191b).put("install_id", e.p(this.f15191b));     // Catch: Exception -> L40
            e.b(this.f15191b).put("device_id", r9);     // Catch: Exception -> L40
            r4.putString("install_id", e.p(this.f15191b));     // Catch: Exception -> L40
            r4.putString("device_id", r9);     // Catch: Exception -> L40
            goto L31
        L27:
            if (e.t() == null) goto L29;
            e.t().a("service_monitor", "diderror", 0, null, null);
            goto L29
        L23:
            if (r9.equals(r6) == true) goto L25;
            this.f15191b.a(r6, r9);
            r2 = true;
            goto L25
        L16:
            if (r10.equals(e.p(this.f15191b)) == true) goto L21;
            e.a(this.f15191b, r10);
            if (com.bytedance.common.utility.h.a(r5) == false) goto L41;
        L20:
            r2 = true;
            goto L21
        L41:
            JSONObject r8 = new JSONObject();     // Catch: Exception -> L39
            r8.put("old_id", r5);     // Catch: Exception -> L39
            r8.put("new_id", r10);     // Catch: Exception -> L39
            this.f15191b.a("iid_change", r8);     // Catch: Exception -> L39
            goto L20
        L8:
            r3 = false;
            goto L9
        }

        private boolean b() {
            if (e.f15186a == true) goto L5;
        L11:
            return false;
        L5:
            if (y.a(this.f15191b.g()) == true) goto L11;
            if (y.a(this.f15191b.h()) == true) goto L11;
            if (e.f(this.f15191b) != u.c()) goto L11;
            return true;
        }

        private long c() {
            long r0 = System.currentTimeMillis();
            if (e.f(this.f15191b) != u.c()) goto L5;
            boolean r2 = true;
        L7:
            if (com.ss.android.deviceregister.b.a.b() == false) goto L9;
        L12:
            long r7 = 21600000;
        L13:
            if (r2 == false) goto L15;
            long r3 = 180000;
        L16:
            long r9 = e();
            if (r9 == 0) goto L19;
            r3 = WifiScanStateMachine.SCAN_INTERVAL_WITH_THROTTLE_LEVEL_2_MS * r9;
        L19:
            long r10 = r7 - (r0 - e.g(this.f15191b));
            long r4 = r3 - (r0 - e.h(this.f15191b));
            if (r10 > 0) goto L22;
        L24:
            long r5 = Math.max(r10, r4);
            if (e.d(this.f15191b) == true) goto L27;
        L29:
            r7 = r5;
        L31:
            if (Logger.debug() == true) goto L33;
        L37:
            return r7;
        L33:
            if (r7 < 0) goto L36;
            r0 = r0 + r7;
        L36:
            Logger.d("RegisterServiceController", "next query time : " + DateFormat.getDateTimeInstance().format(new Date(r0)));
            goto L37
        L27:
            if (e.i(this.f15191b) != f.e()) goto L29;
            e.j(this.f15191b);
            e.a(this.f15191b, 0);
            goto L31
        L22:
            if (e.d(this.f15191b) == false) goto L24;
            e.a(this.f15191b, 0);
            goto L24
        L15:
            r3 = 30000;
            goto L16
        L9:
            if (e.n() >= 0) goto L12;
            if (r2 == false) goto L12;
            r7 = 43200000;
            goto L13
        L5:
            r2 = false;
            goto L7
        }

        private boolean d() {
            return com.ss.android.deviceregister.b.a.c();
        }

        private int e() {
            if (y.a(this.f15191b.g()) == false) goto L5;
        L8:
            boolean r0 = true;
        L9:
            if (r0 == false) goto L17;
            boolean r1 = NetworkUtils.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.k(this.f15191b), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            int r3 = this.f15190a;
            if (r1 == false) goto L13;
            int r2 = 3;
        L14:
            if (r3 <= r2) goto L16;
            r0 = true;
            goto L17
        L16:
            r0 = false;
            goto L17
        L13:
            r2 = 10;
        L17:
            if (r0 == false) goto L20;
            int r4 = this.f15190a + 1;
            this.f15190a = r4;
            return r4;
        L20:
            return 0;
        L5:
            if (y.a(this.f15191b.h()) == true) goto L8;
            r0 = false;
            goto L9
        }

        void a() {
            if (e.o() == false) goto L5;
            return;
        L5:
            IAppTraitCallback r0 = f.g();
            String r1 = null;
            if (r0 == null) goto L111;
            r1 = r0.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.k(this.f15191b), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        L111:
            long r2 = System.currentTimeMillis();     // Catch: Exception -> L101
            if (e.p() > 0) goto L11;
            e.a(r2);     // Catch: Exception -> L101
        L11:
            e.a(this.f15191b, r2);     // Catch: Exception -> L101
            if (NetworkUtils.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.k(this.f15191b), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L15;
            com.ss.android.common.applog.b.a(MonitorKey.register, MonitorState.f_no_network);     // Catch: Exception -> L101
            e.j(this.f15191b);     // Catch: Exception -> L101
            return;
        L15:
            String r3 = u.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.k(this.f15191b), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L101
            if (com.bytedance.common.utility.h.a(r3) == true) goto L19;
            e.b(this.f15191b).put(Api.KEY_USER_AGENT, r3);     // Catch: Exception -> L101
        L19:
            if (com.bytedance.common.utility.h.a(e.l(this.f15191b)) == true) goto L21;
            e.b(this.f15191b).put(Api.KEY_APP_TRACK, e.l(this.f15191b));     // Catch: Exception -> L101
        L21:
            JSONObject r4 = new JSONObject(new JSONTokener(e.b(this.f15191b).toString()));     // Catch: Exception -> L101
            r4.put("req_id", f.l());     // Catch: Exception -> L101
            if (this.f15191b.j() == false) goto L24;
            r4.put(MemoryInfoSectionEditActivity.KIND_SCENE, 2);     // Catch: Exception -> L101
        L24:
            r4.put("device_platform", "android");     // Catch: Exception -> L101
            new com.ss.android.deviceregister.b.b().a(r4);     // Catch: Exception -> L101
            Bundle r8 = new Bundle();     // Catch: Throwable -> L69
            Bundle r9 = e.q();     // Catch: Throwable -> L69
            monitor-enter(r9);     // Catch: Throwable -> L69
            r8.putAll(e.q());     // Catch: Throwable -> L66
            monitor-exit(r9);     // Catch: Throwable -> L66
        L31:
            if (r8.size() <= 0) goto L38;
            JSONObject r10 = new JSONObject();     // Catch: Throwable -> L69
            Iterator<String> r11 = r8.keySet().iterator();     // Catch: Throwable -> L69
        L34:
            if (r11.hasNext() == false) goto L36;
            String r12 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L69
            r10.put(r12, r8.get(r12));     // Catch: Throwable -> L69
            goto L34
        L36:
            r4.put("custom", r10);     // Catch: Throwable -> L69
        L38:
            if (TextUtils.isEmpty(r1) == true) goto L40;
            r4.put("app_trait", r1);     // Catch: Throwable -> L69
        L40:
            String r5 = com.ss.android.b.a();     // Catch: Throwable -> L69
            String r13 = com.ss.android.b.b();     // Catch: Throwable -> L69
            if (this.f15191b.j() == true) goto L60;
            if (f.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.k(this.f15191b), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L60;
            if (f.f() == true) goto L60;
            Pair<String, Boolean> r14 = com.ss.android.deviceregister.h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.k(this.f15191b), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L69
            if (r14 == null) goto L60;
            if (r14.second != null) goto L51;
        L53:
            boolean r15 = false;
        L55:
            if (r15 == false) goto L57;
            int r16 = 1;
        L58:
            r4.put("gaid_limited", r16);     // Catch: Throwable -> L69
            r4.put("google_aid", r14.first);     // Catch: Throwable -> L69
            goto L60
        L57:
            r16 = 0;
            goto L58
        L51:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r14.second, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L53;
            r15 = true;
        L60:
            if (com.bytedance.common.utility.h.a(r5) == true) goto L63;
            r4.put(Api.KEY_APP_LANGUAGE, r5);     // Catch: Throwable -> L69
        L63:
            if (com.bytedance.common.utility.h.a(r13) == true) goto L71;
            r4.put(Api.KEY_APP_REGION, r13);     // Catch: Throwable -> L69
        L71:
            e.a(this.f15191b, r4);     // Catch: Exception -> L101
            r4.put("sdk_version", "3.9.1");     // Catch: Exception -> L101
            r4.put("sdk_flavor", "china");     // Catch: Exception -> L101
            if (f.f() == false) goto L74;
            int r17 = 1;
        L75:
            r4.put("guest_mode", r17);     // Catch: Exception -> L101
            u.a(r4);     // Catch: Exception -> L101
            JSONObject r6 = new JSONObject();     // Catch: Exception -> L101
            r6.put(Api.KEY_MAGIC, Api.MSG_MAGIC);     // Catch: Exception -> L101
            r6.put("header", r4);     // Catch: Exception -> L101
            r6.put("_gen_time", System.currentTimeMillis());     // Catch: Exception -> L101
            e.b(true);     // Catch: Exception -> L101
            e.r().set(Boolean.TRUE);     // Catch: Exception -> L101
            boolean r7 = a(r6.toString(), r4);     // Catch: Exception -> L101
            if (r7 == false) goto L86;
            long r18 = System.currentTimeMillis();     // Catch: Exception -> L101
            if (e.p() <= 0) goto L81;
            com.ss.android.common.applog.b.a(MonitorKey.register, MonitorState.total_success, r18 - e.p());     // Catch: Exception -> L101
            e.a(0);     // Catch: Exception -> L101
        L81:
            if (e.m(this.f15191b) != null) goto L83;
        L85:
            com.ss.android.common.applog.b.a(MonitorKey.register, MonitorState.success, r18 - r2);     // Catch: Exception -> L101
            goto L86
        L83:
            if (e.n(this.f15191b) == null) goto L85;
            e.n(this.f15191b).b(e.m(this.f15191b));     // Catch: Exception -> L101
        L86:
            Object r19 = e.s();     // Catch: Exception -> L101
            monitor-enter(r19);     // Catch: Exception -> L101
            e.b(false);     // Catch: Throwable -> L98
            e.s().notifyAll();     // Catch: Exception -> L91 Throwable -> L98
        L93:
            monitor-exit(r19);     // Catch: Throwable -> L98
            e.c(true);     // Catch: Exception -> L101
            e.r().remove();     // Catch: Exception -> L101
            if (r7 == true) goto L113;
            e.a(this.f15191b, false, com.bytedance.common.utility.h.a(this.f15191b.f15187b.b()));     // Catch: Exception -> L101
            return;
        L113:
            return;
        L91:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L98
        L98:
            th = move-exception;
            throw th;     // Catch: Exception -> L101
        L74:
            r17 = 0;
        L66:
            th = move-exception;
            throw th;     // Catch: Throwable -> L69
        L69:
            th = move-exception;
            th.printStackTrace();     // Catch: Exception -> L101
        L101:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            e.a(this.f15191b, !com.bytedance.common.utility.h.a(e.b(this.f15191b).optString("device_id", null)));
        L4:
            if (e.m() == true) goto L38;
            if (b() == true) goto L8;
            long r0 = c();
            Object r2 = e.c(this.f15191b);
            monitor-enter(r2);
            if (r0 <= 0) goto L35;
        L51:
            th = move-exception;
            throw th;
        L32:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L51
            goto L35
        L27:
            if (e.m() == true) goto L28;
            e.c(this.f15191b).wait(r0);     // Catch: InterruptedException -> L32 Throwable -> L51
        L28:
            monitor-exit(r2);     // Catch: Throwable -> L51
        L35:
            if (e.m() == true) goto L28;
            monitor-exit(r2);     // Catch: Throwable -> L51
            monitor-enter(this);
            a();     // Catch: Throwable -> L48
            if (e.d(this.f15191b) == false) goto L46;
            e.e(this.f15191b);     // Catch: Throwable -> L48
        L46:
            monitor-exit(this);     // Catch: Throwable -> L48
        L48:
            th = move-exception;
            throw th;
        L8:
            Object r1 = e.c(this.f15191b);
            monitor-enter(r1);
            if (Logger.debug() == false) goto L56;
            Logger.d("RegisterServiceController", "throttle by applog/settings sThrottleByAppLogConfig=" + e.f15186a + " did=" + this.f15191b.g() + " iid=" + this.f15191b.h());     // Catch: Throwable -> L19
        L56:
            e.c(this.f15191b).wait(TimeUnit.MINUTES.toMillis(1));     // Catch: InterruptedException -> L15 Throwable -> L19
        L17:
            monitor-exit(r1);     // Catch: Throwable -> L19
            goto L4
        L15:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        L38:
            if (Logger.debug() == false) goto L71;
            Logger.d("RegisterServiceController", "DeviceRegisterThread finished");
            return;
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<WeakReference<a>> f15194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f15195b;
        private final Context c;

        interface a {
            void a();
        }

        public b(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            this.f15194a = Collections.synchronizedSet(new HashSet());
            this.f15195b = new AtomicBoolean(false);
            this.c = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        }

        static /* synthetic */ Context a(b r0) {
            return r0.c;
        }

        private void a() {
            if (this.f15195b.compareAndSet(false, true) == false) goto L12;
            PluginBroadcastReceiver r0 = new AnonymousClass1(this);
            IntentFilter r1 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            ZeusTransformUtils.registerReceiver(this.c, r0, r1, "com.obric.memorydata.plugin");     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        private void b() {
            Iterator r3 = new ArrayList(this.f15194a).iterator();
        L4:
            if (r3.hasNext() == false) goto L8;
            a r0 = (a) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r3.next(), WeakReference.class, "com.obric.memorydata.plugin")).get(), a.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L4;
            r0.a();
            goto L4
        }

        static /* synthetic */ void b(b r0) {
            r0.b();
        }

        public synchronized void a(a r3) {
            monitor-enter(this);
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
            this.f15194a.add(new WeakReference(r4));     // Catch: Throwable -> L6
            a();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void b(a r5) {
            monitor-enter(this);
            a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
            Iterator<WeakReference<a>> r0 = this.f15194a.iterator();     // Catch: Throwable -> L14
        L5:
            if (r0.hasNext() == false) goto L12;
            WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.next(), WeakReference.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
            if (r1 == null) goto L8;
            if (((a) ZeusTransformUtils.preCheckCast(r1.get(), a.class, "com.obric.memorydata.plugin")) != r6) goto L5;
            r0.remove();     // Catch: Throwable -> L14
            goto L12
        L8:
            r0.remove();     // Catch: Throwable -> L14
        L12:
            monitor-exit(this);
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    static {
        d = new Object();
        h = new Bundle();
        i = false;
        j = false;
        f15186a = false;
        q = 0;
        v = false;
        C = Collections.synchronizedList(new ArrayList());
        D = new ThreadLocal();
        F = false;
    }

    public e(Context r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        this.g = new Object();
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.n = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.f15187b = g.a(r7);
        this.o = com.ss.android.deviceregister.a.b.a(r7);
        this.k = r6;
        if (f.e() == (-1)) goto L5;
        boolean r8 = true;
    L6:
        this.B = r8;
        return;
    L5:
        r8 = false;
        goto L6
    }

    static /* synthetic */ int a(e r0, int r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ long a(long r0) {
        x = r0;
        return r0;
    }

    static /* synthetic */ long a(e r0, long r1) {
        r0.s = r1;
        return r1;
    }

    static /* synthetic */ q a(e r0) {
        return r0.z;
    }

    static /* synthetic */ q a(e r2, q r3) {
        q r4 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.memorydata.plugin");
        r2.z = r4;
        return r4;
    }

    private static String a(Context r2) {
        return g.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).b();
    L5:
        return null;
    }

    static /* synthetic */ String a(e r0, String r1) {
        r0.u = r1;
        return r1;
    }

    private void a() {
        long r0 = System.currentTimeMillis();
        SharedPreferences r2 = com.ss.android.deviceregister.a.b.a(this.n);
        this.l = r2.getInt("last_config_version", 0);
        this.u = r2.getString("install_id", "");
        boolean r3 = TextUtils.equals(u.c(this.n), r2.getString("dr_channel", null));
        if (this.l != u.c()) goto L14;
        if (r3 == false) goto L15;
        long r4 = r2.getLong("last_config_time", 0);
        if (r4 > r0) goto L9;
        r0 = r4;
    L9:
        boolean r5 = y.a(g());
        boolean r6 = y.a(h());
        if (r5 == true) goto L16;
        if (r6 == true) goto L17;
        this.r = r0;
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public static void a(Context r5, long r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (D.get() == null) goto L6;
        return;
    L6:
        if (com.bytedance.common.utility.h.a(a(r7)) == true) goto L8;
        return;
    L8:
        Object r0 = d;
        monitor-enter(r0);
    L35:
        th = move-exception;
        throw th;
    L11:
        if (i == false) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L35
        return;
    L15:
        if (com.bytedance.common.utility.h.a(a(r7)) == true) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L35
        return;
    L18:
        long r1 = 1500;
        if (j == false) goto L22;
        r1 = WifiScanStateMachine.SCAN_INTERVAL_WITH_THROTTLE_LEVEL_2_MS;
    L22:
        if (r6 != (-1)) goto L24;
    L39:
        r0.wait(r1);     // Catch: Exception -> L38 Throwable -> L35
    L32:
        i = true;     // Catch: Throwable -> L35
        monitor-exit(r0);     // Catch: Throwable -> L35
        return;
    L24:
        if (r6 <= 120000) goto L27;
        r6 = 120000;
    L29:
        r1 = r6;
        goto L39
    L27:
        if (r6 >= 0) goto L29;
        r6 = 1000;
        goto L29
    }

    public static void a(Bundle r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.size() <= 0) goto L17;
        Bundle r0 = h;
        monitor-enter(r0);
        r0.putAll(r1);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void a(i r2) {
        i r3 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin");
        e = r3;
        u.a(r3);
    }

    static /* synthetic */ void a(e r0, JSONObject r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(e r0, boolean r1) {
        r0.e(r1);
    }

    static /* synthetic */ void a(e r0, boolean r1, boolean r2) {
        r0.a(r1, r2);
    }

    public static void a(f.a r2) {
        f.a r3 = (f.a) ZeusTransformUtils.wrapperContextForParams(r2, f.a.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        C.add(new WeakReference(r3));
    }

    private void a(JSONObject r5) {
        if (f == null) goto L19;
        r5.put("pre_installed_channel", f.a(this.n));
    L19:
        int r1 = 0;
        PackageInfo r4 = this.n.getPackageManager().getPackageInfo(this.n.getPackageName(), 0);     // Catch: Throwable -> L16
        if (r4 == null) goto L21;
        r5.put("apk_first_install_time", r4.firstInstallTime);     // Catch: Throwable -> L16
        if ((r4.applicationInfo.flags & 1) != 1) goto L10;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L14;
        r1 = 1;
    L14:
        r5.put("is_system_app", r1);     // Catch: Throwable -> L16
        return;
    L10:
        r6 = false;
        goto L12
    L21:
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
    }

    private void a(boolean r5, boolean r6) {
        int r4 = C.size();
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L15;
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(C.get(r0), WeakReference.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L14;
        f.a r2 = (f.a) ZeusTransformUtils.preCheckCast(r1.get(), f.a.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L14;
        r2.a(r5, r6);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        r0 = r0 + 1;
        goto L3
    }

    static /* synthetic */ boolean a(e r0, Throwable r1) {
        return r0.a(r1);
    }

    private boolean a(Throwable r4) {
        if (ZeusTransformUtils.instanceOf(r4, CommonHttpException.class) == false) goto L15;
        int r5 = ((CommonHttpException) ZeusTransformUtils.preCheckCast(r4, CommonHttpException.class, "com.obric.memorydata.plugin")).getResponseCode();
        if (this.B == false) goto L8;
        return true;
    L8:
        if (r5 < 200) goto L15;
        if (r5 == 301) goto L15;
        if (r5 == 302) goto L15;
        return false;
    L15:
        return true;
    }

    static /* synthetic */ int b(e r0, int r1) {
        r0.l = r1;
        return r1;
    }

    static /* synthetic */ long b(e r0, long r1) {
        r0.t = r1;
        return r1;
    }

    static /* synthetic */ JSONObject b(e r0) {
        return r0.p;
    }

    private void b() {
        if (this.A != null) goto L5;
        this.A = new b(this.n);
    L5:
        this.E = new AnonymousClass2(this);
        com.ss.android.common.b.b.b("Retry#失败3次后监听网络请求");
        this.A.a(this.E);
    }

    static /* synthetic */ boolean b(boolean r0) {
        j = r0;
        return r0;
    }

    static /* synthetic */ long c(e r0, long r1) {
        r0.r = r1;
        return r1;
    }

    static /* synthetic */ Object c(e r0) {
        return r0.g;
    }

    private void c() {
        u.a(this.f15187b.b(), this.u);
        int r0 = C.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L15;
        WeakReference r2 = (WeakReference) ZeusTransformUtils.preCheckCast(C.get(r1), WeakReference.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L14;
        f.a r3 = (f.a) ZeusTransformUtils.preCheckCast(r2.get(), f.a.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L14;
        r3.a(this.f15187b.b(), this.u);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        r1 = r1 + 1;
        goto L3
    }

    static /* synthetic */ boolean c(boolean r0) {
        i = r0;
        return r0;
    }

    static /* synthetic */ boolean d(e r0) {
        return r0.B;
    }

    static /* synthetic */ boolean d(boolean r0) {
        F = r0;
        return r0;
    }

    static /* synthetic */ int e(e r2) {
        int r0 = r2.m;
        r2.m = r0 + 1;
        return r0;
    }

    private void e(boolean r5) {
        int r4 = C.size();
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L15;
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(C.get(r0), WeakReference.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L14;
        f.a r2 = (f.a) ZeusTransformUtils.preCheckCast(r1.get(), f.a.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L14;
        r2.a(r5);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        r0 = r0 + 1;
        goto L3
    }

    static /* synthetic */ int f(e r0) {
        return r0.l;
    }

    static /* synthetic */ long g(e r2) {
        return r2.r;
    }

    static /* synthetic */ long h(e r2) {
        return r2.s;
    }

    static /* synthetic */ int i(e r0) {
        return r0.m;
    }

    static /* synthetic */ void j(e r0) {
        r0.b();
    }

    static /* synthetic */ Context k(e r0) {
        return r0.n;
    }

    static /* synthetic */ String l(e r0) {
        return r0.w;
    }

    static /* synthetic */ b.a m(e r0) {
        return r0.E;
    }

    static /* synthetic */ boolean m() {
        return v;
    }

    static /* synthetic */ long n() {
        return q;
    }

    static /* synthetic */ b n(e r0) {
        return r0.A;
    }

    static /* synthetic */ SharedPreferences o(e r0) {
        return r0.o;
    }

    static /* synthetic */ boolean o() {
        return j;
    }

    static /* synthetic */ long p() {
        return x;
    }

    static /* synthetic */ String p(e r0) {
        return r0.u;
    }

    static /* synthetic */ Bundle q() {
        return h;
    }

    static /* synthetic */ void q(e r0) {
        r0.c();
    }

    static /* synthetic */ ThreadLocal r() {
        return D;
    }

    static /* synthetic */ Object s() {
        return d;
    }

    static /* synthetic */ h t() {
        return c;
    }

    public abstract void a(String r1, String r2);

    public void a(String r1, JSONObject r2) {
        i r0 = e;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    public void a(boolean r4) {
        this.u = null;
        this.k = r4;
        this.f15187b.b("device_id");
        this.f15187b.b("install_id");
        this.f15187b.b("clientudid");
        com.ss.android.deviceregister.a.b.a(this.n).edit().remove("install_id").apply();
        com.ss.android.deviceregister.d.a.b(this.n);
        JSONObject r0 = new JSONObject();
        u.g();
        u.a(this.n, r0, r4);
        this.p = r0;
    }

    public void a(boolean r3, long r4, q r6) {
        q r7 = (q) ZeusTransformUtils.wrapperContextForParams(r6, q.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
        this.k = r3;     // Catch: Throwable -> L11
        this.r = 0;     // Catch: Throwable -> L11
        this.t = 0;     // Catch: Throwable -> L11
        a r5 = this.y;     // Catch: Throwable -> L11
        if (r5 == null) goto L7;
        r5.f15190a = 0;     // Catch: Throwable -> L11
    L7:
        u.g();     // Catch: Throwable -> L11
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L11
        u.a(this.n, r8, j());     // Catch: Throwable -> L11
        this.p = r8;     // Catch: Throwable -> L11
        this.z = r7;     // Catch: Throwable -> L11
        l();     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass1(this), r4);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void e() {
        this.p = new JSONObject();
        a();
        if (u.a(this.n, this.p, j()) == false) goto L5;
    L9:
        a r0 = new a(this);
        this.y = r0;
        r0.start();
        return;
    L5:
        if (Logger.debug() == false) goto L9;
        throw new RuntimeException("init header error.");
    }

    public void f() {
        a r0 = this.y;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a();
    }

    public String g() {
        return this.f15187b.b();
    }

    public String h() {
        return this.u;
    }

    public String i() {
        if (j() == false) goto L7;
        return "";
    L7:
        return this.f15187b.a(true);
    }

    public boolean j() {
        return this.k;
    }

    public String k() {
        return this.f15187b.a();
    }

    public void l() {
        Object r0 = this.g;
        monitor-enter(r0);
        this.g.notifyAll();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
