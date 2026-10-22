package com.bytedance.android.anniex.monitor;

import com.bytedance.android.monitorV2.g;
import jz2.d;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    static {
    }

    public static void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "errorMsg");
        d.a r0 = new d.a("bdx_anniex_card_props_error");
        r0.b = "bullet_custom_bid";
        r0.b(0);
        JSONObject r1 = new JSONObject();
        r1.put("scene", "anniex_card");
        r1.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG, r10);
        r0.d = r1;
        d r11 = r0.a();
        g.e().getClass();
        g.c(r11);
    }
}
