package com.volcengine.zeus.download;

import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.ZeusPluginStateListener;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.plugin.Plugin;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import mqc.r;
import mqc.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c extends a {
    public final j a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final CountDownLatch e;

    public final PluginDownloadBean c() {
        if (this.c == false) goto L37;
        long r13 = System.currentTimeMillis();
    L34:
        th = move-exception;
        ZeusLogger.w("Zeus/download_zeus", "Request plugin config failed!!! " + this.b, th);
        e(this.b, "fail", 5, th.getMessage());
        return new PluginDownloadBean(this.b, 5);
    L108:
        NetworkInfo r2 = ((ConnectivityManager) Zeus.getAppApplication().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L106 Throwable -> L34
        if (r2 == null) goto L11;
        if (r2.isConnected() == false) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L14;
        ZeusLogger.d("Zeus/download_zeus", "asyncFetchPlugins skip. Network off. " + this.b);     // Catch: Throwable -> L34
        e(this.b, "fail", 1, "network off");     // Catch: Throwable -> L34
        return new PluginDownloadBean(this.b, 1);
    L14:
        NetworkUtils r4 = NetworkUtils.b();     // Catch: Throwable -> L34
        String r12 = GlobalParam.getInstance().getHostUrl();     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r12) == false) goto L17;
        r12 = "https://zeus-api.vemarsdev.com/zeus/client/v2/query";
    L17:
        mqc.f r5 = r4.a(r12, d.a(this.b), this.b);     // Catch: Throwable -> L34
        Object r6 = r5.a;     // Catch: Throwable -> L34
        if (r6 != null) goto L20;
        ZeusLogger.w("Zeus/download_zeus", "Request plugin failed! response is empty! pkg = " + this.b + " logId = " + ((String) r5.b));     // Catch: Throwable -> L34
        e(this.b, "fail", 2, "response empty");     // Catch: Throwable -> L34
        return new PluginDownloadBean(this.b, 2);
    L20:
        JSONObject r7 = (JSONObject) r6;     // Catch: Throwable -> L34
        String r8 = r7.optString("error_msg", "");     // Catch: Throwable -> L34
        int r9 = r7.optInt("error_no", -1);     // Catch: Throwable -> L34
        if (r9 == 0) goto L23;
        ZeusLogger.w("Zeus/download_zeus", "Request plugin failed! errorNo =[" + r9 + "] errorMsg=[" + r8 + "] logId=[" + ((String) r5.b) + "] pluginPkg=[" + this.b + "]");     // Catch: Throwable -> L34
        e(this.b, "fail", r9, r8);     // Catch: Throwable -> L34
        return new PluginDownloadBean(this.b, r9);
    L23:
        ZeusLogger.i("Zeus/download_zeus", "response:" + r5.a + " logId:" + ((String) r5.b));     // Catch: Throwable -> L34
        JSONObject r10 = r7.optJSONObject("data");     // Catch: Throwable -> L34
        if (r10 == null) goto L32;
        PluginDownloadBean r11 = d.b(r10);     // Catch: Throwable -> L34
        if (a.b(r11) == true) goto L28;
        e(this.b, "fail", 6, "should not download");     // Catch: Throwable -> L34
        return new PluginDownloadBean(this.b, 6);
    L28:
        if (a.a(r11) == false) goto L30;
        e(this.b, "fail", 3, "intercept");     // Catch: Throwable -> L34
        return new PluginDownloadBean(this.b, 3);
    L30:
        e(this.b, "success", 0, "");     // Catch: Throwable -> L34
        d(this.b, System.currentTimeMillis() - r13, true);     // Catch: Throwable -> L34
        return r11;
    L32:
        e(this.b, "fail", 4, "no data");     // Catch: Throwable -> L34
        return new PluginDownloadBean(this.b, 4);
    L11:
        r3 = false;
        goto L12
    L37:
        long r14 = System.currentTimeMillis();
        if (this.a != null) goto L40;
    L105:
        return null;
    L40:
        if (this.e == null) goto L105;
        ZeusPluginStateListener.postStateChange(this.b, 11, new Object[0]);     // Catch: Throwable -> L95
        if (GlobalParam.getInstance().getDownloadPolicy().allowRequest(this.b, this.d) == false) goto L101;
        Plugin r15 = Zeus.getPlugin(this.b);     // Catch: Throwable -> L95
        if (TextUtils.isEmpty(r15.response) == true) goto L49;
        JSONObject r16 = new JSONObject(r15.response);     // Catch: Throwable -> L95
        String r17 = "";
    L56:
        String r18 = r16.optString("error_msg", "");     // Catch: Throwable -> L95
        int r19 = r16.optInt("error_no", -1);     // Catch: Throwable -> L95
        if (r19 == 0) goto L59;
        String r0 = "Request plugin failed! errorNo =[" + r19 + "] errorMsg=[" + r18 + "] logId=[" + r17 + "] pluginPkg=[" + this.b + "]";     // Catch: Throwable -> L95
        ZeusLogger.w("Zeus/download_zeus", r0);     // Catch: Throwable -> L95
        ZeusPluginStateListener.postStateChange(this.b, 12, new Object[]{r0});     // Catch: Throwable -> L95
        e(this.b, "fail", r19, r0);     // Catch: Throwable -> L95
        goto L101
    L59:
        this.a.c(this.b);     // Catch: Throwable -> L95
        GlobalParam.getInstance().getDownloadPolicy().updateLastRequestTime(this.b);     // Catch: Throwable -> L95
        ZeusLogger.i("Zeus/download_zeus", "response:" + r16 + " logId:" + r17);     // Catch: Throwable -> L95
        JSONObject r1 = r16.optJSONObject("data");     // Catch: Throwable -> L95
        if (r1 == null) goto L85;
        PluginDownloadBean r20 = d.b(r1);     // Catch: Throwable -> L95
        if (a.b(r20) == false) goto L85;
        t r21 = t.c();     // Catch: Throwable -> L95
        String r22 = this.b;     // Catch: Throwable -> L95
        String r23 = r20.mMd5;     // Catch: Throwable -> L95
        SharedPreferences.Editor r24 = r21.a.edit();     // Catch: Throwable -> L95
        r24.putString("LATEST_" + r22, r23);     // Catch: Throwable -> L95
        r24.apply();     // Catch: Throwable -> L95
        if (a.a(r20) == true) goto L84;
        r15.setApiCompatVersion(r20.mVersionCode, r20.mApiVersionMin, r20.mApiVersionMax);     // Catch: Throwable -> L95
        ZeusPluginStateListener.postStateChange(this.b, 0, new Object[]{r20});     // Catch: Throwable -> L95
    L82:
        th = th;
        boolean r25 = true;
    L113:
        ZeusLogger.w("Zeus/download_zeus", "Request plugin config failed!!! " + this.b, th);     // Catch: Throwable -> L102
        if (r25 == true) goto L100;
        ZeusPluginStateListener.postStateChange(this.b, 12, new Object[]{th.getMessage()});     // Catch: Throwable -> L102
    L100:
        e(this.b, "fail", 5, th.getMessage());     // Catch: Throwable -> L102
    L102:
        th = move-exception;
        ((ConcurrentHashMap) this.a.c).remove(this.b);
        throw th;
    L67:
        if (GlobalParam.getInstance().getDownloadPolicy().allowDownload(this.b, r20) == false) goto L81;
        boolean r26 = GlobalParam.getInstance().getDownloadPolicy().isDownloadWifiOnly(this.b, r20);     // Catch: Throwable -> L82
        if (e.b == null) goto L71;
    L80:
        e.b.a(r20, this, r26);     // Catch: Throwable -> L82
        this.e.await();     // Catch: Throwable -> L82
        goto L81
    L71:
        monitor-enter(e.class);     // Catch: Throwable -> L82
    L77:
        th = move-exception;
        throw th;     // Catch: Throwable -> L82
    L73:
        if (e.b != null) goto L75;
        e.b = new e();     // Catch: Throwable -> L77
    L75:
        monitor-exit(e.class);     // Catch: Throwable -> L77
    L81:
        boolean r27 = true;
        r25 = true;
    L87:
        if (r27 == false) goto L110;
    L91:
        if (r25 == true) goto L93;
        ZeusPluginStateListener.postStateChange(this.b, 0, new Object[]{null});     // Catch: Throwable -> L89
    L93:
        e(this.b, "success", 0, "");     // Catch: Throwable -> L89
        d(this.b, System.currentTimeMillis() - r14, false);     // Catch: Throwable -> L89
    L89:
        th = th;
        goto L113
    L110:
        t r28 = t.c();     // Catch: Throwable -> L89
        String r29 = this.b;     // Catch: Throwable -> L89
        SharedPreferences.Editor r30 = r28.a.edit();     // Catch: Throwable -> L89
        r30.putString("LATEST_" + r29, "0");     // Catch: Throwable -> L89
        r30.apply();     // Catch: Throwable -> L89
        goto L91
    L84:
        r27 = true;
    L86:
        r25 = false;
    L85:
        r27 = false;
        goto L86
    L49:
        NetworkUtils r110 = NetworkUtils.b();     // Catch: Throwable -> L95
        String r111 = GlobalParam.getInstance().getHostUrl();     // Catch: Throwable -> L95
        if (TextUtils.isEmpty(r111) == false) goto L52;
        r111 = "https://zeus-api.vemarsdev.com/zeus/client/v2/query";
    L52:
        mqc.f r112 = r110.a(r111, d.a(this.b), this.b);     // Catch: Throwable -> L95
        JSONObject r113 = (JSONObject) r112.a;     // Catch: Throwable -> L95
        String r114 = (String) r112.b;     // Catch: Throwable -> L95
        if (r113 != null) goto L55;
        String r31 = "Request plugin failed! response is empty! pkg = " + this.b + " logId = " + r114;     // Catch: Throwable -> L95
        ZeusLogger.w("Zeus/download_zeus", r31);     // Catch: Throwable -> L95
        ZeusPluginStateListener.postStateChange(this.b, 12, new Object[]{r31});     // Catch: Throwable -> L95
        e(this.b, "fail", 2, r31);     // Catch: Throwable -> L95
        goto L101
    L55:
        r17 = r114;
        r16 = r113;
    L101:
        ((ConcurrentHashMap) this.a.c).remove(this.b);
    L95:
        th = th;
        r25 = false;
        goto L113
    }

    public c(String r1) {
        this.b = r1;
        this.e = null;
        this.a = null;
        this.c = true;
        this.d = false;
    }

    public c(j r1, boolean r2, String r3) {
        this.a = r1;
        this.b = r3;
        this.e = new CountDownLatch(1);
        this.c = false;
        this.d = r2;
    }

    public static void d(String r7, long r8, boolean r10) {
        Plugin r0 = Zeus.getPlugin(r7);     // Catch: Exception -> L13
        if (r0 == null) goto L5;
        int r1 = r0.getVersion();     // Catch: Exception -> L13
    L6:
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L13
        if (r10 == false) goto L10;
        r6.put("fetch_type", "only_request");     // Catch: Exception -> L13
    L11:
        r.a(r7, Integer.valueOf(r1), "fetch_plugin", r8, r6);     // Catch: Exception -> L13
        return;
    L10:
        r6.put("fetch_type", "request_and_download");     // Catch: Exception -> L13
        goto L11
    L5:
        r1 = -1;
    L13:
        e = move-exception;
        ZeusLogger.w("Zeus/download_zeus", "report fetch cost failed", e);
    }

    public static void e(String r7, String r8, int r9, String r10) {
        Plugin r0 = Zeus.getPlugin(r7);
        if (r0 == null) goto L5;
        int r2 = r0.getVersion();
    L6:
        r.b(r7, r2, "fetch_plugin", r8, Integer.valueOf(r9), r10);
        return;
    L5:
        r2 = -1;
        goto L6
    }
}
