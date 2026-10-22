package com.bytedance.android.ec.core.utils;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k {
    public static final a a = null;

    public static final class a implements ti.j {
        public a() {
        }

        public final void a(JSONObject r10) {
            Intrinsics.checkNotNullParameter(r10, "params");
            CarModelSelectInfo r0 = new CarModelSelectInfo();
            r0.setId(r10.optString("id", ""));
            r0.setModel(r10.optString("model", ""));
            a r11 = k.a;
            s0.a(new f1(r0));
        }
    }

    static {
        a = new a();
    }
}
