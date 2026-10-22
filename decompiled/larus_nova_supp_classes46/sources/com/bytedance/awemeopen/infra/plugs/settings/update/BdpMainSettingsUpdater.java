package com.bytedance.awemeopen.infra.plugs.settings.update;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.net.AoFromSource;
import com.bytedance.awemeopen.infra.base.net.AoNet;
import com.bytedance.awemeopen.infra.base.net.AoNetRequest;
import com.bytedance.awemeopen.infra.base.net.AoNetResponse;
import com.bytedance.awemeopen.infra.base.net.AoRequestType;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.base.npth.ErrorPriority;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.infra.plugs.settings.BdpAppSettingsServiceImpl;
import com.bytedance.awemeopen.infra.plugs.settings.SettingsModel;
import com.bytedance.awemeopen.infra.plugs.settings.SettingsRequest;
import com.bytedance.awemeopen.infra.plugs.settings.dao.AoSettingsDao;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import q64.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class BdpMainSettingsUpdater {
    public static final a l = null;
    public static final HashMap<String, BdpMainSettingsUpdater> m = null;
    public final Context a;
    public final String b;
    public final String c;
    public final Integer[] d;
    public volatile int e;
    public volatile long f;
    public volatile boolean g;
    public final AoSettingsDao h;
    public final AtomicInteger i;
    public final Lazy j;
    public final Lazy k;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final BdpMainSettingsUpdater a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "bdpAppId");
            HashMap<String, BdpMainSettingsUpdater> r0 = BdpMainSettingsUpdater.m;
            BdpMainSettingsUpdater r1 = r0.get(r4);
            if (r1 != null) goto L16;
            Application r2 = y54.a.a();
            monitor-enter(this);
            BdpMainSettingsUpdater r3 = r0.get(r4);     // Catch: Throwable -> L12
            if (r3 != null) goto L9;
            r3 = new BdpMainSettingsUpdater(r2, r4);     // Catch: Throwable -> L12
            r0.put(r4, r3);     // Catch: Throwable -> L12
        L9:
            r1 = r3;
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(this);
        L12:
            th = move-exception;
            throw th;
        L16:
            return r1;
        }
    }

    static {
        l = new a();
        m = new HashMap();
    }

    public final ConcurrentHashMap<String, JSONObject> f() {
        return (ConcurrentHashMap) this.k.getValue();
    }

    public BdpMainSettingsUpdater(Context r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "mContext");
        Intrinsics.checkNotNullParameter(r6, "mBdpAppId");
        this.a = r5;
        this.b = r6;
        this.c = "BdpSettingsUpdater_" + r6;
        this.d = new Integer[]{0, 60, 60, 120, 240, 600};
        this.h = new AoSettingsDao(r5, r6);
        this.i = new AtomicInteger(0);
        this.j = LazyKt.lazy(new BdpMainSettingsUpdater$mockSettingsSp$2(this));
        this.k = LazyKt.lazy(new BdpMainSettingsUpdater$mMockSettings$2(this));
    }

    public static final long a(BdpMainSettingsUpdater r6, int r7) {
        if (r7 != 0) goto L4;
        r6.getClass();
        long r8 = System.currentTimeMillis();
        long r0 = 3600000;
    L6:
        return r8 + r0;
    L4:
        int r9 = Math.min(r7, r6.d.length - 1);
        long r1 = System.currentTimeMillis();
        long r10 = ((long) r6.d[r9].intValue()) * 1000;
        r8 = r1;
        r0 = r10;
        goto L6
    }

    public static final void e(BdpMainSettingsUpdater r1, String r2) {
        if (r2 == null) goto L4;
        ((SharedPreferences) r1.j.getValue()).edit().putString(r2, null).apply();
        return;
    L4:
        ((SharedPreferences) r1.j.getValue()).edit().clear().apply();
    }

    public static final SettingsModel b(BdpMainSettingsUpdater r2, SettingsModel r3, Map r4) {
        r2.getClass();
        if (r4.isEmpty() == true) goto L12;
        JSONObject r5 = new JSONObject(r3.getSettings().toString());
        Iterator r6 = r4.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L10;
        Map.Entry r0 = (Map.Entry) r6.next();
        r5.put((String) r0.getKey(), r0.getValue());
        goto L7
    L10:
        return new SettingsModel(r3.getLastUpdateTime(), r5);
    L12:
        return r3;
    }

    public static final void c(BdpMainSettingsUpdater r5, String r6, SettingsModel r7) {
        AoLogger.g(r5.c, new Object[]{"notifySettingsChange ".concat(r6)});
        Intent r0 = new Intent("com.bytedance.openaweme.settings.update");
        r0.setPackage(r5.a.getPackageName());
        r0.putExtra("openaweme_app_id", r5.b);
        r0.putExtra("result", r6);
        if (r7 == null) goto L7;
        JSONObject r8 = r7.toJson();
        if (r8 == null) goto L7;
        String r9 = r8.toString();
    L8:
        r0.putExtra("data", r9);
        r5.a.sendBroadcast(r0);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        AoLogger.c(r5.c, new Object[]{"sendBroadcast", e});
        return;
    L7:
        r9 = null;
        goto L8
    }

    public static final SettingsModel d(final BdpMainSettingsUpdater r32, Context r33, Map r34, final String r35) {
        r32.getClass();
        long r1 = System.currentTimeMillis();
        BdpAppSettingsServiceImpl r0 = BdpAppSettingsServiceImpl.a;
        SettingsRequest r3 = new SettingsRequest.Builder().setQueryParams(r34).setAppId(AoEnv.d()).setAppName(AoEnv.a().getHostAppName()).setVersionCode(String.valueOf(AoEnv.a().getHostVersionCode())).setDevicePlatform("android").setDeviceType(Build.MODEL).setDeviceBrand(Build.BRAND).setDeviceId(AoEnv.c()).setOsVersion(Build.VERSION.RELEASE).setOsApi(Build.VERSION.SDK_INT).setChannel(AoEnv.b()).setInstallId(AoEnv.a().getInstallId()).setUpdateVersionCode(String.valueOf(AoEnv.e())).setAoVersionString(AoEnv.g()).setAoVersionCode(String.valueOf(37300)).setVersionName(AoEnv.f()).build();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r33, "context");
        Intrinsics.checkNotNullParameter(r3, "request");
        String r4 = BdpAppSettingsServiceImpl.b;
        AoLogger.g(r4, new Object[]{"Start request settings: " + r3});
        String r5 = r3.buildUrl();
        AoFromSource r6 = AoFromSource.settings;
        Intrinsics.checkNotNullParameter(r5, "httpUrl");
        Intrinsics.checkNotNullParameter(r6, "fromSource");
        ArrayList r7 = new ArrayList();
        AoRequestType.a r8 = AoRequestType.Companion;
        HashMap r9 = new HashMap();
        AoRequestType r10 = AoRequestType.HOST;
        Intrinsics.checkNotNullParameter(r10, "libType");
        Intrinsics.checkNotNullParameter("GET", "method");
        AoNetRequest r11 = new AoNetRequest(r5, "GET", r6, false, true, false, false, true, new c(r7), true, r10, null, 60000, 60000, 60000, true, null, false, r9);
        Function0<String> r12 = AoNet.a;
        AoNetResponse r13 = AoNet.d(r11).execute();
        final com.bytedance.awemeopen.infra.plugs.settings.a r14 = new com.bytedance.awemeopen.infra.plugs.settings.a();
        r14.a = r13.getCode();
        r14.b = r13.getMessage();
        String r15 = r13.stringBody();     // Catch: Exception -> L10
        AoLogger.g(r4, new Object[]{"Settings are: " + r15});     // Catch: Exception -> L8
        JSONObject r2 = new JSONObject(r15);     // Catch: Exception -> L8
        boolean r16 = TextUtils.equals("success", JSONObjectProtectorUtils.getString(r2, "err_tips"));     // Catch: Exception -> L8
        r14.c = r16;     // Catch: Exception -> L8
        if (r16 == false) goto L13;
        r14.d = JSONObjectProtectorUtils.getJSONObject(r2, "data");     // Catch: Exception -> L8
    L13:
        final long r17 = System.currentTimeMillis() - r1;
        AoPool.a(new BdpMainSettingsUpdater$reportEventAboutSettingsRequestResult$1(r14, r32, r17, r35));
        if (r14.a == 200) goto L17;
        return null;
    L17:
        if (r14.d != null) goto L19;
        new JSONObject();
    L19:
        long r18 = System.currentTimeMillis();
        if (r14.d != null) goto L22;
        new JSONObject();
    L22:
        JSONObject r19 = r14.d;
        if (r19 != null) goto L26;
        r19 = new JSONObject();
    L26:
        return new SettingsModel(r18, r19);
    L8:
        e = e;
    L12:
        AoLogger.c(BdpAppSettingsServiceImpl.b, new Object[]{"parse_json_error", e});
        AoNpthService r20 = AoExceptionReporter.a;
        AoExceptionReporter.a(ErrorPriority.p1, "settings", "parse_json_error", "code" + r14.a + ",msg" + r14.b + ",rawResponse:" + StringsKt.take(r15, 200), e);
    L10:
        e = e;
        r15 = "";
        goto L12
    }
}
