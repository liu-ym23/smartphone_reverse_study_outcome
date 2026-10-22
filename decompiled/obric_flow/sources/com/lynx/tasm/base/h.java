package com.lynx.tasm.base;

import ai.j0;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Window;
import android.view.WindowInsets;
import b3.k;
import b3.o;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.obric.clockwidgets.ClockWidgetConfigActivity;
import com.obric.clockwidgets.R$array;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
import mt.s;
import mt.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Long f10131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ib.d f10132b;

    public static long a(String r5, String r10, HashMap r11) {
        Object r12 = r11.get(r5);
        Long r13 = null;
        if ((r12 instanceof Long) == false) goto L5;
        Long r14 = (Long) r12;
    L6:
        Object r15 = r11.get(r10);
        if ((r15 instanceof Long) == false) goto L9;
        r13 = (Long) r15;
    L9:
        if (r14 == null) goto L14;
        if (r13 == null) goto L14;
        return r13.longValue() - r14.longValue();
    L14:
        String r16 = "getDurationFromMap: " + r14 + ", " + r13 + ", " + r11;
        Intrinsics.checkNotNullParameter("LynxTimelineHelper", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L19;
        r17.e("LynxTimelineHelper", r16);
        return 0;
    L19:
        return 0;
    L5:
        r14 = null;
        goto L6
    }

    public static String b(int r5, int r10, String r11, String r12) {
        return j0.f(r5, r10, r11, r12);
    }

    public static LocalDateTime c(LocalDateTime r5, long r10) {
        ChronoField r11 = ChronoField.DAY_OF_WEEK;
        Objects.requireNonNull(r5, "temporal");
        return (LocalDateTime) r5.with(r11, r10);
    }

    public static JSONObject d(HashMap r23) {
        JSONObject r5 = new JSONObject();
        long r10 = 0;
        long r11 = new StatFs(Environment.getDataDirectory().getPath()).getFreeBytes();     // Catch: Throwable -> L5
    L48:
        long r12 = new StatFs(Environment.getDataDirectory().getPath()).getTotalBytes();     // Catch: Throwable -> L8
    L9:
        String r13 = "1G - ";
        if (r11 > 1048576) goto L13;
        Object r14 = "0 - 50M";
    L20:
        if (r12 > 1048576) goto L23;
        r13 = "0 - 50M";
    L46:
        r23.put("inner_free", r14);     // Catch: Throwable -> L43
        r23.put("inner_free_real", r13);     // Catch: Throwable -> L43
        String r15 = Environment.getExternalStorageState();     // Catch: Throwable -> L31
    L33:
        if (TextUtils.equals(r15, "mounted") == true) goto L44;
        long r16 = 0;
    L40:
        Pair r17 = new Pair(Long.valueOf(r16), Long.valueOf(r10));     // Catch: Throwable -> L43
        r5.put("sdcard_total", ((Long) r17.first).longValue() / 1048576);     // Catch: Throwable -> L43
        r5.put("sdcard_free", ((Long) r17.second).longValue() / 1048576);     // Catch: Throwable -> L43
        r5.put("inner_free_real", r11 / 1048576);     // Catch: Throwable -> L43
        r5.put("inner_total_real", r12 / 1048576);     // Catch: Throwable -> L43
        r5.put("unit", 1048576);     // Catch: Throwable -> L43
        goto L41
    L44:
        StatFs r18 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());     // Catch: Throwable -> L38
        long r19 = r18.getAvailableBytes();     // Catch: Throwable -> L38
        r10 = r18.getBlockCountLong() * r18.getBlockSizeLong();
    L37:
        long r21 = r10;
        r10 = r19;
        r16 = r21;
    L38:
        r19 = 0;
    L31:
        r15 = null;
    L41:
        return r5;
    L23:
        if (r12 > 104857600) goto L26;
        r13 = "50M - 100M";
        goto L46
    L26:
        if (r12 > 1073741824) goto L46;
        r13 = "100M - 1G";
        goto L46
    L13:
        if (r11 > 104857600) goto L16;
        r14 = "50M - 100M";
        goto L20
    L16:
        if (r11 > 1073741824) goto L18;
        r14 = "100M - 1G";
        goto L20
    L18:
        r14 = "1G - ";
    L8:
        r12 = 0;
    L5:
        r11 = 0;
        goto L48
    }

    public static void e(Map r10, o r11, k r12) {
        Intrinsics.checkNotNullParameter(r11, "timeStampMap");
        Intrinsics.checkNotNullParameter(r12, "durationMap");
        if (r10 == null) goto L44;
        HashMap r5 = null;
        if (r10.get(LynxMonitorService.KEY_METRICS) == null) goto L16;
        Object r13 = r10.get(LynxMonitorService.KEY_METRICS);
        if ((r13 instanceof HashMap) == false) goto L9;
        HashMap r14 = (HashMap) r13;
    L10:
        if (r14 == null) goto L16;
        Object r15 = r10.get(LynxMonitorService.KEY_METRICS);
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
        HashMap r16 = (HashMap) r15;
        Iterator r17 = r16.keySet().iterator();
    L13:
        if (r17.hasNext() == false) goto L16;
        String r18 = (String) r17.next();
        Object r19 = r16.get(r18);
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.Long");
        r12.a(r18, (Long) r19);
        goto L13
    L9:
        r14 = null;
    L16:
        if (r10.get("ssr_metrics") == null) goto L27;
        Object r20 = r10.get("ssr_metrics");
        if ((r20 instanceof HashMap) == false) goto L20;
        HashMap r21 = (HashMap) r20;
    L21:
        if (r21 == null) goto L27;
        Object r22 = r10.get("ssr_metrics");
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
        HashMap r23 = (HashMap) r22;
        Iterator r24 = r23.keySet().iterator();
    L24:
        if (r24.hasNext() == false) goto L27;
        String r25 = (String) r24.next();
        Object r26 = r23.get(r25);
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type kotlin.Long");
        r12.a(r25, (Long) r26);
        goto L24
    L20:
        r21 = null;
    L27:
        if (r10.get(LynxMonitorService.KEY_SETUP_TIMING) == null) goto L35;
        Object r27 = r10.get(LynxMonitorService.KEY_SETUP_TIMING);
        if ((r27 instanceof HashMap) == false) goto L31;
        HashMap r28 = (HashMap) r27;
    L32:
        if (r28 == null) goto L35;
        Object r29 = r10.get(LynxMonitorService.KEY_SETUP_TIMING);
        Intrinsics.checkNotNull(r29, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
        HashMap r30 = (HashMap) r29;
        Intrinsics.checkNotNull(r30, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any?, kotlin.Any?>");
        r11.b(new JSONObject(r30));
        r12.a("create_lynx", Long.valueOf(a("create_lynx_start", "create_lynx_end", r30)));
        r12.a("load_core", Long.valueOf(a("load_core_start", "load_core_end", r30)));
        r12.a("decode", Long.valueOf(a("decode_start", "decode_end", r30)));
        r12.a("lepus_execute", Long.valueOf(a("lepus_excute_start", "lepus_excute_end", r30)));
        r12.a("create_vdom", Long.valueOf(a("create_vdom_start", "create_vdom_end", r30)));
        r12.a("dispatch", Long.valueOf(a("dispatch_start", "dispatch_end", r30)));
        r12.a("layout", Long.valueOf(a("layout_start", "layout_end", r30)));
        r12.a("ui_operation_flush", Long.valueOf(a("ui_operation_flush_start", "ui_operation_flush_end", r30)));
        r12.a("load_app", Long.valueOf(a("load_app_start", "load_app_end", r30)));
        r12.a("load_template", Long.valueOf(a("load_template_start", "load_template_end", r30)));
        goto L35
    L31:
        r28 = null;
    L35:
        if (r10.get("ssr_render_page_timing") == null) goto L45;
        Object r31 = r10.get("ssr_render_page_timing");
        if ((r31 instanceof HashMap) == false) goto L39;
        r5 = (HashMap) r31;
    L39:
        if (r5 == null) goto L46;
        Object r32 = r10.get("ssr_render_page_timing");
        Intrinsics.checkNotNull(r32, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
        HashMap r33 = (HashMap) r32;
        Intrinsics.checkNotNull(r33, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any?, kotlin.Any?>");
        r11.b(new JSONObject(r33));
        r12.a("render_page_ssr", Long.valueOf(a("render_page_start_ssr", "render_page_end_ssr", r33)));
        r12.a("layout_ssr", Long.valueOf(a("layout_start_ssr", "layout_end_ssr", r33)));
        r12.a("create_vdom_ssr", Long.valueOf(a("create_vdom_start_ssr", "create_vdom_end_ssr", r33)));
        r12.a("dispatch_ssr", Long.valueOf(a("dispatch_start_ssr", "dispatch_end_ssr", r33)));
        r12.a("ui_operation_flush_ssr", Long.valueOf(a("ui_operation_flush_start_ssr", "ui_operation_flush_end_ssr", r33)));
        r12.a("decode_ssr", Long.valueOf(a("decode_start_ssr", "decode_end_ssr", r33)));
        return;
    L46:
        return;
    L45:
        return;
    }

    public static void f(Window r5) {
        Intrinsics.checkNotNullParameter(r5, "window");
        Class<?> r10 = r5.getClass();     // Catch: Throwable -> L5
        Class<?> r11 = Class.forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L5
        int r12 = r11.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(r11);     // Catch: Throwable -> L5
        Class r13 = Integer.TYPE;     // Catch: Throwable -> L5
        r10.getMethod("setExtraFlags", new Class[]{r13, r13}).invoke(r5, new Object[]{Integer.valueOf(r12), Integer.valueOf(r12)});     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public static int g(ClockWidgetConfigActivity r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r10 != null) goto L5;
    L13:
        return -1;
    L5:
        if (r10.length() == 0) goto L13;
        String[] r11 = r5.getResources().getStringArray(R$array.cities_id);
        int r12 = r11.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L13;
        if (Intrinsics.areEqual(r10, r11[r13]) == true) goto L11;
        r13 = r13 + 1;
        goto L8
    L11:
        return r13;
    }

    public static int h(int r5) {
        int r10 = 0;
        int r11 = 1;
    L4:
        if (r11 > 256) goto L33;
        if ((r5 & r11) == 0) goto L32;
        if (r11 != 1) goto L9;
        int r12 = WindowInsets.Type.statusBars();
    L24:
        r10 = r10 | r12;
        goto L32
    L9:
        if (r11 != 2) goto L11;
        r12 = WindowInsets.Type.navigationBars();
        goto L24
    L11:
        if (r11 != 4) goto L13;
        r12 = WindowInsets.Type.captionBar();
        goto L24
    L13:
        if (r11 != 8) goto L15;
        r12 = WindowInsets.Type.ime();
        goto L24
    L15:
        if (r11 != 16) goto L17;
        r12 = WindowInsets.Type.systemGestures();
        goto L24
    L17:
        if (r11 != 32) goto L19;
        r12 = WindowInsets.Type.mandatorySystemGestures();
        goto L24
    L19:
        if (r11 != 64) goto L21;
        r12 = WindowInsets.Type.tappableElement();
        goto L24
    L21:
        if (r11 != 128) goto L32;
        r12 = WindowInsets.Type.displayCutout();
    L32:
        r11 = r11 << 1;
        goto L4
    L33:
        return r10;
    }

    public static boolean i(u r5, pt.o r10, s r11) {
        if ((r11 instanceof Callable) == true) goto L34;
        return false;
    L34:
        Object r12 = ((Callable) r11).call();     // Catch: Throwable -> L25
        if (r12 != null) goto L30;
        EmptyDisposable.complete(r5);
        return true;
    L30:
        Object r13 = r10.apply(r12);     // Catch: Throwable -> L22
        io.reactivex.internal.functions.e.d(r13, "The mapper returned a null ObservableSource");     // Catch: Throwable -> L22
        s r14 = (s) r13;     // Catch: Throwable -> L22
        if ((r14 instanceof Callable) == true) goto L32;
        r14.subscribe(r5);
    L21:
        return true;
    L32:
        Object r15 = ((Callable) r14).call();     // Catch: Throwable -> L17
        if (r15 != null) goto L16;
        EmptyDisposable.complete(r5);
        return true;
    L16:
        ObservableScalarXMap$ScalarDisposable r16 = new ObservableScalarXMap$ScalarDisposable(r5, r15);
        r5.onSubscribe(r16);
        r16.run();
    L17:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r5);
        return true;
    L22:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r5);
        return true;
    L25:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r5);
        return true;
    }
}
