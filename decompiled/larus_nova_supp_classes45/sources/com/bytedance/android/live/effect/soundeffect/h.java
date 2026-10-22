package com.bytedance.android.live.effect.soundeffect;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public static final Map<String, Long> a = null;
    public static final Map<String, Long> b = null;

    public h() {
    }

    static {
        a = new LinkedHashMap();
        b = new LinkedHashMap();
    }

    @JvmStatic
    public static final void a(Sticker r8, LiveEffectContextFactoryDelegate$Type r9) {
        Intrinsics.checkNotNullParameter(r8, "sticker");
        Intrinsics.checkNotNullParameter(r9, "type");
        long r0 = System.currentTimeMillis();
        Map<String, Long> r2 = a;
        Long r3 = (Long) ((LinkedHashMap) r2).get(r8.getEffectId());
        if (r3 == null) goto L5;
        long r6 = r3.longValue();
    L6:
        b(r8, "live_voice_resource_download", r9, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("duration_ms", String.valueOf((r0 - r6) * 1.0f))}));
        r2.put(r8.getEffectId(), 0L);
        return;
    L5:
        r6 = 0;
        goto L6
    }

    public static /* synthetic */ void c(Sticker r1, String r2, LiveEffectContextFactoryDelegate$Type r3) {
        b(r1, r2, r3, new HashMap());
    }

    public static void b(Sticker r2, String r3, LiveEffectContextFactoryDelegate$Type r4, HashMap r5) {
        r5.put("effect_id", r2.getEffectId());
        String r6 = r2.getName();
        if (r6 == null) goto L5;
        r5.put("effect_name", r6);
    L5:
        List<String> r7 = LiveEffectContext.h;
        LiveEffectContext.a.a(r4).e().sendLog(r3, r5);
    }
}
