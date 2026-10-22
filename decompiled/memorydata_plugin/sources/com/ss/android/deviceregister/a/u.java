package com.ss.android.deviceregister.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Cdid;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.ss.android.deviceregister.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f15155a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.ss.android.common.a f15156b = null;
    private static String c = null;
    private static String d = null;
    private static int e = 0;
    private static int f = 0;
    private static String g = null;
    private static String h = "2.15.0";
    private static ConcurrentHashMap<String, Object> i;
    private static boolean j;
    private static volatile JSONObject k;
    private static String l;
    private static String m;
    private static String n;
    private static String o;
    private static final Object p = null;
    private static com.ss.android.deviceregister.b.d q;
    private static i r;
    private static boolean s;
    private static String t;
    private static String u;
    private static volatile boolean v;
    private static ConcurrentHashMap<String, Object> w;

    static {
        i = new ConcurrentHashMap();
        j = false;
        p = new Object();
        s = false;
    }

    public static String a() {
        return u;
    }

    public static String a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (com.bytedance.common.utility.h.a(l) == false) goto L22;
        if (r3 == null) goto L22;
        PackageInfo r4 = r3.getPackageManager().getPackageInfo(r3.getPackageName(), 64);     // Catch: Exception -> L19
        if (r4 == null) goto L18;
        if (r4.signatures == null) goto L18;
        if (r4.signatures.length < 1) goto L18;
        Signature r5 = r4.signatures[0];     // Catch: Exception -> L19
        if (r5 == null) goto L15;
        l = com.bytedance.common.utility.b.b(r5.toByteArray());     // Catch: Exception -> L19
        goto L22
    L15:
        return l;
    L18:
        return l;
    L19:
        e = move-exception;
        Logger.w("RegistrationHeaderHelper", "failed to inst package sianature: " + e);
    L22:
        return l;
    }

    public static void a(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (com.bytedance.common.utility.h.a(r3) == false) goto L5;
        return;
    L5:
        if (r3.equals(m) == true) goto L9;
        m = r3;
        SharedPreferences.Editor r5 = b.a(r4).edit();
        r5.putString(Api.KEY_USER_AGENT, r3);
        r5.commit();
        return;
    }

    private static void a(Context r2, JSONObject r3) {
        String r4 = a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
        if (r4 == null) goto L11;
        r3.put(Api.KEY_SIG_HASH, r4);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void a(i r2) {
        r = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin");
    }

    public static void a(com.ss.android.deviceregister.b.d r0) {
        q = r0;
    }

    public static void a(String r0) {
        h = r0;
    }

    public static void a(String r3, String r4) {
        Object r0 = p;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (k != null) goto L15;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L15:
        k.put("device_id", r3);     // Catch: JSONException -> L8 Throwable -> L12
        k.put("install_id", r4);     // Catch: JSONException -> L8 Throwable -> L12
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12
        goto L10
    }

    private static void a(Throwable r4) {
        com.ss.android.common.a r0 = f15156b;
        if (r0 != null) goto L5;
        return;
    L5:
        i r1 = r;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L19;
        if (r1 == null) goto L20;
        String r5 = Log.getStackTraceString(r4);
        if (com.bytedance.common.utility.h.a(r5) == true) goto L21;
        JSONObject r3 = new JSONObject();
        r3.put("stack", r5);     // Catch: JSONException -> L13
    L15:
        r1.a("device_register", r3);
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L21:
        return;
    L20:
        return;
    }

    public static void a(JSONObject r0) {
        f.a(r0);
    }

    public static void a(JSONObject r4, JSONObject r5) {
        Iterator<String> r0 = r4.keys();
    L4:
        if (r0.hasNext() == false) goto L10;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        r5.put(r1, r4.opt(r1));     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    }

    public static void a(boolean r1) {
        s = r1;
        if (k == null) goto L12;
        Object r2 = p;
        monitor-enter(r2);
        a(k);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static boolean a(Context r13, JSONObject r14, boolean r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap();
        Object r1 = p;
        monitor-enter(r1);
    L295:
        th = move-exception;
        throw th;
    L5:
        if (k != null) goto L7;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L295
        boolean r2 = com.ss.android.deviceregister.f.f();
        JSONObject r3 = new JSONObject();
        boolean r4 = false;
        String r5 = r16.getPackageName();     // Catch: Exception -> L292
        Bundle r6 = r16.getPackageManager().getApplicationInfo(r5, 128).metaData;     // Catch: Exception -> L31
        String r7 = f15155a;     // Catch: Exception -> L31
        if (r7 == null) goto L21;
        if (r7.length() <= 0) goto L21;
        String r8 = "channel";
        String r9 = f15155a;     // Catch: Exception -> L31
    L19:
        r0.put(r8, r9);     // Catch: Exception -> L31
    L26:
        if (r6 == null) goto L34;
        if (TextUtils.isEmpty("UMENG_APPKEY") == true) goto L34;
        r0.put(Api.KEY_APPKEY, r6.getString("UMENG_APPKEY"));     // Catch: Exception -> L31
    L34:
        if (TextUtils.isEmpty(u) == true) goto L36;
        r0.put("package", u);     // Catch: Exception -> L292
        Bundle r10 = new Bundle();     // Catch: Exception -> L292
        r10.putString(Api.KEY_REAL_PACKAGE_NAME, r16.getPackageName());     // Catch: Exception -> L292
        com.ss.android.deviceregister.f.a(r10);     // Catch: Exception -> L292
    L37:
        com.ss.android.common.a r11 = f15156b;     // Catch: Exception -> L292
        if (r11 == null) goto L41;
        c = r11.b();     // Catch: Exception -> L292
    L41:
        if (com.bytedance.common.utility.h.a(d) == true) goto L43;
        c = d;     // Catch: Exception -> L292
    L43:
        r0.put("app_version", c);     // Catch: Exception -> L292
        com.ss.android.common.a r12 = f15156b;     // Catch: Exception -> L292
        if (r12 == null) goto L46;
        e = r12.e();     // Catch: Exception -> L292
    L46:
        PackageInfo r17 = r16.getPackageManager().getPackageInfo(r5, 0);     // Catch: Exception -> L292
        if (r17.applicationInfo == null) goto L51;
        int r18 = r17.applicationInfo.labelRes;     // Catch: Exception -> L292
        if (r18 <= 0) goto L51;
        r3.put(Api.KEY_DISPLAY_NAME, r16.getString(r18));     // Catch: Exception -> L292
    L51:
        com.ss.android.common.a r19 = f15156b;     // Catch: Exception -> L292
        if (r19 == null) goto L65;
        int r20 = r19.g();     // Catch: Exception -> L292
        if (r20 <= 0) goto L56;
        r3.put("update_version_code", r20);     // Catch: Exception -> L292
    L56:
        int r21 = f15156b.h();     // Catch: Exception -> L292
        if (r21 <= 0) goto L60;
        r3.put("manifest_version_code", r21);     // Catch: Exception -> L292
    L60:
        if (TextUtils.isEmpty(com.ss.android.deviceregister.f.d()) == true) goto L63;
        String r22 = Api.KEY_APP_VERSION_MINOR;
        String r23 = com.ss.android.deviceregister.f.d();     // Catch: Exception -> L292
    L62:
        r3.put(r22, r23);     // Catch: Exception -> L292
        goto L65
    L63:
        r22 = Api.KEY_APP_VERSION_MINOR;
        r23 = "";
    L65:
        String[] r24 = {"channel", Api.KEY_APPKEY, "package", "app_version"};
    L85:
        e = move-exception;
        a(e);
    L309:
        DisplayMetrics r25 = ZeusTransformUtils.getResources(r16, "com.obric.memorydata.plugin").getDisplayMetrics();     // Catch: Exception -> L99
        int r26 = r25.densityDpi;     // Catch: Exception -> L99
        r3.put("density_dpi", r26);     // Catch: Exception -> L99
        if (r26 != 120) goto L90;
        String r27 = "ldpi";
    L97:
        r3.put("display_density", r27);     // Catch: Exception -> L99
        r3.put("resolution", r25.heightPixels + "x" + r25.widthPixels);     // Catch: Exception -> L99
    L101:
        SharedPreferences r28 = b.a(r16);
        String r29 = ZeusTransformUtils.getResources(r16, "com.obric.memorydata.plugin").getConfiguration().locale.getLanguage();     // Catch: Exception -> L115
        if (com.bytedance.common.utility.h.a(r29) == true) goto L105;
        r3.put(Api.KEY_LANGUAGE, r29);     // Catch: Exception -> L115
    L105:
        float r30 = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;     // Catch: Exception -> L115
        if (r30 >= (-12.0f)) goto L109;
        r30 = -12.0f;
    L109:
        if (r30 <= 12.0f) goto L111;
        r30 = 12.0f;
    L111:
        r3.put(Api.KEY_TIMEZONE, r30);     // Catch: Exception -> L115
        String r31 = NetworkUtils.f(r16);     // Catch: Exception -> L115
        if (r31 == null) goto L302;
        r3.put(Api.KEY_ACCESS, r31);     // Catch: Exception -> L115
    L302:
    L132:
        e = move-exception;
        a(e);
        e.printStackTrace();
    L317:
        String r32 = com.ss.android.deviceregister.d.c.e(r16);     // Catch: Exception -> L141
        String r33 = com.ss.android.deviceregister.d.c.d(r16);     // Catch: Exception -> L141
        if (com.bytedance.common.utility.h.a(r32) == true) goto L138;
        r3.put(Api.KEY_CARRIER, r32);     // Catch: Exception -> L141
    L138:
        if (com.bytedance.common.utility.h.a(r33) == true) goto L143;
        r3.put(Api.KEY_MCC_MNC, r33);     // Catch: Exception -> L141
    L143:
        StringBuilder r34 = new StringBuilder();
    L161:
        th = move-exception;
        a(th);
    L333:
        String r35 = com.ss.android.deviceregister.d.e.a();     // Catch: Throwable -> L167
        if (com.bytedance.common.utility.h.a(r35) == true) goto L325;
        r3.put("rom_version", r35);     // Catch: Throwable -> L167
    L325:
        String r36 = com.ss.android.deviceregister.d.a.a(r16);     // Catch: Throwable -> L173
        if (com.bytedance.common.utility.h.a(r36) == true) goto L175;
        r3.put(Cdid.KEY_CDID, r36);     // Catch: Throwable -> L173
    L175:
        a(r16, r3);
        String r37 = r28.getString(Api.KEY_APP_LANGUAGE, null);
        String r38 = r28.getString(Api.KEY_APP_REGION, null);
        String r39 = com.ss.android.b.a();     // Catch: Throwable -> L219
        String r40 = com.ss.android.b.b();     // Catch: Throwable -> L219
        if (r15 == true) goto L194;
        if (r2 == true) goto L194;
        Pair<String, Boolean> r41 = com.ss.android.deviceregister.h.a(r16);     // Catch: Throwable -> L219
        if (com.ss.android.deviceregister.f.b(r16) == true) goto L194;
        if (r41 == null) goto L194;
        if (r41.second != null) goto L185;
    L187:
        boolean r110 = false;
    L189:
        if (r110 == false) goto L191;
        int r111 = 1;
    L192:
        r3.put("gaid_limited", r111);     // Catch: Throwable -> L219
        r3.put("google_aid", r41.first);     // Catch: Throwable -> L219
        goto L194
    L191:
        r111 = 0;
        goto L192
    L185:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r41.second, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L187;
        r110 = true;
    L194:
        if (com.bytedance.common.utility.h.a(r39) == false) goto L196;
    L198:
        boolean r42 = false;
    L200:
        if (com.bytedance.common.utility.h.a(r37) == true) goto L203;
        r3.put(Api.KEY_APP_LANGUAGE, r37);     // Catch: Throwable -> L219
    L203:
        if (com.bytedance.common.utility.h.a(r40) == true) goto L208;
        if (r40.equals(r38) == true) goto L208;
        r4 = true;
        r38 = r40;
    L208:
        if (com.bytedance.common.utility.h.a(r38) == true) goto L210;
        r3.put(Api.KEY_APP_REGION, r38);     // Catch: Throwable -> L219
    L210:
        SharedPreferences.Editor r43 = r28.edit();     // Catch: Throwable -> L219
        if (r42 == false) goto L213;
        r43.putString(Api.KEY_APP_LANGUAGE, r37);     // Catch: Throwable -> L219
    L213:
        if (r4 == false) goto L215;
        r43.putString(Api.KEY_APP_REGION, r38);     // Catch: Throwable -> L219
    L215:
        if (r42 == true) goto L217;
        if (r4 == true) goto L217;
    L221:
        String r44 = r28.getString(Api.KEY_APP_TRACK, "");
        o = r44;
    L226:
        th = move-exception;
        a(th);
        th.printStackTrace();
    L228:
        com.ss.android.deviceregister.b.d r45 = q;
        if (r45 == null) goto L247;
        String r46 = r45.g();     // Catch: Exception -> L244
        if (com.bytedance.common.utility.h.a(r46) == true) goto L233;
        r3.put("device_id", r46);     // Catch: Exception -> L244
    L233:
        if (r15 == true) goto L237;
        String r47 = q.i();     // Catch: Exception -> L244
        if (com.bytedance.common.utility.h.a(r47) == true) goto L237;
        r3.put("openudid", r47);     // Catch: Exception -> L244
    L237:
        String r48 = q.h();     // Catch: Exception -> L244
        if (com.bytedance.common.utility.h.a(r48) == true) goto L240;
        r3.put("install_id", r48);     // Catch: Exception -> L244
    L240:
        String r49 = q.k();     // Catch: Exception -> L244
        if (com.bytedance.common.utility.h.a(r49) == true) goto L247;
        r3.put("clientudid", r49);     // Catch: Exception -> L244
    L244:
        e = move-exception;
        a(e);
        e.printStackTrace();
    L247:
        if (com.ss.android.deviceregister.f.b(r16) == true) goto L300;
    L252:
        ConcurrentHashMap<String, Object> r50 = w;
        if (r50 == null) goto L327;
        Iterator<Map.Entry<String, Object>> r51 = r50.entrySet().iterator();
    L256:
        if (r51.hasNext() == false) goto L327;
        Map.Entry r52 = (Map.Entry) ZeusTransformUtils.preCheckCast(r51.next(), Map.Entry.class, "com.obric.memorydata.plugin");
    L262:
        e = move-exception;
        e.printStackTrace();
        goto L256
    L259:
        if (r52.getValue() == null) goto L256;
        r3.put((String) ZeusTransformUtils.preCheckCast(r52.getKey(), String.class, "com.obric.memorydata.plugin"), r52.getValue());     // Catch: JSONException -> L262
    L327:
        String r53 = Locale.getDefault().getCountry();     // Catch: Throwable -> L274
        if (com.bytedance.common.utility.h.a(r53) == true) goto L267;
        r3.put(Api.KEY_REGION, r53);     // Catch: Throwable -> L274
    L267:
        String r54 = Calendar.getInstance().getTimeZone().getID();     // Catch: Throwable -> L274
        if (com.bytedance.common.utility.h.a(r54) == true) goto L270;
        r3.put(Api.KEY_TZ_NAME, r54);     // Catch: Throwable -> L274
    L270:
        r3.put(Api.KEY_TZ_OFFSET, Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);     // Catch: Throwable -> L274
        String r55 = com.ss.android.deviceregister.d.c.f(r16);     // Catch: Throwable -> L274
        if (com.bytedance.common.utility.h.a(r55) == true) goto L276;
        r3.put(Api.KEY_SIM_REGION, r55);     // Catch: Throwable -> L274
    L276:
        if (r15 == true) goto L279;
        f.a(r16, q, r3, f(), r2);
    L279:
        if (TextUtils.isEmpty(t) == false) goto L323;
    L284:
        Object r112 = p;
        monitor-enter(r112);
        k = r3;     // Catch: Throwable -> L289
        v = r15;     // Catch: Throwable -> L289
        a(r3, r14);     // Catch: Throwable -> L289
        monitor-exit(r112);     // Catch: Throwable -> L289
        return true;
    L289:
        th = move-exception;
        throw th;
    L323:
        r3.put("old_did", t);     // Catch: JSONException -> L282
    L282:
        e = move-exception;
        e.printStackTrace();
    L274:
        th = move-exception;
        a(th);
        goto L276
    L300:
        r3.put(Api.KEY_NEW_USER_MODE, 1);     // Catch: JSONException -> L250
    L250:
        e = move-exception;
        e.printStackTrace();
        goto L252
    L223:
        if (com.bytedance.common.utility.h.a(r44) == true) goto L228;
        r3.put(Api.KEY_APP_TRACK, new JSONObject(o));     // Catch: Throwable -> L226
    L217:
        r43.commit();     // Catch: Throwable -> L219
        goto L221
    L196:
        if (r39.equals(r37) == true) goto L198;
        r37 = r39;
        r42 = true;
    L219:
        th = move-exception;
        a(th);
    L173:
        th = move-exception;
        a(th);
        th.printStackTrace();
    L167:
        th = move-exception;
        a(th);
        th.printStackTrace();
        goto L325
    L145:
        if (com.ss.android.common.b.d.b() == false) goto L149;
        String r56 = "MIUI-";
    L147:
        r34.append(r56);     // Catch: Throwable -> L161
    L157:
        r34.append(Build.VERSION.INCREMENTAL);     // Catch: Throwable -> L161
        if (r34.length() <= 0) goto L333;
        String r57 = r34.toString();     // Catch: Throwable -> L161
        n = r57;     // Catch: Throwable -> L161
        r3.put(Api.KEY_ROM, r57);     // Catch: Throwable -> L161
        goto L333
    L149:
        if (com.ss.android.common.b.d.c() == false) goto L151;
        r56 = "FLYME-";
        goto L147
    L151:
        String r58 = com.ss.android.common.b.d.a();     // Catch: Throwable -> L161
        if (com.ss.android.deviceregister.d.e.a(r58) == false) goto L155;
        r34.append("EMUI-");     // Catch: Throwable -> L161
    L155:
        if (TextUtils.isEmpty(r58) == true) goto L157;
        r34.append(r58).append("-");     // Catch: Throwable -> L161
    L141:
        e = move-exception;
        a(e);
        e.printStackTrace();
        goto L143
    L118:
        if (i.isEmpty() == true) goto L127;
        Iterator<Map.Entry<String, Object>> r59 = i.entrySet().iterator();     // Catch: Exception -> L132
    L121:
        if (r59.hasNext() == false) goto L127;
        Map.Entry r60 = (Map.Entry) ZeusTransformUtils.preCheckCast(r59.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L132
        if (r60 == null) goto L121;
        r3.put((String) ZeusTransformUtils.preCheckCast(r60.getKey(), String.class, "com.obric.memorydata.plugin"), r60.getValue());     // Catch: Exception -> L132
    L127:
        if (j == false) goto L129;
        int r61 = 1;
    L130:
        r3.put(Api.KEY_NOT_REQUEST_SENDER, r61);     // Catch: Exception -> L132
        goto L317
    L129:
        r61 = 0;
    L115:
        e = move-exception;
        a(e);
        e.printStackTrace();
        goto L302
    L90:
        if (r26 != 240) goto L92;
        r27 = "hdpi";
        goto L97
    L92:
        if (r26 == 320) goto L94;
        r27 = "mdpi";
        goto L97
    L94:
        r27 = "xhdpi";
    L99:
        e = move-exception;
        a(e);
        goto L101
    L67:
        if (f != 0) goto L71;
        com.ss.android.common.a r62 = f15156b;     // Catch: Exception -> L85
        if (r62 == null) goto L71;
        f = r62.i();     // Catch: Exception -> L85
    L71:
        r3.put("aid", f);     // Catch: Exception -> L85
        int r63 = 0;
    L72:
        if (r63 >= 4) goto L80;
        String r64 = r24[r63];     // Catch: Exception -> L85
        String r65 = (String) ZeusTransformUtils.preCheckCast(r0.get(r64), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L85
        if (com.bytedance.common.utility.h.a(r65) == false) goto L78;
        Logger.w("RegistrationHeaderHelper", "init fail empty field: " + r64);     // Catch: Exception -> L85
        if (Api.KEY_APPKEY.equals(r64) == true) goto L79;
        return false;
    L79:
        r63 = r63 + 1;     // Catch: Exception -> L85
        goto L72
    L78:
        r3.put(r64, r65);     // Catch: Exception -> L85
        goto L79
    L80:
        r3.put("version_code", e);     // Catch: Exception -> L85
        r3.put("sdk_version", h);     // Catch: Exception -> L85
        r3.put(Api.KEY_SDK_TARGET_VERSION, 29);     // Catch: Exception -> L85
        r3.put("git_hash", BuildConfig.GIT_HASH);     // Catch: Exception -> L85
        r3.put("os", LocationInfoConst.SYSTEM);     // Catch: Exception -> L85
        r3.put("os_version", Build.VERSION.RELEASE);     // Catch: Exception -> L85
        r3.put("os_api", Build.VERSION.SDK_INT);     // Catch: Exception -> L85
        r3.put("device_model", Build.MODEL);     // Catch: Exception -> L85
        r3.put("device_brand", Build.BRAND);     // Catch: Exception -> L85
        r3.put("device_manufacturer", Build.MANUFACTURER);     // Catch: Exception -> L85
        r3.put("cpu_abi", Build.CPU_ABI);     // Catch: Exception -> L85
        String r66 = g;     // Catch: Exception -> L85
        if (r66 != null) goto L83;
        r66 = "";
    L83:
        r3.put("release_build", r66);     // Catch: Exception -> L85
        goto L309
    L36:
        r0.put("package", r16.getPackageName());     // Catch: Exception -> L292
    L21:
        if (r6 == null) goto L26;
        if (TextUtils.isEmpty("UMENG_CHANNEL") == true) goto L26;
        r8 = "channel";
        r9 = f.a(r6);     // Catch: Exception -> L31
    L31:
        e = move-exception;
        a(e);     // Catch: Exception -> L292
        e.printStackTrace();     // Catch: Exception -> L292
    L292:
        e = move-exception;
        Logger.w("RegistrationHeaderHelper", "init exception: " + e);
        a(e);
        return false;
    L7:
        if (v != r15) goto L11;
        a(k, r14);     // Catch: Throwable -> L295
        monitor-exit(r1);     // Catch: Throwable -> L295
        return true;
    }

    public static int b() {
        if (f > 0) goto L8;
        com.ss.android.common.a r0 = f15156b;
        if (r0 == null) goto L8;
        r0.i();
    L8:
        return f;
    }

    public static String b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (com.bytedance.common.utility.h.a(m) == false) goto L6;
        m = b.a(r3).getString(Api.KEY_USER_AGENT, null);
    L6:
        return m;
    }

    public static void b(String r0) {
        t = r0;
    }

    public static int c() {
        if (e > 0) goto L8;
        com.ss.android.common.a r0 = f15156b;
        if (r0 == null) goto L8;
        e = r0.e();
    L8:
        return e;
    }

    public static String c(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(f15155a) == false) goto L5;
        com.ss.android.common.a r0 = f15156b;
        if (r0 != null) goto L9;
        Bundle r4 = r3.getPackageManager().getApplicationInfo(r3.getPackageName(), 128).metaData;     // Catch: Throwable -> L14
        if (r4 == null) goto L20;
        f15155a = f.a(r4);     // Catch: Throwable -> L14
        return null;
    L20:
        return null;
    L14:
        th = move-exception;
        th.printStackTrace();
        return null;
    L9:
        return r0.d();
    L5:
        return f15155a;
    }

    public static String d() {
        return f15155a;
    }

    public static String e() {
        return c;
    }

    public static boolean f() {
        return !s;
    }

    public static void g() {
        k = null;
    }
}
