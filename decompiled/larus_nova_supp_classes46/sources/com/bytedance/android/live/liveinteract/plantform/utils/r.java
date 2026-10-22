package com.bytedance.android.live.liveinteract.plantform.utils;

import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r2) {
        HashMap r0 = new HashMap();
        r0.put("event_name", r2);
        r0.put("opened", (Boolean) ((ge1.a) tc0.c.h()).b);
        r0.put("link_mic_id", tc0.c.h().f);
        r0.put("state", (Integer) ((ge1.a) hd0.c.f()).b);
        r0.put("mode", Integer.valueOf(hd0.c.f().g));
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_interact", r0);
    }

    @JvmStatic
    public static final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        HashMap r0 = new HashMap();
        r0.put("event_name", r2);
        r0.put("extra", r3);
        r0.put("opened", (Boolean) ((ge1.a) tc0.c.h()).b);
        r0.put("link_mic_id", tc0.c.h().f);
        r0.put("state", (Integer) ((ge1.a) hd0.c.f()).b);
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_interact", r0);
    }
}
