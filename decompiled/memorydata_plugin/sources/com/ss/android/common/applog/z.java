package com.ss.android.common.applog;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Cdid;
import com.bytedance.bdinstall.compat.Level;
import com.bytedance.bdinstall.compat.intf.IParamFilter;
import com.bytedance.bdinstall.util.SystemPropertiesWithCache;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.rpc.internal.RpcUtils;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f15113a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f15114b = null;
    public static final String[] c = null;
    private static y.a d;
    private static IParamFilter e;
    private static com.ss.android.common.a f;
    private static volatile boolean g;
    private static volatile boolean h;
    private static volatile int i;
    private static Object j;
    private static volatile String k;
    private static final ConcurrentHashMap<String, String> l = null;
    private static final ConcurrentHashMap<String, String> m = null;
    private static volatile y.b n;
    private static j o;

    static {
        f15113a = new String[]{"aid", "app_version", "tt_data", "device_id"};
        f15114b = new String[]{"tt_data", "device_platform", "aid", "device_id", "iid"};
        c = new String[]{"aid", "version_code", Api.KEY_AB_VERSION, "device_id", "iid", "device_platform"};
        f = null;
        j = new Object();
        k = "app_log_encrypt_switch_count";
        l = new ConcurrentHashMap();
        m = new ConcurrentHashMap();
    }

    static String a() {
        j r0 = o;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a();
    }

    static String a(com.bytedance.applog.k r6, String r7, byte[] r8, Context r9, boolean r10, String[] r11, Map<String, String> r12, String r13, final boolean r14, boolean r15) {
        com.bytedance.applog.k r16 = (com.bytedance.applog.k) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.applog.k.class, "com.obric.memorydata.plugin");
        Context r17 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Map r18 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        if (com.bytedance.common.utility.h.a(r7) == false) goto L5;
        return null;
    L5:
        if (r8 != null) goto L7;
    L69:
        b.b(r13, MonitorState.f_to_bytes_null);
        return null;
    L7:
        if (r8.length <= 0) goto L69;
        HashMap r0 = new HashMap();
        if (r7.contains("/service/2/app_log/") == false) goto L37;
        if (r16 == null) goto L37;
        com.bytedance.applog.d r19 = r16.a(r8);     // Catch: Throwable -> L35
        if (r19 != null) goto L15;
    L33:
        b.b(r13, MonitorState.f_to_bytes_compress);     // Catch: Throwable -> L35
        return null;
    L15:
        if (r19.a() == null) goto L33;
        byte[] r20 = r19.a();     // Catch: Throwable -> L35
        if (r19.c() != null) goto L20;
    L22:
        if (r17 == null) goto L30;
        a(r17);     // Catch: Throwable -> L35
        if (i >= 3) goto L29;
        byte[] r21 = com.bytedance.frameworks.core.encrypt.b.a(r20, r20.length);     // Catch: Throwable -> L35
        b(r17);     // Catch: Throwable -> L35
        if (r21 != null) goto L39;
        MonitorState r22 = MonitorState.f_to_bytes_encrypt;     // Catch: Throwable -> L35
    L28:
        b.b(r13, r22);     // Catch: Throwable -> L35
    L39:
        if (r21 == null) goto L68;
        String r23 = r7 + "&tt_data=a";
        if (r10 == false) goto L43;
        r23 = r23 + "&config_retry=b";
    L43:
        r0.put(NetConst.KEY_CONTENT_TYPE, "application/octet-stream;tt-data=a");
        if (r18 == null) goto L46;
        r0.putAll(r18);
    L46:
        if (r15 == true) goto L54;
        Pair<String, String> r24 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new AnonymousClass1(r14));     // Catch: Throwable -> L51
        if (r24 == null) goto L54;
        r0.put(r24.first, r24.second);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        th.printStackTrace();
    L54:
        if (com.ss.android.deviceregister.b.a.a.c.a(r11) == false) goto L66;
        byte[] r25 = com.bytedance.common.utility.f.a().b(r23, r21, r0, null);
        if (r25 == null) goto L64;
        byte[] r26 = com.ss.android.deviceregister.b.a.a.c.a(r25, r11[0], r11[1]);
        if (r26 != null) goto L62;
        return new String(r25);
    L62:
        return new String(com.ss.android.deviceregister.b.a.a.c.a(r26));
    L64:
        throw new RuntimeException("get encrypted resp failed");
    L66:
        return com.bytedance.common.utility.f.a().a(r23, r21, r0, null);
    L68:
        throw new RuntimeException("encrypt failed");
    L29:
        r21 = null;
        goto L39
    L30:
        r21 = com.bytedance.frameworks.core.encrypt.b.a(r20, r20.length);     // Catch: Throwable -> L35
        if (r21 != null) goto L39;
        r22 = MonitorState.f_to_bytes_encrypt;     // Catch: Throwable -> L35
        goto L28
    L20:
        if (r19.c().isEmpty() == true) goto L22;
        r0.putAll(r19.c());     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        Logger.e("AppLog", "custom compress with exception: ", th);
        r21 = a(r17, r8, r13);
    L38:
        r0.put("log-encode-type", NetConst.GZIP);
    L37:
        r21 = a(r17, r8, r13);
        goto L38
    }

    public static String a(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return r4;
    L5:
        Uri.Builder r0 = Uri.parse(a(r4, f15113a)).buildUpon();
        r0.appendQueryParameter("tt_info", new String(Base64.encode(a(null, Uri.parse(r4).getQuery().getBytes(RpcUtils.CHARSET_UTF8), null), 8)));     // Catch: Throwable -> L8
        return r0.build().toString();
    L11:
        return r4;
    }

    public static String a(String r6, String[] r7) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return r6;
    L5:
        Uri r8 = Uri.parse(r6);
        HashMap r0 = new HashMap(r7.length);
        int r1 = r7.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        String r3 = r7[r2];
        String r4 = r8.getQueryParameter(r3);
        if (TextUtils.isEmpty(r4) == true) goto L10;
        r0.put(r3, r4);
    L10:
        r2 = r2 + 1;
        goto L6
    L11:
        Uri.Builder r9 = r8.buildUpon();
        r9.clearQuery();
        Iterator r10 = r0.keySet().iterator();
    L13:
        if (r10.hasNext() == false) goto L16;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        r9.appendQueryParameter(r5, (String) ZeusTransformUtils.preCheckCast(r0.get(r5), String.class, "com.obric.memorydata.plugin"));
        goto L13
    L16:
        return r9.build().toString();
    }

    private static void a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (g == true) goto L14;
        if (r5 == null) goto L20;
        Object r0 = j;
        monitor-enter(r0);
        SharedPreferences r6 = r5.getSharedPreferences(k, 0);     // Catch: Throwable -> L15
        i = r6.getInt("app_log_encrypt_faild_count", 0);     // Catch: Throwable -> L15
        SharedPreferences.Editor r7 = r6.edit();     // Catch: Throwable -> L15
        r7.putInt("app_log_encrypt_faild_count", i + 1);     // Catch: Throwable -> L15
        r7.apply();     // Catch: Throwable -> L15
        g = true;     // Catch: Throwable -> L15
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L20:
        return;
    }

    private static void a(Map<String, String> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if (com.ss.android.deviceregister.d.e.v() == false) goto L5;
        String r0 = "harmony";
    L6:
        r3.put("os", r0);
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (com.ss.android.deviceregister.d.e.v() == false) goto L16;
        r3.put("sub_os_api", String.valueOf(SystemPropertiesWithCache.get("hw_sc.build.os.apiversion")));     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L5:
        r0 = "android";
        goto L6
    }

    static void a(Map<String, String> r4, Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (r6.isEmpty() == true) goto L18;
        Iterator r8 = r6.entrySet().iterator();     // Catch: Exception -> L19
    L7:
        if (r8.hasNext() == false) goto L34;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L19
        if (r0 == null) goto L7;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L19
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L19
        if (com.bytedance.common.utility.h.a(r2) == true) goto L7;
        if (com.bytedance.common.utility.h.a(r1) == true) goto L7;
        r7.put(r2, r1);     // Catch: Exception -> L19
    L34:
        return;
    L18:
        return;
    }

    public static void a(Map<String, String> r9, boolean r10, Level r11) {
        Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Level r13 = (Level) ZeusTransformUtils.wrapperContextForParams(r11, Level.class, "com.obric.memorydata.plugin");
        com.ss.android.common.a r0 = f;
        if (r12 == null) goto L136;
        if (r0 == null) goto L137;
        if (r13 == null) goto L139;
        HashMap r2 = new HashMap();
    L18:
        com.ss.android.deviceregister.f.a(r2);
    L19:
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.get("install_id"), String.class, "com.obric.memorydata.plugin");
        if (com.bytedance.common.utility.h.a(r3) == true) goto L22;
        r12.put("iid", r3);
    L22:
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.get("device_id"), String.class, "com.obric.memorydata.plugin");
        if (com.bytedance.common.utility.h.a(r4) == true) goto L25;
        r12.put("device_id", r4);
    L25:
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L30;
        String r6 = NetworkUtils.f(r5);
        if (com.bytedance.common.utility.h.a(r6) == true) goto L30;
        r12.put(Api.KEY_AC, r6);
    L30:
        boolean r7 = com.ss.android.deviceregister.b.c.a(r5);
        String r8 = r0.d();
        if (r8 == null) goto L33;
        r12.put("channel", r8);
    L33:
        r12.put("aid", String.valueOf(r0.i()));
        String r14 = r0.a();
        if (r14 == null) goto L36;
        r12.put(Api.KEY_APP_NAME, r14);
    L36:
        r12.put("version_code", String.valueOf(r0.e()));
        r12.put("version_name", r0.b());
        r12.put("device_platform", "android");
        a(r12);
        String r15 = r0.l();
        if (com.bytedance.common.utility.h.a(r15) == true) goto L39;
        r12.put(Api.KEY_AB_VERSION, r15);
    L39:
        String r16 = r0.j();
        if (com.bytedance.common.utility.h.a(r16) == true) goto L42;
        r12.put(Api.KEY_AB_CLIENT, r16);
    L42:
        String r17 = r0.m();
        if (com.bytedance.common.utility.h.a(r17) == true) goto L45;
        r12.put(Api.KEY_AB_GROUP, r17);
    L45:
        String r18 = r0.n();
        if (com.bytedance.common.utility.h.a(r18) == true) goto L48;
        r12.put(Api.KEY_AB_FEATURE, r18);
    L48:
        long r19 = r0.k();
        if (r19 <= 0) goto L51;
        r12.put(Api.KEY_ABFLAG, String.valueOf(r19));
    L51:
        if (r10 == false) goto L53;
        r12.put(Api.KEY_SSMIX, "a");
    L53:
        r12.put(Api.KEY_DEVICE_TYPE, Build.MODEL);
        r12.put("device_brand", Build.BRAND);
        r12.put(Api.KEY_LANGUAGE, Locale.getDefault().getLanguage());
        r12.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        String r110 = Build.VERSION.RELEASE;     // Catch: Exception -> L117
        if (r110 != null) goto L57;
    L59:
        r12.put("os_version", r110);     // Catch: Exception -> L117
        goto L61
    L57:
        if (r110.length() <= 10) goto L59;
        r110 = r110.substring(0, 10);     // Catch: Exception -> L117
    L61:
        if (r13 == Level.L0) goto L63;
    L72:
        r12.put("manifest_version_code", String.valueOf(r0.h()));
        String r111 = com.bytedance.common.utility.i.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        if (com.bytedance.common.utility.h.a(r111) == true) goto L75;
        r12.put("resolution", r111);
    L75:
        int r112 = com.bytedance.common.utility.i.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        if (r112 <= 0) goto L78;
        r12.put(Api.KEY_DPI, String.valueOf(r112));
    L78:
        r12.put("update_version_code", String.valueOf(r0.g()));
        r12.put(Api.KEY_RTICKET, String.valueOf(System.currentTimeMillis()));
        a(l, r12);
        if (r13 != Level.L0) goto L118;
        a(m, r12);
    L118:
    L102:
        th = move-exception;
        th.printStackTrace();
    L104:
        String r113 = com.ss.android.deviceregister.d.a.a(r5);
        if (com.bytedance.common.utility.h.a(r113) == true) goto L108;
        r12.put(Cdid.KEY_CDID, r113);
    L108:
        if (r13 != Level.L0) goto L111;
        com.ss.android.deviceregister.a.f.a(r5, r0, r12, r7);
    L111:
        if (com.ss.android.deviceregister.f.b(r5) == false) goto L113;
        com.ss.android.deviceregister.c.c.a(r5).a(r12);
    L113:
        IParamFilter r114 = e;
        if (r114 == null) goto L138;
        r114.filterCommonParams(r12);
        return;
    L138:
        return;
    L82:
        if (n == null) goto L104;
        HashMap<String, String> r115 = n.a(r13);     // Catch: Throwable -> L102
        if (r115 == null) goto L104;
        if (r115.isEmpty() == true) goto L104;
        Iterator<Map.Entry<String, String>> r116 = r115.entrySet().iterator();     // Catch: Throwable -> L102
    L89:
        if (r116.hasNext() == false) goto L104;
        Map.Entry r20 = (Map.Entry) ZeusTransformUtils.preCheckCast(r116.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L102
        if (r20 == null) goto L89;
        String r21 = (String) ZeusTransformUtils.preCheckCast(r20.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L102
        String r22 = (String) ZeusTransformUtils.preCheckCast(r20.getValue(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L102
        if (com.bytedance.common.utility.h.a(r21) == true) goto L89;
        if (com.bytedance.common.utility.h.a(r22) == true) goto L89;
        if (r12.containsKey(r21) == true) goto L89;
        r12.put(r21, r22);     // Catch: Throwable -> L102
        goto L89
    L63:
        if (com.ss.android.deviceregister.f.b() == true) goto L67;
        String r23 = (String) ZeusTransformUtils.preCheckCast(r2.get("openudid"), String.class, "com.obric.memorydata.plugin");
        if (com.bytedance.common.utility.h.a(r23) == true) goto L67;
        r12.put("openudid", r23);
    L67:
        j r117 = o;
        if (r117 == null) goto L72;
        String r118 = r117.a();
        if (TextUtils.isEmpty(r118) == true) goto L72;
        r12.put(Api.KEY_ALIYUN_UUID, r118);
        goto L72
    L9:
        if (com.ss.android.common.b.d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L16;
        y.a r24 = d;     // Catch: Exception -> L18
        if (r24 == null) goto L14;
        r24.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r2);     // Catch: Exception -> L18
    L14:
        if (Logger.debug() == false) goto L19;
        Logger.d("PushService", "idmap = " + com.bytedance.common.utility.h.a(r2));     // Catch: Exception -> L18
        goto L19
    L16:
        com.ss.android.deviceregister.f.a(r2);     // Catch: Exception -> L18
        goto L19
    L139:
        return;
    L137:
        return;
    }

    private static byte[] a(Context r3, byte[] r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        byte[] r0 = null;
        if (r4 != null) goto L5;
    L27:
        return null;
    L5:
        if (r4.length <= 0) goto L27;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r2 = new GZIPOutputStream(r1);
        r2.write(r4);     // Catch: Throwable -> L20
        r2.close();
        byte[] r7 = r1.toByteArray();
        if (r6 == null) goto L16;
        a(r6);
        if (i >= 3) goto L19;
        r0 = com.bytedance.frameworks.core.encrypt.b.a(r7, r7.length);
        b(r6);
        if (r0 != null) goto L19;
    L15:
        b.b(r5, MonitorState.f_to_bytes_encrypt);
    L19:
        return r0;
    L16:
        r0 = com.bytedance.frameworks.core.encrypt.b.a(r7, r7.length);
        if (r0 != null) goto L19;
    L20:
        th = move-exception;
        b.b(r5, MonitorState.f_to_bytes_compress);     // Catch: Throwable -> L24
        Logger.w("AppLog", "compress with gzip exception: " + th);     // Catch: Throwable -> L24
        r2.close();
        return null;
    L24:
        th = move-exception;
        r2.close();
        throw th;
    }

    private static void b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (h == true) goto L18;
        if (r5 == null) goto L24;
        Object r0 = j;
        monitor-enter(r0);
        SharedPreferences.Editor r6 = r5.getSharedPreferences(k, 0).edit();     // Catch: Throwable -> L19
        if (i <= 2) goto L11;
        i -= 2;     // Catch: Throwable -> L19
    L12:
        r6.putInt("app_log_encrypt_faild_count", i);     // Catch: Throwable -> L19
        r6.apply();     // Catch: Throwable -> L19
        h = true;     // Catch: Throwable -> L19
        goto L22
    L11:
        i = 0;     // Catch: Throwable -> L19
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L24:
        return;
    }
}
