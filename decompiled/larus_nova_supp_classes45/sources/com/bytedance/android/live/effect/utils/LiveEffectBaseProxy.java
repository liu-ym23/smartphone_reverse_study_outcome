package com.bytedance.android.live.effect.utils;

import com.bytedance.android.live.effect.base.RenderTriggerType;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveEffectBaseProxy implements com.bytedance.android.live.effect.api.f {
    public static final Lazy a = null;
    public static final a b = null;

    public static final class a {
        public a() {
        }
    }

    public LiveEffectBaseProxy() {
    }

    static {
        b = new a();
        a = LazyKt.lazy(LiveEffectBaseProxy$Companion$instance$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.effect.api.f
    public final void a(com.bytedance.android.live.effect.base.e r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "traceInfo");
        Intrinsics.checkNotNullParameter(r12, "eventPage");
        PthreadHandlerThreadV2 r0 = LiveEffectMonitor.a;
        LiveEffectMonitor.m("replace_sticker", "", 10000, "", "", "", "download_fail", "", r11.d);
        Pair[] r1 = new Pair[4];
        r1[0] = TuplesKt.to("status_code", String.valueOf(10000));
        Sticker r2 = r11.b;
        Integer r3 = null;
        if (r2 == null) goto L5;
        Long r4 = Long.valueOf(r2.getId());
    L6:
        r1[1] = TuplesKt.to("sticker_id", String.valueOf(r4));
        r1[2] = TuplesKt.to("panel", r11.c);
        RenderTriggerType r13 = r11.d;
        if (r13 == null) goto L9;
        r3 = Integer.valueOf(r13.getCode());
    L9:
        r1[3] = TuplesKt.to("trigger_type", String.valueOf(r3));
        m.a(MapsKt.hashMapOf(r1), r12);
        return;
    L5:
        r4 = null;
        goto L6
    }
}
