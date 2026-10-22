package com.bytedance.badger.collect.impl.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Network;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.model.TTResponse;
import com.bytedance.badger.collect.impl.network.RangersHttpException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import el9.a;
import f06.b;
import f06.c;
import f06.d;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class CommonUtils {
    private static final int LENGTH_MAX = 10240;

    public CommonUtils() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_badger_collect_impl_utils_CommonUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
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
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
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

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_bytedance_badger_collect_impl_utils_CommonUtils_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r7) throws IOException {
        String r3 = r7.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r4 = r7.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r3, r4) == false) goto L11;
        FLogger.a.i("UrlConnLancet", "openConnection drop host=" + r3 + " path=" + r4);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r3, r4), r3, r4);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r7);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r7.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    public static String getSecureAndroidId(Context r1) {
        return com_bytedance_badger_collect_impl_utils_CommonUtils_android_provider_Settings$Secure_getString(r1.getContentResolver(), "android_id");
    L4:
        return null;
    }

    public static String map2QueryString(Map<String, String> r3) {
        if (r3 != null) goto L4;
        return "";
    L4:
        if (r3.isEmpty() == true) goto L20;
        StringBuilder r0 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r4 = r3.entrySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L14;
        Map.Entry<String, String> r1 = r4.next();
        if (r0.length() <= 0) goto L12;
        r0.append("&");
    L12:
        r0.append(r1.getKey());
        r0.append("=");
        r0.append(r1.getValue());
        goto L8
    L14:
        return r0.toString();
    L20:
        return "";
    }

    public static Map<String, String> parseResponseHeaders(Map<String, List<String>> r5) {
        HashMap r0 = new HashMap();
        if (r5 != null) goto L5;
    L16:
        return r0;
    L5:
        if (r5.isEmpty() == true) goto L16;
        Iterator<Map.Entry<String, List<String>>> r6 = r5.entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L16;
        Map.Entry<String, List<String>> r1 = r6.next();
        int r2 = 0;
    L11:
        if (r2 >= r1.getValue().size()) goto L8;
        if (TextUtils.isEmpty(r1.getKey()) == true) goto L15;
        r0.put(r1.getKey(), ListProtector.get(r1.getValue(), r2));
    L15:
        r2 = r2 + 1;
        goto L11
    }

    private static int com_bytedance_badger_collect_impl_utils_CommonUtils_android_content_Context_checkSelfPermission(Context r18, String r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        b r12 = new b("auto_cert_com_bytedance_badger_collect_impl_utils_CommonUtils_android_content_Context_checkSelfPermission");
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102608);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(102608, "android/content/Context", "checkSelfPermission", r18, r1, "int", r12);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.checkSelfPermission(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private static String com_bytedance_badger_collect_impl_utils_CommonUtils_android_provider_Settings$Secure_getString(ContentResolver r12, String r13) {
        c r8 = new c();
        Object[] r9 = {r12, r13};
        b r10 = new b();
        d r14 = r8.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, "java.lang.String", r10);
        if (r14.a == false) goto L6;
        r8.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, null, r10, false);
        return (String) r14.b;
    L6:
        String r15 = Settings.Secure.getString(r12, r13);
        r8.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, r15, r10, true);
        return r15;
    }

    private static HttpURLConnection createConnectionCompat(Network r5, URL r6) throws Exception {
        return (HttpURLConnection) INVOKESTATIC_com_bytedance_badger_collect_impl_utils_CommonUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.net.Network").getMethod("openConnection", new Class[]{URL.class}).invoke(r5, new Object[]{r6});
    }

    public static boolean hasPermission(Context r4, String r5) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT >= 23) goto L13;
        return true;
    L13:
        if (com_bytedance_badger_collect_impl_utils_CommonUtils_android_content_Context_checkSelfPermission(r4, r5) != 0) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.badger.collect.impl.model.TTResponse] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.badger.collect.impl.model.TTResponse] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public static TTResponse http(Network r8, String r9, String r10, Map<String, String> r12, byte[] r13) throws Exception {
        ?? r1 = "gzip";
        if (KLog.isDebug() == false) goto L13;
        if (r12 == null) goto L13;
        Iterator<Map.Entry<String, String>> r2 = r12.entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L13;
        Map.Entry<String, String> r4 = r2.next();
        if (TextUtils.isEmpty(r4.getKey()) == true) goto L7;
        if (TextUtils.isEmpty(r4.getValue()) == true) goto L7;
        KLog.d(Constants.TAGS.WIFI_TO_CELLULAR_NETWORK, "http headers key:" + r4.getKey() + " value:" + r4.getValue());
    L13:
        HttpURLConnection r3 = null;
        BufferedReader r5 = null;
        r5 = null;
        URL r6 = new URL(r10);     // Catch: Throwable -> L73
        if (r8 == null) goto L19;
        HttpURLConnection r14 = (HttpURLConnection) r8.openConnection(r6);     // Catch: Throwable -> L73
        KLog.d(Constants.TAGS.WIFI_TO_CELLULAR_NETWORK, "强切# 原生http接口链接创建成功 " + r14);     // Catch: Throwable -> L71
    L21:
        if (Objects.equals(r9, Constants.Keys.METHOD_GET) == false) goto L24;
        r14.setDoOutput(false);     // Catch: Throwable -> L71
    L26:
        r14.setRequestMethod(r9);     // Catch: Throwable -> L71
        r14.setConnectTimeout(30000);     // Catch: Throwable -> L71
        r14.setReadTimeout(30000);     // Catch: Throwable -> L71
        if (r12 != null) goto L29;
    L38:
        r14.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L71
        if (r13 != null) goto L41;
    L44:
        DataOutputStream r15 = null;
    L45:
        int r16 = r14.getResponseCode();     // Catch: Throwable -> L69
        if (r16 == 200) goto L48;
        r1 = new TTResponse(r10, r16, parseResponseHeaders(r14.getHeaderFields()), r14.getResponseMessage());     // Catch: Throwable -> L69
    L60:
        r14.disconnect();
        if (r15 != null) goto L107;
    L65:
        if (r5 == null) goto L86;
        r5.close();     // Catch: IOException -> L68
        r1 = r1;
    L114:
        goto L86
    L107:
        r15.close();     // Catch: IOException -> L64
        goto L65
    L48:
        if (r14.getContentLength() >= LENGTH_MAX) goto L58;
        InputStream r7 = r14.getInputStream();     // Catch: Throwable -> L69
        if ("gzip".equalsIgnoreCase(r14.getContentEncoding()) == false) goto L52;
        BufferedReader r17 = new BufferedReader(new InputStreamReader(new GZIPInputStream(r7)));     // Catch: Throwable -> L69
    L53:
        r5 = r17;
        StringBuilder r18 = new StringBuilder(r7.available());     // Catch: Throwable -> L69
    L54:
        String r19 = r5.readLine();     // Catch: Throwable -> L69
        if (r19 == null) goto L57;
        r18.append(r19);     // Catch: Throwable -> L69
        r18.append("\n");     // Catch: Throwable -> L69
        goto L54
    L57:
        JSONObject r20 = new JSONObject(r18.toString());     // Catch: Throwable -> L69
        r20.put("httpCode", 200);     // Catch: Throwable -> L69
        r20.put(Constants.Keys.KEY_SET_COOKIE, r14.getHeaderField(Constants.Keys.KEY_SET_COOKIE));     // Catch: Throwable -> L69
        r1 = new TTResponse(r10, r16, parseResponseHeaders(r14.getHeaderFields()), r20.toString());     // Catch: Throwable -> L69
        goto L60
    L52:
        r17 = new BufferedReader(new InputStreamReader(r7));     // Catch: Throwable -> L69
        goto L53
    L58:
        KLog.e(Constants.TAGS.WIFI_TO_CELLULAR_NETWORK, "强切# http error~~~~");     // Catch: Throwable -> L69
        r1 = 0;
        goto L60
    L41:
        if (r13.length <= 0) goto L44;
        r15 = new DataOutputStream(r14.getOutputStream());     // Catch: Throwable -> L71
        r15.write(r13);     // Catch: Throwable -> L69
        r15.flush();     // Catch: Throwable -> L69
        r15.close();     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        r3 = r14;
        DataOutputStream r22 = r15;
        th = th;
        BufferedReader r110 = null;
    L111:
        KLog.e(Constants.TAGS.WIFI_TO_CELLULAR_NETWORK, th);     // Catch: Throwable -> L91
        if ((th instanceof RangersHttpException) == true) goto L90;
        r1 = TTResponse.failed(th);     // Catch: Throwable -> L91
        if (r3 == null) goto L80;
        r3.disconnect();
    L80:
        if (r22 != null) goto L105;
    L84:
        if (r110 == null) goto L86;
        r110.close();     // Catch: IOException -> L68
        r1 = r1;
        goto L114
    L105:
        r22.close();     // Catch: IOException -> L83
        goto L84
    L90:
        throw th;     // Catch: Throwable -> L91
    L91:
        th = move-exception;
        if (r3 == null) goto L94;
        r3.disconnect();
    L94:
        if (r22 != null) goto L109;
    L98:
        if (r110 == null) goto L133;
        r110.close();     // Catch: IOException -> L101
        throw th;
    L134:
        throw th;
    L133:
        throw th;
    L109:
        r22.close();     // Catch: IOException -> L97
        goto L98
    L29:
        if (r12.isEmpty() == true) goto L38;
        Iterator<Map.Entry<String, String>> r23 = r12.entrySet().iterator();     // Catch: Throwable -> L71
    L32:
        if (r23.hasNext() == false) goto L38;
        Map.Entry<String, String> r111 = r23.next();     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r111.getKey()) == true) goto L32;
        if (TextUtils.isEmpty(r111.getValue()) == true) goto L32;
        r14.addRequestProperty(r111.getKey(), r111.getValue());     // Catch: Throwable -> L71
        goto L32
    L24:
        if (Objects.equals(r9, Constants.Keys.METHOD_POST) == false) goto L26;
        r14.setDoOutput(true);     // Catch: Throwable -> L71
    L71:
        th = th;
        r110 = null;
        r3 = r14;
        r22 = null;
        goto L111
    L19:
        r14 = (HttpURLConnection) INVOKEVIRTUAL_com_bytedance_badger_collect_impl_utils_CommonUtils_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r6);     // Catch: Throwable -> L73
    L73:
        th = th;
        r22 = null;
        r110 = null;
    L86:
        if (r1 == 0) goto L88;
        return r1;
    L88:
        return TTResponse.failed();
    }
}
