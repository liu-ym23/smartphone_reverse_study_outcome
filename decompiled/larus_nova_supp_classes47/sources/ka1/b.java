package ka1;

import android.net.Uri;
import android.os.Parcelable;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.schema.convert.PopupGraType;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.live.schema.vo.LynxHybridParamVo;
import com.bytedance.android.live.schema.vo.PopupHybridParamVo;
import ga1.c;
import ga1.d;
import ga1.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [android.os.Parcelable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v34, types: [com.bytedance.android.live.schema.vo.PopupHybridParamVo] */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    @JvmStatic
    public static final Parcelable a(ia1.b r59, ia1.a r60, boolean r62) {
        Intrinsics.checkNotNullParameter(r60, "hybridParams");
        int r3 = a.a[r60.a.ordinal()];
        String r5 = "";
        String r7 = null;
        Object r12 = 0;
        if (r3 != 1) goto L5;
        int r4 = a.c[r60.b.ordinal()];
        if (r4 == 1) goto L176;
        if (r4 != 2) goto L175;
        PopupGraType r1 = r60.c;
        Intrinsics.checkNotNullParameter(r1, "popType");
        int r2 = ga1.b.a[r1.ordinal()];
        if (r2 == 1) goto L145;
        if (r2 != 2) goto L144;
        Parcelable r0 = com.bytedance.android.live.schema.helper.a.b(r59.a, r59.b, r59.c);
    L177:
        Object r6 = r0;
    L178:
        StringBuilder r8 = new StringBuilder("HybridParamsFactory->getH5Params: ");
        if (r6 == null) goto L181;
        String r9 = r6.toString();
    L182:
        r8.append(r9);
        com.bytedance.android.live.schema.api.utils.a.d("tag_hybrid_parse", r8.toString());
        ?? r10 = r6;
    L183:
        StringBuilder r13 = new StringBuilder("HybridParamsFactory->getHybridParams: ");
        if (r10 == 0) goto L186;
        r7 = r10.toString();
    L186:
        r13.append(r7);
        com.bytedance.android.live.schema.api.utils.a.d("tag_hybrid_parse", r13.toString());
        return r10;
    L181:
        r9 = null;
        goto L182
    L144:
        throw new NoWhenBranchMatchedException();
    L145:
        ja1.a r14 = new ja1.a(r59.b, r59.a, null);
        PopupHybridParamVo r15 = com.bytedance.android.live.schema.helper.a.b(r59.a, r59.b, r59.c);
        if (r15 == null) goto L148;
        r15.a0((int) s1.G(s1.y()));
    L148:
        if (r15 == null) goto L150;
        r15.Y(r15.r());
    L150:
        if (r15 == null) goto L152;
        r15.W(r15.r());
    L152:
        if (r15 == null) goto L154;
        r15.S();
    L154:
        if (r15 == null) goto L156;
        r15.U();
    L156:
        if (r15 == null) goto L158;
        r15.R();
    L158:
        if (r15 == null) goto L160;
        r15.N();
    L160:
        if (r15 == null) goto L162;
        r15.Z(((Number) r14.a("use_player_bottom_height", r12)).intValue());
    L162:
        String r16 = (String) r14.a("show_from", "");
        BaseHybridParamVo r17 = com.bytedance.android.live.schema.helper.a.a(r59.a, r59.b, null, r14);
        if (r17 == null) goto L165;
        r17.g = true;
    L165:
        if (r15 == null) goto L167;
        r15.k = r17;
    L167:
        if (r15 == null) goto L169;
        r15.e = r16;
    L169:
        String r18 = "H5ParamsParse->bottomPopParams: " + r15;
        if (r18 == null) goto L173;
        r5 = r18;
    L173:
        com.bytedance.android.live.schema.api.utils.a.d("tag_hybrid_parse", r5);
        r6 = r15;
        goto L178
    L175:
        throw new NoWhenBranchMatchedException();
    L176:
        r0 = new c().a(r59, r62);
        goto L177
    L5:
        if (r3 != 2) goto L7;
        int r19 = a.d[r60.b.ordinal()];
        if (r19 == 1) goto L129;
        if (r19 != 2) goto L128;
        e r20 = new e();
        PopupGraType r22 = r60.c;
        Intrinsics.checkNotNullParameter(r22, "popType");
        int r23 = d.a[r22.ordinal()];
        if (r23 == 1) goto L92;
        if (r23 != 2) goto L91;
        ?? r24 = com.bytedance.android.live.schema.helper.a.b(r59.a, r59.b, r59.c);
        if (r24 == 0) goto L84;
        BaseHybridParamVo r25 = r24.k;
        if (r25 == null) goto L84;
        r25.g = true;
    L84:
        if (r24 == 0) goto L88;
        BaseHybridParamVo r26 = r24.k;
        if (r26 == null) goto L88;
        BaseHybridParamVo.HybridType r27 = BaseHybridParamVo.HybridType.LYNX;
        Intrinsics.checkNotNullParameter(r27, "<set-?>");
        r26.a = r27;
    L88:
        if (r24 == 0) goto L131;
        r24.j = (LynxHybridParamVo) r20.a(r59, false);
    L131:
        StringBuilder r28 = new StringBuilder("HybridParamsFactory->getLynxParams: ");
        if (r24 == 0) goto L134;
        String r29 = r24.toString();
    L135:
        r28.append(r29);
        com.bytedance.android.live.schema.api.utils.a.d("tag_hybrid_parse", r28.toString());
        r10 = r24;
        goto L183
    L134:
        r29 = null;
        goto L135
    L91:
        throw new NoWhenBranchMatchedException();
    L92:
        Uri r30 = r59.b;
        String r32 = r59.a;
        ArrayList r33 = new ArrayList();
        r33.add(new ja1.a.c(r32));
        r33.add(new ja1.a.b(r30));
        r33.add(new ja1.a.C0257a(null));
        PopupHybridParamVo r34 = com.bytedance.android.live.schema.helper.a.d(r59.a, r59.b, r59.c);
        if (r34 == null) goto L97;
        BaseHybridParamVo r35 = r34.k;
        if (r35 == null) goto L97;
        r35.g = true;
    L97:
        if (r34 == null) goto L99;
        r34.a0((int) s1.G(s1.y()));
    L99:
        if (r34 == null) goto L101;
        r34.N();
    L101:
        if (r34 == null) goto L103;
        r34.Y(r34.r());
    L103:
        if (r34 == null) goto L105;
        r34.W(r34.r());
    L105:
        if (r34 == null) goto L107;
        r34.S();
    L107:
        if (r34 == null) goto L109;
        r34.U();
    L109:
        if (r34 == null) goto L111;
        r34.R();
    L111:
        if (r34 != null) goto L113;
    L122:
        String r36 = "getLynxPopVo: " + r34;
        if (r36 == null) goto L126;
        r5 = r36;
    L126:
        com.bytedance.android.live.schema.api.utils.a.d("HybridParamHelper", r5);
        Object r37 = r34;
    L130:
        r24 = r37;
        goto L131
    L113:
        if (r33.isEmpty() == true) goto L121;
        Iterator r38 = r33.iterator();
    L117:
        if (r38.hasNext() == false) goto L121;
        ja1.b r39 = (ja1.b) r38.next();
        if (r39.a("use_player_bottom_height") == false) goto L117;
        r12 = r39.b("use_player_bottom_height", r12);
    L121:
        r34.Z(((Number) r12).intValue());
        goto L122
    L128:
        throw new NoWhenBranchMatchedException();
    L129:
        r37 = new e().a(r59, r62);
        goto L130
    L7:
        if (r3 != 3) goto L72;
        int r40 = a.b[r60.b.ordinal()];
        if (r40 == 1) goto L69;
        if (r40 != 2) goto L68;
        Intrinsics.checkNotNullParameter(r60.c, "popType");
        ja1.a r42 = r59.d;
        if (r42 != null) goto L15;
        r42 = new ja1.a(r59.b, r59.a, r59.c);
    L15:
        if (((Number) r42.a("use_host", r12)).intValue() != 1) goto L17;
        boolean r43 = true;
    L18:
        if (r43 == false) goto L20;
        BaseHybridParamVo.HybridType r44 = BaseHybridParamVo.HybridType.HOST_H5;
    L21:
        int r210 = ((Number) r42.a("radius", 8)).intValue();
        int r211 = ((Number) r42.a("horizontal_radius", -1)).intValue();
        int r110 = ((Number) r42.a("height", 400)).intValue();
        int r111 = ((Number) r42.a("width", 300)).intValue();
        int r212 = ((Number) r42.a("margin", r12)).intValue();
        int r310 = ((Number) r42.a("height_percent", r12)).intValue();
        int r311 = ((Number) r42.a("width_percent", r12)).intValue();
        int r112 = ((Number) r42.a("horizontal_height", r12)).intValue();
        int r113 = ((Number) r42.a("horizontal_width", r12)).intValue();
        int r213 = ((Number) r42.a("horizontal_height_percent", r12)).intValue();
        int r214 = ((Number) r42.a("horizontal_width_percent", r12)).intValue();
        float r49 = ((Number) r42.a("mask_alpha", Float.valueOf(0.0f))).floatValue();
        int r50 = ((Number) r42.a("close_type", r12)).intValue();
        if (((Number) r42.a("show_dim", r12)).intValue() != 1) goto L24;
        boolean r312 = true;
    L26:
        if (((Number) r42.a("mask_click_disable", r12)).intValue() != 0) goto L28;
        boolean r313 = true;
    L30:
        if (((Number) r42.a("open_animate", 1)).intValue() != 1) goto L32;
        boolean r46 = true;
    L34:
        if (((Number) r42.a("landscape_custom_gravity", r12)).intValue() != 1) goto L36;
        boolean r314 = true;
    L38:
        if (((Number) r42.a("landscape_custom_height", r12)).intValue() != 1) goto L40;
        boolean r315 = true;
    L41:
        int r316 = ((Number) r42.a("rate_height", -1)).intValue();
        String r45 = (String) r42.a("up_status_bar_bg_color", "");
        if (((Number) r42.a("landscape_custom_width", r12)).intValue() != 1) goto L44;
        boolean r317 = true;
    L46:
        if (((Number) r42.a("up_full_screen", r12)).intValue() != 1) goto L48;
        boolean r47 = true;
    L49:
        int r48 = ((Number) r42.a("up_offset_height", -1)).intValue();
        int r410 = ((Number) r42.a("up_height_percent", 70)).intValue();
        int r52 = ((Number) r42.a("close_icon_position", r12)).intValue();
        if (((Number) r42.a("window_floating", 1)).intValue() != 1) goto L52;
        boolean r411 = true;
    L53:
        String r56 = (String) r42.a("show_animation_type", "bottom");
        if (((Number) r42.a("auto_show_nav_bar", r12)).intValue() != 1) goto L56;
        boolean r55 = true;
    L57:
        BaseHybridParamVo r53 = com.bytedance.android.live.schema.helper.a.a(r59.a, r59.b, null, r42);
        if (r53 == null) goto L60;
        Intrinsics.checkNotNullParameter(r44, "<set-?>");
        r53.a = r44;
    L60:
        if (r53 == null) goto L62;
        r53.g = true;
    L62:
        PopupHybridParamVo r54 = new PopupHybridParamVo(r111, r110, r113, r112, r213, r214, r212, r210, r211, 0, 0, 0, 0, 17, false, r315, r317, r314, r312, r312, r313, r310, r311, r316, r47, r48, r410, r45, null, null, r46, r411, false, r49, r50, "right".equals(Integer.valueOf(r52)), r52, null, r53, r55, r56, -1341628928, 265);
        String r57 = "CommonParamsParse->getWebPopVo: " + r54;
        if (r57 == null) goto L66;
        r5 = r57;
    L66:
        com.bytedance.android.live.schema.api.utils.a.d("tag_hybrid_parse", r5);
        Parcelable r58 = r54;
    L70:
        com.bytedance.android.live.schema.api.utils.a.d("tag_hybrid_parse", "HybridParamsFactory->getCommonParams: " + r58.toString());
        r10 = r58;
        goto L183
    L56:
        r55 = false;
        goto L57
    L52:
        r411 = false;
        goto L53
    L48:
        r47 = false;
        goto L49
    L44:
        r317 = false;
        goto L46
    L40:
        r315 = false;
        goto L41
    L36:
        r314 = false;
        goto L38
    L32:
        r46 = false;
        goto L34
    L28:
        r313 = false;
        goto L30
    L24:
        r312 = false;
        goto L26
    L20:
        r44 = BaseHybridParamVo.HybridType.H5;
        goto L21
    L17:
        r43 = false;
        goto L18
    L68:
        throw new NoWhenBranchMatchedException();
    L69:
        r58 = new ga1.a().a(r59, false);
        goto L70
    L72:
        throw new NoWhenBranchMatchedException();
    }
}
