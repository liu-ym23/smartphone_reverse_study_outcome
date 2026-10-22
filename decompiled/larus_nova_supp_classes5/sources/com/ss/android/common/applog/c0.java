package com.ss.android.common.applog;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.applog.e;
import com.bytedance.applog.m;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.i;
import com.bytedance.bdinstall.k;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ttnet.org.chromium.base.TTProcessUtils;
import eta.b;
import i84.u;
import ita.j;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import jta.g;
import kta.f;
import kta.s;
import lta.c;
import pta.a;
import pta.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c0 {
    public static b a;
    public static final ConcurrentHashMap<String, String> b = null;
    public static final ConcurrentHashMap<String, String> c = null;

    static {
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
    }

    public static boolean f(String r5) {
        if (StringUtils.isEmpty(r5) == false) goto L6;
        return true;
    L6:
        if (r5.equalsIgnoreCase("unknown") == false) goto L9;
        return true;
    L9:
        if (r5.equalsIgnoreCase("None") == false) goto L11;
        return true;
    L11:
        int r2 = 0;
    L13:
        if (r2 >= r5.length()) goto L21;
        if (r5.charAt(r2) != '0') goto L16;
        r2 = r2 + 1;
        goto L13
    L16:
        return false;
    L21:
        return true;
    }

    public static void a(StringBuilder r6, Map<String, String> r7) {
        Uri r0 = UriProtector.parse(r6.toString());
        Set r1 = UriProtector.getQueryParameterNames(r0);
        Uri.Builder r2 = r0.buildUpon();
        Iterator r8 = ((LinkedHashMap) r7).entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        Map.Entry r3 = (Map.Entry) r8.next();
        String r4 = (String) r3.getKey();
        String r5 = (String) r3.getValue();
        if (r1.contains(r4) == true) goto L4;
        if (TextUtils.isEmpty(r5) == true) goto L4;
        r2.appendQueryParameter(r4, (String) r3.getValue());
        goto L4
    L10:
        r6.delete(0, r6.length());
        r6.append(r2.build().toString());
    }

    public static String b(String r3, boolean r4) {
        Level r0 = Level.L0;
        b r1 = a;
        if (StringUtils.isEmpty(r3) == true) goto L8;
        if (r1 == null) goto L9;
        StringBuilder r2 = new StringBuilder(r3);
        d(r2, r4, r0);
        return r2.toString();
    L9:
        return r3;
    L8:
        return r3;
    }

    public static void c(String r4, Level r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (StringUtils.isEmpty("language") == false) goto L7;
        return;
    L7:
        if (StringUtils.isEmpty(r4) == false) goto L10;
        return;
    L10:
        if (g.f() == false) goto L12;
        i.a(r4, r5);
        return;
    L12:
        int r1 = a.a[r5.ordinal()];
        if (r1 == 1) goto L17;
        if (r1 != 2) goto L18;
        b.put("language", r4);
    L18:
        String[] r2 = d0.a;
        if (StringUtils.isEmpty("language") == false) goto L21;
        return;
    L21:
        if (StringUtils.isEmpty(r4) == false) goto L24;
        return;
    L24:
        if (g.f() == false) goto L26;
        i.a(r4, r5);
        return;
    L26:
        int r6 = d0.a.a[r5.ordinal()];
        if (r6 == 1) goto L31;
        if (r6 != 2) goto L40;
        d0.j.put("language", r4);
        return;
    L40:
        return;
    L31:
        d0.k.put("language", r4);
        return;
    L17:
        c.put("language", r4);
        goto L18
    }

    public static void d(StringBuilder r5, boolean r6, Level r7) {
        if (a == null) goto L24;
        String r0 = r5.toString();
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return;
    L7:
        Uri r1 = UriProtector.parse(r0);
        Set r2 = UriProtector.getQueryParameterNames(r1);
        Uri.Builder r3 = r1.buildUpon();
        LinkedHashMap r4 = new LinkedHashMap();
        g(r4, r6, r7);
        Iterator r8 = r4.entrySet().iterator();
    L9:
        if (r8.hasNext() == false) goto L15;
        Map.Entry r9 = (Map.Entry) r8.next();
        String r10 = (String) r9.getKey();
        String r11 = (String) r9.getValue();
        if (r2.contains(r10) == true) goto L9;
        if (TextUtils.isEmpty(r11) == true) goto L9;
        r3.appendQueryParameter(r10, (String) r9.getValue());
        goto L9
    L15:
        r5.delete(0, r5.length());
        r5.append(r3.build().toString());
        return;
    }

    public static void g(Map<String, String> r10, boolean r11, Level r12) {
        b r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        Context r1 = r0.getContext();
        if (g.f() == false) goto L10;
        k r2 = i.b;
        if (r2.e() == false) goto L189;
        r2.i.b(r1, r11, r10, r12);
        return;
    L189:
        return;
    L10:
        b r3 = d0.d;
        if (r10 == null) goto L191;
        if (r3 == null) goto L192;
        if (r12 != null) goto L16;
        return;
    L16:
        if (g.f() == false) goto L20;
        Context r4 = r3.getContext();
        k r5 = i.b;
        if (r5.e() == false) goto L193;
        r5.i.b(r4, r11, r10, r12);
        return;
    L193:
        return;
    L20:
        HashMap r6 = new HashMap();
        boolean r7 = true;
        String r8 = ita.k.c(r3.getContext());     // Catch: Exception -> L33
        if (r8 != null) goto L24;
    L26:
        boolean r9 = false;
    L27:
        if (r9 == true) goto L29;
        g.j.x(r6, g.c);     // Catch: Exception -> L33
    L34:
        String r13 = (String) r6.get("klink_egdi");
        if (StringUtils.isEmpty(r13) == true) goto L37;
        r10.put("klink_egdi", r13);
    L37:
        String r14 = (String) r6.get("install_id");
        if (StringUtils.isEmpty(r14) == true) goto L40;
        r10.put("iid", r14);
    L40:
        String r15 = (String) r6.get(EffectConfiguration.KEY_DEVICE_ID);
        if (StringUtils.isEmpty(r15) == true) goto L43;
        r10.put(EffectConfiguration.KEY_DEVICE_ID, r15);
    L43:
        Context r16 = r3.getContext();
        if (r16 == null) goto L50;
        String[] r17 = d0.a;
        String r18 = NetworkUtils.getNetworkAccessType(r16);
        if (StringUtils.isEmpty(r18) == true) goto L50;
        r10.put("ac", r18);
        if (Logger.debug() == false) goto L50;
        j.b("NetUtil get access from access " + r18, null);
    L50:
        if (r16 != null) goto L53;
        boolean r19 = c.a;
        r7 = false;
    L56:
        String r20 = r3.getTweakedChannel();
        if (r20 == null) goto L59;
        r10.put(EffectConfiguration.KEY_CHANNEL, r20);
    L59:
        r10.put(EffectConfiguration.KEY_APP_ID, String.valueOf(r3.getAid()));
        String r21 = r3.getAppName();
        if (r21 == null) goto L62;
        r10.put("app_name", r21);
    L62:
        r10.put("version_code", String.valueOf(r3.getVersionCode()));
        r10.put("version_name", r3.getVersion());
        String r22 = "android";
        r10.put(EffectConfiguration.KEY_DEVICE_PLATFORM, "android");
        if (d.h() == false) goto L65;
        r22 = "harmony";
    L65:
        r10.put("os", r22);
    L70:
        th = move-exception;
        th.printStackTrace();
    L72:
        String r23 = r3.getAbVersion();
        if (StringUtils.isEmpty(r23) == true) goto L75;
        r10.put("ab_version", r23);
    L75:
        String r24 = r3.getAbClient();
        if (StringUtils.isEmpty(r24) == true) goto L78;
        r10.put("ab_client", r24);
    L78:
        String r25 = r3.getAbGroup();
        if (StringUtils.isEmpty(r25) == true) goto L81;
        r10.put("ab_group", r25);
    L81:
        String r26 = r3.getAbFeature();
        if (StringUtils.isEmpty(r26) == true) goto L84;
        r10.put("ab_feature", r26);
    L84:
        long r27 = r3.getAbFlag();
        if (r27 <= 0) goto L87;
        r10.put("abflag", String.valueOf(r27));
    L87:
        if (r11 == false) goto L89;
        r10.put("ssmix", "a");
    L89:
        r10.put(EffectConfiguration.KEY_DEVICE_TYPE, Build.MODEL);
        r10.put("device_brand", Build.BRAND);
        r10.put("language", Locale.getDefault().getLanguage());
        r10.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        String r110 = Build.VERSION.RELEASE;     // Catch: Exception -> L97
        if (r110 != null) goto L93;
    L95:
        r10.put("os_version", r110);     // Catch: Exception -> L97
        goto L98
    L93:
        if (r110.length() <= 10) goto L95;
        r110 = r110.substring(0, 10);     // Catch: Exception -> L97
    L98:
        Level r111 = Level.L0;
        if (r12 == r111) goto L101;
    L105:
        r10.put("manifest_version_code", String.valueOf(r3.getManifestVersionCode()));
        String r28 = UIUtils.getScreenResolution(r3.getContext());
        if (StringUtils.isEmpty(r28) == true) goto L108;
        r10.put("resolution", r28);
    L108:
        int r29 = UIUtils.getDpi(r3.getContext());
        if (r29 <= 0) goto L111;
        r10.put("dpi", String.valueOf(r29));
    L111:
        r10.put("update_version_code", String.valueOf(r3.getUpdateVersionCode()));
        r10.put("_rticket", String.valueOf(System.currentTimeMillis()));
        d0.c(d0.j, r10);
        if (r12 != r111) goto L169;
        d0.c(d0.k, r10);
    L169:
    L135:
        th = move-exception;
        th.printStackTrace();
    L137:
        String r112 = a.a(r16);
        if (StringUtils.isEmpty(r112) == true) goto L141;
        r10.put("cdid", r112);
    L141:
        if (r12 != Level.L0) goto L162;
        if (r7 == true) goto L150;
        if (g.g != null) goto L147;
        g.g = new jta.j();
    L147:
        if (g.g.a.b() == false) goto L162;
        s.b(r16).a();
        goto L162
    L150:
        if (g.f == true) goto L154;
        String r113 = r3.getDeviceId();
        if (f(r113) == true) goto L154;
        r10.put("uuid", r113);
    L154:
        if (r7 == false) goto L162;
        String r114 = f.c(kta.n.c(r16));     // Catch: Throwable -> L159
        if (r114 == null) goto L162;
        r10.put("oaid", r114);     // Catch: Throwable -> L159
    L159:
        th = move-exception;
        th.printStackTrace();
    L162:
        if (g.g(r16) == false) goto L195;
        jta.k r115 = (jta.k) ota.b.a(jta.k.class);
        if (r115 == null) goto L196;
        r115.a();
        return;
    L196:
        return;
    L195:
        return;
    L115:
        if (d0.l == null) goto L137;
        HashMap r116 = d0.l.getExtrparams(r12);     // Catch: Throwable -> L135
        if (r116 == null) goto L137;
        if (r116.isEmpty() == true) goto L137;
        Iterator r117 = r116.entrySet().iterator();     // Catch: Throwable -> L135
    L122:
        if (r117.hasNext() == false) goto L137;
        Map.Entry r30 = (Map.Entry) r117.next();     // Catch: Throwable -> L135
        if (r30 == null) goto L122;
        String r31 = (String) r30.getKey();     // Catch: Throwable -> L135
        String r32 = (String) r30.getValue();     // Catch: Throwable -> L135
        if (StringUtils.isEmpty(r31) == true) goto L122;
        if (StringUtils.isEmpty(r32) == true) goto L122;
        if (r10.containsKey(r31) == true) goto L122;
        r10.put(r31, r32);     // Catch: Throwable -> L135
        goto L122
    L101:
        if (g.j.t() == true) goto L105;
        String r33 = (String) r6.get("openudid");
        if (StringUtils.isEmpty(r33) == true) goto L105;
        r10.put("openudid", r33);
        goto L105
    L67:
        if (d.h() == false) goto L72;
        r10.put("sub_os_api", String.valueOf(u.a("hw_sc.build.os.apiversion")));     // Catch: Throwable -> L70
        goto L72
    L53:
        if (c.a == true) goto L56;
        r7 = ((SharedPreferences) c.b.b(new Object[]{r16})).getBoolean("_install_started_v2", false);
        goto L56
    L29:
        if (Logger.debug() == false) goto L34;
        j.b("PushService idmap = " + StringUtils.mapToString(r6), null);     // Catch: Exception -> L33
        goto L34
    L24:
        if (r8.endsWith(TTProcessUtils.MESSAGE_PROCESS_SUFFIX) == false) goto L26;
        r9 = true;
    L33:
        g.j.x(r6, g.c);
        goto L34
    L192:
        return;
    }

    public static String e(m r2, String r3, byte[] r4, boolean r5, String r6, Map r7, boolean r8, boolean r9) throws CommonHttpException {
        HashMap r0 = new HashMap();
        if (StringUtils.isEmpty(r6) == true) goto L6;
        r0.put(DownloadHelper.CONTENT_TYPE, r6);
    L6:
        if (r5 == false) goto L27;
        if (r2 != null) goto L9;
    L20:
        boolean r10 = false;
    L21:
        if (r10 == true) goto L27;
        r4 = NetworkClient.compressWithgzip(r4);     // Catch: Exception -> L24
        r0.put(DownloadHelper.CONTENT_ENCODING, DownloadHelper.GZIP);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        throw new CommonHttpException(0, e.getMessage());
    L9:
        if (r3.contains("/service/2/app_log/") == false) goto L20;
        e r11 = r2.a(r4);
        if (r11 == null) goto L20;
        byte[] r12 = r11.a;
        if (r12 == null) goto L20;
        Map r13 = r11.c;
        if (r13 != null) goto L17;
    L19:
        r10 = true;
        r4 = r12;
        goto L21
    L17:
        if (r13.isEmpty() == true) goto L19;
        r0.putAll(r11.c);
    L27:
        if (r7 == null) goto L29;
        r0.putAll(r7);
    L29:
        if (r9 == true) goto L31;
        ita.g.a(r0, r8);
    L31:
        NetworkClient.ReqContext r14 = new NetworkClient.ReqContext();
        r14.addCommonParams = false;
        return NetworkClient.getDefault().post(r3, r4, r0, r14);
    }

    public static String h(m r4, String r5, byte[] r6, Context r7, boolean r8, String[] r9, Map r10, boolean r11, boolean r12) throws Exception {
        String[] r0 = d0.a;
        byte[] r1 = null;
        GZIPInputStream r2 = null;
        GZIPInputStream r3 = null;
        r2 = null;
        r3 = null;
        if (StringUtils.isEmpty(r5) == true) goto L145;
        if (r6 != null) goto L7;
        return null;
    L7:
        if (r6.length <= 0) goto L146;
        HashMap r13 = new HashMap();
        r13.put("log-encode-type", DownloadHelper.GZIP);
        if (r5.contains("/service/2/app_log/") == false) goto L41;
        if (r4 != null) goto L125;
    L28:
        if (r7 == null) goto L35;
        d0.a(r7);     // Catch: Throwable -> L26
        if (d0.g >= 3) goto L34;
        byte[] r14 = EncryptorUtil.b(r6, r6.length);     // Catch: Throwable -> L26
        d0.f(r7);     // Catch: Throwable -> L26
        if (r14 != null) goto L42;
        e.a().b(StatsCountKeys.ENCRYPT_ERROR_COUNT, 1);     // Catch: Throwable -> L26
    L42:
        if (r14 == null) goto L110;
        String r15 = r5.concat("&tt_data=a");
        if (r8 == false) goto L46;
        r15 = r15 + "&config_retry=b";
    L46:
        r13.remove(DownloadHelper.CONTENT_ENCODING);
        r13.put(DownloadHelper.CONTENT_TYPE, "application/octet-stream;tt-data=a");
        if (r10 == null) goto L49;
        r13.putAll(r10);
    L49:
        if (r12 == true) goto L52;
        ita.g.a(r13, r11);
    L52:
        if (nta.d.d(r9) == false) goto L144;
        byte[] r16 = NetworkClient.getDefault().postDataStream(r15, r14, r13, null);
        if (r16 == null) goto L107;
        String r17 = r9[0];
        String r18 = r9[1];
        Cipher r19 = Cipher.getInstance("AES/CBC/PKCS7PADDING");     // Catch: Throwable -> L64
        int r110 = r17.length();     // Catch: Throwable -> L64
        byte[] r111 = new byte[r110];     // Catch: Throwable -> L64
        int r112 = 0;
    L57:
        if (r112 >= r110) goto L59;
        r111[r112] = (byte) r17.charAt(r112);     // Catch: Throwable -> L64
        r112 = r112 + 1;     // Catch: Throwable -> L64
        goto L57
    L59:
        SecretKeySpec r20 = new SecretKeySpec(r111, "AES");     // Catch: Throwable -> L64
        int r113 = r18.length();     // Catch: Throwable -> L64
        byte[] r114 = new byte[r113];     // Catch: Throwable -> L64
        int r115 = 0;
    L60:
        if (r115 >= r113) goto L62;
        r114[r115] = (byte) r18.charAt(r115);     // Catch: Throwable -> L64
        r115 = r115 + 1;     // Catch: Throwable -> L64
        goto L60
    L62:
        r19.init(2, r20, new IvParameterSpec(r114));     // Catch: Throwable -> L64
        byte[] r21 = r19.doFinal(r16);     // Catch: Throwable -> L64
    L66:
        if (r21 != null) goto L69;
        return new String(r16);
    L69:
        if (r21.length <= 0) goto L143;
        ByteArrayOutputStream r22 = new ByteArrayOutputStream();
        ByteArrayInputStream r23 = new ByteArrayInputStream(r21);     // Catch: Throwable -> L88 IOException -> L97
        GZIPInputStream r24 = new GZIPInputStream(r23);     // Catch: Throwable -> L85 IOException -> L87
        goto L98
    L132:
        byte[] r25 = new byte[1024];     // Catch: Throwable -> L82 IOException -> L84
    L76:
        int r116 = r24.read(r25);     // Catch: Throwable -> L82 IOException -> L84
        if (r116 < 0) goto L119;
        r22.write(r25, 0, r116);     // Catch: Throwable -> L82 IOException -> L84
    L119:
        r24.close();     // Catch: IOException -> L112
    L115:
        r23.close();     // Catch: IOException -> L113
    L104:
        r1 = r22.toByteArray();
    L84:
        r2 = r24;
    L82:
        th = th;
        r3 = r24;
    L90:
        if (r3 != null) goto L126;
    L94:
        if (r23 == null) goto L139;
        r23.close();     // Catch: IOException -> L114
        throw th;
    L140:
        throw th;
    L139:
        throw th;
    L126:
        r3.close();     // Catch: IOException -> L93
    L85:
        th = th;
    L98:
        if (r2 != null) goto L121;
    L102:
        if (r23 == null) goto L104;
    L121:
        r2.close();     // Catch: IOException -> L101
        goto L102
    L97:
        r23 = null;
    L88:
        th = th;
        r23 = null;
    L143:
        return new String(r1);
    L64:
        th = move-exception;
        th.printStackTrace();
        r21 = null;
        goto L66
    L107:
        throw new RuntimeException("get encrypted resp failed");
    L144:
        return NetworkClient.getDefault().post(r15, r14, r13, null);
    L110:
        throw new RuntimeException("encrypt failed");
    L34:
        r14 = null;
        goto L42
    L35:
        r14 = EncryptorUtil.b(r6, r6.length);     // Catch: Throwable -> L26
        if (r14 != null) goto L42;
        e.a().b(StatsCountKeys.ENCRYPT_ERROR_COUNT, 1);     // Catch: Throwable -> L26
        goto L42
    L125:
        e r26 = r4.a(r6);     // Catch: Throwable -> L26
        if (r26 == null) goto L25;
        byte[] r27 = r26.a;     // Catch: Throwable -> L26
        if (r27 == null) goto L25;
        Map r28 = r26.c;     // Catch: Throwable -> L23
        if (r28 != null) goto L20;
    L22:
        r6 = r27;
        goto L28
    L20:
        if (r28.isEmpty() == true) goto L22;
        r13.putAll(r26.c);     // Catch: Throwable -> L23
    L23:
        th = th;
    L40:
        j.c("compress log data failed", th);
        r14 = r27;
    L25:
        e.a().b(StatsCountKeys.COMPRESS_ERROR_COUNT, 1);     // Catch: Throwable -> L26
        return null;
    L26:
        th = th;
        r27 = r6;
        goto L40
    L41:
        r14 = d0.b(r7, r6);
        goto L42
    L146:
        return null;
    L145:
        return null;
    }
}
