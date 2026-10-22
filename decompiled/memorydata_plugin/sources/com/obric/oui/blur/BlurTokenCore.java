package com.obric.oui.blur;

import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class BlurTokenCore {

    @Deprecated
    public static final float Blur_Background_Regular = 20.0f;

    @Deprecated
    public static final float Blur_Background_Thick = 64.0f;

    @Deprecated
    public static final float Blur_Progress_Regular = 20.0f;

    @Deprecated
    public static final float Blur_Progress_Thin = 8.0f;
    public static final float Blur_Regular = 20.0f;
    public static final float Blur_Thick = 32.0f;
    public static final float Blur_Thin = 8.0f;
    public static final float Blur_UltraThick = 64.0f;
    public static final float Blur_UltraThin = 0.0f;
    static final float Blur_UltraThin_V1 = 4.0f;
    static final float Blur_UltraThin_V2 = 2.0f;
    public static final float Blur_Zero = 0.1f;
    private static volatile ConcurrentHashMap<String, Float> tokens;

    static {
        if (OMaterialHelper.b() < 4) goto L5;
        float r0 = Blur_UltraThin_V2;
    L6:
        Blur_UltraThin = r0;
        return;
    L5:
        r0 = 4.0f;
        goto L6
    }

    private BlurTokenCore() {
    }

    private static ConcurrentHashMap<String, Float> getTokens(Object r2) {
        ConcurrentHashMap<String, Float> r0 = tokens;
        if (r0 == null) goto L5;
    L14:
        return r0;
    L5:
        monitor-enter(BlurTokenCore.class);
        r0 = tokens;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        ConcurrentHashMap<String, Float> r3 = o.a(r2, Float.class);     // Catch: Throwable -> L11
        tokens = r3;     // Catch: Throwable -> L11
        r0 = r3;
    L9:
        monitor-exit(BlurTokenCore.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static Float parse(Object r1, String r2) {
        return (Float) ZeusTransformUtils.preCheckCast(o.a(r2, getTokens(r1)), Float.class, "com.obric.memorydata.plugin");
    }

    public static void register(Object r1, Object r2, boolean r3) {
        o.a(getTokens(r1), r2, Float.class, r3);
    }

    public static void registerTokens(Object r2, Map<String, Float> r3, boolean r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        o.a(getTokens(r2), r5, r4);
    }
}
