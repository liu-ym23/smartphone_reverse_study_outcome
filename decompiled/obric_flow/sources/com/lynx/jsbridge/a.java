package com.lynx.jsbridge;

import ai.j0;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.CrashType;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import javax.lang.model.element.Element;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.d0;
import okhttp3.e0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static int a(Context r5, float r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return (int) ((r10 * r5.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.length() <= 7) goto L5;
        int r10 = Color.parseColor(r5);
        int r11 = r10 >>> 8;
        return (r10 << 24) | r11;
    L5:
        return Color.parseColor(r5);
    }

    public static Number c(Number r5, Number r10) {
        if (r5 != null) goto L8;
        if (r10 != null) goto L7;
        return -3;
    L7:
        return -1;
    L8:
        if (r10 == null) goto L10;
        double r11 = r5.doubleValue();
        double r12 = r10.doubleValue();
        if (r11 <= r12) goto L16;
        return -4;
    L16:
        return Double.valueOf(r12 - r11);
    L10:
        return -2;
    }

    public static String d(int r5, String r10) {
        return j0.g(r5, r10);
    }

    public static String e(String r5) {
        if (r5.length() != 0) goto L53;
        return r5;
    L53:
        if (StringsKt.P(r5, "http://") == false) goto L8;
    L47:
        String r10 = Uri.parse(r5).getPath();     // Catch: Exception -> L52
        if (r10 == null) goto L51;
        return r10;
    L8:
        if (StringsKt.P(r5, "https://") == true) goto L47;
        if (StringsKt.P(r5, "local_file://") == true) goto L47;
        if (StringsKt.P(r5, "lynxview://") == false) goto L15;
    L20:
        Uri r11 = Uri.parse(r5);     // Catch: Exception -> L52
        String r12 = r11.getQueryParameter("surl");     // Catch: Exception -> L52
        if (r12 != null) goto L23;
        r12 = r11.getQueryParameter("url");     // Catch: Exception -> L52
    L23:
        if (r12 != null) goto L25;
    L29:
        String r13 = r11.getQueryParameter(LynxMonitorService.KEY_CHANNEL);     // Catch: Exception -> L52
        String r14 = r11.getQueryParameter("bundle");     // Catch: Exception -> L52
        StringBuilder r15 = new StringBuilder();     // Catch: Exception -> L52
        if (r13 != null) goto L32;
    L35:
        if (r14 == null) goto L44;
        if (r14.length() == 0) goto L44;
        if (r15.length() <= 0) goto L42;
        r15.append("&");     // Catch: Exception -> L52
    L42:
        r15.append("bundle=");     // Catch: Exception -> L52
        r15.append(r14);     // Catch: Exception -> L52
    L44:
        if (r15.length() <= 0) goto L51;
        return r15.toString();
    L32:
        if (r13.length() == 0) goto L35;
        r15.append("channel=");     // Catch: Exception -> L52
        r15.append(r13);     // Catch: Exception -> L52
        goto L35
    L25:
        if (r12.length() == 0) goto L29;
        return e(r12);
    L15:
        if (StringsKt.P(r5, "aweme://") == true) goto L20;
        if (StringsKt.P(r5, "sslocal://") == true) goto L20;
        if (StringsKt.P(r5, "hybrid://") == true) goto L20;
    L51:
        return r5;
    }

    public static final String f(String r5, String r10) {
        if (r5 == null) goto L11;
        StringBuilder r11 = sk.a.a(r5);
        if (r10.length() <= 0) goto L6;
        String r12 = String.valueOf(r10.charAt(0)).toUpperCase(Locale.ROOT) + r10.substring(1);
    L7:
        r11.append(r12);
        String r13 = r11.toString();
        if (r13 == null) goto L11;
        return r13;
    L6:
        r12 = r10;
    L11:
        return r10;
    }

    public static LinkedHashMap g(String r10, Map r11) {
        Intrinsics.checkNotNullParameter(r11, "entry");
        Intrinsics.checkNotNullParameter("Start", "startSuffix");
        Intrinsics.checkNotNullParameter("End", "endSuffix");
        LinkedHashMap r5 = new LinkedHashMap();
        LinkedHashSet r12 = new LinkedHashSet();
        Iterator r13 = r11.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L40;
        Map.Entry r14 = (Map.Entry) r13.next();
        String r15 = (String) r14.getKey();
        Object r16 = r14.getValue();
        Number r17 = null;
        Map r18 = null;
        Number r19 = null;
        if (StringsKt.k(r15, "Start") == true) goto L7;
        if (StringsKt.k(r15, "End") == true) goto L20;
        if ((r16 instanceof Map) == true) goto L34;
        r5.put(f(r10, r15), r16);
        goto L4
    L34:
        if ((r16 instanceof Map) == false) goto L36;
        r18 = (Map) r16;
    L36:
        if (r18 != null) goto L37;
        r5.put(f(r10, r15), r16);
        goto L4
    L37:
        r5.putAll(g(r15, r18));
        goto L4
    L20:
        String r20 = StringsKt.B(r15, "End");
        Object r21 = io.reactivex.internal.observers.h.b(r20, "Start");
        if (r12.contains(r20) == true) goto L4;
        r12.add(r20);
        String r22 = f(r10, r20);
        Object r23 = r11.get(r21);
        if ((r23 instanceof Number) == false) goto L26;
        Number r24 = (Number) r23;
    L27:
        Object r25 = r11.get(r15);
        if ((r25 instanceof Number) == false) goto L30;
        r19 = (Number) r25;
    L30:
        r5.put(r22, c(r24, r19));
        goto L4
    L26:
        r24 = null;
        goto L27
    L7:
        String r26 = StringsKt.B(r15, "Start");
        Object r27 = io.reactivex.internal.observers.h.b(r26, "End");
        if (r12.contains(r26) == true) goto L4;
        r12.add(r26);
        String r28 = f(r10, r26);
        Object r29 = r11.get(r15);
        if ((r29 instanceof Number) == false) goto L13;
        Number r30 = (Number) r29;
    L14:
        Object r31 = r11.get(r27);
        if ((r31 instanceof Number) == false) goto L17;
        r17 = (Number) r31;
    L17:
        r5.put(r28, c(r30, r17));
        goto L4
    L13:
        r30 = null;
        goto L14
    L40:
        return r5;
    }

    public static Pattern h() {
        InputStream r5 = m.h.a().getAssets().open("TimeRegex.Gzip");
        Pattern r10 = Pattern.compile(((Pattern) new ObjectInputStream(new BufferedInputStream(new GZIPInputStream(r5))).readObject()).pattern());     // Catch: Throwable -> L7
        if (r5 == null) goto L6;
        r5.close();
    L6:
        return r10;
    L7:
        th = move-exception;
        if (r5 != null) goto L16;
    L13:
        throw th;
    L16:
        r5.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public static e0 i(e0 r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArrayList r5 = r10.g;
        if (Intrinsics.areEqual(r5.get(r5.size() - 1), "") == false) goto L5;
        return r10;
    L5:
        d0 r11 = r10.f();
        Intrinsics.checkNotNullParameter("", "pathSegment");
        r11.e("", 0, 0, false, false);
        return r11.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void j(File r30, JSONObject r31) {
        JSONObject r5 = r31;
        Object r10 = r5.opt("data");
        JSONObject r11 = r5.optJSONObject("header");
        JSONObject r12 = new JSONObject();
        JSONObject r13 = new JSONObject();
        if (r10 != null) goto L6;
        io.reactivex.exceptions.a.e("UPLOAD_CHECK", "upload data empty");
        return;
    L6:
        if (r11 != null) goto L10;
        io.reactivex.exceptions.a.e("UPLOAD_CHECK", "upload header empty");
        return;
    L10:
        if ((r10 instanceof JSONArray) == false) goto L13;
        CrashType r14 = CrashType.LAUNCH;
        io.reactivex.exceptions.a.e("UPLOAD_CHECK", "check launch ");
        JSONObject r15 = ((JSONArray) r10).optJSONObject(0);
        k(r15.opt("launch_did"), "launch_did", r12);
        String r28 = "process_name";
        CrashType r16 = r14;
        r5 = r15;
    L38:
        mh.e.g(r16, "crash_type", r12);
        mh.e.g(Integer.valueOf(r5.optInt("succ_step", -1)), "succ_step", r12);
        k(r5.opt("logcat"), "logcat", r12);
        if (mh.e.n(r5) == false) goto L41;
    L44:
        boolean r26 = true;
    L45:
        z8.c.l(r5, "filters", "has_logcat", String.valueOf(!r26));
        k(r5.opt("crash_time"), "crash_time", r12);
        k(r5.opt("crash_uuid"), "crash_uuid", r12);
        k(r5.opt("storage"), "storage", r12);
        k(r5.opt("filters"), "filters", r12);
        if (r5.opt("filters") == null) goto L48;
        k(r5.optJSONObject("filters").opt(WsConstants.KEY_SDK_VERSION), "filters:sdk_version", r12);
        k(r5.optJSONObject("filters").opt("is_root"), "filters:is_root", r12);
        k(r5.optJSONObject("filters").opt("is_64_devices"), "filters:is_64_devices", r12);
        k(r5.optJSONObject("filters").opt("is_64_runtime"), "filters:is_64_runtime", r12);
        k(r5.optJSONObject("filters").opt("is_x86_devices"), "filters:is_x86_devices", r12);
        k(r5.optJSONObject("filters").opt("kernel_version"), "filters:kernel_version", r12);
    L48:
        l(r11.optString("sdk_version_name"), "sdk_version_name", r12);
        l(r11.optString(WsConstants.KEY_SDK_VERSION), WsConstants.KEY_SDK_VERSION, r12);
        String r17 = r11.optString("os");
        if ("Android" != r17) goto L51;
    L54:
        l(r11.optString("os_version"), "os_version", r12);
        l(r11.optString("os_api"), "os_api", r12);
        l(r11.optString("device_model"), "device_model", r12);
        l(r11.optString("device_brand"), "device_brand", r12);
        l(r11.optString("device_manufacturer"), "device_manufacturer", r12);
        l(r11.optString("cpu_abi"), "cpu_abi", r12);
        l(r11.optString("package"), "package", r12);
        l(r11.optString("package"), "package", r12);
        l(r11.optString("unique_key"), "unique_key", r12);
        if (r11.optLong("version_get_time") != 0) goto L57;
        long r18 = 0;
    L59:
        if (r18 != 0) goto L61;
        String r19 = "normal";
    L64:
        z8.c.l(r5, "filters", "version_get_time", r19);
        if (r18 == 0) goto L67;
        mh.e.g(Long.valueOf(r18), "version_get_time", r13);
    L67:
        int r20 = r11.optInt("first_update_launch", -1);
        if (r20 != (-1)) goto L70;
        String r21 = null;
    L71:
        l(r21, "first_update_launch", r12);
        z8.c.l(r5, "filters", "first_update_launch", String.valueOf(r20));
        k(r5.opt("miniapp_id"), "miniapp_id", r12);
        k(r5.opt("plugin_info"), "plugin_info", r12);
        String r22 = r28;
        k(r5.opt(r22), r22, r12);
        k(r5.opt("plugin_info"), "plugin_info", r12);
        k(r5.opt(LynxMonitorService.KEY_PID), LynxMonitorService.KEY_PID, r12);
        k(r5.opt("app_start_time"), "app_start_time", r12);
        k(r5.opt("app_start_time_readable"), "app_start_time_readable", r12);
        k(r5.opt("patch_info"), "patch_info", r12);
        k(r5.opt("is_background"), "is_background", r12);
        k(r5.opt("activity_trace"), "activity_trace", r12);
        k(r5.opt("custom_long"), "custom_long", r12);
        k(r5.opt("custom"), "custom", r12);
        if (r5.optJSONObject("custom_long") == null) goto L74;
        k(r5.optJSONObject("custom_long").opt("activity_track"), "activity_track", r12);
    L74:
        k(r5.opt("battery"), "battery", r12);
        k(r5.opt("filters"), "filters", r12);
        if (r30 == null) goto L82;
        m("has_logcat_file", n(new File(r30, "logcat.txt")), r5, r12);
        if (new File(r30, "logerr.txt").exists() == false) goto L80;
        String r23 = "native";
    L81:
        z8.c.l(r5, "filters", "logcat_type", r23);
        m("has_maps_file", n(new File(r30, "maps.txt")), r5, r12);
        m("has_pthread_key_file", n(new File(r30, "pthread_key_info.txt")), r5, r12);
        m("has_pthread_key_map_file", n(new File(r30, "pthread_key_map.txt")), r5, r12);
        m("has_envinfo_file", n(new File(r30, "envinfo.txt")), r5, r12);
        m("has_meminfo_file", n(new File(r30, "meminfo.txt")), r5, r12);
        m("has_threads_file", n(new File(r30, "threads.txt")), r5, r12);
        String r24 = com.bytedance.crash.util.g.f4181a;
        m("has_pthreads_file", n(new File(r30, "pthreads.txt")), r5, r12);
        m("has_malloc_file", n(new File(r30, "malloc.txt")), r5, r12);
        m("has_fds_file", n(new File(r30, "fds.txt")), r5, r12);
        m("has_view_tree", n(new File(r30, "threads.txt")), r5, r12);
        goto L82
    L80:
        r23 = "java";
    L82:
        l9.n.b("crash_data_check", r12, r13);
        return;
    L70:
        r21 = "value";
        goto L71
    L61:
        if (r18 >= 0) goto L63;
        r19 = "old";
        goto L64
    L63:
        r19 = "new";
        goto L64
    L57:
        r18 = r11.optLong("version_get_time") - r5.optLong("crash_time");
        goto L59
    L51:
        if ("Android".equals(r17) == true) goto L54;
        r12.put("err_os_not_Android", 1);     // Catch: JSONException -> L84
        goto L54
    L41:
        if (mh.e.m(r5.optJSONArray("logcat")) == true) goto L44;
        r26 = false;
        goto L45
    L13:
        if (r5.optInt("is_anr") != 1) goto L30;
        CrashType r25 = CrashType.ANR;
        int r110 = 1;
        int r27 = !new JSONObject(r5.optString("data")).optString("mainStackFromTrace").trim().startsWith("at") ? 1 : 0;
    L18:
        Integer r29 = Integer.valueOf(r110);
        Integer r111 = Integer.valueOf(r27);
        if (r29 != r111) goto L21;
    L25:
        r28 = "process_name";
        int r112 = 1;
    L26:
        if (r27 != r112) goto L28;
        boolean r32 = r112;
    L29:
        z8.c.l(r5, "filters", "has_native_stack", String.valueOf(r32));
        io.reactivex.exceptions.a.e("UPLOAD_CHECK", "check anr ");
        r16 = r25;
        goto L38
    L28:
        r32 = 0;
        goto L29
    L21:
        if (r29.equals(r111) == true) goto L25;
        r28 = "process_name";
        r112 = 1;
        r12.put("err_has_native_stack_not_" + r29, 1);     // Catch: JSONException -> L85
    L17:
        r110 = 1;
        r27 = -1;
        goto L18
    L30:
        r28 = "process_name";
        if (r5.optInt("is_native_crash") != 1) goto L34;
        r16 = CrashType.NATIVE;
        io.reactivex.exceptions.a.e("UPLOAD_CHECK", "check native ");
        goto L38
    L34:
        if (r5.optInt("is_dart") != 1) goto L37;
        CrashType r33 = CrashType.LAUNCH;
        io.reactivex.exceptions.a.e("UPLOAD_CHECK", "check dart ");
        return;
    L37:
        r16 = CrashType.JAVA;
        io.reactivex.exceptions.a.e("UPLOAD_CHECK", "check java ");
        goto L38
    }

    public static void k(Object r5, String r10, JSONObject r11) {
        if (r5 == null) goto L7;
        return;
    L7:
        r11.put("err_null_".concat(r10), 1);     // Catch: JSONException -> L6
        return;
    }

    public static void l(String r5, String r10, JSONObject r11) {
        if (TextUtils.isEmpty(r5) == true) goto L8;
        return;
    L8:
        r11.put("err_empty_".concat(r10), 1);     // Catch: JSONException -> L7
        return;
    }

    public static void m(String r5, boolean r10, JSONObject r11, JSONObject r12) {
        if (r10 == false) goto L8;
    L5:
        z8.c.l(r11, "filters", r5, String.valueOf(r10));
        return;
    L8:
        r12.put(r5.concat("_false"), 1);     // Catch: JSONException -> L7
        goto L5
    }

    public static boolean n(File r5) {
        if (r5.exists() == true) goto L5;
        return false;
    L5:
        if (r5.length() <= 128) goto L10;
        return true;
    L10:
        return false;
    }

    public static void o(com.squareup.kotlinpoet.q r5, Element r10) {
        Intrinsics.checkNotNullParameter(r10, "originatingElement");
        r5.a().add(r10);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type T of com.squareup.kotlinpoet.OriginatingElementsHolder.Builder");
    }

    public static e0 p(e0 r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r10 = r5.g.size() - 1;
        if (Intrinsics.areEqual(r5.g.get(r10), "") == false) goto L9;
        d0 r11 = r5.f();
        ArrayList r12 = r11.f;
        r12.remove(r10);
        if (r12.isEmpty() == false) goto L8;
        r12.add("");
    L8:
        return r11.a();
    L9:
        return r5;
    }

    public static void q(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
    }

    public static final void r(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
    }

    public static void s(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
    }

    public static void t(Throwable r5) {
        if ((r5 instanceof VirtualMachineError) == true) goto L14;
        if ((r5 instanceof ThreadDeath) == true) goto L12;
        if ((r5 instanceof LinkageError) == true) goto L10;
        return;
    L10:
        throw ((LinkageError) r5);
    L12:
        throw ((ThreadDeath) r5);
    L14:
        throw ((VirtualMachineError) r5);
    }
}
