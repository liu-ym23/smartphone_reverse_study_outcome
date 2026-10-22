package com.obric.oui.material;

import android.content.res.ColorStateList;
import androidx.core.view.ViewCompat;
import com.obric.oui.blur.BlurTokenCore;
import com.obric.oui.color.BlendTokenCore;
import com.obric.oui.color.StrokeTokenCore;
import com.obric.oui.fluid.FluidTokenCore;
import com.obric.oui.shadow.ShadowTokenCore;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
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
    public static final e[] OUI_Bg_Floating_Ring_Dark = null;
    public static final e OUI_Bg_Floating_Ring_Fluid_Dark = null;
    public static final e OUI_Bg_Floating_Ring_Fluid_Light = null;
    public static final e OUI_Bg_Floating_Ring_Frost_Dark = null;
    public static final e OUI_Bg_Floating_Ring_Frost_Light = null;
    public static final e[] OUI_Bg_Floating_Ring_Light = null;
    public static final e[] OUI_Bg_Floating_Tinted_Dark = null;
    public static final e[] OUI_Bg_Floating_Tinted_Light = null;
    public static final e[] OUI_Bg_Modal_Dark = null;
    public static final e OUI_Bg_Modal_Fluid_Dark = null;
    public static final e OUI_Bg_Modal_Fluid_Light = null;
    public static final e OUI_Bg_Modal_Frost_Dark = null;
    public static final e OUI_Bg_Modal_Frost_Light = null;
    public static final e[] OUI_Bg_Modal_Light = null;
    public static final e[] OUI_Bg_Modal_Variant_Dark = null;
    public static final e OUI_Bg_Modal_Variant_Fluid_Dark = null;
    public static final e OUI_Bg_Modal_Variant_Fluid_Light = null;
    public static final e OUI_Bg_Modal_Variant_Frost_Dark = null;
    public static final e OUI_Bg_Modal_Variant_Frost_Light = null;
    public static final e[] OUI_Bg_Modal_Variant_Light = null;

    @Deprecated
    public static final e[] OUI_Bg_Overlay_Search_Dark = null;

    @Deprecated
    public static final e OUI_Bg_Overlay_Search_Fluid_Dark = null;

    @Deprecated
    public static final e OUI_Bg_Overlay_Search_Fluid_Light = null;

    @Deprecated
    public static final e OUI_Bg_Overlay_Search_Frost_Dark = null;

    @Deprecated
    public static final e OUI_Bg_Overlay_Search_Frost_Light = null;

    @Deprecated
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
    public static final e[] OUI_Bg_Scrim_Dark = null;
    public static final e OUI_Bg_Scrim_Fluid_Dark = null;
    public static final e OUI_Bg_Scrim_Fluid_Light = null;
    public static final e OUI_Bg_Scrim_Frost_Dark = null;
    public static final e OUI_Bg_Scrim_Frost_Light = null;
    public static final e[] OUI_Bg_Scrim_Light = null;
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
    public static final String TOKEN_BG_FLOATING_RING = "oui_bg_floating_ring";
    public static final String TOKEN_BG_FLOATING_TINTED = "oui_bg_floating_tinted";
    public static final String TOKEN_BG_MODAL = "oui_bg_modal";
    public static final String TOKEN_BG_MODAL_VARIANT = "oui_bg_modal_variant";
    public static final String TOKEN_BG_POPUP = "oui_bg_popup";
    public static final String TOKEN_BG_POPUP_ON_IMAGE = "oui_bg_popup_onimage";
    public static final String TOKEN_BG_POPUP_OVERLAY = "oui_bg_popup_overlay";
    public static final String TOKEN_BG_SCRIM = "oui_bg_scrim";
    public static final String TOKEN_TEXT_PRIMARY = "oui_text_primary";
    public static final String TOKEN_TEXT_SECONDARY = "oui_text_secondary";
    public static final String TOKEN_TEXT_TERTIARY = "oui_text_tertiary";
    private static volatile ConcurrentHashMap<String, e[]> tokenSets;
    private static volatile ConcurrentHashMap<String, e> tokens;

    static {
        ColorStateList r1 = ColorStateList.valueOf(-1);
        com.obric.oui.b.b r2 = com.obric.oui.b.b.a(BlendTokenCore.OUI_Color_Blend_Frost_Regular_Light, BlendTokenCore.OUI_Color_Blend_Frost_Regular_Light, BlendTokenCore.OUI_Color_State_Press_Light, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a);
        com.obric.oui.color.f r5 = StrokeTokenCore.OUI_Effect_Stroke_Regular_Light;
        Float r24 = Float.valueOf(8.0f);
        e r11 = new e(r1, r2, null, null, r5, null, null, r24, ShadowTokenCore.Oui_Shadow_Regular, null);
        OUI_Bg_Floating_Frost_Light = r11;
        e r0 = new e(ColorStateList.valueOf(-13421773), com.obric.oui.b.b.a(BlendTokenCore.OUI_Color_Blend_Frost_Regular_Dark, BlendTokenCore.OUI_Color_Blend_Frost_Regular_Dark, BlendTokenCore.OUI_Color_State_Press_Dark, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a), null, null, StrokeTokenCore.OUI_Effect_Stroke_Regular_Dark, null, null, r24, ShadowTokenCore.Oui_Shadow_Regular, null);
        OUI_Bg_Floating_Frost_Dark = r0;
        e r3 = new e(ColorStateList.valueOf(-1), com.obric.oui.b.b.a(BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Light, BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Light, BlendTokenCore.OUI_Color_State_Press_Light, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a), null, null, null, null, null, Float.valueOf(BlurTokenCore.Blur_UltraThin), ShadowTokenCore.Oui_Shadow_Regular, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Floating_Fluid_Light = r3;
        e r4 = new e(ColorStateList.valueOf(-13421773), com.obric.oui.b.b.a(BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Dark, BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Dark, BlendTokenCore.OUI_Color_State_Press_Dark, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a), null, null, null, null, null, Float.valueOf(BlurTokenCore.Blur_UltraThin), ShadowTokenCore.Oui_Shadow_Regular, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Fluid_Dark = r4;
        OUI_Bg_Floating_Light = new e[]{r11, r3};
        OUI_Bg_Floating_Dark = new e[]{r0, r4};
        ColorStateList r14 = ColorStateList.valueOf(-1);
        com.obric.oui.color.b[] r16 = BlendTokenCore.OUI_Color_Blend_Frost_Thin_Light;
        com.obric.oui.color.f r18 = StrokeTokenCore.OUI_Effect_Stroke_Thin_Light;
        Float r6 = Float.valueOf(20.0f);
        e r7 = new e(r14, null, r16, null, r18, null, null, r6, ShadowTokenCore.Oui_Shadow_Thick, null);
        OUI_Bg_Floating_OnImage_Frost_Light = r7;
        e r8 = new e(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Frost_Thin_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark, null, null, r6, ShadowTokenCore.Oui_Shadow_Thick, null);
        OUI_Bg_Floating_OnImage_Frost_Dark = r8;
        e r9 = new e(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thin_Light, null, null, null, null, r24, ShadowTokenCore.Oui_Shadow_Thick, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Floating_OnImage_Fluid_Light = r9;
        e r10 = new e(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thin_Dark, null, null, null, null, r24, ShadowTokenCore.Oui_Shadow_Thick, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_OnImage_Fluid_Dark = r10;
        OUI_Bg_Floating_OnImage_Light = new e[]{r7, r9};
        OUI_Bg_Floating_OnImage_Dark = new e[]{r8, r10};
        e r12 = new e(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Fills_Thick_Light, null, null, null, null, r24, null, null);
        OUI_Bg_Floating_Fill_Frost_Light = r12;
        e r13 = new e(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Fills_Thick_Dark, null, null, null, null, r24, null, null);
        OUI_Bg_Floating_Fill_Frost_Dark = r13;
        OUI_Bg_Floating_Fill_Fluid_Light = new e(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Fills_Thick_Light, null, null, null, null, r24, null, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Floating_Fill_Fluid_Dark = new e(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Fills_Thick_Dark, null, null, null, null, r24, null, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Fill_Light = new e[]{r12};
        OUI_Bg_Floating_Fill_Dark = new e[]{r13};
        e r15 = new e(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Frost_Regular_Light, null, StrokeTokenCore.OUI_Effect_Stroke_Regular_Light, null, null, r6, ShadowTokenCore.Oui_Shadow_Thick, null);
        OUI_Bg_Popup_Frost_Light = r15;
        e r17 = new e(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Frost_Regular_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Regular_Dark, null, null, r6, ShadowTokenCore.Oui_Shadow_Thick, null);
        OUI_Bg_Popup_Frost_Dark = r17;
        e r19 = new e(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Light, null, null, null, null, r6, ShadowTokenCore.Oui_Shadow_Thick, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Popup_Fluid_Light = r19;
        e r20 = new e(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Fluid_Regular_Dark, null, null, null, null, r6, ShadowTokenCore.Oui_Shadow_Thick, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Popup_Fluid_Dark = r20;
        OUI_Bg_Popup_Light = new e[]{r15, r19};
        OUI_Bg_Popup_Dark = new e[]{r17, r20};
        ColorStateList r110 = ColorStateList.valueOf(-1);
        com.obric.oui.color.b[] r111 = BlendTokenCore.OUI_Color_Blend_Frost_Thin_Light;
        com.obric.oui.color.f r112 = StrokeTokenCore.OUI_Effect_Stroke_Thin_Light;
        Float r21 = Float.valueOf(32.0f);
        e r22 = new e(r110, null, r111, null, r112, null, null, r21, ShadowTokenCore.Oui_Shadow_UltraThick, null);
        OUI_Bg_Popup_OnImage_Frost_Light = r22;
        e r23 = new e(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Frost_Thin_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark, null, null, r21, ShadowTokenCore.Oui_Shadow_UltraThick, null);
        OUI_Bg_Popup_OnImage_Frost_Dark = r23;
        e r25 = new e(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thin_Light, null, null, null, null, r6, ShadowTokenCore.Oui_Shadow_UltraThick, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Popup_OnImage_Fluid_Light = r25;
        e r26 = new e(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thin_Dark, null, null, null, null, r6, ShadowTokenCore.Oui_Shadow_UltraThick, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Popup_OnImage_Fluid_Dark = r26;
        OUI_Bg_Popup_OnImage_Light = new e[]{r22, r25};
        OUI_Bg_Popup_OnImage_Dark = new e[]{r23, r26};
        e r27 = new e(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Frost_Thick_Light, null, StrokeTokenCore.OUI_Effect_Stroke_Thick_Light, null, null, r21, null, null);
        OUI_Bg_Modal_Frost_Light = r27;
        e r28 = new e(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Frost_Thick_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Thick_Dark, null, null, r21, null, null);
        OUI_Bg_Modal_Frost_Dark = r28;
        e r29 = new e(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thick_Light, null, null, null, null, r21, null, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Modal_Fluid_Light = r29;
        e r30 = new e(ColorStateList.valueOf(-13421773), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thick_Dark, null, null, null, null, r21, null, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Modal_Fluid_Dark = r30;
        OUI_Bg_Modal_Light = new e[]{r27, r29};
        OUI_Bg_Modal_Dark = new e[]{r28, r30};
        e r31 = new e(ColorStateList.valueOf(-986638), null, BlendTokenCore.OUI_Color_Blend_Frost_Thick_Variant_Light, null, StrokeTokenCore.OUI_Effect_Stroke_Thick_Light, null, null, r21, null, null);
        OUI_Bg_Modal_Variant_Frost_Light = r31;
        e r32 = new e(ColorStateList.valueOf(-14079703), null, BlendTokenCore.OUI_Color_Blend_Frost_Thick_Variant_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Thick_Dark, null, null, r21, null, null);
        OUI_Bg_Modal_Variant_Frost_Dark = r32;
        e r33 = new e(ColorStateList.valueOf(-986638), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thick_Variant_Light, null, null, null, null, r21, null, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Modal_Variant_Fluid_Light = r33;
        e r34 = new e(ColorStateList.valueOf(-14079703), null, BlendTokenCore.OUI_Color_Blend_Fluid_Thick_Variant_Dark, null, null, null, null, r21, null, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Modal_Variant_Fluid_Dark = r34;
        OUI_Bg_Modal_Variant_Light = new e[]{r31, r33};
        OUI_Bg_Modal_Variant_Dark = new e[]{r32, r34};
        e r35 = new e(null, com.obric.oui.b.b.a(BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Light, BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Light, BlendTokenCore.OUI_Color_State_Press_Light, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a), null, null, StrokeTokenCore.OUI_Effect_Stroke_Thin_Light, null, null, Float.valueOf(BlurTokenCore.Blur_UltraThin), null, null);
        OUI_Bg_Floating_Overlay_Frost_Light = r35;
        e r36 = new e(null, com.obric.oui.b.b.a(BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a), null, null, StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark, null, null, Float.valueOf(BlurTokenCore.Blur_UltraThin), null, null);
        OUI_Bg_Floating_Overlay_Frost_Dark = r36;
        e r37 = new e(null, com.obric.oui.b.b.a(BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Light, BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Light, BlendTokenCore.OUI_Color_State_Press_Light, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a), null, null, null, null, null, Float.valueOf(BlurTokenCore.Blur_UltraThin), null, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Floating_Overlay_Fluid_Light = r37;
        e r38 = new e(null, com.obric.oui.b.b.a(BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a), null, null, null, null, null, Float.valueOf(BlurTokenCore.Blur_UltraThin), null, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Overlay_Fluid_Dark = r38;
        e[] r39 = {r35, r37};
        OUI_Bg_Floating_Overlay_Light = r39;
        e[] r40 = {r36, r38};
        OUI_Bg_Floating_Overlay_Dark = r40;
        ColorStateList r113 = ColorStateList.valueOf(Integer.MIN_VALUE);
        com.obric.oui.color.b[] r114 = BlendTokenCore.OUI_Color_Scrim_Regular;
        Float r310 = Float.valueOf(64.0f);
        e r115 = new e(r113, null, r114, null, null, null, null, r310, null, null);
        OUI_Bg_Scrim_Frost_Light = r115;
        e r116 = new e(ColorStateList.valueOf(Integer.MIN_VALUE), null, BlendTokenCore.OUI_Color_Scrim_Regular, null, null, null, null, r310, null, null);
        OUI_Bg_Scrim_Frost_Dark = r116;
        e r117 = new e(ColorStateList.valueOf(Integer.MIN_VALUE), null, BlendTokenCore.OUI_Color_Scrim_Regular, null, null, null, null, r310, null, null);
        OUI_Bg_Scrim_Fluid_Light = r117;
        e r118 = new e(ColorStateList.valueOf(Integer.MIN_VALUE), null, BlendTokenCore.OUI_Color_Scrim_Regular, null, null, null, null, r310, null, null);
        OUI_Bg_Scrim_Fluid_Dark = r118;
        OUI_Bg_Scrim_Light = new e[]{r115, r117};
        OUI_Bg_Scrim_Dark = new e[]{r116, r118};
        e r119 = new e(ColorStateList.valueOf(620756991), com.obric.oui.b.b.a(BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a), null, null, StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark, null, null, Float.valueOf(BlurTokenCore.Blur_UltraThin), null, null);
        OUI_Bg_Floating_Ring_Frost_Light = r119;
        e r210 = new e(ColorStateList.valueOf(620756991), com.obric.oui.b.b.a(BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a), null, null, StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark, null, null, Float.valueOf(BlurTokenCore.Blur_UltraThin), null, null);
        OUI_Bg_Floating_Ring_Frost_Dark = r210;
        e r120 = new e(ColorStateList.valueOf(620756991), com.obric.oui.b.b.a(BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a), null, null, null, null, null, Float.valueOf(BlurTokenCore.Blur_UltraThin), null, FluidTokenCore.OUI_Effect_Fluid_Ring_Light);
        OUI_Bg_Floating_Ring_Fluid_Light = r120;
        e r121 = new e(ColorStateList.valueOf(620756991), com.obric.oui.b.b.a(BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a, com.obric.oui.color.b.f13470a), null, null, null, null, null, Float.valueOf(BlurTokenCore.Blur_UltraThin), null, FluidTokenCore.OUI_Effect_Fluid_Ring_Dark);
        OUI_Bg_Floating_Ring_Fluid_Dark = r121;
        OUI_Bg_Floating_Ring_Light = new e[]{r119, r120};
        OUI_Bg_Floating_Ring_Dark = new e[]{r210, r121};
        OUI_Bg_Overlay_Search_Frost_Light = r35;
        OUI_Bg_Overlay_Search_Frost_Dark = r36;
        OUI_Bg_Overlay_Search_Fluid_Light = r37;
        OUI_Bg_Overlay_Search_Fluid_Dark = r38;
        OUI_Bg_Overlay_Search_Light = r39;
        OUI_Bg_Overlay_Search_Dark = r40;
        e r41 = new e(null, com.obric.oui.b.b.a(BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark), null, null, StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark, null, null, r6, ShadowTokenCore.Oui_Shadow_Thick, null);
        OUI_Bg_Popup_Overlay_Frost_Light = r41;
        e r42 = new e(null, com.obric.oui.b.b.a(BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Frost_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark), null, null, StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark, null, null, r6, ShadowTokenCore.Oui_Shadow_Thick, null);
        OUI_Bg_Popup_Overlay_Frost_Dark = r42;
        e r43 = new e(null, com.obric.oui.b.b.a(BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark), null, null, null, null, null, r6, ShadowTokenCore.Oui_Shadow_Thick, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Popup_Overlay_Fluid_Light = r43;
        e r44 = new e(null, com.obric.oui.b.b.a(BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_Blend_Fluid_UltraThin_Dark, BlendTokenCore.OUI_Color_State_Press_Dark), null, null, null, null, null, r6, ShadowTokenCore.Oui_Shadow_Thick, FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Bg_Popup_Overlay_Fluid_Dark = r44;
        OUI_Bg_Popup_Overlay_Light = new e[]{r41, r43};
        OUI_Bg_Popup_Overlay_Dark = new e[]{r42, r44};
        e r45 = new e(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Fill_Tinted_Light, null, StrokeTokenCore.OUI_Effect_Stroke_Tinted_Light, null, null, r24, ShadowTokenCore.Oui_Shadow_Regular, null);
        OUI_Bg_Floating_Frost_Tinted_Light = r45;
        e r46 = new e(ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK), null, BlendTokenCore.OUI_Color_Blend_Fill_Tinted_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Tinted_Dark, null, null, r24, ShadowTokenCore.Oui_Shadow_Regular, null);
        OUI_Bg_Floating_Frost_Tinted_Dark = r46;
        e r47 = new e(ColorStateList.valueOf(-1), null, BlendTokenCore.OUI_Color_Blend_Fill_Tinted_Light, null, null, null, null, Float.valueOf(BlurTokenCore.Blur_UltraThin), ShadowTokenCore.Oui_Shadow_Regular, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Fluid_Tinted_Light = r47;
        e r48 = new e(ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK), null, BlendTokenCore.OUI_Color_Blend_Fill_Tinted_Dark, null, null, null, null, Float.valueOf(BlurTokenCore.Blur_UltraThin), ShadowTokenCore.Oui_Shadow_Regular, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Fluid_Tinted_Dark = r48;
        OUI_Bg_Floating_Tinted_Light = new e[]{r45, r47};
        OUI_Bg_Floating_Tinted_Dark = new e[]{r46, r48};
        e r49 = new e(ColorStateList.valueOf(-15895809), null, BlendTokenCore.OUI_Color_Blend_Blue_Regular_Light, null, StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular_Light, null, null, r24, ShadowTokenCore.Oui_Shadow_Regular, null);
        OUI_Bg_Floating_Frost_Blue_Light = r49;
        e r50 = new e(ColorStateList.valueOf(-16087553), null, BlendTokenCore.OUI_Color_Blend_Blue_Regular_Dark, null, StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular_Dark, null, null, r24, ShadowTokenCore.Oui_Shadow_Regular, null);
        OUI_Bg_Floating_Frost_Blue_Dark = r50;
        e r51 = new e(ColorStateList.valueOf(-15895809), null, BlendTokenCore.OUI_Color_Blend_Blue_Regular_Light, null, null, null, null, Float.valueOf(BlurTokenCore.Blur_UltraThin), ShadowTokenCore.Oui_Shadow_Regular, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Fluid_Blue_Light = r51;
        e r52 = new e(ColorStateList.valueOf(-16087553), null, BlendTokenCore.OUI_Color_Blend_Blue_Regular_Dark, null, null, null, null, Float.valueOf(BlurTokenCore.Blur_UltraThin), ShadowTokenCore.Oui_Shadow_Regular, FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
        OUI_Bg_Floating_Fluid_Blue_Dark = r52;
        OUI_Bg_Floating_Blue_Light = new e[]{r49, r51};
        OUI_Bg_Floating_Blue_Dark = new e[]{r50, r52};
        OUI_Text_Primary_Light = new e(null, null, BlendTokenCore.OUI_Color_Blend_Text_Primary_Light, null, null, null, null, null, null, null);
        OUI_Text_Primary_Dark = new e(null, null, BlendTokenCore.OUI_Color_Blend_Text_Primary_Dark, null, null, null, null, null, null, null);
        OUI_Text_Secondary_Light = new e(null, null, BlendTokenCore.OUI_Color_Blend_Text_Secondary_Light, null, null, null, null, null, null, null);
        OUI_Text_Secondary_Dark = new e(null, null, BlendTokenCore.OUI_Color_Blend_Text_Secondary_Dark, null, null, null, null, null, null, null);
        OUI_Text_Tertiary_Light = new e(null, null, BlendTokenCore.OUI_Color_Blend_Text_Tertiary_Light, null, null, null, null, null, null, null);
        OUI_Text_Tertiary_Dark = new e(null, null, BlendTokenCore.OUI_Color_Blend_Text_Tertiary_Dark, null, null, null, null, null, null, null);
    }

    private MaterialTokenCore() {
    }

    private static ConcurrentHashMap<String, e[]> getTokenSets(Object r1) {
        ConcurrentHashMap<String, e[]> r0 = tokenSets;
        if (r0 != null) goto L13;
        monitor-enter(MaterialTokenCore.class);
        r0 = tokenSets;     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        r0 = o.a(MaterialTokenCore.class, e[].class);     // Catch: Throwable -> L10
        tokenSets = r0;     // Catch: Throwable -> L10
    L8:
        monitor-exit(MaterialTokenCore.class);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L13:
        return r0;
    }

    private static ConcurrentHashMap<String, e> getTokens(Object r1) {
        ConcurrentHashMap<String, e> r0 = tokens;
        if (r0 != null) goto L13;
        monitor-enter(MaterialTokenCore.class);
        r0 = tokens;     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        r0 = o.a(MaterialTokenCore.class, e.class);     // Catch: Throwable -> L10
        tokens = r0;     // Catch: Throwable -> L10
    L8:
        monitor-exit(MaterialTokenCore.class);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L13:
        return r0;
    }

    public static e parse(Object r3, String r4, boolean r5) {
        e r0 = (e) ZeusTransformUtils.preCheckCast(o.a(r4, getTokens(r3)), e.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        StringBuilder r6 = new StringBuilder().append(r4);
        if (r5 == false) goto L7;
        String r7 = "_light";
    L9:
        return (e) ZeusTransformUtils.preCheckCast(o.a(r6.append(r7).toString(), getTokens(r3)), e.class, "com.obric.memorydata.plugin");
    L7:
        r7 = "_dark";
        goto L9
    L10:
        return r0;
    }

    public static e[] parseSet(Object r3, String r4, boolean r5) {
        e[] r0 = (e[]) ZeusTransformUtils.preCheckCast(o.a(r4, getTokenSets(r3)), e[].class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L9;
        StringBuilder r1 = new StringBuilder().append(r4);
        if (r5 == false) goto L7;
        String r2 = "_light";
    L8:
        r0 = (e[]) ZeusTransformUtils.preCheckCast(o.a(r1.append(r2).toString(), getTokenSets(r3)), e[].class, "com.obric.memorydata.plugin");
        goto L9
    L7:
        r2 = "_dark";
    L9:
        if (r0 != null) goto L14;
        e r6 = parse(r3, r4, r5);
        if (r6 != null) goto L13;
        return r0;
    L13:
        return new e[]{r6};
    L14:
        return r0;
    }

    public static void register(Object r1, Object r2, boolean r3) {
        o.a(getTokens(r1), r2, e.class, r3);
    }

    public static void registerSet(Object r1, Object r2, boolean r3) {
        o.a(getTokenSets(r1), r2, e[].class, r3);
    }

    public static void registerTokenSets(Object r2, Map<String, e[]> r3, boolean r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        o.a(getTokenSets(r2), r5, r4);
    }

    public static void registerTokens(Object r2, Map<String, e> r3, boolean r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        o.a(getTokens(r2), r5, r4);
    }
}
