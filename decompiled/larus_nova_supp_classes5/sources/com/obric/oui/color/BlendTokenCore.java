package com.obric.oui.color;

import com.obric.oui.graphic.BlendMode;
import com.obric.oui.material.OMaterialHelper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
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
    public static final b OUI_Color_State_Active_Dark = null;
    public static final b OUI_Color_State_Active_Light = null;
    public static final b OUI_Color_State_Press_Dark = null;
    public static final b OUI_Color_State_Press_Light = null;
    private static volatile ConcurrentHashMap<String, Function1<Boolean, b[]>> providers;
    private static volatile ConcurrentHashMap<String, b[]> tokens;

    static {
        BlendMode r3 = BlendMode.COLOR_DODGE;
        BlendMode r6 = BlendMode.SRC_OVER;
        Blend_Base_Thick_Light = new b[]{new b(-1726013665, r3), new b(-604571914, r6)};
        BlendMode r8 = BlendMode.COLOR_BURN;
        Blend_Base_Thick_Dark = new b[]{new b(-3355444, r8), new b(-618388444, r6)};
        Blend_Base_Thick = new d();
        Blend_Base_Regular_Light = new b[]{new b(-14737633, r3), new b(-855638017, r6)};
        Blend_Base_Regular_Dark = new b[]{new b(-3355444, r8), new b(-666746302, r6)};
        Blend_Base_Regular = new f();
        OUI_Color_Blend_Frost_Regular_Light = new b[]{new b(-14737633, r3), new b(-855638017, r6)};
        OUI_Color_Blend_Frost_Regular_Dark = new b[]{new b(-3355444, r8), new b(-868072894, r6)};
        OUI_Color_Blend_Frost_Regular = new r();
        BlendMode r12 = BlendMode.LUMINOSITY;
        b[] r2 = {new b(-1716342094, r12), new b(-13421773, r3), new b(1626074091, r6)};
        OUI_Color_Blend_Fluid_Regular_Light_V2 = r2;
        b[] r11 = {new b(-1718052712, r12), new b(-860572492, r8), new b(335544320, r6)};
        OUI_Color_Blend_Fluid_Regular_Dark_V2 = r11;
        b[] r14 = {new b(869059788, r12), new b(-1724697805, r3), new b(-1929379841, r6)};
        OUI_Color_Blend_Fluid_Regular_Light_V1 = r14;
        b[] r13 = {new b(869059788, r12), new b(-1714631476, r8), new b(-1724697805, r6)};
        OUI_Color_Blend_Fluid_Regular_Dark_V1 = r13;
        if (OMaterialHelper.f() >= 4) goto L6;
        r2 = r14;
    L6:
        OUI_Color_Blend_Fluid_Regular_Light = r2;
        if (OMaterialHelper.f() >= 4) goto L10;
        r11 = r13;
    L10:
        OUI_Color_Blend_Fluid_Regular_Dark = r11;
        OUI_Color_Blend_Fluid_Regular = new s();
        BlendMode r15 = BlendMode.PLUS_LIGHTER;
        OUI_Color_Blend_Frost_UltraThin_Light = new b[]{new b(-14737633, r15)};
        OUI_Color_Blend_Frost_UltraThin_Dark = new b[]{new b(-14737633, r15)};
        OUI_Color_Blend_Frost_UltraThin = new t();
        OUI_Color_Blend_Fluid_UltraThin_Light = new b[]{new b(-15461356, r15)};
        OUI_Color_Blend_Fluid_UltraThin_Dark = new b[]{new b(-15461356, r15)};
        OUI_Color_Blend_Fluid_UltraThin = new u();
        OUI_Color_Blend_Frost_Thin_Light = new b[]{new b(1722329256, r12), new b(-13421773, r3), new b(-1711276033, r6)};
        OUI_Color_Blend_Frost_Thin_Dark = new b[]{new b(-2137417319, r12)};
        OUI_Color_Blend_Frost_Thin = new v();
        OUI_Color_Blend_Fluid_Thin_Light = new b[]{new b(869059788, r12), new b(-1724697805, r3), new b(352321535, r6)};
        OUI_Color_Blend_Fluid_Thin_Dark = new b[]{new b(1721342361, r12)};
        OUI_Color_Blend_Fluid_Thin = new w();
        OUI_Color_Blend_Frost_Thick_Light = new b[]{new b(-1726013665, r3), new b(-604506121, r6)};
        OUI_Color_Blend_Frost_Thick_Dark = new b[]{new b(-3355444, r8), new b(-618059479, r6)};
        OUI_Color_Blend_Fluid_Thick_Light = new b[]{new b(-1726013665, r3), new b(-604506121, r6)};
        OUI_Color_Blend_Fluid_Thick_Dark = new b[]{new b(-858993460, r8), new b(-869717719, r6)};
        OUI_Color_Blend_Fluid_Thick = new x();
        OUI_Color_Fills_Thick_Light = new b[]{new b(251658240, r6)};
        OUI_Color_Fills_Thick_Dark = new b[]{new b(620756991, r6)};
        BlendMode r9 = BlendMode.PLUS_DARKER;
        OUI_Color_Blend_Text_Primary_Light = new b[]{new b(-13421773, r9)};
        OUI_Color_Blend_Text_Primary_Dark = new b[]{new b(-2500135, r15)};
        OUI_Color_Blend_Text_Primary = new y();
        OUI_Color_Blend_Text_Secondary_Light = new b[]{new b(-6710887, r9)};
        OUI_Color_Blend_Text_Secondary_Dark = new b[]{new b(-9211021, r15)};
        OUI_Color_Blend_Text_Secondary = new o();
        OUI_Color_Blend_Text_Tertiary_Light = new b[]{new b(-4342339, r9)};
        OUI_Color_Blend_Text_Tertiary_Dark = new b[]{new b(-10921639, r15)};
        OUI_Color_Blend_Text_Tertiary = new z();
        BlendMode r16 = BlendMode.OVERLAY;
        OUI_Color_Blend_Fill_Tinted_Light = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-1, r9)};
        OUI_Color_Blend_Fill_Tinted_Dark = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-16777216, r9)};
        OUI_Color_Blend_Blue_Thin_Light = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-10049793, r9)};
        OUI_Color_Blend_Blue_Thin_Dark = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-10049793, r9)};
        OUI_Color_Blend_Blue_Thin = new a0();
        OUI_Color_Blend_Blue_Regular_Light = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-14253569, r9)};
        OUI_Color_Blend_Blue_Regular_Dark = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-14253569, r9)};
        OUI_Color_Blend_Blue_Regular = new b0();
        OUI_Color_Blend_Red_Thin_Light = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-30841, r9)};
        OUI_Color_Blend_Red_Thin_Dark = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-30841, r9)};
        OUI_Color_Blend_Red_Thin = new c0();
        OUI_Color_Blend_Red_Regular_Light = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-45747, r9)};
        OUI_Color_Blend_Red_Regular_Dark = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-45747, r9)};
        OUI_Color_Blend_Red_Regular = new d0();
        OUI_Color_Blend_Green_Thin_Light = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-8917601, r9)};
        OUI_Color_Blend_Green_Thin_Dark = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-8917601, r9)};
        OUI_Color_Blend_Green_Thin = new e0();
        OUI_Color_Blend_Green_Regular_Light = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-15415472, r9)};
        OUI_Color_Blend_Green_Regular_Dark = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-15415472, r9)};
        OUI_Color_Blend_Green_Regular = new f0();
        OUI_Color_Blend_Yellow_Thin_Light = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-11671, r9)};
        OUI_Color_Blend_Yellow_Thin_Dark = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-11671, r9)};
        OUI_Color_Blend_Yellow_Thin = new g0();
        OUI_Color_Blend_Yellow_Regular_Light = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-15078, r9)};
        OUI_Color_Blend_Yellow_Regular_Dark = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-15078, r9)};
        OUI_Color_Blend_Yellow_Regular = new e();
        OUI_Color_State_Press_Light = new b(-13421773, r15);
        OUI_Color_State_Press_Dark = new b(-1724697805, r15);
        OUI_Color_State_Active_Light = new b(-6710887, r15);
        OUI_Color_State_Active_Dark = new b(-6710887, r15);
        Blend_Blue_6_Light = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-15042049, r9)};
        Blend_Blue_6_Dark = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-15042049, r9)};
        Blend_Blue_6 = new g();
        Blend_Blue_4_Light = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-10049793, r9)};
        Blend_Blue_4_Dark = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-10049793, r9)};
        Blend_Blue_4 = new h();
        Blend_Yellow_6_Light = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-873984, r9)};
        Blend_Yellow_6_Dark = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-873984, r9)};
        Blend_Yellow_6 = new i();
        Blend_Yellow_4_Light = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-11671, r9)};
        Blend_Yellow_4_Dark = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-11671, r9)};
        Blend_Yellow_4 = new j();
        Blend_Green_6_Light = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-16722873, r9)};
        Blend_Green_6_Dark = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-16722873, r9)};
        Blend_Green_6 = new k();
        Blend_Green_4_Light = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-8917601, r9)};
        Blend_Green_4_Dark = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-8917601, r9)};
        Blend_Green_4 = new l();
        Blend_Red_6_Light = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-53971, r9)};
        Blend_Red_6_Dark = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-53971, r9)};
        Blend_Red_6 = new m();
        Blend_Red_4_Light = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-30841, r9)};
        Blend_Red_4_Dark = new b[]{new b(-2130706433, r6), new b(-3355444, r16), new b(-30841, r9)};
        Blend_Red_4 = new n();
        Blend_Fill_Element_2_Light = new b[]{new b(167772160, r6)};
        Blend_Fill_Element_2_Dark = new b[]{new b(536870911, r6)};
        Blend_Fill_Element_2 = new p();
        Blend_Fluid_Thin_Light = new b[]{new b(-13421773, r3), new b(1088018905, r6)};
        Blend_Fluid_Thin_Dark = new b[]{new b(-13421773, r3), new b(1088018905, r6)};
        Blend_Fluid_Thin = new q();
    }

    public static /* synthetic */ b[] A(Boolean r0) {
        return lambda$static$29(r0);
    }

    public static /* synthetic */ b[] B(Boolean r0) {
        return lambda$static$22(r0);
    }

    public static /* synthetic */ b[] C(Boolean r0) {
        return lambda$static$11(r0);
    }

    public static /* synthetic */ b[] D(Boolean r0) {
        return lambda$static$7(r0);
    }

    public static /* synthetic */ b[] a(Boolean r0) {
        return lambda$static$26(r0);
    }

    public static /* synthetic */ b[] b(Boolean r0) {
        return lambda$static$12(r0);
    }

    public static /* synthetic */ b[] c(Boolean r0) {
        return lambda$static$8(r0);
    }

    public static /* synthetic */ b[] d(Boolean r0) {
        return lambda$static$1(r0);
    }

    public static /* synthetic */ b[] e(Boolean r0) {
        return lambda$static$21(r0);
    }

    public static /* synthetic */ b[] f(Boolean r0) {
        return lambda$static$17(r0);
    }

    public static /* synthetic */ b[] g(Boolean r0) {
        return lambda$static$27(r0);
    }

    public static /* synthetic */ b[] h(Boolean r0) {
        return lambda$static$13(r0);
    }

    public static /* synthetic */ b[] i(Boolean r0) {
        return lambda$static$2(r0);
    }

    public static /* synthetic */ b[] j(Boolean r0) {
        return lambda$static$16(r0);
    }

    public static /* synthetic */ b[] k(Boolean r0) {
        return lambda$static$3(r0);
    }

    public static /* synthetic */ b[] l(Boolean r0) {
        return lambda$static$23(r0);
    }

    public static /* synthetic */ b[] m(Boolean r0) {
        return lambda$static$5(r0);
    }

    public static /* synthetic */ b[] n(Boolean r0) {
        return lambda$static$9(r0);
    }

    public static /* synthetic */ b[] o(Boolean r0) {
        return lambda$static$19(r0);
    }

    public static /* synthetic */ b[] p(Boolean r0) {
        return lambda$static$4(r0);
    }

    public static /* synthetic */ b[] q(Boolean r0) {
        return lambda$static$25(r0);
    }

    public static /* synthetic */ b[] r(Boolean r0) {
        return lambda$static$6(r0);
    }

    public static /* synthetic */ b[] s(Boolean r0) {
        return lambda$static$28(r0);
    }

    public static /* synthetic */ b[] t(Boolean r0) {
        return lambda$static$14(r0);
    }

    public static /* synthetic */ b[] u(Boolean r0) {
        return lambda$static$24(r0);
    }

    public static /* synthetic */ b[] v(Boolean r0) {
        return lambda$static$18(r0);
    }

    public static /* synthetic */ b[] w(Boolean r0) {
        return lambda$static$10(r0);
    }

    public static /* synthetic */ b[] x(Boolean r0) {
        return lambda$static$0(r0);
    }

    public static /* synthetic */ b[] y(Boolean r0) {
        return lambda$static$15(r0);
    }

    public static /* synthetic */ b[] z(Boolean r0) {
        return lambda$static$20(r0);
    }

    private BlendTokenCore() {
    }

    private static ConcurrentHashMap<String, Function1<Boolean, b[]>> getProviders(Object r2) {
        ConcurrentHashMap<String, Function1<Boolean, b[]>> r3 = providers;
        if (r3 == null) goto L5;
    L14:
        return r3;
    L5:
        monitor-enter(BlendTokenCore.class);
        r3 = providers;     // Catch: Throwable -> L11
        if (r3 != null) goto L9;
        r3 = com.obric.oui.material.s.a(BlendTokenCore.class, Function1.class);     // Catch: Throwable -> L11
        providers = r3;     // Catch: Throwable -> L11
    L9:
        monitor-exit(BlendTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static ConcurrentHashMap<String, b[]> getTokens(Object r2) {
        ConcurrentHashMap<String, b[]> r3 = tokens;
        if (r3 == null) goto L5;
    L14:
        return r3;
    L5:
        monitor-enter(BlendTokenCore.class);
        r3 = tokens;     // Catch: Throwable -> L11
        if (r3 != null) goto L9;
        r3 = com.obric.oui.material.s.a(BlendTokenCore.class, b[].class);     // Catch: Throwable -> L11
        tokens = r3;     // Catch: Throwable -> L11
    L9:
        monitor-exit(BlendTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ b[] lambda$static$0(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Base_Thick_Light;
    L6:
        return Blend_Base_Thick_Dark;
    }

    private static /* synthetic */ b[] lambda$static$1(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Base_Regular_Light;
    L6:
        return Blend_Base_Regular_Dark;
    }

    private static /* synthetic */ b[] lambda$static$10(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Text_Secondary_Light;
    L6:
        return OUI_Color_Blend_Text_Secondary_Dark;
    }

    private static /* synthetic */ b[] lambda$static$11(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Text_Tertiary_Light;
    L6:
        return OUI_Color_Blend_Text_Tertiary_Dark;
    }

    private static /* synthetic */ b[] lambda$static$12(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Blue_Thin_Light;
    L6:
        return OUI_Color_Blend_Blue_Thin_Dark;
    }

    private static /* synthetic */ b[] lambda$static$13(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Blue_Regular_Light;
    L6:
        return OUI_Color_Blend_Blue_Regular_Dark;
    }

    private static /* synthetic */ b[] lambda$static$14(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Red_Thin_Light;
    L6:
        return OUI_Color_Blend_Red_Thin_Dark;
    }

    private static /* synthetic */ b[] lambda$static$15(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Red_Regular_Light;
    L6:
        return OUI_Color_Blend_Red_Regular_Dark;
    }

    private static /* synthetic */ b[] lambda$static$16(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Green_Thin_Light;
    L6:
        return OUI_Color_Blend_Green_Thin_Dark;
    }

    private static /* synthetic */ b[] lambda$static$17(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Green_Regular_Light;
    L6:
        return OUI_Color_Blend_Green_Regular_Dark;
    }

    private static /* synthetic */ b[] lambda$static$18(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Yellow_Thin_Light;
    L6:
        return OUI_Color_Blend_Yellow_Thin_Dark;
    }

    private static /* synthetic */ b[] lambda$static$19(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Yellow_Regular_Light;
    L6:
        return OUI_Color_Blend_Yellow_Regular_Dark;
    }

    private static /* synthetic */ b[] lambda$static$2(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Frost_Regular_Light;
    L6:
        return OUI_Color_Blend_Frost_Regular_Dark;
    }

    private static /* synthetic */ b[] lambda$static$20(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Blue_6_Light;
    L6:
        return Blend_Blue_6_Dark;
    }

    private static /* synthetic */ b[] lambda$static$21(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Blue_4_Light;
    L6:
        return Blend_Blue_4_Dark;
    }

    private static /* synthetic */ b[] lambda$static$22(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Yellow_6_Light;
    L6:
        return Blend_Yellow_6_Dark;
    }

    private static /* synthetic */ b[] lambda$static$23(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Yellow_4_Light;
    L6:
        return Blend_Yellow_4_Dark;
    }

    private static /* synthetic */ b[] lambda$static$24(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Green_6_Light;
    L6:
        return Blend_Green_6_Dark;
    }

    private static /* synthetic */ b[] lambda$static$25(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Green_4_Light;
    L6:
        return Blend_Green_4_Dark;
    }

    private static /* synthetic */ b[] lambda$static$26(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Red_6_Light;
    L6:
        return Blend_Red_6_Dark;
    }

    private static /* synthetic */ b[] lambda$static$27(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Red_4_Light;
    L6:
        return Blend_Red_4_Dark;
    }

    private static /* synthetic */ b[] lambda$static$28(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Fill_Element_2_Light;
    L6:
        return Blend_Fill_Element_2_Dark;
    }

    private static /* synthetic */ b[] lambda$static$29(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return Blend_Fluid_Thin_Light;
    L6:
        return Blend_Fluid_Thin_Dark;
    }

    private static /* synthetic */ b[] lambda$static$3(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Fluid_Regular_Light;
    L6:
        return OUI_Color_Blend_Fluid_Regular_Dark;
    }

    private static /* synthetic */ b[] lambda$static$4(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Frost_UltraThin_Light;
    L6:
        return OUI_Color_Blend_Frost_UltraThin_Dark;
    }

    private static /* synthetic */ b[] lambda$static$5(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Fluid_UltraThin_Light;
    L6:
        return OUI_Color_Blend_Fluid_UltraThin_Dark;
    }

    private static /* synthetic */ b[] lambda$static$6(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Frost_Thin_Light;
    L6:
        return OUI_Color_Blend_Frost_Thin_Dark;
    }

    private static /* synthetic */ b[] lambda$static$7(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Fluid_Thin_Light;
    L6:
        return OUI_Color_Blend_Fluid_Thin_Dark;
    }

    private static /* synthetic */ b[] lambda$static$8(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Fluid_Thick_Light;
    L6:
        return OUI_Color_Blend_Fluid_Thick_Dark;
    }

    private static /* synthetic */ b[] lambda$static$9(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Color_Blend_Text_Primary_Light;
    L6:
        return OUI_Color_Blend_Text_Primary_Dark;
    }

    public static Function1<Boolean, b[]> parseProvider(Object r0, String r1) {
        return (Function1) com.obric.oui.material.s.c(r1, getProviders(r0));
    }

    public static b[] parse(Object r1, String r2, boolean r3) {
        b[] r0 = (b[]) com.obric.oui.material.s.c(r2, getTokens(r1));
        if (r0 != null) goto L10;
        StringBuilder r4 = new StringBuilder();
        r4.append(r2);
        if (r3 == false) goto L7;
        String r5 = "_light";
    L8:
        r4.append(r5);
        return (b[]) com.obric.oui.material.s.c(r4.toString(), getTokens(r1));
    L7:
        r5 = "_dark";
        goto L8
    L10:
        return r0;
    }

    public static void register(Object r1, Object r2, boolean r3) {
        com.obric.oui.material.s.d(getTokens(r1), r2, b[].class, r3);
    }

    public static void registerProvider(Object r1, Object r2, boolean r3) {
        com.obric.oui.material.s.d(getProviders(r1), r2, Function1.class, r3);
    }

    public static void registerProviderTokens(Object r0, Map<String, ? extends Function1<Boolean, b[]>> r1, boolean r2) {
        com.obric.oui.material.s.e(getProviders(r0), r1, r2);
    }

    public static void registerTokens(Object r0, Map<String, b[]> r1, boolean r2) {
        com.obric.oui.material.s.e(getTokens(r0), r1, r2);
    }
}
