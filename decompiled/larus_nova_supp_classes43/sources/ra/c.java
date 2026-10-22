package ra;

import android.net.Uri;
import android.view.View;
import com.bytedance.ies.bullet.lynx.init.e;
import com.bytedance.ies.bullet.lynx.init.h;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.ThreadStrategyForRendering;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final b a(b r26, Uri r27) {
        Intrinsics.checkNotNullParameter(r26, "<this>");
        Intrinsics.checkNotNullParameter(r27, "uri");
        if (r27.isHierarchical() == false) goto L5;
        HashMap<String, String> r14 = new HashMap();
        if (r27.getBooleanQueryParameter("enable_lynx_config", false) == false) goto L14;
        Iterator r1 = UriProtector.getQueryParameterNames(r27).iterator();
    L10:
        if (r1.hasNext() == false) goto L14;
        String r10 = (String) r1.next();
        String r11 = UriProtector.getQueryParameter(r27, r10);
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r11) == false) goto L10;
        r14.put(r10, r11);
    L14:
        String r12 = UriProtector.getQueryParameter(r27, "group");
        if (r12 != null) goto L17;
        r12 = "";
    L17:
        boolean r13 = r27.getBooleanQueryParameter("enable_canvas", false);
        boolean r15 = r27.getBooleanQueryParameter("enable_canvas_optimize", false);
        boolean r16 = r27.getBooleanQueryParameter("enable_dynamic_v8", false);
        boolean r17 = r27.getBooleanQueryParameter("share_group", true);
        boolean r18 = r27.getBooleanQueryParameter("use_storage_group", false);
        if (r13 == false) goto L23;
        if (Intrinsics.areEqual(r12, "-1") == true) goto L23;
        r12 = r12.concat("_canvas");
    L23:
        if (r26.c == null) goto L29;
        if (Intrinsics.areEqual(r26.d, r12) == false) goto L29;
        LynxGroup r19 = r26.c;
    L34:
        String r20 = UriProtector.getQueryParameter(r27, "lynx_preset_height");
        String r21 = UriProtector.getQueryParameter(r27, "lynx_preset_width");
        String r22 = UriProtector.getQueryParameter(r27, "lynx_preset_height_spec");
        String r23 = UriProtector.getQueryParameter(r27, "lynx_preset_width_spec");
        int r24 = r26.f;
        int r25 = r26.e;
        if (r21 != null) goto L38;
        if (r20 != null) goto L38;
    L45:
        if (r23 == null) goto L48;
        if (r22 == null) goto L48;
        int r28 = CastIntegerProtector.parseInt(r23);
        int r29 = CastIntegerProtector.parseInt(r22);
        int r30 = r28;
    L49:
        String r31 = UriProtector.getQueryParameter(r27, "thread_strategy");
        if (r31 == null) goto L64;
        int r32 = CastIntegerProtector.parseInt(r31);
        ThreadStrategyForRendering r33 = ThreadStrategyForRendering.ALL_ON_UI;
        if (r32 == r33.id()) goto L63;
        ThreadStrategyForRendering r34 = ThreadStrategyForRendering.MOST_ON_TASM;
        if (r32 == r34.id()) goto L62;
        r34 = ThreadStrategyForRendering.PART_ON_LAYOUT;
        if (r32 == r34.id()) goto L62;
        r34 = ThreadStrategyForRendering.MULTI_THREADS;
        if (r32 != r34.id()) goto L63;
    L62:
        ThreadStrategyForRendering r35 = r34;
    L65:
        boolean r36 = r27.getBooleanQueryParameter("enable_font_scale", false);
        String r37 = UriProtector.getQueryParameter(r27, "font_scale");
        Float r38 = null;
        if (r36 == false) goto L69;
        if (r37 != null) goto L69;
        Float r39 = h.d;
    L72:
        if (r39 == null) goto L74;
        float r40 = r39.floatValue();
    L75:
        boolean r41 = r27.getBooleanQueryParameter("enable_view_zoom", false);
        String r110 = UriProtector.getQueryParameter(r27, "view_zoom");
        if (r41 == false) goto L79;
        if (r110 != null) goto L79;
        r38 = h.e;
    L81:
        if (r38 == null) goto L83;
        float r42 = r38.floatValue();
    L84:
        float r111 = r42;
        String r43 = UriProtector.getQueryParameter(r27, "create_view_async");
        if (r43 == null) goto L93;
        Integer r44 = StringsKt.toIntOrNull(r43);
        if (r44 != null) goto L90;
    L92:
        boolean r45 = false;
    L94:
        String r46 = UriProtector.getQueryParameter(r27, "preset_safe_point");
        if (r46 == null) goto L103;
        Integer r47 = StringsKt.toIntOrNull(r46);
        if (r47 != null) goto L100;
    L102:
        boolean r48 = false;
    L104:
        String r112 = UriProtector.getQueryParameter(r27, "enable_code_cache");
        if (r112 == null) goto L113;
        Integer r113 = StringsKt.toIntOrNull(r112);
        if (r113 != null) goto L110;
    L112:
        boolean r114 = false;
    L114:
        String r115 = UriProtector.getQueryParameter(r27, "enable_sync_flush");
        if (r115 == null) goto L123;
        Integer r116 = StringsKt.toIntOrNull(r115);
        if (r116 != null) goto L120;
    L122:
        boolean r117 = false;
    L124:
        String r118 = UriProtector.getQueryParameter(r27, "disable_auto_expose");
        if (r118 == null) goto L133;
        Integer r119 = StringsKt.toIntOrNull(r118);
        if (r119 != null) goto L130;
    L132:
        boolean r210 = false;
    L134:
        String r120 = UriProtector.getQueryParameter(r27, "enable_pending_js_task");
        if (r120 == null) goto L143;
        Integer r121 = StringsKt.toIntOrNull(r120);
        if (r121 != null) goto L140;
    L142:
        boolean r211 = false;
    L144:
        String r122 = UriProtector.getQueryParameter(r27, "enable_vsync_aligned_message_loop");
        if (r122 == null) goto L153;
        Integer r123 = StringsKt.toIntOrNull(r122);
        if (r123 != null) goto L150;
    L152:
        boolean r212 = false;
    L154:
        String r124 = UriProtector.getQueryParameter(r27, "air_strict_mode");
        if (r124 == null) goto L163;
        Integer r125 = StringsKt.toIntOrNull(r124);
        if (r125 != null) goto L160;
    L162:
        boolean r213 = false;
    L164:
        b r0 = b.b(r26, r48, r35, r19, r12, r29, r30, r40, r45, r117, null, r210, null, null, r211, r213, r114, null, r212, r111, 2488832);
        r0.z = r27;
        r0.y = r14;
        return r0;
    L160:
        if (r125.intValue() != 1) goto L162;
        r213 = true;
        goto L164
    L163:
        r213 = r26.t;
        goto L164
    L150:
        if (r123.intValue() != 1) goto L152;
        r212 = true;
        goto L154
    L153:
        r212 = r26.w;
        goto L154
    L140:
        if (r121.intValue() != 1) goto L142;
        r211 = true;
        goto L144
    L143:
        r211 = r26.r;
        goto L144
    L130:
        if (r119.intValue() != 0) goto L132;
        r210 = true;
        goto L134
    L133:
        r210 = r26.k;
        goto L134
    L120:
        if (r116.intValue() != 1) goto L122;
        r117 = true;
        goto L124
    L123:
        r117 = r26.i;
        goto L124
    L110:
        if (r113.intValue() != 1) goto L112;
        r114 = true;
        goto L114
    L113:
        r114 = r26.u;
        goto L114
    L100:
        if (r47.intValue() != 1) goto L102;
        r48 = true;
        goto L104
    L103:
        r48 = r26.a;
        goto L104
    L90:
        if (r44.intValue() != 1) goto L92;
        r45 = true;
        goto L94
    L93:
        r45 = r26.h;
        goto L94
    L83:
        r42 = r26.x;
    L79:
        if (r110 == null) goto L81;
        r38 = Float.valueOf(CastFloatProtector.parseFloat(r110));
        goto L81
    L74:
        r40 = r26.g;
    L69:
        if (r37 == null) goto L71;
        r39 = Float.valueOf(CastFloatProtector.parseFloat(r37));
        goto L72
    L71:
        r39 = null;
    L63:
        r35 = r33;
        goto L65
    L64:
        r35 = r26.b;
    L48:
        r30 = r24;
        r29 = r25;
    L38:
        if (r21 == null) goto L40;
        int r49 = View.MeasureSpec.makeMeasureSpec(CastIntegerProtector.parseInt(r21), 1073741824);
    L41:
        if (r20 == null) goto L43;
        int r50 = View.MeasureSpec.makeMeasureSpec(CastIntegerProtector.parseInt(r20), 1073741824);
    L44:
        r25 = r50;
        r24 = r49;
        goto L45
    L43:
        r50 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L44
    L40:
        r49 = View.MeasureSpec.makeMeasureSpec(0, 0);
    L29:
        if (r18 == false) goto L31;
        b.a r51 = b.B;
        r19 = b.a.a(r12, r17, r13, new String[]{"assets://bdlynx_core.js"}, r16, r15, true);
        goto L34
    L31:
        if (r15 == false) goto L33;
        r19 = b.a.b(b.B, r12, r17, r13, new String[]{"assets://bdlynx_core.js"}, r16, r15);
        goto L34
    L33:
        b.a r52 = b.B;
        Intrinsics.checkNotNullParameter(r12, "groupName");
        r19 = e.b(r12, r17, r13, new String[]{"assets://bdlynx_core.js"}, r16, false);
        goto L34
    L5:
        return new b(false, null, null, null, 0, 0, 0.0f, false, false, null, false, 0, 0, null, false, false, false, false, null, false, 0.0f, 16777215);
    }
}
