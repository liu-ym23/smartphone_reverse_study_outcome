package m5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e1 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Map r10, h1 r11, b1 r12) {
        Intrinsics.checkNotNullParameter(r11, "timeStampMap");
        Intrinsics.checkNotNullParameter(r12, "durationMap");
        if (r10 == null) goto L44;
        HashMap r13 = null;
        if (r10.get("metrics") == null) goto L16;
        Object r1 = r10.get("metrics");
        if ((r1 instanceof HashMap) == false) goto L9;
        HashMap r14 = (HashMap) r1;
    L10:
        if (r14 == null) goto L16;
        Object r0 = r10.get("metrics");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
        HashMap r15 = (HashMap) r0;
        Iterator r16 = r15.keySet().iterator();
    L13:
        if (r16.hasNext() == false) goto L16;
        String r17 = (String) r16.next();
        Object r18 = r15.get(r17);
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlin.Long");
        r12.d(r17, (Long) r18);
        goto L13
    L9:
        r14 = null;
    L16:
        if (r10.get("ssr_metrics") == null) goto L27;
        Object r19 = r10.get("ssr_metrics");
        if ((r19 instanceof HashMap) == false) goto L20;
        HashMap r20 = (HashMap) r19;
    L21:
        if (r20 == null) goto L27;
        Object r21 = r10.get("ssr_metrics");
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
        HashMap r22 = (HashMap) r21;
        Iterator r23 = r22.keySet().iterator();
    L24:
        if (r23.hasNext() == false) goto L27;
        String r24 = (String) r23.next();
        Object r25 = r22.get(r24);
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type kotlin.Long");
        r12.d(r24, (Long) r25);
        goto L24
    L20:
        r20 = null;
    L27:
        if (r10.get("setup_timing") == null) goto L35;
        Object r26 = r10.get("setup_timing");
        if ((r26 instanceof HashMap) == false) goto L31;
        HashMap r27 = (HashMap) r26;
    L32:
        if (r27 == null) goto L35;
        Object r28 = r10.get("setup_timing");
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
        HashMap r29 = (HashMap) r28;
        Intrinsics.checkNotNull(r29, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any?, kotlin.Any?>");
        r11.a(new JSONObject(r29));
        r12.d("create_lynx", Long.valueOf(b(r29, "create_lynx_start", "create_lynx_end")));
        r12.d("load_core", Long.valueOf(b(r29, "load_core_start", "load_core_end")));
        r12.d("decode", Long.valueOf(b(r29, "decode_start", "decode_end")));
        r12.d("lepus_execute", Long.valueOf(b(r29, "lepus_excute_start", "lepus_excute_end")));
        r12.d("create_vdom", Long.valueOf(b(r29, "create_vdom_start", "create_vdom_end")));
        r12.d("dispatch", Long.valueOf(b(r29, "dispatch_start", "dispatch_end")));
        r12.d("layout", Long.valueOf(b(r29, "layout_start", "layout_end")));
        r12.d("ui_operation_flush", Long.valueOf(b(r29, "ui_operation_flush_start", "ui_operation_flush_end")));
        r12.d("load_app", Long.valueOf(b(r29, "load_app_start", "load_app_end")));
        r12.d("load_template", Long.valueOf(b(r29, "load_template_start", "load_template_end")));
        goto L35
    L31:
        r27 = null;
    L35:
        if (r10.get("ssr_render_page_timing") == null) goto L45;
        Object r30 = r10.get("ssr_render_page_timing");
        if ((r30 instanceof HashMap) == false) goto L39;
        r13 = (HashMap) r30;
    L39:
        if (r13 == null) goto L46;
        Object r31 = r10.get("ssr_render_page_timing");
        Intrinsics.checkNotNull(r31, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
        HashMap r32 = (HashMap) r31;
        Intrinsics.checkNotNull(r32, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any?, kotlin.Any?>");
        r11.a(new JSONObject(r32));
        r12.d("render_page_ssr", Long.valueOf(b(r32, "render_page_start_ssr", "render_page_end_ssr")));
        r12.d("layout_ssr", Long.valueOf(b(r32, "layout_start_ssr", "layout_end_ssr")));
        r12.d("create_vdom_ssr", Long.valueOf(b(r32, "create_vdom_start_ssr", "create_vdom_end_ssr")));
        r12.d("dispatch_ssr", Long.valueOf(b(r32, "dispatch_start_ssr", "dispatch_end_ssr")));
        r12.d("ui_operation_flush_ssr", Long.valueOf(b(r32, "ui_operation_flush_start_ssr", "ui_operation_flush_end_ssr")));
        r12.d("decode_ssr", Long.valueOf(b(r32, "decode_start_ssr", "decode_end_ssr")));
        return;
    L46:
        return;
    L45:
        return;
    }

    public static long b(HashMap r10, String r11, String r12) {
        Object r13 = r10.get(r11);
        Long r1 = null;
        if ((r13 instanceof Long) == false) goto L5;
        Long r14 = (Long) r13;
    L6:
        Object r15 = r10.get(r12);
        if ((r15 instanceof Long) == false) goto L9;
        r1 = (Long) r15;
    L9:
        if (r14 == null) goto L14;
        if (r1 == null) goto L14;
        return r1.longValue() - r14.longValue();
    L14:
        com.bytedance.ai.utils.g.a.e("LynxTimelineHelper", "getDurationFromMap: " + r14 + ", " + r1 + ", " + r10);
        return 0;
    L5:
        r14 = null;
        goto L6
    }
}
