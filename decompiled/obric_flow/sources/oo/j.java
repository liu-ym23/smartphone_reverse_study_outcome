package oo;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.anniex.container.AnnieXContainer;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.services.apm.api.IEnsure;
import com.ss.android.agilelogger.ALog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.g0;
import okhttp3.internal.Util;
import okhttp3.l0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IEnsure f20816a;

    public static long a() {
        xs.b r5 = ALog.sConfig;     // Catch: Exception -> L4
        return ((Long) ALog.class.getMethod("getALogSimpleWriteFuncAddr", null).invoke(null, null)).longValue();
    L4:
        e = move-exception;
        Log.e("vmsdk", "No ALog found in the host [ " + e.getMessage() + " ]");
        return 0;
    }

    public static com.bytedance.android.monitorV2.event.a b() {
        Intrinsics.checkNotNullParameter("blank", "eventType");
        return c("blank", null, null);
    }

    public static com.bytedance.android.monitorV2.event.a c(String r5, t4.a r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r5, "eventType");
        Intrinsics.checkNotNullParameter(r5, "eventType");
        com.bytedance.android.monitorV2.event.a r12 = new com.bytedance.android.monitorV2.event.a(r5);
        r12.f3550m = r10;
        if (r11 == null) goto L5;
        r11.invoke(r12);
    L5:
        r12.e();
        return r12;
    }

    public static String d() {
        Class<?> r5 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L5
        return (String) r5.getMethod("get", new Class[]{String.class, String.class}).invoke(r5, new Object[]{"ro.build.version.emui", ""});
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static OkHttpClient e(final String r5, final String r10) {
        Intrinsics.checkNotNullParameter(r5, "userName");
        Intrinsics.checkNotNullParameter(r10, "password");
        l0 r11 = new l0();
        TimeUnit r12 = TimeUnit.SECONDS;
        r11.a(10, r12);
        r11.c(10, r12);
        r11.d(10, r12);
        Intrinsics.checkNotNullParameter(r12, "unit");
        r11.f20693w = Util.checkDuration("timeout", 30, r12);
        g0 r13 = new t1.a(r5, r10);
        Intrinsics.checkNotNullParameter(r13, "interceptor");
        r11.f20678c.add(r13);
        r11.f20679h = false;
        return new OkHttpClient(r11);
    }

    public static JSONObject f(JSONObject r10) {
        JSONObject r5 = new JSONObject();
        if (r10 == null) goto L27;
        String r11 = r10.optString(LynxMonitorService.KEY_PID, "");
        if (r11.length() <= 0) goto L7;
        qo.a.t(LynxMonitorService.KEY_PID, r11, r5);
    L7:
        String r12 = r10.optString("bid", "");
        if (r12.length() <= 0) goto L10;
        qo.a.t("bid", r12, r5);
    L10:
        JSONObject r13 = r10.optJSONObject("context");
        if (r13 == null) goto L21;
        Iterator<String> r14 = r13.keys();
    L14:
        if (r14.hasNext() == false) goto L20;
        String r15 = r14.next();
        Object r16 = r13.get(r15);
        if (r16 == null) goto L14;
        if ((r16 instanceof String) == true) goto L14;
        qo.a.t(r15, r16.toString(), r13);
        goto L14
    L20:
        qo.a.j(r13, "context", r5);
    L21:
        String r17 = r10.optString("env", "");
        if (r17.length() <= 0) goto L24;
        qo.a.t("env", r17, r5);
    L24:
        String r18 = r10.optString("release", "");
        if (r18.length() <= 0) goto L27;
        qo.a.t("release", r18, r5);
    L27:
        return r5;
    }

    public static void g(AnnieXContainer r5, StringBuilder r10) {
        r10.append(r5.getUrl());
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXContainer", r10.toString(), null, 12);
    }

    public static void h(Throwable r5, String r10) {
        IEnsure r11 = f20816a;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.ensureNotReachHere(r5, r10);
    }

    public static String i() {
        BufferedReader r5 = new BufferedReader(new FileReader("/proc/self/cmdline"));     // Catch: Throwable -> L14 Exception -> L16
    L35:
        String r10 = r5.readLine();     // Catch: Throwable -> L10 Exception -> L26
        if (TextUtils.isEmpty(r10) == true) goto L27;
        String r11 = r10.trim();     // Catch: Throwable -> L10 Exception -> L26
        if (TextUtils.isEmpty(r11) == true) goto L27;
        r5.close();     // Catch: Exception -> L23
    L9:
        return r11;
    L27:
        r5.close();     // Catch: Exception -> L24
    L22:
        return null;
    L10:
        Throwable th2 = th;
    L17:
        if (r5 != null) goto L29;
    L19:
        throw th2;
    L29:
        r5.close();     // Catch: Exception -> L25
    L20:
        if (r5 == null) goto L22;
    L16:
        r5 = null;
    L14:
        th = move-exception;
        r5 = null;
        th2 = th;
        goto L17
    }
}
