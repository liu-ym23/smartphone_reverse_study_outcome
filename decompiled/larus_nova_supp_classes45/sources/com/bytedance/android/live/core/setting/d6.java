package com.bytedance.android.live.core.setting;

import android.app.Application;
import android.content.Context;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d6 {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final Application b() {
        Context r0 = wa1.b.a.getContext();
        if ((r0 instanceof Application) == true) goto L6;
        r0 = null;
    L6:
        return (Application) r0;
    }

    static {
    }

    @JvmStatic
    public static final void a(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "e");
        wa1.a r1 = wa1.d.a;
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        wa1.a r0 = wa1.d.a;
        if (r0 == null) goto L6;
        r0.e(r2, r3);
        return;
    }

    @JvmStatic
    public static final void c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        wa1.a r1 = wa1.d.a;
        Intrinsics.checkNotNullParameter(r2, "tag");
        wa1.a r0 = wa1.d.a;
        if (r0 == null) goto L6;
        r0.i(r2, r3);
        return;
    }

    @JvmStatic
    public static final void d(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r2, "serviceName");
        wa1.a r1 = wa1.d.a;
        Intrinsics.checkNotNullParameter(r2, "serviceName");
        wa1.a r0 = wa1.d.a;
        if (r0 == null) goto L6;
        r0.monitorEvent(r2, r3, r4, r5);
        return;
    }
}
