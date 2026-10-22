package org.chromium;

import android.os.Process;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Logger;
import com.ttnet.org.chromium.base.Reflect;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.impl.CronetLibraryLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends TTEventListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile e f9800b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9801a;

    public e() {
        this.f9801a = false;
    }

    public static e a() {
        if (f9800b != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9800b != null) goto L9;
        f9800b = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f9800b;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void handleApiResult(boolean r38, String r39, String r40, String r41, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, boolean r62, long r63, long r65, String r67, String r68, String r69, int r70, int r71, String r72) {
        if (this.f9801a == false) goto L6;
        c.c().b(r38, r39, r40, r41, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r63, r65, r67, r68, r69, r70, r71, r72);
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final Map<String, String> onCallToAddSecurityFactor(String r8, Map<String, String> r10) {
        c r11 = c.c();
        r11.getClass();
        if (d.a().loggerDebug() == false) goto L14;
        d.a().loggerD("CronetAppProviderManager", "onCallToAddSecurityFactor info url = " + r8);
    L14:
        Object r12 = r11.f9796a;     // Catch: Throwable -> L11
        if (r12 == null) goto L16;
        return (Map) Reflect.on(r12).call("onCallToAddSecurityFactor", new Class[]{String.class, Map.class}, new Object[]{r8, r10}).get();
    L16:
        return null;
    L11:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onClientIPChanged(String r8) {
        if (this.f9801a == false) goto L17;
        c r10 = c.c();
        r10.getClass();
        if (d.a().loggerDebug() == false) goto L15;
        d.a().loggerD("CronetAppProviderManager", "onClientIPChanged ");
    L15:
        Object r11 = r10.f9796a;     // Catch: Throwable -> L12
        if (r11 == null) goto L18;
        Reflect.on(r11).call("onClientIPChanged", new Class[]{String.class}, new Object[]{r8});     // Catch: Throwable -> L12
        return;
    L18:
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onColdStartFinish() {
        if (this.f9801a == false) goto L17;
        c r8 = c.c();
        r8.getClass();
        if (d.a().loggerDebug() == false) goto L15;
        d.a().loggerD("CronetAppProviderManager", "onColdStartFinish ");
    L15:
        Object r10 = r8.f9796a;     // Catch: Throwable -> L12
        if (r10 == null) goto L18;
        Reflect.on(r10).call("onColdStartFinish");     // Catch: Throwable -> L12
        return;
    L18:
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onContextInitCompleted(long r11, long r13, long r15, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, long r37, long r39, long r41, long r43, long r45) {
        y6.b r8 = y6.b.b();
        r8.f14012c = Process.getThreadPriority(0);
        r8.f14020k = CronetLibraryLoader.sInitThreadStartTime;
        r8.f14021l = CronetLibraryLoader.sInitThreadEndTime;
        r8.f14029t = CronetLibraryLoader.sLoadCronetSoDuration;
        r8.f14022m = r11;
        r8.f14023n = r13;
        r8.f14024o = r15;
        r8.f14025p = r17;
        r8.f14026q = r19;
        r8.f14027r = r21;
        r8.f14030u = r23;
        r8.f14031v = r25;
        r8.f14032w = r27;
        r8.f14033x = r29;
        r8.f14034y = r31;
        r8.f14035z = r33;
        r8.A = r35;
        r8.B = r37;
        r8.C = r39;
        r8.D = r41;
        r8.E = r43;
        r8.F = r45;
        c r10 = c.c();
        y6.b r12 = y6.b.b();
        r12.getClass();
        JSONObject r14 = new JSONObject();
        JSONObject r16 = new JSONObject();
        JSONObject r18 = new JSONObject();
        r14.put("mode", r12.f14010a.f14040a);     // Catch: JSONException -> L6
        r14.put(LocationMonitorConst.IS_MAIN_PROCESS, r12.f14011b);     // Catch: JSONException -> L6
        r14.put("net_thread_priority", r12.f14012c);     // Catch: JSONException -> L6
        r16.put("ttnet_start", r12.f14013d);     // Catch: JSONException -> L6
        r16.put("ttnet_end", r12.f14014e);     // Catch: JSONException -> L6
        r16.put("engine_start", r12.f14018i);     // Catch: JSONException -> L6
        r16.put("engine_end", r12.f14019j);     // Catch: JSONException -> L6
        r16.put("init_start", r12.f14020k);     // Catch: JSONException -> L6
        r16.put("init_end", r12.f14021l);     // Catch: JSONException -> L6
        r16.put("network_start", r12.f14024o);     // Catch: JSONException -> L6
        r16.put("network_end", r12.f14025p);     // Catch: JSONException -> L6
        r16.put("exec_wait_end", r12.f14026q);     // Catch: JSONException -> L6
        r16.put("preconnect_start", r12.f14027r);     // Catch: JSONException -> L6
        r18.put("builder_build", r12.f14028s);     // Catch: JSONException -> L6
        r18.put("load_cronet", r12.f14029t);     // Catch: JSONException -> L6
        r18.put("init_mssdk", r12.f14017h);     // Catch: JSONException -> L6
        y6.b.d(r18, "init_ttnet", r12.f14013d, r12.f14014e);     // Catch: JSONException -> L6
        y6.b.d(r18, "init_metasec", r12.f14015f, r12.f14016g);     // Catch: JSONException -> L6
        y6.b.d(r18, "create_engine", r12.f14018i, r12.f14019j);     // Catch: JSONException -> L6
        y6.b.d(r18, "init_thread", r12.f14020k, r12.f14021l);     // Catch: JSONException -> L6
        y6.b.d(r18, "native_init_thread", r12.f14022m, r12.f14023n);     // Catch: JSONException -> L6
        y6.b.d(r18, "network_thread", r12.f14024o, r12.f14025p);     // Catch: JSONException -> L6
        y6.b.d(r18, "exec_tasks", r12.f14025p, r12.f14026q);     // Catch: JSONException -> L6
        y6.b.d(r18, "init_total", r12.f14013d, r12.f14025p);     // Catch: JSONException -> L6
        y6.b.d(r18, "init_preconnect", r12.f14013d, r12.f14027r);     // Catch: JSONException -> L6
        r18.put("nqe_init", r12.f14030u);     // Catch: JSONException -> L6
        r18.put("prefs_init", r12.f14031v);     // Catch: JSONException -> L6
        r18.put("channel_init", r12.f14032w);     // Catch: JSONException -> L6
        r18.put("context_build", r12.f14033x);     // Catch: JSONException -> L6
        r18.put("tnc_config", r12.f14034y);     // Catch: JSONException -> L6
        r18.put("update_appinfo", r12.f14035z);     // Catch: JSONException -> L6
        r18.put("netlog_init", r12.A);     // Catch: JSONException -> L6
        r18.put("nqe_detect", r12.B);     // Catch: JSONException -> L6
        r18.put("preconnect", r12.C);     // Catch: JSONException -> L6
        r18.put("ssl_session", r12.D);     // Catch: JSONException -> L6
        r18.put("ttnet_config", r12.E);     // Catch: JSONException -> L6
        r18.put("install_cert", r12.F);     // Catch: JSONException -> L6
        r14.put("ttnet_timestamp", r16);     // Catch: JSONException -> L6
        r14.put("ttnet_duration", r18);     // Catch: JSONException -> L6
    L4:
        Logger.d("b", "cronet init metrics json: " + r14.toString());
        r10.d(r14.toString(), "ttnet_init");
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onCronetBootSucceed() {
        if (this.f9801a == false) goto L17;
        c r8 = c.c();
        r8.getClass();
        if (d.a().loggerDebug() == false) goto L15;
        d.a().loggerD("CronetAppProviderManager", "onCronetBootSucceed ");
    L15:
        Object r10 = r8.f9796a;     // Catch: Throwable -> L12
        if (r10 == null) goto L18;
        Reflect.on(r10).call("onCronetBootSucceed");     // Catch: Throwable -> L12
        return;
    L18:
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onEffectiveConnectionTypeChanged(int r8) {
        c r10 = c.c();
        r10.getClass();
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onEffectiveConnectionTypeChanged type = " + r8);
    L13:
        Object r11 = r10.f9796a;     // Catch: Throwable -> L10
        if (r11 == null) goto L15;
        Reflect.on(r11).call("onEffectiveConnectionTypeChanged", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r8)});     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onMultiNetworkStateChanged(int r8, int r10) {
        c r11 = c.c();
        r11.getClass();
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", "onMultiNetworkStateChanged, prev state = " + r8 + ", curr state = " + r10);
    L13:
        Object r12 = r11.f9796a;     // Catch: Throwable -> L10
        if (r12 == null) goto L15;
        Reflect r13 = Reflect.on(r12);     // Catch: Throwable -> L10
        Class<?> r14 = Integer.TYPE;     // Catch: Throwable -> L10
        r13.call("onMultiNetworkStateChanged", new Class[]{r14, r14}, new Object[]{Integer.valueOf(r8), Integer.valueOf(r10)}).get();     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onPacketLossComputed(int r20, double r21, double r23, double r25, double r27) {
        c r8 = c.c();
        r8.getClass();
        if (d.a().loggerDebug() == false) goto L14;
        d.a().loggerD("CronetAppProviderManager", "onPacketLossComputed protocol = " + r20 + ", upstreamLossRate = " + r21 + ", upstreamLossRateVariance = " + r23 + ", downstreamLossRate = " + r25 + ", downstreamLossRateVariance = " + r27);
    L14:
        Object r10 = r8.f9796a;     // Catch: Throwable -> L11
        if (r10 == null) goto L16;
        Reflect r11 = Reflect.on(r10);     // Catch: Throwable -> L11
        Class<?> r13 = Double.TYPE;     // Catch: Throwable -> L11
        r11.call("onPacketLossComputed", new Class[]{Integer.TYPE, r13, r13, r13, r13}, new Object[]{Integer.valueOf(r20), Double.valueOf(r21), Double.valueOf(r23), Double.valueOf(r25), Double.valueOf(r27)});     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onRTTOrThroughputEstimatesComputed(int r8, int r10, int r11) {
        c r12 = c.c();
        r12.getClass();
        if (d.a().loggerDebug() == false) goto L13;
        d r13 = d.a();
        StringBuilder r14 = defpackage.a.g("onRTTOrThroughputEstimatesComputed httpRtt = ", r8, ", transportRttMs = ", r10, ",downstreamThroughputKbps = ");
        r14.append(r11);
        r13.loggerD("CronetAppProviderManager", r14.toString());
    L13:
        Object r15 = r12.f9796a;     // Catch: Throwable -> L10
        if (r15 == null) goto L15;
        Reflect r16 = Reflect.on(r15);     // Catch: Throwable -> L10
        Class<?> r17 = Integer.TYPE;     // Catch: Throwable -> L10
        r16.call("onRTTOrThroughputEstimatesComputed", new Class[]{r17, r17, r17}, new Object[]{Integer.valueOf(r8), Integer.valueOf(r10), Integer.valueOf(r11)});     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onServerConfigUpdated(String r8, String r10) {
        if (this.f9801a == false) goto L17;
        c r11 = c.c();
        r11.getClass();
        if (d.a().loggerDebug() == false) goto L15;
        d.a().loggerD("CronetAppProviderManager", "onServerConfigUpdated json = " + r8);
    L15:
        Object r12 = r11.f9796a;     // Catch: Throwable -> L12
        if (r12 == null) goto L18;
        Reflect.on(r12).call("onServerConfigEtagChanged", new Class[]{String.class}, new Object[]{r10});     // Catch: Throwable -> L12
        Reflect.on(r11.f9796a).call("onServerConfigUpdated", new Class[]{String.class}, new Object[]{r8});     // Catch: Throwable -> L12
        return;
    L18:
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onStoreIdcChanged(String r8, String r10, String r11) {
        if (this.f9801a == false) goto L17;
        c r12 = c.c();
        r12.getClass();
        if (d.a().loggerDebug() == false) goto L15;
        d.a().loggerD("CronetAppProviderManager", "onStoreIdcChanged ");
    L15:
        Object r13 = r12.f9796a;     // Catch: Throwable -> L12
        if (r13 == null) goto L18;
        Reflect.on(r13).call("onStoreIdcChanged", new Class[]{String.class, String.class, String.class}, new Object[]{r8, r10, r11});     // Catch: Throwable -> L12
        return;
    L18:
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onTNCUpdateFailed(String[] r8, String r10) {
        if (this.f9801a == false) goto L24;
        c r11 = c.c();
        r11.getClass();
        if (d.a().loggerDebug() == false) goto L21;
        d.a().loggerD("CronetAppProviderManager", "onTNCUpdateFailed ");
    L21:
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (r11.f9796a == null) goto L25;
        if (r8 != null) goto L11;
        return;
    L11:
        if (r8.length <= 0) goto L27;
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L18
        int r13 = r8.length;     // Catch: Throwable -> L18
        int r14 = 0;
    L14:
        if (r14 >= r13) goto L16;
        r12.add(r8[r14]);     // Catch: Throwable -> L18
        r14 = r14 + 1;     // Catch: Throwable -> L18
        goto L14
    L16:
        Reflect.on(r11.f9796a).call("onTNCUpdateFailed", new Class[]{ArrayList.class, String.class}, new Object[]{r12, r10});     // Catch: Throwable -> L18
        return;
    L27:
        return;
    L25:
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onTTDnsResolveResult(String r15, String r16, int r17, int r18, int r19, List<String> r20, String r21) {
        c r8 = c.c();
        r8.getClass();
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", defpackage.b.e("onTTDnsResolveResult info uuid = ", r15, " host: ", r16));
    L13:
        Object r10 = r8.f9796a;     // Catch: Throwable -> L10
        if (r10 == null) goto L15;
        Reflect r11 = Reflect.on(r10);     // Catch: Throwable -> L10
        Class<?> r12 = Integer.TYPE;     // Catch: Throwable -> L10
        r11.call("onTTDnsResolveResult", new Class[]{String.class, String.class, r12, r12, r12, List.class, String.class}, new Object[]{r15, r16, Integer.valueOf(r17), Integer.valueOf(r18), Integer.valueOf(r19), r20, r21});     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onTTNetDetectInfoChanged(String r8) {
        if (this.f9801a == false) goto L17;
        c r10 = c.c();
        r10.getClass();
        if (d.a().loggerDebug() == false) goto L15;
        d.a().loggerD("CronetAppProviderManager", "onTTNetDetectInfoChanged info str = " + r8);
    L15:
        Object r11 = r10.f9796a;     // Catch: Throwable -> L12
        if (r11 == null) goto L18;
        Reflect.on(r11).call("onTTNetDetectInfoChanged", new Class[]{String.class}, new Object[]{r8});     // Catch: Throwable -> L12
        return;
    L18:
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }
}
