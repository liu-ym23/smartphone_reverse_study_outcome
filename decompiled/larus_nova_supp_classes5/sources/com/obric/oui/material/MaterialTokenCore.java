package com.obric.oui.material;

import android.content.res.ColorStateList;
import com.obric.oui.blur.BlurTokenCore;
import com.obric.oui.color.BlendTokenCore;
import com.obric.oui.color.StrokeTokenCore;
import com.obric.oui.color.b;
import com.obric.oui.color.j0;
import com.obric.oui.fluid.FluidTokenCore;
import com.obric.oui.shadow.ShadowTokenCore;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class MaterialTokenCore {
    public static final e[] OUI_Bg_Floating_Blue_Dark = null;
    public static final e[] OUI_Bg_Floating_Blue_Light = null;
    public static final e[] OUI_Bg_Floating_Dark = null;
    public static final e[] OUI_Bg_Floating_Fill_Dark = null;
    public static final e OUI_Bg_Floating_Fill_Fluid_Dark = null;
    public static final e OUI_Bg_Floating_Fill_Fluid_Light = null;
    public static final e OUI_Bg_Floating_Fill_Frost_Dark = null;
    public static final e OUI_Bg_Floating_Fill_Frost_Light = null;
    public static final e[] OUI_Bg_Floating_Fill_Light = null;
    public static final e OUI_Bg_Floating_Fluid_Blue_Dark = null;
    public static final e OUI_Bg_Floating_Fluid_Blue_Light = null;
    public static final e OUI_Bg_Floating_Fluid_Dark = null;
    public static final e OUI_Bg_Floating_Fluid_Light = null;
    public static final e OUI_Bg_Floating_Fluid_Tinted_Dark = null;
    public static final e OUI_Bg_Floating_Fluid_Tinted_Light = null;
    public static final e OUI_Bg_Floating_Frost_Blue_Dark = null;
    public static final e OUI_Bg_Floating_Frost_Blue_Light = null;
    public static final e OUI_Bg_Floating_Frost_Dark = null;
    public static final e OUI_Bg_Floating_Frost_Light = null;
    public static final e OUI_Bg_Floating_Frost_Tinted_Dark = null;
    public static final e OUI_Bg_Floating_Frost_Tinted_Light = null;
    public static final e[] OUI_Bg_Floating_Light = null;
    public static final e[] OUI_Bg_Floating_OnImage_Dark = null;
    public static final e OUI_Bg_Floating_OnImage_Fluid_Dark = null;
    public static final e OUI_Bg_Floating_OnImage_Fluid_Light = null;
    public static final e OUI_Bg_Floating_OnImage_Frost_Dark = null;
    public static final e OUI_Bg_Floating_OnImage_Frost_Light = null;
    public static final e[] OUI_Bg_Floating_OnImage_Light = null;
    public static final e[] OUI_Bg_Floating_Overlay_Dark = null;
    public static final e OUI_Bg_Floating_Overlay_Fluid_Dark = null;
    public static final e OUI_Bg_Floating_Overlay_Fluid_Light = null;
    public static final e OUI_Bg_Floating_Overlay_Frost_Dark = null;
    public static final e OUI_Bg_Floating_Overlay_Frost_Light = null;
    public static final e[] OUI_Bg_Floating_Overlay_Light = null;
    public static final e[] OUI_Bg_Floating_Tinted_Dark = null;
    public static final e[] OUI_Bg_Floating_Tinted_Light = null;
    public static final e[] OUI_Bg_Modal_Dark = null;
    public static final e OUI_Bg_Modal_Fluid_Dark = null;
    public static final e OUI_Bg_Modal_Fluid_Light = null;
    public static final e OUI_Bg_Modal_Frost_Dark = null;
    public static final e OUI_Bg_Modal_Frost_Light = null;
    public static final e[] OUI_Bg_Modal_Light = null;
    public static final e[] OUI_Bg_Overlay_Search_Dark = null;
    public static final e OUI_Bg_Overlay_Search_Fluid_Dark = null;
    public static final e OUI_Bg_Overlay_Search_Fluid_Light = null;
    public static final e OUI_Bg_Overlay_Search_Frost_Dark = null;
    public static final e OUI_Bg_Overlay_Search_Frost_Light = null;
    public static final e[] OUI_Bg_Overlay_Search_Light = null;
    public static final e[] OUI_Bg_Popup_Dark = null;
    public static final e OUI_Bg_Popup_Fluid_Dark = null;
    public static final e OUI_Bg_Popup_Fluid_Light = null;
    public static final e OUI_Bg_Popup_Frost_Dark = null;
    public static final e OUI_Bg_Popup_Frost_Light = null;
    public static final e[] OUI_Bg_Popup_Light = null;
    public static final e[] OUI_Bg_Popup_OnImage_Dark = null;
    public static final e OUI_Bg_Popup_OnImage_Fluid_Dark = null;
    public static final e OUI_Bg_Popup_OnImage_Fluid_Light = null;
    public static final e OUI_Bg_Popup_OnImage_Frost_Dark = null;
    public static final e OUI_Bg_Popup_OnImage_Frost_Light = null;
    public static final e[] OUI_Bg_Popup_OnImage_Light = null;
    public static final e[] OUI_Bg_Popup_Overlay_Dark = null;
    public static final e OUI_Bg_Popup_Overlay_Fluid_Dark = null;
    public static final e OUI_Bg_Popup_Overlay_Fluid_Light = null;
    public static final e OUI_Bg_Popup_Overlay_Frost_Dark = null;
    public static final e OUI_Bg_Popup_Overlay_Frost_Light = null;
    public static final e[] OUI_Bg_Popup_Overlay_Light = null;
    public static final e OUI_Text_Primary_Dark = null;
    public static final e OUI_Text_Primary_Light = null;
    public static final e OUI_Text_Secondary_Dark = null;
    public static final e OUI_Text_Secondary_Light = null;
    public static final e OUI_Text_Tertiary_Dark = null;
    public static final e OUI_Text_Tertiary_Light = null;
    public static final String TOKEN_BG_FLOATING = "oui_bg_floating";
    public static final String TOKEN_BG_FLOATING_BLUE = "oui_bg_floating_blue";
    public static final String TOKEN_BG_FLOATING_FILL = "oui_bg_floating_fill";
    public static final String TOKEN_BG_FLOATING_ON_IMAGE = "oui_bg_floating_onimage";
    public static final String TOKEN_BG_FLOATING_OVERLAY = "oui_bg_floating_overlay";
    public static final String TOKEN_BG_FLOATING_TINTED = "oui_bg_floating_tinted";
    public static final String TOKEN_BG_MODAL = "oui_bg_modal";
    public static final String TOKEN_BG_POPUP = "oui_bg_popup";
    public static final String TOKEN_BG_POPUP_ON_IMAGE = "oui_bg_popup_onimage";
    public static final String TOKEN_BG_POPUP_OVERLAY = "oui_bg_popup_overlay";
    public static final String TOKEN_TEXT_PRIMARY = "oui_text_primary";
    public static final String TOKEN_TEXT_SECONDARY = "oui_text_secondary";
    public static final String TOKEN_TEXT_TERTIARY = "oui_text_tertiary";
    private static volatile ConcurrentHashMap<String, e[]> tokenSets;
    private static volatile ConcurrentHashMap<String, e> tokens;

    static {
        ColorStateList r1 = ColorStateList.valueOf(-1);
        b[] r16 = BlendTokenCore.OUI_Color_Blend_Frost_Regular_Light;
        b r24 = BlendTokenCore.OUI_Color_State_Press_Light;
        b r25 = b.c;
        kma.b r2 = kma.b.d(r16, r16, r24, r25, r25, r25);
        j0 r18 = StrokeTokenCore.OUI_Effect_Stroke_Regular_Light;
        Float r37 = Float.valueOf(8.0f);
        com.obric.oui.shadow.b[] r38 = ShadowTokenCore.Oui_Shadow_Regular;
        e r11 = new e(r1, r2, null, null, r18, null, null, r37, r38, null);
        OUI_Bg_Floating_Frost_Light = r11;
        ColorStateList r27 = ColorStateList.valueOf(-13421773);
        b[] r42 = BlendTokenCore.OUI_Color_Blend_Frost_Regular_Dark;
        b r8 = BlendTokenCore.OUI_Color_State_Press_Dark;
        kma.b r28 = kma.b.d(r42, r42, r8, r25, r25, r25);
        j0 r44 = StrokeTokenCore.OUI_Effect_Stroke_Regular_Dark;
        e r0 = new e(r27, r28, null, null, r44, null, null, r37, r38, null);
        OUI_Bg_Floating_Frost_Dark = r0;
        ColorStateList r29 = ColorStateList.valueOf(-1);
        b[] r10 = BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Light;
        kma.b r210 = kma.b.d(r10, r10, r24, r25, r25, r25);
        float r56 = BlurTokenCore.Blur_UltraThin;
        Float r34 = Float.valueOf(r56);
        com.obric.oui.fluid.b r57 = FluidTokenCore.OUI_Effect_Fluid_Regular_Light;
        e r9 = new e(r29, r210, null, null, null, null, null, r34, r38, r57);
        OUI_Bg_Floating_Fluid_Light = r9;
        ColorStateList r211 = ColorStateList.valueOf(-13421773);
        b[] r58 = BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Dark;
        kma.b r212 = kma.b.d(r58, r58, r8, r25, r25, r25);
        Float r35 = Float.valueOf(r56);
        com.obric.oui.fluid.b r59 = FluidTokenCore.OUI_Effect_Fluid_Regular_Dark;
        e r13 = new e(r211, r212, null, null, null, null, null, r35, r38, r59);
        OUI_Bg_Floating_Fluid_Dark = r13;
        OUI_Bg_Floating_Light = new e[]{r11, r9};
        OUI_Bg_Floating_Dark = new e[]{r0, r13};
        ColorStateList r213 = ColorStateList.valueOf(-1);
        b[] r3 = BlendTokenCore.OUI_Color_Blend_Frost_Thin_Light;
        j0 r12 = StrokeTokenCore.OUI_Effect_Stroke_Thin_Light;
        Float r61 = Float.valueOf(20.0f);
        com.obric.oui.shadow.b[] r62 = ShadowTokenCore.Oui_Shadow_Thick;
        e r4 = new e(r213, null, r3, null, r12, null, null, r61, r62, null);
        OUI_Bg_Floating_OnImage_Frost_Light = r4;
        ColorStateList r46 = ColorStateList.valueOf(-13421773);
        b[] r5 = BlendTokenCore.OUI_Color_Blend_Frost_Thin_Dark;
        j0 r63 = StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark;
        e r6 = new e(r46, null, r5, null, r63, null, null, r61, r62, null);
        OUI_Bg_Floating_OnImage_Frost_Dark = r6;
        ColorStateList r214 = ColorStateList.valueOf(-1);
        b[] r7 = BlendTokenCore.OUI_Color_Blend_Fluid_Thin_Light;
        e r14 = new e(r214, null, r7, null, null, null, null, r37, r62, r57);
        OUI_Bg_Floating_OnImage_Fluid_Light = r14;
        ColorStateList r215 = ColorStateList.valueOf(-13421773);
        b[] r64 = BlendTokenCore.OUI_Color_Blend_Fluid_Thin_Dark;
        e r15 = new e(r215, null, r64, null, null, null, null, r37, r62, r59);
        OUI_Bg_Floating_OnImage_Fluid_Dark = r15;
        OUI_Bg_Floating_OnImage_Light = new e[]{r4, r14};
        OUI_Bg_Floating_OnImage_Dark = new e[]{r6, r15};
        ColorStateList r216 = ColorStateList.valueOf(-1);
        b[] r17 = BlendTokenCore.OUI_Color_Fills_Thick_Light;
        e r19 = new e(r216, null, r17, null, null, null, null, r37, null, null);
        OUI_Bg_Floating_Fill_Frost_Light = r19;
        ColorStateList r217 = ColorStateList.valueOf(-13421773);
        b[] r110 = BlendTokenCore.OUI_Color_Fills_Thick_Dark;
        e r20 = new e(r217, null, r110, null, null, null, null, r37, null, null);
        OUI_Bg_Floating_Fill_Frost_Dark = r20;
        OUI_Bg_Floating_Fill_Fluid_Light = new e(ColorStateList.valueOf(-1), null, r17, null, null, null, null, r37, null, r57);
        OUI_Bg_Floating_Fill_Fluid_Dark = new e(ColorStateList.valueOf(-13421773), null, r110, null, null, null, null, r37, null, r59);
        OUI_Bg_Floating_Fill_Light = new e[]{r19};
        OUI_Bg_Floating_Fill_Dark = new e[]{r20};
        e r21 = new e(ColorStateList.valueOf(-1), null, r16, null, r18, null, null, r61, r62, null);
        OUI_Bg_Popup_Frost_Light = r21;
        e r22 = new e(ColorStateList.valueOf(-13421773), null, r42, null, r44, null, null, r61, r62, null);
        OUI_Bg_Popup_Frost_Dark = r22;
        e r23 = new e(ColorStateList.valueOf(-1), null, r10, null, null, null, null, r61, r62, r57);
        OUI_Bg_Popup_Fluid_Light = r23;
        e r111 = new e(ColorStateList.valueOf(-13421773), null, r58, null, null, null, null, r61, r62, r59);
        OUI_Bg_Popup_Fluid_Dark = r111;
        OUI_Bg_Popup_Light = new e[]{r21, r23};
        OUI_Bg_Popup_Dark = new e[]{r22, r111};
        ColorStateList r47 = ColorStateList.valueOf(-1);
        Float r26 = Float.valueOf(32.0f);
        com.obric.oui.shadow.b[] r30 = ShadowTokenCore.Oui_Shadow_UltraThick;
        e r31 = new e(r47, null, r3, null, r12, null, null, r26, r30, null);
        OUI_Bg_Popup_OnImage_Frost_Light = r31;
        e r32 = new e(ColorStateList.valueOf(-13421773), null, r5, null, r63, null, null, r26, r30, null);
        OUI_Bg_Popup_OnImage_Frost_Dark = r32;
        e r33 = new e(ColorStateList.valueOf(-1), null, r7, null, null, null, null, r61, r30, r57);
        OUI_Bg_Popup_OnImage_Fluid_Light = r33;
        e r36 = new e(ColorStateList.valueOf(-13421773), null, r64, null, null, null, null, r61, r30, r59);
        OUI_Bg_Popup_OnImage_Fluid_Dark = r36;
        OUI_Bg_Popup_OnImage_Light = new e[]{r31, r33};
        OUI_Bg_Popup_OnImage_Dark = new e[]{r32, r36};
        e r39 = new e(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Frost_Thick_Light, null, StrokeTokenCore.OUI_Effect_Stroke_Thick_Light, null, null, r26, null, null);
        OUI_Bg_Modal_Frost_Light = r39;
        e r40 = new e(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Frost_Thick_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Thick_Dark, null, null, r26, null, null);
        OUI_Bg_Modal_Frost_Dark = r40;
        e r41 = new e(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thick_Light, null, null, null, null, r26, null, r57);
        OUI_Bg_Modal_Fluid_Light = r41;
        e r43 = new e(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thick_Dark, null, null, null, null, r26, null, r59);
        OUI_Bg_Modal_Fluid_Dark = r43;
        OUI_Bg_Modal_Light = new e[]{r39, r41};
        OUI_Bg_Modal_Dark = new e[]{r40, r43};
        b[] r45 = BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Light;
        e r48 = new e(null, kma.b.d(r45, r45, r24, r25, r25, r25), null, null, r12, null, null, Float.valueOf(r56), null, null);
        OUI_Bg_Floating_Overlay_Frost_Light = r48;
        b[] r112 = BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Dark;
        e r49 = new e(null, kma.b.d(r112, r112, r8, r25, r25, r25), null, null, r63, null, null, Float.valueOf(r56), null, null);
        OUI_Bg_Floating_Overlay_Frost_Dark = r49;
        b[] r50 = BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Light;
        e r113 = new e(null, kma.b.d(r50, r50, r24, r25, r25, r25), null, null, null, null, null, Float.valueOf(r56), null, r57);
        OUI_Bg_Floating_Overlay_Fluid_Light = r113;
        b[] r114 = BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark;
        e r115 = new e(null, kma.b.d(r114, r114, r8, r25, r25, r25), null, null, null, null, null, Float.valueOf(r56), null, r59);
        OUI_Bg_Floating_Overlay_Fluid_Dark = r115;
        e[] r51 = {r48, r113};
        OUI_Bg_Floating_Overlay_Light = r51;
        e[] r52 = {r49, r115};
        OUI_Bg_Floating_Overlay_Dark = r52;
        OUI_Bg_Overlay_Search_Frost_Light = r48;
        OUI_Bg_Overlay_Search_Frost_Dark = r49;
        OUI_Bg_Overlay_Search_Fluid_Light = r113;
        OUI_Bg_Overlay_Search_Fluid_Dark = r115;
        OUI_Bg_Overlay_Search_Light = r51;
        OUI_Bg_Overlay_Search_Dark = r52;
        e r53 = new e(null, kma.b.c(r112, r112, r8), null, null, r63, null, null, r61, r62, null);
        OUI_Bg_Popup_Overlay_Frost_Light = r53;
        e r54 = new e(null, kma.b.c(r112, r112, r8), null, null, r63, null, null, r61, r62, null);
        OUI_Bg_Popup_Overlay_Frost_Dark = r54;
        e r55 = new e(null, kma.b.c(r114, r114, r8), null, null, null, null, null, r61, r62, r57);
        OUI_Bg_Popup_Overlay_Fluid_Light = r55;
        e r60 = new e(null, kma.b.c(r114, r114, r8), null, null, null, null, null, r61, r62, r57);
        OUI_Bg_Popup_Overlay_Fluid_Dark = r60;
        OUI_Bg_Popup_Overlay_Light = new e[]{r53, r55};
        OUI_Bg_Popup_Overlay_Dark = new e[]{r54, r60};
        ColorStateList r218 = ColorStateList.valueOf(-1);
        b[] r65 = BlendTokenCore.OUI_Color_Blend_Fill_Tinted_Light;
        e r66 = new e(r218, null, r65, null, StrokeTokenCore.OUI_Effect_Stroke_Tinted_Light, null, null, r37, r38, null);
        OUI_Bg_Floating_Frost_Tinted_Light = r66;
        ColorStateList r219 = ColorStateList.valueOf(-16777216);
        b[] r67 = BlendTokenCore.OUI_Color_Blend_Fill_Tinted_Dark;
        e r68 = new e(r219, null, r67, null, StrokeTokenCore.OUI_Effect_Stroke_Tinted_Dark, null, null, r37, r38, null);
        OUI_Bg_Floating_Frost_Tinted_Dark = r68;
        e r69 = new e(ColorStateList.valueOf(-1), null, r65, null, null, null, null, Float.valueOf(r56), r38, r59);
        OUI_Bg_Floating_Fluid_Tinted_Light = r69;
        e r70 = new e(ColorStateList.valueOf(-16777216), null, r67, null, null, null, null, Float.valueOf(r56), r38, r59);
        OUI_Bg_Floating_Fluid_Tinted_Dark = r70;
        OUI_Bg_Floating_Tinted_Light = new e[]{r66, r69};
        OUI_Bg_Floating_Tinted_Dark = new e[]{r68, r70};
        ColorStateList r220 = ColorStateList.valueOf(-15895809);
        b[] r71 = BlendTokenCore.OUI_Color_Blend_Blue_Regular_Light;
        e r72 = new e(r220, null, r71, null, StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular_Light, null, null, r37, r38, null);
        OUI_Bg_Floating_Frost_Blue_Light = r72;
        ColorStateList r221 = ColorStateList.valueOf(-16087553);
        b[] r73 = BlendTokenCore.OUI_Color_Blend_Blue_Regular_Dark;
        e r74 = new e(r221, null, r73, null, StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular_Dark, null, null, r37, r38, null);
        OUI_Bg_Floating_Frost_Blue_Dark = r74;
        e r75 = new e(ColorStateList.valueOf(-15895809), null, r71, null, null, null, null, Float.valueOf(r56), r38, r59);
        OUI_Bg_Floating_Fluid_Blue_Light = r75;
        e r76 = new e(ColorStateList.valueOf(-16087553), null, r73, null, null, null, null, Float.valueOf(r56), r38, r59);
        OUI_Bg_Floating_Fluid_Blue_Dark = r76;
        OUI_Bg_Floating_Blue_Light = new e[]{r72, r75};
        OUI_Bg_Floating_Blue_Dark = new e[]{r74, r76};
        OUI_Text_Primary_Light = new e(null, null, BlendTokenCore.OUI_Color_Blend_Text_Primary_Light, null, null, null, null, null, null, null);
        OUI_Text_Primary_Dark = new e(null, null, BlendTokenCore.OUI_Color_Blend_Text_Primary_Dark, null, null, null, null, null, null, null);
        OUI_Text_Secondary_Light = new e(null, null, BlendTokenCore.OUI_Color_Blend_Text_Secondary_Light, null, null, null, null, null, null, null);
        OUI_Text_Secondary_Dark = new e(null, null, BlendTokenCore.OUI_Color_Blend_Text_Secondary_Dark, null, null, null, null, null, null, null);
        OUI_Text_Tertiary_Light = new e(null, null, BlendTokenCore.OUI_Color_Blend_Text_Tertiary_Light, null, null, null, null, null, null, null);
        OUI_Text_Tertiary_Dark = new e(null, null, BlendTokenCore.OUI_Color_Blend_Text_Tertiary_Dark, null, null, null, null, null, null, null);
    }

    private MaterialTokenCore() {
    }

    private static ConcurrentHashMap<String, e[]> getTokenSets(Object r2) {
        ConcurrentHashMap<String, e[]> r3 = tokenSets;
        if (r3 == null) goto L5;
    L14:
        return r3;
    L5:
        monitor-enter(MaterialTokenCore.class);
        r3 = tokenSets;     // Catch: Throwable -> L11
        if (r3 != null) goto L9;
        r3 = s.a(MaterialTokenCore.class, e[].class);     // Catch: Throwable -> L11
        tokenSets = r3;     // Catch: Throwable -> L11
    L9:
        monitor-exit(MaterialTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static ConcurrentHashMap<String, e> getTokens(Object r2) {
        ConcurrentHashMap<String, e> r3 = tokens;
        if (r3 == null) goto L5;
    L14:
        return r3;
    L5:
        monitor-enter(MaterialTokenCore.class);
        r3 = tokens;     // Catch: Throwable -> L11
        if (r3 != null) goto L9;
        r3 = s.a(MaterialTokenCore.class, e.class);     // Catch: Throwable -> L11
        tokens = r3;     // Catch: Throwable -> L11
    L9:
        monitor-exit(MaterialTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static e parse(Object r1, String r2, boolean r3) {
        e r0 = (e) s.c(r2, getTokens(r1));
        if (r0 != null) goto L10;
        StringBuilder r4 = new StringBuilder();
        r4.append(r2);
        if (r3 == false) goto L7;
        String r5 = "_light";
    L8:
        r4.append(r5);
        return (e) s.c(r4.toString(), getTokens(r1));
    L7:
        r5 = "_dark";
        goto L8
    L10:
        return r0;
    }

    public static e[] parseSet(Object r2, String r3, boolean r4) {
        e[] r0 = (e[]) s.c(r3, getTokenSets(r2));
        if (r0 != null) goto L9;
        StringBuilder r1 = new StringBuilder();
        r1.append(r3);
        if (r4 == false) goto L7;
        String r5 = "_light";
    L8:
        r1.append(r5);
        r0 = (e[]) s.c(r1.toString(), getTokenSets(r2));
        goto L9
    L7:
        r5 = "_dark";
    L9:
        if (r0 != null) goto L14;
        e r6 = parse(r2, r3, r4);
        if (r6 != null) goto L13;
        return r0;
    L13:
        return new e[]{r6};
    L14:
        return r0;
    }

    public static void register(Object r1, Object r2, boolean r3) {
        s.d(getTokens(r1), r2, e.class, r3);
    }

    public static void registerSet(Object r1, Object r2, boolean r3) {
        s.d(getTokenSets(r1), r2, e[].class, r3);
    }

    public static void registerTokenSets(Object r0, Map<String, e[]> r1, boolean r2) {
        s.e(getTokenSets(r0), r1, r2);
    }

    public static void registerTokens(Object r0, Map<String, e> r1, boolean r2) {
        s.e(getTokens(r0), r1, r2);
    }
}
