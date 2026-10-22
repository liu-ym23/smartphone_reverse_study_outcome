package com.bytedance.android.live.revlink.impl.audience;

import com.bytedance.android.live.revlink.impl.multianchor.utils.h0;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public final w41.c a;
    public final w41.d b;
    public final h0 c;
    public final long d;
    public long e;
    public int f;
    public final com.bytedance.android.live.revlink.impl.global.c g;

    public static final class a {
    }

    static {
    }

    public h(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b r4) {
        this.g = r4;
        com.bytedance.android.live.revlink.impl.settings.live.c r5 = com.bytedance.android.live.revlink.impl.settings.live.c.D;
        r5.getClass();
        ReadOnlyProperty r0 = com.bytedance.android.live.revlink.impl.settings.live.c.x;
        KProperty[] r1 = com.bytedance.android.live.revlink.impl.settings.live.c.a;
        this.a = (w41.c) r0.getValue(r5, r1[22]);
        this.b = (w41.d) com.bytedance.android.live.revlink.impl.settings.live.c.z.getValue(r5, r1[24]);
        this.c = new h0();
        i97.a r6 = i97.a.a;
        this.d = System.currentTimeMillis();
    }
}
