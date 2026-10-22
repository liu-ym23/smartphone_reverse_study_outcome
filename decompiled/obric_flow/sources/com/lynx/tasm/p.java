package com.lynx.tasm;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.net.DefaultHttpServiceImpl;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.services.apm.api.IHttpService;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Application f10924a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f10925b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ib.d f10926c;
    public static String d;

    public static Settings a() {
        Lazy r5 = Settings.B;
        if (Settings.D == false) goto L5;
        Settings r10 = Settings.E;
        if (r10 != null) goto L9;
    L11:
        Application r11 = zg.b.f23438a;
        Settings r12 = (Settings) Settings.B.getValue();
        Settings.E = r12;
        return r12;
    L9:
        if (Intrinsics.areEqual(r10, (Settings) Settings.B.getValue()) == true) goto L11;
        return r10;
    L5:
        return (Settings) Settings.C.getValue();
    }

    public static String b() {
        String r5 = "";
        if (com.bytedance.crash.util.c.b() == true) goto L5;
        String r10 = Build.DISPLAY;
        if (r10.contains("Flyme") == false) goto L12;
    L64:
        if (r10 != null) goto L66;
    L68:
        return "";
    L66:
        if (r10.toLowerCase(Locale.getDefault()).contains("flyme") == false) goto L68;
        return r10;
    L12:
        if (Build.USER.equals("flyme") == true) goto L64;
        String r11 = Build.MANUFACTURER;
        boolean r12 = false;
        if (TextUtils.isEmpty(r11) == true) goto L17;
        boolean r13 = r11.toLowerCase(Locale.getDefault()).contains("oppo");
    L18:
        if (r13 == true) goto L20;
        String r14 = c("ro.build.version.emui");
        if (r14 != null) goto L29;
    L31:
        String r15 = "";
    L33:
        if (TextUtils.isEmpty(r15) == true) goto L35;
        return r15;
    L35:
        String r16 = c("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(r16) == true) goto L42;
        if (r16.toLowerCase(Locale.getDefault()).contains("funtouch") == false) goto L42;
        return c("ro.vivo.os.build.display.id") + "_" + c("ro.vivo.product.version");
    L42:
        if (TextUtils.isEmpty(r10) == false) goto L44;
    L47:
        StringBuilder r17 = sk.a.a(r11);
        r17.append(Build.BRAND);
        String r18 = r17.toString();
        if (TextUtils.isEmpty(r18) == true) goto L56;
        String r19 = r18.toLowerCase(Locale.getDefault());
        if (r19.contains("360") == true) goto L63;
        if (r19.contains("qiku") == false) goto L56;
    L63:
        return c("ro.build.uiversion") + "_" + r10;
    L56:
        if (TextUtils.isEmpty(c("ro.letv.release.version")) == true) goto L59;
        r5 = "eui_" + c("ro.letv.release.version") + "_" + r10;
    L59:
        if (TextUtils.isEmpty(r5) == true) goto L61;
        return r5;
    L61:
        return r10;
    L44:
        if (r10.toLowerCase(Locale.getDefault()).contains("amigo") == false) goto L47;
        StringBuilder r20 = com.lynx.tasm.utils.j.d(r10, "_");
        r20.append(c("ro.gn.sv.version"));
        return r20.toString();
    L29:
        if (r14.toLowerCase(Locale.getDefault()).contains("emotionui") == false) goto L31;
        StringBuilder r21 = com.lynx.tasm.utils.j.d(r14, "_");
        r21.append(r10);
        r15 = r21.toString();
        goto L33
    L20:
        if (TextUtils.isEmpty(r11) == true) goto L22;
        r12 = r11.toLowerCase(Locale.getDefault()).contains("oppo");
    L22:
        if (r12 == true) goto L24;
        return "";
    L24:
        return "coloros_" + c("ro.build.version.opporom") + "_" + r10;
    L17:
        r13 = false;
        goto L18
    L5:
        if (com.bytedance.crash.util.c.b() == true) goto L7;
        return "";
    L7:
        return "miui_" + c("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String c(String r5) {
        String r10 = "";
        Process r11 = Runtime.getRuntime().exec("getprop ".concat(r5));     // Catch: Throwable -> L7
        BufferedReader r12 = new BufferedReader(new InputStreamReader(r11.getInputStream()), 1024);     // Catch: Throwable -> L7
        r10 = r12.readLine();     // Catch: Throwable -> L10
        r11.destroy();     // Catch: Throwable -> L10
        com.bytedance.android.anniex.base.service.f.h(r12);
        return r10;
    L8:
        com.bytedance.android.anniex.base.service.f.h(r12);
        return r10;
    L7:
        r12 = null;
        goto L8
    }

    public static StringBuilder d(int r5, String r10, String r11) {
        return ai.j0.s(r5, r10, r11);
    }

    public static void e(String r5, String r10, String r11, String r12, String r13, String r14) {
        File r15 = null;
        String r16 = null;
        File r17 = null;
        File r18 = null;
        IHttpService r19 = (IHttpService) og.a.a(IHttpService.class);     // Catch: Throwable -> L6 Exception -> L8 IOException -> L54
        if (r19 != null) goto L10;
        r19 = new DefaultHttpServiceImpl();     // Catch: Throwable -> L6 Exception -> L8 IOException -> L54
    L10:
        oj.f r20 = r19.buildMultipartUpload(d, "UTF-8", false);     // Catch: Throwable -> L6 Exception -> L8 IOException -> L54
        r20.h(WsConstants.KEY_APP_ID, r5);     // Catch: Throwable -> L6 Exception -> L8 IOException -> L54
        r20.h("os", "Android");     // Catch: Throwable -> L6 Exception -> L8 IOException -> L54
        r20.h("update_version_code", r10);     // Catch: Throwable -> L6 Exception -> L8 IOException -> L54
        r20.h(LynxMonitorService.KEY_CHANNEL, r11);     // Catch: Throwable -> L6 Exception -> L8 IOException -> L54
        r20.h("release_build", r12);     // Catch: Throwable -> L6 Exception -> L8 IOException -> L54
        if (TextUtils.isEmpty(r14) == true) goto L13;
        r20.h(WsConstants.KEY_DEVICE_ID, r14);     // Catch: Throwable -> L6 Exception -> L8 IOException -> L54
    L13:
        r20.h("monitor_version", "5.0.21.11");     // Catch: Throwable -> L6 Exception -> L8 IOException -> L54
        File r21 = new File(r13);     // Catch: Throwable -> L6 Exception -> L8 IOException -> L54
        if (r21.exists() == false) goto L24;
        String r22 = r21.getParent() + "/" + (u8.a.u(r21) + ".zip");     // Catch: Throwable -> L6 Exception -> L8 IOException -> L54
        u8.a.s(r22, new String[]{r13});     // Catch: Throwable -> L6 Exception -> L8 IOException -> L54
        File r23 = new File(r22);     // Catch: Throwable -> L6 Exception -> L8 IOException -> L54
        goto L50
    L66:
        r20.d(r23, r23.getName(), new HashMap());     // Catch: IOException -> L19 Throwable -> L20 Exception -> L22
    L25:
        HashMap r24 = new HashMap();     // Catch: IOException -> L19 Throwable -> L20 Exception -> L22
        r24.put("filetype", "common_params");     // Catch: IOException -> L19 Throwable -> L20 Exception -> L22
        r24.put("logtype", "env");     // Catch: IOException -> L19 Throwable -> L20 Exception -> L22
        if (TextUtils.isEmpty(null) == false) goto L30;
        JSONObject r25 = new JSONObject();     // Catch: IOException -> L19 Throwable -> L20 Exception -> L22
        r25.put("defaultData", "none commonParams");     // Catch: IOException -> L19 Throwable -> L20 Exception -> L22 JSONException -> L53
    L29:
        r16 = r25.toString();     // Catch: IOException -> L19 Throwable -> L20 Exception -> L22
    L30:
        r20.f(r16, r24);     // Catch: IOException -> L19 Throwable -> L20 Exception -> L22
        new JSONObject(new String(r20.finish().f20586b)).optInt("errno", -1);     // Catch: IOException -> L19 Throwable -> L20 Exception -> L22 JSONException -> L33
    L35:
        if (r23 == null) goto L68;
        r23.delete();     // Catch: Throwable -> L38
    L58:
        return;
    L68:
        return;
    L33:
        e = move-exception;
        e.printStackTrace();     // Catch: IOException -> L19 Throwable -> L20 Exception -> L22
    L19:
        r18 = r23;
    L22:
        e = e;
        r15 = r23;
    L40:
        e.printStackTrace();     // Catch: Throwable -> L6
        if (r15 == null) goto L70;
        r15.delete();     // Catch: Throwable -> L38
        goto L58
    L70:
        return;
    L20:
        th = th;
        r17 = r23;
    L44:
        if (r17 != null) goto L61;
    L49:
        throw th;
    L61:
        r17.delete();     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        th.printStackTrace();
        goto L49
    L24:
        r23 = null;
    L6:
        th = th;
    L8:
        e = e;
    L50:
        if (r18 == null) goto L71;
        r18.delete();     // Catch: Throwable -> L38
        goto L58
    L71:
        return;
    L38:
        th = move-exception;
        th.printStackTrace();
    }

    public static boolean f() {
        int r5 = f10925b;
        if (r5 == (-1)) goto L14;
        if (r5 != 1) goto L6;
        return true;
    L6:
        return false;
    L14:
        Class.forName("ohos.utils.system.SystemCapability");     // Catch: Throwable -> L9
        f10925b = 1;     // Catch: Throwable -> L9
    L11:
        if (f10925b == 1) goto L13;
        return false;
    L13:
        return true;
    L9:
        f10925b = 0;
        goto L11
    }

    public static final ym.d g(com.squareup.kotlinpoet.x r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new ym.d(new LinkedHashMap(r5.c()));
    }

    public static int h(String r5) {
        if (r5.equals("零") == false) goto L5;
        return 0;
    L5:
        if (r5.equals("0") == false) goto L8;
        return 0;
    L8:
        if (r5.equals("一") == false) goto L10;
        return 1;
    L10:
        if (r5.equals(IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L13;
        return 1;
    L13:
        if (r5.equals("二") == false) goto L15;
        return 2;
    L15:
        if (r5.equals("两") == false) goto L17;
        return 2;
    L17:
        if (r5.equals("2") == false) goto L20;
        return 2;
    L20:
        if (r5.equals("三") == false) goto L22;
        return 3;
    L22:
        if (r5.equals("3") == false) goto L25;
        return 3;
    L25:
        if (r5.equals("四") == false) goto L27;
        return 4;
    L27:
        if (r5.equals("4") == false) goto L30;
        return 4;
    L30:
        if (r5.equals("五") == false) goto L32;
        return 5;
    L32:
        if (r5.equals("5") == false) goto L35;
        return 5;
    L35:
        if (r5.equals("六") == false) goto L37;
        return 6;
    L37:
        if (r5.equals("6") == false) goto L40;
        return 6;
    L40:
        if (r5.equals("七") == false) goto L42;
        return 7;
    L42:
        if (r5.equals("天") == false) goto L44;
        return 7;
    L44:
        if (r5.equals("日") == false) goto L46;
        return 7;
    L46:
        if (r5.equals("末") == false) goto L48;
        return 7;
    L48:
        if (r5.equals("7") == false) goto L51;
        return 7;
    L51:
        if (r5.equals("八") == false) goto L53;
        return 8;
    L53:
        if (r5.equals("8") == false) goto L56;
        return 8;
    L56:
        if (r5.equals("九") == false) goto L58;
        return 9;
    L58:
        if (r5.equals("9") == true) goto L82;
        return -1;
    L82:
        return 9;
    }

    public static void i(String r5) {
        d = ai.j0.k("https://", r5, "/monitor/collect/c/code_coverage");
    }

    public static boolean j(Object r5, pt.o r10, mt.b r11) {
        if ((r5 instanceof Callable) == true) goto L20;
        return false;
    L20:
        Object r12 = ((Callable) r5).call();     // Catch: Throwable -> L9
        if (r12 == null) goto L11;
        Object r13 = r10.apply(r12);     // Catch: Throwable -> L9
        io.reactivex.internal.functions.e.d(r13, "The mapper returned a null CompletableSource");     // Catch: Throwable -> L9
        mt.c r14 = (mt.c) r13;     // Catch: Throwable -> L9
    L12:
        if (r14 != null) goto L14;
        EmptyDisposable.complete(r11);
    L15:
        return true;
    L14:
        ((mt.a) r14).b(r11);
        goto L15
    L11:
        r14 = null;
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r11);
        return true;
    }

    public static boolean k(Object r5, pt.o r10, mt.u r11) {
        if ((r5 instanceof Callable) == true) goto L20;
        return false;
    L20:
        Object r12 = ((Callable) r5).call();     // Catch: Throwable -> L9
        if (r12 == null) goto L11;
        Object r13 = r10.apply(r12);     // Catch: Throwable -> L9
        io.reactivex.internal.functions.e.d(r13, "The mapper returned a null MaybeSource");     // Catch: Throwable -> L9
        mt.k r14 = (mt.k) r13;     // Catch: Throwable -> L9
    L12:
        if (r14 != null) goto L14;
        EmptyDisposable.complete(r11);
    L15:
        return true;
    L14:
        mt.h r15 = (mt.h) r14;
        r15.b(io.reactivex.internal.operators.maybe.e.d(r11));
        goto L15
    L11:
        r14 = null;
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r11);
        return true;
    }

    public static boolean l(Object r5, pt.o r10, mt.u r11) {
        if ((r5 instanceof Callable) == true) goto L20;
        return false;
    L20:
        Object r12 = ((Callable) r5).call();     // Catch: Throwable -> L9
        if (r12 == null) goto L11;
        Object r13 = r10.apply(r12);     // Catch: Throwable -> L9
        io.reactivex.internal.functions.e.d(r13, "The mapper returned a null SingleSource");     // Catch: Throwable -> L9
        mt.c0 r14 = (mt.c0) r13;     // Catch: Throwable -> L9
    L12:
        if (r14 != null) goto L14;
        EmptyDisposable.complete(r11);
    L15:
        return true;
    L14:
        mt.a0 r15 = (mt.a0) r14;
        r15.b(io.reactivex.internal.operators.single.c.d(r11));
        goto L15
    L11:
        r14 = null;
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r11);
        return true;
    }
}
