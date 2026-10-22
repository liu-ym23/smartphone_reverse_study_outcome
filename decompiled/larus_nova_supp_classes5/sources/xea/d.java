package xea;

import android.app.Application;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ttnet.TTNetInit;
import com.larus.apm.api.IApmTrace;
import com.larus.common.apphost.AppHost;
import com.larus.network.util.ScreenStateManager;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.platform.depend.IRuntimeContext;
import com.obric.assistant.ObricNetworkInterceptConfig;
import com.obric.assistant.common.spi.network.IObricBackgroundNetworkBlockService;
import com.obric.assistant.os.libs.NetworkCapability;
import com.obric.assistant.os.libs.NetworkInfo;
import com.obric.assistant.os.libs.NetworkStateInfo;
import com.obric.assistant.os.libs.VipStrategyReport;
import com.obric.assistant.t1;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import hm9.j;
import hm9.s;
import ita.k;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d {
    public static volatile a a;
    public static volatile long b;
    public static volatile ObricNetworkInterceptConfig c;
    public static volatile long d;
    public static final Object e = null;
    public static final AtomicBoolean f = null;
    public static final ExecutorService g = null;
    public static final c h = null;
    public static final Lazy i = null;
    public static final b j = null;

    public static final class a {
        public final int A;
        public final int B;
        public final int C;
        public final String a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final boolean f;
        public final boolean g;
        public final boolean h;
        public final boolean i;
        public final boolean j;
        public final boolean k;
        public final boolean l;
        public final int m;
        public final String n;
        public final int o;
        public final int p;
        public final int q;
        public final int r;
        public final int s;
        public final int t;
        public final int u;
        public final int v;
        public final int w;
        public final int x;
        public final boolean y;
        public final int z;

        public a() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L45;
            return false;
        L45:
            if (this.m == r6.m) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
            return false;
        L51:
            if (this.o == r6.o) goto L54;
            return false;
        L54:
            if (this.p == r6.p) goto L57;
            return false;
        L57:
            if (this.q == r6.q) goto L60;
            return false;
        L60:
            if (this.r == r6.r) goto L63;
            return false;
        L63:
            if (this.s == r6.s) goto L66;
            return false;
        L66:
            if (this.t == r6.t) goto L69;
            return false;
        L69:
            if (this.u == r6.u) goto L72;
            return false;
        L72:
            if (this.v == r6.v) goto L75;
            return false;
        L75:
            if (this.w == r6.w) goto L78;
            return false;
        L78:
            if (this.x == r6.x) goto L81;
            return false;
        L81:
            if (this.y == r6.y) goto L84;
            return false;
        L84:
            if (this.z == r6.z) goto L87;
            return false;
        L87:
            if (this.A == r6.A) goto L90;
            return false;
        L90:
            if (this.B == r6.B) goto L93;
            return false;
        L93:
            if (this.C == r6.C) goto L95;
            return false;
        L95:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
            int r2 = 1231;
            if (this.f == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.g == false) goto L9;
            int r4 = 1231;
        L10:
            int r5 = (r3 + r4) * 31;
            if (this.h == false) goto L13;
            int r6 = 1231;
        L14:
            int r7 = (r5 + r6) * 31;
            if (this.i == false) goto L17;
            int r8 = 1231;
        L18:
            int r9 = (r7 + r8) * 31;
            if (this.j == false) goto L21;
            int r10 = 1231;
        L22:
            int r11 = (r9 + r10) * 31;
            if (this.k == false) goto L25;
            int r12 = 1231;
        L26:
            int r13 = (r11 + r12) * 31;
            if (this.l == false) goto L29;
            int r14 = 1231;
        L30:
            int r15 = (((((((((((((((((((((((((r13 + r14) * 31) + this.m) * 31) + this.n.hashCode()) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r) * 31) + this.s) * 31) + this.t) * 31) + this.u) * 31) + this.v) * 31) + this.w) * 31) + this.x) * 31;
            if (this.y == true) goto L35;
            r2 = 1237;
        L35:
            return ((((((((r15 + r2) * 31) + this.z) * 31) + this.A) * 31) + this.B) * 31) + this.C;
        L29:
            r14 = 1237;
            goto L30
        L25:
            r12 = 1237;
            goto L26
        L21:
            r10 = 1237;
            goto L22
        L17:
            r8 = 1237;
            goto L18
        L13:
            r6 = 1237;
            goto L14
        L9:
            r4 = 1237;
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "OsNetworkCache(osCapabilityType=" + this.a + ", osNetworkFreq=" + this.b + ", osNetworkRssi=" + this.c + ", osNetworkLinkSpeed=" + this.d + ", osNetworkRxLinkSpeed=" + this.e + ", osIsIdleMode=" + this.f + ", osIsPowerSaveMode=" + this.g + ", osIsSleepMode=" + this.h + ", isVipNetworkFeatureEnabled=" + this.i + ", isWifiAccelEnabled=" + this.j + ", isSuperStableEnabled=" + this.k + ", isVipChannelEnabled=" + this.l + ", rateStrategyType=" + this.m + ", foregroundAppPkg=" + this.n + ", foregroundRateLimit=" + this.o + ", vipChannelRateLimit=" + this.p + ", backgroundRateLimit=" + this.q + ", foregroundThroughput=" + this.r + ", vipChannelThroughput=" + this.s + ", backgroundThroughput=" + this.t + ", doubaoRtt=" + this.u + ", doubaoAvgRttFiveSec=" + this.v + ", doubaoMaxRttFiveSec=" + this.w + ", doubaoMinRttFiveSec=" + this.x + ", isVpnEnabled=" + this.y + ", wifiCurrentThroughput=" + this.z + ", wifiRtt=" + this.A + ", cellularThroughput=" + this.B + ", cellularRtt=" + this.C + ')';
        }

        public /* synthetic */ a(int r31) {
            this("UNKNOWN", -1, -1, -1, -1, false, false, false, false, false, false, false, -1, "UNKNOWN", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, false, -1, -1, -1, -1);
        }

        public a(String r5, int r6, int r7, int r8, int r9, boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, int r17, String r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, boolean r29, int r30, int r31, int r32, int r33) {
            Intrinsics.checkNotNullParameter(r5, "osCapabilityType");
            Intrinsics.checkNotNullParameter(r18, "foregroundAppPkg");
            this.a = r5;
            this.b = r6;
            this.c = r7;
            this.d = r8;
            this.e = r9;
            this.f = r10;
            this.g = r11;
            this.h = r12;
            this.i = r13;
            this.j = r14;
            this.k = r15;
            this.l = r16;
            this.m = r17;
            this.n = r18;
            this.o = r19;
            this.p = r20;
            this.q = r21;
            this.r = r22;
            this.s = r23;
            this.t = r24;
            this.u = r25;
            this.v = r26;
            this.w = r27;
            this.x = r28;
            this.y = r29;
            this.z = r30;
            this.A = r31;
            this.B = r32;
            this.C = r33;
        }
    }

    public static final class b implements wea.a {
        public b() {
        }

        @Override // wea.a
        public final void a(Long r12, Long r13, String r14, String r15, String r16, Integer r17, JSONObject r18, String r19) {
            if (d.a() == true) goto L5;
            return;
        L5:
            d.g.execute(new f(r12, r13, r14, r15, r16, r17, r18, r19));
        }

        @Override // wea.a
        public final void b(Long r12, Long r13, String r14, String r15, String r16, Integer r17, JSONObject r18, String r19) {
            if (d.a() == true) goto L5;
            return;
        L5:
            d.g.execute(new e(r12, r13, r14, r15, r16, r17, r18, r19));
        }
    }

    public static final class c implements uea.a {
        public c() {
        }

        @Override // uea.a
        public final void a(boolean r4) {
            FLogger.a.i("ObricTTNetReport", "onObricStatusChanged: " + r4);
            d.f.set(r4);
        }
    }

    public d() {
    }

    static {
        a = new a(0);
        e = new Object();
        f = new AtomicBoolean(true);
        g = PThreadExecutorsUtils.newSingleThreadExecutor(new xea.b());
        h = new c();
        i = LazyKt.lazy(new xea.c());
        j = new b();
        UriProtector.parse("content://com.obric.assistant.provider.AssistantHybridAbilityProvider");
    }

    public static final boolean a() {
        Object r0 = e;
        monitor-enter(r0);
        long r1 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L24
        if (r1 >= d) goto L7;
    L8:
        c = t1.a.getObricPowerLockConfig().getObricNetworkInterceptConfig();     // Catch: Throwable -> L24
        d = r1;     // Catch: Throwable -> L24
    L9:
        ObricNetworkInterceptConfig r2 = c;     // Catch: Throwable -> L24
        monitor-exit(r0);
        if (r2 == null) goto L14;
        boolean r3 = Intrinsics.areEqual(r2.getObricEnableTTNetMonitorHookEvent(), Boolean.TRUE);
    L15:
        if (r3 == false) goto L30;
        Float r4 = r2.getObricTtnetMonitorHookEventRate();
        float r5 = 0.0f;
        if (r4 == null) goto L21;
        r5 = RangesKt.coerceIn(r4.floatValue(), 0.0f, 1.0f);
    L21:
        if (Math.random() >= r5) goto L29;
        return true;
    L29:
        return false;
    L30:
        return false;
    L14:
        r3 = false;
        goto L15
    L7:
        if ((r1 - d) <= 1800000) goto L9;
    L24:
        th = move-exception;
        throw th;
    }

    public static String c(String r6, String r7) {
        if (r6 != null) goto L31;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == false) goto L14;
        FLogger.a.i("ObricTTNetReport", "parseRawLogValueByKey raw log is empty");     // Catch: Exception -> L8
        return null;
    L14:
        MatchResult r8 = Regex.find$default(new Regex("\\\\?\"" + r7 + "\\\\?\"\\s*:\\s*(\\\\?\"(.*?)\\\\?\"|([^,}]+))"), r6, 0, 2, null);     // Catch: Exception -> L8
        if (r8 != null) goto L17;
        return null;
    L17:
        MatchGroup r9 = r8.getGroups().get(2);     // Catch: Exception -> L8
        if (r9 == null) goto L23;
        String r10 = r9.getValue();     // Catch: Exception -> L8
        if (r10 == null) goto L23;
        return r10;
    L23:
        MatchGroup r11 = r8.getGroups().get(3);     // Catch: Exception -> L8
        if (r11 == null) goto L33;
        String r12 = r11.getValue();     // Catch: Exception -> L8
        if (r12 != null) goto L28;
        return null;
    L28:
        return StringsKt.trim(r12).toString();
    L33:
        return null;
    L31:
    L8:
        e = move-exception;
        FLogger.a.e("ObricTTNetReport", "parseRawLogValueByKey failed", e);
        return null;
    L5:
        if (r6.length() == 0) goto L10;
        r4 = false;
        goto L11
    }

    public static final void b(String r39, String r40, Long r41, Long r42, String r43, String r44, String r45, Integer r46, String r47) {
        boolean r3 = true;
        Boolean r4 = null;
        if (r43 != null) goto L315;
    L15:
        boolean r6 = true;
    L18:
        if (r6 == false) goto L21;
        return;
    L21:
        if (AppHost.a.isDebug() == true) goto L24;
    L44:
        JSONObject r1 = new JSONObject();
        boolean r7 = IRuntimeContext.a.a();     // Catch: Throwable -> L47
    L327:
        String r0 = IRuntimeContext.a.b();     // Catch: Throwable -> L51
    L53:
        String r8 = r0;
        int r2 = TTNetInit.getEffectiveConnectionType();     // Catch: Throwable -> L56
    L58:
        String r9 = "UNKNOWN";
        String r10 = "UNKNOWN";
        if (r43 == null) goto L68;
        Uri r11 = UriProtector.parse(r43);
        if (r11 == null) goto L68;
        r9 = r11.getHost();
        if (r9 != null) goto L65;
        r9 = "UNKNOWN";
    L65:
        r10 = r11.getPath();
        if (r10 != null) goto L68;
        r10 = "UNKNOWN";
    L68:
        String r12 = c(r47, "mn_state");
        if (r12 != null) goto L71;
        r12 = "UNKNOWN";
    L71:
        String r5 = c(r47, "proxy");
        if (r5 != null) goto L74;
        r5 = "UNKNOWN";
    L74:
        r1.put("o_is_main_pro", r7);
        r1.put("o_pro_name", r8);
        PowerManager r13 = (PowerManager) i.getValue();     // Catch: Throwable -> L81
        if (r13 == null) goto L78;
        boolean r14 = r13.isInteractive();     // Catch: Throwable -> L81
    L79:
        FLogger.a.i("ObricTTNetReport", "isScreenOn, value: " + r14);     // Catch: Throwable -> L81
    L82:
        if (r14 == false) goto L84;
        ScreenStateManager.ScreenState r15 = ScreenStateManager.ScreenState.SCREEN_ON;
    L85:
        FLogger.a.i("ObricTTNetReport", "getScreenState, state: " + r15);
        r1.put("o_screen_state", r15.toString());
        r1.put("o_project_name", "f");
        long r16 = -1;
        if (r41 == null) goto L88;
        long r17 = r41.longValue();
    L89:
        r1.put("o_send_dur", r17);
        if (r42 == null) goto L92;
        r16 = r42.longValue();
    L92:
        r1.put("o_send_time", r16);
        if (r43 != null) goto L95;
        String r18 = "UNKNOWN";
    L96:
        r1.put("o_send_url", r18);
        r1.put("o_send_api", r9);
        r1.put("o_send_path", r10);
        if (r44 != null) goto L99;
        String r19 = "UNKNOWN";
    L100:
        r1.put("o_send_ip", r19);
        if (r45 != null) goto L103;
        String r20 = "EMPTY_CODE";
    L104:
        r1.put("o_trace_code", r20);
        if (r46 != null) goto L107;
        Object r21 = "UNKNOWN";
    L108:
        r1.put("o_net_status", r21);
        r1.put("ot_ec_type", r2);
        r1.put("ot_mn_state", r12);
        r1.put("ot_proxy", r5);
        s r22 = j.h;
        r1.put("obm_intercepting", r22.B);
        r1.put("obm_dora_user", r22.e);
        r1.put("obm_block_h", r22.c);
        r1.put("obm_n_control", r22.d);
        r1.put("obm_block_not_use_dora", r22.g);
        r1.put("obm_in_a_list", r22.f);
        r1.put("obm_audio_playing", r22.w);
        r1.put("obm_screen_state", r22.a);
        r1.put("obm_dora_task_status", r22.v);
        r1.put("obm_is_assistant_deactive", f.get());
        Application r23 = AppHost.a.getApplication();
    L114:
        th = move-exception;
        FLogger.a.w("ObricTTNetReport", "isMainProcessSafe failed: " + th.getMessage(), th);
        boolean r24 = true;
    L116:
        if (r24 == false) goto L323;
        j r25 = j.a;
        boolean r26 = j.c();
    L131:
        r1.put("obm_is_bg", r26);
        j r27 = j.a;
        Intrinsics.checkNotNullParameter(r9, "host");
        Intrinsics.checkNotNullParameter(r10, DownloadConstants.PATH_KEY);
        s r28 = j.h;
        r1.put("obm_in_allow_list", r28.a(r9, r10));
        r1.put("obm_bg_network_mode", r28.y);
        r1.put("obm_need_open_network_control", r28.d);
        r1.put("obm_is_clear_ttent_pool", r28.z);
        long r29 = System.currentTimeMillis();
        if ((r29 - b) > 1000) goto L135;
        r3 = false;
    L135:
        if (r3 == true) goto L314;
    L312:
        a r30 = a;
        r1.put("os_capability_type", r30.a);
        r1.put("os_frep_type", r30.b);
        r1.put("os_rssi", r30.c);
        r1.put("os_link_speed", r30.d);
        r1.put("os_rx_link_speed", r30.e);
        r1.put("os_is_idle_mode", r30.f);
        r1.put("os_is_power_save_mode", r30.g);
        r1.put("os_is_sleep_mode", r30.h);
        r1.put("os_is_vip_network_feature_enabled", r30.i);
        r1.put("os_is_wifi_accel_enabled", r30.j);
        r1.put("os_is_super_stable_enabled", r30.k);
        r1.put("os_is_vip_channel_enabled", r30.l);
        r1.put("os_rate_strategy_type", r30.m);
        r1.put("os_foreground_app_pkg", r30.n);
        r1.put("os_foreground_rate_limit", r30.o);
        r1.put("os_vip_channel_rate_limit", r30.p);
        r1.put("os_background_rate_limit", r30.q);
        r1.put("os_foreground_throughput", r30.r);
        r1.put("os_vip_channel_throughput", r30.s);
        r1.put("os_background_throughput", r30.t);
        r1.put("os_doubao_rtt", r30.u);
        r1.put("os_doubao_avg_rtt_five_sec", r30.v);
        r1.put("os_doubao_max_rtt_five_sec", r30.w);
        r1.put("os_doubao_min_rtt_five_sec", r30.x);
        r1.put("os_is_vpn_enabled", r30.y);
        r1.put("os_wifi_current_throughput", r30.z);
        r1.put("os_wifi_rtt", r30.A);
        r1.put("os_cellular_throughput", r30.B);
        r1.put("os_cellular_rtt", r30.C);
        IApmTrace.a.c(r39, r1);
        return;
    L314:
    L307:
        th = move-exception;
        if (AppHost.a.isDebug() == true) goto L311;
        FLogger.a.e("ObricTTNetReport", "ERROR_USING_CAE", th);
        goto L312
    L311:
        throw th;
    L137:
        if (lfa.c.g == null) goto L139;
    L148:
        NetworkStateInfo r31 = lfa.c.g.c();     // Catch: Throwable -> L307
        if (r31 == null) goto L312;
        VipStrategyReport r32 = r31.getVipStrategyReport();     // Catch: Throwable -> L307
        NetworkInfo r33 = r31.getDefaultNetworkInfo();     // Catch: Throwable -> L307
        if (r33 == null) goto L154;
        String r34 = r33.getCapabilityType();     // Catch: Throwable -> L307
        if (r34 == null) goto L154;
    L155:
        String r110 = r34;
        NetworkInfo r35 = r31.getDefaultNetworkInfo();     // Catch: Throwable -> L307
        if (r35 == null) goto L162;
        NetworkCapability r36 = r35.getCapability();     // Catch: Throwable -> L307
        if (r36 == null) goto L162;
        Integer r37 = r36.getFreq();     // Catch: Throwable -> L307
        if (r37 == null) goto L162;
        int r111 = r37.intValue();     // Catch: Throwable -> L307
    L163:
        NetworkInfo r38 = r31.getDefaultNetworkInfo();     // Catch: Throwable -> L307
        if (r38 == null) goto L170;
        NetworkCapability r48 = r38.getCapability();     // Catch: Throwable -> L307
        if (r48 == null) goto L170;
        Integer r49 = r48.getRssi();     // Catch: Throwable -> L307
        if (r49 == null) goto L170;
        int r112 = r49.intValue();     // Catch: Throwable -> L307
    L171:
        NetworkInfo r50 = r31.getDefaultNetworkInfo();     // Catch: Throwable -> L307
        if (r50 == null) goto L178;
        NetworkCapability r51 = r50.getCapability();     // Catch: Throwable -> L307
        if (r51 == null) goto L178;
        Integer r52 = r51.getLinkSpeed();     // Catch: Throwable -> L307
        if (r52 == null) goto L178;
        int r113 = r52.intValue();     // Catch: Throwable -> L307
    L179:
        NetworkInfo r53 = r31.getDefaultNetworkInfo();     // Catch: Throwable -> L307
        if (r53 == null) goto L186;
        NetworkCapability r54 = r53.getCapability();     // Catch: Throwable -> L307
        if (r54 == null) goto L186;
        Integer r55 = r54.getRxLinkSpeed();     // Catch: Throwable -> L307
        if (r55 == null) goto L186;
        int r114 = r55.intValue();     // Catch: Throwable -> L307
    L187:
        Boolean r56 = r31.isIdleMode();     // Catch: Throwable -> L307
        if (r56 == null) goto L190;
        boolean r115 = r56.booleanValue();     // Catch: Throwable -> L307
    L191:
        Boolean r57 = r31.isPowerSaveMode();     // Catch: Throwable -> L307
        if (r57 == null) goto L194;
        boolean r116 = r57.booleanValue();     // Catch: Throwable -> L307
    L195:
        Boolean r58 = r31.isSleepMode();     // Catch: Throwable -> L307
        if (r58 == null) goto L198;
        boolean r117 = r58.booleanValue();     // Catch: Throwable -> L307
    L199:
        if (r32 == null) goto L203;
        Boolean r59 = r32.isVipNetworkFeatureEnabled();     // Catch: Throwable -> L307
        if (r59 == null) goto L203;
        boolean r118 = r59.booleanValue();     // Catch: Throwable -> L307
    L204:
        if (r32 == null) goto L208;
        Boolean r60 = r32.isWifiAccelEnabled();     // Catch: Throwable -> L307
        if (r60 == null) goto L208;
        boolean r119 = r60.booleanValue();     // Catch: Throwable -> L307
    L209:
        if (r32 == null) goto L213;
        Boolean r61 = r32.isSuperStableEnabled();     // Catch: Throwable -> L307
        if (r61 == null) goto L213;
        boolean r210 = r61.booleanValue();     // Catch: Throwable -> L307
    L214:
        if (r32 == null) goto L218;
        Boolean r62 = r32.isVipChannelEnabled();     // Catch: Throwable -> L307
        if (r62 == null) goto L218;
        boolean r211 = r62.booleanValue();     // Catch: Throwable -> L307
    L220:
        if (r32 == null) goto L224;
        Integer r63 = r32.getRateStrategyType();     // Catch: Throwable -> L307
        if (r63 == null) goto L224;
        int r212 = r63.intValue();     // Catch: Throwable -> L307
    L225:
        if (r32 == null) goto L228;
        String r64 = r32.getForegroundAppPkg();     // Catch: Throwable -> L307
        if (r64 == null) goto L228;
    L229:
        String r213 = r64;
        if (r32 == null) goto L234;
        Integer r65 = r32.getForegroundRateLimit();     // Catch: Throwable -> L307
        if (r65 == null) goto L234;
        int r214 = r65.intValue();     // Catch: Throwable -> L307
    L235:
        if (r32 == null) goto L239;
        Integer r66 = r32.getVipChannelRateLimit();     // Catch: Throwable -> L307
        if (r66 == null) goto L239;
        int r215 = r66.intValue();     // Catch: Throwable -> L307
    L240:
        if (r32 == null) goto L244;
        Integer r67 = r32.getBackgroundRateLimit();     // Catch: Throwable -> L307
        if (r67 == null) goto L244;
        int r216 = r67.intValue();     // Catch: Throwable -> L307
    L245:
        if (r32 == null) goto L249;
        Integer r68 = r32.getForegroundThroughput();     // Catch: Throwable -> L307
        if (r68 == null) goto L249;
        int r217 = r68.intValue();     // Catch: Throwable -> L307
    L250:
        if (r32 == null) goto L254;
        Integer r69 = r32.getVipChannelThroughput();     // Catch: Throwable -> L307
        if (r69 == null) goto L254;
        int r218 = r69.intValue();     // Catch: Throwable -> L307
    L255:
        if (r32 == null) goto L259;
        Integer r70 = r32.getBackgroundThroughput();     // Catch: Throwable -> L307
        if (r70 == null) goto L259;
        int r219 = r70.intValue();     // Catch: Throwable -> L307
    L260:
        if (r32 == null) goto L264;
        Integer r71 = r32.getDoubaoRtt();     // Catch: Throwable -> L307
        if (r71 == null) goto L264;
        int r310 = r71.intValue();     // Catch: Throwable -> L307
    L265:
        if (r32 == null) goto L269;
        Integer r72 = r32.getDoubaoAvgRttFiveSec();     // Catch: Throwable -> L307
        if (r72 == null) goto L269;
        int r311 = r72.intValue();     // Catch: Throwable -> L307
    L270:
        if (r32 == null) goto L274;
        Integer r73 = r32.getDoubaoMaxRttFiveSec();     // Catch: Throwable -> L307
        if (r73 == null) goto L274;
        int r312 = r73.intValue();     // Catch: Throwable -> L307
    L275:
        if (r32 == null) goto L279;
        Integer r74 = r32.getDoubaoMinRttFiveSec();     // Catch: Throwable -> L307
        if (r74 == null) goto L279;
        int r313 = r74.intValue();     // Catch: Throwable -> L307
    L280:
        if (r32 == null) goto L284;
        Boolean r75 = r32.isVpnEnabled();     // Catch: Throwable -> L307
        if (r75 == null) goto L284;
        boolean r314 = r75.booleanValue();     // Catch: Throwable -> L307
    L285:
        if (r32 == null) goto L289;
        Integer r76 = r32.getWifiCurrentThroughput();     // Catch: Throwable -> L307
        if (r76 == null) goto L289;
        int r315 = r76.intValue();     // Catch: Throwable -> L307
    L290:
        if (r32 == null) goto L294;
        Integer r77 = r32.getWifiRtt();     // Catch: Throwable -> L307
        if (r77 == null) goto L294;
        int r316 = r77.intValue();     // Catch: Throwable -> L307
    L295:
        if (r32 == null) goto L299;
        Integer r78 = r32.getCellularThroughput();     // Catch: Throwable -> L307
        if (r78 == null) goto L299;
        int r317 = r78.intValue();     // Catch: Throwable -> L307
    L300:
        if (r32 == null) goto L304;
        Integer r79 = r32.getCellularRtt();     // Catch: Throwable -> L307
        if (r79 == null) goto L304;
        int r318 = r79.intValue();     // Catch: Throwable -> L307
    L305:
        a = new a(r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r318);     // Catch: Throwable -> L307
        b = r29;     // Catch: Throwable -> L307
    L304:
        r318 = -1;
    L299:
        r317 = -1;
    L294:
        r316 = -1;
    L289:
        r315 = -1;
    L284:
        r314 = false;
    L279:
        r313 = -1;
    L274:
        r312 = -1;
    L269:
        r311 = -1;
    L264:
        r310 = -1;
    L259:
        r219 = -1;
    L254:
        r218 = -1;
    L249:
        r217 = -1;
    L244:
        r216 = -1;
    L239:
        r215 = -1;
    L234:
        r214 = -1;
    L228:
        r64 = "UNKNOWN";
    L224:
        r212 = -1;
    L218:
        r211 = false;
    L213:
        r210 = false;
    L208:
        r119 = false;
    L203:
        r118 = false;
        goto L204
    L198:
        r117 = false;
        goto L199
    L194:
        r116 = false;
        goto L195
    L190:
        r115 = false;
    L186:
        r114 = -404;
    L178:
        r113 = -404;
    L170:
        r112 = -404;
    L162:
        r111 = -404;
    L154:
        r34 = "EMPTY_TYPE";
        goto L155
    L139:
        monitor-enter(lfa.c.class);     // Catch: Throwable -> L307
    L145:
        th = move-exception;
        throw th;     // Catch: Throwable -> L307
    L141:
        if (lfa.c.g != null) goto L143;
        lfa.c.g = new lfa.c();     // Catch: Throwable -> L145
    L143:
        monitor-exit(lfa.c.class);     // Catch: Throwable -> L145
    L323:
        IObricBackgroundNetworkBlockService r80 = (IObricBackgroundNetworkBlockService) ServiceManager.get().getService(IObricBackgroundNetworkBlockService.class);     // Catch: Throwable -> L126
        if (r80 == null) goto L123;
        Boolean r81 = r80.a();     // Catch: Throwable -> L126
        if (r81 == null) goto L123;
        boolean r82 = r81.booleanValue();     // Catch: Throwable -> L126
    L124:
        r4 = Boolean.valueOf(r82);     // Catch: Throwable -> L126
    L128:
        if (r4 == null) goto L130;
        r26 = r4.booleanValue();
        goto L131
    L130:
        j r83 = j.a;
        r26 = j.c();
    L123:
        r82 = false;
    L126:
        th = move-exception;
        FLogger.a.w("ObricTTNetReport", "queryMainProcessAppInBackground failed: " + th.getMessage(), th);
        goto L128
    L110:
        if (Build.VERSION.SDK_INT < 28) goto L112;
        r24 = Intrinsics.areEqual(r23.getPackageName(), Application.getProcessName());     // Catch: Throwable -> L114
    L320:
        goto L116
    L112:
        r24 = k.i(r23);     // Catch: Throwable -> L114
        goto L320
    L107:
        r21 = r46;
        goto L108
    L103:
        r20 = r45;
        goto L104
    L99:
        r19 = r44;
        goto L100
    L95:
        r18 = r43;
        goto L96
    L88:
        r17 = -1;
        goto L89
    L84:
        r15 = ScreenStateManager.ScreenState.SCREEN_OFF;
        goto L85
    L78:
        r14 = true;
    L81:
        r14 = true;
    L56:
        th = move-exception;
        FLogger.a.w("ObricTTNetReport", th);
        r2 = -404;
    L51:
        th = move-exception;
        FLogger.a.w("ObricTTNetReport", th);
        r0 = "UNKNOWN";
    L47:
        th = move-exception;
        FLogger.a.w("ObricTTNetReport", th);
        r7 = true;
        goto L327
    L24:
        if (r47 != null) goto L319;
    L31:
        boolean r84 = true;
    L32:
        if (r84 == false) goto L34;
        FLogger.a.i("ObricTTNetReport", "long log is empty");     // Catch: Exception -> L29
        goto L44
    L34:
        FLogger.a.i("ObricTTNetReport", "===>>> start ".concat(r40));     // Catch: Exception -> L29
        Iterator r85 = StringsKt.chunked(r47, 1000).iterator();     // Catch: Exception -> L29
        int r86 = 0;
    L36:
        if (r85.hasNext() == false) goto L41;
        Object r87 = r85.next();     // Catch: Exception -> L29
        int r88 = r86 + 1;     // Catch: Exception -> L29
        if (r86 >= 0) goto L40;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L29
    L40:
        FLogger.a.i("ObricTTNetReport", "Print long log part [" + r88 + "]: " + ((String) r87));     // Catch: Exception -> L29
        r86 = r88;
        goto L36
    L41:
        FLogger.a.i("ObricTTNetReport", "<<<=== end " + r40);     // Catch: Exception -> L29
        goto L44
    L319:
    L29:
        e = move-exception;
        FLogger.a.e("ObricTTNetReport", r40, e);
        goto L44
    L26:
        if (r47.length() == 0) goto L31;
        r84 = false;
        goto L32
    L315:
        Uri r89 = UriProtector.parse(r43);     // Catch: Exception -> L16
        if (r89 == null) goto L9;
        String r90 = r89.getHost();     // Catch: Exception -> L16
        if (r90 == null) goto L9;
    L11:
        if (StringsKt.contains$default(r90, "log", false, 2, null) == true) goto L15;
        if (StringsKt.startsWith$default(r90, "dig.bdurl.net", false, 2, null) == false) goto L17;
    L9:
        r90 = "";
    L17:
        r6 = false;
        goto L18
    }
}
