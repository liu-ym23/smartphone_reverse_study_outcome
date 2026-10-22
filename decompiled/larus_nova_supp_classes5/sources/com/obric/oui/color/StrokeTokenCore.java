package com.obric.oui.color;

import com.obric.oui.graphic.BlendMode;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class StrokeTokenCore {
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Blue_Regular = null;
    public static final j0 OUI_Effect_Stroke_Blue_Regular_Dark = null;
    public static final j0 OUI_Effect_Stroke_Blue_Regular_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Blue_Thin = null;
    public static final j0 OUI_Effect_Stroke_Blue_Thin_Dark = null;
    public static final j0 OUI_Effect_Stroke_Blue_Thin_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Green_Regular = null;
    public static final j0 OUI_Effect_Stroke_Green_Regular_Dark = null;
    public static final j0 OUI_Effect_Stroke_Green_Regular_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Green_Thin = null;
    public static final j0 OUI_Effect_Stroke_Green_Thin_Dark = null;
    public static final j0 OUI_Effect_Stroke_Green_Thin_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Red_Regular = null;
    public static final j0 OUI_Effect_Stroke_Red_Regular_Dark = null;
    public static final j0 OUI_Effect_Stroke_Red_Regular_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Red_Thin = null;
    public static final j0 OUI_Effect_Stroke_Red_Thin_Dark = null;
    public static final j0 OUI_Effect_Stroke_Red_Thin_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Regular = null;
    public static final j0 OUI_Effect_Stroke_Regular_Dark = null;
    public static final j0 OUI_Effect_Stroke_Regular_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Thick = null;
    public static final j0 OUI_Effect_Stroke_Thick_Dark = null;
    public static final j0 OUI_Effect_Stroke_Thick_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Thin = null;
    public static final j0 OUI_Effect_Stroke_Thin_Dark = null;
    public static final j0 OUI_Effect_Stroke_Thin_Light = null;
    public static final j0 OUI_Effect_Stroke_Tinted_Dark = null;
    public static final j0 OUI_Effect_Stroke_Tinted_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_UltraThin = null;
    public static final j0 OUI_Effect_Stroke_UltraThin_Dark = null;
    public static final j0 OUI_Effect_Stroke_UltraThin_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Yellow_Regular = null;
    public static final j0 OUI_Effect_Stroke_Yellow_Regular_Dark = null;
    public static final j0 OUI_Effect_Stroke_Yellow_Regular_Light = null;
    public static final Function1<Boolean, j0> OUI_Effect_Stroke_Yellow_Thin = null;
    public static final j0 OUI_Effect_Stroke_Yellow_Thin_Dark = null;
    public static final j0 OUI_Effect_Stroke_Yellow_Thin_Light = null;
    private static volatile ConcurrentHashMap<String, Function1<Boolean, j0>> providers;
    private static volatile ConcurrentHashMap<String, j0> tokens;

    public static /* synthetic */ j0 a(Boolean r0) {
        return lambda$static$5(r0);
    }

    public static /* synthetic */ j0 b(Boolean r0) {
        return lambda$static$4(r0);
    }

    public static /* synthetic */ j0 c(Boolean r0) {
        return lambda$static$8(r0);
    }

    public static /* synthetic */ j0 d(Boolean r0) {
        return lambda$static$7(r0);
    }

    public static /* synthetic */ j0 e(Boolean r0) {
        return lambda$static$0(r0);
    }

    public static /* synthetic */ j0 f(Boolean r0) {
        return lambda$static$6(r0);
    }

    public static /* synthetic */ j0 g(Boolean r0) {
        return lambda$static$1(r0);
    }

    public static /* synthetic */ j0 h(Boolean r0) {
        return lambda$static$3(r0);
    }

    public static /* synthetic */ j0 i(Boolean r0) {
        return lambda$static$11(r0);
    }

    public static /* synthetic */ j0 j(Function1 r0, Boolean r1) {
        return lambda$toCoreProviders$12(r0, r1);
    }

    public static /* synthetic */ j0 k(Boolean r0) {
        return lambda$static$10(r0);
    }

    public static /* synthetic */ j0 l(Boolean r0) {
        return lambda$static$9(r0);
    }

    public static /* synthetic */ j0 m(Boolean r0) {
        return lambda$static$2(r0);
    }

    static {
        BlendMode r1 = BlendMode.SRC_OVER;
        OUI_Effect_Stroke_Regular_Light = new j0(1.0f, 1728053247, r1);
        OUI_Effect_Stroke_Regular_Dark = new j0(1.0f, 1715618370, r1);
        OUI_Effect_Stroke_Regular = new q0();
        OUI_Effect_Stroke_UltraThin_Light = new j0(1.0f, 452984831, r1);
        OUI_Effect_Stroke_UltraThin_Dark = new j0(1.0f, 452984831, r1);
        OUI_Effect_Stroke_UltraThin = new t0();
        OUI_Effect_Stroke_Thin_Light = new j0(1.0f, 1728053247, r1);
        OUI_Effect_Stroke_Thin_Dark = new j0(1.0f, 134217728, r1);
        OUI_Effect_Stroke_Thin = new u0();
        OUI_Effect_Stroke_Thick_Light = new j0(1.0f, 1727526903, r1);
        OUI_Effect_Stroke_Thick_Dark = new j0(1.0f, 1294872110, r1);
        OUI_Effect_Stroke_Thick = new v0();
        OUI_Effect_Stroke_Tinted_Light = new j0(1.0f, 1728053247, r1);
        OUI_Effect_Stroke_Tinted_Dark = new j0(1.0f, 1728053247, r1);
        OUI_Effect_Stroke_Blue_Regular_Light = new j0(1.0f, 1713799679, r1);
        OUI_Effect_Stroke_Blue_Regular_Dark = new j0(1.0f, 1713799679, r1);
        OUI_Effect_Stroke_Blue_Regular = new w0();
        OUI_Effect_Stroke_Blue_Thin_Light = new j0(1.0f, 1718003455, r1);
        OUI_Effect_Stroke_Blue_Thin_Dark = new j0(1.0f, 1718003455, r1);
        OUI_Effect_Stroke_Blue_Thin = new x0();
        OUI_Effect_Stroke_Red_Regular_Light = new j0(1.0f, 1728007501, r1);
        OUI_Effect_Stroke_Red_Regular_Dark = new j0(1.0f, 1728007501, r1);
        OUI_Effect_Stroke_Red_Regular = new y0();
        OUI_Effect_Stroke_Red_Thin_Light = new j0(1.0f, 1728022407, r1);
        OUI_Effect_Stroke_Red_Thin_Dark = new j0(1.0f, 1728022407, r1);
        OUI_Effect_Stroke_Red_Thin = new n0();
        OUI_Effect_Stroke_Green_Regular_Light = new j0(1.0f, 1712637776, r1);
        OUI_Effect_Stroke_Green_Regular_Dark = new j0(1.0f, 1712637776, r1);
        OUI_Effect_Stroke_Green_Regular = new o0();
        OUI_Effect_Stroke_Green_Thin_Light = new j0(1.0f, 1719135647, r1);
        OUI_Effect_Stroke_Green_Thin_Dark = new j0(1.0f, 1719135647, r1);
        OUI_Effect_Stroke_Green_Thin = new p0();
        OUI_Effect_Stroke_Yellow_Regular_Light = new j0(1.0f, 1728038170, r1);
        OUI_Effect_Stroke_Yellow_Regular_Dark = new j0(1.0f, 1728038170, r1);
        OUI_Effect_Stroke_Yellow_Regular = new r0();
        OUI_Effect_Stroke_Yellow_Thin_Light = new j0(1.0f, 1728041577, r1);
        OUI_Effect_Stroke_Yellow_Thin_Dark = new j0(1.0f, 1728041577, r1);
        OUI_Effect_Stroke_Yellow_Thin = new s0();
    }

    private StrokeTokenCore() {
    }

    private static ConcurrentHashMap<String, Function1<Boolean, j0>> getProviders(Object r2) {
        ConcurrentHashMap<String, Function1<Boolean, j0>> r3 = providers;
        if (r3 == null) goto L5;
    L14:
        return r3;
    L5:
        monitor-enter(StrokeTokenCore.class);
        r3 = providers;     // Catch: Throwable -> L11
        if (r3 != null) goto L9;
        r3 = com.obric.oui.material.s.a(StrokeTokenCore.class, Function1.class);     // Catch: Throwable -> L11
        providers = r3;     // Catch: Throwable -> L11
    L9:
        monitor-exit(StrokeTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static ConcurrentHashMap<String, j0> getTokens(Object r2) {
        ConcurrentHashMap<String, j0> r3 = tokens;
        if (r3 == null) goto L5;
    L14:
        return r3;
    L5:
        monitor-enter(StrokeTokenCore.class);
        r3 = tokens;     // Catch: Throwable -> L11
        if (r3 != null) goto L9;
        r3 = com.obric.oui.material.s.a(StrokeTokenCore.class, j0.class);     // Catch: Throwable -> L11
        tokens = r3;     // Catch: Throwable -> L11
    L9:
        monitor-exit(StrokeTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ j0 lambda$static$0(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Regular_Dark;
    }

    private static /* synthetic */ j0 lambda$static$1(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_UltraThin_Light;
    L6:
        return OUI_Effect_Stroke_UltraThin_Dark;
    }

    private static /* synthetic */ j0 lambda$static$10(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Yellow_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Yellow_Regular_Dark;
    }

    private static /* synthetic */ j0 lambda$static$11(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Yellow_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Yellow_Thin_Dark;
    }

    private static /* synthetic */ j0 lambda$static$2(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Thin_Dark;
    }

    private static /* synthetic */ j0 lambda$static$3(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Thick_Light;
    L6:
        return OUI_Effect_Stroke_Thick_Dark;
    }

    private static /* synthetic */ j0 lambda$static$4(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Blue_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Blue_Regular_Dark;
    }

    private static /* synthetic */ j0 lambda$static$5(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Blue_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Blue_Thin_Dark;
    }

    private static /* synthetic */ j0 lambda$static$6(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Red_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Red_Regular_Dark;
    }

    private static /* synthetic */ j0 lambda$static$7(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Red_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Red_Thin_Dark;
    }

    private static /* synthetic */ j0 lambda$static$8(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Green_Regular_Light;
    L6:
        return OUI_Effect_Stroke_Green_Regular_Dark;
    }

    private static /* synthetic */ j0 lambda$static$9(Boolean r1) {
        if (Boolean.TRUE.equals(r1) == false) goto L6;
        return OUI_Effect_Stroke_Green_Thin_Light;
    L6:
        return OUI_Effect_Stroke_Green_Thin_Dark;
    }

    private static j0 toCore(j0 r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        return new j0(r3.a, r3.b, r3.c);
    }

    private static ConcurrentHashMap<String, Function1<Boolean, j0>> toCoreProviders(Map<String, ? extends Function1<Boolean, j0>> r4) {
        ConcurrentHashMap<String, Function1<Boolean, j0>> r0 = new ConcurrentHashMap();
        if (r4 != null) goto L5;
    L11:
        return r0;
    L5:
        if (r4.isEmpty() == true) goto L11;
        Iterator<Map.Entry<String, ? extends Function1<Boolean, j0>>> r5 = r4.entrySet().iterator();
    L9:
        if (r5.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Function1<Boolean, j0>> r1 = r5.next();
        Function1<Boolean, j0> r2 = r1.getValue();
        r0.put(r1.getKey(), new m0(r2));
        goto L9
    }

    private static ConcurrentHashMap<String, j0> toCoreTokens(Map<String, j0> r3) {
        ConcurrentHashMap<String, j0> r0 = new ConcurrentHashMap();
        if (r3 != null) goto L5;
    L11:
        return r0;
    L5:
        if (r3.isEmpty() == true) goto L11;
        Iterator<Map.Entry<String, j0>> r4 = r3.entrySet().iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        Map.Entry<String, j0> r1 = r4.next();
        r0.put(r1.getKey(), toCore(r1.getValue()));
        goto L9
    }

    private static /* synthetic */ j0 lambda$toCoreProviders$12(Function1 r0, Boolean r1) {
        return toCore((j0) r0.invoke(r1));
    }

    public static Function1<Boolean, j0> parseProvider(Object r0, String r1) {
        return (Function1) com.obric.oui.material.s.c(r1, getProviders(r0));
    }

    public static j0 parse(Object r1, String r2, boolean r3) {
        j0 r0 = (j0) com.obric.oui.material.s.c(r2, getTokens(r1));
        if (r0 != null) goto L10;
        StringBuilder r4 = new StringBuilder();
        r4.append(r2);
        if (r3 == false) goto L7;
        String r5 = "_light";
    L8:
        r4.append(r5);
        return (j0) com.obric.oui.material.s.c(r4.toString(), getTokens(r1));
    L7:
        r5 = "_dark";
        goto L8
    L10:
        return r0;
    }

    public static void register(Object r2, Object r3, boolean r4) {
        com.obric.oui.material.s.d(getTokens(r2), r3, j0.class, r4);
        com.obric.oui.material.s.e(getTokens(r2), toCoreTokens(com.obric.oui.material.s.b(r3, j0.class)), r4);
    }

    public static void registerProvider(Object r1, Object r2, boolean r3) {
        com.obric.oui.material.s.d(getProviders(r1), r2, Function1.class, r3);
    }

    public static void registerProviderTokens(Object r0, Map<String, ? extends Function1<Boolean, j0>> r1, boolean r2) {
        com.obric.oui.material.s.e(getProviders(r0), toCoreProviders(r1), r2);
    }

    public static void registerTokens(Object r0, Map<String, j0> r1, boolean r2) {
        com.obric.oui.material.s.e(getTokens(r0), toCoreTokens(r1), r2);
    }
}
