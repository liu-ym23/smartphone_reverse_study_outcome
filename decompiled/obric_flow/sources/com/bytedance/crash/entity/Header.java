package com.bytedance.crash.entity;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.Keep;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import androidx.room.writer.DaoWriter;
import com.bytedance.android.anniex.base.service.e;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.n;
import com.bytedance.crash.util.NativeTools;
import com.bytedance.crash.util.c;
import com.bytedance.crash.util.g;
import com.bytedance.ies.bullet.base.utils.b;
import com.lynx.tasm.p;
import i.a;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import l9.q;
import org.json.JSONException;
import org.json.JSONObject;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public final class Header {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f4027b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f4028c;
    public static int d;
    public static int e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f4029a;

    static {
        f4027b = new String[]{"version_code", "manifest_version_code", WsConstants.KEY_APP_ID, "update_version_code"};
        d = -1;
        e = -1;
    }

    public Header() {
        this.f4029a = new JSONObject();
    }

    public static Header a() {
        Header r5 = new Header();
        JSONObject r10 = r5.f4029a;
        r10.put(WsConstants.KEY_SDK_VERSION, 30107139);     // Catch: Exception -> L5
        r10.put("sdk_version_name", "3.1.7-rc.89");     // Catch: Exception -> L5
        r10.put("bytrace_id", n.c());     // Catch: Exception -> L5
    L4:
        return r5;
    }

    @Keep
    public static void addOtherHeader(JSONObject r5) {
        if (r5 == null) goto L112;
        StringBuilder r10 = new StringBuilder();
        if (c.b() == false) goto L9;
        r10.append("MIUI-");     // Catch: Throwable -> L87
    L23:
        r10.append(Build.VERSION.INCREMENTAL);     // Catch: Throwable -> L87
        if (r10.length() <= 0) goto L26;
        r5.put("rom", r10.toString());     // Catch: Throwable -> L87
    L26:
        r5.put("rom_version", p.b());     // Catch: Throwable -> L87
        goto L103
    L9:
        if (Build.DISPLAY.contains("Flyme") == false) goto L11;
    L14:
        boolean r11 = true;
    L15:
        if (r11 == false) goto L17;
        r10.append("FLYME-");     // Catch: Throwable -> L87
        goto L23
    L17:
        String r12 = p.c("ro.build.version.emui");     // Catch: Throwable -> L87
        if (c.a(r12) == false) goto L21;
        r10.append("EMUI-");     // Catch: Throwable -> L87
    L21:
        if (TextUtils.isEmpty(r12) == true) goto L23;
        r10.append(r12);     // Catch: Throwable -> L87
        r10.append(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);     // Catch: Throwable -> L87
        goto L23
    L11:
        if (Build.USER.equals("flyme") == true) goto L14;
        r11 = false;
    L103:
        DisplayMetrics r13 = n.f4057a.getResources().getDisplayMetrics();     // Catch: Exception -> L88
        int r14 = r13.densityDpi;     // Catch: Exception -> L88
        if (r14 != 120) goto L30;
        Object r15 = "ldpi";
    L37:
        r5.put("density_dpi", r14);     // Catch: Exception -> L88
        r5.put("display_density", r15);     // Catch: Exception -> L88
        r5.put("resolution", r13.heightPixels + "x" + r13.widthPixels);     // Catch: Exception -> L88
        goto L92
    L30:
        if (r14 != 240) goto L32;
        r15 = "hdpi";
        goto L37
    L32:
        if (r14 == 320) goto L34;
        r15 = "mdpi";
        goto L37
    L34:
        r15 = "xhdpi";
    L92:
        int r16 = TimeZone.getDefault().getRawOffset() / 3600000;     // Catch: Exception -> L89
        if (r16 >= (-12)) goto L42;
        r16 = -12;
    L42:
        if (r16 <= 12) goto L44;
        r16 = 12;
    L44:
        r5.put("timezone", r16);     // Catch: Exception -> L89
    L94:
        r5.put("os", "Android");     // Catch: Throwable -> L48
        if (NativeTools.k().E() == false) goto L50;
        Object r17 = "64";
    L51:
        r5.put("verify_info", r17);     // Catch: Throwable -> L48
        r5.put(WsConstants.KEY_DEVICE_ID, n.g().e());     // Catch: Throwable -> L48
        String r18 = Build.VERSION.RELEASE;     // Catch: Throwable -> L48
        if (r18.contains(".") == true) goto L55;
        r18 = r18.concat(".0");     // Catch: Throwable -> L48
    L55:
        r5.put("os_version", r18);     // Catch: Throwable -> L48
        r5.put("os_api", Build.VERSION.SDK_INT);     // Catch: Throwable -> L48
        String r19 = Build.MODEL;     // Catch: Throwable -> L48
        String r20 = Build.BRAND;     // Catch: Throwable -> L48
        if (r19 != null) goto L58;
        r19 = r20;
    L62:
        r5.put("device_model", r19);     // Catch: Throwable -> L48
        r5.put("device_brand", r20);     // Catch: Throwable -> L48
        r5.put("device_manufacturer", Build.MANUFACTURER);     // Catch: Throwable -> L48
        r5.put("cpu_abi", g());     // Catch: Throwable -> L48
        r5.put("cpu_model", e.e());     // Catch: Throwable -> L48
        r5.put("hardware", Build.HARDWARE);     // Catch: Throwable -> L48
        Object r21 = System.getProperty("os.version");     // Catch: Throwable -> L65
    L66:
        r5.put("kernel_version", r21);     // Catch: Throwable -> L48
        Context r22 = n.f4057a;     // Catch: Throwable -> L48
        String r23 = r22.getPackageName();     // Catch: Throwable -> L48
        r5.put("package", r23);     // Catch: Throwable -> L48
        ApplicationInfo r24 = r22.getPackageManager().getPackageInfo(r23, 0).applicationInfo;     // Catch: Throwable -> L48
        if (r24 == null) goto L100;
        int r25 = r24.labelRes;     // Catch: Throwable -> L48
        if (r25 <= 0) goto L100;
        r5.put("display_name", r22.getString(r25));     // Catch: Throwable -> L48
    L100:
        a.j();     // Catch: Throwable -> L91
        JSONObject r26 = a.f17477c;     // Catch: Throwable -> L91
        if (r26 == null) goto L86;
        Iterator<String> r27 = r26.keys();     // Catch: Throwable -> L91
    L78:
        if (r27.hasNext() == false) goto L114;
        String r28 = r27.next();     // Catch: Throwable -> L91
        if ("slardar_filter".equals(r28) == true) goto L78;
        Object r29 = a.f17477c.opt(r28);     // Catch: Throwable -> L91
        if (r29 == null) goto L78;
        r5.put(r28, r29);     // Catch: JSONException -> L90 Throwable -> L91
    L114:
        return;
    L86:
        return;
    L113:
        return;
    L65:
        r21 = null;
        goto L66
    L58:
        if (r20 == null) goto L62;
        if (r19.contains(r20) == true) goto L62;
        r19 = r20 + ' ' + r19;     // Catch: Throwable -> L48
        goto L62
    L50:
        r17 = "32";
    L48:
        th = move-exception;
        th.printStackTrace();
        goto L100
    }

    public static void addRuntimeHeader(JSONObject r5) {
        r5.put("access", b.c(n.f4057a));     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static z8.c c(String r10, long r11, long r13) {
        com.bytedance.ies.argus.bean.b r5 = com.bytedance.ies.argus.bean.b.a();
        if (r13 != 0) goto L5;
        r13 = System.currentTimeMillis();
    L5:
        r5.getClass();
        boolean r12 = TextUtils.isEmpty(r10);
        Context r14 = (Context) r5.f;
        if (r12 == false) goto L8;
    L9:
        r10 = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
    L10:
        String r15 = g.f4181a;
        File r16 = new File(g.h(r14), x8.a.f22982a + r10.replaceAll(":", "@"));
        Iterator r17 = r5.b(r16, ".ctx2").iterator();
        JSONObject r18 = null;
        q r19 = null;
    L12:
        if (r17.hasNext() == false) goto L21;
        q r20 = (q) r17.next();
        if (r11 == r20.f19586a) goto L15;
        if (r19 == null) goto L12;
    L15:
        if (r19 != null) goto L18;
        r19 = r20;
    L18:
        if (r13 < r20.f19587b) goto L12;
        r19 = r20;
    L21:
        if (r19 != null) goto L32;
        Iterator r110 = r5.b(r16, ".ctx2").iterator();
        q r111 = null;
    L24:
        if (r110.hasNext() == false) goto L30;
        q r112 = (q) r110.next();
        long r21 = r112.f19587b;
        if (r13 <= r21) goto L28;
        r112.e = r21;
        r111 = r112;
        goto L24
    L28:
        if (r111 != null) goto L30;
        r112.e = r21;
        r19 = r112;
    L31:
        boolean r113 = true;
    L34:
        if (r19 != null) goto L67;
    L48:
        if (r18 != null) goto L50;
    L59:
        z8.c r114 = new z8.c();
        Header r115 = a();
        r115.b(n.d().u());
        r115.f4029a.put("version_get_time", System.currentTimeMillis());     // Catch: Throwable -> L64
    L61:
        Header r116 = r115;
    L62:
        r116.j();
        d(r116);
        mh.e.g(r116.f4029a, "header", r114.f23416a);
        r114.f23417b = r116;
        return r114;
    L50:
        if (r18.length() == 0) goto L59;
        r114 = new z8.c(r18);
        Context r117 = n.f4057a;
        r116 = new Header();
        JSONObject r118 = r18.optJSONObject("header");
        if (r118 == null) goto L62;
        Iterator<String> r119 = r118.keys();
    L57:
        if (r119.hasNext() == false) goto L62;
        String r22 = r119.next();
        mh.e.g(r118.opt(r22), r22, r116.f4029a);
        goto L57
    L67:
        r18 = new JSONObject(cl.a.D(r19.f19588c.getAbsolutePath()));     // Catch: Throwable -> L65
    L37:
        long r120 = r19.e;
        if (r120 == 0) goto L45;
        if (r18 == null) goto L45;
        JSONObject r23 = r18.optJSONObject("header");
        if (r23 == null) goto L71;
    L44:
        r23.put("version_get_time", r120);     // Catch: Throwable -> L66
        goto L45
    L71:
        r23 = new JSONObject();     // Catch: Throwable -> L66
        r18.put("header", r23);     // Catch: Throwable -> L66
    L45:
        if (r113 == false) goto L48;
        if (r18 == null) goto L48;
        r18.remove("filters");
    L30:
        r19 = r111;
        goto L31
    L32:
        r113 = false;
        goto L34
    L8:
        if (m.k(r14, r10) == false) goto L10;
        goto L9
    }

    public static void d(Header r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        addOtherHeader(r5.f4029a);
    }

    public static boolean e(JSONObject r5) {
        if (r5 != null) goto L4;
        return true;
    L4:
        if (r5.length() != 0) goto L6;
        return true;
    L6:
        if (r5.opt("app_version") != null) goto L10;
        if (r5.opt("version_name") != null) goto L10;
        return true;
    L10:
        if (r5.opt("version_code") != null) goto L12;
        return true;
    L12:
        if (r5.opt("update_version_code") == null) goto L21;
        return false;
    L21:
        return true;
    }

    public static Header f() {
        Header r5 = a();
        addRuntimeHeader(r5.f4029a);
        d(r5);
        r5.b(n.d().u());
        r5.j();
        r5.k();
        return r5;
    }

    public static String g() {
        if (f4028c != null) goto L23;
        StringBuilder r5 = new StringBuilder();     // Catch: Exception -> L12
        if (Build.SUPPORTED_ABIS.length <= 0) goto L15;
        int r10 = 0;
    L7:
        String[] r11 = Build.SUPPORTED_ABIS;     // Catch: Exception -> L12
        if (r10 >= r11.length) goto L17;
        r5.append(r11[r10]);     // Catch: Exception -> L12
        if (r10 == (r11.length - 1)) goto L14;
        r5.append(", ");     // Catch: Exception -> L12
    L14:
        r10 = r10 + 1;     // Catch: Exception -> L12
    L17:
        if (TextUtils.isEmpty(r5.toString()) == false) goto L19;
        f4028c = "unknown";     // Catch: Exception -> L12
    L19:
        f4028c = r5.toString();     // Catch: Exception -> L12
        goto L23
    L15:
        r5 = new StringBuilder(Build.CPU_ABI);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        io.reactivex.exceptions.a.j(e);
        f4028c = "unknown";
    L23:
        return f4028c;
    }

    public static boolean h() {
        if (d != (-1)) goto L6;
        d = g().contains("64") ? 1 : 0;
    L6:
        if (d != 1) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean i() {
        if (e != (-1)) goto L6;
        e = g().contains("86") ? 1 : 0;
    L6:
        if (e != 1) goto L8;
        return true;
    L8:
        return false;
    }

    public final JSONObject b(Map r10) {
        JSONObject r11 = this.f4029a;
        if (r10 != null) goto L32;
        return r11;
    L32:
        Iterator r5 = r10.entrySet().iterator();     // Catch: Throwable -> L31
    L7:
        if (r5.hasNext() == false) goto L11;
        Map.Entry r12 = (Map.Entry) r5.next();     // Catch: Throwable -> L31
        if (r11.has((String) r12.getKey()) == true) goto L7;
        r11.put((String) r12.getKey(), r12.getValue());     // Catch: Throwable -> L31
        goto L7
    L11:
        String[] r13 = f4027b;     // Catch: Throwable -> L31
        int r14 = 0;
    L13:
        if (r14 >= 4) goto L21;
        String r15 = r13[r14];     // Catch: Throwable -> L31
        if (r10.containsKey(r15) == false) goto L19;
        r11.put(r15, Integer.parseInt(String.valueOf(r10.get(r15))));     // Catch: Throwable -> L18
    L18:
        r11.put(r15, r10.get(r15));     // Catch: Throwable -> L31
    L19:
        r14 = r14 + 1;     // Catch: Throwable -> L31
        goto L13
    L21:
        if (r10.containsKey("version_code") == false) goto L26;
        if (r10.containsKey("manifest_version_code") == true) goto L26;
        r11.put("manifest_version_code", Integer.parseInt(String.valueOf(r10.get("version_code"))));     // Catch: Throwable -> L30
    L26:
        if (r10.containsKey("version_name") == false) goto L28;
        r11.put("app_version", r10.get("version_name"));     // Catch: Throwable -> L31
        r11.remove("version_name");     // Catch: Throwable -> L31
    L28:
        r11.put("version_get_time", 0);     // Catch: Throwable -> L31
    L29:
        return r11;
    }

    public final void j() {
        this.f4029a.put(WsConstants.KEY_DEVICE_ID, n.g().e());     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public final void k() {
        i4.a r5 = n.d();     // Catch: JSONException -> L11
        r5.getClass();     // Catch: JSONException -> L11
        long r10 = ((ICommonParams) r5.f17503c).getUserId();     // Catch: Throwable -> L6
    L8:
        if (r10 <= 0) goto L18;
        this.f4029a.put("user_id", r10);     // Catch: JSONException -> L11
        return;
    L18:
        return;
    L6:
        r10 = 0;
    L11:
        e = move-exception;
        e.printStackTrace();
    }
}
