package com.bytedance.android.ec.core.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f2 {
    public static Function1<? super String, Unit> a;
    public static final a b = null;

    public static final class a implements ti.j {
        public a() {
        }

        public final void a(JSONObject r10) {
            Intrinsics.checkNotNullParameter(r10, "params");
            Function1<? super String, Unit> r0 = f2.a;
            if (r0 == null) goto L6;
            Unit r11 = (Unit) r0.invoke(r10.optString(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID));
            return;
        }
    }

    static {
        b = new a();
    }
}
