package lta;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.applog.c0;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import jta.g$a;
import jta.n;
import kta.j;
import kta.u;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class h {
    public static final ThreadLocal<Boolean> A = null;
    public static final Object r = null;
    public static j s;
    public static final Bundle t = null;
    public static volatile boolean u;
    public static volatile boolean v;
    public static volatile boolean w;
    public static long x;
    public static volatile long y;
    public static final List<WeakReference<g$a>> z = null;
    public final Object a;
    public volatile boolean b;
    public int c;
    public volatile int d;
    public final mta.a e;
    public final Context f;
    public final SharedPreferences g;
    public JSONObject h;
    public long i;
    public long j;
    public String k;
    public a l;
    public volatile n m;
    public b n;
    public final boolean o;
    public final jta.i p;
    public g q;

    public class a extends PthreadThreadV2 {
        public int v;
        public final /* synthetic */ h w;

        public final void l() {
            super.run();
            Throwable r3 = null;
            String r0 = this.w.h.optString("device_id", null);
            h r2 = this.w;
            int r4 = 1;
            boolean r5 = !StringUtils.isEmpty(r0);
            r2.getClass();
            int r6 = h.z.size();
            int r7 = 0;
        L3:
            if (r7 >= r6) goto L15;
            WeakReference r1 = (WeakReference) ListProtector.get(h.z, r7);
            if (r1 == null) goto L14;
            g$a r8 = (g$a) r1.get();
            if (r8 == null) goto L14;
            r8.onDidLoadLocally(r5);     // Catch: Exception -> L12
        L12:
            e = move-exception;
            e.printStackTrace();
        L14:
            r7 = r7 + 1;
        L15:
            Object r9 = h.r;
            if (h.w == true) goto L18;
        L24:
            boolean r10 = false;
        L25:
            if (r10 == true) goto L26;
            long r11 = System.currentTimeMillis();
            if (this.w.c != u.e()) goto L43;
            boolean r12 = true;
        L45:
            if (lta.a.b == false) goto L47;
        L50:
            long r13 = 21600000;
        L51:
            if (r12 == false) goto L53;
            long r14 = 180000;
        L55:
            if (c0.f(this.w.c()) == false) goto L57;
        L60:
            boolean r15 = true;
        L61:
            if (r15 == false) goto L69;
            boolean r16 = NetworkUtils.isNetworkAvailable(this.w.f);
            int r17 = this.v;
            if (r16 == false) goto L65;
            int r18 = 3;
        L66:
            if (r17 <= r18) goto L68;
            r15 = true;
            goto L69
        L68:
            r15 = false;
            goto L69
        L65:
            r18 = 10;
        L69:
            if (r15 == false) goto L71;
            int r19 = this.v + r4;
            this.v = r19;
        L72:
            long r20 = r19;
            if (r20 == 0) goto L75;
            r14 = 4000 * r20;
        L75:
            h r21 = this.w;
            long r22 = r13 - (r11 - r21.i);
            long r110 = r14 - (r11 - r21.j);
            if (r22 > 0) goto L78;
        L80:
            long r23 = Math.max(r22, r110);
            h r24 = this.w;
            if (r24.o == true) goto L83;
        L85:
            r13 = r23;
        L87:
            if (Logger.debug() == true) goto L89;
            Throwable r25 = null;
        L94:
            Object r26 = this.w.a;
            monitor-enter(r26);
            if (r13 > 0) goto L118;
        L102:
            Object r27 = h.r;     // Catch: Throwable -> L116
            monitor-exit(r26);     // Catch: Throwable -> L116
            monitor-enter(this);
            n();     // Catch: Throwable -> L111
            h r28 = this.w;     // Catch: Throwable -> L111
            if (r28.o == false) goto L108;
            r4 = 1;
            r28.d++;     // Catch: Throwable -> L111
        L109:
            monitor-exit(this);     // Catch: Throwable -> L111
            r3 = r25;
            goto L15
        L108:
            r4 = 1;
        L111:
            th = move-exception;
            throw th;
        L118:
            this.w.a.wait(r13);     // Catch: InterruptedException -> L100 Throwable -> L116
        L100:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L116
        L116:
            th = move-exception;
            throw th;
        L89:
            if (r13 < 0) goto L92;
            r11 = r11 + r13;
        L92:
            r25 = null;
            ita.j.b("RegisterServiceController next query time : " + DateFormat.getDateTimeInstance().format(new Date(r11)), null);
            goto L94
        L83:
            if (r24.d != jta.g.h) goto L85;
            h.a(this.w);
            this.w.d = 0;
            goto L87
        L78:
            if (r21.o == false) goto L80;
            r21.d = 0;
            goto L80
        L71:
            r19 = 0;
            goto L72
        L57:
            if (c0.f(this.w.k) == true) goto L60;
            r15 = false;
            goto L61
        L53:
            r14 = 30000;
            goto L55
        L47:
            if (h.x >= 0) goto L50;
            if (r12 == false) goto L50;
            r13 = 43200000;
            goto L51
        L43:
            r12 = false;
            goto L45
        L26:
            Object r29 = this.w.a;
            monitor-enter(r29);
            if (Logger.debug() == false) goto L126;
            ita.j.b("RegisterServiceController throttle by applog/settings sThrottleByAppLogConfig=" + h.w + " did=" + this.w.c() + " iid=" + this.w.k, r3);     // Catch: Throwable -> L37
        L126:
            this.w.a.wait(TimeUnit.MINUTES.toMillis(1));     // Catch: InterruptedException -> L33 Throwable -> L37
        L35:
            monitor-exit(r29);     // Catch: Throwable -> L37
            goto L15
        L33:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L37
        L37:
            th = move-exception;
            throw th;
        L18:
            if (c0.f(this.w.c()) == true) goto L24;
            if (c0.f(this.w.k) == true) goto L24;
            if (this.w.c != u.e()) goto L24;
            r10 = true;
            goto L25
        }

        public final void n() {
            if (h.v == false) goto L5;
            return;
        L5:
            jta.g r0 = jta.g.a;
            long r1 = System.currentTimeMillis();     // Catch: Exception -> L98
            if (h.y > 0) goto L9;
            h.y = r1;     // Catch: Exception -> L98
        L9:
            h r2 = this.w;     // Catch: Exception -> L98
            r2.j = r1;     // Catch: Exception -> L98
            if (NetworkUtils.isNetworkAvailable(r2.f) == true) goto L13;
            com.ss.android.common.applog.e.a().b(StatsCountKeys.NO_NETWORK_COUNT, 1);     // Catch: Exception -> L98
            h.a(this.w);     // Catch: Exception -> L98
            return;
        L13:
            Context r3 = this.w.f;     // Catch: Exception -> L98
            if (StringUtils.isEmpty(u.k) == false) goto L16;
            u.k = r3.getSharedPreferences(kta.b.a, 0).getString("user_agent", null);     // Catch: Exception -> L98
        L16:
            String r4 = u.k;     // Catch: Exception -> L98
            if (StringUtils.isEmpty(r4) == true) goto L19;
            this.w.h.put("user_agent", r4);     // Catch: Exception -> L98
        L19:
            this.w.getClass();     // Catch: Exception -> L98
            if (StringUtils.isEmpty(null) == true) goto L22;
            this.w.h.put("app_track", null);     // Catch: Exception -> L98
        L22:
            JSONObject r5 = new JSONObject(new JSONTokener(this.w.h.toString()));     // Catch: Exception -> L98
            r5.put("req_id", jta.g.j.getRequestId());     // Catch: Exception -> L98
            if (this.w.b == false) goto L25;
            r5.put("scene", 2);     // Catch: Exception -> L98
        L25:
            r5.put("device_platform", "android");     // Catch: Exception -> L98
            lta.b.a(r5);     // Catch: Exception -> L98
            Bundle r6 = new Bundle();     // Catch: Throwable -> L57
            Bundle r7 = h.t;     // Catch: Throwable -> L57
            monitor-enter(r7);     // Catch: Throwable -> L57
            r6.putAll(r7);     // Catch: Throwable -> L54
            monitor-exit(r7);     // Catch: Throwable -> L54
        L31:
            if (r6.size() <= 0) goto L38;
            JSONObject r8 = new JSONObject();     // Catch: Throwable -> L57
            Iterator<String> r9 = r6.keySet().iterator();     // Catch: Throwable -> L57
        L34:
            if (r9.hasNext() == false) goto L36;
            String r10 = r9.next();     // Catch: Throwable -> L57
            r8.put(r10, r6.get(r10));     // Catch: Throwable -> L57
            goto L34
        L36:
            r5.put("custom", r8);     // Catch: Throwable -> L57
        L38:
            if (TextUtils.isEmpty(null) == true) goto L41;
            r5.put("app_trait", null);     // Catch: Throwable -> L57
        L41:
            if (this.w.b == true) goto L48;
            if (jta.g.g(this.w.f) == true) goto L48;
            if (jta.g.f == true) goto L48;
            Context r11 = this.w.f;     // Catch: Throwable -> L57
        L48:
            if (StringUtils.isEmpty(null) == true) goto L51;
            r5.put("app_language", null);     // Catch: Throwable -> L57
        L51:
            if (StringUtils.isEmpty(null) == true) goto L58;
            r5.put("app_region", null);     // Catch: Throwable -> L57
        L58:
            h r12 = this.w;     // Catch: Exception -> L98
            r12.getClass();     // Catch: Exception -> L98
            PackageInfo r13 = r12.f.getPackageManager().getPackageInfo(r12.f.getPackageName(), 0);     // Catch: Throwable -> L67
            if (r13 == null) goto L69;
            r5.put("apk_first_install_time", r13.firstInstallTime);     // Catch: Throwable -> L67
            if ((r13.applicationInfo.flags & 1) != 1) goto L64;
            int r14 = 1;
        L65:
            r5.put("is_system_app", r14);     // Catch: Throwable -> L67
        L64:
            r14 = 0;
        L69:
            r5.put("sdk_version", "3.10.6");     // Catch: Exception -> L98
            r5.put("sdk_flavor", "china");     // Catch: Exception -> L98
            if (jta.g.f == false) goto L72;
            int r15 = 1;
        L73:
            r5.put("guest_mode", r15);     // Catch: Exception -> L98
            u.b(r5);     // Catch: Exception -> L98
            JSONObject r16 = new JSONObject();     // Catch: Exception -> L98
            r16.put("magic_tag", "ss_app_log");     // Catch: Exception -> L98
            r16.put("header", r5);     // Catch: Exception -> L98
            r16.put("_gen_time", System.currentTimeMillis());     // Catch: Exception -> L98
            h.v = true;     // Catch: Exception -> L98
            h.A.set(Boolean.TRUE);     // Catch: Exception -> L98
            boolean r17 = m(r16.toString(), r5);     // Catch: Exception -> L98
            if (r17 == false) goto L83;
            System.currentTimeMillis();     // Catch: Exception -> L98
            if (h.y <= 0) goto L78;
            h.y = 0;     // Catch: Exception -> L98
        L78:
            h r18 = this.w;     // Catch: Exception -> L98
            g r19 = r18.q;     // Catch: Exception -> L98
            if (r19 == null) goto L83;
            b r20 = r18.n;     // Catch: Exception -> L98
            if (r20 == null) goto L83;
            r20.b(r19);     // Catch: Exception -> L98
        L83:
            Object r21 = h.r;     // Catch: Exception -> L98
            monitor-enter(r21);     // Catch: Exception -> L98
            h.v = false;     // Catch: Throwable -> L95
            r21.notifyAll();     // Catch: Exception -> L88 Throwable -> L95
        L90:
            monitor-exit(r21);     // Catch: Throwable -> L95
            h.u = true;     // Catch: Exception -> L98
            h.A.remove();     // Catch: Exception -> L98
            if (r17 == true) goto L112;
            String r22 = ((jta.a) this.w.e).c();     // Catch: Exception -> L98
            h.b(this.w, false, StringUtils.isEmpty(r22));     // Catch: Exception -> L98
            return;
        L112:
            return;
        L88:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L95
        L95:
            th = move-exception;
            throw th;     // Catch: Exception -> L98
        L72:
            r15 = 0;
        L67:
            th = move-exception;
            th.printStackTrace();     // Catch: Exception -> L98
        L54:
            th = move-exception;
            throw th;     // Catch: Throwable -> L57
        L57:
            com.ss.android.common.applog.e.a().b(StatsCountKeys.JSON_ERROR_COUNT, 1);     // Catch: Exception -> L98
        L98:
            e = move-exception;
            e.printStackTrace();
        }

        public final void run() {
            l();     // Catch: Throwable -> L4
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(e r1) {
            this.w = r1;
            super("DeviceRegisterThread");
            this.v = 0;
        }

        public final boolean o(JSONObject r18) {
            this.w.c = u.e();
            r18.optInt("new_user", 0);
            Object r2 = h.r;
            SharedPreferences.Editor r3 = this.w.g.edit();
            r3.putInt("last_config_version", this.w.c);
            r3.putString("dr_channel", u.c(this.w.f));
            h r4 = this.w;
            String r5 = r4.k;
            String r6 = ((jta.a) r4.e).c();
            boolean r7 = StringUtils.isEmpty(r6);
            String r8 = r18.optString("install_id", null);
            String r9 = r18.optString("device_id", null);
            String r10 = r18.optString("device_token", "");
            String r0 = r18.optString("klink_egdi", "");
            boolean r11 = c0.f(r9);
            boolean r12 = c0.f(r8);
            c0.f(r0);
            jta.g r13 = jta.g.a;
            if (r11 == true) goto L7;
            if (r12 == true) goto L7;
            this.w.i = System.currentTimeMillis();
            r3.putLong("last_config_time", this.w.i);
        L7:
            if (r12 == false) goto L9;
        L18:
            boolean r14 = false;
        L19:
            if (r11 == false) goto L21;
        L45:
            if (r11 == false) goto L47;
            Object r15 = h.r;
        L47:
            if (r14 == true) goto L89;
        L51:
            r3.putString("device_token", r10);
            r3.commit();
            if (r14 == false) goto L84;
            jta.a r1 = (jta.a) this.w.e;
            r1.getClass();
            if (c0.f(r9) == false) goto L56;
        L59:
            h r16 = this.w;
            String r17 = ((jta.a) r16.e).c();
            String r19 = r16.k;
            Object r20 = u.m;
            monitor-enter(r20);
        L81:
            th = move-exception;
            throw th;
        L62:
            if (u.i != null) goto L99;
        L67:
            monitor-exit(r20);     // Catch: Throwable -> L81
            int r21 = h.z.size();
            int r22 = 0;
        L69:
            if (r22 >= r21) goto L84;
            WeakReference r23 = (WeakReference) ListProtector.get(h.z, r22);
            if (r23 == null) goto L80;
            g$a r24 = (g$a) r23.get();
            if (r24 == null) goto L80;
            r24.onDeviceRegistrationInfoChanged(((jta.a) r16.e).c(), r16.k);     // Catch: Exception -> L78
        L78:
            e = move-exception;
            e.printStackTrace();
        L80:
            r22 = r22 + 1;
            goto L69
        L99:
            u.i.put("device_id", r17);     // Catch: JSONException -> L65 Throwable -> L81
            u.i.put("install_id", r19);     // Catch: JSONException -> L65 Throwable -> L81
        L65:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L81
            goto L67
        L56:
            if (StringUtils.equal(r9, jta.a.g) == true) goto L59;
            jta.a.g = r1.b.d(r9, jta.a.g);
        L84:
            h.b(this.w, true, r7);
            if (this.w.m == null) goto L88;
            new Handler(Looper.getMainLooper()).post(new a(this, r9, r8));
        L88:
            return !r11;
        L89:
            h r25 = this.w;     // Catch: Exception -> L50
            r25.h.put("install_id", r25.k);     // Catch: Exception -> L50
            this.w.h.put("device_id", r9);     // Catch: Exception -> L50
            this.w.h.put("klink_egdi", r0);     // Catch: Exception -> L50
            r3.putString("install_id", this.w.k);     // Catch: Exception -> L50
            r3.putString("device_id", r9);     // Catch: Exception -> L50
            r3.putString("klink_egdi", r0);     // Catch: Exception -> L50
            goto L51
        L21:
            if (r9.equals(r6) == true) goto L45;
            e r26 = (e) this.w;
            r26.getClass();
            if (StringUtils.isEmpty(r6) == false) goto L95;
        L44:
            r14 = true;
            goto L45
        L95:
            JSONObject r110 = new JSONObject();     // Catch: Exception -> L43
            String r111 = r26.e();     // Catch: Exception -> L43
            if (jta.g.f == true) goto L39;
            String r112 = ((jta.e) r26.e).g();     // Catch: Exception -> L43
            String r113 = ((jta.e) r26.e).e();     // Catch: Exception -> L43
            if (StringUtils.isEmpty(r112) == true) goto L30;
            r110.put("udid", r112);     // Catch: Exception -> L43
        L30:
            if (StringUtils.isEmpty(r113) == true) goto L33;
            r110.put("serial_number", r113);     // Catch: Exception -> L43
        L33:
            if ((!u.p) == false) goto L39;
            String[] r27 = ((jta.e) r26.e).f();     // Catch: Exception -> L43
            if (r27 == null) goto L39;
            if (r27.length <= 0) goto L39;
            r110.put("sim_serial_number", Arrays.toString(r27));     // Catch: Exception -> L43
        L39:
            String r28 = ((jta.a) r26.e).b();     // Catch: Exception -> L43
            r110.put("old_id", r6);     // Catch: Exception -> L43
            r110.put("new_id", r9);     // Catch: Exception -> L43
            r110.put("openudid", r111);     // Catch: Exception -> L43
            r110.put("clientudid", r28);     // Catch: Exception -> L43
            if (h.s == null) goto L44;
            AppLogNewUtils.onEventV3("did_change", r110);     // Catch: Exception -> L43
            goto L44
        L9:
            if (r8.equals(this.w.k) == true) goto L18;
            this.w.k = r8;
            if (StringUtils.isEmpty(r5) == false) goto L97;
        L17:
            r14 = true;
            goto L19
        L97:
            JSONObject r114 = new JSONObject();     // Catch: Exception -> L16
            r114.put("old_id", r5);     // Catch: Exception -> L16
            r114.put("new_id", r8);     // Catch: Exception -> L16
            this.w.getClass();     // Catch: Exception -> L16
            if (h.s == null) goto L17;
            AppLogNewUtils.onEventV3("iid_change", r114);     // Catch: Exception -> L16
            goto L17
        }

        public final boolean m(String r26, JSONObject r27) {
            ita.j.b("RegisterServiceController app_log_config: " + r26, null);     // Catch: Throwable -> L70
            byte[] r3 = r26.getBytes("UTF-8");     // Catch: Throwable -> L70
            h r0 = this.w;     // Catch: Throwable -> L70
            System.currentTimeMillis();     // Catch: Throwable -> L70
            r0.getClass();     // Catch: Throwable -> L70
            String[] r1 = lta.a.a;     // Catch: Throwable -> L70
            if (r1 != null) goto L6;
        L10:
            String[] r2 = {"https://ib.snssdk.com/service/2/device_register/", "https://ib.snssdk.com/service/2/device_register/"};     // Catch: Throwable -> L70
        L11:
            String[] r15 = r2;
            if (r15 == null) goto L69;
            int r13 = r15.length;     // Catch: Throwable -> L70
            int r12 = 0;
        L14:
            if (r12 >= r13) goto L67;
            String r7 = r15[r12];     // Catch: Throwable -> L70
            byte[] r18 = (byte[]) r3.clone();     // Catch: Throwable -> L70
            if (StringUtils.isEmpty(r7) == false) goto L19;
            r12 = r12;
            r13 = r13;
        L65:
            r12 = r12 + 1;     // Catch: Throwable -> L70
            r13 = r13;
            goto L14
        L19:
            if (Logger.debug() == false) goto L22;
            ita.j.b("RegisterServiceController request url : " + r7, null);     // Catch: Throwable -> L70
        L22:
            if (TextUtils.isEmpty(r27.optString("device_id")) == false) goto L24;
        L27:
            boolean r4 = true;
        L71:
            if (r7.indexOf(63) >= 0) goto L32;
            String r6 = r7 + "?";     // Catch: Throwable -> L35 RuntimeException -> L37
        L33:
            String r5 = c0.h(null, r6, r18, this.w.f, false, null, null, r4, false);     // Catch: Throwable -> L35 RuntimeException -> L37
        L73:
            ita.j.f("device_register response: " + r5);     // Catch: Throwable -> L50
            if (r5 != null) goto L43;
        L48:
            com.ss.android.common.applog.e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);     // Catch: Throwable -> L50
            goto L65
        L43:
            if (r5.length() == 0) goto L48;
            if (o(new JSONObject(r5)) == false) goto L65;
            return true;
        L50:
            th = th;
        L51:
            com.ss.android.common.applog.e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);     // Catch: Throwable -> L70
            h r8 = this.w;     // Catch: Throwable -> L70
            r8.getClass();     // Catch: Throwable -> L70
            if ((th instanceof CommonHttpException) == false) goto L63;
            int r9 = ((CommonHttpException) th).getResponseCode();     // Catch: Throwable -> L70
            if (r8.o == true) goto L63;
            if (r9 < 200) goto L63;
            if (r9 == 301) goto L63;
            if (r9 == 302) goto L63;
            boolean r10 = false;
        L64:
            if (r10 == true) goto L65;
            throw th;     // Catch: Throwable -> L70
        L63:
            r10 = true;
            goto L64
        L32:
            r6 = r7 + "&";     // Catch: Throwable -> L35 RuntimeException -> L37
            goto L33
        L37:
            com.ss.android.common.applog.e.a().b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);     // Catch: Throwable -> L35
            r5 = c0.e(null, r7, r3, true, "application/json; charset=utf-8", null, r4, false);     // Catch: Throwable -> L50
        L35:
            th = th;
            r12 = r12;
            r13 = r13;
            goto L51
        L24:
            if (TextUtils.isEmpty(r27.optString("install_id")) == true) goto L27;
            r4 = false;
            goto L71
        L67:
            return false;
        L69:
            throw new IllegalArgumentException("url is null");     // Catch: Throwable -> L70
        L6:
            if (r1.length <= 0) goto L10;
            if (StringUtils.isEmpty(r1[0]) == true) goto L10;
            r2 = lta.a.a;     // Catch: Throwable -> L70
        L70:
            return false;
        }
    }

    public static class b {
        public final Set<WeakReference<a>> a;
        public final AtomicBoolean b;
        public final Context c;

        public interface a {
            void onNetworkReady();
        }

        public b(Context r3) {
            this.a = Collections.synchronizedSet(new HashSet());
            this.b = new AtomicBoolean(false);
            this.c = r3;
        }

        public final synchronized void b(g r3) {
            monitor-enter(this);
            Iterator<WeakReference<a>> r0 = this.a.iterator();     // Catch: Throwable -> L14
        L5:
            if (r0.hasNext() == false) goto L12;
            WeakReference<a> r1 = r0.next();     // Catch: Throwable -> L14
            if (r1 == null) goto L8;
            if (r1.get() != r3) goto L5;
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

        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
        public static void a(Context r8, i r9, IntentFilter r10) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        L39:
        L33:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
            ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
            return;
        L38:
            throw e;
        L6:
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
            if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L22;
            int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8).result;     // Catch: Exception -> L33
            if (r0 != 1) goto L12;
            r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
            return;
        L12:
            if (r0 != 2) goto L14;
            new Intent();     // Catch: Exception -> L33
            return;
        L14:
            if (r0 == 3) goto L40;
            r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
            return;
        L40:
            return;
        L22:
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
            ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
            r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
            return;
        L26:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
        L31:
            r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
            return;
        L28:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L31;
            ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
            ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
        }
    }

    static {
        r = new Object();
        t = new Bundle();
        u = false;
        v = false;
        w = false;
        x = 0;
        z = Collections.synchronizedList(new ArrayList());
        A = new ThreadLocal();
    }

    public final String c() {
        return ((jta.a) this.e).c();
    }

    public final String d() {
        jta.i r0 = this.p;
        if (TextUtils.isEmpty(r0.a) == false) goto L7;
        ita.j.e("[egdi] get egdi from sp.");
        String r1 = r0.b.getString("klink_egdi", "");
        r0.a = r1;
        return r1;
    L7:
        return r0.a;
    }

    public final String e() {
        if (this.b == false) goto L6;
        return "";
    L6:
        jta.a r0 = (jta.a) this.e;
        r0.getClass();
        if (StringUtils.isEmpty(jta.a.e) == false) goto L48;
        Context r2 = r0.a;
        pta.c.a r3 = pta.c.a;
        String r4 = pta.c.e(r2.getContentResolver());     // Catch: Exception -> L12
    L15:
        if (r4 != null) goto L43;
    L20:
        SharedPreferences r5 = r0.a.getSharedPreferences(kta.b.a(), 0);     // Catch: Exception -> L33
        String r6 = r5.getString("openudid", null);     // Catch: Exception -> L33
        if (pta.b.b(r6) == true) goto L32;
        r6 = new BigInteger(80, new SecureRandom()).toString(16);     // Catch: Exception -> L33
        if (r6.charAt(0) != '-') goto L25;
        r6 = r6.substring(1);     // Catch: Exception -> L33
    L25:
        int r7 = 13 - r6.length();     // Catch: Exception -> L33
        if (r7 <= 0) goto L31;
        StringBuilder r8 = new StringBuilder();     // Catch: Exception -> L33
    L28:
        if (r7 <= 0) goto L30;
        r8.append('F');     // Catch: Exception -> L33
        r7 = r7 - 1;     // Catch: Exception -> L33
        goto L28
    L30:
        r8.append(r6);     // Catch: Exception -> L33
        r6 = r8.toString();     // Catch: Exception -> L33
    L31:
        SharedPreferences.Editor r9 = r5.edit();     // Catch: Exception -> L33
        r9.putString("openudid", r6);     // Catch: Exception -> L33
        r9.commit();     // Catch: Exception -> L33
    L33:
        e = move-exception;
        ita.j.c("DeviceParamsProviderexception when making openudid: ", e);
    L36:
        if (StringUtils.isEmpty(r4) == true) goto L38;
        String r1 = r4 + r0.d;
    L40:
        if (StringUtils.isEmpty(r1) == true) goto L49;
        jta.a.e = r1;
        return r1;
    L49:
        return r1;
    L38:
        r1 = r4;
    L32:
        r4 = r6;
        goto L36
    L43:
        if (r4.equals("9774d56d682e549c") == true) goto L20;
        if (r4.length() >= 13) goto L36;
    L12:
        e = move-exception;
        e.printStackTrace();
        r4 = null;
        goto L15
    L48:
        return jta.a.e;
    }

    public final void f() {
        Object r0 = this.a;
        monitor-enter(r0);
        this.a.notifyAll();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void a(h r3) {
        if (r3.n != null) goto L5;
        r3.n = new b(r3.f);
    L5:
        r3.q = new g(r3);
        b r0 = r3.n;
        g r4 = r3.q;
        monitor-enter(r0);
        r0.a.add(new WeakReference(r4));     // Catch: Throwable -> L16
        if (r0.b.compareAndSet(false, true) == false) goto L14;
        i r5 = new i(r0);     // Catch: Throwable -> L16
        IntentFilter r1 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L16
        b.a(r0.c, r5, r1);     // Catch: Exception -> L12 Throwable -> L16
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
    L14:
        monitor-exit(r0);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public h(Context r3, boolean r4) {
        this.a = new Object();
        this.i = 0;
        this.j = 0;
        this.f = r3;
        this.e = jta.h.a(r3);
        boolean r1 = false;
        this.g = r3.getSharedPreferences(kta.b.a, 0);
        this.b = r4;
        if (jta.g.h == (-1)) goto L5;
        r1 = true;
    L5:
        this.o = r1;
        this.p = new jta.i(r3);
    }

    public static void g(Context r6, long r7) {
        if (A.get() == null) goto L5;
        return;
    L5:
        String r0 = null;
        String r1 = ((jta.a) jta.h.a(r6)).c();     // Catch: Exception -> L8
    L10:
        if (StringUtils.isEmpty(r1) == true) goto L12;
        return;
    L12:
        Object r2 = r;
        monitor-enter(r2);
    L41:
        th = move-exception;
        throw th;
    L15:
        if (u == false) goto L46;
        monitor-exit(r2);     // Catch: Throwable -> L41
        return;
    L46:
        r0 = ((jta.a) jta.h.a(r6)).c();     // Catch: Exception -> L44 Throwable -> L41
    L20:
        if (StringUtils.isEmpty(r0) == true) goto L24;
        monitor-exit(r2);     // Catch: Throwable -> L41
        return;
    L24:
        if (v == false) goto L26;
        long r3 = 4000;
    L28:
        if (r7 != (-1)) goto L30;
    L49:
        r2.wait(r3);     // Catch: Exception -> L45 Throwable -> L41
    L38:
        u = true;     // Catch: Throwable -> L41
        monitor-exit(r2);     // Catch: Throwable -> L41
        return;
    L30:
        if (r7 <= 120000) goto L33;
        r7 = 120000;
    L35:
        r3 = r7;
        goto L49
    L33:
        if (r7 >= 0) goto L35;
        r7 = 1000;
        goto L35
    L26:
        r3 = 1500;
    L8:
        r1 = null;
        goto L10
    }

    public static void b(h r2, boolean r3, boolean r4) {
        r2.getClass();
        int r5 = z.size();
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L15;
        WeakReference r1 = (WeakReference) ListProtector.get(z, r0);
        if (r1 == null) goto L14;
        g$a r6 = (g$a) r1.get();
        if (r6 == null) goto L14;
        r6.onRemoteConfigUpdate(r3, r4);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        r0 = r0 + 1;
        goto L3
    }
}
