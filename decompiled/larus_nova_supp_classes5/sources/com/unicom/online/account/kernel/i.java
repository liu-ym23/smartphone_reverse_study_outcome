package com.unicom.online.account.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class i {
    private static volatile i d;
    public Context a;
    public String b;
    public String c;
    private ExecutorService e;

    private i() {
        this.b = "cuPreGetToken";
        this.c = "checkOk";
        this.e = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("ount/kernel/i"));
    }

    public static /* synthetic */ Context a(i r0) {
        return r0.a;
    }

    public static i a() {
        if (d != null) goto L15;
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new i();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    public static String a(int r1) {
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L17;
        if (r1 == 4) goto L17;
        if (r1 == 5) goto L17;
        if (r1 == 24) goto L17;
        if (r1 == 25) goto L17;
        return "";
    L17:
        return "Type".concat(String.valueOf(r1));
    }

    public static String a(int r0, int r1, String r2, int r3, int r4, int r5, String r6) {
        return ai.a(r0, r1, r2, r3, r4, r5, r6);
    }

    private static void a(int r2, h r3, String r4) {
        aj.c("type:" + r2 + "\nmsg:" + r4);
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L7
        r5.put("resultCode", 1);     // Catch: Exception -> L7
        r5.put("resultMsg", r4);     // Catch: Exception -> L7
        r5.put("resultData", "");     // Catch: Exception -> L7
        r5.put("seq", g());     // Catch: Exception -> L7
        if (r3 == null) goto L12;
        r3.onResult(r5.toString());     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        aj.a(e);
    }

    public static void a(boolean r0) {
        aj.a(r0);
    }

    public static boolean a(Context r0) {
        a();
        k.b(r0);
        return k.a(r0);
    }

    public static String b() {
        return ac.d();
    }

    public static boolean b(int r2) {
        if (1 != r2) goto L5;
        ac.b(true);
        ac.a(true);
        ac.c(false);
    L6:
        return true;
    L5:
        ac.b(false);
        ac.a(false);
        ac.c(true);
        goto L6
    }

    public static boolean b(Context r1) {
        int r2 = al.b(r1);
        if (r2 == 0) goto L8;
        if (r2 == 1) goto L8;
        return false;
    L8:
        return true;
    }

    public static /* synthetic */ int c(int r1) {
        return Math.abs(new Random().nextInt() % r1);
    }

    public static void c(Context r0) {
        j.a(r0);
    }

    public static boolean c() {
        return ac.a();
    }

    public static boolean c(String r1) {
        if (d(r1) == false) goto L6;
        ac.g = r1;
        return true;
    L6:
        ac.g = ak.e;
        return false;
    }

    public static String d() {
        if (an.a(ac.g).booleanValue() == false) goto L6;
        ac.g = ak.e;
    L6:
        return ac.g;
    }

    private static boolean d(String r1) {
        if (r1.equalsIgnoreCase(ak.f) == false) goto L5;
        return true;
    L5:
        if (r1.equalsIgnoreCase(ak.g) == false) goto L7;
        return true;
    L7:
        if (r1.equalsIgnoreCase(ak.e) == false) goto L9;
        return true;
    L9:
        if (r1.equalsIgnoreCase(ak.h) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public static String e() {
        return ak.i;
    }

    public static void f() {
        af.a().b();
    }

    public static String g() {
        return "seqEmpty" + System.currentTimeMillis() + "-" + UUID.randomUUID().toString().substring(0, 6);
    }

    public final String a(String r8) {
        if (this.a != null) goto L97;
        return "sdk 未初始化, context 为空";
    L97:
        String r1 = r8.toLowerCase();     // Catch: Exception -> L94
        switch(r1.hashCode()) {
            case -1705644026: goto L52;
            case -1411271163: goto L49;
            case -1077289829: goto L46;
            case -903629273: goto L43;
            case -202146594: goto L40;
            case -197617279: goto L37;
            case 107902: goto L34;
            case 113945: goto L31;
            case 3528965: goto L28;
            case 93029116: goto L25;
            case 667683678: goto L22;
            case 781805572: goto L19;
            case 909712337: goto L16;
            case 1183900800: goto L13;
            case 1285324646: goto L10;
            default: goto L54;
        };     // Catch: Exception -> L94
    L54:
        byte r2 = -1;
    L56:
        switch(r2) {
            case 0: goto L91;
            case 1: goto L91;
            case 2: goto L89;
            case 3: goto L86;
            case 4: goto L86;
            case 5: goto L86;
            case 6: goto L82;
            case 7: goto L73;
            case 8: goto L71;
            case 9: goto L69;
            case 10: goto L67;
            case 11: goto L65;
            case 12: goto L63;
            case 13: goto L61;
            case 14: goto L59;
            default: goto L93;
        };
    L86:
        Context r0 = this.a;     // Catch: Exception -> L94
        return al.a(r0, r0.getPackageName(), r8.toLowerCase());
    L93:
        throw new Exception("no info");     // Catch: Exception -> L94
    L59:
        return al.a(3);
    L61:
        return ae.a();
    L63:
        return al.a(2);
    L65:
        return al.a(1);
    L67:
        return al.a(0);
    L69:
        return ac.e();
    L71:
        return ac.d();
    L73:
        if (ac.a == true) goto L75;
        return "sdk 未初始化支持国密";
    L75:
        if (Security.getProvider("BC") == null) goto L78;
        StringBuilder r9 = new StringBuilder();     // Catch: Exception -> L94
        r9.append(Security.getProvider("BC").getVersion());     // Catch: Exception -> L94
        return r9.toString();
    L78:
        return "Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) is null";
    L82:
        if (ac.a == false) goto L85;
        Context r10 = this.a;     // Catch: Exception -> L94
        return al.a(r10, r10.getPackageName());
    L85:
        return "sdk 未初始化支持国密";
    L89:
        return this.a.getApplicationContext().getPackageName();
    L91:
        return ak.c();
    L10:
        if (r1.equals("bcproviderversion") == false) goto L54;
        r2 = 7;
        goto L56
    L13:
        if (r1.equals("debuginfoall") == false) goto L54;
        r2 = 11;
        goto L56
    L16:
        if (r1.equals("packagename") == false) goto L54;
        r2 = 2;
        goto L56
    L19:
        if (r1.equals("deviceinfo") == false) goto L54;
        r2 = 13;
        goto L56
    L22:
        if (r1.equals("sdkversion") == false) goto L54;
        r2 = 8;
        goto L56
    L25:
        if (r1.equals("appid") == false) goto L54;
        r2 = 1;
        goto L56
    L28:
        if (r1.equals("sha1") == false) goto L54;
        r2 = 4;
        goto L56
    L31:
        if (r1.equals("sm3") == false) goto L54;
        r2 = 6;
        goto L56
    L34:
        if (r1.equals(DBDefinition.MD5) == false) goto L54;
        r2 = 3;
        goto L56
    L37:
        if (r1.equals("debuginfo") == false) goto L54;
        r2 = 10;
        goto L56
    L40:
        if (r1.equals("debuginforesult") == false) goto L54;
        r2 = 12;
        goto L56
    L43:
        if (r1.equals("sha256") == false) goto L54;
        r2 = 5;
        goto L56
    L46:
        if (r1.equals("debuginfocosttime") == false) goto L54;
        r2 = 14;
        goto L56
    L49:
        if (r1.equals("apikey") == false) goto L54;
        r2 = 0;
        goto L56
    L52:
        if (r1.equals("testversion") == false) goto L54;
        r2 = 9;
    L94:
        e = move-exception;
        return "no info:" + e.toString();
    }

    public final void a(Context r3, int r4) {
        j.b(r3, a(r4), this.b + this.c);
    }

    public final boolean a(Context r2, int r3, String r4, String r5) {
        if (r4.equals(this.b) == true) goto L5;
        return false;
    L5:
        return j.a(r2, a(r3), r4 + this.c, r5);
    }

    public final boolean a(Context r5, String r6, String r7, boolean r8) {
        al.b();
        al.e("cuPreGetToken");
        al.c();
        if (r5 != null) goto L42;
    L33:
        aj.c("初始化参数不能为空");     // Catch: Exception -> L35
        return false;
    L42:
    L35:
        e = move-exception;
        aj.a(e);
        return false;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L33;
        if (TextUtils.isEmpty(r7) == true) goto L33;
        if (TextUtils.isEmpty(ak.c()) == true) goto L13;
        aj.c("不可重复初始化");     // Catch: Exception -> L35
        return false;
    L13:
        ac.c = true;     // Catch: Exception -> L35
        ac.a = r8;     // Catch: Exception -> L35
        ac.d = true;     // Catch: Exception -> L35
        if (ac.a == false) goto L16;
        aj.a(" MyApplication.enableGuoMi  ");     // Catch: Exception -> L35
    L16:
        this.a = r5.getApplicationContext();     // Catch: Exception -> L35
        ak.c(r6);     // Catch: Exception -> L35
        ak.f(al.c(this.a));     // Catch: Exception -> L35
        Context r9 = this.a;     // Catch: Exception -> L35
        String r10 = am.a(r9, "auth02");     // Catch: Exception -> L35
        if (TextUtils.isEmpty(r10) == false) goto L23;
        r10 = al.b(UUID.randomUUID().toString().replace("-", "") + System.currentTimeMillis());     // Catch: Exception -> L35
        SharedPreferences.Editor r11 = r9.getSharedPreferences("cu_auth", 0).edit();     // Catch: Exception -> L21
        r11.putString("auth02", r10);     // Catch: Exception -> L21
        r11.commit();     // Catch: Exception -> L21
    L21:
        e = move-exception;
        aj.a(e);     // Catch: Exception -> L35
    L23:
        ak.g(r10);     // Catch: Exception -> L35
        ak.e();     // Catch: Exception -> L35
        c(new String(o.b("bXN2Ni53b3Ntcy5jbg==")));     // Catch: Exception -> L35
        aa.a = false;     // Catch: Exception -> L35
        aa.b = false;     // Catch: Exception -> L35
        if (ac.b() == true) goto L38;
    L31:
        aj.a(ae.a());     // Catch: Exception -> L35
        ak.h(Build.BRAND);     // Catch: Exception -> L35
        return true;
    L38:
        List<d> r12 = am.b(this.a, "DNSCache");     // Catch: Exception -> L29
        ak.o = r12;     // Catch: Exception -> L29
        if (r12.isEmpty() == false) goto L30;
        ak.a(this.a, d());     // Catch: Exception -> L29
    L30:
        this.e.submit(new 1(this));     // Catch: Exception -> L35
    L29:
        ak.o = new ArrayList();     // Catch: Exception -> L35
        goto L30
    }

    public final boolean a(String r2, int r3, int r4, h r5) {
        if (this.a != null) goto L5;
    L11:
        a(r4, r5, "sdk未初始化");
        return false;
    L5:
        if (TextUtils.isEmpty(ak.c()) == true) goto L11;
        if (TextUtils.isEmpty(ak.d()) == true) goto L11;
        al.b();
        al.e(r2);
        al.c();
        ak.c(r3);
        return true;
    }

    public final void b(String r2) {
        ai.a(this.a, r2);
    }
}
