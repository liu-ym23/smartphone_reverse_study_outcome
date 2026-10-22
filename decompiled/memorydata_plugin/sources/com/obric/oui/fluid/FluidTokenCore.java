package com.obric.oui.fluid;

import com.obric.oui.graphic.BlendMode;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class FluidTokenCore {
    public static final b OUI_Effect_Fluid_Regular_Dark = null;
    static final b OUI_Effect_Fluid_Regular_Dark_V1 = null;
    static final b OUI_Effect_Fluid_Regular_Dark_V2 = null;
    public static final b OUI_Effect_Fluid_Regular_Light = null;
    static final b OUI_Effect_Fluid_Regular_Light_V1 = null;
    static final b OUI_Effect_Fluid_Regular_Light_V2 = null;
    public static final b OUI_Effect_Fluid_Ring_Dark = null;
    public static final b OUI_Effect_Fluid_Ring_Light = null;
    public static final b OUI_Effect_Fluid_Thin_Dark = null;
    static final b OUI_Effect_Fluid_Thin_Dark_V1 = null;
    static final b OUI_Effect_Fluid_Thin_Dark_V2 = null;
    public static final b OUI_Effect_Fluid_Thin_Light = null;
    static final b OUI_Effect_Fluid_Thin_Light_V1 = null;
    static final b OUI_Effect_Fluid_Thin_Light_V2 = null;
    private static volatile ConcurrentHashMap<String, b> tokens;

    static {
        b r0 = new b(new float[]{40.0f, -120.0f, 1.5f, 3.0f, 6.0f, 1.0f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), BlendMode.COLOR_DODGE.getPorterDuffMode(), Float.intBitsToFloat(452984831), BlendMode.PLUS_LIGHTER.getPorterDuffMode(), 0.0f});
        OUI_Effect_Fluid_Regular_Light_V2 = r0;
        b r2 = new b(new float[]{40.0f, -120.0f, 1.5f, 3.0f, 6.0f, 0.8f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), BlendMode.COLOR_DODGE.getPorterDuffMode(), Float.intBitsToFloat(872415231), BlendMode.PLUS_LIGHTER.getPorterDuffMode(), 0.0f});
        OUI_Effect_Fluid_Regular_Dark_V2 = r2;
        b r13 = new b(new float[]{40.0f, -120.0f, 1.5f, 3.0f, 6.0f, 0.7f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), BlendMode.COLOR_DODGE.getPorterDuffMode(), Float.intBitsToFloat(452984831), BlendMode.PLUS_LIGHTER.getPorterDuffMode(), 0.0f});
        OUI_Effect_Fluid_Thin_Light_V2 = r13;
        b r11 = new b(new float[]{40.0f, -120.0f, 1.5f, 3.0f, 6.0f, 0.4f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), BlendMode.COLOR_DODGE.getPorterDuffMode(), Float.intBitsToFloat(872415231), BlendMode.PLUS_LIGHTER.getPorterDuffMode(), 0.0f});
        OUI_Effect_Fluid_Thin_Dark_V2 = r11;
        b r10 = new b(new float[]{12.0f, -200.0f, 0.8f, 3.0f, 5.0f, 0.6f, 0.0f});
        OUI_Effect_Fluid_Regular_Light_V1 = r10;
        b r15 = new b(new float[]{12.0f, -200.0f, 0.8f, 3.0f, 5.0f, 0.16f, 0.0f});
        OUI_Effect_Fluid_Regular_Dark_V1 = r15;
        b r12 = new b(new float[]{12.0f, -200.0f, 0.8f, 3.0f, 5.0f, 0.3f, 0.0f});
        OUI_Effect_Fluid_Thin_Light_V1 = r12;
        b r9 = new b(new float[]{12.0f, -200.0f, 0.8f, 3.0f, 5.0f, 0.1f, 0.0f});
        OUI_Effect_Fluid_Thin_Dark_V1 = r9;
        if (OMaterialHelper.b() >= 4) goto L6;
        r0 = r10;
    L6:
        OUI_Effect_Fluid_Regular_Light = r0;
        if (OMaterialHelper.b() >= 4) goto L10;
        r2 = r15;
    L10:
        OUI_Effect_Fluid_Regular_Dark = r2;
        if (OMaterialHelper.b() >= 4) goto L14;
        r13 = r12;
    L14:
        OUI_Effect_Fluid_Thin_Light = r13;
        if (OMaterialHelper.b() >= 4) goto L18;
        r11 = r9;
    L18:
        OUI_Effect_Fluid_Thin_Dark = r11;
        OUI_Effect_Fluid_Ring_Light = new b(new float[]{40.0f, -120.0f, 1.5f, 5.0f, 6.0f, 0.7f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), BlendMode.COLOR_DODGE.getPorterDuffMode(), Float.intBitsToFloat(1728053247), BlendMode.PLUS_LIGHTER.getPorterDuffMode(), 0.5f});
        OUI_Effect_Fluid_Ring_Dark = new b(new float[]{40.0f, -120.0f, 1.5f, 5.0f, 6.0f, 0.7f, 0.0f, 2.0f, Float.intBitsToFloat(-8355712), BlendMode.COLOR_DODGE.getPorterDuffMode(), Float.intBitsToFloat(1728053247), BlendMode.PLUS_LIGHTER.getPorterDuffMode(), 0.5f});
    }

    private FluidTokenCore() {
    }

    private static ConcurrentHashMap<String, b> getTokens(Object r1) {
        ConcurrentHashMap<String, b> r0 = tokens;
        if (r0 != null) goto L13;
        monitor-enter(FluidTokenCore.class);
        r0 = tokens;     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        r0 = o.a(FluidTokenCore.class, b.class);     // Catch: Throwable -> L10
        tokens = r0;     // Catch: Throwable -> L10
    L8:
        monitor-exit(FluidTokenCore.class);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L13:
        return r0;
    }

    public static b parse(Object r1, String r2) {
        return (b) ZeusTransformUtils.preCheckCast(o.a(r2, getTokens(r1)), b.class, "com.obric.memorydata.plugin");
    }

    public static void register(Object r1, Object r2, boolean r3) {
        o.a(getTokens(r1), r2, b.class, r3);
    }

    public static void registerTokens(Object r2, Map<String, b> r3, boolean r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        o.a(getTokens(r2), r5, r4);
    }
}
