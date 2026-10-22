package com.obric.assistant.zeus.plugin;

import android.app.KeyguardManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.LruCache;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.activeness.IObricActivenessMonitorService;
import com.obric.activeness.ObricActiveReason;
import com.obric.assistant.t1;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.download.DownloadPolicy;
import com.volcengine.zeus.download.PluginDownloadBean;
import hm9.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c implements DownloadPolicy, Handler.Callback {
    public static final c a = null;
    public static Context b;
    public static final ConcurrentHashMap<String, Long> c = null;
    public static final LruCache<String, Boolean> d = null;
    public static volatile List<String> e;
    public static final ConcurrentHashMap<String, String> f = null;
    public static final Handler g = null;

    public c() {
    }

    static {
        c r0 = new c();
        a = r0;
        c = new ConcurrentHashMap();
        d = new LruCache(16);
        e = CollectionsKt.emptyList();
        f = new ConcurrentHashMap();
        g = new Handler(Looper.getMainLooper(), r0);
    }

    public static void b(String r7) {
        Handler r0 = g;
        r0.removeMessages(1001, r7);
        Message r2 = Message.obtain();
        r2.what = 1001;
        r2.obj = r7;
        Long r8 = Long.valueOf(t1.a.getObricZeusAutoFetchConfig().getAutoFetchTimeIntervalMillis());
        if (r8.longValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r8 = null;
    L9:
        if (r8 == null) goto L11;
        long r3 = r8.longValue();
    L12:
        r0.sendMessageDelayed(r2, r3);
        return;
    L11:
        r3 = DownloadConstants.HOUR;
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    public static void c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        List r0 = CollectionsKt.distinct(e);
        if (r0.isEmpty() == false) goto L6;
        FLogger.a.i("ZeusAutoFetchManager", "triggerFetchForAll skipped: no auto fetch plugin. reason=" + r5);
        return;
    L6:
        FLogger.a.i("ZeusAutoFetchManager", "triggerFetchForAll: reason=" + r5 + ", plugins=" + r0);
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        a((String) r1.next(), r5);
        goto L8
    }

    @Override // com.volcengine.zeus.download.DownloadPolicy
    public final Map<String, String> getCustomTag(String r8) {
        Intrinsics.checkNotNullParameter(r8, "pluginPkgName");
        AppHost.Companion r9 = AppHost.a;
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("version_code", String.valueOf(r9.getVersionCode())), TuplesKt.to("update_version_code", String.valueOf(r9.getUpdateVersionCode())), TuplesKt.to("short_os_version", t9a.b.b().b().b()), TuplesKt.to("os_build_date", String.valueOf(t9a.b.b().b().c())), TuplesKt.to("obric_fwk_api_version", String.valueOf(t9a.b.b().b().h())), TuplesKt.to("os_device_id", String.valueOf(t9a.b.b().b().a()))});
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        if (r4.what != 1001) goto L12;
        Object r5 = r4.obj;
        if ((r5 instanceof String) == false) goto L7;
        String r6 = (String) r5;
    L8:
        if (r6 != null) goto L10;
        return false;
    L10:
        FLogger.a.d("ZeusAutoFetchManager", "handleMessage: check auto fetch triggered for ".concat(r6));
        a(r6, "auto_fetch_timer");
        b(r6);
        return true;
    L7:
        r6 = null;
        goto L8
    L12:
        return false;
    }

    @Override // com.volcengine.zeus.download.DownloadPolicy
    public final void updateLastRequestTime(String r6) {
        Intrinsics.checkNotNullParameter(r6, "pluginPkgName");
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        c.put(r6, Long.valueOf(SystemClock.uptimeMillis()));
        long r1 = System.currentTimeMillis();
        ((Keva) e.a.getValue()).storeLong("last_success_request_time_millis", r1);
        FLogger.a.i("ZeusAutoFetchManager", "update last success request time: plugin=" + r6 + ", lastSuccessRequestTimeMillis=" + r1);
        if (e.contains(r6) == false) goto L12;
        b(r6);
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void a(String r3, String r4) {
        FLogger.a.i("ZeusAutoFetchManager", "fetchPlugin: plugin=" + r3 + ", reason=" + r4);
        Zeus.fetchPlugin(r3);
    }

    @Override // com.volcengine.zeus.download.DownloadPolicy
    public final boolean allowDownload(String r7, PluginDownloadBean r8) {
        Intrinsics.checkNotNullParameter(r7, "pluginPkgName");
        Intrinsics.checkNotNullParameter(r8, "bean");
        String r0 = r8.mUrl;
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (Intrinsics.areEqual(f.get(r0), r8.mMd5) == false) goto L10;
        FLogger.a.w("ZeusAutoFetchManager", "allowDownload: reject due to same md5. plugin=" + r7 + ", bean=" + r8);
        return false;
    L10:
        if (t1.a.getObricZeusAutoFetchConfig().getUseNetworkIntercept() == true) goto L12;
    L14:
        boolean r1 = false;
    L15:
        if (r1 == false) goto L18;
        FLogger.a.i("ZeusAutoFetchManager", "allowDownload: rejected due to network restriction. plugin=" + r7 + ", bean=" + r8);
        return false;
    L18:
        FLogger.a.d("ZeusAutoFetchManager", "allowDownload: allowed. plugin=" + r7 + ", bean=" + r8);
        IObricActivenessMonitorService.a.getClass();
        IObricActivenessMonitorService r9 = (IObricActivenessMonitorService) IObricActivenessMonitorService.a.b.getValue();
        if (r9 == null) goto L21;
        r9.c(ObricActiveReason.PLUGIN_UPDATE, true, 900000);
    L21:
        return true;
    L12:
        if (j.h.B == false) goto L14;
        r1 = true;
        goto L15
    }

    @Override // com.volcengine.zeus.download.DownloadPolicy
    public final boolean allowRequest(String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "pluginPkgName");
        Long r2 = null;
        if (b != null) goto L5;
    L35:
        if (r13 == true) goto L65;
        if (r12 != null) goto L38;
    L41:
        boolean r14 = true;
    L42:
        if (r14 == true) goto L60;
        Long r15 = c.get(r12);
        if (r15 == null) goto L47;
        long r7 = r15.longValue();
    L48:
        long r9 = SystemClock.uptimeMillis() - r7;
        Long r16 = Long.valueOf(t1.a.getObricZeusAutoFetchConfig().getFetchTimeThrottleMillis());
        if (r16.longValue() <= 0) goto L51;
        boolean r0 = true;
    L52:
        if (r0 == false) goto L54;
        r2 = r16;
    L54:
        if (r2 == null) goto L56;
        long r5 = r2.longValue();
    L58:
        if (r9 < r5) goto L60;
        boolean r17 = true;
    L61:
        if (r17 == true) goto L65;
        FLogger.a.i("ZeusAutoFetchManager", "allowRequest: rejected due to time interval. plugin=" + r12);
        return false;
    L56:
        r5 = DownloadConstants.HOUR;
        goto L58
    L51:
        r0 = false;
        goto L52
    L47:
        r7 = 0;
    L60:
        r17 = false;
        goto L61
    L38:
        if (r12.length() == 0) goto L41;
        r14 = false;
    L65:
        if (t1.a.getObricZeusAutoFetchConfig().getUseNetworkIntercept() == true) goto L67;
    L69:
        boolean r18 = false;
    L70:
        if (r18 == false) goto L73;
        FLogger.a.i("ZeusAutoFetchManager", "allowRequest: rejected due to network restriction. plugin=" + r12);
        return false;
    L73:
        FLogger.a.i("ZeusAutoFetchManager", "allowRequest: allowed. plugin=" + r12);
        return true;
    L67:
        if (j.h.B == false) goto L69;
        r18 = true;
        goto L70
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L35;
        Context r1 = b;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        r1 = null;
    L9:
        Object r3 = r1.getSystemService("connectivity");
        if ((r3 instanceof ConnectivityManager) == false) goto L12;
        ConnectivityManager r4 = (ConnectivityManager) r3;
    L13:
        FLogger r6 = FLogger.a;
        r6.d("ZeusAutoFetchManager", "allowRequest: connectionManager=" + r4);
        if (r4 == null) goto L16;
        Network r8 = r4.getActiveNetwork();
    L17:
        if (r8 != null) goto L20;
        r6.i("ZeusAutoFetchManager", "allowRequest: rejected due to no active network. plugin=" + r12);
        return false;
    L20:
        Context r10 = b;
        if (r10 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        r10 = null;
    L23:
        Object r11 = r10.getSystemService("keyguard");
        if ((r11 instanceof KeyguardManager) == false) goto L26;
        KeyguardManager r19 = (KeyguardManager) r11;
    L27:
        if (r19 != null) goto L29;
    L31:
        boolean r20 = false;
    L32:
        if (r20 == false) goto L35;
        r6.i("ZeusAutoFetchManager", "allowRequest: rejected due to keyguard locked. plugin=" + r12);
        return false;
    L29:
        if (r19.isKeyguardLocked() != true) goto L31;
        r20 = true;
        goto L32
    L26:
        r19 = null;
        goto L27
    L16:
        r8 = null;
        goto L17
    L12:
        r4 = null;
        goto L13
    }

    @Override // com.volcengine.zeus.download.DownloadPolicy
    public final boolean isDownloadWifiOnly(String r5, PluginDownloadBean r6) {
        Intrinsics.checkNotNullParameter(r5, "pluginPkgName");
        Intrinsics.checkNotNullParameter(r6, "bean");
        boolean r0 = true;
        if (r5.length() != 0) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L8;
        return true;
    L8:
        String r8 = r6.mCustomMsg;
        if (r8 != null) goto L11;
        r8 = "{}";
    L11:
        Boolean r9 = d.get(r8);
        if (r9 != null) goto L14;
        JSONObject r10 = new JSONObject(r8);     // Catch: JSONException -> L17
    L19:
        if (r10 == null) goto L21;
        r0 = r10.optBoolean("is_wifi_only", true);
    L21:
        d.put(r8, Boolean.valueOf(r0));
        return r0;
    L17:
        e = move-exception;
        FLogger.a.e("ZeusAutoFetchManager", "isDownloadWifiOnly: failed to parse custom message. customMessage=".concat(r8), e);
        r10 = null;
        goto L19
    L14:
        return r9.booleanValue();
    L5:
        r7 = false;
        goto L6
    }

    @Override // com.volcengine.zeus.download.DownloadPolicy
    public final void onDownloadSuccess(String r4, PluginDownloadBean r5) {
        Intrinsics.checkNotNullParameter(r4, "mPackageName");
        Intrinsics.checkNotNullParameter(r5, "pluginDownloadBean");
        Intrinsics.checkNotNullParameter(r4, "mPackageName");
        Intrinsics.checkNotNullParameter(r5, "pluginDownloadBean");
        String r6 = r5.mUrl;
        if (r6 != null) goto L5;
        return;
    L5:
        ConcurrentHashMap<String, String> r0 = f;
        String r7 = r5.mMd5;
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        r0.put(r6, r7);
        IObricActivenessMonitorService.a.getClass();
        IObricActivenessMonitorService r8 = (IObricActivenessMonitorService) IObricActivenessMonitorService.a.b.getValue();
        if (r8 == null) goto L12;
        r8.c(ObricActiveReason.PLUGIN_UPDATE, false, 0);
        return;
    }
}
