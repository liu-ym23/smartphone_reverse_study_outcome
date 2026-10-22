package com.obric.oui.fluid;

import com.obric.oui.graphic.BlendMode;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.s;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class FluidTokenCore {
    public static final b OUI_Effect_Fluid_Regular_Dark = null;
    static final b OUI_Effect_Fluid_Regular_Dark_V1 = null;
    static final b OUI_Effect_Fluid_Regular_Dark_V2 = null;
    public static final b OUI_Effect_Fluid_Regular_Light = null;
    static final b OUI_Effect_Fluid_Regular_Light_V1 = null;
    static final b OUI_Effect_Fluid_Regular_Light_V2 = null;
    public static final b OUI_Effect_Fluid_Thin_Dark = null;
    static final b OUI_Effect_Fluid_Thin_Dark_V1 = null;
    static final b OUI_Effect_Fluid_Thin_Dark_V2 = null;
    public static final b OUI_Effect_Fluid_Thin_Light = null;
    static final b OUI_Effect_Fluid_Thin_Light_V1 = null;
    static final b OUI_Effect_Fluid_Thin_Light_V2 = null;
    private static volatile ConcurrentHashMap<String, b> tokens;

    static {
        BlendMode r19 = BlendMode.COLOR_DODGE;
        BlendMode r13 = BlendMode.PLUS_LIGHTER;
        b r0 = new b(new float[]{40.0f, -120.0f, 1.5f, 3.0f, 6.0f, 1.0f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), r19.getPorterDuffMode(), Float.intBitsToFloat(452984831), r13.getPorterDuffMode(), 0.0f});
        OUI_Effect_Fluid_Regular_Light_V2 = r0;
        b r2 = new b(new float[]{40.0f, -120.0f, 1.5f, 3.0f, 6.0f, 0.8f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), r19.getPorterDuffMode(), Float.intBitsToFloat(872415231), r13.getPorterDuffMode(), 0.0f});
        OUI_Effect_Fluid_Regular_Dark_V2 = r2;
        b r11 = new b(new float[]{40.0f, -120.0f, 1.5f, 3.0f, 6.0f, 0.7f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), r19.getPorterDuffMode(), Float.intBitsToFloat(452984831), r13.getPorterDuffMode(), 0.0f});
        OUI_Effect_Fluid_Thin_Light_V2 = r11;
        b r12 = new b(new float[]{40.0f, -120.0f, 1.5f, 3.0f, 6.0f, 0.4f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), r19.getPorterDuffMode(), Float.intBitsToFloat(872415231), r13.getPorterDuffMode(), 0.0f});
        OUI_Effect_Fluid_Thin_Dark_V2 = r12;
        b r1 = new b(new float[]{12.0f, -200.0f, 0.8f, 3.0f, 5.0f, 0.6f, 0.0f});
        OUI_Effect_Fluid_Regular_Light_V1 = r1;
        b r4 = new b(new float[]{12.0f, -200.0f, 0.8f, 3.0f, 5.0f, 0.16f, 0.0f});
        OUI_Effect_Fluid_Regular_Dark_V1 = r4;
        b r5 = new b(new float[]{12.0f, -200.0f, 0.8f, 3.0f, 5.0f, 0.3f, 0.0f});
        OUI_Effect_Fluid_Thin_Light_V1 = r5;
        b r6 = new b(new float[]{12.0f, -200.0f, 0.8f, 3.0f, 5.0f, 0.1f, 0.0f});
        OUI_Effect_Fluid_Thin_Dark_V1 = r6;
        if (OMaterialHelper.f() >= 4) goto L6;
        r0 = r1;
    L6:
        OUI_Effect_Fluid_Regular_Light = r0;
        if (OMaterialHelper.f() >= 4) goto L10;
        r2 = r4;
    L10:
        OUI_Effect_Fluid_Regular_Dark = r2;
        if (OMaterialHelper.f() >= 4) goto L14;
        r11 = r5;
    L14:
        OUI_Effect_Fluid_Thin_Light = r11;
        if (OMaterialHelper.f() >= 4) goto L18;
        r12 = r6;
    L18:
        OUI_Effect_Fluid_Thin_Dark = r12;
    }

    private FluidTokenCore() {
    }

    private static ConcurrentHashMap<String, b> getTokens(Object r2) {
        ConcurrentHashMap<String, b> r3 = tokens;
        if (r3 == null) goto L5;
    L14:
        return r3;
    L5:
        monitor-enter(FluidTokenCore.class);
        r3 = tokens;     // Catch: Throwable -> L11
        if (r3 != null) goto L9;
        r3 = s.a(FluidTokenCore.class, b.class);     // Catch: Throwable -> L11
        tokens = r3;     // Catch: Throwable -> L11
    L9:
        monitor-exit(FluidTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static b parse(Object r0, String r1) {
        return (b) s.c(r1, getTokens(r0));
    }

    public static void register(Object r1, Object r2, boolean r3) {
        s.d(getTokens(r1), r2, b.class, r3);
    }

    public static void registerTokens(Object r0, Map<String, b> r1, boolean r2) {
        s.e(getTokens(r0), r1, r2);
    }
}
