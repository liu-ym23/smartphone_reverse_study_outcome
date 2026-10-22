package com.obric.oui.color;

import androidx.core.view.ViewCompat;
import com.obric.oui.graphic.BlendMode;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class BlendTokenCore {
    public static final Function1<Boolean, b[]> Blend_Base_Regular = null;
    public static final b[] Blend_Base_Regular_Dark = null;
    public static final b[] Blend_Base_Regular_Light = null;
    public static final Function1<Boolean, b[]> Blend_Base_Thick = null;
    public static final b[] Blend_Base_Thick_Dark = null;
    public static final b[] Blend_Base_Thick_Light = null;
    public static final Function1<Boolean, b[]> Blend_Blue_4 = null;
    public static final b[] Blend_Blue_4_Dark = null;
    public static final b[] Blend_Blue_4_Light = null;
    public static final Function1<Boolean, b[]> Blend_Blue_6 = null;
    public static final b[] Blend_Blue_6_Dark = null;
    public static final b[] Blend_Blue_6_Light = null;
    public static final Function1<Boolean, b[]> Blend_Fill_Element_2 = null;
    public static final b[] Blend_Fill_Element_2_Dark = null;
    public static final b[] Blend_Fill_Element_2_Light = null;
    public static final Function1<Boolean, b[]> Blend_Fluid_Thin = null;
    public static final b[] Blend_Fluid_Thin_Dark = null;
    public static final b[] Blend_Fluid_Thin_Light = null;
    public static final Function1<Boolean, b[]> Blend_Green_4 = null;
    public static final b[] Blend_Green_4_Dark = null;
    public static final b[] Blend_Green_4_Light = null;
    public static final Function1<Boolean, b[]> Blend_Green_6 = null;
    public static final b[] Blend_Green_6_Dark = null;
    public static final b[] Blend_Green_6_Light = null;
    public static final Function1<Boolean, b[]> Blend_Red_4 = null;
    public static final b[] Blend_Red_4_Dark = null;
    public static final b[] Blend_Red_4_Light = null;
    public static final Function1<Boolean, b[]> Blend_Red_6 = null;
    public static final b[] Blend_Red_6_Dark = null;
    public static final b[] Blend_Red_6_Light = null;
    public static final Function1<Boolean, b[]> Blend_Yellow_4 = null;
    public static final b[] Blend_Yellow_4_Dark = null;
    public static final b[] Blend_Yellow_4_Light = null;
    public static final Function1<Boolean, b[]> Blend_Yellow_6 = null;
    public static final b[] Blend_Yellow_6_Dark = null;
    public static final b[] Blend_Yellow_6_Light = null;
    public static final Function1<Boolean, b[]> OUI_Color_Blend_Blue_Regular = null;
    public static final b[] OUI_Color_Blend_Blue_Regular_Dark = null;
    public static final b[] OUI_Color_Blend_Blue_Regular_Light = null;
    public static final Function1<Boolean, b[]> OUI_Color_Blend_Blue_Thin = null;
    public static final b[] OUI_Color_Blend_Blue_Thin_Dark = null;
    public static final b[] OUI_Color_Blend_Blue_Thin_Light = null;
    public static final b[] OUI_Color_Blend_Fill_Tinted_Dark = null;
    public static final b[] OUI_Color_Blend_Fill_Tinted_Light = null;
    public static final Function1<Boolean, b[]> OUI_Color_Blend_Fluid_Regular = null;
    public static final b[] OUI_Color_Blend_Fluid_Regular_Dark = null;
    static final b[] OUI_Color_Blend_Fluid_Regular_Dark_V1 = null;
    static final b[] OUI_Color_Blend_Fluid_Regular_Dark_V2 = null;
    public static final b[] OUI_Color_Blend_Fluid_Regular_Light = null;
    static final b[] OUI_Color_Blend_Fluid_Regular_Light_V1 = null;
    static final b[] OUI_Color_Blend_Fluid_Regular_Light_V2 = null;
    public static final Function1<Boolean, b[]> OUI_Color_Blend_Fluid_Thick = null;
    public static final b[] OUI_Color_Blend_Fluid_Thick_Dark = null;
    public static final b[] OUI_Color_Blend_Fluid_Thick_Light = null;
    public static final Function1<Boolean, b[]> OUI_Color_Blend_Fluid_Thick_Variant = null;
    public static final b[] OUI_Color_Blend_Fluid_Thick_Variant_Dark = null;
    public static final b[] OUI_Color_Blend_Fluid_Thick_Variant_Light = null;
    public static final Function1<Boolean, b[]> OUI_Color_Blend_Fluid_Thin = null;
    public static final b[] OUI_Color_Blend_Fluid_Thin_Dark = null;
    public static final b[] OUI_Color_Blend_Fluid_Thin_Light = null;
    public static final Function1<Boolean, b[]> OUI_Color_Blend_Fluid_UltraThin = null;
    public static final b[] OUI_Color_Blend_Fluid_UltraThin_Dark = null;
    public static final b[] OUI_Color_Blend_Fluid_UltraThin_Light = null;
    public static final Function1<Boolean, b[]> OUI_Color_Blend_Frost_Regular = null;
    public static final b[] OUI_Color_Blend_Frost_Regular_Dark = null;
    public static final b[] OUI_Color_Blend_Frost_Regular_Light = null;
    public static final b[] OUI_Color_Blend_Frost_Thick_Dark = null;
    public static final b[] OUI_Color_Blend_Frost_Thick_Light = null;
    public static final b[] OUI_Color_Blend_Frost_Thick_Variant_Dark = null;
    public static final b[] OUI_Color_Blend_Frost_Thick_Variant_Light = null;
    public static final Function1<Boolean, b[]> OUI_Color_Blend_Frost_Thin = null;
    public static final b[] OUI_Color_Blend_Frost_Thin_Dark = null;
    public static final b[] OUI_Color_Blend_Frost_Thin_Light = null;
    public static final Function1<Boolean, b[]> OUI_Color_Blend_Frost_UltraThin = null;
    public static final b[] OUI_Color_Blend_Frost_UltraThin_Dark = null;
    public static final b[] OUI_Color_Blend_Frost_UltraThin_Light = null;
    public static final Function1<Boolean, b[]> OUI_Color_Blend_Green_Regular = null;
    public static final b[] OUI_Color_Blend_Green_Regular_Dark = null;
    public static final b[] OUI_Color_Blend_Green_Regular_Light = null;
    public static final Function1<Boolean, b[]> OUI_Color_Blend_Green_Thin = null;
    public static final b[] OUI_Color_Blend_Green_Thin_Dark = null;
    public static final b[] OUI_Color_Blend_Green_Thin_Light = null;
    public static final Function1<Boolean, b[]> OUI_Color_Blend_Red_Regular = null;
    public static final b[] OUI_Color_Blend_Red_Regular_Dark = null;
    public static final b[] OUI_Color_Blend_Red_Regular_Light = null;
    public static final Function1<Boolean, b[]> OUI_Color_Blend_Red_Thin = null;
    public static final b[] OUI_Color_Blend_Red_Thin_Dark = null;
    public static final b[] OUI_Color_Blend_Red_Thin_Light = null;
    public static final Function1<Boolean, b[]> OUI_Color_Blend_Text_Primary = null;
    public static final b[] OUI_Color_Blend_Text_Primary_Dark = null;
    public static final b[] OUI_Color_Blend_Text_Primary_Light = null;
    public static final Function1<Boolean, b[]> OUI_Color_Blend_Text_Secondary = null;
    public static final b[] OUI_Color_Blend_Text_Secondary_Dark = null;
    public static final b[] OUI_Color_Blend_Text_Secondary_Light = null;
    public static final Function1<Boolean, b[]> OUI_Color_Blend_Text_Tertiary = null;
    public static final b[] OUI_Color_Blend_Text_Tertiary_Dark = null;
    public static final b[] OUI_Color_Blend_Text_Tertiary_Light = null;
    public static final Function1<Boolean, b[]> OUI_Color_Blend_Yellow_Regular = null;
    public static final b[] OUI_Color_Blend_Yellow_Regular_Dark = null;
    public static final b[] OUI_Color_Blend_Yellow_Regular_Light = null;
    public static final Function1<Boolean, b[]> OUI_Color_Blend_Yellow_Thin = null;
    public static final b[] OUI_Color_Blend_Yellow_Thin_Dark = null;
    public static final b[] OUI_Color_Blend_Yellow_Thin_Light = null;
    public static final b[] OUI_Color_Fills_Thick_Dark = null;
    public static final b[] OUI_Color_Fills_Thick_Light = null;
    public static final b[] OUI_Color_Scrim_Regular = null;
    public static final b OUI_Color_State_Active_Dark = null;
    public static final b OUI_Color_State_Active_Light = null;
    public static final b OUI_Color_State_Press_Dark = null;
    public static final b OUI_Color_State_Press_Light = null;
    private static volatile ConcurrentHashMap<String, Function1<Boolean, b[]>> providers;
    private static volatile ConcurrentHashMap<String, b[]> tokens;

    static {
        Blend_Base_Thick_Light = new b[]{new b(-1726013665, BlendMode.COLOR_DODGE), new b(-604571914, BlendMode.SRC_OVER)};
        Blend_Base_Thick_Dark = new b[]{new b(-3355444, BlendMode.COLOR_BURN), new b(-618388444, BlendMode.SRC_OVER)};
        Blend_Base_Thick = $$Lambda$BlendTokenCore$2g0K154p0ylEzkvKRM3xhHEL2bk.INSTANCE;
        Blend_Base_Regular_Light = new b[]{new b(-14737633, BlendMode.COLOR_DODGE), new b(-855638017, BlendMode.SRC_OVER)};
        Blend_Base_Regular_Dark = new b[]{new b(-3355444, BlendMode.COLOR_BURN), new b(-666746302, BlendMode.SRC_OVER)};
        Blend_Base_Regular = $$Lambda$BlendTokenCore$ILxuYyZqt20vUGmWos58CusFdc.INSTANCE;
        OUI_Color_Blend_Frost_Regular_Light = new b[]{new b(-14737633, BlendMode.COLOR_DODGE), new b(-855638017, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Regular_Dark = new b[]{new b(-3355444, BlendMode.COLOR_BURN), new b(-868072894, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Regular = $$Lambda$BlendTokenCore$NQPOh6Lxa76jd3kvQQiJaD5CBK4.INSTANCE;
        b[] r2 = {new b(-1716342094, BlendMode.LUMINOSITY), new b(-13421773, BlendMode.COLOR_DODGE), new b(1626074091, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Regular_Light_V2 = r2;
        b[] r6 = {new b(-1718052712, BlendMode.LUMINOSITY), new b(-860572492, BlendMode.COLOR_BURN), new b(335544320, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Regular_Dark_V2 = r6;
        b[] r9 = {new b(869059788, BlendMode.LUMINOSITY), new b(-1724697805, BlendMode.COLOR_DODGE), new b(-1929379841, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Regular_Light_V1 = r9;
        b[] r11 = {new b(869059788, BlendMode.LUMINOSITY), new b(-1714631476, BlendMode.COLOR_BURN), new b(-1724697805, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Regular_Dark_V1 = r11;
        if (OMaterialHelper.b() >= 4) goto L6;
        r2 = r9;
    L6:
        OUI_Color_Blend_Fluid_Regular_Light = r2;
        if (OMaterialHelper.b() >= 4) goto L10;
        r6 = r11;
    L10:
        OUI_Color_Blend_Fluid_Regular_Dark = r6;
        OUI_Color_Blend_Fluid_Regular = $$Lambda$BlendTokenCore$ii1fmbau7uCGSHIwt8B02D29zJs.INSTANCE;
        OUI_Color_Blend_Frost_UltraThin_Light = new b[]{new b(-14737633, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Frost_UltraThin_Dark = new b[]{new b(-14737633, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Frost_UltraThin = $$Lambda$BlendTokenCore$XjrVpkus_32Ev0alOCdA6gxXwYw.INSTANCE;
        OUI_Color_Blend_Fluid_UltraThin_Light = new b[]{new b(-15461356, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Fluid_UltraThin_Dark = new b[]{new b(-15461356, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Fluid_UltraThin = $$Lambda$BlendTokenCore$CsLzjs_5w3q9aaNRJ62XD90nPc.INSTANCE;
        OUI_Color_Blend_Frost_Thin_Light = new b[]{new b(1722329256, BlendMode.LUMINOSITY), new b(-13421773, BlendMode.COLOR_DODGE), new b(-1711276033, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Thin_Dark = new b[]{new b(-2137417319, BlendMode.LUMINOSITY)};
        OUI_Color_Blend_Frost_Thin = $$Lambda$BlendTokenCore$I4dtI1O1YizZnMVdMh9eTIW6AI.INSTANCE;
        OUI_Color_Blend_Fluid_Thin_Light = new b[]{new b(869059788, BlendMode.LUMINOSITY), new b(-1724697805, BlendMode.COLOR_DODGE), new b(352321535, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thin_Dark = new b[]{new b(1721342361, BlendMode.LUMINOSITY)};
        OUI_Color_Blend_Fluid_Thin = $$Lambda$BlendTokenCore$USyMAQojQh8p2DhVPD80Azxl9U.INSTANCE;
        OUI_Color_Blend_Frost_Thick_Light = new b[]{new b(-1726013665, BlendMode.COLOR_DODGE), new b(-604506121, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Thick_Dark = new b[]{new b(-3355444, BlendMode.COLOR_BURN), new b(-618059479, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thick_Light = new b[]{new b(-1726013665, BlendMode.COLOR_DODGE), new b(-604506121, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thick_Dark = new b[]{new b(-858993460, BlendMode.COLOR_BURN), new b(-869717719, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thick = $$Lambda$BlendTokenCore$4fkSY6FGrKewFZtIG2xvCH8arvU.INSTANCE;
        OUI_Color_Blend_Frost_Thick_Variant_Light = new b[]{new b(-1726013665, BlendMode.COLOR_DODGE), new b(-604834571, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Thick_Variant_Dark = new b[]{new b(-1714631476, BlendMode.COLOR_BURN), new b(-869717719, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thick_Variant_Light = new b[]{new b(-1726013665, BlendMode.COLOR_DODGE), new b(-604834571, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thick_Variant_Dark = new b[]{new b(-1714631476, BlendMode.COLOR_BURN), new b(-869717719, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thick_Variant = $$Lambda$BlendTokenCore$7uxs_twgBSZtoMHeTTKFuHR3ctM.INSTANCE;
        OUI_Color_Fills_Thick_Light = new b[]{new b(251658240, BlendMode.SRC_OVER)};
        OUI_Color_Fills_Thick_Dark = new b[]{new b(620756991, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Text_Primary_Light = new b[]{new b(-13421773, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Text_Primary_Dark = new b[]{new b(-2500135, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Text_Primary = $$Lambda$BlendTokenCore$y3raRDi9x7E22hk1IXm95YE1JU.INSTANCE;
        OUI_Color_Blend_Text_Secondary_Light = new b[]{new b(-6710887, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Text_Secondary_Dark = new b[]{new b(-9211021, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Text_Secondary = $$Lambda$BlendTokenCore$qcjDndOXJ3BTfgqOU4Ju7eYoj4g.INSTANCE;
        OUI_Color_Blend_Text_Tertiary_Light = new b[]{new b(-4342339, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Text_Tertiary_Dark = new b[]{new b(-10921639, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Text_Tertiary = $$Lambda$BlendTokenCore$wt8XFDSZMPfanEqjzbtWxY7VpdI.INSTANCE;
        OUI_Color_Blend_Fill_Tinted_Light = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-1, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Fill_Tinted_Dark = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(ViewCompat.MEASURED_STATE_MASK, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Thin_Light = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-10049793, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Thin_Dark = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-10049793, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Thin = $$Lambda$BlendTokenCore$RQOKa5UYEAqBqENSVCok7XFUZk.INSTANCE;
        OUI_Color_Blend_Blue_Regular_Light = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-14253569, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Regular_Dark = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-14253569, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Regular = $$Lambda$BlendTokenCore$5t_mpSXwOshCKLy51Bn3BXyP70.INSTANCE;
        OUI_Color_Blend_Red_Thin_Light = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-30841, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Red_Thin_Dark = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-30841, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Red_Thin = $$Lambda$BlendTokenCore$ntP8wpv1hRIxCtbta4T15aJPIRI.INSTANCE;
        OUI_Color_Blend_Red_Regular_Light = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-45747, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Red_Regular_Dark = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-45747, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Red_Regular = $$Lambda$BlendTokenCore$pOs4htVOMEij0NVtGIiOG4cPSqM.INSTANCE;
        OUI_Color_Blend_Green_Thin_Light = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-8917601, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Green_Thin_Dark = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-8917601, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Green_Thin = $$Lambda$BlendTokenCore$uPaYCHqHDDAXa8sY5zl0o7g31SI.INSTANCE;
        OUI_Color_Blend_Green_Regular_Light = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-15415472, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Green_Regular_Dark = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-15415472, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Green_Regular = $$Lambda$BlendTokenCore$dab3jqW3QSJA4p0SiLF7vrJ7CI.INSTANCE;
        OUI_Color_Blend_Yellow_Thin_Light = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-11671, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Yellow_Thin_Dark = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-11671, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Yellow_Thin = $$Lambda$BlendTokenCore$8lECzavc6mIiCelKFlDdnBeXrk.INSTANCE;
        OUI_Color_Blend_Yellow_Regular_Light = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-15078, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Yellow_Regular_Dark = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-15078, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Yellow_Regular = $$Lambda$BlendTokenCore$cweQuEODGnfCIYIfopgaSMLzks.INSTANCE;
        OUI_Color_State_Press_Light = new b(-13421773, BlendMode.PLUS_LIGHTER);
        OUI_Color_State_Press_Dark = new b(-1724697805, BlendMode.PLUS_LIGHTER);
        OUI_Color_State_Active_Light = new b(-6710887, BlendMode.PLUS_LIGHTER);
        OUI_Color_State_Active_Dark = new b(-6710887, BlendMode.PLUS_LIGHTER);
        OUI_Color_Scrim_Regular = new b[]{new b(Integer.MIN_VALUE, BlendMode.SRC_OVER)};
        Blend_Blue_6_Light = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-15042049, BlendMode.PLUS_DARKER)};
        Blend_Blue_6_Dark = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-15042049, BlendMode.PLUS_DARKER)};
        Blend_Blue_6 = $$Lambda$BlendTokenCore$oKoYsXqgotVJJRkg8c3uaFZkPmc.INSTANCE;
        Blend_Blue_4_Light = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-10049793, BlendMode.PLUS_DARKER)};
        Blend_Blue_4_Dark = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-10049793, BlendMode.PLUS_DARKER)};
        Blend_Blue_4 = $$Lambda$BlendTokenCore$LWwFCIzVpuvjBNLxbR3yW6TEW0.INSTANCE;
        Blend_Yellow_6_Light = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-873984, BlendMode.PLUS_DARKER)};
        Blend_Yellow_6_Dark = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-873984, BlendMode.PLUS_DARKER)};
        Blend_Yellow_6 = $$Lambda$BlendTokenCore$qMcmj37P6J0_Dc3hkPCGsnXqE4.INSTANCE;
        Blend_Yellow_4_Light = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-11671, BlendMode.PLUS_DARKER)};
        Blend_Yellow_4_Dark = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-11671, BlendMode.PLUS_DARKER)};
        Blend_Yellow_4 = $$Lambda$BlendTokenCore$StkrakFFhK8SfsyHvxw_0AKRBBE.INSTANCE;
        Blend_Green_6_Light = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-16722873, BlendMode.PLUS_DARKER)};
        Blend_Green_6_Dark = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-16722873, BlendMode.PLUS_DARKER)};
        Blend_Green_6 = $$Lambda$BlendTokenCore$1crSBJGBldcRodpJVoJWiJUuCy8.INSTANCE;
        Blend_Green_4_Light = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-8917601, BlendMode.PLUS_DARKER)};
        Blend_Green_4_Dark = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-8917601, BlendMode.PLUS_DARKER)};
        Blend_Green_4 = $$Lambda$BlendTokenCore$6ieoNdCqUxTqHoxSznQmT7XYDQ.INSTANCE;
        Blend_Red_6_Light = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-53971, BlendMode.PLUS_DARKER)};
        Blend_Red_6_Dark = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-53971, BlendMode.PLUS_DARKER)};
        Blend_Red_6 = $$Lambda$BlendTokenCore$WOaOzcMiVDxnw7EgLUDgt1gKK4.INSTANCE;
        Blend_Red_4_Light = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-30841, BlendMode.PLUS_DARKER)};
        Blend_Red_4_Dark = new b[]{new b(-2130706433, BlendMode.SRC_OVER), new b(-3355444, BlendMode.OVERLAY), new b(-30841, BlendMode.PLUS_DARKER)};
        Blend_Red_4 = $$Lambda$BlendTokenCore$t1iN7h96lW6LO1ovheSlN2Q1X7s.INSTANCE;
        Blend_Fill_Element_2_Light = new b[]{new b(167772160, BlendMode.SRC_OVER)};
        Blend_Fill_Element_2_Dark = new b[]{new b(536870911, BlendMode.SRC_OVER)};
        Blend_Fill_Element_2 = $$Lambda$BlendTokenCore$7yHvKe6ObPl_2TZ1VdI82iUDtg.INSTANCE;
        Blend_Fluid_Thin_Light = new b[]{new b(-13421773, BlendMode.COLOR_DODGE), new b(1088018905, BlendMode.SRC_OVER)};
        Blend_Fluid_Thin_Dark = new b[]{new b(-13421773, BlendMode.COLOR_DODGE), new b(1088018905, BlendMode.SRC_OVER)};
        Blend_Fluid_Thin = $$Lambda$BlendTokenCore$HvMTzZ67KciZXT9foCUhTbJWQKM.INSTANCE;
    }

    private BlendTokenCore() {
    }

    private static ConcurrentHashMap<String, Function1<Boolean, b[]>> getProviders(Object r1) {
        ConcurrentHashMap<String, Function1<Boolean, b[]>> r0 = providers;
        if (r0 != null) goto L13;
        monitor-enter(BlendTokenCore.class);
        r0 = providers;     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        r0 = o.a(BlendTokenCore.class, Function1.class);     // Catch: Throwable -> L10
        providers = r0;     // Catch: Throwable -> L10
    L8:
        monitor-exit(BlendTokenCore.class);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L13:
        return r0;
    }

    private static ConcurrentHashMap<String, b[]> getTokens(Object r1) {
        ConcurrentHashMap<String, b[]> r0 = tokens;
        if (r0 != null) goto L13;
        monitor-enter(BlendTokenCore.class);
        r0 = tokens;     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        r0 = o.a(BlendTokenCore.class, b[].class);     // Catch: Throwable -> L10
        tokens = r0;     // Catch: Throwable -> L10
    L8:
        monitor-exit(BlendTokenCore.class);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L13:
        return r0;
    }

    static /* synthetic */ b[] lambda$static$0(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Base_Thick_Light;
    L6:
        return Blend_Base_Thick_Dark;
    }

    static /* synthetic */ b[] lambda$static$1(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Base_Regular_Light;
    L6:
        return Blend_Base_Regular_Dark;
    }

    static /* synthetic */ b[] lambda$static$10(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Text_Primary_Light;
    L6:
        return OUI_Color_Blend_Text_Primary_Dark;
    }

    static /* synthetic */ b[] lambda$static$11(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Text_Secondary_Light;
    L6:
        return OUI_Color_Blend_Text_Secondary_Dark;
    }

    static /* synthetic */ b[] lambda$static$12(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Text_Tertiary_Light;
    L6:
        return OUI_Color_Blend_Text_Tertiary_Dark;
    }

    static /* synthetic */ b[] lambda$static$13(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Blue_Thin_Light;
    L6:
        return OUI_Color_Blend_Blue_Thin_Dark;
    }

    static /* synthetic */ b[] lambda$static$14(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Blue_Regular_Light;
    L6:
        return OUI_Color_Blend_Blue_Regular_Dark;
    }

    static /* synthetic */ b[] lambda$static$15(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Red_Thin_Light;
    L6:
        return OUI_Color_Blend_Red_Thin_Dark;
    }

    static /* synthetic */ b[] lambda$static$16(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Red_Regular_Light;
    L6:
        return OUI_Color_Blend_Red_Regular_Dark;
    }

    static /* synthetic */ b[] lambda$static$17(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Green_Thin_Light;
    L6:
        return OUI_Color_Blend_Green_Thin_Dark;
    }

    static /* synthetic */ b[] lambda$static$18(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Green_Regular_Light;
    L6:
        return OUI_Color_Blend_Green_Regular_Dark;
    }

    static /* synthetic */ b[] lambda$static$19(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Yellow_Thin_Light;
    L6:
        return OUI_Color_Blend_Yellow_Thin_Dark;
    }

    static /* synthetic */ b[] lambda$static$2(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Frost_Regular_Light;
    L6:
        return OUI_Color_Blend_Frost_Regular_Dark;
    }

    static /* synthetic */ b[] lambda$static$20(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Yellow_Regular_Light;
    L6:
        return OUI_Color_Blend_Yellow_Regular_Dark;
    }

    static /* synthetic */ b[] lambda$static$21(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Blue_6_Light;
    L6:
        return Blend_Blue_6_Dark;
    }

    static /* synthetic */ b[] lambda$static$22(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Blue_4_Light;
    L6:
        return Blend_Blue_4_Dark;
    }

    static /* synthetic */ b[] lambda$static$23(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Yellow_6_Light;
    L6:
        return Blend_Yellow_6_Dark;
    }

    static /* synthetic */ b[] lambda$static$24(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Yellow_4_Light;
    L6:
        return Blend_Yellow_4_Dark;
    }

    static /* synthetic */ b[] lambda$static$25(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Green_6_Light;
    L6:
        return Blend_Green_6_Dark;
    }

    static /* synthetic */ b[] lambda$static$26(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Green_4_Light;
    L6:
        return Blend_Green_4_Dark;
    }

    static /* synthetic */ b[] lambda$static$27(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Red_6_Light;
    L6:
        return Blend_Red_6_Dark;
    }

    static /* synthetic */ b[] lambda$static$28(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Red_4_Light;
    L6:
        return Blend_Red_4_Dark;
    }

    static /* synthetic */ b[] lambda$static$29(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Fill_Element_2_Light;
    L6:
        return Blend_Fill_Element_2_Dark;
    }

    static /* synthetic */ b[] lambda$static$3(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Fluid_Regular_Light;
    L6:
        return OUI_Color_Blend_Fluid_Regular_Dark;
    }

    static /* synthetic */ b[] lambda$static$30(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Fluid_Thin_Light;
    L6:
        return Blend_Fluid_Thin_Dark;
    }

    static /* synthetic */ b[] lambda$static$4(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Frost_UltraThin_Light;
    L6:
        return OUI_Color_Blend_Frost_UltraThin_Dark;
    }

    static /* synthetic */ b[] lambda$static$5(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Fluid_UltraThin_Light;
    L6:
        return OUI_Color_Blend_Fluid_UltraThin_Dark;
    }

    static /* synthetic */ b[] lambda$static$6(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Frost_Thin_Light;
    L6:
        return OUI_Color_Blend_Frost_Thin_Dark;
    }

    static /* synthetic */ b[] lambda$static$7(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Fluid_Thin_Light;
    L6:
        return OUI_Color_Blend_Fluid_Thin_Dark;
    }

    static /* synthetic */ b[] lambda$static$8(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Fluid_Thick_Light;
    L6:
        return OUI_Color_Blend_Fluid_Thick_Dark;
    }

    static /* synthetic */ b[] lambda$static$9(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Fluid_Thick_Variant_Light;
    L6:
        return OUI_Color_Blend_Fluid_Thick_Variant_Dark;
    }

    public static b[] parse(Object r3, String r4, boolean r5) {
        b[] r0 = (b[]) ZeusTransformUtils.preCheckCast(o.a(r4, getTokens(r3)), b[].class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        StringBuilder r6 = new StringBuilder().append(r4);
        if (r5 == false) goto L7;
        String r7 = "_light";
    L9:
        return (b[]) ZeusTransformUtils.preCheckCast(o.a(r6.append(r7).toString(), getTokens(r3)), b[].class, "com.obric.memorydata.plugin");
    L7:
        r7 = "_dark";
        goto L9
    L10:
        return r0;
    }

    public static Function1<Boolean, b[]> parseProvider(Object r1, String r2) {
        return (Function1) ZeusTransformUtils.preCheckCast(o.a(r2, getProviders(r1)), Function1.class, "com.obric.memorydata.plugin");
    }

    public static void register(Object r1, Object r2, boolean r3) {
        o.a(getTokens(r1), r2, b[].class, r3);
    }

    public static void registerProvider(Object r1, Object r2, boolean r3) {
        o.a(getProviders(r1), r2, Function1.class, r3);
    }

    public static void registerProviderTokens(Object r2, Map<String, ? extends Function1<Boolean, b[]>> r3, boolean r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        o.a(getProviders(r2), r5, r4);
    }

    public static void registerTokens(Object r2, Map<String, b[]> r3, boolean r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        o.a(getTokens(r2), r5, r4);
    }
}
