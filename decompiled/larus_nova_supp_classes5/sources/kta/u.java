package kta;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import eta.b;
import ita.j;
import ita.k;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import jta.g;
import lta.e;
import lta.h;
import org.json.JSONException;
import org.json.JSONObject;
import pta.a;
import pta.c;
import pta.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class u {
    public static String a = null;
    public static b b = null;
    public static String c = null;
    public static int d = 0;
    public static int e = 0;
    public static String f = null;
    public static String g = "2.15.0";
    public static final ConcurrentHashMap<String, Object> h = null;
    public static volatile JSONObject i;
    public static String j;
    public static String k;
    public static String l;
    public static final Object m = null;
    public static e n;
    public static j o;
    public static boolean p;
    public static String q;
    public static volatile boolean r;
    public static volatile boolean s;

    static {
        h = new ConcurrentHashMap();
        m = new Object();
        p = false;
        s = true;
    }

    public static int e() {
        if (d > 0) goto L8;
        b r0 = b;
        if (r0 == null) goto L8;
        d = r0.getVersionCode();
    L8:
        return d;
    }

    public static void b(JSONObject r1) {
        if (r1 != null) goto L5;
        return;
    L5:
        if ((!p) == true) goto L13;
        r1.remove("sim_serial_number");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static String c(Context r2) {
        if (TextUtils.isEmpty(a) == false) goto L5;
        b r0 = b;
        if (r0 != null) goto L9;
        Bundle r3 = r2.getPackageManager().getApplicationInfo(r2.getPackageName(), 128).metaData;     // Catch: Throwable -> L14
        if (r3 == null) goto L20;
        a = r3.getString("UMENG_CHANNEL");     // Catch: Throwable -> L14
        return null;
    L20:
        return null;
    L14:
        th = move-exception;
        th.printStackTrace();
        return null;
    L9:
        return r0.getTweakedChannel();
    L5:
        return a;
    }

    public static void f(Throwable r2) {
        b r0 = b;
        if (r0 != null) goto L5;
        return;
    L5:
        j r1 = o;
        r0.getContext();
        if (r1 == null) goto L18;
        String r3 = Log.getStackTraceString(r2);
        if (StringUtils.isEmpty(r3) == true) goto L19;
        JSONObject r4 = new JSONObject();
        r4.put("stack", r3);     // Catch: JSONException -> L12
    L14:
        AppLogNewUtils.onEventV3("device_register", r4);
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L19:
        return;
    }

    public static void a(JSONObject r3, JSONObject r4) {
        Iterator<String> r0 = r3.keys();
    L4:
        if (r0.hasNext() == false) goto L10;
        String r1 = r0.next();
        r4.put(r1, r3.opt(r1));     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    }

    public static void g(Context r2, JSONObject r3) {
        if (StringUtils.isEmpty(j) == false) goto L20;
        if (r2 == null) goto L20;
        PackageInfo r4 = r2.getPackageManager().getPackageInfo(r2.getPackageName(), 64);     // Catch: Exception -> L18
        if (r4 == null) goto L16;
        Signature[] r5 = r4.signatures;     // Catch: Exception -> L18
        if (r5 == null) goto L16;
        if (r5.length < 1) goto L16;
        Signature r6 = r5[0];     // Catch: Exception -> L18
        if (r6 != null) goto L15;
        String r7 = j;     // Catch: Exception -> L18
    L21:
        if (r7 == null) goto L30;
        r3.put("sig_hash", r7);     // Catch: JSONException -> L24
        return;
    L24:
        e = move-exception;
        e.printStackTrace();
        return;
    L30:
        return;
    L15:
        j = DigestUtils.md5Hex(r6.toByteArray());     // Catch: Exception -> L18
    L16:
        r7 = j;     // Catch: Exception -> L18
    L18:
        e = move-exception;
        j.c("RegistrationHeaderHelperfailed to inst package sianature: ", e);
    L20:
        r7 = j;
        goto L21
    }

    public static boolean d(Context r11, JSONObject r12, boolean r13) {
        HashMap r0 = new HashMap();
        Object r1 = m;
        monitor-enter(r1);
    L280:
        th = move-exception;
        throw th;
    L5:
        if (i != null) goto L7;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L280
        boolean r2 = g.f;
        JSONObject r3 = new JSONObject();
        boolean r4 = false;
        String r5 = r11.getPackageName();     // Catch: Exception -> L277
        Bundle r6 = r11.getPackageManager().getApplicationInfo(r5, 128).metaData;     // Catch: Exception -> L30
        String r7 = a;     // Catch: Exception -> L30
        if (r7 == null) goto L20;
        if (r7.length() <= 0) goto L20;
        r0.put(EffectConfiguration.KEY_CHANNEL, a);     // Catch: Exception -> L30
    L25:
        if (r6 == null) goto L33;
        if (TextUtils.isEmpty("UMENG_APPKEY") == true) goto L33;
        r0.put("appkey", r6.getString("UMENG_APPKEY"));     // Catch: Exception -> L30
    L33:
        if (TextUtils.isEmpty(null) == true) goto L35;
        r0.put("package", null);     // Catch: Exception -> L277
        Bundle r8 = new Bundle();     // Catch: Exception -> L277
        r8.putString("real_package_name", r11.getPackageName());     // Catch: Exception -> L277
        g.j.s(r8);     // Catch: Exception -> L277
    L36:
        b r9 = b;     // Catch: Exception -> L277
        if (r9 == null) goto L40;
        c = r9.getVersion();     // Catch: Exception -> L277
    L40:
        if (StringUtils.isEmpty(null) == true) goto L42;
        c = null;     // Catch: Exception -> L277
    L42:
        r0.put(EffectConfiguration.KEY_APP_VERSION, c);     // Catch: Exception -> L277
        b r10 = b;     // Catch: Exception -> L277
        if (r10 == null) goto L45;
        d = r10.getVersionCode();     // Catch: Exception -> L277
    L45:
        ApplicationInfo r14 = r11.getPackageManager().getPackageInfo(r5, 0).applicationInfo;     // Catch: Exception -> L277
        if (r14 == null) goto L50;
        int r15 = r14.labelRes;     // Catch: Exception -> L277
        if (r15 <= 0) goto L50;
        r3.put("display_name", r11.getString(r15));     // Catch: Exception -> L277
    L50:
        b r16 = b;     // Catch: Exception -> L277
        if (r16 == null) goto L62;
        int r17 = r16.getUpdateVersionCode();     // Catch: Exception -> L277
        if (r17 <= 0) goto L55;
        r3.put("update_version_code", r17);     // Catch: Exception -> L277
    L55:
        int r18 = b.getManifestVersionCode();     // Catch: Exception -> L277
        if (r18 <= 0) goto L58;
        r3.put("manifest_version_code", r18);     // Catch: Exception -> L277
    L58:
        g r19 = g.a;     // Catch: Exception -> L277
        if (TextUtils.isEmpty("") == true) goto L61;
        r3.put("app_version_minor", "");     // Catch: Exception -> L277
        goto L62
    L61:
        r3.put("app_version_minor", "");     // Catch: Exception -> L277
    L62:
        String[] r20 = {EffectConfiguration.KEY_CHANNEL, "appkey", "package", EffectConfiguration.KEY_APP_VERSION};
    L83:
        e = move-exception;
        f(e);
    L308:
        Resources r21 = r11.getResources();     // Catch: Exception -> L97
        DisplayMetrics r22 = WindowDisplayMetricsOverride.apply(r21, r21.getDisplayMetrics());     // Catch: Exception -> L97
        int r23 = r22.densityDpi;     // Catch: Exception -> L97
        r3.put("density_dpi", r23);     // Catch: Exception -> L97
        if (r23 != 120) goto L88;
        String r24 = "ldpi";
    L95:
        r3.put("display_density", r24);     // Catch: Exception -> L97
        r3.put("resolution", r22.heightPixels + "x" + r22.widthPixels);     // Catch: Exception -> L97
    L99:
        SharedPreferences r25 = r11.getSharedPreferences(b.a, 0);
        String r26 = r11.getResources().getConfiguration().locale.getLanguage();     // Catch: Exception -> L113
        if (StringUtils.isEmpty(r26) == true) goto L103;
        r3.put("language", r26);     // Catch: Exception -> L113
    L103:
        float r27 = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;     // Catch: Exception -> L113
        if (r27 >= (-12.0f)) goto L107;
        r27 = -12.0f;
    L107:
        if (r27 <= 12.0f) goto L109;
        r27 = 12.0f;
    L109:
        r3.put("timezone", r27);     // Catch: Exception -> L113
        String r28 = NetworkUtils.getNetworkAccessType(r11);     // Catch: Exception -> L113
        if (r28 == null) goto L286;
        r3.put("access", r28);     // Catch: Exception -> L113
    L286:
        ConcurrentHashMap<String, Object> r29 = h;     // Catch: Exception -> L126
        if (r29.isEmpty() == true) goto L124;
        Iterator<Map.Entry<String, Object>> r30 = r29.entrySet().iterator();     // Catch: Exception -> L126
    L119:
        if (r30.hasNext() == false) goto L124;
        Map.Entry<String, Object> r31 = r30.next();     // Catch: Exception -> L126
        if (r31 == null) goto L119;
        r3.put(r31.getKey(), r31.getValue());     // Catch: Exception -> L126
    L124:
        r3.put("not_request_sender", 0);     // Catch: Exception -> L126
    L301:
        c.a r32 = c.a;     // Catch: Exception -> L141
        if (g.e == false) goto L131;
        g r33 = g.a;     // Catch: Exception -> L141
    L131:
        String r34 = ((TelephonyManager) r11.getSystemService("phone")).getNetworkOperatorName();     // Catch: Exception -> L141
        if (g.e == false) goto L134;
        g r35 = g.a;     // Catch: Exception -> L141
    L134:
        String r36 = ((TelephonyManager) r11.getSystemService("phone")).getNetworkOperator();     // Catch: Exception -> L141
        if (StringUtils.isEmpty(r34) == true) goto L138;
        r3.put("carrier", r34);     // Catch: Exception -> L141
    L138:
        if (StringUtils.isEmpty(r36) == true) goto L143;
        r3.put("mcc_mnc", r36);     // Catch: Exception -> L141
    L143:
        StringBuilder r37 = new StringBuilder();
    L175:
        th = move-exception;
        f(th);
    L312:
        String r38 = d.d();     // Catch: Throwable -> L181
        if (StringUtils.isEmpty(r38) == true) goto L299;
        r3.put("rom_version", r38);     // Catch: Throwable -> L181
    L299:
        String r39 = a.a(r11);     // Catch: Throwable -> L187
        if (StringUtils.isEmpty(r39) == true) goto L189;
        r3.put("cdid", r39);     // Catch: Throwable -> L187
    L189:
        g(r11, r3);
        String r40 = r25.getString(EffectConfiguration.KEY_APP_LANGUAGE, null);
        String r41 = r25.getString("app_region", null);
        if (r13 == true) goto L194;
        if (r2 == true) goto L194;
        g.g(r11);     // Catch: Throwable -> L206
    L206:
        th = move-exception;
        f(th);
    L208:
        String r42 = r25.getString("app_track", "");
        l = r42;
    L213:
        th = move-exception;
        f(th);
        th.printStackTrace();
    L215:
        e r43 = n;
        if (r43 == null) goto L237;
        String r44 = r43.c();     // Catch: Exception -> L234
        if (StringUtils.isEmpty(r44) == true) goto L220;
        r3.put(EffectConfiguration.KEY_DEVICE_ID, r44);     // Catch: Exception -> L234
    L220:
        if (r13 == true) goto L224;
        String r45 = n.e();     // Catch: Exception -> L234
        if (StringUtils.isEmpty(r45) == true) goto L224;
        r3.put("openudid", r45);     // Catch: Exception -> L234
    L224:
        String r46 = ((h) n).k;     // Catch: Exception -> L234
        if (StringUtils.isEmpty(r46) == true) goto L227;
        r3.put("install_id", r46);     // Catch: Exception -> L234
    L227:
        String r47 = ((h) n).e.b();     // Catch: Exception -> L234
        if (StringUtils.isEmpty(r47) == true) goto L230;
        r3.put("clientudid", r47);     // Catch: Exception -> L234
    L230:
        String r48 = n.d();     // Catch: Exception -> L234
        if (StringUtils.isEmpty(r48) == true) goto L237;
        r3.put("klink_egdi", r48);     // Catch: Exception -> L234
    L234:
        e = move-exception;
        f(e);
        e.printStackTrace();
    L237:
        if (g.g(r11) == true) goto L297;
    L292:
        c.a r49 = c.a;     // Catch: Throwable -> L259
        String r50 = Locale.getDefault().getCountry();     // Catch: Throwable -> L259
        if (StringUtils.isEmpty(r50) == true) goto L249;
        r3.put(EffectConfiguration.KEY_REGION, r50);     // Catch: Throwable -> L259
    L249:
        String r51 = Calendar.getInstance().getTimeZone().getID();     // Catch: Throwable -> L259
        if (StringUtils.isEmpty(r51) == true) goto L252;
        r3.put("tz_name", r51);     // Catch: Throwable -> L259
    L252:
        r3.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);     // Catch: Throwable -> L259
        if (g.e == false) goto L255;
        g r52 = g.a;     // Catch: Throwable -> L259
    L255:
        String r53 = ((TelephonyManager) r11.getSystemService("phone")).getSimCountryIso();     // Catch: Throwable -> L259
        if (StringUtils.isEmpty(r53) == true) goto L261;
        r3.put("sim_region", r53);     // Catch: Throwable -> L259
    L261:
        if (r13 == true) goto L264;
        f.d(r11, n, r3, !p, r2);
    L264:
        if (TextUtils.isEmpty(q) == false) goto L288;
    L269:
        Object r110 = m;
        monitor-enter(r110);
        i = r3;     // Catch: Throwable -> L274
        r = r13;     // Catch: Throwable -> L274
        a(r3, r12);     // Catch: Throwable -> L274
        monitor-exit(r110);     // Catch: Throwable -> L274
        return true;
    L274:
        th = move-exception;
        throw th;
    L288:
        r3.put("old_did", q);     // Catch: JSONException -> L267
    L267:
        e = move-exception;
        e.printStackTrace();
    L259:
        th = move-exception;
        f(th);
        goto L261
    L297:
    L244:
        e = move-exception;
        e.printStackTrace();
        goto L292
    L239:
        if (pta.b.a(g.d()) == false) goto L241;
    L242:
        r3.put("new_user_mode", 1);     // Catch: JSONException -> L244
        goto L292
    L241:
        if (pta.b.a(g.e()) == false) goto L292;
    L210:
        if (StringUtils.isEmpty(r42) == true) goto L215;
        r3.put("app_track", new JSONObject(l));     // Catch: Throwable -> L213
    L194:
        if (StringUtils.isEmpty(null) == true) goto L196;
        throw null;     // Catch: Throwable -> L206
    L196:
        if (StringUtils.isEmpty(r40) == true) goto L199;
        r3.put(EffectConfiguration.KEY_APP_LANGUAGE, r40);     // Catch: Throwable -> L206
    L199:
        if (StringUtils.isEmpty(null) == true) goto L201;
        throw null;     // Catch: Throwable -> L206
    L201:
        if (StringUtils.isEmpty(r41) == true) goto L203;
        r3.put("app_region", r41);     // Catch: Throwable -> L206
    L203:
        r25.edit();     // Catch: Throwable -> L206
    L187:
        th = move-exception;
        f(th);
        th.printStackTrace();
    L181:
        th = move-exception;
        f(th);
        th.printStackTrace();
        goto L299
    L145:
        if (k.j() == false) goto L148;
        r37.append("MIUI-");     // Catch: Throwable -> L175
    L171:
        r37.append(Build.VERSION.INCREMENTAL);     // Catch: Throwable -> L175
        if (r37.length() <= 0) goto L312;
        r3.put("rom", r37.toString());     // Catch: Throwable -> L175
        goto L312
    L148:
        if (k.f() == false) goto L150;
        r37.append("FLYME-");     // Catch: Throwable -> L175
        goto L171
    L150:
        String r54 = k.d();     // Catch: Throwable -> L175
        d.a r55 = d.a;     // Catch: Throwable -> L175
        if (TextUtils.isEmpty(r54) == false) goto L153;
        String r56 = k.d();     // Catch: Throwable -> L175
    L155:
        if (TextUtils.isEmpty(r56) == true) goto L162;
        if (r56.toLowerCase().contains("emotionui") == false) goto L159;
    L165:
        r4 = true;
    L166:
        if (r4 == false) goto L169;
        r37.append("EMUI-");     // Catch: Throwable -> L175
    L169:
        if (TextUtils.isEmpty(r54) == true) goto L171;
        r37.append(r54);     // Catch: Throwable -> L175
        r37.append("-");     // Catch: Throwable -> L175
        goto L171
    L159:
        if (r56.toLowerCase().contains("magicui") == true) goto L165;
    L162:
        if (d.j() == true) goto L165;
        if (d.i() == false) goto L166;
    L153:
        r56 = r54;
    L141:
        e = move-exception;
        f(e);
        e.printStackTrace();
    L126:
        e = move-exception;
        f(e);
        e.printStackTrace();
    L113:
        e = move-exception;
        f(e);
        e.printStackTrace();
        goto L286
    L88:
        if (r23 != 240) goto L90;
        r24 = "hdpi";
        goto L95
    L90:
        if (r23 == 320) goto L92;
        r24 = "mdpi";
        goto L95
    L92:
        r24 = "xhdpi";
    L97:
        e = move-exception;
        f(e);
        goto L99
    L64:
        if (e != 0) goto L68;
        b r57 = b;     // Catch: Exception -> L83
        if (r57 == null) goto L68;
        e = r57.getAid();     // Catch: Exception -> L83
    L68:
        r3.put(EffectConfiguration.KEY_APP_ID, e);     // Catch: Exception -> L83
        int r58 = 0;
    L70:
        if (r58 >= 4) goto L78;
        String r59 = r20[r58];     // Catch: Exception -> L83
        String r60 = (String) r0.get(r59);     // Catch: Exception -> L83
        if (StringUtils.isEmpty(r60) == false) goto L76;
        j.g("RegistrationHeaderHelper init fail empty field: " + r59, null);     // Catch: Exception -> L83
        if ("appkey".equals(r59) == true) goto L77;
        return false;
    L77:
        r58 = r58 + 1;     // Catch: Exception -> L83
        goto L70
    L76:
        r3.put(r59, r60);     // Catch: Exception -> L83
        goto L77
    L78:
        r3.put("version_code", d);     // Catch: Exception -> L83
        r3.put(EffectConfiguration.KEY_SDK_VERSION, g);     // Catch: Exception -> L83
        r3.put("sdk_target_version", 29);     // Catch: Exception -> L83
        r3.put("git_hash", "f023337");     // Catch: Exception -> L83
        r3.put("os", "Android");     // Catch: Exception -> L83
        r3.put("os_version", Build.VERSION.RELEASE);     // Catch: Exception -> L83
        r3.put("os_api", Build.VERSION.SDK_INT);     // Catch: Exception -> L83
        r3.put("device_model", Build.MODEL);     // Catch: Exception -> L83
        r3.put("device_brand", Build.BRAND);     // Catch: Exception -> L83
        r3.put("device_manufacturer", Build.MANUFACTURER);     // Catch: Exception -> L83
        r3.put("cpu_abi", Build.CPU_ABI);     // Catch: Exception -> L83
        String r61 = f;     // Catch: Exception -> L83
        if (r61 != null) goto L81;
        r61 = "";
    L81:
        r3.put("release_build", r61);     // Catch: Exception -> L83
        goto L308
    L35:
        r0.put("package", r11.getPackageName());     // Catch: Exception -> L277
    L20:
        if (r6 == null) goto L25;
        if (TextUtils.isEmpty("UMENG_CHANNEL") == true) goto L25;
        r0.put(EffectConfiguration.KEY_CHANNEL, r6.getString("UMENG_CHANNEL"));     // Catch: Exception -> L30
    L30:
        e = move-exception;
        f(e);     // Catch: Exception -> L277
        e.printStackTrace();     // Catch: Exception -> L277
    L277:
        e = move-exception;
        j.c("RegistrationHeaderHelper init exception: ", e);
        f(e);
        return false;
    L7:
        if (r != r13) goto L11;
        a(i, r12);     // Catch: Throwable -> L280
        monitor-exit(r1);     // Catch: Throwable -> L280
        return true;
    }
}
