package com.bytedance.news.common.settings;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.news.common.settings.api.annotation.ILocalSettings;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.model.SettingsByteSyncModel;
import com.bytedance.news.common.settings.api.model.SettingsRequestModel;
import com.bytedance.news.common.settings.api.request.RequestV3Service;
import com.bytedance.news.common.settings.internal.g;
import com.bytedance.news.common.settings.internal.i;
import com.bytedance.news.common.settings.internal.k;
import com.service.middleware.applog.ApplogService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f2935a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f2936b;
    public static long c;
    private static volatile boolean d;
    private static volatile a e;
    private static final ConcurrentHashMap<f, Boolean> f = null;
    private static final i g = null;
    private static final g h = null;
    private static volatile b i;
    private static SettingsByteSyncModel j;
    private static volatile boolean k;
    private static long l;
    private static long m;
    private static volatile boolean n;

    static {
        f2935a = new Handler(Looper.getMainLooper());
        f = new ConcurrentHashMap();
        g = new i();
        h = new g();
        j = null;
        k = true;
        l = 0;
        m = 0;
        n = false;
    }

    public e() {
    }

    private static com.bytedance.news.common.settings.api.c a(com.bytedance.news.common.settings.api.c r10) {
        if (r10.f2921b != null) goto L23;
        return r10;
    L23:
        if (com.bytedance.news.common.settings.internal.f.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.news.common.settings.internal.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).a() == false) goto L21;
        boolean r1 = true;
        JSONObject r2 = null;
        JSONObject r3 = com.bytedance.news.common.settings.internal.f.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.news.common.settings.internal.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).b();     // Catch: Exception -> L22
        if (r10.f2921b.a() == null) goto L10;
        r2 = r10.f2921b.a();     // Catch: Exception -> L22
        Iterator<String> r4 = r3.keys();     // Catch: Exception -> L22
    L14:
        if (r4.hasNext() == false) goto L18;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L22
        Object r7 = r3.opt(r6);     // Catch: Exception -> L22
        if (TextUtils.equals(String.valueOf(r7), String.valueOf(r2.opt(r6))) == true) goto L14;
        r2.put(r6, r7);     // Catch: Exception -> L22
        r1 = false;
    L18:
        if (r1 == false) goto L20;
        com.bytedance.news.common.settings.internal.f.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.news.common.settings.internal.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).c();     // Catch: Exception -> L22
        goto L21
    L20:
        r10.f2921b = new com.bytedance.news.common.settings.api.e(r2, r10.f2921b.b(), r10.f2921b.c(), r10.f2921b.d());     // Catch: Exception -> L22
        goto L21
    L10:
        if (r3.length() <= 0) goto L18;
        r2 = r3;
        r1 = false;
    L21:
        return r10;
    }

    public static <T> T a(Class<T> r3) {
        a();
        if (ISettings.class.isAssignableFrom(r3) == false) goto L7;
        return (T) g.a(r3, i, "");
    L7:
        if (ILocalSettings.class.isAssignableFrom(r3) == false) goto L11;
        return (T) h.a(r3, i, "");
    L11:
        throw new IllegalArgumentException("tClass必须是ISettings或ILocalSettings的子类");
    }

    private static void a() {
        if (d == true) goto L29;
        monitor-enter(e.class);
    L25:
        th = move-exception;
        throw th;
    L7:
        if (d == true) goto L23;
        final SettingsConfigProvider r1 = (SettingsConfigProvider) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(SettingsConfigProvider.class), SettingsConfigProvider.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        b r3 = r1.getConfig();     // Catch: Throwable -> L25
    L12:
        if (r3 == null) goto L14;
    L18:
        if (r3 == null) goto L23;
        r3.a("");     // Catch: Throwable -> L25
        com.bytedance.news.common.settings.internal.b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L25
        com.bytedance.news.common.settings.api.b.a.a(r3.m());     // Catch: Throwable -> L25
        i = r3;     // Catch: Throwable -> L25
        com.bytedance.news.common.settings.api.b.a.a(r3);     // Catch: Throwable -> L25
        com.bytedance.news.common.settings.api.b.a.b(r3.l());     // Catch: Throwable -> L25
        com.bytedance.news.common.settings.api.b.a.a(r3.m());     // Catch: Throwable -> L25
        com.bytedance.news.common.settings.api.b.a.a(System.currentTimeMillis());     // Catch: Throwable -> L25
        ApplogService r2 = (ApplogService) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(ApplogService.class), ApplogService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L22;
        r2.registerHeaderCustomCallback(new AnonymousClass3(r1));     // Catch: Throwable -> L25
    L22:
        d = true;     // Catch: Throwable -> L25
        f2936b = System.currentTimeMillis();     // Catch: Throwable -> L25
        goto L23
    L14:
        if (e == null) goto L16;
        r3 = e.a();     // Catch: Throwable -> L25
    L17:
        e = null;     // Catch: Throwable -> L25
        goto L18
    L16:
        r3 = null;
        goto L17
    L11:
        r3 = null;
    L23:
        monitor-exit(e.class);     // Catch: Throwable -> L25
    L29:
        if (i == null) goto L32;
        return;
    L32:
        throw new IllegalStateException("SettingsManager尚未被配置");
    }

    private static void a(final com.bytedance.news.common.settings.api.e r5) {
        Iterator<Map.Entry<f, Boolean>> r0 = f.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        final Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L4;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r1.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L9;
        ((f) ZeusTransformUtils.preCheckCast(r1.getKey(), f.class, "com.obric.memorydata.plugin")).a(r5);
        goto L4
    L9:
        f2935a.post(new AnonymousClass2(r1, r5));
        goto L4
    }

    public static void a(f r2, boolean r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin");
        f.put(r4, Boolean.valueOf(r3));
    }

    public static void a(JSONObject r6) {
        com.bytedance.news.common.settings.api.e r0 = com.bytedance.news.common.settings.internal.f.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.news.common.settings.internal.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).a(i.s());
        if (r0 == null) goto L24;
        JSONObject r2 = r0.a();
        if (r2 == null) goto L15;
        Iterator<String> r3 = r6.keys();
    L8:
        if (r3.hasNext() == false) goto L15;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        if (r2.has(r4) == false) goto L8;
        r2.put(r4, r6.opt(r4));     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L15:
        g.a(r0, i, false);
        a(r0);
        return;
    }

    public static void a(final boolean r2) {
        a();
        if (n == false) goto L5;
        return;
    L5:
        i.c().execute(new AnonymousClass1(r2));
    }

    public static boolean a(SettingsByteSyncModel r6) {
        if (r6.timeStamp >= Math.max(f2936b, c)) goto L6;
        Log.e("SettingsManager", "settingsByteSyncModel.timeStamp = " + r6.timeStamp + " initTime = " + f2936b + " requestTime = " + c);
        return false;
    L6:
        return true;
    }

    static /* synthetic */ com.bytedance.news.common.settings.api.c b(boolean r0) {
        return c(r0);
    }

    private static void b(com.bytedance.news.common.settings.api.c r4) {
        if (r4.f2921b == null) goto L6;
        g.a(r4.f2921b, i, k);
    L6:
        if (r4.c != null) goto L15;
    L11:
        com.bytedance.news.common.settings.api.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.news.common.settings.internal.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).a(r4.d);
        com.bytedance.news.common.settings.api.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.news.common.settings.internal.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).a(r4.e);
        com.bytedance.news.common.settings.api.e r5 = com.bytedance.news.common.settings.internal.f.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.news.common.settings.internal.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).a(i.s());
        if (r5 == null) goto L17;
        a(r5);
        return;
    L17:
        return;
    L15:
        com.bytedance.news.common.settings.api.b.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.news.common.settings.internal.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).a(r4.c);     // Catch: RuntimeException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static void b(SettingsByteSyncModel r0) {
        j = r0;
    }

    private static com.bytedance.news.common.settings.api.c c(boolean r12) {
        SettingsConfigProvider r0 = (SettingsConfigProvider) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(SettingsConfigProvider.class), SettingsConfigProvider.class, "com.obric.memorydata.plugin");
        boolean r3 = true;
        com.bytedance.news.common.settings.api.c r4 = null;
        if (r0 != null) goto L5;
    L33:
        boolean r5 = true;
        String r6 = null;
    L34:
        if (r5 == false) goto L66;
        long r1 = System.currentTimeMillis();
        if (r12 == false) goto L38;
    L41:
        if (r12 == false) goto L43;
    L44:
        n = true;
        m = r1;
        if (TextUtils.isEmpty(r6) == true) goto L50;
        SettingsRequestModel r13 = new SettingsRequestModel();
        r13.urlParams = r6;
        if (r6.contains("pull_task_data") == false) goto L49;
        r13.isReturnCtxInfo = false;
    L51:
        RequestV3Service r7 = i.o();
        if (r3 == false) goto L55;
        if (r7 != null) goto L56;
    L58:
        if (r4 != null) goto L60;
    L62:
        c = System.currentTimeMillis();
        n = false;
        if (k == false) goto L65;
        k = false;
    L65:
        return r4;
    L60:
        if (r4.f2920a == false) goto L62;
        b(a(r4));
        l = r1;
    L56:
        r4 = r7.requestV3(r13);
        goto L58
    L55:
        if (r7 != null) goto L56;
        r4 = i.a().a();
        goto L58
    L49:
        r13.isReturnCtxInfo = true;
        r3 = false;
        goto L51
    L50:
        r3 = false;
        r13 = null;
        goto L51
    L43:
        if ((r1 - m) > i.e()) goto L44;
    L76:
        return null;
    L38:
        if ((r1 - l) <= i.d()) goto L76;
        if (k.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L76;
    L66:
        if (r0 == null) goto L76;
        if (r0.getConfig() == null) goto L76;
        com.bytedance.news.common.settings.api.f r14 = r0.getConfig().f();
        if (r14 == null) goto L76;
        r14.b("SettingsManager", "settings 请求不可以在非主进程请求，否则会出现子进程请求覆盖主进程的结果");
        if (r14.a() == false) goto L76;
        throw new IllegalStateException("settings 请求不可以在非主进程请求，否则会出现子进程请求覆盖主进程的结果");
    L5:
        if (r0.getConfig() == null) goto L33;
        r5 = r0.getConfig().g();
        com.bytedance.news.common.settings.api.f r8 = r0.getConfig().f();
        if (r8 == null) goto L9;
        r8.a("SettingsManager", "isMainProcess = " + r5);
    L9:
        StringBuilder r9 = new StringBuilder();
        com.bytedance.news.common.settings.api.model.a r10 = r0.getConfig().n();
        if (r10 == null) goto L27;
        r9.append("&device_platform=").append(r10.e);
        if (r10.f2924a == 0) goto L15;
        r9.append("&aid=").append(r10.f2924a);
    L15:
        if (r10.f2925b == 0) goto L17;
        r9.append("&iid=").append(r10.f2925b);
    L17:
        r9.append("&device_id=").append(r10.c);
        r9.append("&channel=").append(r10.d);
        if (TextUtils.isEmpty(r10.f) == true) goto L21;
        r9.append("&caller_name=").append(r10.f);
    L21:
        if (TextUtils.isEmpty(r10.g) == true) goto L24;
        r9.append("&region=").append(r10.g);
    L24:
        if (TextUtils.isEmpty(r10.h) == true) goto L27;
        r9.append("&language=").append(r10.h);
    L27:
        if (j == null) goto L29;
        r9.append("&pull_task_data=").append(j.taskData);
        r9.append("&pull_task_ids=").append(j.taskId);
        j = null;
    L32:
        r6 = r9.toString();
        goto L34
    L29:
        String r11 = com.bytedance.news.common.settings.api.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.news.common.settings.internal.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).a();
        if (TextUtils.isEmpty(r11) == true) goto L32;
        r9.append("&ctx_infos=").append(r11);
        goto L32
    }
}
