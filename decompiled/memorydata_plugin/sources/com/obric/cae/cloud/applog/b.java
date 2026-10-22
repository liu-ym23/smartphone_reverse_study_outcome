package com.obric.cae.cloud.applog;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.g;
import com.bytedance.applog.o;
import com.bytedance.applog.p;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallUrl;
import com.obric.cae.cloud.ttnet.c;
import com.obric.cae.utils.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f6938a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f6939b = "";
    public static String c = "";
    public static Context d;
    public static Application e;

    public class a implements g {
        public a() {
        }

        @Override // com.bytedance.applog.g
        public final void a(String r2, String r3, String r4) {
            com.obric.cae.log.a.c("ByteIOUtils", "onIdLoaded - did: " + r2 + ", iid: " + r3 + ", ssid: " + r4);
            if (r2 == null) goto L5;
            b.f6939b = r2;
        L5:
            if (r3 == null) goto L7;
            b.c = r3;
        L7:
            c.a(b.d, b.e);
        }

        @Override // com.bytedance.applog.g
        public final void a(boolean r2, String r3, String r4, String r5, String r6, String r7, String r8) {
            com.obric.cae.log.a.c("ByteIOUtils", "onRemoteIdGet - changed: " + r2 + ", oldDid: " + r3 + ", newDid: " + r4 + ", oldIid: " + r5 + ", newIid: " + r6 + ", oldSsid: " + r7 + ", newSsid: " + r8);
            if (r4 == null) goto L5;
            b.f6939b = r4;
        L5:
            if (r6 == null) goto L8;
            b.c = r6;
            return;
        }

        @Override // com.bytedance.applog.g
        public final void a(boolean r2, JSONObject r3) {
            StringBuilder r1 = new StringBuilder("onRemoteConfigGet - changed: ").append(r2).append(", config: ");
            if (r3 == null) goto L5;
            String r4 = r3.toString();
        L6:
            com.obric.cae.log.a.c("ByteIOUtils", r1.append(r4).toString());
            return;
        L5:
            r4 = "null";
            goto L6
        }
    }

    public static void a(Context r6, Application r7, boolean r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Application r10 = (Application) ZeusTransformUtils.wrapperContextForParams(r7, Application.class, "com.obric.memorydata.plugin");
        d = r9;
        e = r10;
        if (f6938a == false) goto L11;
        com.obric.cae.log.a.c("ByteIOUtils", "ByteIO already initialized");
        return;
    L11:
        com.obric.cae.log.a.c("ByteIOUtils", "Initializing ByteIO...");     // Catch: Exception -> L8
        o r11 = new o("941134", "cae_release");     // Catch: Exception -> L8
        r11.a("CAE");     // Catch: Exception -> L8
        r11.f(true);     // Catch: Exception -> L8
        PackageInfo r1 = r9.getPackageManager().getPackageInfo(r9.getPackageName(), 0);     // Catch: Exception -> L8
        long r4 = r1.getLongVersionCode();     // Catch: Exception -> L8
        String r2 = r1.versionName;     // Catch: Exception -> L8
        r11.a(r4);     // Catch: Exception -> L8
        r11.c(r4);     // Catch: Exception -> L8
        r11.c(r2);     // Catch: Exception -> L8
        r11.b(r4);     // Catch: Exception -> L8
        r11.a(new p.a().a(new Env(InstallUrl.createUriByDomain("https://log-klink.zijieapi.com"), false, false)).a(new String[]{"https://log.zijieapi.com/service/2/app_log/", "https://applog.zijieapi.com/service/2/app_log/"}).b(new String[]{"https://rtlog.zijieapi.com/service/2/app_log/"}).a("https://log.zijieapi.com/service/2/log_settings/").a());     // Catch: Exception -> L8
        r11.a(new com.obric.cae.cloud.applog.a());     // Catch: Exception -> L8
        r11.a(true);     // Catch: Exception -> L8
        r11.d(true);     // Catch: Exception -> L8
        r11.c(true);     // Catch: Exception -> L8
        AppLog.setEncryptAndCompress(false);     // Catch: Exception -> L8
        AppLog.setNewMonitorEnabled(true);     // Catch: Exception -> L8
        a(c());     // Catch: Exception -> L8
        d.a(r9);     // Catch: Exception -> L8
        AppLog.init(r9, r11);     // Catch: Exception -> L8
        f6938a = true;     // Catch: Exception -> L8
        com.obric.cae.log.a.c("ByteIOUtils", "ByteIO initialization successful");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.obric.cae.log.a.i("ByteIOUtils", "ByteIO initialization failed: " + e.getMessage());
        e.printStackTrace();
    }

    public static void a(g r2) {
        g r3 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        AppLog.addDataObserver(r3);
        com.obric.cae.log.a.c("ByteIOUtils", "Added data observer");
        return;
    }

    public static void a(String r3, JSONObject r4) {
        if (f6938a == true) goto L15;
        com.obric.cae.log.a.g("ByteIOUtils", "ByteIO not initialized, event not tracked: " + r3);
        return;
    L15:
        AppLog.onEventV3(r3, r4);     // Catch: Exception -> L12
        StringBuilder r5 = new StringBuilder("Tracked event V3: ").append(r3).append(" with params: ");     // Catch: Exception -> L12
        if (r4 == null) goto L9;
        String r6 = r4.toString();     // Catch: Exception -> L12
    L10:
        com.obric.cae.log.a.c("ByteIOUtils", r5.append(r6).toString());     // Catch: Exception -> L12
        return;
    L9:
        r6 = "null";
    L12:
        e = move-exception;
        com.obric.cae.log.a.a("ByteIOUtils", "Failed to track event V3: " + e.getMessage(), e);
    }

    public static boolean a() {
        return f6938a;
    }

    public static String b() {
        return f6939b;
    }

    public static g c() {
        return new a();
    }
}
