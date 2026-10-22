package com.bytedance.android.live.browser.schema.core.strategy;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public final Map<Integer, c.b> a;

    public static final class a implements c.b {
        public a() {
        }

        @Override // com.bytedance.android.live.browser.schema.core.strategy.c.b
        public final c a(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "json");
            return new g();
        }
    }

    public d() {
        this.a = new HashMap();
        a(0, new a());
    }

    public final void a(int r2, c.b r3) {
        Intrinsics.checkNotNullParameter(r3, "factory");
        Map<Integer, c.b> r0 = this.a;
        HashMap r1 = (HashMap) r0;
        r1.put(Integer.valueOf(r2), r3);
    }
}
