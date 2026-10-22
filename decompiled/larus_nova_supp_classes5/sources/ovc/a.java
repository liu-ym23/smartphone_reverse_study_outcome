package ovc;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient$TransportMode;
import java.net.CookieHandler;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;
import org.chromium.CronetClient;
import org.chromium.c;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static CronetEngine o = null;
    public static volatile String p = "";
    public static final String q = null;
    public static volatile AtomicInteger r;
    public static volatile int s;
    public final IWsChannelClient a;
    public final AtomicBoolean b;
    public final AtomicBoolean c;
    public final AtomicInteger d;
    public int e;
    public int f;
    public final Map<Integer, Boolean> g;
    public CronetFrontierClient h;
    public final AtomicBoolean i;
    public volatile int j;
    public volatile boolean k;
    public TTWebsocketConnection l;
    public final e m;
    public b n;

    public static Map e() {
        return (Map) a("com.bytedance.ttnet.clientkey.ClientKeyManager").getMethod("getClientKeyHeaders", new Class[0]).invoke(null, new Object[0]);
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final void d() {
        TTWebsocketConnection r0 = this.l;
        if (r0 == null) goto L5;
        r0.stopConnection();
        this.l.destroyConnection();
    L5:
        CronetFrontierClient r1 = this.h;
        if (r1 == null) goto L56;
        r1.destroy();
        if (com.bytedance.frameworks.baselib.network.http.util.a.d == null) goto L10;
    L19:
        com.bytedance.frameworks.baselib.network.http.util.a r2 = com.bytedance.frameworks.baselib.network.http.util.a.d;
        String r3 = q;
        r2.getClass();
        if (TextUtils.isEmpty(r3) == false) goto L44;
    L40:
        this.i.set(false);
        return;
    L44:
        Iterator r4 = r2.c.entrySet().iterator();     // Catch: Throwable -> L38
    L24:
        if (r4.hasNext() == false) goto L28;
        Runnable r5 = (com.bytedance.frameworks.baselib.network.http.util.b) ((Map.Entry) r4.next()).getKey();     // Catch: Throwable -> L38
        if (r3.equals(((com.bytedance.frameworks.baselib.network.http.util.b) r5).a) == false) goto L24;
        r4.remove();     // Catch: Throwable -> L38
        r2.a.remove(r5);     // Catch: Throwable -> L38
        goto L24
    L28:
        Iterator r6 = r2.b.entrySet().iterator();     // Catch: Throwable -> L38
    L29:
        if (r6.hasNext() == false) goto L40;
        Map.Entry r7 = (Map.Entry) r6.next();     // Catch: Throwable -> L38
        if (r3.equals(((com.bytedance.frameworks.baselib.network.http.util.b) r7.getKey()).a) == false) goto L29;
        ScheduledFuture r8 = (ScheduledFuture) r7.getValue();     // Catch: Throwable -> L38
        if (r8 == null) goto L36;
        r8.cancel(true);     // Catch: Throwable -> L38
    L36:
        r6.remove();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        Logger.e(com.bytedance.frameworks.baselib.network.http.util.a.e, "removeTask failed", th);
        goto L40
    L10:
        monitor-enter(com.bytedance.frameworks.baselib.network.http.util.a.class);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (com.bytedance.frameworks.baselib.network.http.util.a.d != null) goto L14;
        com.bytedance.frameworks.baselib.network.http.util.a.d = new com.bytedance.frameworks.baselib.network.http.util.a();     // Catch: Throwable -> L16
    L14:
        monitor-exit(com.bytedance.frameworks.baselib.network.http.util.a.class);     // Catch: Throwable -> L16
        goto L19
    }

    static {
        q = UUID.randomUUID().toString();
        CronetFrontierClient$TransportMode r0 = CronetFrontierClient$TransportMode.UNKNOWN;
        r = new AtomicInteger(0);
        s = -1;
    }

    public a(IWsChannelClient r3) {
        this.b = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
        this.d = new AtomicInteger(0);
        this.e = 10000;
        this.f = 10000;
        this.g = new ConcurrentHashMap();
        this.i = new AtomicBoolean(false);
        this.j = -1;
        this.k = false;
        this.a = r3;
        this.m = new e(r3);
        Object r4 = a("com.bytedance.ttnet.TTNetInit").newInstance();     // Catch: Throwable -> L5
        Reflect.on(r4).call("getInitCompletedLatch");     // Catch: Throwable -> L5
        Reflect.on(r4).call("preInitCronetKernel");     // Catch: Throwable -> L5
    L9:
        o = CronetClient.getCronetEngine();
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        if (Logger.debug() == false) goto L9;
        Logger.d("CronetFrontierConnection", "TTNet init failed, cronet engine is null.");
        goto L9
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static boolean c(a r2) {
        if (((ConcurrentHashMap) r2.g).isEmpty() == true) goto L16;
        Iterator r3 = ((ConcurrentHashMap) r2.g).entrySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        if (((Boolean) ((Map.Entry) r3.next()).getValue()).booleanValue() == true) goto L7;
        return false;
    L11:
        return true;
    L16:
        return false;
    }

    public static String f(URI r5) {
        HashMap r0 = new HashMap();
        StringBuilder r1 = new StringBuilder();
        Map<String, List<String>> r2 = null;
        CookieHandler r3 = CookieHandler.getDefault();     // Catch: Exception -> L25
        if (r3 == null) goto L6;
        r2 = r3.get(r5, r0);     // Catch: Exception -> L25
    L6:
        if (r2 == null) goto L24;
        if (r2.size() <= 0) goto L24;
        Iterator<Map.Entry<String, List<String>>> r6 = r2.entrySet().iterator();
    L11:
        if (r6.hasNext() == false) goto L24;
        Map.Entry<String, List<String>> r4 = r6.next();
        if ("cookie".equalsIgnoreCase(r4.getKey()) == false) goto L11;
        if (r4.getValue().isEmpty() == true) goto L11;
        Iterator<String> r7 = r4.getValue().iterator();
        int r8 = 0;
    L18:
        if (r7.hasNext() == false) goto L11;
        String r9 = r7.next();
        if (r8 <= 0) goto L22;
        r1.append("; ");
    L22:
        r1.append(r9);
        r8 = r8 + 1;
    L24:
        return r1.toString();
    L25:
        return null;
    }

    public static void b(a r2, JSONObject r3) throws JSONException {
        r2.getClass();
        r3.put("report_type", 1);
        r3.put("report_time", System.currentTimeMillis());
        if (Logger.debug() == false) goto L5;
        Logger.d("CronetFrontierConnection", "report log:" + r3.toString());
    L5:
        c.h().k(r3.toString(), "private_protocol");
    }

    public final void g(Map<String, Object> r11, List<String> r12) {
        this.b.set(false);
        this.c.set(false);
        r.incrementAndGet();
        Object r1 = r11.get("channel_id");
        if (r1 != null) goto L5;
        int r2 = -1;
    L7:
        if (s != (-1)) goto L12;
        if (r2 <= 0) goto L12;
        if (r.get() != 1) goto L12;
        s = r2;
    L12:
        TTWebsocketConnection.Builder r3 = o.newWebsocketConnectionBuilder(this.m, PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("CronetFrontierConnection")));
        r3.setUrlList(r12);     // Catch: Throwable -> L63
        r3.setAppKey(String.valueOf(r11.get("app_key")));     // Catch: Throwable -> L63
        r3.setFpid(((Integer) r11.get("fpid")).intValue());     // Catch: Throwable -> L63
        r3.setAppVersion(((Integer) r11.get(EffectConfiguration.KEY_APP_VERSION)).intValue());     // Catch: Throwable -> L63
        r3.setAppId(((Integer) r11.get(EffectConfiguration.KEY_APP_ID)).intValue());     // Catch: Throwable -> L63
        r3.setDeviceId(CastLongProtector.parseLong((String) r11.get(EffectConfiguration.KEY_DEVICE_ID)));     // Catch: Throwable -> L63
        r3.setInstallId(CastLongProtector.parseLong((String) r11.get("iid")));     // Catch: Throwable -> L63
        r3.setSharedConnection(false);     // Catch: Throwable -> L63
        if (r11.containsKey("sid") == false) goto L16;
        r3.setSessionId((String) r11.get("sid"));     // Catch: Throwable -> L63
    L16:
        String r13 = (String) r11.get(DBDefinition.EXTRA);     // Catch: Throwable -> L63
        HashMap r0 = new HashMap();     // Catch: Throwable -> L63
        if (TextUtils.isEmpty(r13) == true) goto L66;
        String[] r14 = r13.split("&");     // Catch: Throwable -> L63
        int r4 = r14.length;     // Catch: Throwable -> L63
        int r5 = 0;
    L19:
        if (r5 >= r4) goto L66;
        String r6 = r14[r5];     // Catch: Throwable -> L63
        if (TextUtils.isEmpty(r6) == true) goto L25;
        String[] r7 = r6.split("=");     // Catch: Throwable -> L63
        if (r7.length != 2) goto L25;
        r0.put(r7[0], r7[1]);     // Catch: Throwable -> L63
    L25:
        r5 = r5 + 1;
    L66:
        HashMap r15 = new HashMap();     // Catch: Throwable -> L42
        Map r8 = e();     // Catch: Throwable -> L42
        if (Logger.debug() == false) goto L29;
        Logger.d("CronetFrontierConnection", "Client key: " + r8);     // Catch: Throwable -> L42
    L29:
        if (r8 != null) goto L31;
    L33:
        Map r16 = (Map) r11.get("custom_headers");     // Catch: Throwable -> L42
        if (r16 == null) goto L39;
        if (r16.isEmpty() == true) goto L39;
        r15.putAll(r16);     // Catch: Throwable -> L42
    L39:
        if (r15.isEmpty() == true) goto L44;
        r3.setCustomizedHeaders(r15);     // Catch: Throwable -> L42
    L44:
        b r17 = this.n;     // Catch: Throwable -> L63
        if (r17 == null) goto L60;
        long r9 = 0;
        if (b.e == true) goto L49;
        long r18 = 0;
    L51:
        if (r18 <= 0) goto L60;
        b r19 = this.n;     // Catch: Throwable -> L63
        if (b.e == true) goto L55;
        r19.getClass();     // Catch: Throwable -> L63
    L57:
        if (Logger.debug() == false) goto L59;
        Logger.d("CronetFrontierConnection", "WS destroy timeout:" + r9);     // Catch: Throwable -> L63
    L59:
        r0.put("ttnet_timeout_millis", String.valueOf(r9));     // Catch: Throwable -> L63
        goto L60
    L55:
        r9 = r19.a;     // Catch: Throwable -> L63
        goto L57
    L49:
        r18 = r17.a;     // Catch: Throwable -> L63
    L60:
        r3.setCustomizedParams(r0);     // Catch: Throwable -> L63
        TTWebsocketConnection r110 = r3.build();
        this.l = r110;
        r110.startConnection();
        return;
    L31:
        if (r8.isEmpty() == true) goto L33;
        r15.putAll(r8);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        th.printStackTrace();
        throw new IllegalArgumentException("configMap contain err params !!!");
    L5:
        r2 = ((Integer) r1).intValue();
        goto L7
    }
}
