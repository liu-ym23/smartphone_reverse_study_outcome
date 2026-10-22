package com.bytedance.android.live.revlink.link.domain.streammix;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public static final void a(d r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$writeToAnchorSeiInfo");
        Intrinsics.checkNotNullParameter(r4, "anchorSeiInfo");
        r4.put("mix_owner_index", r3.b);
        JSONObject r0 = new JSONObject();
        r0.put("x", Float.valueOf(r3.c.left));
        r0.put("y", Float.valueOf(r3.c.top));
        r0.put("w", Float.valueOf(r3.c.width()));
        r0.put("h", Float.valueOf(r3.c.height()));
        Unit r5 = Unit.INSTANCE;
        r4.put("content", r0);
    }
}
