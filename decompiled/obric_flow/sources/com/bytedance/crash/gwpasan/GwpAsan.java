package com.bytedance.crash.gwpasan;

import android.content.Context;
import androidx.annotation.Keep;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.c;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.n;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import io.reactivex.exceptions.a;
import java.io.File;
import java.io.IOException;
import m.b;
import mh.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import z8.d;
import z8.f;

/* JADX INFO: loaded from: classes2.dex */
public class GwpAsan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static JSONArray f4030b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f4031c = null;
    public static String d = "None";
    public static String e = "None";
    public static String f = "None";
    public static String[] g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f4032h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f4033i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f4034j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f4035k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f4036l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static File f4037m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Context f4038n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static File f4039o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4040a;

    public static /* synthetic */ int a(int r5, String[] r10) {
        return gwpAsanNativeInit(r5, r10);
    }

    public static int b(JSONArray r5, int r10, String r11) {
    L3:
        if (r10 >= r5.length()) goto L10;
        String r12 = r5.optString(r10, null);
        if (r12 == null) goto L9;
        if (r12.startsWith(r11) == false) goto L9;
        return r10;
    L9:
        r10 = r10 + 1;
        goto L3
    L10:
        return -1;
    }

    public static String c(String r5) {
        StringBuilder r10 = new StringBuilder();
        if (r5.length() >= 16) goto L6;
        r10.append(r5);     // Catch: Throwable -> L11
    L12:
        goto L10
    L6:
        r10.append(r5.charAt(6));     // Catch: Throwable -> L11
        r10.append(r5.charAt(7));     // Catch: Throwable -> L11
        r10.append(r5.charAt(4));     // Catch: Throwable -> L11
        r10.append(r5.charAt(5));     // Catch: Throwable -> L11
        r10.append(r5.charAt(2));     // Catch: Throwable -> L11
        r10.append(r5.charAt(3));     // Catch: Throwable -> L11
        r10.append(r5.charAt(0));     // Catch: Throwable -> L11
        r10.append(r5.charAt(1));     // Catch: Throwable -> L11
        r10.append(r5.charAt(10));     // Catch: Throwable -> L11
        r10.append(r5.charAt(11));     // Catch: Throwable -> L11
        r10.append(r5.charAt(8));     // Catch: Throwable -> L11
        r10.append(r5.charAt(9));     // Catch: Throwable -> L11
        r10.append(r5.charAt(14));     // Catch: Throwable -> L11
        r10.append(r5.charAt(15));     // Catch: Throwable -> L11
        r10.append(r5.charAt(12));     // Catch: Throwable -> L11
        r10.append(r5.charAt(13));     // Catch: Throwable -> L11
        if (r5.length() < 32) goto L12;
        r10.append(r5, 16, 32);     // Catch: Throwable -> L11
        r10.append('0');     // Catch: Throwable -> L11
    L10:
        return r10.toString().toUpperCase();
    }

    public static boolean d(File r10, String r11) {
        File[] r12 = r10.listFiles();
        int r5 = 0;
    L4:
        if (r5 >= r12.length) goto L20;
        File r13 = r12[r5];
    L17:
        th = move-exception;
        c.f4025a.getClass();
        b.h("NPTH_CATCH", th);
    L19:
        r5 = r5 + 1;
        goto L4
    L7:
        if (r13.getName().isEmpty() == true) goto L19;
        if (r13.isDirectory() == true) goto L19;
        if (r13.getName().equals(r11) == false) goto L19;
        if (r13.length() < 0) goto L19;
        f4039o = r13.getAbsoluteFile();     // Catch: Throwable -> L17
        return true;
    L20:
        return false;
    }

    public static boolean e(boolean r13) {
        String[] r5 = new String[8];     // Catch: Throwable -> L10
        g = r5;     // Catch: Throwable -> L10
        if (f4030b == null) goto L7;
    L16:
        JSONArray r10 = f4030b;     // Catch: Throwable -> L10
        if (r10 != null) goto L19;
    L29:
        return false;
    L19:
        if (r10.length() <= 0) goto L29;
        if (r13 == false) goto L22;
        g[0] = f4030b.optString(0);     // Catch: Throwable -> L10
        String[] r14 = g;     // Catch: Throwable -> L10
        r14[1] = "8192";     // Catch: Throwable -> L10
        r14[2] = "150";     // Catch: Throwable -> L10
        r14[3] = f4030b.optString(3);     // Catch: Throwable -> L10
        g[4] = "0";     // Catch: Throwable -> L10
    L26:
        a.d("XASAN", "Conifig Init Param ok");     // Catch: Throwable -> L10
        return true;
    L22:
        int r15 = 0;
    L24:
        if (r15 >= f4030b.length()) goto L26;
        g[r15] = f4030b.optString(r15);     // Catch: Throwable -> L10
        r15 = r15 + 1;     // Catch: Throwable -> L10
        goto L24
    L7:
        if (f4032h == false) goto L15;
        if (r13 == false) goto L12;
        r5[0] = "0";     // Catch: Throwable -> L10
        r5[1] = "8192";     // Catch: Throwable -> L10
        r5[2] = "150";     // Catch: Throwable -> L10
        r5[3] = "0";     // Catch: Throwable -> L10
        r5[4] = "0";     // Catch: Throwable -> L10
    L13:
        a.d("XASAN", "Start Init Param");     // Catch: Throwable -> L10
        return true;
    L12:
        r5[0] = "0";     // Catch: Throwable -> L10
        r5[1] = "64";     // Catch: Throwable -> L10
        r5[2] = "5000";     // Catch: Throwable -> L10
        r5[3] = "0";     // Catch: Throwable -> L10
        r5[4] = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;     // Catch: Throwable -> L10
        goto L13
    L15:
        Thread.sleep(15000);     // Catch: Throwable -> L10
        f4030b = e.f(l9.c.e(), new String[]{"custom_event_settings", "npth_simple_setting", "gwp_asan_set_init_param"});     // Catch: Throwable -> L10
        a.d("XASAN", "Get Config Init Param again");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        c.f4025a.getClass();
        b.h("NPTH_CATCH", th);
        goto L29
    }

    public static void f(File r27, String r28) {
        String r5 = "gwp_asan_type";
        String r10 = "\\s";
        String r11 = "pid:";
        String r12 = "XASAN";
        File r13 = new File(r27, "tombstone.txt");
        z8.c r14 = new z8.c();
        JSONArray r15 = cl.a.F(r13.getAbsolutePath());     // Catch: Throwable -> L7 IOException -> L10
        if (r15 != null) goto L13;
        cl.a.C(r27);     // Catch: Throwable -> L7 IOException -> L10
        return;
    L13:
        int r16 = 0;
        int r17 = b(r15, 0, "pid:");     // Catch: Throwable -> L7 IOException -> L10
        if (r17 >= 0) goto L17;
        cl.a.C(r27);     // Catch: Throwable -> L7 IOException -> L10
        return;
    L17:
        String[] r18 = r15.optString(r17, null).trim().split("\\s");     // Catch: Throwable -> L7 IOException -> L10
        String r19 = null;
    L268:
        String r110 = r12;
        if (r16 >= r18.length) goto L36;
        String r20 = r18[r16];     // Catch: Throwable -> L25 IOException -> L27
        if (r11.equals(r20) == false) goto L29;
        String r111 = r18[r16 + 1];     // Catch: Throwable -> L25 IOException -> L27
        String r21 = r11;
        String r112 = r10;
        r14.i(LynxMonitorService.KEY_PID, Long.decode(r111.substring(0, r111.length() - 1)));     // Catch: Throwable -> L25 IOException -> L27
    L35:
        r16 = r16 + 1;     // Catch: Throwable -> L25 IOException -> L27
        r12 = r110;
        r10 = r112;
        r11 = r21;
        goto L268
    L29:
        r112 = r10;
        r21 = r11;
        if ("tid:".equals(r20) == false) goto L33;
        String r22 = r18[r16 + 1];     // Catch: Throwable -> L25 IOException -> L27
        r14.i("tid", Long.decode(r22.substring(0, r22.length() - 1)));     // Catch: Throwable -> L25 IOException -> L27
        goto L35
    L33:
        if ("name:".equals(r20) == false) goto L35;
        int r23 = r16 + 1;     // Catch: Throwable -> L25 IOException -> L27
        String r24 = r18[r23];     // Catch: Throwable -> L25 IOException -> L27
        r14.i("crash_thread_name", r24.substring(0, r24.length() - 1));     // Catch: Throwable -> L25 IOException -> L27
        String r25 = r18[r23];     // Catch: Throwable -> L25 IOException -> L27
        r19 = r25.substring(0, r25.length() - 1);     // Catch: Throwable -> L25 IOException -> L27
    L27:
        e = e;
        String r26 = r110;
    L255:
        a.d(r26, "upload IOException :" + e);
        cl.a.C(r27);
        return;
    L25:
        th = th;
        String r29 = r110;
    L253:
        c.a().getClass();
        b.h("NPTH_CATCH", th);
        a.d(r29, "upload Throwable:" + th);
        cl.a.C(r27);
        return;
    L36:
        String r113 = r10;
        r14.i("process_name", r18[r18.length - 2]);     // Catch: Throwable -> L25 IOException -> L27
        StringBuilder r30 = new StringBuilder();     // Catch: Throwable -> L25 IOException -> L27
        int r31 = b(r15, r17 + 1, "Signal ");     // Catch: Throwable -> L25 IOException -> L27
        if (r31 >= 0) goto L40;
        cl.a.C(r27);     // Catch: Throwable -> L25 IOException -> L27
        return;
    L40:
        r30.append(r15.optString(r31, null));     // Catch: Throwable -> L25 IOException -> L27
        r30.append('\n');     // Catch: Throwable -> L25 IOException -> L27
        int r32 = b(r15, r31 + 1, "GWP-ASan message:");     // Catch: Throwable -> L25 IOException -> L27
        if (r32 >= 0) goto L44;
        cl.a.C(r27);     // Catch: Throwable -> L25 IOException -> L27
        return;
    L44:
        String r33 = r15.optString(r32, null).replace("GWP-ASan message:", "abort message:");     // Catch: Throwable -> L25 IOException -> L27
        r30.append(r33);     // Catch: Throwable -> L25 IOException -> L27
        r30.append('\n');     // Catch: Throwable -> L25 IOException -> L27
        String r114 = "Double Free";
        if (r33.contains("Use After Free") == false) goto L49;
        f4031c = "Use After Free";     // Catch: Throwable -> L25 IOException -> L27
    L61:
        r14.p("gwp_asan_type", f4031c);     // Catch: Throwable -> L25 IOException -> L27
        int r34 = b(r15, r32 + 1, "backtrace:");     // Catch: Throwable -> L25 IOException -> L27
        if (r34 >= 0) goto L65;
        cl.a.C(r27);     // Catch: Throwable -> L25 IOException -> L27
        return;
    L65:
        String r35 = "    #00";
        int r36 = 1;
    L66:
        r34 = r34 + r36;     // Catch: Throwable -> L25 IOException -> L27
        String r37 = "gwp_asan_fatal_lib";
        String r210 = r35;
        String r211 = "null";
        if (r34 >= r15.length()) goto L126;
        String r38 = r15.optString(r34, null);     // Catch: Throwable -> L25 IOException -> L27
        if (r38.startsWith("    #") == false) goto L126;
        r30.append(r38.trim());     // Catch: Throwable -> L25 IOException -> L27
        r30.append('\n');     // Catch: Throwable -> L25 IOException -> L27
        if (r114.equals(f4031c) == false) goto L76;
        String r39 = "    #03";
    L75:
        String r212 = r114;
        if (r38.endsWith("libc.so") == true) goto L100;
        if (r38.endsWith("libc++_shared.so") == true) goto L100;
        if (r38.startsWith(r39) == false) goto L116;
        int r40 = r38.indexOf("==/lib/");     // Catch: Throwable -> L25 IOException -> L27
        int r41 = r38.indexOf(".so");     // Catch: Throwable -> L25 IOException -> L27
        if (r40 < 0) goto L89;
        if (r41 < 0) goto L89;
        r211 = r38.substring(r40, r41).substring(7);     // Catch: Throwable -> L25 IOException -> L27
    L89:
        String[] r42 = r211.trim().split("/");     // Catch: Throwable -> L25 IOException -> L27
        if (r42 == null) goto L116;
        if (r42.length <= 1) goto L116;
        String r43 = r42[1];     // Catch: Throwable -> L25 IOException -> L27
        String r44 = r43.substring(r43.lastIndexOf(47) + 1);     // Catch: Throwable -> L25 IOException -> L27
        d = r44;     // Catch: Throwable -> L25 IOException -> L27
        if (r44.length() < 1) goto L116;
        if (d.isEmpty() == true) goto L116;
        r14.p("gwp_asan_fatal_lib", d);     // Catch: Throwable -> L25 IOException -> L27
    L116:
        if (r28 == null) goto L123;
        if (r38.contains(r28) == false) goto L120;
    L121:
        f4036l = true;     // Catch: Throwable -> L25 IOException -> L27
    L125:
        r35 = r39;
        r114 = r212;
        r36 = 1;
        goto L66
    L120:
        if ("all".equals(r28) == false) goto L125;
    L123:
        if (r38.contains("data") == false) goto L125;
        f4036l = true;     // Catch: Throwable -> L25 IOException -> L27
    L100:
        if (r38.startsWith("    #01") == false) goto L116;
        int r45 = r38.indexOf("==/lib/");     // Catch: Throwable -> L25 IOException -> L27
        int r46 = r38.indexOf(".so");     // Catch: Throwable -> L25 IOException -> L27
        if (r45 < 0) goto L107;
        if (r46 < 0) goto L107;
        r211 = r38.substring(r45, r46).substring(7);     // Catch: Throwable -> L25 IOException -> L27
    L107:
        String[] r47 = r211.trim().split("/");     // Catch: Throwable -> L25 IOException -> L27
        if (r47 == null) goto L116;
        if (r47.length <= 1) goto L116;
        String r48 = r47[1];     // Catch: Throwable -> L25 IOException -> L27
        String r49 = r48.substring(r48.lastIndexOf(47) + 1);     // Catch: Throwable -> L25 IOException -> L27
        d = r49;     // Catch: Throwable -> L25 IOException -> L27
        if (r49.length() < 1) goto L116;
        if (d.isEmpty() == true) goto L116;
        r14.p("gwp_asan_fatal_lib", d);     // Catch: Throwable -> L25 IOException -> L27
        goto L116
    L76:
        r39 = r210;
    L126:
        String r50 = r30.toString();     // Catch: Throwable -> L25 IOException -> L27
        int r51 = b(r15, r34, "deallocated by thread") + 1;     // Catch: Throwable -> L25 IOException -> L27
    L128:
        String r213 = r37;
        String r214 = r5;
        String r52 = "    #02";
        if (r51 >= r15.length()) goto L157;
        String r215 = r33;
        String r53 = r15.optString(r51, null);     // Catch: Throwable -> L25 IOException -> L27
        if (r53.startsWith("    #01") == true) goto L138;
        if (r53.startsWith("    #02") == true) goto L138;
    L136:
        String r216 = r50;
    L156:
        r51 = r51 + 1;     // Catch: Throwable -> L25 IOException -> L27
        r50 = r216;
        r37 = r213;
        r5 = r214;
        r33 = r215;
    L138:
        if (r53.endsWith("libnpth_xasan.so") == true) goto L136;
        if (r53.endsWith("libc++_shared.so") == true) goto L136;
        int r54 = r53.indexOf("==/lib/");     // Catch: Throwable -> L25 IOException -> L27
        r216 = r50;
        int r55 = r53.indexOf(".so");     // Catch: Throwable -> L25 IOException -> L27
        if (r54 >= 0) goto L144;
    L143:
        String r56 = "null";
    L147:
        String[] r57 = r56.trim().split("/");     // Catch: Throwable -> L25 IOException -> L27
        if (r57 == null) goto L156;
        if (r57.length <= 1) goto L156;
        String r58 = r57[1];     // Catch: Throwable -> L25 IOException -> L27
        String r59 = r58.substring(r58.lastIndexOf(47) + 1);     // Catch: Throwable -> L25 IOException -> L27
        e = r59;     // Catch: Throwable -> L25 IOException -> L27
        if (r59.length() < 1) goto L156;
        if (e.isEmpty() == true) goto L156;
        r14.p("gwp_asan_deallocated_lib", e);     // Catch: Throwable -> L25 IOException -> L27
    L158:
        int r60 = b(r15, r51, "allocated by thread") + 1;     // Catch: Throwable -> L25 IOException -> L27
    L161:
        if (r60 >= r15.length()) goto L189;
        String r61 = r15.optString(r60, null);     // Catch: Throwable -> L25 IOException -> L27
        if (r61.startsWith("    #01") == true) goto L170;
        if (r61.startsWith(r52) == true) goto L170;
    L168:
        String r217 = r52;
    L188:
        r60 = r60 + 1;     // Catch: Throwable -> L25 IOException -> L27
        r52 = r217;
    L170:
        if (r61.endsWith("libnpth_xasan.so") == true) goto L168;
        if (r61.endsWith("libc++_shared.so") == true) goto L168;
        int r62 = r61.indexOf("==/lib/");     // Catch: Throwable -> L25 IOException -> L27
        r217 = r52;
        int r63 = r61.indexOf(".so");     // Catch: Throwable -> L25 IOException -> L27
        if (r62 >= 0) goto L176;
    L175:
        String r64 = "null";
    L179:
        String[] r65 = r64.trim().split("/");     // Catch: Throwable -> L25 IOException -> L27
        if (r65 == null) goto L188;
        if (r65.length <= 1) goto L188;
        String r66 = r65[1];     // Catch: Throwable -> L25 IOException -> L27
        String r67 = r66.substring(r66.lastIndexOf(47) + 1);     // Catch: Throwable -> L25 IOException -> L27
        f = r67;     // Catch: Throwable -> L25 IOException -> L27
        if (r67.length() < 1) goto L188;
        if (f.isEmpty() == true) goto L188;
        r14.p("gwp_asan_allocated_lib", f);     // Catch: Throwable -> L25 IOException -> L27
        goto L189
    L176:
        if (r63 < 0) goto L175;
        r64 = r61.substring(r62, r63).substring(7);     // Catch: Throwable -> L25 IOException -> L27
    L189:
        int r68 = b(r15, r60, "build id:");     // Catch: Throwable -> L25 IOException -> L27
        if (r68 <= 0) goto L203;
        JSONArray r69 = new JSONArray();     // Catch: Throwable -> L25 IOException -> L27
    L192:
        r68 = r68 + 1;     // Catch: Throwable -> L25 IOException -> L27
        if (r68 >= r15.length()) goto L202;
        String r70 = r15.optString(r68, null);     // Catch: Throwable -> L25 IOException -> L27
        if (r70.startsWith("    /") == false) goto L200;
        String r71 = r70.trim();     // Catch: Throwable -> L25 IOException -> L27
        String r72 = r113;
        String[] r73 = r71.split(r72);     // Catch: Throwable -> L25 IOException -> L27
        if (r73.length < 3) goto L201;
        String r74 = r73[0];     // Catch: Throwable -> L25 IOException -> L27
        r69.put(new JSONObject().put("lib_name", r74.substring(r74.lastIndexOf(47) + 1)).put("lib_uuid", c(r73[r73.length - 1].substring(0, r73[r73.length - 1].length() - 1))));     // Catch: Throwable -> L25 IOException -> L27
    L201:
        r113 = r72;
        goto L192
    L200:
        r72 = r113;
        goto L201
    L202:
        r14.i("crash_lib_uuid", r69);     // Catch: Throwable -> L25 IOException -> L27
    L203:
        r14.i("data", r30.toString());     // Catch: Throwable -> L25 IOException -> L27
    L207:
        th = th;
        String r75 = r110;
    L247:
        a.d(r75, "upload body Throwable:" + th);
        cl.a.C(r27);
        return;
    L205:
        if (f4038n != null) goto L209;
        f4038n = n.a();     // Catch: Throwable -> L207
    L209:
        Header r76 = Header.f();     // Catch: Throwable -> L207
        r76.f4029a.put(WsConstants.KEY_APP_ID, 1314);     // Catch: Throwable -> L207 JSONException -> L212
        r75 = r110;
    L216:
        e.g(r76.f4029a, "header", r14.f23416a);     // Catch: Throwable -> L245
        r14.f23417b = r76;     // Catch: Throwable -> L245
        r14.i("is_native_crash", 1);     // Catch: Throwable -> L245
        r14.i("crash_time", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L245
        r14.p("gwp_asan_app", f4038n.getPackageName());     // Catch: Throwable -> L245
        if (f4036l == false) goto L298;
        f4035k = true;
        String r77 = "false";
        if (r216 == null) goto L235;
        String r78 = r19;
        if (r78 == null) goto L235;
        f r79 = f.r(null, r216, r215, r78);     // Catch: Throwable -> L233
        r79.p(r214, f4031c);     // Catch: Throwable -> L233
        r79.p("gwp_asan_allocated_lib", f);     // Catch: Throwable -> L233
        r79.p("gwp_asan_deallocated_lib", e);     // Catch: Throwable -> L233
        r79.p(r213, d);     // Catch: Throwable -> L233
        if (f4035k == false) goto L227;
        String r80 = "true";
    L228:
        r79.p("has_gwp_asan", r80);     // Catch: Throwable -> L233
        File r81 = r27;
        com.bytedance.crash.upload.n.d(r79, d.f23419b, System.currentTimeMillis(), r81);     // Catch: Throwable -> L231
    L237:
        if (com.bytedance.crash.upload.b.a("unknown_old", n.e().getNativeCrashUploadUrl(), r14.f23416a.toString(), null, new c5.a[]{new c5.a(new File[]{r81, null}, true)}).c() == true) goto L239;
        return;
    L239:
        if (f4035k == false) goto L241;
        r77 = "true";
    L241:
        r14.p("has_gwp_asan", r77);     // Catch: Throwable -> L231
        com.bytedance.crash.upload.b.s();     // Catch: Throwable -> L231
        cl.a.C(r27);     // Catch: Throwable -> L231
        return;
    L231:
        Object th2 = th;
    L243:
        a.d(r75, "upload exception:" + th2);
        cl.a.C(r27);
        return;
    L227:
        r80 = "false";
    L233:
        th2 = th;
    L235:
        r81 = r27;
        goto L237
    L298:
        return;
    L245:
        th = th;
        goto L247
    L212:
        e = move-exception;
        r75 = r110;
        a.d(r75, "upload KEY_AID JSONException:" + e);     // Catch: Throwable -> L245
        goto L216
    L144:
        if (r55 < 0) goto L143;
        r56 = r53.substring(r54, r55).substring(7);     // Catch: Throwable -> L25 IOException -> L27
        goto L147
    L157:
        r216 = r50;
        r215 = r33;
        goto L158
    L49:
        if (r33.contains("Double Free") == false) goto L52;
        f4031c = "Double Free";     // Catch: Throwable -> L25 IOException -> L27
        goto L61
    L52:
        if (r33.contains("Buffer Overflow") == false) goto L55;
        f4031c = "Buffer Overflow";     // Catch: Throwable -> L25 IOException -> L27
        goto L61
    L55:
        if (r33.contains("Buffer Underflow") == false) goto L58;
        f4031c = "Buffer Underflow";     // Catch: Throwable -> L25 IOException -> L27
        goto L61
    L58:
        if (r33.contains("Invalid Free") == false) goto L60;
        f4031c = "Invalid Free";     // Catch: Throwable -> L25 IOException -> L27
        goto L61
    L60:
        f4031c = "Unknown";     // Catch: Throwable -> L25 IOException -> L27
        goto L61
    L251:
        e = e;
    L12:
        r26 = r12;
    L249:
        th = th;
    L9:
        r29 = r12;
    L10:
        e = e;
    L7:
        th = th;
        goto L9
    }

    @Keep
    private static native int gwpAsanNativeInit(int r5, String[] r10);
}
