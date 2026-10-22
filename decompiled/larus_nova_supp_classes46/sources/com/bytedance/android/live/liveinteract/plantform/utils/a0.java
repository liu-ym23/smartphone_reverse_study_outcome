package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.livesdk.ktvapi.IKtvService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0 implements com.bytedance.android.livesdk.log.filter.v {
    public static final a0 a = null;

    public a0() {
    }

    public final void Rd() {
    }

    public final void onRemove() {
    }

    static {
        a = new a0();
    }

    public final void L9(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "params");
        fd2.f r5 = jc1.k.n(IKtvService.class).getChorusService();
        if (r5 == null) goto L5;
        com.bytedance.android.live.liveinteract.model.a r0 = r5.getChorusInfo();
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.Pp() != true) goto L13;
        if (r0 == null) goto L14;
        r4.put("chorus_id", String.valueOf(r0.getChorusId()));
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r0 = null;
        goto L6
    }
}
