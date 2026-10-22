package e4;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.news.common.settings.api.annotation.ILocalSettings;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.model.SettingsByteSyncModel;
import com.bytedance.news.common.settings.api.model.SettingsRequestModel;
import com.bytedance.news.common.settings.api.request.RequestV3Service;
import com.bytedance.news.common.settings.internal.g;
import com.bytedance.news.common.settings.internal.i;
import com.bytedance.news.common.settings.internal.k;
import com.service.middleware.applog.ApplogService;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f8618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile e4.a f8619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f8620c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<f, Boolean> f8621d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final i f8622e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final g f8623f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile e4.b f8624g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static SettingsByteSyncModel f8625h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f8626i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f8627j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile boolean f8628k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static long f8629l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static long f8630m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile boolean f8631n;

    static class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f8632c;

        a(boolean r10) {
            this.f8632c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a(this.f8632c);
        }
    }

    static class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map.Entry f8633c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f4.d f8634g;

        b(Map.Entry r10, f4.d r11) {
            this.f8633c = r10;
            this.f8634g = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((f) this.f8633c.getKey()).a(this.f8634g);
        }
    }

    static class c implements oa.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SettingsConfigProvider f8635a;

        c(SettingsConfigProvider r10) {
            this.f8635a = r10;
        }
    }

    static {
        f8620c = new Handler(Looper.getMainLooper());
        f8621d = new ConcurrentHashMap();
        f8622e = new i();
        f8623f = new g();
        f8625h = null;
        f8628k = true;
        f8629l = 0;
        f8630m = 0;
        f8631n = false;
    }

    public e() {
    }

    static /* synthetic */ f4.c a(boolean r10) {
        return d(r10);
    }

    private static void b() {
        if (f8618a == true) goto L29;
        monitor-enter(e.class);
    L25:
        th = move-exception;
        throw th;
    L7:
        if (f8618a == true) goto L23;
        SettingsConfigProvider r10 = (SettingsConfigProvider) c4.d.a(SettingsConfigProvider.class);     // Catch: Throwable -> L25
        if (r10 == null) goto L11;
        e4.b r11 = r10.getConfig();     // Catch: Throwable -> L25
    L12:
        if (r11 == null) goto L14;
    L18:
        if (r11 == null) goto L23;
        r11.s("");     // Catch: Throwable -> L25
        com.bytedance.news.common.settings.internal.b.c(r11.b());     // Catch: Throwable -> L25
        h4.a.f(r11.c());     // Catch: Throwable -> L25
        f8624g = r11;     // Catch: Throwable -> L25
        h4.a.g(r11);     // Catch: Throwable -> L25
        h4.a.i(r11.r());     // Catch: Throwable -> L25
        h4.a.f(r11.c());     // Catch: Throwable -> L25
        h4.a.h(System.currentTimeMillis());     // Catch: Throwable -> L25
        ApplogService r12 = (ApplogService) c4.d.a(ApplogService.class);     // Catch: Throwable -> L25
        if (r12 == null) goto L22;
        r12.registerHeaderCustomCallback(new c(r10));     // Catch: Throwable -> L25
    L22:
        f8618a = true;     // Catch: Throwable -> L25
        f8626i = System.currentTimeMillis();     // Catch: Throwable -> L25
        goto L23
    L14:
        if (f8619b == null) goto L16;
        r11 = f8619b.create();     // Catch: Throwable -> L25
    L17:
        f8619b = null;     // Catch: Throwable -> L25
        goto L18
    L16:
        r11 = null;
        goto L17
    L11:
        r11 = null;
    L23:
        monitor-exit(e.class);     // Catch: Throwable -> L25
    L29:
        if (f8624g == null) goto L32;
        return;
    L32:
        throw new IllegalStateException("SettingsManager尚未被配置");
    }

    private static f4.c c(@NonNull f4.c r10) {
        if (r10.f8845b != null) goto L23;
        return r10;
    L23:
        if (com.bytedance.news.common.settings.internal.f.c(com.bytedance.news.common.settings.internal.b.b()).e() == false) goto L21;
        boolean r11 = true;
        JSONObject r12 = null;
        JSONObject r13 = com.bytedance.news.common.settings.internal.f.c(com.bytedance.news.common.settings.internal.b.b()).b();     // Catch: Exception -> L22
        if (r10.f8845b.a() == null) goto L10;
        r12 = r10.f8845b.a();     // Catch: Exception -> L22
        Iterator<String> r14 = r13.keys();     // Catch: Exception -> L22
    L14:
        if (r14.hasNext() == false) goto L18;
        String r15 = r14.next();     // Catch: Exception -> L22
        Object r16 = r13.opt(r15);     // Catch: Exception -> L22
        if (TextUtils.equals(String.valueOf(r16), String.valueOf(r12.opt(r15))) == true) goto L14;
        r12.put(r15, r16);     // Catch: Exception -> L22
        r11 = false;
    L18:
        if (r11 == false) goto L20;
        com.bytedance.news.common.settings.internal.f.c(com.bytedance.news.common.settings.internal.b.b()).f();     // Catch: Exception -> L22
        goto L21
    L20:
        r10.f8845b = new f4.d(r12, r10.f8845b.c(), r10.f8845b.b(), r10.f8845b.d());     // Catch: Exception -> L22
        goto L21
    L10:
        if (r13.length() <= 0) goto L18;
        r12 = r13;
        r11 = false;
    L21:
        return r10;
    }

    private static f4.c d(boolean r10) {
        SettingsConfigProvider r11 = (SettingsConfigProvider) c4.d.a(SettingsConfigProvider.class);
        boolean r12 = true;
        f4.c r13 = null;
        if (r11 != null) goto L5;
    L16:
        boolean r14 = true;
        String r15 = null;
    L17:
        if (r14 == false) goto L50;
        long r16 = System.currentTimeMillis();
        if (r10 == false) goto L21;
    L24:
        if (r10 == false) goto L26;
    L27:
        f8631n = true;
        f8630m = r16;
        if (TextUtils.isEmpty(r15) == true) goto L33;
        SettingsRequestModel r17 = new SettingsRequestModel();
        r17.urlParams = r15;
        if (r15.contains("pull_task_data") == false) goto L32;
        r17.isReturnCtxInfo = false;
    L35:
        RequestV3Service r18 = f8624g.i();
        if (r12 == false) goto L39;
        if (r18 != null) goto L40;
    L42:
        if (r13 != null) goto L44;
    L46:
        f8627j = System.currentTimeMillis();
        f8631n = false;
        if (f8628k == false) goto L49;
        f8628k = false;
    L49:
        return r13;
    L44:
        if (r13.f8844a == false) goto L46;
        f(c(r13));
        f8629l = r16;
    L40:
        r13 = r18.requestV3(r17);
        goto L42
    L39:
        if (r18 != null) goto L40;
        r13 = f8624g.h().a();
        goto L42
    L32:
        r17.isReturnCtxInfo = true;
    L34:
        r12 = false;
        goto L35
    L33:
        r17 = null;
        goto L34
    L26:
        if ((r16 - f8630m) > f8624g.j()) goto L27;
    L60:
        return null;
    L21:
        if ((r16 - f8629l) <= f8624g.n()) goto L60;
        if (k.a(f8624g.b()) == false) goto L60;
    L50:
        if (r11 == null) goto L60;
        if (r11.getConfig() == null) goto L60;
        f4.e r19 = r11.getConfig().k();
        if (r19 == null) goto L60;
        r19.e("SettingsManager", "settings 请求不可以在非主进程请求，否则会出现子进程请求覆盖主进程的结果");
        if (r19.a() == false) goto L60;
        throw new IllegalStateException("settings 请求不可以在非主进程请求，否则会出现子进程请求覆盖主进程的结果");
    L5:
        if (r11.getConfig() == null) goto L16;
        r14 = r11.getConfig().p();
        f4.e r20 = r11.getConfig().k();
        if (r20 == null) goto L9;
        r20.d("SettingsManager", "isMainProcess = " + r14);
    L9:
        StringBuilder r21 = new StringBuilder();
        r11.getConfig().g();
        if (f8625h == null) goto L12;
        r21.append("&pull_task_data=");
        r21.append(f8625h.taskData);
        r21.append("&pull_task_ids=");
        r21.append(f8625h.taskId);
        f8625h = null;
    L15:
        r15 = r21.toString();
        goto L17
    L12:
        String r22 = g4.a.b(com.bytedance.news.common.settings.internal.b.b()).a();
        if (TextUtils.isEmpty(r22) == true) goto L15;
        r21.append("&ctx_infos=");
        r21.append(r22);
        goto L15
    }

    public static boolean e(@NonNull SettingsByteSyncModel r10) {
        if (r10.timeStamp >= Math.max(f8626i, f8627j)) goto L6;
        Log.e("SettingsManager", "settingsByteSyncModel.timeStamp = " + r10.timeStamp + " initTime = " + f8626i + " requestTime = " + f8627j);
        return false;
    L6:
        return true;
    }

    private static void f(@NonNull f4.c r10) {
        f4.d r11 = r10.f8845b;
        if (r11 == null) goto L6;
        f8622e.d(r11, f8624g, f8628k);
    L6:
        if (r10.f8846c != null) goto L15;
    L11:
        g4.a.b(com.bytedance.news.common.settings.internal.b.b()).c(r10.f8847d);
        g4.a.b(com.bytedance.news.common.settings.internal.b.b()).d(r10.f8848e);
        f4.d r12 = com.bytedance.news.common.settings.internal.f.c(com.bytedance.news.common.settings.internal.b.b()).d(f8624g.e());
        if (r12 == null) goto L17;
        h(r12);
        return;
    L17:
        return;
    L15:
        h4.a.a(com.bytedance.news.common.settings.internal.b.b()).k(r10.f8846c);     // Catch: RuntimeException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    @NonNull
    public static <T> T g(Class<T> r10) {
        b();
        if (ISettings.class.isAssignableFrom(r10) == false) goto L7;
        return (T) f8622e.c(r10, f8624g, "");
    L7:
        if (ILocalSettings.class.isAssignableFrom(r10) == false) goto L11;
        return (T) f8623f.b(r10, f8624g, "");
    L11:
        throw new IllegalArgumentException("tClass必须是ISettings或ILocalSettings的子类");
    }

    private static void h(f4.d r10) {
        Iterator<Map.Entry<f, Boolean>> r11 = f8621d.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        Map.Entry<f, Boolean> r12 = r11.next();
        if (r12 == null) goto L4;
        if (r12.getValue().booleanValue() == true) goto L9;
        r12.getKey().a(r10);
        goto L4
    L9:
        f8620c.post(new b(r12, r10));
        goto L4
    }

    public static void i(f r10, boolean r11) {
        f8621d.put(r10, Boolean.valueOf(r11));
    }

    public static void j(@NonNull SettingsByteSyncModel r10) {
        f8625h = r10;
    }

    public static void k(@NonNull JSONObject r10) {
        f4.d r11 = com.bytedance.news.common.settings.internal.f.c(com.bytedance.news.common.settings.internal.b.b()).d(f8624g.e());
        if (r11 == null) goto L24;
        JSONObject r12 = r11.a();
        if (r12 == null) goto L15;
        Iterator<String> r13 = r10.keys();
    L8:
        if (r13.hasNext() == false) goto L15;
        String r14 = r13.next();
        if (r12.has(r14) == false) goto L8;
        r12.put(r14, r10.opt(r14));     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L15:
        f8622e.d(r11, f8624g, false);
        h(r11);
        return;
    }

    public static void l(boolean r10) {
        b();
        if (f8631n == false) goto L5;
        return;
    L5:
        f8624g.d().execute(new a(r10));
    }
}
