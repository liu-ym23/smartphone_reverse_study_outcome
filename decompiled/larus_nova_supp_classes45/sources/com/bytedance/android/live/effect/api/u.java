package com.bytedance.android.live.effect.api;

import com.bytedance.android.live.effect.composer.LiveComposerManagerB;
import java.util.EnumMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u {
    public static final Map<LiveEffectContextFactoryDelegate$Type, e> a = null;
    public static final Map<LiveEffectContextFactoryDelegate$Type, ILiveEffectComposerManager> b = null;
    public static final Map<LiveEffectContextFactoryDelegate$Type, g> c = null;

    static {
        a = new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        b = new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        c = new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
    }

    public static e a(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        EnumMap r0 = (EnumMap) a;
        if (r0.containsKey(r2) == true) goto L5;
    L6:
        r0.put(r2, new LiveEffectBaseContext(r2));
    L7:
        Object r3 = r0.get(r2);
        Intrinsics.checkNotNull(r3);
        return (e) r3;
    L5:
        if (r0.get(r2) != null) goto L7;
        goto L6
    }

    public static g b(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        EnumMap r0 = (EnumMap) c;
        if (r0.containsKey(r2) == true) goto L5;
    L6:
        r0.put(r2, new LiveEffectBaseService(r2));
    L7:
        Object r3 = r0.get(r2);
        Intrinsics.checkNotNull(r3);
        return (g) r3;
    L5:
        if (r0.get(r2) != null) goto L7;
        goto L6
    }

    public static ILiveEffectComposerManager c(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        EnumMap r0 = (EnumMap) b;
        if (r0.containsKey(r2) == true) goto L5;
    L6:
        r0.put(r2, new LiveComposerManagerB(r2));
    L7:
        Object r3 = r0.get(r2);
        Intrinsics.checkNotNull(r3);
        return (ILiveEffectComposerManager) r3;
    L5:
        if (r0.get(r2) != null) goto L7;
        goto L6
    }
}
